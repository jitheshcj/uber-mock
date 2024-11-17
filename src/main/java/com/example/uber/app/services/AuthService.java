package com.example.uber.app.services;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.SignUpDto;
import com.example.uber.app.dtos.UserDto;

public interface AuthService {
    String login(String email,String password);
    UserDto signup(SignUpDto signUpDto);
    DriverDto onboardNewDriver(Long userId);
}
