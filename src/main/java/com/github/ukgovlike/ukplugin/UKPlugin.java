package com.github.ukgovlike.ukplugin;

import com.github.ukgovlike.ukplugin.commands.Bank;
import com.github.ukgovlike.ukplugin.events.InventoryClick;
import org.bukkit.plugin.java.JavaPlugin;

public final class UKPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
     this.getCommand("bank").setExecutor(new Bank());
     this.getServer().getPluginManager().registerEvents(new InventoryClick(),this);
    }

    @Override
    public void onDisable() {

    }
}
