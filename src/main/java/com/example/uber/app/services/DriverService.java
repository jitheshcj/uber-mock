package com.example.uber.app.services;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.RideDto;

import java.util.List;

public interface DriverService {
     RideDto cancelRide(Long rideId);
     RideDto startRide(Long rideId);
     RideDto acceptRide(Long rideId);
     RideDto endRide(Long rideId);
     RideDto rateRide(Long rideId,Integer rating);
     List<RideDto> getAllRides(Long rideId);
     DriverDto getMyProfile();

}
