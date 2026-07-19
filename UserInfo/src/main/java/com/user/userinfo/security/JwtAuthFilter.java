package com.user.userinfo.security;

import io.jsonwebtoken.Jwt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtAuthFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        String authHeader = request.getHeader("Authorization");

//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            String token = authorizationHeader.substring(7);
//            try {
//                jwtUtil.validateToken(token);
//                // If the token is valid, you can set the authentication in the security context here
//            } catch (Exception e) {
//                res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid or expired token");
//                return;
//            }
//        } else {
//            res.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authorization header missing or invalid");
//            return;
//        }

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                if (!jwtUtil.isTokenExpired(token)) {
                    String email = jwtUtil.extractEmail(token);
                    var authToken = new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            } catch (Exception e) {
                // bad/expired token -> just stays unauthenticated, request gets rejected downstream
            }
        }

        chain.doFilter(request, response);

    }

}
