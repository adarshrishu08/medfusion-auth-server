package com.medfusion.medfusion_auth_server.utils;

import java.security.SecureRandom;
import java.util.Base64;

public class GenerateSecretUtil {
    public static void main(String[] args) {
        byte[] key = new byte[32]; // 32 bytes = 256 bits
        new SecureRandom().nextBytes(key);
        String secret = Base64.getEncoder().encodeToString(key);

        System.out.println("Generated Secret Key: " + secret);
    }
}
