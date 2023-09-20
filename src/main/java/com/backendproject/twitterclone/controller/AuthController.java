package com.backendproject.twitterclone.controller;

import com.backendproject.twitterclone.entity.User;
import com.backendproject.twitterclone.requests.LoginRequest;
import com.backendproject.twitterclone.requests.RegistrationRequest;
import com.backendproject.twitterclone.responses.LoginResponse;
import com.backendproject.twitterclone.service.AuthenticationService;
import com.backendproject.twitterclone.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationService authenticationService;
    private UserService userService;

    public AuthController(AuthenticationService authenticationService, UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegistrationRequest user){
        return authenticationService.register(user.getName(), user.getPhoneNumber(), user.getEmail(),
                user.getNick(), user.getPassword());
    }

    @PostMapping("/login")
    public LoginResponse register(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }
}