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

   /* @Override
    public UserDto checkAuthentification(User u) throws Exception {
        UserDto userDto = null;
        List<User> users = userDao.findUserByLoginAndPassword(u.getLogin(),u.getPassword());

        User user = exist(users);

        userDto = UserMapper.map(user);
        return userDto;
    }*/

    @Override
    public UserDto checkAuthentification(User u) throws Exception {
        UserDto userDto = null;
        List<User> users = userDao.findUserByLoginAndPassword(u.getLogin(),u.getPassword());

        User user = exist(users);
        enabled(user);

        userDto = UserMapper.map(user);
        return userDto;
    }


    private User exist(List<User> users) throws Exception {
        if (users.size() == 1){
            return users.get(0);
        }else{
            throw new Exception("Authentication error");
        }
    }

    private User enabled(User user) throws Exception{
        if (user.isEnabled()){
            return user;
        }else{
            throw new Exception("User disabled");
        }
    }
}
