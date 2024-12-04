package com.example.uber.app.dtos;

import com.example.uber.app.entities.User;
import com.example.uber.app.entities.WalletTransaction;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;
@Data
public class WalletDto {
    private Long id;
    private UserDto user;
    private Double balance;
    private List<WalletTransactionDto> transactions;
}
