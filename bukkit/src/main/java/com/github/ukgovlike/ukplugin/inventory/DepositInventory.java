package com.github.ukgovlike.ukplugin.inventory;

import com.github.ukgovlike.ukplugin.api.User;
import com.wizardlybump17.wlib.inventory.item.ItemButton;
import com.wizardlybump17.wlib.inventory.paginated.PaginatedInventoryBuilder;
import com.wizardlybump17.wlib.item.Item;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class DepositInventory extends UKInventory {

    private static final ItemStack DEPOSIT_ALL = Item.builder()
            .type(Material.EMERALD_BLOCK)
            .displayName("§aDeposit all of my money")
            .build();
    private static final ItemStack DEPOSIT_HALF = Item.builder()
            .type(Material.EMERALD)
            .displayName("§aDeposit half of my money")
            .build();
    private static final ItemStack DEPOSIT_SPECIFIC = Item.builder()
            .type(Material.EMERALD_ORE)
            .displayName("§aDeposit specific amount of my money")
            .build();

    public DepositInventory(User user) {
        super(user);
    }

    @Override
    public PaginatedInventoryBuilder getBuilder() {
        double balance = user.getBalance();
        return new PaginatedInventoryBuilder()
                .shape("#########" +
                        "#   @   #" +
                        "#       #" +
                        "#^  /  ?#" +
                        "####_####"
                )
                .shapeReplacement('^', new ItemButton(DEPOSIT_ALL, event -> {
                    user.addDeposited(balance);
                    user.setBalance(0);
                    event.getWhoClicked().closeInventory();
                    new MainInventory(user).show(event.getWhoClicked());
                }))
                .shapeReplacement('/', new ItemButton(DEPOSIT_HALF, event -> {
                    user.addDeposited(balance / 2);
                    user.setBalance(balance / 2);
                    event.getWhoClicked().closeInventory();
                    new MainInventory(user).show(event.getWhoClicked());
                }))
                .shapeReplacement('?', new ItemButton(DEPOSIT_SPECIFIC));
    }
}
