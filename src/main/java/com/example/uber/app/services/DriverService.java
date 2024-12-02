package com.example.uber.app.services;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.RideDto;
import com.example.uber.app.entities.Driver;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DriverService {
     RideDto cancelRide(Long rideId);
     RideDto startRide(Long rideId,String otp);
     RideDto acceptRide(Long rideId);
     RideDto endRide(Long rideId);
     RideDto rateRide(Long rideId,Integer rating);
     List<RideDto> getAllRides(Pageable pageable);
     DriverDto getMyProfile();
     Driver getCurrentDriver();
     Driver updateDriverStatus(Driver driver,boolean status);
}
