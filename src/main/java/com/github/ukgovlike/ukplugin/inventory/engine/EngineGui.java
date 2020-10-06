package com.github.ukgovlike.ukplugin.inventory.engine;

import com.github.ukgovlike.ukplugin.inventory.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class EngineGui {
    public void hook(Player p) {
        Inventory inventory = Bukkit.createInventory(null, 3*9, ""+ChatColor.COLOR_CHAR+"6UK Bank");
        inventory.setItem(10,new ItemBuilder(Material.CHEST).setName(""+ChatColor.COLOR_CHAR+"eDeposit your coins").setLore("", ""+ChatColor.COLOR_CHAR+"fBalance: "+ChatColor.COLOR_CHAR+"6$1,000,000.00", "", ""+ChatColor.COLOR_CHAR+"fClick here to deposit", ""+ChatColor.COLOR_CHAR+"fyour coins, and invest your money!", "").toItemStack());
        inventory.setItem(13,new ItemBuilder(Material.FURNACE).setName(""+ChatColor.COLOR_CHAR+"eWithdraw your coins").setLore("", ""+ChatColor.COLOR_CHAR+"fBalance: "+ChatColor.COLOR_CHAR+"6$1,000,000.00", "", ""+ChatColor.COLOR_CHAR+"fClick here to withdraw", ""+ChatColor.COLOR_CHAR+"fyour coins, and use yout money anywhere!").toItemStack());
        inventory.setItem(16,new ItemBuilder(Material.FILLED_MAP).setName(""+ ChatColor.COLOR_CHAR+"eRecent Chances").setLore("", ""+ChatColor.COLOR_CHAR+"e<1 minute "+ChatColor.COLOR_CHAR+"a+10,00 "+ChatColor.COLOR_CHAR+"9Plugner", ""+ChatColor.COLOR_CHAR+"eless than an hour "+ChatColor.COLOR_CHAR+"c-5,00 "+ChatColor.COLOR_CHAR+"3LoboMetalurgico").toItemStack());
        p.openInventory(inventory);
    }
}
