package com.user.userinfo.service;

import com.user.userinfo.entity.Users;
import com.user.userinfo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;


//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testGetUserById() {

        Users user = userRepository.findById(5L)
                .orElseThrow(() -> new RuntimeException("User not found"));

        System.out.println("\n \n \n \n \n \n");
        System.out.println("user: " + user);
        System.out.println("\n \n \n \n \n \n");
    }

    @Test
    public void testUserByNamePrefix() {
        String prefix = "final";
        var users = userRepository.findByNameStartingWith(prefix);
        System.out.println("\n \n \n \n \n \n");
        System.out.println("users: " + users);
        System.out.println("\n \n \n \n \n \n");
    }
}