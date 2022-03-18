package org.sqli.authentification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sqli.authentification.entitie.User;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    public List<User> findByLoginAndPassword(String login, String password);
    public List<User> findByLogin(String login);
}
