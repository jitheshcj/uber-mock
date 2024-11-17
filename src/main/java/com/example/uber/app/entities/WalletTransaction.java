package com.example.uber.app.entities;

import com.example.uber.app.entities.enums.TransactionMethod;
import com.example.uber.app.entities.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Enumerated(value=EnumType.STRING)
    private TransactionType transactionType;

    @Enumerated(value = EnumType.STRING)
    private TransactionMethod transactionMethod;

    @OneToOne(fetch = FetchType.LAZY)
    private Ride ride;

    private String transactionId;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Wallet wallet;
}
