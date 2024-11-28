package com.example.uber.app.startegies.impl;

import com.example.uber.app.entities.Driver;
import com.example.uber.app.entities.RideRequest;
import com.example.uber.app.repositories.DriverRepository;
import com.example.uber.app.startegies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverMatchingHighestRatedStrategy implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;
    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenHighestRatedDriver(rideRequest.getPickUpLocation());
    }
}
