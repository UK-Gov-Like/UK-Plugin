package com.github.ukgovlike.ukplugin.impl;

import com.github.ukgovlike.ukplugin.api.Transaction;
import com.github.ukgovlike.ukplugin.api.User;
import lombok.Data;

import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

@Data
public class BukkitUser implements User {

    private final UUID id;
    private final String name;
    private double balance;
    private double deposited;
    private final Set<Transaction> transactions = new TreeSet<>();
    private boolean dirty, deleted, inDatabase;

    public void setBalance(double balance) {
        this.balance = balance;
        dirty = true;
    }

    @Override
    public void addBalance(double balance) {
        this.balance += balance;
        dirty = true;
    }

    @Override
    public void removeBalance(double balance) {
        this.balance = Math.max(this.balance - balance, 0);
        dirty = true;
    }

    @Override
    public void addDeposited(double deposited) {
        double oldDeposited = this.deposited;
        double oldBalance = this.balance;

        this.deposited += deposited;
        balance -= deposited;

        transactions.add(new Transaction(Transaction.TransactionType.DEPOSIT, deposited, System.currentTimeMillis(), oldDeposited, oldBalance));
        dirty = true;
    }

    @Override
    public void removeDeposited(double deposited) {
        double oldDeposited = this.deposited;
        double oldBalance = this.balance;

        this.deposited = Math.max(this.deposited - deposited, 0);
        balance += deposited;

        transactions.add(new Transaction(Transaction.TransactionType.WITHDRAW, deposited, System.currentTimeMillis(), oldDeposited, oldBalance));
        dirty = true;
    }

    public void setDeposited(double deposited) {
        this.deposited = deposited;
        dirty = true;
    }
}
