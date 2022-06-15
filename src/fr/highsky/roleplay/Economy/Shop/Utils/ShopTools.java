package fr.highsky.roleplay.Economy.Shop.Utils;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.text.NumberFormat;
import java.util.Locale;

public class ShopTools {

    public static Double checkSellPrice(ItemStack it){

        Material mat = it.getType();
        short Durablility = Short.valueOf(it.getDurability());
        int Amount = it.getAmount();
        File file = new File("plugins/HighSky-RP/ConfigShop.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        Double Price = 0.00;
        if(it.hasItemMeta() && (it.getType() == Material.BLAZE_ROD)){
            return Price;
        }
        for(String st:yamlConfiguration.getConfigurationSection("Ore.").getKeys(true)){
            String ii = yamlConfiguration.getString("Ore."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[3]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Blocks.").getKeys(true)){
            String ii = yamlConfiguration.getString("Blocks."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[3]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Wild.").getKeys(true)){
            String ii = yamlConfiguration.getString("Wild."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[3]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Eat.").getKeys(true)){
            String ii = yamlConfiguration.getString("Eat."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[3]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Loots.").getKeys(true)){
            String ii = yamlConfiguration.getString("Loots."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[3]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Other.").getKeys(true)){
            String ii = yamlConfiguration.getString("Other."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[3]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Coral.").getKeys(true)){
            String ii = yamlConfiguration.getString("Coral."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[3]);
            }
        }
        return Price;
    }

    public static Double checkPrice(ItemStack it){

        Material mat = it.getType();
        short Durablility = Short.valueOf(it.getDurability());
        int Amount = it.getAmount();
        File file = new File("plugins/HighSky-RP/ConfigShop.yml");
        YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        Double Price = 0.00;
        if(it.hasItemMeta() && (it.getType() == Material.BLAZE_ROD)){
            return Price;
        }
        for(String st:yamlConfiguration.getConfigurationSection("Ore.").getKeys(true)){
            String ii = yamlConfiguration.getString("Ore."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[2]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Blocks.").getKeys(true)){
            String ii = yamlConfiguration.getString("Blocks."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[2]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Wild.").getKeys(true)){
            String ii = yamlConfiguration.getString("Wild."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[2]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Eat.").getKeys(true)){
            String ii = yamlConfiguration.getString("Eat."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[2]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Loots.").getKeys(true)){
            String ii = yamlConfiguration.getString("Loots."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[2]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Other.").getKeys(true)){
            String ii = yamlConfiguration.getString("Other."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[2]);
            }
        }
        for(String st:yamlConfiguration.getConfigurationSection("Coral.").getKeys(true)){
            String ii = yamlConfiguration.getString("Coral."+st);
            String[] split = ii.split("/");
            if(Material.getMaterial(split[0].toUpperCase()) == mat){
                Price += Amount * Double.valueOf(split[2]);
            }
        }
        return Price;
    }
    
    public static String returnSplitSold(double i) {
        return NumberFormat.getCurrencyInstance(new Locale("US", "us")).format(i).replace("$", "").replace(",","").replace(".00", "").replace("D", "");
    }

    public static String returnSold(String s) {
        String rs = String.valueOf(s).replace(",", "");
        return rs;
    }

}
