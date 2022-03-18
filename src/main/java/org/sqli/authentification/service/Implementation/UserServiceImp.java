package org.sqli.authentification.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sqli.authentification.dao.UserDao;
import org.sqli.authentification.dto.UserDto;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.mapper.UserMapper;
import org.sqli.authentification.service.UserService;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    public UserDao userDao;

    @Override
    public UserDto checkAuthentification(User u) throws Exception {
        UserDto userDto = null;
        List<User> users = userDao.findUserByLoginAndPassword(u.getLogin(),u.getPassword());

        if (users.size() == 1){
            userDto = UserMapper.map(users.get(0));
        }else{
            throw new Exception("Authentication error");
        }
        return userDto;
    }

    @Override
    public UserDto checkAuthentificationAndDisable(User u) throws Exception {
        UserDto userDto = null;
        List<User> users = userDao.findUserByLoginAndPassword(u.getLogin(),u.getPassword());
        
        if (users.size() == 1){
            User user = users.get(0);
            if (!user.isEnabled()){
                throw new Exception("User disabled");
            }
            userDto = UserMapper.map(user);

        }else{
            throw new Exception("Authentication error");
        }
        return null;
    }
}
