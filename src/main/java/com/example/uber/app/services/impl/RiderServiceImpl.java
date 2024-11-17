package com.example.uber.app.services.impl;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.RideDto;
import com.example.uber.app.dtos.RideRequestDto;
import com.example.uber.app.dtos.RiderDto;
import com.example.uber.app.services.RiderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderServiceImpl implements RiderService {

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        return null;
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRiders() {
        return List.of();
    }
}
