package fr.highsky.roleplay.Commands.WeeklyQuest;

import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class WQ_RETURNCLICK implements Listener {

    @EventHandler
    public void onReturn(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase(Main.getInstance().getConfig().getString("WeeklyQuest.Menu.Beacon").replace("&", "§"))) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }
            switch (e.getCurrentItem().getType()) {
                case PAPER:
                    p.closeInventory();
                    Bukkit.dispatchCommand(p, "wq");
                    break;
                default:
                    break;
            }
        }
    }

}
