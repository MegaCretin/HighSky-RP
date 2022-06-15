package fr.highsky.roleplay.Events.Boxs.XPBoxs;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class XP_BOXS_KEY {

    public static ItemStack XP75Key(int Amount) {
        ItemStack it = new ItemStack(Material.SUNFLOWER, Amount);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§7§l» §aClé: §fXP75 §7§l«");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }

    public static ItemStack XP75KeyCheck() {
        ItemStack it = new ItemStack(Material.SUNFLOWER);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§7§l» §aClé: §fXP75 §7§l«");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }

    public static ItemStack XP150Key(int Amount) {
        ItemStack it = new ItemStack(Material.SUNFLOWER, Amount);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§7§l» §eClé: §fXP150 §7§l«");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }

    public static ItemStack XP150KeyCheck() {
        ItemStack it = new ItemStack(Material.SUNFLOWER);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§7§l» §eClé: §fXP150 §7§l«");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }

    public static ItemStack XP300Key(int Amount) {
        ItemStack it = new ItemStack(Material.SUNFLOWER, Amount);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§7§l» §6Clé: §fXP300 §7§l«");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }

    public static ItemStack XP300KeyCheck() {
        ItemStack it = new ItemStack(Material.SUNFLOWER);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§7§l» §6Clé: §fXP300 §7§l«");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }
}
