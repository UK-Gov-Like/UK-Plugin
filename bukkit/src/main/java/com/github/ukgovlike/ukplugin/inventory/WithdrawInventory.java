package com.github.ukgovlike.ukplugin.inventory;

import com.github.ukgovlike.ukplugin.api.User;
import com.wizardlybump17.wlib.inventory.item.ItemButton;
import com.wizardlybump17.wlib.inventory.paginated.PaginatedInventoryBuilder;
import com.wizardlybump17.wlib.item.Item;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class WithdrawInventory extends UKInventory {

    private static final ItemStack WITHDRAW_ALL = Item.builder()
            .type(Material.GOLD_BLOCK)
            .displayName("§eWithdraw all of my money")
            .build();
    private static final ItemStack WITHDRAW_HALF = Item.builder()
            .type(Material.GOLD_INGOT)
            .displayName("§eWithdraw half of my money")
            .build();
    private static final ItemStack WITHDRAW_SPECIFIC = Item.builder()
            .type(Material.GOLD_ORE)
            .displayName("§eWithdraw specific amount of my money")
            .build();

    public WithdrawInventory(User user) {
        super(user);
    }

    @Override
    public PaginatedInventoryBuilder getBuilder() {
        double deposited = user.getDeposited();
        return new PaginatedInventoryBuilder()
                .shape("#########" +
                        "#   @   #" +
                        "#       #" +
                        "#^  /  ?#" +
                        "####_####"
                )
                .shapeReplacement('^', new ItemButton(WITHDRAW_ALL, event -> {
                    user.removeDeposited(deposited);
                    new MainInventory(user).show(event.getWhoClicked());
                }))
                .shapeReplacement('/', new ItemButton(WITHDRAW_HALF, event -> {
                    user.removeDeposited(deposited / 2);
                    event.getWhoClicked().closeInventory();
                    new MainInventory(user).show(event.getWhoClicked());
                }))
                .shapeReplacement('?', new ItemButton(WITHDRAW_SPECIFIC));
    }
}
