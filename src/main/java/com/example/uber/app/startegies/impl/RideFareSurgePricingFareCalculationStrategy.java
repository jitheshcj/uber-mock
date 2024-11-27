package com.example.uber.app.startegies.impl;

import com.example.uber.app.entities.RideRequest;
import com.example.uber.app.startegies.RideFareCalculationStrategy;
import org.springframework.stereotype.Service;

@Service
public class RideFareSurgePricingFareCalculationStrategy implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
