package com.github.ukgovlike.ukplugin.impl;

import com.github.ukgovlike.ukplugin.api.Transaction;
import com.github.ukgovlike.ukplugin.api.User;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class BukkitUser implements User {

    private final UUID id;
    private final String name;
    private double balance;
    private final Set<Transaction> transactions = new HashSet<>();
    private boolean dirty, deleted, inDatabase;

    public void setBalance(double balance) {
        this.balance = balance;
        dirty = true;
    }

    @Override
    public void addBalance(double balance) {
        this.balance += balance;
        transactions.add(new Transaction(Transaction.TransactionType.DEPOSIT, balance, System.currentTimeMillis()));
        dirty = true;
    }

    @Override
    public void removeBalance(double balance) {
        this.balance = Math.max(this.balance - balance, 0);
        transactions.add(new Transaction(Transaction.TransactionType.WITHDRAW, balance, System.currentTimeMillis()));
        dirty = true;
    }
}
