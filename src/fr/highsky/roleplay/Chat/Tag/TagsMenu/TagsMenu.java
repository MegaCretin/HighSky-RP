package fr.highsky.roleplay.Chat.Tag.TagsMenu;


import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import fr.highsky.roleplay.Utils.INV_CREATOR;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.*;

import static org.bukkit.Material.PLAYER_HEAD;

public class TagsMenu implements CommandExecutor {
    public TagsMenu() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        Player p = (Player)sender;
        Inventory inv = Bukkit.createInventory(null, 54, "§aTags §7§l» §bAccueil");

        for(int i=0;i<53;i++){
            ItemStack it = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            ItemMeta itx = it.getItemMeta();
            itx.setLore(Arrays.asList("§e"));
            itx.setDisplayName("§e");
            it.setItemMeta(itx);
            inv.setItem(i, it);
        }



        List<Integer> in = new ArrayList<>();
        in.add(0);
        in.add(1);
        in.add(7);
        in.add(8);
        in.add(9);
        in.add(17);
        in.add(36);
        in.add(44);
        in.add(45);
        in.add(46);
        in.add(52);
        in.add(53);

        for(int i=0; i<in.size();i++){

            ItemStack it = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
            ItemMeta itx = it.getItemMeta();
            itx.setLore(Arrays.asList("§e"));
            itx.setDisplayName("§e");
            it.setItemMeta(itx);
            inv.setItem(in.get(i), it);

        }

        INV_CREATOR.newItem(inv, 20, Material.NAME_TAG, 1, "§aTags §7§l» §b§lCommun", Arrays.asList("","§7Clique gauche pour ouvrir","§7la catégorie."));
        INV_CREATOR.newItem(inv, 22, Material.NAME_TAG, 1, "§aTags §7§l» §c§lRare", Arrays.asList("","§7Clique gauche pour ouvrir","§7la catégorie."));
        INV_CREATOR.newItem(inv, 24, Material.NAME_TAG, 1, "§aTags §7§l» §6§lLégendaire", Arrays.asList("","§7Clique gauche pour ouvrir","§7la catégorie."));

        INV_CREATOR.newItem(inv, 40, Material.WRITABLE_BOOK, 1, "§c§lReset du tag",Arrays.asList("","§7Clique gauche pour retiré le tag."));

        /*ItemStack it1 = new ItemStack(PLAYER_HEAD, 1);
        SkullMeta itemMeta1 = (SkullMeta) it1.getItemMeta();
        itemMeta1.setDisplayName("§a§lEn Jeux");
        GameProfile profile1 = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData1 = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", "http://textures.minecraft.net/texture/73c062715491b3a573b7ed10ea8f9bc19ffe19ce9b498ebb24f6f09e473e1e").getBytes());
        profile1.getProperties().put("textures", new Property("textures", new String(encodedData1)));
        Field profileField1 = null;
        try
        {
            profileField1 = itemMeta1.getClass().getDeclaredField("profile");
            profileField1.setAccessible(true);
            profileField1.set(itemMeta1, profile1);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        it1.setItemMeta(itemMeta1);
        inv.setItem(10, it1);

        ItemStack it2 = new ItemStack(PLAYER_HEAD, 1);
        SkullMeta itemMeta2 = (SkullMeta) it2.getItemMeta();
        itemMeta2.setDisplayName("§f§lCommun");
        GameProfile profile2 = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData2 = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", "http://textures.minecraft.net/texture/ac16719a34ed6e65cf21669658d4539060d4d1a2362bad3cc2de573c9ec6f2").getBytes());
        profile2.getProperties().put("textures", new Property("textures", new String(encodedData2)));
        Field profileField2 = null;
        try
        {
            profileField2 = itemMeta2.getClass().getDeclaredField("profile");
            profileField2.setAccessible(true);
            profileField2.set(itemMeta2, profile2);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        it2.setItemMeta(itemMeta2);
        inv.setItem(12, it2);

        ItemStack it3 = new ItemStack(PLAYER_HEAD, 1);
        SkullMeta itemMeta3 = (SkullMeta) it3.getItemMeta();
        itemMeta3.setDisplayName("§b§lRare");
        GameProfile profile3 = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData3 = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", "http://textures.minecraft.net/texture/d91b3d3fb72251fc686ab67b2109f8be75c628da2a4d3a8258a1715f82b6d").getBytes());
        profile3.getProperties().put("textures", new Property("textures", new String(encodedData3)));
        Field profileField3 = null;
        try
        {
            profileField3 = itemMeta3.getClass().getDeclaredField("profile");
            profileField3.setAccessible(true);
            profileField3.set(itemMeta3, profile3);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        it3.setItemMeta(itemMeta3);
        inv.setItem(13, it3);

        ItemStack it4 = new ItemStack(PLAYER_HEAD, 1);
        SkullMeta itemMeta4 = (SkullMeta) it4.getItemMeta();
        itemMeta4.setDisplayName("§c§lLegendaire");
        GameProfile profile4 = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData4 = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", "http://textures.minecraft.net/texture/6d9b1465619c42c7cb06ce1d2ce6eb84add6fc9b21a16dda23fad2480e11ff2").getBytes());
        profile4.getProperties().put("textures", new Property("textures", new String(encodedData4)));
        Field profileField4 = null;
        try
        {
            profileField4 = itemMeta4.getClass().getDeclaredField("profile");
            profileField4.setAccessible(true);
            profileField4.set(itemMeta4, profile4);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        it4.setItemMeta(itemMeta4);
        inv.setItem(14, it4);

        ItemStack it5 = new ItemStack(PLAYER_HEAD, 1);
        SkullMeta itemMeta5 = (SkullMeta) it5.getItemMeta();
        itemMeta5.setDisplayName("§d§lExclusif");
        GameProfile profile5 = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData5 = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", "http://textures.minecraft.net/texture/edee1fc3ead03ec8bba4e551d65bf3b8ed48debcffc07a4b1ac535f616e314e7").getBytes());
        profile5.getProperties().put("textures", new Property("textures", new String(encodedData5)));
        Field profileField5 = null;
        try
        {
            profileField5 = itemMeta5.getClass().getDeclaredField("profile");
            profileField5.setAccessible(true);
            profileField5.set(itemMeta5, profile5);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        it5.setItemMeta(itemMeta5);
        inv.setItem(16, it5);
        */


        p.openInventory(inv);
        return false;
    }
}
