package com.service.restaurantService.infrastructure.adapter.in.rest;

import com.service.restaurantService.infrastructure.config.JwtTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/test")
public class TestTokenController {
    private final JwtTokenProvider jwt;

    public TestTokenController(JwtTokenProvider jwt) {
        this.jwt = jwt;
    }

    // Only for local testing: quickly mint a token
    @GetMapping("/token")
    public ResponseEntity<Map<String, Object>> token() {
        String t = jwt.createToken("dev-user@example.com", List.of("ROLE_USER"));
        return ResponseEntity.ok(Map.of("token", t));
    }
}
