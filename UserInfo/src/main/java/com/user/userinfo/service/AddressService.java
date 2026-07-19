package com.user.userinfo.service;

import com.user.userinfo.entity.Address;
import com.user.userinfo.entity.Users;
import com.user.userinfo.exception.ResourceNotFoundException;
import com.user.userinfo.repository.AddressRepository;
import com.user.userinfo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    public AddressService(AddressRepository addressRepository,
                          UserRepository userRepository) {
        this.addressRepository = addressRepository;
        this.userRepository = userRepository;
    }

    public List<Address> getAllAddresses() {
        return addressRepository.findAll();
    }

    public Address getAddressById(Long addressId) {
        return addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found"));
    }

    public Address saveAddress(Address address) {

        Long userId = address.getUser().getId();

        Users user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        address.setUser(user);

        return addressRepository.save(address);
    }

    public List<Address> getAddressesByUserId(Long userId) {

        return addressRepository.findByUserId(userId);
    }
}
