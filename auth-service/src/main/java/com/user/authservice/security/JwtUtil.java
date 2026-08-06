package com.user.authservice.security;

import com.user.authservice.entity.Users;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration-ms}")
    private long expirationDate;

    private SecretKey getSignedSecretKey() {
        return Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateToken(Users user) {
        Date now = new Date();
        Date expiry = new Date(now.getTime() + expirationDate);

        return Jwts.builder()
                .subject(user.getEmail())
                .claim("id", user.getId())
                .claim("name", user.getName())
                .issuedAt(now)
                .expiration(expiry)
                .signWith(getSignedSecretKey())
                .compact();
    }
}
