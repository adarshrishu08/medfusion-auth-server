package com.medfusion.medfusion_auth_server.repository;

import com.medfusion.medfusion_auth_server.model.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserCredential, Long> {
    Optional<UserCredential> findByUsername(String username);
    Optional<UserCredential> findByUsernameAndPassword(String username, String password);
}
