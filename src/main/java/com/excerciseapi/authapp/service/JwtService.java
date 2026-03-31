package com.excerciseapi.authapp.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.excerciseapi.authapp.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
    private String email;
    private String userId;
    private String tokenBuilder;

    public String generateToken(User user) {
        email = user.getEmail();
        userId = user.getUserId();

        tokenBuilder = Jwts.builder().setSubject(email).claim("userId", userId)
                .claim("email", email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 36000000))
                // .signWith(Keys.hmacShaKeyFor("glsc-pruebaApiJava_ISC948y3948ty398439".getBytes())).compact();
                .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS256)).compact();

        System.out.println(tokenBuilder);
        return tokenBuilder;
    }

    public String validateToken(String Token) {

        return Token;
    }

}
