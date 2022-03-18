package org.sqli.authentification.service;

import org.sqli.authentification.entitie.User;

public interface AuthentificationService {

    public User authenticate(String login, String password);

}
