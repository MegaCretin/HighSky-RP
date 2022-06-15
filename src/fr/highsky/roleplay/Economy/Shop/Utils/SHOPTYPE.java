package fr.highsky.roleplay.Economy.Shop.Utils;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Utils.INV_CREATOR;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class SHOPTYPE {

    public static void shopOre(Player p){
        File folder = new File("plugins/HighSky-RP/");
        File file = new File(folder, "ConfigShop.yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration config = updateFile();
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §eMinerais");
        addStyle(inv);
        for (String string : conf.getConfigurationSection("Ore.").getKeys(true)) {
            String s1 = conf.getString("Ore." + string);
            String[] items = s1.split("/");
            ItemStack is1 = new ItemStack(Material.getMaterial(items[0].toUpperCase()), 1);

            ItemMeta is1x = is1.getItemMeta();

            is1x.setDisplayName("§7§l§m   §e§l{ §b§l"+string+" §e§l}§7§m§l   ");


            if (items[2].equals("0")) {
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[3])), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
            } else if(items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas vendable.", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┗                ━━━━━━"}));
            } else if (!items[2].equals("0") && !items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(Double.valueOf(items[3])),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
            }
            is1.setItemMeta(is1x);
            inv.setItem(Integer.valueOf(items[4]).intValue() - 1, is1);
        }
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("§3Argent: §e"+ MoneyAPI.getMoney(p)+"§a$");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        p.openInventory(inv);
        p.updateInventory();
    }

    public static void shopBlocks(Player p){
        File folder = new File("plugins/HighSky-RP/");
        File file = new File(folder, "ConfigShop.yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration config = updateFile();
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §3Blocks");
        addStyle(inv);
        for (String string : conf.getConfigurationSection("Blocks.").getKeys(true)) {
            String s1 = conf.getString("Blocks." + string);
            String[] items = s1.split("/");
            ItemStack is1 = new ItemStack(Material.getMaterial(items[0].toUpperCase()), 1);

            ItemMeta is1x = is1.getItemMeta();

            is1x.setDisplayName("§7§l§m   §e§l{ §b§l"+string+" §e§l}§7§m§l   ");


            if (items[2].equals("0")) {
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[3])), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
            } else if(items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas vendable.", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┗                ━━━━━━"}));
            } else if (!items[2].equals("0") && !items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(Double.valueOf(items[3])),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
            }
            is1.setItemMeta(is1x);
            inv.setItem(Integer.valueOf(items[4]).intValue() - 1, is1);
        }
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("§3Argent: §e"+ MoneyAPI.getMoney(p)+"§a$");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        p.openInventory(inv);
        p.updateInventory();
    }


    public static void shopWild(Player p){
        File folder = new File("plugins/HighSky-RP/");
        File file = new File(folder, "ConfigShop.yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration config = updateFile();
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §aNature");
        addStyle(inv);
        for (String string : conf.getConfigurationSection("Wild.").getKeys(true)) {
            String s1 = conf.getString("Wild." + string);
            String[] items = s1.split("/");
            ItemStack is1 = new ItemStack(Material.getMaterial(items[0].toUpperCase()), 1);

            ItemMeta is1x = is1.getItemMeta();

            is1x.setDisplayName("§7§l§m   §e§l{ §b§l"+string+" §e§l}§7§m§l   ");


            if (items[2].equals("0")) {
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[3])), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
            } else if(items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas vendable.", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┗                ━━━━━━"}));
            } else if (!items[2].equals("0") && !items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(Double.valueOf(items[3])),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
            }
            is1.setItemMeta(is1x);
            inv.setItem(Integer.valueOf(items[4]).intValue() - 1, is1);
        }
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("§3Argent: §e"+ MoneyAPI.getMoney(p)+"§a$");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        p.openInventory(inv);
        p.updateInventory();
    }


    public static void shopEat(Player p){
        File folder = new File("plugins/HighSky-RP/");
        File file = new File(folder, "ConfigShop.yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration config = updateFile();
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» Nourriture");
        addStyle(inv);
        for (String string : conf.getConfigurationSection("Eat.").getKeys(true)) {
            String s1 = conf.getString("Eat." + string);
            String[] items = s1.split("/");
            ItemStack is1 = new ItemStack(Material.getMaterial(items[0].toUpperCase()), 1);

            ItemMeta is1x = is1.getItemMeta();

            is1x.setDisplayName("§7§l§m   §e§l{ §b§l"+string+" §e§l}§7§m§l   ");


            if (items[2].equals("0")) {
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[3])), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
            } else if(items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas vendable.", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┗                ━━━━━━"}));
            } else if (!items[2].equals("0") && !items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(Double.valueOf(items[3])),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
            }
            is1.setItemMeta(is1x);
            inv.setItem(Integer.valueOf(items[4]).intValue() - 1, is1);
        }
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("§3Argent: §e"+ MoneyAPI.getMoney(p)+"§a$");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        p.openInventory(inv);
        p.updateInventory();
    }


    public static void shopLoots(Player p){
        File folder = new File("plugins/HighSky-RP/");
        File file = new File(folder, "ConfigShop.yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration config = updateFile();
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §5Loots");
        addStyle(inv);
        for (String string : conf.getConfigurationSection("Loots.").getKeys(true)) {
            String s1 = conf.getString("Loots." + string);
            String[] items = s1.split("/");
            ItemStack is1 = new ItemStack(Material.getMaterial(items[0].toUpperCase()), 1);

            ItemMeta is1x = is1.getItemMeta();

            is1x.setDisplayName("§7§l§m   §e§l{ §b§l"+string+" §e§l}§7§m§l   ");


            if (items[2].equals("0")) {
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[3])), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
            } else if(items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas vendable.", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┗                ━━━━━━"}));
            } else if (!items[2].equals("0") && !items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(Double.valueOf(items[3])),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
            }
            is1.setItemMeta(is1x);
            inv.setItem(Integer.valueOf(items[4]).intValue() - 1, is1);
        }
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("§3Argent: §e"+ MoneyAPI.getMoney(p)+"§a$");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        p.openInventory(inv);
        p.updateInventory();
    }


    public static void shopWorld(Player p){
        File folder = new File("plugins/HighSky-RP/");
        File file = new File(folder, "ConfigShop.yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration config = updateFile();
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §9World");
        addStyle(inv);
        for (String string : conf.getConfigurationSection("World.").getKeys(true)) {
            String s1 = conf.getString("World." + string);
            String[] items = s1.split("/");
            ItemStack is1 = new ItemStack(Material.getMaterial(items[0].toUpperCase()), 1);

            ItemMeta is1x = is1.getItemMeta();

            is1x.setDisplayName("§7§l§m   §e§l{ §b§l"+string+" §e§l}§7§m§l   ");


            if (items[2].equals("0")) {
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[3])), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
            } else if(items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas vendable.", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┗                ━━━━━━"}));
            } else if (!items[2].equals("0") && !items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(Double.valueOf(items[3])),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
            }
            is1.setItemMeta(is1x);
            inv.setItem(Integer.valueOf(items[4]).intValue() - 1, is1);
        }
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("§3Argent: §e"+ MoneyAPI.getMoney(p)+"§a$");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        p.openInventory(inv);
        p.updateInventory();
    }

    public static void shopOther(Player p){
        File folder = new File("plugins/HighSky-RP/");
        File file = new File(folder, "ConfigShop.yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration config = updateFile();
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §2Divers");
        addStyle(inv);
        for (String string : conf.getConfigurationSection("Other.").getKeys(true)) {
            String s1 = conf.getString("Other." + string);
            String[] items = s1.split("/");
            ItemStack is1 = new ItemStack(Material.getMaterial(items[0].toUpperCase()), 1);

            ItemMeta is1x = is1.getItemMeta();

            is1x.setDisplayName("§7§l§m   §e§l{ §b§l"+string+" §e§l}§7§m§l   ");


            if (items[2].equals("0")) {
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[3])), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
            } else if(items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas vendable.", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┗                ━━━━━━"}));
            } else if (!items[2].equals("0") && !items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(Double.valueOf(items[3])),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
            }
            is1.setItemMeta(is1x);
            inv.setItem(Integer.valueOf(items[4]).intValue() - 1, is1);
        }
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("§3Argent: §e"+ MoneyAPI.getMoney(p)+"§a$");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        p.openInventory(inv);
        p.updateInventory();
    }

    public static void shopCoral(Player p){
        File folder = new File("plugins/HighSky-RP/");
        File file = new File(folder, "ConfigShop.yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration config = updateFile();
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §dCorails");
        addStyle(inv);
        for (String string : conf.getConfigurationSection("Coral.").getKeys(true)) {
            String s1 = conf.getString("Coral." + string);
            String[] items = s1.split("/");
            ItemStack is1 = new ItemStack(Material.getMaterial(items[0].toUpperCase()), 1);

            ItemMeta is1x = is1.getItemMeta();

            is1x.setDisplayName("§7§l§m   §e§l{ §b§l"+string+" §e§l}§7§m§l   ");


            if (items[2].equals("0")) {
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[3])), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
            } else if(items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas vendable.", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┗                ━━━━━━"}));
            } else if (!items[2].equals("0") && !items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(Double.valueOf(items[3])),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
            }
            is1.setItemMeta(is1x);
            inv.setItem(Integer.valueOf(items[4]).intValue() - 1, is1);
        }
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("§3Argent: §e"+ MoneyAPI.getMoney(p)+"§a$");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        p.openInventory(inv);
        p.updateInventory();
    }


    public static void shopCaverne(Player p){
        File folder = new File("plugins/HighSky-RP/");
        File file = new File(folder, "ConfigShop.yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration config = updateFile();
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §7Caverne");
        addStyle(inv);
        for (String string : conf.getConfigurationSection("Caverne.").getKeys(true)) {
            String s1 = conf.getString("Caverne." + string);
            String[] items = s1.split("/");
            ItemStack is1 = new ItemStack(Material.getMaterial(items[0].toUpperCase()), 1);

            ItemMeta is1x = is1.getItemMeta();

            is1x.setDisplayName("§7§l§m   §e§l{ §b§l"+string+" §e§l}§7§m§l   ");


            if (items[2].equals("0")) {
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[3])), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
            } else if(items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas vendable.", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┗                ━━━━━━"}));
            } else if (!items[2].equals("0") && !items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(Double.valueOf(items[3])),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
            }
            is1.setItemMeta(is1x);
            inv.setItem(Integer.valueOf(items[4]).intValue() - 1, is1);
        }
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("§3Argent: §e"+ MoneyAPI.getMoney(p)+"§a$");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        p.openInventory(inv);
        p.updateInventory();
    }

    public static void shopFleur(Player p){
        File folder = new File("plugins/HighSky-RP/");
        File file = new File(folder, "ConfigShop.yml");
        YamlConfiguration conf = YamlConfiguration.loadConfiguration(file);
        YamlConfiguration config = updateFile();
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §eFleurs");
        addStyle(inv);
        for (String string : conf.getConfigurationSection("Fleur.").getKeys(true)) {
            String s1 = conf.getString("Fleur." + string);
            String[] items = s1.split("/");
            ItemStack is1 = new ItemStack(Material.getMaterial(items[0].toUpperCase()), 1);

            ItemMeta is1x = is1.getItemMeta();

            is1x.setDisplayName("§7§l§m   §e§l{ §b§l"+string+" §e§l}§7§m§l   ");


            if (items[2].equals("0")) {
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[3])), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
            } else if(items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas vendable.", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┗                ━━━━━━"}));
            } else if (!items[2].equals("0") && !items[3].equals("0")){
                is1x.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(Double.valueOf(items[2])), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(Double.valueOf(items[3])),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
            }
            is1.setItemMeta(is1x);
            inv.setItem(Integer.valueOf(items[4]).intValue() - 1, is1);
        }
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("§3Argent: §e"+ MoneyAPI.getMoney(p)+"§a$");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        p.openInventory(inv);
        p.updateInventory();
    }


    public static void saleShop(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §6Promotions");
        addStyle(inv);
        ItemStack money = new ItemStack(Material.GOLD_NUGGET);
        ItemMeta moneyx = money.getItemMeta();
        moneyx.setDisplayName("+ MoneyAPI.getMoney(p) + ");
        money.setItemMeta(moneyx);
        inv.setItem(4, money);
        addSaleItem("Blocks", inv, 20);
        addSaleItem("Eat", inv, 21);
        addSaleItem("Ore", inv, 22);
        addSaleItem("Loots", inv, 23);
        addSaleItem("Coral", inv, 24);
        addSaleItem("World", inv, 30);
        addSaleItem("Other", inv, 31);
        addSaleItem("Wild", inv, 32);
        p.openInventory(inv);
    }

    public static ItemStack addSaleItem(String type, Inventory inv, int Slot) {
        ItemStack it = new ItemStack(Material.getMaterial(Main.getInstance().getConfig().getString("Sale." + type).toUpperCase()));
        ItemMeta itx = it.getItemMeta();
        Double achat = Double.valueOf(ShopTools.checkPrice(it).doubleValue() - ShopTools.checkPrice(it).doubleValue() * 30.0D / 100.0D);
        Double vente = Double.valueOf(ShopTools.checkSellPrice(it).doubleValue() * 1.2D);

        if (achat.doubleValue() == 0.0D) {
            itx.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l" + soldReturn(vente.doubleValue()), "§f┣                ━━━━━━","§f┃ §e§lInformations§f§l: ", "§f┃   §7[§c§l✘§7]§cCet item n'est pas achetable.", "§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━"}));
        } else{
            itx.setLore(Arrays.asList(new String[]{"§f┏                ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §b§l" + soldReturn(achat.doubleValue()), "§f┣                ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §b§l"  + soldReturn(vente.doubleValue()),"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §lgauche§r§a pour acheté","§f┃   §7[§a✔§7]§cClique §ldroit§r§c pour vendre","§f┃   §7[§a✔§7]§cClique §lmolette§r§c pour tous vendre.","§f┗                ━━━━━━" }));
        }

        it.setItemMeta(itx);
        inv.setItem(Slot, it);
        return it;
    }

    public static void shopDeco(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "§bShop §8» §dDécorations");
        addStyle(inv);
        INV_CREATOR.newItem(inv, 20, Material.BRAIN_CORAL, Integer.valueOf(1), "§bShop §8» §dCorails", Arrays.asList("§7","§7Clique gauche pour ouvrir","§7la catégorie."));
        INV_CREATOR.newItem(inv, 24, Material.LARGE_AMETHYST_BUD, Integer.valueOf(1), "§bShop §8» §7Caverne", Arrays.asList("§7","§7Clique gauche pour ouvrir","§7la catégorie."));
        INV_CREATOR.newItem(inv, 31, Material.OXEYE_DAISY, Integer.valueOf(1), "§bShop §8» §eFleurs", Arrays.asList("§7","§7Clique gauche pour ouvrir","§7la catégorie."));
        p.openInventory(inv);
    }

    private static YamlConfiguration updateFile(){
        File file = new File( "plugins/HighSky-RP/DataShop.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config;
    }

    public static void addStyle(Inventory inv){

        ItemStack it = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§e");
        itx.setLore(Arrays.asList("§e"));
        it.setItemMeta(itx);

        ItemStack it1 = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta it1x = it1.getItemMeta();
        it1x.setDisplayName("§e");
        it1x.setLore(Arrays.asList("§e"));
        it1.setItemMeta(it1x);

        for(int i=0; i<54; i++){
            inv.setItem(i, it1);
        }

        inv.setItem(0, it);
        inv.setItem(1, it);
        inv.setItem(7, it);
        inv.setItem(8, it);
        inv.setItem(9, it);
        inv.setItem(17, it);
        inv.setItem(36, it);
        inv.setItem(44, it);
        inv.setItem(45, it);
        inv.setItem(46, it);
        inv.setItem(52, it);
        inv.setItem(53, it);

    }

    public static String soldReturn(double i) {
        return NumberFormat.getCurrencyInstance(new Locale("US", "us")).format(i).replace("$", "").replace(",","").replace(".00", "").replace("US", "").replaceAll("[^\\p{Punct}\\w]","").replace("D","");
    }

    public static String returnSold(String s) {
        String rs = String.valueOf(s).replace(",", "");
        return rs;
    }

}
