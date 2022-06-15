package fr.highsky.roleplay.Commands.WeeklyQuest;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class WQ_CLICKWINDOW implements Listener {

    @EventHandler
    public void onWindow(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("Chargement")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }
            switch (e.getCurrentItem().getType()) {
                case RED_STAINED_GLASS_PANE:
                case LIME_STAINED_GLASS_PANE:
                    e.setCancelled(true);
                    break;
                default:
                    break;

            }
        }
    }

}
