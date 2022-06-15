package fr.highsky.roleplay.Equipement.Utils;

/*import com.codingforcookies.armorequip.ArmorEquipEvent;*/
import com.codingforcookies.armorequip.ArmorEquipEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SPEED_GESTION implements Listener {

    @EventHandler
    public void speedHandItems(PlayerMoveEvent e){
        Player p = e.getPlayer();
        Integer value = 0;

        if(GET_REQUIRED_LEVEL.getRequiredLevel("MainHand", p) && p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().hasLore() && p.getInventory().getItemInMainHand().getItemMeta().getLore().toString().contains("§7Vitesse:")){
            String[] lore = p.getInventory().getItemInMainHand().getItemMeta().getLore().toString().split(",");
            for (String s:lore) {
                if(s.contains("§7Vitesse:")){
                    value = value + Integer.parseInt(s.replace("  §f§l► §7Vitesse: §9+","").replace(" ",""));
                }
            }

        }if(GET_REQUIRED_LEVEL.getRequiredLevel("SecondHand", p) && p.getInventory().getItemInOffHand() != null && p.getInventory().getItemInOffHand().hasItemMeta() && p.getInventory().getItemInOffHand().getItemMeta().hasLore() && p.getInventory().getItemInOffHand().getItemMeta().getLore().toString().contains("§7Vitesse:")){

            String[] lore = p.getInventory().getItemInOffHand().getItemMeta().getLore().toString().split(",");
            for (String s:lore) {
                if(s.contains("§7Vitesse:")){
                    value = value + Integer.parseInt(s.replace("  §f§l► §7Vitesse: §9+","").replace(" ",""));
                }
            }

        }if(GET_REQUIRED_LEVEL.getRequiredLevel("Helmet", p) && p.getInventory().getHelmet() != null && p.getInventory().getHelmet().hasItemMeta() && p.getInventory().getHelmet().getItemMeta().hasLore() && p.getInventory().getHelmet().getItemMeta().getLore().toString().contains("§7Vitesse:")){

            String[] lore = p.getInventory().getHelmet().getItemMeta().getLore().toString().split(",");
            for (String s:lore) {
                if(s.contains("§7Vitesse:")){
                    value = value + Integer.parseInt(s.replace("  §f§l► §7Vitesse: §9+","").replace(" ",""));
                }
            }


        }if(GET_REQUIRED_LEVEL.getRequiredLevel("Chestplate", p) && p.getInventory().getChestplate() != null && p.getInventory().getChestplate().hasItemMeta() && p.getInventory().getChestplate().getItemMeta().hasLore() && p.getInventory().getChestplate().getItemMeta().getLore().toString().contains("§7Vitesse:")){

            String[] lore = p.getInventory().getChestplate().getItemMeta().getLore().toString().split(",");
            for (String s:lore) {
                if(s.contains("§7Vitesse:")){
                    value = value + Integer.parseInt(s.replace("  §f§l► §7Vitesse: §9+","").replace(" ",""));
                }
            }

        }if(GET_REQUIRED_LEVEL.getRequiredLevel("Leggings", p) && p.getInventory().getLeggings() != null && p.getInventory().getLeggings().hasItemMeta() && p.getInventory().getLeggings().getItemMeta().hasLore()  && p.getInventory().getLeggings().getItemMeta().getLore().toString().contains("§7Vitesse:")){

            String[] lore = p.getInventory().getLeggings().getItemMeta().getLore().toString().split(",");
            for (String s:lore) {
                if(s.contains("§7Vitesse:")){
                    value = value + Integer.parseInt(s.replace("  §f§l► §7Vitesse: §9+","").replace(" ",""));
                }
            }

        }if(GET_REQUIRED_LEVEL.getRequiredLevel("Boots", p) && p.getInventory().getBoots() != null && p.getInventory().getBoots().hasItemMeta() && p.getInventory().getBoots().getItemMeta().hasLore() && p.getInventory().getBoots().getItemMeta().getLore().toString().contains("§7Vitesse:")){

            String[] lore = p.getInventory().getBoots().getItemMeta().getLore().toString().split(",");
            for (String s:lore) {
                if(s.contains("§7Vitesse:")){
                    value = value + Integer.parseInt(s.replace("  §f§l► §7Vitesse: §9+","").replace(" ",""));
                }
            }

        }

        if(value != 0) {
            p.removePotionEffect(PotionEffectType.SPEED);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 160, value - 1));
        }
    }


    @EventHandler
    public void equipArmor(ArmorEquipEvent e){


        if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR) {
            if (e.getNewArmorPiece().hasItemMeta() && e.getNewArmorPiece().getItemMeta().hasLore() && e.getNewArmorPiece().getItemMeta().getLore().toString().contains("§7Vitesse:")) {
                Player p = e.getPlayer();

                String[] lore = e.getNewArmorPiece().getItemMeta().getLore().toString().split(",");
                if(Integer.valueOf(lore[2].replace("  §f§l► §7Vitesse: §9+","").replace(" ","")) != 0) {
                    p.removePotionEffect(PotionEffectType.SPEED);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 160, Integer.valueOf(lore[2].replace("  §f§l► §7Vitesse: §9+","").replace(" ","")) - 1));
                }
            }
        }
    }

    @EventHandler
    public void desequipArmor(ArmorEquipEvent e){
        if(e.getNewArmorPiece() != null && e.getNewArmorPiece().getType() != Material.AIR) {
            if (e.getNewArmorPiece().hasItemMeta() && e.getNewArmorPiece().getItemMeta().hasLore() && e.getNewArmorPiece().getItemMeta().getLore().toString().contains("§7Vitesse:")) {
                Player p = e.getPlayer();

                String[] lore = e.getNewArmorPiece().getItemMeta().getLore().toString().split(",");
                if(Integer.valueOf(lore[2].replace("  §f§l► §7Vitesse: §9+","").replace(" ","")) != 0) {
                    p.removePotionEffect(PotionEffectType.SPEED);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 160, Integer.valueOf(lore[2].replace("  §f§l► §7Vitesse: §9+","").replace(" ","")) - 1));
                }
            }
        }
    }



}
