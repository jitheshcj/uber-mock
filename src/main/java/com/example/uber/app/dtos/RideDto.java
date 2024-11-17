package com.example.uber.app.dtos;

import com.example.uber.app.entities.Rider;
import com.example.uber.app.entities.enums.PaymentMethod;
import com.example.uber.app.entities.enums.RideStatus;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

public class RideDto {
    private Long id;
    private Point pickUpLocation;
    private Point dropUpLocation;
    private LocalDateTime createdTime;

    private RiderDto rider;
    private DriverDto driver;

    private PaymentMethod paymentMethod;

    private RideStatus status;

    private Double fare;

    private LocalDateTime startAt;
    private LocalDateTime endedAt;


}
