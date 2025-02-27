package com.medfusion.medfusion_auth_server.controller;

import com.medfusion.medfusion_auth_server.model.UserCredential;
import com.medfusion.medfusion_auth_server.repository.UserRepository;
import com.medfusion.medfusion_auth_server.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody UserCredential user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singleton("ROLE_USER"));
        userRepository.save(user);
        return Map.of("message", "User registered successfully");
    }

    @GetMapping("/token")
    public ResponseEntity<?> getToken(@RequestBody UserCredential user) {
        try {
            String token = authService.generateToken(user);
            return ResponseEntity.ok(Map.of("token", token));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/validateToken")
    public String getToken(@RequestParam String token) {
        authService.validateToken(token);
        return "Token is Valid";
    }
}
