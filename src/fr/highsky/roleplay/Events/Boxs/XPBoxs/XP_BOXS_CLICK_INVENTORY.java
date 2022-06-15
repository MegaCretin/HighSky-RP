package fr.highsky.roleplay.Events.Boxs.XPBoxs;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class XP_BOXS_CLICK_INVENTORY implements Listener {

    @EventHandler
    public void clickInventory(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§7[§6§lH§b§lS§7] §3Boxs d'expérience")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;

            }
            switch (e.getCurrentItem().getType()) {
                case SUNFLOWER:
                    if(e.getCurrentItem().getItemMeta().getDisplayName().contains("XP75")){
                        if(p.getLevel() >= 75){
                            p.setLevel(p.getLevel() - 75);
                            p.getInventory().addItem(XP_BOXS_KEY.XP75Key(1));
                            p.sendMessage("§d§lBOX §8§l» §aVous avez reçu une clé §3§lXP75 §acontre §e75 §aniveaux d'xp.");
                            p.closeInventory();
                        }else p.sendMessage("§d§lBOX §8§l» §cVous n'avez pas le niveau requis pour acheté cette clé.");
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("XP150")){
                        if(p.getLevel() >=150){
                            p.setLevel(p.getLevel() - 150);
                            p.getInventory().addItem(XP_BOXS_KEY.XP150Key(1));
                            p.sendMessage("§d§lBOX §8§l» §aVous avez reçu une clé §3§lXP150 §acontre §e150 §aniveaux d'xp.");
                            p.closeInventory();
                        }else p.sendMessage("§d§lBOX §8§l» §cVous n'avez pas le niveau requis pour acheté cette clé.");
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("XP300")){
                        if(p.getLevel() >= 300){
                            p.setLevel(p.getLevel() - 300);
                            p.getInventory().addItem(XP_BOXS_KEY.XP300Key(1));
                            p.sendMessage("§d§lBOX §8§l» §aVous avez reçu une clé §3§lXP300 §acontre §e300 §aniveaux d'xp.");
                            p.closeInventory();
                        }else p.sendMessage("§d§lBOX §8§l» §cVous n'avez pas le niveau requis pour acheté cette clé.");
                    }
                    break;
                default:
                    break;

            }
        }
    }


    @EventHandler
    public void incClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§a§lBOX §3§lXP75") || e.getView().getTitle().equalsIgnoreCase("§a§lBOX §3§lXP150") || e.getView().getTitle().equalsIgnoreCase("§a§lBOX §3§lXP300")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;

            }
        }
    }

}
