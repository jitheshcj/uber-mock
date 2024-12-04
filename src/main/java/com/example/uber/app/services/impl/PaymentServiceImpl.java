package com.example.uber.app.services.impl;

import com.example.uber.app.entities.Payment;
import com.example.uber.app.entities.Ride;
import com.example.uber.app.repositories.PaymentRepository;
import com.example.uber.app.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    @Override
    public void processPayment(Payment payment) {

    }

    @Override
    public Payment createNewPayment(Ride ride) {
        return null;
    }
}
