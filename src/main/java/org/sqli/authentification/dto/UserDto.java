package org.sqli.authentification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String login;
    private String group;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password; //Client -> Server

}
