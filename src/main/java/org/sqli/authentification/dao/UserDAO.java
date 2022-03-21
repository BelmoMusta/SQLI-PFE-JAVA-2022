package org.sqli.authentification.dao;

import org.sqli.authentification.entitie.User;

import java.util.Optional;

public interface UserDAO {
    Optional<User> findByLoginAndPassword(final String login, final String password);
}
