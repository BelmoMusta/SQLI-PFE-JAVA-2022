package org.sqli.authentification.service;

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

    /**
     *
     * @param login
     * @param password
     * @return  User or null
     */
    @Override
    public User authenticate(String login, String password) {
        User user = isUserExist(login);
        if(user != null)
        {
           return isPasswordCorrect(user.getPassword(),password) ? user : null;
        }
        else{
            return null;
        }
    }


    /**
     *
     * @param optUser
     * @return obj User or null
     */
    private User isUserExist(String login) throws UserException{
        Optional<User> optUser =  userDao.findByLogin(login);
        return optUser.orElseThrow(() -> new UserException("Authentication error"));
    }



    /**
     *
     * @param UserPassword
     * @param requestPassword
     * @return
     */
    private boolean isPasswordCorrect(String UserPassword,String requestPassword)
    {
        return UserPassword.equals(requestPassword);
    }





}
