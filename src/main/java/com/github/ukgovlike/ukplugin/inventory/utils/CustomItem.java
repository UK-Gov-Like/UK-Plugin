package com.github.ukgovlike.ukplugin.inventory.utils;

import com.github.ukgovlike.ukplugin.UKPlugin;
import lombok.Getter;
import lombok.NonNull;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.lang.reflect.Field;
import java.util.*;

@Getter
public class CustomItem {

    private static final Enchantment glow = new Enchantment(new NamespacedKey(UKPlugin.getInstance(), "glow")) {
        @Override
        public String getName() {
            return "GLOW";
        }

        @Override
        public int getMaxLevel() {
            return Integer.MAX_VALUE;
        }

        @Override
        public int getStartLevel() {
            return 0;
        }

        @Override
        public EnchantmentTarget getItemTarget() {
            return null;
        }

        @Override
        public boolean isTreasure() {
            return false;
        }

        @Override
        public boolean isCursed() {
            return false;
        }

        @Override
        public boolean conflictsWith(Enchantment enchantment) {
            return false;
        }

        @Override
        public boolean canEnchantItem(ItemStack itemStack) {
            return true;
        }
    };

    static {
        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null, true);
            Enchantment.registerEnchantment(glow);
        } catch (Exception ignored) {
        }
    }

    private final ItemStack itemStack;

    public CustomItem(@NonNull Material material) {
        itemStack = new ItemStack(material);
    }

    public CustomItem(@NonNull Material material, int amount) {
        this(material);
        itemStack.setAmount(amount);
    }

    public CustomItem(@NonNull ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public CustomItem setType(@NonNull Material type) {
        itemStack.setType(type);
        return this;
    }

    public CustomItem setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public CustomItem setItemMeta(@NonNull ItemMeta itemMeta) {
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public CustomItem setDisplayName(String displayName) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.setDisplayName(displayName);
        return setItemMeta(itemMeta);
    }

    public CustomItem setLore(List<String> lore) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.setLore(lore);
        return setItemMeta(itemMeta);
    }

    public CustomItem setLore(String... lore) {
        return setLore(Arrays.asList(lore));
    }

    public CustomItem hideAttributes(boolean hide) {
        ItemMeta itemMeta = getItemMeta();
        if (hide) {
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            return setItemMeta(itemMeta);
        }
        if (itemMeta.hasItemFlag(ItemFlag.HIDE_ATTRIBUTES)) {
            itemMeta.removeItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            return setItemMeta(itemMeta);
        }
        return this;
    }

    public CustomItem setGlow(boolean set) {
        if (set) return addUnsafeEnchantment(glow, 1);
        return removeEnchantment(glow);
    }

    public CustomItem addEnchantment(@NonNull Enchantment enchantment, int level) {
        itemStack.addEnchantment(enchantment, level);
        return this;
    }

    public CustomItem addEnchantments(@NonNull Map<Enchantment, Integer> enchantments) {
        itemStack.addEnchantments(enchantments);
        return this;
    }

    public CustomItem addUnsafeEnchantment(@NonNull Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public CustomItem addUnsafeEnchantments(@NonNull Map<Enchantment, Integer> enchantments) {
        itemStack.addUnsafeEnchantments(enchantments);
        return this;
    }

    public CustomItem removeEnchantment(@NonNull Enchantment enchantment) {
        itemStack.removeEnchantment(enchantment);
        return this;
    }

    public ItemMeta getItemMeta() {
        return itemStack.getItemMeta();
    }

    public boolean containsEnchantment(@NonNull Enchantment enchantment) {
        return itemStack.containsEnchantment(enchantment);
    }

    public CustomItem setUnbreakable(boolean unbreakable) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.setUnbreakable(unbreakable);
        return setItemMeta(itemMeta);
    }

    public boolean isUnbreakable() {
        return getItemMeta().isUnbreakable();
    }

    public String getDisplayName() {
        return getItemMeta().getDisplayName();
    }

    public List<String> getLore() {
        return getItemMeta().getLore();
    }

    public boolean hasGlow() {
        return containsEnchantment(glow);
    }

    public boolean hasHiddenAttributes() {
        return getItemMeta().hasItemFlag(ItemFlag.HIDE_ATTRIBUTES);
    }

    public int getAmount() {
        return itemStack.getAmount();
    }

    public CustomItem setLeatherArmorColor(@NonNull Color color) {
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) getItemMeta();
        itemMeta.setColor(color);
        return setItemMeta(itemMeta);
    }

    public static CustomItem fromItemStack(@NonNull ItemStack itemStack) {
        return new CustomItem(itemStack);
    }
}
