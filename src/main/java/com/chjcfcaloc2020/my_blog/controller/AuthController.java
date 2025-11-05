package com.chjcfcaloc2020.my_blog.controller;

import com.chjcfcaloc2020.my_blog.dto.request.LoginRequest;
import com.chjcfcaloc2020.my_blog.dto.response.TokenResponse;
import com.chjcfcaloc2020.my_blog.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        UserDetails userDetails = authenticationService.authenticate(
                request.getUsername(),
                request.getPassword()
        );
        String accessToken = authenticationService.generateToken(userDetails);
        TokenResponse tokenResponse = TokenResponse.builder()
                .token(accessToken)
                .expiresIn(86400)
                .build();
        return ResponseEntity.ok(tokenResponse);
    }
}
