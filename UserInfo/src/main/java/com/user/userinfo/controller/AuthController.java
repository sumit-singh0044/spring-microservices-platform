//package com.user.userinfo.controller;
//
//import com.user.userinfo.dto.LoginRequestDTO;
//import com.user.userinfo.dto.LoginResponseDTO;
//import com.user.userinfo.entity.Users;
//import com.user.userinfo.service.AuthService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/login")
//public class AuthController {
//
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping
//    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequest) {
//
//        LoginResponseDTO response= authService.login(loginRequest);
//
//        return ResponseEntity.ok(response);
//    }
//
//}