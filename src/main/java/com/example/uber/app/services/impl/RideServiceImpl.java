package com.example.uber.app.services.impl;

import com.example.uber.app.dtos.RideRequestDto;
import com.example.uber.app.entities.Driver;
import com.example.uber.app.entities.Ride;
import com.example.uber.app.entities.RideRequest;
import com.example.uber.app.entities.enums.RideRequestStatus;
import com.example.uber.app.entities.enums.RideStatus;
import com.example.uber.app.exceptions.ResourceNotFoundException;
import com.example.uber.app.repositories.RideRepository;
import com.example.uber.app.services.RideRequestService;
import com.example.uber.app.services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class RideServiceImpl implements RideService {

    private final RideRepository rideRepository;
    private final RideRequestService rideRequestService;
    private final ModelMapper modelMapper;

    @Override
    public Ride getRideById(Long rideId) {
        return rideRepository.findById(rideId).orElseThrow(
                ()->new ResourceNotFoundException("Ride with id "+ rideId+" not found")
        );
    }

    @Override
    public void mathWithDrivers(RideRequestDto rideRequestDto) {

    }

    @Override
    public Ride createNewRide(RideRequest rideRequest, Driver driver) {
        rideRequest.setRideRequestStatus(RideRequestStatus.CONFIRMED);
        rideRequestService.updateRideRequest(rideRequest);
        Ride ride=modelMapper.map(rideRequest,Ride.class);
        ride.setDriver(driver);
        ride.setOtp(generateRandomOTP());
        ride.setId(null);
        ride.setRideStatus(RideStatus.CONFIRMED);
        return rideRepository.save(ride);
    }

    @Override
    public Ride updateRideStatus(Ride ride, RideStatus rideStatus) {
        ride.setRideStatus(rideStatus);
        return rideRepository.save(ride);
    }

    @Override
    public List<Ride> getAllRidersOfRider(Long riderId, Pageable pageable) {
        return null;
    }

    @Override
    public List<Ride> getAllRidersOfDriver(Driver driver, Pageable pageable) {
        return rideRepository.findByDriver(driver,pageable);
    }

    private String generateRandomOTP(){
        Random random=new Random();
        int otp=random.nextInt(10000);
        return String.format("%04d",otp);
    }
}
