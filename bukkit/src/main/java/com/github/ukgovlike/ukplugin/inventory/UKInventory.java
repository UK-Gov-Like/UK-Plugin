package com.github.ukgovlike.ukplugin.inventory;

import com.github.ukgovlike.ukplugin.api.User;
import com.wizardlybump17.wlib.inventory.paginated.PaginatedInventoryBuilder;
import lombok.Data;
import org.bukkit.entity.Player;

@Data
abstract class UKInventory {

    private final User user;

    public abstract PaginatedInventoryBuilder getBuilder();

    public void show(Player player) {
        getBuilder()
                .title("UK Bank")
                .build().show(player);
    }
}
