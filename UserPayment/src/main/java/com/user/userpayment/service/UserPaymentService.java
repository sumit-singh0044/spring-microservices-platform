package com.user.userpayment.service;

import com.user.userpayment.repository.UserPaymentRepository;
import com.user.userpayment.dto.AccountRequest;
import com.user.userpayment.entity.Account;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPaymentService {

    private final UserPaymentRepository userPaymentRepository;
    public UserPaymentService(UserPaymentRepository userPaymentRepository) {
        this.userPaymentRepository = userPaymentRepository;
    }

    public Account saveAccountDetails(AccountRequest request) {

        // Implement the logic to save account details here
        // For example, you can call a repository to save the account information in the database

        // For now, let's just return a success response

        Account account = new Account();
        account.setEmail(request.getEmail());
        account.setUserID(request.getId());
        account.setAccountNumber("ACC"+request.getId()+request.getId()*123456);

        Account acc =  userPaymentRepository.save(account);
        return acc;
    }

    public List<Account> getAllAccount() {
        return userPaymentRepository.findAll();
    }

    @Transactional
    public void deleteAccount(Long userId) {
        userPaymentRepository.deleteByUserID(userId);
    }
}
