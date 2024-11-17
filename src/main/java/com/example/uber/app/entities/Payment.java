package com.example.uber.app.entities;

import com.example.uber.app.entities.enums.PaymentMethod;
import com.example.uber.app.entities.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @OneToOne(fetch = FetchType.LAZY)
    private  Ride ride;


    private Double amount;

    @CreationTimestamp
    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;
}
