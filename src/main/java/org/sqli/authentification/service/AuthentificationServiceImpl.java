package org.sqli.authentification.service;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.GroupDao;
import org.sqli.authentification.dao.UserDao;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.exception.UserException;

import java.util.Optional;

@Service
public class AuthentificationServiceImpl implements AuthentificationService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private GroupDao groupDao;


    public User authenticate(String login, String password) throws RuntimeException{

        User user = isUserExist(login);

        if(user != null)
        {
            if(!isUserAccountActivated(user))
            {
                throw  new UserException("User Account is Disabled");
            }
            if(!isPasswordCorrect(user.getPassword(),password))
            {
                throw new UserException("Authentication error");
            }
        }
        else{
           throw new UserException("Authentication error");
        }

        return user;
    }



    private User isUserExist(String login) throws UserException{
        Optional<User> optUser =  userDao.findByLogin(login);
        return optUser.orElseThrow(() -> new UserException("Authentication error"));
    }



    private boolean isPasswordCorrect(String UserPassword,String requestPassword)
    {
        return UserPassword.equals(requestPassword);
    }


    private boolean isUserAccountActivated(User user)
    {
        return user.isEnabled();
    }





}
