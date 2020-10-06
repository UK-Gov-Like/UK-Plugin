package com.github.ukgovlike.ukplugin.api.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public interface BankPlayer {

    String getName();
    double getCoins();
    void setCoins(double amount);
    default boolean hasCoins(double amount) {
        return getCoins() >= amount;
    }
    default void deposit(double amount) {
        if(amount <= 0) throw new NumberFormatException("invalid amount (amount <= 0)");
        setCoins(getCoins() + amount);
    }
    default void withdraw(double amount) {
        if(amount <= 0) throw new NumberFormatException("invalid amount (amount <= 0)");
        setCoins(getCoins() - amount);
    }
    default Player getBukkitPlayer() {
        return Bukkit.getPlayerExact(getName());
    }
}
