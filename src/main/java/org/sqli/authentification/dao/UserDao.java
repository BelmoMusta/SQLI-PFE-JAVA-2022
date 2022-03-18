package org.sqli.authentification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.sqli.authentification.entitie.User;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {

    public Optional<User> findByLogin(String login);
}
