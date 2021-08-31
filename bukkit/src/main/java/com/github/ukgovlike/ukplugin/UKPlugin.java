package com.github.ukgovlike.ukplugin;

import com.github.ukgovlike.ukplugin.api.Bank;
import com.github.ukgovlike.ukplugin.api.cache.UserCache;
import com.github.ukgovlike.ukplugin.command.BankCommand;
import com.wizardlybump17.wlib.command.CommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class UKPlugin extends JavaPlugin {

    private final Bank bank = new Bank();
    private final UserCache userCache = new UserCache();

    @Override
    public void onEnable() {
        new CommandManager(this).registerCommands(new BankCommand(bank, userCache));
    }
}
