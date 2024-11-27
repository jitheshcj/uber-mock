package com.example.uber.app.services.impl;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.RideDto;
import com.example.uber.app.dtos.RideRequestDto;
import com.example.uber.app.dtos.RiderDto;
import com.example.uber.app.entities.RideRequest;
import com.example.uber.app.entities.Rider;
import com.example.uber.app.entities.User;
import com.example.uber.app.entities.enums.RideRequestStatus;
import com.example.uber.app.repositories.RideRequestRepository;
import com.example.uber.app.repositories.RiderRepository;
import com.example.uber.app.services.RiderService;
import com.example.uber.app.startegies.DriverMatchingStrategy;
import com.example.uber.app.startegies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideFareCalculationStrategy rideFareCalculationStrategy;
    private final DriverMatchingStrategy driverMatchingStrategy;
    private final RiderRepository riderRepository;
    private final RideRequestRepository rideRequestRepository;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest=modelMapper.map(rideRequestDto,RideRequest.class);
        log.info("Converted rider request {}",rideRequest);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);
        log.info("Set the Ride request status as {}",RideRequestStatus.PENDING);
        Double fare=rideFareCalculationStrategy.calculateFare(rideRequest);
        log.info("Calculated fare for the ride is {}",fare);
        rideRequest.setFare(fare);

        RideRequest savedRequest=rideRequestRepository.save(rideRequest);
        driverMatchingStrategy.findMatchingDriver(rideRequest);
        return modelMapper.map(savedRequest,RideRequestDto.class);
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

    @Override
    public Rider createNewRider(User savedUser) {
        return riderRepository.save(
                Rider.builder()
                        .user(savedUser)
                        .rating(0.0)
                        .build()
        );
    }
}
