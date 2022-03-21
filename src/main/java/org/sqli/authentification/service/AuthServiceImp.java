package org.sqli.authentification.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.UserDAO;
import org.sqli.authentification.dto.UserLoggedInDTO;
import org.sqli.authentification.dto.UserLoginFormDTO;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.repository.UserRepository;

@Service
@Slf4j
public class AuthServiceImp implements AuthService {

    private final UserDAO userDao;
    private final UserRepository userRepository;

    public AuthServiceImp(UserDAO userDao, UserRepository userRepository) {
        this.userDao = userDao;
        this.userRepository = userRepository;
    }

    @Override
    public UserLoggedInDTO login(UserLoginFormDTO userLoginFormDto) {
        log.info("login attempt with data {}", userLoginFormDto);
        return userDao
                .findByLoginAndPassword(userLoginFormDto.getLogin(), userLoginFormDto.getPassword())
                .map(user -> mapToLoggedInDTO(user, new UserLoggedInDTO()))
                .get();
    }


    /**
     * @param user
     * @param userLoggedInDTO
     * @return an object mapped from the input user into UserLoggedInDTO
     */
    private UserLoggedInDTO mapToLoggedInDTO(final User user, final UserLoggedInDTO userLoggedInDTO) {
        userLoggedInDTO.setId(user.getId());
        userLoggedInDTO.setLogin(user.getLogin());
        userLoggedInDTO.setGroup(user.getGroup().getName());
        return userLoggedInDTO;
    }

}