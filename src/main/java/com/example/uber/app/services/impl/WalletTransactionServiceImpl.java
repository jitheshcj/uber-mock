package com.example.uber.app.services.impl;

import com.example.uber.app.dtos.WalletTransactionDto;
import com.example.uber.app.entities.WalletTransaction;
import com.example.uber.app.repositories.WalletTransactionRepository;
import com.example.uber.app.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletTransactionServiceImpl implements WalletTransactionService{

    private final WalletTransactionRepository walletPaymentRepository;
    private final ModelMapper modelMapper;
    @Override
    public void createNewWalletTransaction(WalletTransactionDto walletTransactionDto) {
        walletPaymentRepository.save(modelMapper.map(walletTransactionDto, WalletTransaction.class));
    }
}
