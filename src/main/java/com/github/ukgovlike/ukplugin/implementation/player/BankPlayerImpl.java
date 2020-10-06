package com.github.ukgovlike.ukplugin.implementation.player;

import com.github.ukgovlike.ukplugin.api.player.BankPlayer;

public class BankPlayerImpl implements BankPlayer {

    private final String name;
    private double coins;

    public BankPlayerImpl(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getCoins() {
        return coins;
    }

    @Override
    public void setCoins(double amount) {
        coins = amount;
    }
}
