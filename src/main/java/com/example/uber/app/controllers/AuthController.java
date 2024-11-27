package com.example.uber.app.controllers;

import com.example.uber.app.dtos.SignUpDto;
import com.example.uber.app.dtos.UserDto;
import com.example.uber.app.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public UserDto signUp(@RequestBody SignUpDto signUpDto){
        return authService.signup(signUpDto);
    }
}
