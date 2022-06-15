package fr.highsky.roleplay.Commands.DayliGift;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class DG_INVENTORY_CLICK implements Listener {

    @EventHandler
    public void dg_clicked_event(InventoryClickEvent e){

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equals("§b§lDAY§7-§6§lGIFT §8§l» §7[§8I§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;
            }
        }

    }

}
