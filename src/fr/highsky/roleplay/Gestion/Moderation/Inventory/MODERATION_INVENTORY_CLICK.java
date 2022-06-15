package fr.highsky.roleplay.Gestion.Moderation.Inventory;

import fr.highsky.roleplay.Gestion.Moderation.Utils.MODERATION_INV_UTILS;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MODERATION_INVENTORY_CLICK implements Listener {

    @EventHandler
    public void clickTime(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();


        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§6§lH§b§lL§7-§aModération §8§l» §7[§7i§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }

            switch (e.getCurrentItem().getType()) {
                case GOLDEN_SWORD:
                    if (p.hasPermission("moderation.tempan")) {
                        p.closeInventory();
                        String[] suspect = e.getInventory().getItem(4).getItemMeta().getDisplayName().split(" ");
                        p.openInventory(MODERATION_INV_UTILS.timeInv(Bukkit.getPlayer(suspect[4].replace("§e", " ").replace(" ", "")), "TEMPBAN"));
                    }
                    break;
                case BARRIER:
                    if (p.hasPermission("moderation.mute")){
                        p.closeInventory();
                        String[] suspect1 = e.getInventory().getItem(4).getItemMeta().getDisplayName().split(" ");
                        p.openInventory(MODERATION_INV_UTILS.timeInv(Bukkit.getPlayer(suspect1[4].replace("§e", " ").replace(" ", "")), "MUTE"));
                    }
                    break;
                case GOLDEN_BOOTS:
                    if(p.hasPermission("moderation.kick")) {
                        p.closeInventory();
                        String[] suspect2 = e.getInventory().getItem(4).getItemMeta().getDisplayName().split(" ");
                        p.openInventory(MODERATION_INV_UTILS.reasonInv(Bukkit.getPlayer(suspect2[4].replace("§e", " ").replace(" ", "")), "KICK"));
                    }
                    break;
                case NETHERITE_SWORD:
                    if(p.hasPermission("moderation.ban")) {
                        p.closeInventory();
                        String[] suspect3 = e.getInventory().getItem(4).getItemMeta().getDisplayName().split(" ");
                        p.openInventory(MODERATION_INV_UTILS.reasonInv(Bukkit.getPlayer(suspect3[4].replace("§e", " ").replace(" ", "")), "BAN"));
                    }
                    break;
                default:
                    break;
            }
        }
    }

}
