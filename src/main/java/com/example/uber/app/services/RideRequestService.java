package com.example.uber.app.services;

import com.example.uber.app.entities.RideRequest;

public interface RideRequestService {
    RideRequest findRideRequestById(Long rideId);

    RideRequest saveRideRequest(RideRequest rideRequest);

    RideRequest updateRideRequest(RideRequest rideRequest);
}
