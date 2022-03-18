package org.sqli.authentification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sqli.authentification.dto.request.UserRequestDto;
import org.sqli.authentification.dto.response.ResponseMessage;
import org.sqli.authentification.dto.response.UserResponseDto;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.service.AuthentificationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping
    public ResponseEntity<Object> auth(@RequestBody UserRequestDto userRequestDto)
    {
        User user = authentificationService.authenticate(userRequestDto.getLogin(), userRequestDto.getPassword());
        if(user != null){
            return new ResponseEntity<>(new UserResponseDto(user), HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(new ResponseMessage("Not Found User"), HttpStatus.BAD_REQUEST);
    }

}
