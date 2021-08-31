package com.github.ukgovlike.ukplugin.api.cache;

import com.github.ukgovlike.ukplugin.api.Transaction;
import com.github.ukgovlike.ukplugin.api.User;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class InvalidUser implements User {

    public static final String INVALID_NAME = "invalid-user";
    public static final UUID INVALID_UUID = UUID.nameUUIDFromBytes(INVALID_NAME.getBytes());

    @Override
    public UUID getId() {
        return INVALID_UUID;
    }

    @Override
    public String getName() {
        return INVALID_NAME;
    }

    @Override
    public double getBalance() {
        return 0;
    }

    @Override
    public void setBalance(double balance) {
    }

    @Override
    public void addBalance(double balance) {
    }

    @Override
    public void removeBalance(double balance) {
    }

    @Override
    public double getDeposited() {
        return 0;
    }

    @Override
    public void setDeposited(double deposited) {
    }

    @Override
    public void addDeposited(double deposited) {
    }

    @Override
    public void removeDeposited(double deposited) {
    }

    @Override
    public Set<Transaction> getTransactions() {
        return new HashSet<>();
    }

    @Override
    public boolean isDirty() {
        return false;
    }

    @Override
    public void setDirty(boolean dirty) {
    }

    @Override
    public boolean isInDatabase() {
        return false;
    }

    @Override
    public void setInDatabase(boolean inDatabase) {
    }

    @Override
    public boolean isDeleted() {
        return false;
    }

    @Override
    public void setDeleted(boolean deleted) {
    }
}
