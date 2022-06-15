package fr.highsky.roleplay.Utils;

import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class GET_RANDOM_BM_ITEM {

    public static void setItem(){
        Random r = new Random();
        int locate = 9;
        int alea = 1 + r.nextInt(locate);

        if(alea == 1){
            Main.getInstance().getConfig().set("BlackMarket.Number", 1);
            Main.getInstance().getConfig().set("BlackMarket.Price", 15000);
            Main.getInstance().getConfig().set("BlackMarket.Stock", 10);
        }else if(alea == 2){
            Main.getInstance().getConfig().set("BlackMarket.Number", 2);
            Main.getInstance().getConfig().set("BlackMarket.Price", 85000);
            Main.getInstance().getConfig().set("BlackMarket.Stock", 5);
        }else if(alea == 3){
            Main.getInstance().getConfig().set("BlackMarket.Number", 3);
            Main.getInstance().getConfig().set("BlackMarket.Price", 300000);
            Main.getInstance().getConfig().set("BlackMarket.Stock", 5);
        }else if(alea == 4){
            Main.getInstance().getConfig().set("BlackMarket.Number", 4);
            Main.getInstance().getConfig().set("BlackMarket.Price", 75000);
            Main.getInstance().getConfig().set("BlackMarket.Stock", 10);
        }else if(alea == 5){
            Main.getInstance().getConfig().set("BlackMarket.Number", 5);
            Main.getInstance().getConfig().set("BlackMarket.Price", 500);
            Main.getInstance().getConfig().set("BlackMarket.Stock", 25);
        }else if(alea == 6){
            Main.getInstance().getConfig().set("BlackMarket.Number", 6);
            Main.getInstance().getConfig().set("BlackMarket.Price", 100000);
            Main.getInstance().getConfig().set("BlackMarket.Stock", 5);
        }else if(alea == 7){
            Main.getInstance().getConfig().set("BlackMarket.Number", 7);
            Main.getInstance().getConfig().set("BlackMarket.Price", 150000);
            Main.getInstance().getConfig().set("BlackMarket.Stock", 2);
        }else if(alea == 8){
            Main.getInstance().getConfig().set("BlackMarket.Number", 8);
            Main.getInstance().getConfig().set("BlackMarket.Price", 25000);
            Main.getInstance().getConfig().set("BlackMarket.Stock", 10);
        }else if(alea == 9){
            Main.getInstance().getConfig().set("BlackMarket.Number", 9);
            Main.getInstance().getConfig().set("BlackMarket.Price", 500000);
            Main.getInstance().getConfig().set("BlackMarket.Stock", 1);
        }
        Main.getInstance().saveConfig();
    }

    public static ItemStack getItem(Integer i){

        ItemStack it = new ItemStack(Material.WITHER_SKELETON_SKULL, 1);

        if(i == 1){
            it.setType(Material.WITHER_SKELETON_SKULL);
        }
        else if(i == 2){
            it.setType(Material.NETHER_STAR);
        }
        else if(i == 3){
            it.setType(Material.DRAGON_EGG);
        }
        else if(i == 4){
            it.setType(Material.MAGMA_BLOCK);
            it.setAmount(64);
        }
        else if(i == 5){
            it.setType(Material.EXPERIENCE_BOTTLE);
            it.setAmount(64);
        }
        else if(i == 6){
            it.setType(Material.WITHER_ROSE);
        }
        else if(i == 7){
            it.setType(Material.VILLAGER_SPAWN_EGG);
        }
        else if(i == 8){
            it.setType(Material.TURTLE_EGG);
        }
        else if(i == 9){
            it.setType(Material.END_PORTAL_FRAME);
        }
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§8§l» §c§lVENTE LIMITÉ §8§l«");
        itx.setLore(Arrays.asList("§e","  §3§lPrix: §e"+Main.getInstance().getConfig().getInt("BlackMarket.Price"),"  §3§lStock restant: §e"+Main.getInstance().getConfig().getInt("BlackMarket.Stock"),"§e","§f§lClique pour acheter."));
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        it.setItemMeta(itx);

        return it;
    }

}
