package com.github.ukgovlike.ukplugin.api;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Bank {

    private final Map<UUID, Double> depositedValues = new HashMap<>();

    public void deposit(UUID id, double value) {
        depositedValues.put(id, depositedValues.getOrDefault(id, 0d) + value);
    }

    public void withdraw(UUID id, double value) {
        depositedValues.put(id, depositedValues.getOrDefault(id, 0d) - value);
    }

    public double getDeposited(UUID id) {
        return depositedValues.getOrDefault(id, 0d);
    }
}
