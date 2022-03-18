package org.sqli.authentification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {

    private String login;
    private int id;
    private String group;


}
