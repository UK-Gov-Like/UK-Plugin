package com.github.ukgovlike.ukplugin.api;

import com.github.ukgovlike.ukplugin.api.database.DatabaseStorable;

import java.util.Set;
import java.util.UUID;

public interface User extends DatabaseStorable {

    UUID getId();
    String getName();

    double getBalance();
    void setBalance(double balance);
    void addBalance(double balance);
    void removeBalance(double balance);
    default boolean hasBalance(double balance) {
        return getBalance() >= balance;
    }

    double getDeposited();
    void setDeposited(double deposited);
    void addDeposited(double deposited);
    void removeDeposited(double deposited);

    Set<Transaction> getTransactions();
}
