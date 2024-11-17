package com.example.uber.app.startegies;

import com.example.uber.app.dtos.RideRequestDto;
import com.example.uber.app.entities.Driver;

import java.util.List;

public interface DriverMatchingStrategy {

     List<Driver> findMatchingDriver(RideRequestDto rideRequestDto);
}
