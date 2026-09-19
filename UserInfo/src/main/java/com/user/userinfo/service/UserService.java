package com.user.userinfo.service;

import com.user.userinfo.client.PaymentClient;
import com.user.userinfo.dto.AccountRequest;
import com.user.userinfo.dto.UserCreatedEvent;
import com.user.userinfo.entity.Users;
import com.user.userinfo.exception.PaymentServiceException;
import com.user.userinfo.kafka.UserProducer;
import com.user.userinfo.repository.AddressRepository;
import com.user.userinfo.repository.UserRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserProducer userProducer;

    @Autowired
    private PaymentClient paymentClient;

    public UserService(UserRepository userRepository,
                       AddressRepository addressRepository,
                       PasswordEncoder passwordEncoder,
                       UserProducer userProducer) {
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
        this.userProducer = userProducer;
    }

    public List<Users> getUsers() {
        return userRepository.findAll();
    }

    public Users saveUser(Users user) {
        Optional<Users> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            return null;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Users savedUsers = userRepository.save(user);

        AccountRequest request = new AccountRequest();
        request.setId(savedUsers.getId());
        request.setEmail(savedUsers.getEmail());

        try {
            paymentClient.createAccount(request);
        } catch (FeignException ex) {
            userRepository.delete(savedUsers); // compensating rollback
            throw new PaymentServiceException("Failed to create bank account");
        }

        UserCreatedEvent event = new UserCreatedEvent(
                savedUsers.getId(), savedUsers.getName(), savedUsers.getEmail());
//        userProducer.sendMessage(event);

        return savedUsers;
    }

    @Cacheable(value = "users", key = "#id")
    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Deletes the user's addresses (UserInfo DB), their payment account
     * (UserPayment, via Feign), then the user row itself.
     * Returns false if the user doesn't exist.
     */
    @Transactional
    @CacheEvict(value = "users", key = "#id")
    public boolean deleteById(Long id) {
        Optional<Users> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return false;
        }

        // 1. Explicitly remove addresses (belt-and-braces alongside the
        //    CascadeType.ALL on Users.addresses).
        addressRepository.deleteAll(addressRepository.findByUserId(id));

        // 2. Remove the payment account in UserPayment via Feign.
        try {
            paymentClient.deleteAccount(id);
        } catch (FeignException.NotFound notFoundEx) {
            // account never existed / already deleted — fine, continue
        } catch (FeignException ex) {
            throw new PaymentServiceException("Failed to delete linked bank account");
        }

        // 3. Remove the user itself.
        userRepository.deleteById(id);
        return true;
    }

    public List<Users> getUsersAddress() {
        return userRepository.findAllAddress();
    }
}