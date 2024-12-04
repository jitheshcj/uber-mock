package com.example.uber.app.startegies.impl;

import com.example.uber.app.entities.Payment;
import com.example.uber.app.startegies.PaymentStrategy;
import org.springframework.stereotype.Service;

@Service
public class CODPaymentStrategy implements PaymentStrategy {
    @Override
    public void processPayment(Payment payment) {

    }
}
