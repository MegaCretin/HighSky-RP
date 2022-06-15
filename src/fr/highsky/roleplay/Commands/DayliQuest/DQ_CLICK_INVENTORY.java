package fr.highsky.roleplay.Commands.DayliQuest;

import fr.highsky.roleplay.Utils.PLAYER_FILE;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class DQ_CLICK_INVENTORY implements Listener {

    @EventHandler
    public void clickShopBM(InventoryClickEvent e) throws IOException {

        Player p = (Player) e.getWhoClicked();
        File file = new File("plugins/HighSky-RP/Origine/PlayerData/"+p.getName()+".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§3Quêtes Journalière §8§l» §7[§8I§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;

            }



            if(e.getSlot() == 11 || e.getSlot() == 13 || e.getSlot() == 15){
                ItemStack it = DQ_UTILS.getInfo(e.getCurrentItem().getType());
                if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasLore() && !e.getCurrentItem().getItemMeta().getLore().toString().contains("Quête réussi")) {
                    if(p.getInventory().containsAtLeast(it, it.getAmount())){
                        p.getInventory().removeItem(it);
                        DQ_UTILS.getReward(e.getCurrentItem().getType(), p);

                        if (e.getSlot() == 11) config.set("DayliQuest.One", true);
                        if (e.getSlot() == 13) config.set("DayliQuest.Two", true);
                        if (e.getSlot() == 15) config.set("DayliQuest.Three", true);
                        PLAYER_FILE.savePlayerFile(p.getName(), config);
                        DQ_UTILS.players.add(p);
                        p.sendMessage("§3Quêtes Journalière §8§l» §aFélicitation vous avez réussi une quête journalière.");
                        p.closeInventory();

                    }else p.sendMessage("§3Quêtes Journalière §8§l» §cVous n'avez pas les objets requis dans votre inventaire.");
                }else p.sendMessage("§3Quêtes Journalière §8§l» §cVous avez déjà réussi ce défi.");
            }else e.setCancelled(true);

        }

    }

}
