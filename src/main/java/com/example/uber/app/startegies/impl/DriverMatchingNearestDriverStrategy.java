package com.example.uber.app.startegies.impl;

import com.example.uber.app.dtos.RideRequestDto;
import com.example.uber.app.entities.Driver;
import com.example.uber.app.startegies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingNearestDriverStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequestDto rideRequestDto) {
        return List.of();
    }
}
