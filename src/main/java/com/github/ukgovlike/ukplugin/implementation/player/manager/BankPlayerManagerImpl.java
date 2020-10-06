package com.github.ukgovlike.ukplugin.implementation.player.manager;

import com.github.ukgovlike.ukplugin.api.player.BankPlayer;
import com.github.ukgovlike.ukplugin.api.player.manager.BankPlayerManager;

import java.util.HashMap;
import java.util.Map;

public class BankPlayerManagerImpl implements BankPlayerManager {

    private final Map<String, BankPlayer> players = new HashMap<>();

    @Override
    public Map<String, BankPlayer> getPlayers() {
        return players;
    }

    @Override
    public BankPlayer getPlayer(String name) {
        return players.get(name.toLowerCase());
    }

    @Override
    public void registerPlayer(BankPlayer bankPlayer) {
        if(isPlayerRegistered(bankPlayer.getName())) throw new IllegalArgumentException("this player is registered");
        players.put(bankPlayer.getName().toLowerCase(), bankPlayer);
    }

    @Override
    public void unregisterPlayer(String name) {
        if(!isPlayerRegistered(name)) throw new NullPointerException("this player is not registered");
        players.remove(name.toLowerCase());
    }
}
