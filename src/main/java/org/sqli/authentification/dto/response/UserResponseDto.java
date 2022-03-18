package org.sqli.authentification.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.sqli.authentification.entitie.User;

@Getter
@Setter
public class UserResponseDto {

    private int id;

    private String login;

    private String group;

    public UserResponseDto(){}
    public UserResponseDto(User user){
        this.id = user.getId();
        this.login = user.getLogin();
        this.group = user.getUserGroup().getName();
    }

    @Override
    public String toString() {
        return "UserResponseDto{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
