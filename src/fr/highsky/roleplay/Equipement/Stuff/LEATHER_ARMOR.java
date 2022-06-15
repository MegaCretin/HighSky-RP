package fr.highsky.roleplay.Equipement.Stuff;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class LEATHER_ARMOR implements Listener {


    public static ItemStack healthHelmet(){

        ItemStack it = new ItemStack(Material.LEATHER_HELMET);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§eCasque en cuir");
        itx.setLore(Arrays.asList("§e","  §f§l► §7Vie: §9+1","  §f§l► §7Armure: §9+1","§e","§7Rareté: §e☆§7☆☆☆☆"));
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        it.setItemMeta(itx);


        return it;
    }

    public static ItemStack healthChestplate(){

        ItemStack it = new ItemStack(Material.LEATHER_CHESTPLATE);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§ePlastron en cuir");
        itx.setLore(Arrays.asList("§e","  §f§l► §7Vie: §9+2","  §f§l► §7Armure: §9+3","§e","§7Rareté: §e☆§7☆☆☆☆"));
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        it.setItemMeta(itx);


        return it;
    }

    public static ItemStack healthLeggings(){

        ItemStack it = new ItemStack(Material.LEATHER_LEGGINGS);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§eJambière en cuir");
        itx.setLore(Arrays.asList("§e","  §f§l► §7Vie: §9+2","  §f§l► §7Armure: §9+2","§e","§7Rareté: §e☆§7☆☆☆☆"));
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        it.setItemMeta(itx);


        return it;
    }

    public static ItemStack healthBoots(){

        ItemStack it = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§eBottes en cuir");
        itx.setLore(Arrays.asList("§e","  §f§l► §7Vie: §9+1","  §f§l► §7Armure: §9+1","§e","§7Rareté: §e☆§7☆☆☆☆"));
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        it.setItemMeta(itx);


        return it;
    }



}
