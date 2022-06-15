package fr.highsky.roleplay.Equipement.Stuff;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class TOOLS {

    public static ItemStack Tools(Material material, String name, List lore, int Efficiency, int Unbreaking, int Fortune, int SilkTouch,int Durabillity,int Luck_Of_The_Sea ,int Lure ,Boolean Curse_Of_Vanishing, Boolean Mending,Boolean Unbreakable){

        ItemStack it = new ItemStack(material);
        ItemMeta itx = it.getItemMeta();
        if(it instanceof Damageable){
            ((Damageable) itx).setDamage(it.getType().getMaxDurability() - Durabillity);
        }
        itx.setDisplayName(name);
        itx.setLore(lore);
        //Arrays.asList("§e","  §f§l► §7Efficacité: §9+1","  §f§l► §7Vitesse: §9+1","§e","§7Rareté: §e☆§7☆☆☆☆")
        itx.addEnchant(Enchantment.DIG_SPEED, Efficiency, true);
        itx.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, Fortune, true);
        itx.addEnchant(Enchantment.DURABILITY, Unbreaking, true);
        itx.addEnchant(Enchantment.SILK_TOUCH, SilkTouch, true);
        itx.addEnchant(Enchantment.LUCK, Luck_Of_The_Sea, true);
        itx.addEnchant(Enchantment.LURE, Lure, true);
        itx.addEnchant(Enchantment.MENDING, 1, Mending);
        itx.addEnchant(Enchantment.VANISHING_CURSE, 1, Curse_Of_Vanishing);
        itx.setUnbreakable(Unbreakable);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itx.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        it.setItemMeta(itx);
        return it;

    }

    public static ItemStack Sword(Material material, String name, List lore, int Durabillity, int Unbreaking, int Sharpness, int Smite, int Bane_of_Arthropods,int KnockBack ,int Fire_Aspect , int Looting,int Sweeping_Edge, Boolean Curse_Of_Vanishing, Boolean Mending,Boolean Unbreakable){

        ItemStack it = new ItemStack(material);
        ItemMeta itx = it.getItemMeta();
        if(it instanceof Damageable){
            ((Damageable) itx).setDamage(it.getType().getMaxDurability() - Durabillity);
        }
        itx.setDisplayName(name);
        itx.setLore(lore);
        //Arrays.asList("§e","  §f§l► §7Efficacité: §9+1","  §f§l► §7Vitesse: §9+1","§e","§7Rareté: §e☆§7☆☆☆☆")
        itx.addEnchant(Enchantment.DAMAGE_ALL, Sharpness, true);
        itx.addEnchant(Enchantment.DAMAGE_UNDEAD, Smite, true);
        itx.addEnchant(Enchantment.DURABILITY, Unbreaking, true);
        itx.addEnchant(Enchantment.DAMAGE_ARTHROPODS, Bane_of_Arthropods, true);
        itx.addEnchant(Enchantment.KNOCKBACK, KnockBack, true);
        itx.addEnchant(Enchantment.FIRE_ASPECT, Fire_Aspect, true);
        itx.addEnchant(Enchantment.LOOT_BONUS_MOBS, Looting, true);
        itx.addEnchant(Enchantment.SWEEPING_EDGE, Sweeping_Edge, true);
        itx.addEnchant(Enchantment.MENDING, 1, Mending);
        itx.addEnchant(Enchantment.VANISHING_CURSE, 1, Curse_Of_Vanishing);
        itx.setUnbreakable(Unbreakable);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itx.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        it.setItemMeta(itx);
        return it;

    }

    public static ItemStack Arc(Material material, String name, List lore, int Durabillity, int Unbreaking, int Power, int Punch, int Flame,int Infinity, Boolean Curse_Of_Vanishing, Boolean Mending,Boolean Unbreakable){

        ItemStack it = new ItemStack(material);
        ItemMeta itx = it.getItemMeta();
        if(it instanceof Damageable){
            ((Damageable) itx).setDamage(it.getType().getMaxDurability() - Durabillity);
        }
        itx.setDisplayName(name);
        itx.setLore(lore);
        //Arrays.asList("§e","  §f§l► §7Efficacité: §9+1","  §f§l► §7Vitesse: §9+1","§e","§7Rareté: §e☆§7☆☆☆☆")
        itx.addEnchant(Enchantment.ARROW_DAMAGE, Power, true);
        itx.addEnchant(Enchantment.ARROW_KNOCKBACK, Punch, true);
        itx.addEnchant(Enchantment.DURABILITY, Unbreaking, true);
        itx.addEnchant(Enchantment.ARROW_FIRE, Flame, true);
        itx.addEnchant(Enchantment.ARROW_INFINITE, Infinity, true);
        itx.addEnchant(Enchantment.MENDING, 1, Mending);
        itx.addEnchant(Enchantment.VANISHING_CURSE, 1, Curse_Of_Vanishing);
        itx.setUnbreakable(Unbreakable);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itx.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        it.setItemMeta(itx);
        return it;

    }

    public static ItemStack Trident(Material material, String name, List lore, int Durabillity, int Unbreaking, int Loyalty, int Impaling, int Riptide,int Channeling, Boolean Curse_Of_Vanishing, Boolean Mending,Boolean Unbreakable){

        ItemStack it = new ItemStack(material);
        ItemMeta itx = it.getItemMeta();
        if(it instanceof Damageable){
            ((Damageable) itx).setDamage(it.getType().getMaxDurability() - Durabillity);
        }
        itx.setDisplayName(name);
        itx.setLore(lore);
        //Arrays.asList("§e","  §f§l► §7Efficacité: §9+1","  §f§l► §7Vitesse: §9+1","§e","§7Rareté: §e☆§7☆☆☆☆")
        itx.addEnchant(Enchantment.LOYALTY, Loyalty, true);
        itx.addEnchant(Enchantment.IMPALING, Impaling, true);
        itx.addEnchant(Enchantment.DURABILITY, Unbreaking, true);
        itx.addEnchant(Enchantment.RIPTIDE, Riptide, true);
        itx.addEnchant(Enchantment.CHANNELING, Channeling, true);
        itx.addEnchant(Enchantment.MENDING, 1, Mending);
        itx.addEnchant(Enchantment.VANISHING_CURSE, 1, Curse_Of_Vanishing);
        itx.setUnbreakable(Unbreakable);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itx.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        it.setItemMeta(itx);
        return it;

    }

    public static ItemStack CrossBow(Material material, String name, List lore, int Durabillity, int Unbreaking, int Multishot, int Piercing, int Quick_Charge, Boolean Curse_Of_Vanishing, Boolean Mending,Boolean Unbreakable){

        ItemStack it = new ItemStack(material);
        ItemMeta itx = it.getItemMeta();
        if(it instanceof Damageable){
            ((Damageable) itx).setDamage(it.getType().getMaxDurability() - Durabillity);
        }
        itx.setDisplayName(name);
        itx.setLore(lore);
        //Arrays.asList("§e","  §f§l► §7Efficacité: §9+1","  §f§l► §7Vitesse: §9+1","§e","§7Rareté: §e☆§7☆☆☆☆")
        itx.addEnchant(Enchantment.MULTISHOT, Multishot, true);
        itx.addEnchant(Enchantment.PIERCING, Piercing, true);
        itx.addEnchant(Enchantment.DURABILITY, Unbreaking, true);
        itx.addEnchant(Enchantment.QUICK_CHARGE, Quick_Charge, true);
        itx.addEnchant(Enchantment.MENDING, 1, Mending);
        itx.addEnchant(Enchantment.VANISHING_CURSE, 1, Curse_Of_Vanishing);
        itx.setUnbreakable(Unbreakable);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itx.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        it.setItemMeta(itx);
        return it;

    }


    @EventHandler
    public void Anvil(PrepareAnvilEvent e){

        e.getInventory().setRepairCost(-1);

    }


    //public static ItemStack

}
