package com.example.uber.app.repositories;

import com.example.uber.app.entities.Payment;
import com.example.uber.app.entities.WalletTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WalletTransactionRepository extends JpaRepository<WalletTransaction,Long> {
}
