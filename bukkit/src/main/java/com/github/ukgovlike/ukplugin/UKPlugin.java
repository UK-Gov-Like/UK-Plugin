package com.github.ukgovlike.ukplugin;

import com.github.ukgovlike.ukplugin.api.cache.UserCache;
import com.github.ukgovlike.ukplugin.command.BankCommand;
import com.github.ukgovlike.ukplugin.task.FakeExcelDatabase;
import com.github.ukgovlike.ukplugin.task.UpdateDatabaseTask;
import com.wizardlybump17.wlib.command.CommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class UKPlugin extends JavaPlugin {

    private final UserCache userCache = new UserCache();

    @Override
    public void onEnable() {
        new CommandManager(this).registerCommands(new BankCommand(userCache));

        initDatabase();
    }

    @Override
    public void onDisable() {
        UpdateDatabaseTask.update(userCache, new FakeExcelDatabase());
    }

    private void initDatabase() {
        //init database

        long delay = 10 * 60 * 20;
        new UpdateDatabaseTask(userCache, new FakeExcelDatabase()).runTaskTimerAsynchronously(this, delay, delay);
        loadUsers();
    }

    private void loadUsers() {

    }
}
