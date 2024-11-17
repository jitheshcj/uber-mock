package com.example.uber.app.startegies;

import com.example.uber.app.dtos.RideRequestDto;

public interface RideFareCalculationStrategy {
    double calculateFare(RideRequestDto requestDto);
}
