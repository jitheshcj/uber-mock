package com.example.uber.app.services;

import com.example.uber.app.dtos.RideRequestDto;
import com.example.uber.app.entities.Driver;
import com.example.uber.app.entities.Ride;
import com.example.uber.app.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {
    Ride getRideById(Long rideId);
    void mathWithDrivers(RideRequestDto rideRequestDto);
    Ride createNewRide(RideRequestDto rideRequestDto, Driver driver);
    Ride updateRideStatus(Long rideId, RideStatus rideStatus);
    Page<Ride> getAllRidersOfRider(Long riderId, PageRequest pageRequest);
    Page<Ride> getAllRidersOfDriver(Long driverId, PageRequest pageRequest);
}
