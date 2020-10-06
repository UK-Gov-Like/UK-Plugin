package com.github.ukgovlike.ukplugin;

import com.github.ukgovlike.ukplugin.commands.Bank;
import org.bukkit.plugin.java.JavaPlugin;

public final class UKPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
     this.getCommand("bank").setExecutor(new Bank());
    }

    @Override
    public void onDisable() {

    }
}
