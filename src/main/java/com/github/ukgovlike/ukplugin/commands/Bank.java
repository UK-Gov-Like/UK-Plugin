package com.github.ukgovlike.ukplugin.commands;

import com.github.ukgovlike.ukplugin.inventory.engine.EngineGui;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Bank implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You need to be a player to execute this action.");
            return false;
        }
        Player player = (Player) sender;
        EngineGui gui = new EngineGui();
        gui.hook(player);
        return false;
    }
}
