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

    public static final int NUMBER_LOGIN_ATTEMPTS = 3;

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
                incrementloginAttempsFailure(user);
                throw new UserException("Authentication error");
            }
            if(loginAttemps(user,NUMBER_LOGIN_ATTEMPTS)){
                throw new UserException("You have reached "+user.getLoginAttempts()+ "failed authentication attemps,your account will be disabled");
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


    private boolean loginAttemps(User user,int attempsNumber)
    {
        return user.getLoginAttempts() >= attempsNumber;
    }

    private void  incrementloginAttempsFailure(User user){

        user.setLoginAttempts(user.getLoginAttempts()+1);
        userDao.save(user);


    }





}
