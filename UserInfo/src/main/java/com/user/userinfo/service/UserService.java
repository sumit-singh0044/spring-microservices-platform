package com.user.userinfo.service;

import com.user.userinfo.entity.Users;
import com.user.userinfo.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    public UserRepository userRepository;
    public final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository ,  PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
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
        Users savedUsers= userRepository.save(user);
        return savedUsers;
    }

    public Users getUserById(Long id) {
        Optional<Users> optionalUser = userRepository.findById(id);
        System.out.println(optionalUser.get().getAddresses().size());
        return optionalUser.orElse(null);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }


//    <!--        tejas loan - 9582668554 - 366, 16B vasundra , gajiabad UP , 20012 -->
}


