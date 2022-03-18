package org.sqli.authentification.mapper;

import org.sqli.authentification.dto.UserDto;
import org.sqli.authentification.entitie.User;

public class UserMapper {

    public static UserDto userDto;

    public static UserDto map(User user){
        userDto = new UserDto();
        userDto.setId( user.getId() );
        userDto.setLogin( user.getLogin());
        userDto.setGroup( user.getMyGroup().getName() );

        return userDto;
    }
}
