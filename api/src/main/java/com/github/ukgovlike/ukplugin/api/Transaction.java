package com.github.ukgovlike.ukplugin.api;

import org.jetbrains.annotations.NotNull;

/**
 * A simple record that represents a transaction.
 */
public record Transaction(
        TransactionType type,
        double amount,
        long millis,
        double oldBankBalance,
        double oldBalance
) implements Comparable<Transaction> {

    @Override
    public int compareTo(@NotNull Transaction o) {
        return Long.compare(o.millis, millis);
    }

    public enum TransactionType {
        WITHDRAW, DEPOSIT
    }
}
