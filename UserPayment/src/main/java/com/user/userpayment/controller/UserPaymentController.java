package com.user.userpayment.controller;

import com.user.userpayment.dto.AccountRequest;
import com.user.userpayment.dto.AccountResponse;
import com.user.userpayment.entity.Account;
import com.user.userpayment.service.UserPaymentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/accounts")
public class UserPaymentController {

    private static final Logger log = LoggerFactory.getLogger(UserPaymentController.class);

    private UserPaymentService userPaymentService;

    public UserPaymentController(UserPaymentService userPaymentService) {
        this.userPaymentService = userPaymentService;
    }

    @PostMapping
    public ResponseEntity<Void>  createAccount(@RequestBody AccountRequest request)
    {
        String email = request.getEmail();
        long id  = request.getId();

//        userPaymentService.saveAccountDetails(request);
        log.info("Creating account for user with email: {} and id: {}", email, id);

        Account account = userPaymentService.saveAccountDetails(request);
//        return ResponseEntity.ok("Account created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccount(){

        return ResponseEntity.ok(userPaymentService.getAllAccount());
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long userId) {
        userPaymentService.deleteAccount(userId);
        return ResponseEntity.noContent().build();
    }

}
