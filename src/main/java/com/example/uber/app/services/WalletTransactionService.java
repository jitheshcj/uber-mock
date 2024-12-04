package com.example.uber.app.services;

import com.example.uber.app.dtos.WalletTransactionDto;
import com.example.uber.app.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransactionDto walletTransactionDto);
}
