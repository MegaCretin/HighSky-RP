package fr.highsky.roleplay.Commands.Menu;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MENU_CLICK_INVENTORY implements Listener {

    @EventHandler
    public void clickKey(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();


        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§d§lMENU §8§l» §7[§8I§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }

            switch (e.getCurrentItem().getType()) {
                case GRASS_BLOCK:
                    p.closeInventory();
                    Bukkit.dispatchCommand(p, "is");
                    break;
                case BELL:
                    p.closeInventory();
                    Bukkit.dispatchCommand(p, "ah");
                    break;
                case WHEAT:
                    p.closeInventory();
                    Bukkit.dispatchCommand(p, "dq");
                    break;
                case BEDROCK:
                    p.closeInventory();
                    Bukkit.dispatchCommand(p, "spawn");
                    break;
                case EXPERIENCE_BOTTLE:
                    p.closeInventory();
                    Bukkit.dispatchCommand(p, "xpbox");
                    break;
                case ENDER_PEARL:
                    p.closeInventory();
                    Bukkit.dispatchCommand(p, "warp");
                    break;
                case CACTUS:
                    p.closeInventory();
                    Bukkit.dispatchCommand(p, "wq");
                    break;
                case COMPASS:
                    p.closeInventory();
                    Bukkit.dispatchCommand(p, "pt");
                    break;
                default:
                    break;
            }
        }
    }

}
