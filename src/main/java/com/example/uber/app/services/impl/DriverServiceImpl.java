package com.example.uber.app.services.impl;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.RideDto;
import com.example.uber.app.entities.Driver;
import com.example.uber.app.entities.Ride;
import com.example.uber.app.entities.RideRequest;
import com.example.uber.app.entities.enums.RideRequestStatus;
import com.example.uber.app.entities.enums.RideStatus;
import com.example.uber.app.exceptions.ResourceNotFoundException;
import com.example.uber.app.exceptions.RuntimeConflictException;
import com.example.uber.app.repositories.DriverRepository;
import com.example.uber.app.services.DriverService;
import com.example.uber.app.services.RideRequestService;
import com.example.uber.app.services.RideService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverServiceImpl implements DriverService {

    private final RideRequestService rideRequestService;
    private final DriverRepository driverRepository;
    private final ModelMapper modelMapper;
    private final RideService rideService;

    @Override
    public RideDto cancelRide(Long rideId) {
        Ride ride=rideService.getRideById(rideId);
        Driver driver=getCurrentDriver();
        if(!driver.equals(ride.getDriver())){
            throw new RuntimeException("Driver cannot start a ride as he ahs not accepted it earlier");
        }
        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw  new RuntimeException("Ride cannot be cancelled, invalid status "+ ride.getRideStatus());
        }
        Ride updatedRide=rideService.updateRideStatus(ride,RideStatus.CANCELLED);
        updateDriverStatus(driver,true);
        return modelMapper.map(updatedRide,RideDto.class);
    }

    @Override
    public RideDto startRide(Long rideId,String otp) {
        Ride ride=rideService.getRideById(rideId);
        Driver currentDriver=getCurrentDriver();
        if(!currentDriver.equals(ride.getDriver())){
            throw new RuntimeException("Driver can not start ride as he not the owner of the ride");
        }
        if(!ride.getRideStatus().equals(RideStatus.CONFIRMED)){
            throw new RuntimeException("Ride status is not CONFIRMED , hence cannot be starter, status: "+ride.getRideStatus());
        }
        if(!otp.equals(ride.getOtp())){
            throw new RuntimeException("Otp does not match , Please enter a correct OTP");
        }
        ride.setStartAt(LocalDateTime.now());
        Ride updatedRide= rideService.updateRideStatus(ride,RideStatus.ONGOING);
        return modelMapper.map(updatedRide,RideDto.class);
    }

    @Override
    public RideDto acceptRide(Long rideId) {
        RideRequest rideRequest=rideRequestService.findRideRequestById(rideId);
        if(rideRequest.getRideRequestStatus()==RideRequestStatus.CONFIRMED){
            throw new RuntimeConflictException("Ride Request service status is "+rideRequest.getRideRequestStatus()+" so "
                    +RideRequestStatus.CONFIRMED+" can't be invoked.");
        }
        Driver currentDriver=getCurrentDriver();
        if(!currentDriver.getAvailable()){
            throw new RuntimeConflictException("Driver not available!!!");
        }
        Ride ride=rideService.createNewRide(rideRequest,currentDriver);
        updateDriverStatus(currentDriver,false);
        return modelMapper.map(ride,RideDto.class);

    }

    @Override
    public RideDto endRide(Long rideId) {
        return null;
    }

    @Override
    public RideDto rateRide(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public List<RideDto> getAllRides(Long rideId) {
        return List.of();
    }

    @Override
    public DriverDto getMyProfile() {
        return modelMapper.map(getCurrentDriver(),DriverDto.class);
    }

    @Override
    public Driver getCurrentDriver() {
        return driverRepository.findById(1L).orElseThrow(()->
                new ResourceNotFoundException("Current driver not found"));
    }

    @Override
    public Driver updateDriverStatus(Driver driver, boolean status) {
        driver.setAvailable(status);
        return driverRepository.save(driver);
    }
}
