package com.github.ukgovlike.ukplugin.api.player.manager;

import com.github.ukgovlike.ukplugin.api.player.BankPlayer;

import java.util.Map;

public interface BankPlayerManager {

    Map<String, BankPlayer> getPlayers();
    BankPlayer getPlayer(String name);
    void registerPlayer(BankPlayer bankPlayer);
    void unregisterPlayer(String name);
    default boolean isPlayerRegistered(String name) {
        return getPlayer(name) != null;
    }
}
