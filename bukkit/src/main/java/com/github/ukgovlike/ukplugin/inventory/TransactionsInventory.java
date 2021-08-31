package com.github.ukgovlike.ukplugin.inventory;

import com.github.ukgovlike.ukplugin.api.Transaction;
import com.github.ukgovlike.ukplugin.api.User;
import com.wizardlybump17.wlib.inventory.item.ItemButton;
import com.wizardlybump17.wlib.inventory.paginated.PaginatedInventoryBuilder;
import com.wizardlybump17.wlib.item.Item;
import com.wizardlybump17.wlib.util.DateUtil;
import com.wizardlybump17.wlib.util.NumberFormatter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.stream.Collectors;

public class TransactionsInventory extends UKInventory {

    public TransactionsInventory(User user) {
        super(user);
    }

    @Override
    public PaginatedInventoryBuilder getBuilder() {
        return new PaginatedInventoryBuilder()
                .shape("#########" +
                        "#xxxxxxx#" +
                        (user.getTransactions().isEmpty() ? "#xxx0xxx#" : "#xxxxxxx#") +
                        "#xxxxxxx#" +
                        "<###_###>")
                .content(
                        user.getTransactions().stream()
                        .map(TransactionsInventory::getTransactionItem)
                        .collect(Collectors.toList())
                )
                .shapeReplacement('0', new ItemButton(
                        Item.builder()
                                .type(Material.COBWEB)
                                .displayName("§cNo transactions")
                                .build()
                ));
    }

    private static ItemButton getTransactionItem(Transaction transaction) {
        NumberFormatter formatter = NumberFormatter.SIMPLE_FORMATTER;
        ItemStack item;
        switch (transaction.type()) {
            case WITHDRAW: {
                item = Item.builder()
                        .type(Material.GOLD_INGOT)
                        .displayName("§e" + new DateUtil(transaction.millis()).format(DateUtil.DateFormat.FULL))
                        .lore(
                                "§eWithdraw §f" + formatter.formatNumber(transaction.amount()),
                                "",
                                "§eBank balance before the operation:",
                                "§f - " + formatter.formatNumber(transaction.oldBankBalance()),
                                "§eBank balance after the operation:",
                                "§f - " + formatter.formatNumber(transaction.oldBankBalance() - transaction.amount()),
                                "",
                                "§eYour balance before the operation:",
                                "§f - " + formatter.formatNumber(transaction.oldBalance()),
                                "§eYour balance after the operation:",
                                "§f - " + formatter.formatNumber(transaction.oldBalance() + transaction.amount())
                        )
                        .build();
                break;
            }
            case DEPOSIT: {
                item = Item.builder()
                        .type(Material.EMERALD)
                        .displayName("§a" + new DateUtil(transaction.millis()).format(DateUtil.DateFormat.FULL))
                        .lore(
                                "§aDeposited §f" + formatter.formatNumber(transaction.amount()),
                                "",
                                "§aBank balance before the operation:",
                                "§f - " + formatter.formatNumber(transaction.oldBankBalance()),
                                "§aBank balance after the operation:",
                                "§f - " + formatter.formatNumber(transaction.oldBankBalance() + transaction.amount()),
                                "",
                                "§aYour balance before the operation:",
                                "§f - " + formatter.formatNumber(transaction.oldBalance()),
                                "§aYour balance after the operation:",
                                "§f - " + formatter.formatNumber(transaction.oldBalance() - transaction.amount())
                        )
                        .build();
                break;
            }
            default: item = new ItemStack(Material.AIR);
        }
        return new ItemButton(item);
    }
}
