package com.example.uber.app.dtos;

import com.example.uber.app.entities.enums.PaymentMethod;
import com.example.uber.app.entities.enums.RideStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RideDto {
    private Long id;
    private PointDto pickUpLocation;
    private PointDto dropUpLocation;
    private LocalDateTime createdTime;

    private RiderDto rider;
    private DriverDto driver;

    private PaymentMethod paymentMethod;

    private RideStatus status;

    private Double fare;

    private LocalDateTime startAt;
    private LocalDateTime endedAt;

    private String otp;


}
