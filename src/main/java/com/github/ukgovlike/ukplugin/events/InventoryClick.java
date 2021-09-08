package com.github.ukgovlike.ukplugin.events;

import com.github.ukgovlike.ukplugin.inventory.engine.EngineGui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryClick implements Listener {
    /**
     * @author Plugner
     * @see EngineGui
     * @since 06/10/2020
     * @param e = event when player click in a inventory
     */
    @EventHandler
    public void Click(InventoryClickEvent e) {
        ItemStack item = e.getCurrentItem();
        ItemMeta itemMeta = item.getItemMeta();
        String displayName = itemMeta.getDisplayName();
        Player player = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == EngineGui.MAIN_GUI) {
          if (item.getType() == Material.CHEST) {
            EngineGui engineGui = new EngineGui();
            player.closeInventory();
            engineGui.hookDeposit(player);
            e.setCancelled(true);
          }
          else if(item.getType() == Material.FURNACE) {
            EngineGui engineGui = new EngineGui();
            player.closeInventory();
            engineGui.hookWithdraw(player);
            e.setCancelled(true);
          }
        }
    }
}
