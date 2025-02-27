package com.medfusion.medfusion_auth_server.service;

import com.medfusion.medfusion_auth_server.model.UserCredential;
import com.medfusion.medfusion_auth_server.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String generateToken(UserCredential user) {
        UserCredential storedUser = userRepository.findByUsername(user.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(user.getPassword(), storedUser.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtService.generateToken(user.getUsername());
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
        }
}
