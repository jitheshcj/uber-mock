package com.example.uber.app.startegies;

import com.example.uber.app.entities.Payment;

public interface PaymentStrategy {
    void processPayment(Payment payment);
}
