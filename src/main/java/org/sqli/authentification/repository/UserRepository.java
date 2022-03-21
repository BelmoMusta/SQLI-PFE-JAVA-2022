package org.sqli.authentification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sqli.authentification.entitie.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLoginAndPassword(String login, String password);
}