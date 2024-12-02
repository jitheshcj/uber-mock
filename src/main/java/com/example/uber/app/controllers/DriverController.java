package com.example.uber.app.controllers;

import com.example.uber.app.dtos.DriverDto;
import com.example.uber.app.dtos.RideDto;
import com.example.uber.app.dtos.RideStartDto;
import com.example.uber.app.services.DriverService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/acceptRide/{rideRequestId}")
    public ResponseEntity<RideDto> acceptRide(@PathVariable Long rideRequestId){
        return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
    }

    @PostMapping("/startRide/{rideRequestId}")
    public ResponseEntity<RideDto> startRide(@PathVariable Long rideRequestId,
                                             @RequestBody RideStartDto rideStartDto){
        return ResponseEntity.ok(driverService.startRide(rideRequestId, rideStartDto.getOtp()));
    }

    @PostMapping("/cancelRide/{rideRequestId}")
    public ResponseEntity<RideDto> cancelRide(@PathVariable Long rideRequestId){
        return ResponseEntity.ok(driverService.cancelRide(rideRequestId));
    }

    @GetMapping("/getAllRides")
    public ResponseEntity<List<RideDto>> getAllRides(@RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "5") Integer pageSize){
        return ResponseEntity.ok(driverService.getAllRides(PageRequest.of(pageNumber,pageSize)));
    }
    @GetMapping("/getMyProfile")
    public ResponseEntity<DriverDto> getMyProfile(){
        return ResponseEntity.ok(driverService.getMyProfile());
    }
}
