package fr.highsky.roleplay.Commands.WeeklyQuest;

import fr.highsky.roleplay.Utils.INV_CREATOR;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class WQ_CLICLDIAMOND implements Listener {

    @EventHandler
    public void onReturn(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§3Quêtes Hebdomadaire §8§l» §7[§8I§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }
            switch (e.getCurrentItem().getType()) {
                case DIAMOND:
                    p.closeInventory();
                    Inventory inv = INV_CREATOR.newInv(27, "§7[§3QH§7] §8§l» §eRécompenses");

                    for(int i=0;i<27;i++){
                        INV_CREATOR.newItem(inv, i, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                    }
                    INV_CREATOR.newItem(inv, 0, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                    INV_CREATOR.newItem(inv, 8, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                    INV_CREATOR.newItem(inv, 18, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                    INV_CREATOR.newItem(inv, 26, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));

                    INV_CREATOR.newItem(inv, 9, Material.NETHERITE_INGOT, 1, "§8§l» §aPremière place §8§l«", Arrays.asList("","§7[§8I§7]"," §7• 1 Portail de l'end"," §7• 50000$"," §7• 1 clé Légendaire"));
                    INV_CREATOR.newItem(inv, 11, Material.EMERALD, 1, "§8§l» §aSeconde place §8§l«", Arrays.asList("","§7[§8I§7]"," §7• 40000$"," §7• 1 clé Légendaire"," §7• 2 clés Rare"));
                    INV_CREATOR.newItem(inv, 13, Material.DIAMOND, 1, "§8§l» §aTroisième place §8§l«", Arrays.asList("","§7[§8I§7]"," §7• 30000$"," §7• 2 clés Rare"," §7• 3 clés Commune"));
                    INV_CREATOR.newItem(inv, 15, Material.GOLD_INGOT, 1, "§8§l» §aQuatrième place §8§l«", Arrays.asList("","§7[§8I§7]"," §7• 25000$"," §7• 2 clés Commune"));
                    INV_CREATOR.newItem(inv, 17, Material.IRON_INGOT, 1, "§8§l» §aCinquième place §8§l«", Arrays.asList("","§7[§8I§7]"," §7• 20000$"," §7• 1 clé Commune"));
                    p.openInventory(inv);
                    break;
                default:
                    break;
            }
        }
    }

}
