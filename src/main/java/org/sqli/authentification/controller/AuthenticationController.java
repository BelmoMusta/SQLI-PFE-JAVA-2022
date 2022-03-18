package org.sqli.authentification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sqli.authentification.dto.request.UserRequestDto;
import org.sqli.authentification.dto.response.ResponseErrorMessage;
import org.sqli.authentification.dto.response.ResponseMessage;
import org.sqli.authentification.dto.response.UserResponseDto;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.exception.UserException;
import org.sqli.authentification.service.AuthentificationService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthentificationService authentificationService;

    @PostMapping
    public ResponseEntity<Object> auth(@RequestBody UserRequestDto userRequestDto)
    {
        try{
            User user = authentificationService.authenticate(userRequestDto.getLogin(), userRequestDto.getPassword());
            return new ResponseEntity<>(new UserResponseDto(user), HttpStatus.ACCEPTED);
        }
        catch (UserException ex)
        {
            return new ResponseEntity<>(new ResponseErrorMessage(ex.getMessage()), HttpStatus.BAD_REQUEST);
        }

    }

}
