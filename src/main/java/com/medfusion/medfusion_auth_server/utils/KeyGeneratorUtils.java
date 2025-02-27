package com.medfusion.medfusion_auth_server.utils;

import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.gen.RSAKeyGenerator;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class KeyGeneratorUtils {

    public static RSAKey generateRSAKey() {
        try {
            return new RSAKeyGenerator(2048)
                    .keyID("auth-server-key") // Unique Key ID
                    .generate();
        } catch (Exception e) {
            throw new RuntimeException("Error generating RSA key", e);
        }
    }
}
