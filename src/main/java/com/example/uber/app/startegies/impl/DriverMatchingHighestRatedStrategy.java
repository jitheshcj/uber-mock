package com.example.uber.app.startegies.impl;

import com.example.uber.app.entities.Driver;
import com.example.uber.app.entities.RideRequest;
import com.example.uber.app.startegies.DriverMatchingStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverMatchingHighestRatedStrategy implements DriverMatchingStrategy {
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return List.of();
    }
}
