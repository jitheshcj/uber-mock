package com.example.uber.app.services.impl;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.SignUpDto;
import com.example.uber.app.dtos.UserDto;
import com.example.uber.app.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignUpDto signUpDto) {
        return null;
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
