package org.sqli.authentification.service;

import org.sqli.authentification.dto.UserLoggedInDTO;
import org.sqli.authentification.dto.UserLoginFormDTO;

public interface AuthService {
    UserLoggedInDTO login(final UserLoginFormDTO userDto);
}