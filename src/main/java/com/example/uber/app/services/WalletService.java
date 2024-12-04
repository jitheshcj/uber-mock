package com.example.uber.app.services;

import com.example.uber.app.entities.User;
import com.example.uber.app.entities.Wallet;

public interface WalletService {
    Wallet addMoneyToWallet(User user,Double amount);
    void withdrawMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet createNewWallet(User user);

}
