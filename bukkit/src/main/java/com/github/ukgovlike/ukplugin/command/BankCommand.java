package com.github.ukgovlike.ukplugin.command;

import com.github.ukgovlike.ukplugin.api.User;
import com.github.ukgovlike.ukplugin.api.cache.UserCache;
import com.github.ukgovlike.ukplugin.impl.BukkitUser;
import com.github.ukgovlike.ukplugin.inventory.MainInventory;
import com.wizardlybump17.wlib.command.Command;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public record BankCommand(UserCache userCache) {

    @Command(execution = "bank")
    public void bank(Player player) {
        new MainInventory(
                userCache.getOrInsert(player.getUniqueId(), new BukkitUser(player.getUniqueId(), player.getName()))
        ).show(player);
    }

    @Command(execution = "bank (give|add) <target> <amount>", permission = "ukplugin.admin")
    public void bankGive(Player player, String targetName, String amountString) {
        Player target = Bukkit.getPlayerExact(targetName);
        double amount = Double.parseDouble(amountString);

        User user = userCache.getOrInsert(target.getUniqueId(), new BukkitUser(target.getUniqueId(), target.getName()));

        user.addBalance(amount);
    }

    @Command(execution = "bank (set|define) <target> <amount>", permission = "ukplugin.admin")
    public void bankSet(Player player, String targetName, String amountString) {
        Player target = Bukkit.getPlayerExact(targetName);
        double amount = Double.parseDouble(amountString);

        User user = userCache.getOrInsert(target.getUniqueId(), new BukkitUser(target.getUniqueId(), target.getName()));

        user.setBalance(amount);
    }

    @Command(execution = "bank (take|remove) <target> <amount>", permission = "ukplugin.admin")
    public void bankTake(Player player, String targetName, String amountString) {
        Player target = Bukkit.getPlayerExact(targetName);
        double amount = Double.parseDouble(amountString);

        User user = userCache.getOrInsert(target.getUniqueId(), new BukkitUser(target.getUniqueId(), target.getName()));

        user.removeBalance(amount);
    }
}
