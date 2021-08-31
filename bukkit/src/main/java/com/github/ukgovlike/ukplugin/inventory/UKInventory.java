package com.github.ukgovlike.ukplugin.inventory;

import com.github.ukgovlike.ukplugin.api.Bank;
import com.github.ukgovlike.ukplugin.api.User;
import com.wizardlybump17.wlib.inventory.paginated.PaginatedInventoryBuilder;
import lombok.Data;
import org.bukkit.entity.HumanEntity;

@Data
abstract class UKInventory {

    protected final Bank bank;
    protected final User user;

    public abstract PaginatedInventoryBuilder getBuilder();

    public void show(HumanEntity player) {
        getBuilder()
                .title("UK Bank")
                .build().show(player);
    }
}
