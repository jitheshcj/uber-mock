package com.example.uber.app.services;

import com.example.uber.app.entities.Payment;
import com.example.uber.app.entities.Ride;

public interface PaymentService {
    void processPayment(Payment payment);

    Payment createNewPayment(Ride ride);
}
