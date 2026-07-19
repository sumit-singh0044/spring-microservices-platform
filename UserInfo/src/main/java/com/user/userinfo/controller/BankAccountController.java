package com.user.userinfo.controller;

import com.user.userinfo.dto.CreateAccountRequest;
import com.user.userinfo.dto.DebitRequest;
import com.user.userinfo.dto.TransferRequest;
import com.user.userinfo.entity.BankAccount;
import com.user.userinfo.service.BankAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bank-accounts")
public class BankAccountController {

    private final BankAccountService service;

    public  BankAccountController(BankAccountService bankAccountService) {
        this.service = bankAccountService;
    }

    @PostMapping
    public ResponseEntity<BankAccount> createAccount(@RequestBody CreateAccountRequest request) {
        BankAccount account = service.createAccount(request.name(), request.amount());
        return ResponseEntity.status(HttpStatus.CREATED).body(account);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankAccount> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAccount(id));
    }

    // Just debit — no destination account
    @PostMapping("/{id}/debit")
    public ResponseEntity<BankAccount> debit(@PathVariable Long id, @RequestBody DebitRequest request) {
        return ResponseEntity.ok(service.debit(id, request.amount()));
    }

    // Debit from one account and credit another
    @PostMapping("/transfer")
    public ResponseEntity<Void> transfer(@RequestBody TransferRequest request) {
        service.transfer(request.fromAccountId(), request.toAccountId(), request.amount());
        return ResponseEntity.ok().build();
    }
}
