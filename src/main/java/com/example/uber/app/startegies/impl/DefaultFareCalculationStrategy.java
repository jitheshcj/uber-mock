package com.example.uber.app.startegies.impl;

import com.example.uber.app.entities.RideRequest;
import com.example.uber.app.services.DistanceService;
import com.example.uber.app.startegies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Primary
public class DefaultFareCalculationStrategy implements RideFareCalculationStrategy {

    private final DistanceService distanceService;
    @Override
    public double calculateFare(RideRequest rideRequest) {
        double distance=distanceService.calculateDistance(rideRequest.getPickUpLocation(),rideRequest.getDropUpLocation());
        return distance*RIDE_FARE_MULTIPLIER;
    }
}