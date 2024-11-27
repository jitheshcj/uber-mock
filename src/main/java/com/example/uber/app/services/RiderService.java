package com.example.uber.app.services;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.RideDto;
import com.example.uber.app.dtos.RideRequestDto;
import com.example.uber.app.dtos.RiderDto;
import com.example.uber.app.entities.Rider;
import com.example.uber.app.entities.User;

import java.util.List;

public interface RiderService {
   RideRequestDto requestRide(RideRequestDto rideRequestDto);
   RideDto cancelRide(Long rideId);
   DriverDto rateDriver(Long rideId,Integer rating);
   RiderDto getMyProfile();
   List<RideDto> getAllMyRiders();

   Rider createNewRider(User savedUser);
}
