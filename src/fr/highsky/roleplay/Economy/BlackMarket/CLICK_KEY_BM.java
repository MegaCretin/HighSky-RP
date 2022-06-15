package fr.highsky.roleplay.Economy.BlackMarket;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils.KEY;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CLICK_KEY_BM implements Listener {

    @EventHandler
    public void clickKey(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();


        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§5Marché noir §8§l» §b§lClés")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }

            switch (e.getCurrentItem().getType()) {
                case TRIPWIRE_HOOK:
                    if(e.getCurrentItem().getItemMeta().getDisplayName().contains("COMMUNE")){
                        if(MoneyAPI.getMoney(p) >= 25000.00){
                            p.getInventory().addItem(KEY.CommunKey(1));
                            p.sendMessage("§b§lCLÉS §8§l» §aVous avez reçu une clé §b§lCOMMUNE !");
                            MoneyAPI.removeMoney(p, 25000.00);
                        }else{
                            p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                        }
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("RARE")){
                        if(MoneyAPI.getMoney(p) >= 75000.00){
                            p.getInventory().addItem(KEY.RareKey(1));
                            p.sendMessage("§b§lCLÉS §8§l» §aVous avez reçu une clé §c§lRARE !");
                            MoneyAPI.removeMoney(p, 75000.00);
                        }else{
                            p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                        }
                    }else if(e.getCurrentItem().getItemMeta().getDisplayName().contains("LEGENDAIRE")){
                        if(MoneyAPI.getMoney(p) >= 200000.00){
                            p.getInventory().addItem(KEY.LegKey(1));
                            p.sendMessage("§b§lCLÉS §8§l» §aVous avez reçu une clé §6§lLÉGENDAIRE !");
                            MoneyAPI.removeMoney(p, 200000.00);
                        }else{
                            p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                        }
                    }
                    break;
                case BARRIER:
                    p.closeInventory();
                    p.openInventory(BM_INVENTORY.BMInventory());
                    break;
                case BLACK_STAINED_GLASS_PANE:
                    break;
                default:
                    break;
            }
        }
    }

}
