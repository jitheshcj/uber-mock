package com.example.uber.app.startegies;

import com.example.uber.app.entities.RideRequest;

public interface RideFareCalculationStrategy {
    double RIDE_FARE_MULTIPLIER=10;
    double calculateFare(RideRequest rideRequest);
}
