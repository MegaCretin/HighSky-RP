package fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class KEY {

    public static ItemStack CommunKey(int Amount){
        ItemStack it = new ItemStack(Material.TRIPWIRE_HOOK, Amount);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§bClé §lCOMMUNE");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }
    public static ItemStack CommunKeyCheck(){
        ItemStack it = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§bClé §lCOMMUNE");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }
    public static ItemStack RareKey(int Amount){
        ItemStack it = new ItemStack(Material.TRIPWIRE_HOOK, Amount);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§cClé §lRARE");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }
    public static ItemStack RareKeyCheck(){
        ItemStack it = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§cClé §lRARE");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }
    public static ItemStack LegKey(int Amount){
        ItemStack it = new ItemStack(Material.TRIPWIRE_HOOK, Amount);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§6Clé §lLEGENDAIRE");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }
    public static ItemStack LegKeyCheck(){
        ItemStack it = new ItemStack(Material.TRIPWIRE_HOOK);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§6Clé §lLEGENDAIRE");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("", "§7[§fi§7]","  §7Pour utilisé cette clé faites","  §7la commande §f/Spawn§7 et","  §7regardez dèrriere vous."));
        it.setItemMeta(itx);
        return it;
    }

}
