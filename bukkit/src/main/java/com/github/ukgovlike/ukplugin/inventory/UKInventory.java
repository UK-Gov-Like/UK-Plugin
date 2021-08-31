package com.github.ukgovlike.ukplugin.inventory;

import com.github.ukgovlike.ukplugin.api.User;
import com.wizardlybump17.wlib.adapter.WMaterial;
import com.wizardlybump17.wlib.inventory.item.ItemButton;
import com.wizardlybump17.wlib.inventory.paginated.InventoryNavigator;
import com.wizardlybump17.wlib.inventory.paginated.PaginatedInventoryBuilder;
import com.wizardlybump17.wlib.item.Item;
import com.wizardlybump17.wlib.util.NumberFormatter;
import lombok.Data;
import org.bukkit.Material;
import org.bukkit.entity.HumanEntity;

@Data
abstract class UKInventory {

    private static final ItemButton BLACK_GLASS = new ItemButton(
            Item.builder().type(WMaterial.BLACK_STAINED_GLASS_PANE).displayName(" ").build()
    );
    private static final InventoryNavigator NEXT_PAGE = new InventoryNavigator(
            Item.builder()
                    .type(Material.ARROW)
                    .displayName("§aNext page")
                    .build(),
            '#'
    );
    private static final InventoryNavigator PREVIOUS_PAGE = new InventoryNavigator(
            Item.builder()
                    .type(Material.ARROW)
                    .displayName("§aPrevious page")
                    .build(),
            '#'
    );

    protected final User user;

    public abstract PaginatedInventoryBuilder getBuilder();

    public void show(HumanEntity player) {
        getBuilder()
                .title("UK Bank")
                .shapeReplacement('#', BLACK_GLASS)
                .shapeReplacement('@', new ItemButton(
                        Item.builder()
                                .type(Material.PAPER)
                                .displayName("§aYour balance:")
                                .lore(
                                        "§f - " + NumberFormatter.SIMPLE_FORMATTER.formatNumber(user.getBalance()),
                                        "",
                                        "§aDeposited:",
                                        "§f - " + NumberFormatter.SIMPLE_FORMATTER.formatNumber(user.getDeposited())
                                )
                                .build()
                ))
                .shapeReplacement('_', new ItemButton(
                        Item.builder()
                                .type(Material.BARRIER)
                                .displayName("§cBack")
                                .build(),
                        event -> new MainInventory(user).show(event.getWhoClicked())
                ))
                .nextPage(NEXT_PAGE)
                .previousPage(PREVIOUS_PAGE)
                .build().show(player);
    }
}
