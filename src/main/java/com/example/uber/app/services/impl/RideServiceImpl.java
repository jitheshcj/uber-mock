package com.example.uber.app.services.impl;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.RideDto;
import com.example.uber.app.dtos.RideRequestDto;
import com.example.uber.app.dtos.RiderDto;
import com.example.uber.app.entities.Driver;
import com.example.uber.app.entities.Ride;
import com.example.uber.app.entities.enums.RideStatus;
import com.example.uber.app.services.RideService;
import com.example.uber.app.services.RiderService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideServiceImpl implements RideService {

    @Override
    public Ride getRideById(Long rideId) {
        return null;
    }

    @Override
    public void mathWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequestDto rideRequestDto, Driver driver) {
        return null;
    }

    @Override
    public Ride updateRideStatus(Long rideId, RideStatus rideStatus) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidersOfRider(Long riderId, PageRequest pageRequest) {
        return null;
    }

    @Override
    public Page<Ride> getAllRidersOfDriver(Long driverId, PageRequest pageRequest) {
        return null;
    }
}
