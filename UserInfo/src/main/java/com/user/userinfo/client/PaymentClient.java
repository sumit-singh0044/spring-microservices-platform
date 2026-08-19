package com.user.userinfo.client;

import com.user.userinfo.dto.AccountRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "UserPayment", url = "http://localhost:4002")
public interface PaymentClient {

    @PostMapping("/accounts")
    void createAccount(@RequestBody AccountRequest request);

    @DeleteMapping("/accounts/{id}")
    void deleteAccount(@PathVariable("id") long id);
}