package com.github.ukgovlike.ukplugin.command;

import com.github.ukgovlike.ukplugin.api.cache.UserCache;
import com.github.ukgovlike.ukplugin.impl.BukkitUser;
import com.github.ukgovlike.ukplugin.inventory.WithdrawInventory;
import com.wizardlybump17.wlib.command.Command;
import org.bukkit.entity.Player;

public record BankCommand(UserCache userCache) {

    @Command(execution = "bank")
    public void bank(Player player) {
        new WithdrawInventory(userCache.getOrInsert(player.getUniqueId(), new BukkitUser(player.getUniqueId(), player.getName())))
                .show(player);
    }
}
