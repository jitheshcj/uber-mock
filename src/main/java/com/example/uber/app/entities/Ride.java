package com.example.uber.app.entities;

import com.example.uber.app.entities.enums.PaymentMethod;
import com.example.uber.app.entities.enums.RideRequestStatus;
import com.example.uber.app.entities.enums.RideStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Rider rider;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

    private RideStatus status;

    @Column(columnDefinition = "Geometry(Point,4326)")
    private Point pickUpLocation;
    @Column(columnDefinition = "Geometry(Point,4326)")
    private Point dropUpLocation;

    private LocalDateTime startAt;

    private LocalDateTime endedAt;

    private Double fare;

    private String otp;

    @Enumerated(value=EnumType.STRING)
    private PaymentMethod paymentMethod;

}
