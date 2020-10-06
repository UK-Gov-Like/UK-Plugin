package com.github.ukgovlike.ukplugin;

import com.github.ukgovlike.ukplugin.commands.Bank;
import com.github.ukgovlike.ukplugin.events.InventoryClick;
import org.bukkit.plugin.java.JavaPlugin;

public final class UKPlugin extends JavaPlugin {

    /**
     * @authors Plugner, LoboMetalurgico
     * @since 05/10/2020
     */

    @Override
    public void onEnable() {
     this.getCommand("bank").setExecutor(new Bank());
     this.getServer().getPluginManager().registerEvents(new InventoryClick(),this);
    }

    @Override
    public void onDisable() {

    }

    public static UKPlugin getInstance() {
        return getPlugin(UKPlugin.class);
    }
}
