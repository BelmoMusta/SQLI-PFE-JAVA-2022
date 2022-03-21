package org.sqli.authentification.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.sqli.authentification.dto.UserLoginFormDTO;
import org.sqli.authentification.dto.UserLoggedInDTO;
import org.sqli.authentification.service.AuthService;

@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthController {


    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<UserLoggedInDTO> createProduct(@RequestBody  final UserLoginFormDTO userLoginFormDTO) {
        return ResponseEntity.ok(authService.login(userLoginFormDTO));
    }

}