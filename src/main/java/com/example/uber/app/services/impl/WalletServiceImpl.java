package com.example.uber.app.services.impl;

import com.example.uber.app.entities.User;
import com.example.uber.app.entities.Wallet;
import com.example.uber.app.exceptions.ResourceNotFoundException;
import com.example.uber.app.exceptions.RuntimeConflictException;
import com.example.uber.app.repositories.WalletRepository;
import com.example.uber.app.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Override
    public Wallet addMoneyToWallet(User user, Double amount) {
        Wallet wallet=walletRepository.findByUser(user).orElseThrow(()->
                new ResourceNotFoundException("Wallet for user is not created or not found !!!"));
        wallet.setBalance(wallet.getBalance()+amount);
        return walletRepository.save(wallet);
    }

    @Override
    public void withdrawMoneyFromWallet() {

    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return null;
    }

    @Override
    public Wallet createNewWallet(User user) {
        walletRepository.findByUser(user).ifPresent(x-> {
            throw new RuntimeException("User wallet was already created!!");
        });
        return walletRepository.save(Wallet.builder()
                        .balance(0.0)
                        .user(user)
                        .build());
    }
}
