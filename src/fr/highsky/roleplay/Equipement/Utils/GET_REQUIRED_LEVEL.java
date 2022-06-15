package fr.highsky.roleplay.Equipement.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class GET_REQUIRED_LEVEL {

    public static Boolean getRequiredLevel(String type, Player p){

        if(p.getLevel() >= getLevelNeeded(type, p)){
            return true;
        }else{
            return false;
        }

    }

    public static int getLevelNeeded(String type, Player p){

        if(type.equalsIgnoreCase("Helmet")){
            if(p.getInventory().getHelmet() != null && p.getInventory().getHelmet().hasItemMeta() && p.getInventory().getHelmet().getItemMeta().hasLore() && p.getInventory().getHelmet().getItemMeta().getLore().toString().contains("Niveaux requis:")){
                String[] lore = p.getInventory().getHelmet().getItemMeta().getLore().toString().split(",");
                for (String s:lore) {
                    if(s.contains("§eNiveaux requis:")){
                        return Integer.valueOf(s.replace("  §f§l► §eNiveaux requis: §9","").replace(" ", ""));
                    }
                }
            }
        }
        else if(type.equalsIgnoreCase("Chestplate")){
            if(p.getInventory().getChestplate() != null && p.getInventory().getChestplate().hasItemMeta() && p.getInventory().getChestplate().getItemMeta().hasLore() && p.getInventory().getChestplate().getItemMeta().getLore().toString().contains("Niveaux requis:")){
                String[] lore = p.getInventory().getChestplate().getItemMeta().getLore().toString().split(",");
                for (String s:lore) {
                    if(s.contains("§eNiveaux requis:")){
                        return Integer.valueOf(s.replace("  §f§l► §eNiveaux requis: §9","").replace(" ", ""));
                    }
                }
            }
        }
        else if(type.equalsIgnoreCase("Leggings")){
            if(p.getInventory().getLeggings() != null && p.getInventory().getLeggings().hasItemMeta() && p.getInventory().getLeggings().getItemMeta().hasLore() && p.getInventory().getLeggings().getItemMeta().getLore().toString().contains("Niveaux requis:")){
                String[] lore = p.getInventory().getLeggings().getItemMeta().getLore().toString().split(",");
                for (String s:lore) {
                    if(s.contains("§eNiveaux requis:")){
                        return Integer.valueOf(s.replace("  §f§l► §eNiveaux requis: §9","").replace(" ", ""));
                    }
                }
            }
        }
        else if(type.equalsIgnoreCase("Boots")){
            if(p.getInventory().getBoots() != null && p.getInventory().getBoots().hasItemMeta() && p.getInventory().getBoots().getItemMeta().hasLore() && p.getInventory().getBoots().getItemMeta().getLore().toString().contains("Niveaux requis:")){
                String[] lore = p.getInventory().getBoots().getItemMeta().getLore().toString().split(",");
                for (String s:lore) {
                    if(s.contains("§eNiveaux requis:")){
                        return Integer.valueOf(s.replace("  §f§l► §eNiveaux requis: §9","").replace(" ", ""));
                    }
                }
            }
        }
        else if(type.equalsIgnoreCase("MainHand")){
            if(p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().hasLore() && p.getInventory().getItemInMainHand().getItemMeta().getLore().toString().contains("Niveaux requis:")){
                String[] lore = p.getInventory().getItemInMainHand().getItemMeta().getLore().toString().split(",");
                for (String s:lore) {
                    if(s.contains("§eNiveaux requis:")){
                        return Integer.valueOf(s.replace("  §f§l► §eNiveaux requis: §9","").replace(" ", ""));
                    }
                }
            }
        }
        else if(type.equalsIgnoreCase("SecondHand")){
            if(p.getInventory().getItemInOffHand() != null && p.getInventory().getItemInOffHand().hasItemMeta() && p.getInventory().getItemInOffHand().getItemMeta().hasLore() && p.getInventory().getItemInOffHand().getItemMeta().getLore().toString().contains("Niveaux requis:")){
                String[] lore = p.getInventory().getItemInOffHand().getItemMeta().getLore().toString().split(",");
                for (String s:lore) {
                    if(s.contains("§eNiveaux requis:")){
                        return Integer.valueOf(s.replace("  §f§l► §eNiveaux requis: §9","").replace(" ", ""));
                    }
                }
            }
        }
        return 0;
    }
}
