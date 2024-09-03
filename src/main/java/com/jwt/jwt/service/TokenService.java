package com.jwt.jwt.service;

import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jwt.jwt.entities.User;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("auth-api")// identifica a aplicação
                    .withSubject(user.getLogin())// usuario que recebe token
                    .withExpiresAt(genExpirationDate())// tempo de expiração
                    .sign(algorithm);// faz assinatura
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Error while generating token", e);
        }
    }

    public String validate(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject(); // descriptografa e pega o subject(login)
        } catch (JWTVerificationException e) {
            return "";
        }
    }

    private Instant genExpirationDate() {
        ZonedDateTime zone = ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")).plusHours(2);
        return zone.toInstant();
    }
}
