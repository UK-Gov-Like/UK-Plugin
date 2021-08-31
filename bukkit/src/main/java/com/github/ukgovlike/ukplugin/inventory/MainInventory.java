package com.github.ukgovlike.ukplugin.inventory;

import com.github.ukgovlike.ukplugin.api.User;
import com.wizardlybump17.wlib.adapter.WMaterial;
import com.wizardlybump17.wlib.inventory.item.ItemButton;
import com.wizardlybump17.wlib.inventory.paginated.PaginatedInventoryBuilder;
import com.wizardlybump17.wlib.item.Item;
import org.bukkit.Material;

public class MainInventory extends UKInventory {

    public MainInventory(User user) {
        super(user);
    }

    @Override
    public PaginatedInventoryBuilder getBuilder() {
        return new PaginatedInventoryBuilder()
                .shape("#########" +
                        "#   @   #" +
                        "#       #" +
                        "#-  +  ?#" +
                        "#########")
                .shapeReplacement('@', new ItemButton(
                        Item.builder()
                                .type(Material.PAPER)
                                .displayName("§aYour balance:")
                                .lore("§f" + user.getBalance())
                                .build()
                ))
                .shapeReplacement('-', new ItemButton(
                        Item.builder()
                                .type(Material.GOLD_INGOT)
                                .displayName("§eWithdraw your coins")
                                .build(),
                        event -> new WithdrawInventory(user).show(event.getWhoClicked())
                ))
                .shapeReplacement('+', new ItemButton(
                        Item.builder()
                                .type(Material.EMERALD)
                                .displayName("§aDeposit your coins")
                                .build(),
                        event -> new DepositInventory(user).show(event.getWhoClicked())
                ))
                .shapeReplacement('?', new ItemButton(
                        Item.builder()
                                .type(WMaterial.SIGN)
                                .displayName("§fRecent changes")
                                .build()
                        //transactions inventory
                ));
    }
}
