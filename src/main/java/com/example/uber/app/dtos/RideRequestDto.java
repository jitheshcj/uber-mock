package com.example.uber.app.dtos;

import com.example.uber.app.entities.Rider;
import com.example.uber.app.entities.enums.PaymentMethod;
import com.example.uber.app.entities.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {
    private Long id;
    private PointDto pickUpLocation;
    private PointDto dropUpLocation;
    private LocalDateTime requestedTime;
    private Rider rider;
    private PaymentMethod paymentMethod;
    private RideRequestStatus rideRequestStatus;
    private Double fare;
}
