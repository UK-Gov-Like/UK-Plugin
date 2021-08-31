package com.github.ukgovlike.ukplugin.api;

/**
 * A simple record that represents a transaction.
 */
public record Transaction(TransactionType type, double amount, long millis) {

    public enum TransactionType {
        WITHDRAW, DEPOSIT
    }
}
