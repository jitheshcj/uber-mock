package com.example.uber.app.dtos;

import com.example.uber.app.entities.Ride;
import com.example.uber.app.entities.Wallet;
import com.example.uber.app.entities.enums.TransactionMethod;
import com.example.uber.app.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class WalletTransactionDto {
    private Long id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    private RideDto ride;
    private String transactionId;

    private LocalDateTime timestamp;

    private WalletDto wallet;
}
