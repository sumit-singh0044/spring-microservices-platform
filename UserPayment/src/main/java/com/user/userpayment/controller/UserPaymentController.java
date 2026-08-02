package com.user.userpayment.controller;

import com.user.userpayment.dto.AccountRequest;
import com.user.userpayment.dto.AccountResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/accounts")
public class UserPaymentController {

    private static final Logger log = LoggerFactory.getLogger(UserPaymentController.class);

    @PostMapping
    public ResponseEntity<String>  createAccount(@RequestBody AccountRequest request)
    {
        String email = request.getEmail();
        long id  = request.getId();
        // Implement the logic to create an account based on the request
        // For example, you can call a service method to handle the account creation
        // and return an appropriate response.

        // Assuming the account creation is successful, return a success response
        System.out.println("Creating account for user with email: " + email + " and id: " + id);
        log.info("Creating account for user with email: {} and id: {}", email, id);

        return ResponseEntity.ok("Account created successfully for user with email: " + email + " and id: " + id);
    }
}
