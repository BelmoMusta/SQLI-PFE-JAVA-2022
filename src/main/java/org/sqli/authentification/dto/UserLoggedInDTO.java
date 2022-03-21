package org.sqli.authentification.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserLoggedInDTO implements Serializable {
    private Long id;
    private String login;
    private String group;
}