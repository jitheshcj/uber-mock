package com.example.uber.app.services.impl;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.SignUpDto;
import com.example.uber.app.dtos.UserDto;
import com.example.uber.app.entities.Rider;
import com.example.uber.app.entities.User;
import com.example.uber.app.entities.Wallet;
import com.example.uber.app.entities.enums.Role;
import com.example.uber.app.repositories.UserRepository;
import com.example.uber.app.services.AuthService;
import com.example.uber.app.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    public UserDto signup(SignUpDto signUpDto) {
        userRepository.findByEmail(signUpDto.getEmail())
                .ifPresent(u -> {
                    throw new RuntimeException("Can't sign in. Email already exists");
                });
        User mappedUser=modelMapper.map(signUpDto,User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
//        TODO: add password encoder once available;
        User savedUser=userRepository.save(mappedUser);
        Rider rider=riderService.createNewRider(savedUser);
//        Wallet wallet=
//        TODO: Add wallet related service;
        return modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId) {
        return null;
    }
}
