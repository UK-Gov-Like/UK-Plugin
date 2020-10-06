package com.github.ukgovlike.ukplugin.events;

import com.github.ukgovlike.ukplugin.inventory.engine.EngineGui;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {
    @EventHandler
    public void Click(InventoryClickEvent e) {

           if (e.getCurrentItem().getItemMeta().getDisplayName().contains("Deposit" /*PLEASE CHANGE IN THE FUTURE */)) {
               EngineGui engineGui = new EngineGui();
               e.getWhoClicked().closeInventory();
               engineGui.hookDeposit((Player) e.getWhoClicked());
           }
    }
}
