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
        List<User> user = userDao.findUserByLoginAndPassword(u.getLogin(),u.getPassword());
        if (user.size() == 1){
            userDto = UserMapper.map(user.get(0));
        }else{
            throw new Exception("Authentication error");
        }
        //traitement
        System.out.println(user);
        return userDto;
    }
}
