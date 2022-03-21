package org.sqli.authentification.dao;

import org.springframework.stereotype.Repository;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.repository.UserRepository;

import java.util.Optional;

@Repository
public class UserDAOImp implements UserDAO {

    private final UserRepository userRepository;

    public UserDAOImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }
}