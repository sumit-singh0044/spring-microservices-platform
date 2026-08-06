package com.user.authservice.controller;

import com.user.authservice.dto.LoginRequestDTO;
import com.user.authservice.dto.LoginResponseDTO;
import com.user.authservice.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {

        LoginResponseDTO response = authService.login(loginRequest);

        return ResponseEntity.ok(response);
    }

}
