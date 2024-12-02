package com.example.uber.app.services;

import com.example.uber.app.dtos.RideRequestDto;
import com.example.uber.app.entities.Driver;
import com.example.uber.app.entities.Ride;
import com.example.uber.app.entities.RideRequest;
import com.example.uber.app.entities.enums.RideStatus;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RideService {
    Ride getRideById(Long rideId);
    void mathWithDrivers(RideRequestDto rideRequestDto);
    Ride createNewRide(RideRequest rideRequestDto, Driver driver);
    Ride updateRideStatus(Ride ride, RideStatus rideStatus);
    List<Ride> getAllRidersOfRider(Long riderId, Pageable pageable);
    List<Ride> getAllRidersOfDriver(Driver driver,  Pageable pageable);
}
