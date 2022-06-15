package fr.highsky.roleplay.Equipement.Utils;

import com.codingforcookies.armorequip.ArmorEquipEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class HEALTH_GESTION implements Listener {

    @EventHandler
    public void addHealthOnMoove(PlayerMoveEvent e){

        Player p = e.getPlayer();

        Double vie = 0D;

        if(p.getInventory().getItemInMainHand() != null && GET_REQUIRED_LEVEL.getRequiredLevel("MainHand", p) && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().hasLore() && p.getInventory().getItemInMainHand().getItemMeta().getLore().toString().contains("§7Vie:")){

            String[] lore = p.getInventory().getItemInMainHand().getItemMeta().getLore().toString().split(",");
            Double life = 0.00;

            for(String s: lore){
                if(s.contains("§7Vie")){
                    life = life + Double.parseDouble(s.replace("  §f§l► §7Vie: §9+","").replace(" ",""));
                }
            }


            vie = vie + life;
        }
        if(p.getInventory().getItemInOffHand() != null && GET_REQUIRED_LEVEL.getRequiredLevel("SecondHand", p) && p.getInventory().getItemInOffHand().hasItemMeta() && p.getInventory().getItemInOffHand().getItemMeta().hasLore() && p.getInventory().getItemInOffHand().getItemMeta().getLore().toString().contains("§7Vie:")){

            String[] lore = p.getInventory().getItemInOffHand().getItemMeta().getLore().toString().split(",");
            Double life = 0.00;

            for(String s: lore){
                if(s.contains("§7Vie")){
                    life = life + Double.parseDouble(s.replace("  §f§l► §7Vie: §9+","").replace(" ",""));
                }
            }


            vie = vie + life;
        }
        p.setMaxHealth(p.getHealth() +vie);
        p.setHealth((p.getHealth() - vie)+vie);

    }

    @EventHandler
    public void addHealth(PlayerJoinEvent e){

        Player p = e.getPlayer();

        Double vie = 0D;

        if(p.getInventory().getItemInMainHand() != null && GET_REQUIRED_LEVEL.getRequiredLevel("MainHand", p) && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().hasLore() && p.getInventory().getItemInMainHand().getItemMeta().getLore().toString().contains("§7Vie:")){

            String[] lore = p.getInventory().getItemInMainHand().getItemMeta().getLore().toString().split(",");
            Double life = 0.00;

            for(String s: lore){
                if(s.contains("§7Vie")){
                    life = life + Double.parseDouble(s.replace("  §f§l► §7Vie: §9+","").replace(" ",""));
                }
            }


            vie = vie + life;
        }
        if(p.getInventory().getItemInOffHand() != null && GET_REQUIRED_LEVEL.getRequiredLevel("SecondHand", p) && p.getInventory().getItemInOffHand().hasItemMeta() && p.getInventory().getItemInOffHand().getItemMeta().hasLore() && p.getInventory().getItemInOffHand().getItemMeta().getLore().toString().contains("§7Vie:")){

            String[] lore = p.getInventory().getItemInOffHand().getItemMeta().getLore().toString().split(",");
            Double life = 0.00;

            for(String s: lore){
                if(s.contains("§7Vie")){
                    life = life + Double.parseDouble(s.replace("  §f§l► §7Vie: §9+","").replace(" ",""));
                }
            }


            vie = vie + life;
        }
        if(p.getInventory().getHelmet() != null && GET_REQUIRED_LEVEL.getRequiredLevel("Helmet", p) && p.getInventory().getHelmet().hasItemMeta() && p.getInventory().getHelmet().getItemMeta().hasLore() && p.getInventory().getHelmet().getItemMeta().getLore().toString().contains("§7Vie:")){

            String[] lore = p.getInventory().getHelmet().getItemMeta().getLore().toString().split(",");
            Double life = 0.00;

            for(String s: lore){
                if(s.contains("§7Vie")){
                    life = life + Double.parseDouble(s.replace("  §f§l► §7Vie: §9+","").replace(" ",""));
                }
            }


            vie = vie + life;
        }
        if(p.getInventory().getChestplate() != null && GET_REQUIRED_LEVEL.getRequiredLevel("Chestplate", p) && p.getInventory().getChestplate().hasItemMeta() && p.getInventory().getChestplate().getItemMeta().hasLore() && p.getInventory().getChestplate().getItemMeta().getLore().toString().contains("§7Vie:")){

            String[] lore = p.getInventory().getChestplate().getItemMeta().getLore().toString().split(",");
            Double life = 0.00;

            for(String s: lore){
                if(s.contains("§7Vie")){
                    life = life + Double.parseDouble(s.replace("  §f§l► §7Vie: §9+","").replace(" ",""));
                }
            }


            vie = vie + life;

        }
        if(p.getInventory().getLeggings() != null && GET_REQUIRED_LEVEL.getRequiredLevel("Leggings", p) && p.getInventory().getLeggings().hasItemMeta() && p.getInventory().getLeggings().getItemMeta().hasLore() && p.getInventory().getLeggings().getItemMeta().getLore().toString().contains("§7Vie:")){

            String[] lore = p.getInventory().getLeggings().getItemMeta().getLore().toString().split(",");
            Double life = 0.00;

            for(String s: lore){
                if(s.contains("§7Vie")){
                    life = life + Double.parseDouble(s.replace("  §f§l► §7Vie: §9+","").replace(" ",""));
                }
            }


            vie = vie + life;

        }
        if(p.getInventory().getBoots() != null && GET_REQUIRED_LEVEL.getRequiredLevel("Boots", p) && p.getInventory().getBoots().hasItemMeta() && p.getInventory().getBoots().getItemMeta().hasLore() && p.getInventory().getBoots().getItemMeta().getLore().toString().contains("§7Vie:")){

            String[] lore = p.getInventory().getBoots().getItemMeta().getLore().toString().split(",");
            Double life = 0.00;

            for(String s: lore){
                if(s.contains("§7Vie")){
                    life = life + Double.parseDouble(s.replace("  §f§l► §7Vie: §9+","").replace(" ",""));
                }
            }


            vie = vie + life;

        }

        p.setMaxHealth(p.getHealth() + vie);
        p.setHealth(p.getHealth() + vie);

    }

    @EventHandler
    public void equipArmor(ArmorEquipEvent e){
        if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR) {
            if (e.getNewArmorPiece().hasItemMeta() && e.getNewArmorPiece().getItemMeta().hasLore() && e.getNewArmorPiece().getItemMeta().getLore().toString().contains("§7Vie:")) {
                Player p = e.getPlayer();
                Double vie = p.getHealth();

                String[] Hlore = e.getNewArmorPiece().getItemMeta().getLore().toString().split(",");
                Double Hvie = Double.parseDouble(Hlore[1].replace("§7Vie: §9+", "").replace("§f§l►", "").replace(" ", ""));
                vie = vie + Hvie;

                p.setMaxHealth(vie);
                p.setHealth(vie);
            }
        }
    }

    @EventHandler
    public void desequipArmor(ArmorEquipEvent e){
        if(e.getOldArmorPiece() != null && e.getOldArmorPiece().getType() != Material.AIR) {
            if (e.getOldArmorPiece().hasItemMeta() && e.getNewArmorPiece().getItemMeta().hasLore() && e.getOldArmorPiece().getItemMeta().getLore().toString().contains("§7Vie:")) {
                Player p = e.getPlayer();
                Double vie = p.getHealth();

                String[] Hlore = e.getOldArmorPiece().getItemMeta().getLore().toString().split(",");
                Double Hvie = Double.parseDouble(Hlore[1].replace("§7Vie: §9+", "").replace("§f§l►", "").replace(" ", ""));
                vie = vie - Hvie;

                p.setMaxHealth(vie);
                p.setHealth(vie);
            }
        }
    }
}
