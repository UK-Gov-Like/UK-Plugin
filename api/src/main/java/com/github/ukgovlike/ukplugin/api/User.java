package com.github.ukgovlike.ukplugin.api;

import java.util.Set;

public interface User {

    double getBalance();
    void setBalance(double balance);
    void addBalance(double balance);
    void removeBalance(double balance);

    Set<Transaction> getTransactions();
}
