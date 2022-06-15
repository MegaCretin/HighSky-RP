package fr.highsky.roleplay.Events.LootsBoxs.Utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Base64;
import java.util.UUID;

public class LootsBoxs {

    public static ItemStack CommunBox(int Amount){

        ItemStack it = new ItemStack(Material.PLAYER_HEAD, Amount);
        SkullMeta itemMeta = (SkullMeta) it.getItemMeta();
        itemMeta.setDisplayName("§8§l» §b§lLootBox Commune §8§l«");
        String url = "http://textures.minecraft.net/texture/cdbca4b69eaf8dcb7ac3728228de8a64440787013342ddaabc1b00eeb8eec1e2";
        itemMeta.setLore(Arrays.asList(""," §f§l→ §7Rareté: §bCommune","","§7Pour utilisé cette loot box posez la","§7part terre."));
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try
        {
            profileField = itemMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(itemMeta, profile);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        it.setItemMeta(itemMeta);

        return it;
    }

    public static ItemStack RareBox(int Amount){

        ItemStack it = new ItemStack(Material.PLAYER_HEAD, Amount);
        SkullMeta itemMeta = (SkullMeta) it.getItemMeta();
        itemMeta.setDisplayName("§8§l» §c§lLootBox Rare §8§l«");
        String url = "http://textures.minecraft.net/texture/bd95e00f165161d4c22bd40875a598aae2d5241a0ea68e50383b016711b76210";
        itemMeta.setLore(Arrays.asList(""," §f§l→ §7Rareté: §cRare","","§7Pour utilisé cette loot box posez la","§7part terre."));
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try
        {
            profileField = itemMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(itemMeta, profile);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        it.setItemMeta(itemMeta);

        return it;
    }

    public static ItemStack LegBox(int Amount){

        ItemStack it = new ItemStack(Material.PLAYER_HEAD, Amount);
        SkullMeta itemMeta = (SkullMeta) it.getItemMeta();
        itemMeta.setDisplayName("§8§l» §6§lLootBox Légendaire §8§l«");
        String url = "http://textures.minecraft.net/texture/185594b78e8fb3e3bd7ce3ce2bfa94f138a9ebc1baed679aebf5f63d1961c8de";
        itemMeta.setLore(Arrays.asList(""," §f§l→ §7Rareté: §6Légendaire","","§7Pour utilisé cette loot box posez la","§7part terre."));
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;
        try
        {
            profileField = itemMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(itemMeta, profile);
        }
        catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        it.setItemMeta(itemMeta);

        return it;
    }

}
