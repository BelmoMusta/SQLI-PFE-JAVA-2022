package org.sqli.authentification.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.sqli.authentification.dao.UserDao;
import org.sqli.authentification.dto.UserDto;
import org.sqli.authentification.entitie.User;
import org.sqli.authentification.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String test(){
        System.out.println("hi");
        return "hi;";
    }

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    public UserDto connect(@RequestBody User user) throws Exception{

        UserDto userDto =userService.checkAuthentification(user);
        return userDto;
    }

    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDto) throws Exception {

        return userService.createAccount(userDto);
    }
}
