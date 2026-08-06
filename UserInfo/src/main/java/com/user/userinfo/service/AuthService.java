//package com.user.userinfo.service;
//
//import com.user.userinfo.dto.LoginRequestDTO;
//import com.user.userinfo.dto.LoginResponseDTO;
//import com.user.userinfo.entity.Users;
//import com.user.userinfo.repository.UserRepository;
//import com.user.userinfo.security.JwtUtil;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class AuthService {
//
//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//    private final JwtUtil jwtUtil;
//
//    public AuthService(UserRepository userRepository,  PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
//        this.userRepository=userRepository;
//        this.passwordEncoder=passwordEncoder;
//        this.jwtUtil=jwtUtil;
//
//    }
//
//    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
//        Optional<Users> userOptional = userRepository.findByEmail(loginRequestDTO.getEmail());
//        Users user = userRepository.findByEmail(loginRequestDTO.getEmail())
//                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
//
//        if (!passwordEncoder.matches(loginRequestDTO.getPassword(), user.getPassword())) {
//            throw new BadCredentialsException("Invalid email or password");
//        }
//        String token = jwtUtil.generateToken(user);
//
//        LoginResponseDTO response = new LoginResponseDTO();
//
//        response.setToken(token);
//        response.setId(user.getId());
//        response.setName(user.getName());
//        response.setEmail(user.getEmail());
//
//        return response;
//
//    }
//}
