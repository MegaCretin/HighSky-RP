package fr.highsky.roleplay.Economy.Shop.Events;

import fr.highsky.roleplay.Economy.Shop.Utils.SHOPTYPE;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CLICK_INVENTORY implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        if (e.getClickedInventory() == null)
        e.setCancelled(true);
        if (e.getView().getTitle().equalsIgnoreCase("§bShop §8» §dDécorations")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;
            }
            switch (e.getCurrentItem().getType()) {
                case BRAIN_CORAL:
                    p.closeInventory();
                    SHOPTYPE.shopCoral(p);
                    break;
                case OXEYE_DAISY:
                    p.closeInventory();
                    SHOPTYPE.shopFleur(p);
                    break;
                case LARGE_AMETHYST_BUD:
                    p.closeInventory();
                    SHOPTYPE.shopCaverne(p);
                    break;
                default:
                    break;
            }
        }
    }
}


