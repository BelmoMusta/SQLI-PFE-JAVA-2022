package org.sqli.authentification.service;

import org.sqli.authentification.dto.UserDto;
import org.sqli.authentification.entitie.User;

public interface UserService {

    public UserDto checkAuthentification(User u) throws Exception;

    public UserDto checkAuthentificationAndDisable(User u) throws Exception;

}
