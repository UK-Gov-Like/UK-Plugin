package com.github.ukgovlike.ukplugin.inventory;

import com.github.ukgovlike.ukplugin.api.Bank;
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

    public DepositInventory(Bank bank, User user) {
        super(bank, user);
    }

    @Override
    public PaginatedInventoryBuilder getBuilder() {
        double balance = user.getBalance();
        return new PaginatedInventoryBuilder()
                .shape("         " +
                        " 0  1  2 " +
                        "         "
                )
                .shapeReplacement('0', new ItemButton(DEPOSIT_ALL, event -> {
                    bank.deposit(user.getId(), balance);
                    user.setBalance(0);
                    event.getWhoClicked().closeInventory();
                }))
                .shapeReplacement('1', new ItemButton(DEPOSIT_HALF, event -> {
                    bank.deposit(user.getId(), balance / 2);
                    user.setBalance(balance / 2);
                    event.getWhoClicked().closeInventory();
                }))
                .shapeReplacement('2', new ItemButton(DEPOSIT_SPECIFIC));
    }
}
