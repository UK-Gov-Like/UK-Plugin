package com.github.ukgovlike.ukplugin;

import com.github.ukgovlike.ukplugin.api.player.manager.BankPlayerManager;
import com.github.ukgovlike.ukplugin.commands.Bank;
import com.github.ukgovlike.ukplugin.events.InventoryClick;
import com.github.ukgovlike.ukplugin.implementation.player.manager.BankPlayerManagerImpl;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public final class UKPlugin extends JavaPlugin {

    @Getter
    private static final BankPlayerManager bankPlayerManager = new BankPlayerManagerImpl();

    /**
     * @authors Plugner, LoboMetalurgico, WizardlyBump17
     * @since 05/10/2020
     */
    @Override
    public void onEnable() {
        this.getCommand("bank").setExecutor(new Bank());
        this.getServer().getPluginManager().registerEvents(new InventoryClick(), this);
    }

    @Override
    public void onDisable() {

    }

    public static UKPlugin getInstance() {
        return getPlugin(UKPlugin.class);
    }
}
