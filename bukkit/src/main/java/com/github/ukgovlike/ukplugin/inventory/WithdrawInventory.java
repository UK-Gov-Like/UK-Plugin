package com.github.ukgovlike.ukplugin.inventory;

import com.github.ukgovlike.ukplugin.api.Bank;
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

    public WithdrawInventory(Bank bank, User user) {
        super(bank, user);
    }

    @Override
    public PaginatedInventoryBuilder getBuilder() {
        double deposited = bank.getDeposited(user.getId());
        return new PaginatedInventoryBuilder()
                .shape("         " +
                        " 0  1  2 " +
                        "         "
                )
                .shapeReplacement('0', new ItemButton(WITHDRAW_ALL, event -> {
                    bank.withdraw(user.getId(), deposited);
                    user.addBalance(deposited);
                    event.getWhoClicked().closeInventory();
                }))
                .shapeReplacement('1', new ItemButton(WITHDRAW_HALF, event -> {
                    bank.withdraw(user.getId(), deposited / 2);
                    user.addBalance(deposited / 2);
                    event.getWhoClicked().closeInventory();
                }))
                .shapeReplacement('2', new ItemButton(WITHDRAW_SPECIFIC));
    }
}
