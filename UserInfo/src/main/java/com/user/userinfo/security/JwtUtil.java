package com.user.userinfo.security;


import com.user.userinfo.entity.Users;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;

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
               .compact();   }

    public String extractEmail(String token) {
        return extractAllClaims(token).getSubject();
    }

    public boolean isTokenValid(String token, String email) {
        return extractEmail(token).equals(email) && !isTokenExpired(token);
    }

    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getSignedSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
