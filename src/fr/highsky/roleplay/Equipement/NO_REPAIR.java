package fr.highsky.roleplay.Equipement;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;

public class NO_REPAIR implements Listener {

    @EventHandler
    public void Anvil(PrepareAnvilEvent e) {
        if (e.getInventory().getItem(0) != null && e.getInventory().getItem( 1) != null && e.getInventory().getItem(0).hasItemMeta() && e.getInventory().getItem(0).getItemMeta().hasLore() && e.getInventory().getItem(0).getItemMeta().getLore().toString().contains("§7Rareté:")){
            e.setResult(null);
        }

    }

}
