package com.example.uber.app.services.impl;

import com.example.uber.app.entities.RideRequest;
import com.example.uber.app.exceptions.ResourceNotFoundException;
import com.example.uber.app.repositories.RideRequestRepository;
import com.example.uber.app.services.RideRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RideRequestServiceImpl implements RideRequestService {

    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequest findRideRequestById(Long rideId) {
        return rideRequestRepository.findById(rideId).orElseThrow(()->new ResourceNotFoundException("Not found"));
    }

    @Override
    public RideRequest saveRideRequest(RideRequest rideRequest) {
        return rideRequestRepository.save(rideRequest);
    }

    @Override
    public RideRequest updateRideRequest(RideRequest rideRequest) {
        if(!rideRequestRepository.existsById(rideRequest.getId())){
            throw new ResourceNotFoundException("Ride Request not found with id "+ rideRequest.getId());
        }
        return rideRequestRepository.save(rideRequest);
    }
}
