package com.user.userinfo.client;


import com.user.userinfo.dto.AccountRequest;
import com.user.userinfo.dto.AccountResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "UserPayment", url = "http://localhost:4050")
public interface PaymentClient {

    @PostMapping("/accounts")
    ResponseEntity<String> createAccount(@RequestBody AccountRequest request);

}
