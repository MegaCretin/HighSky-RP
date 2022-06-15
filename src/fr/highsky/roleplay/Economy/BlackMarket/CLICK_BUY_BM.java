package fr.highsky.roleplay.Economy.BlackMarket;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CLICK_BUY_BM implements Listener {

    @EventHandler
    public void BMBuy(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();


        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§5Marché noir §8§l» §7[§8I§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }
            if(e.getSlot() == 31){
                if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §c§lVENTE LIMITÉ §8§l«")){
                    Double price = Main.getInstance().getConfig().getDouble("BlackMarket.Price");
                    int Stock = Main.getInstance().getConfig().getInt("BlackMarket.Stock");
                    if(Stock >= 1) {
                        if (MoneyAPI.getMoney(p) >= price) {

                            p.getInventory().addItem(new ItemStack(e.getCurrentItem().getType(), e.getCurrentItem().getAmount()));
                            MoneyAPI.removeMoney(p, price);
                            Main.getInstance().getConfig().set("BlackMarket.Stock", Stock - 1);
                            Main.getInstance().saveConfig();
                            p.sendMessage("§f§k§lMichel §8§l» §aN'en parle à personne !");
                            p.closeInventory();
                            p.openInventory(BM_INVENTORY.BMInventory());
                        } else {
                            p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                        }
                    }
                }
            }
        }
    }

}
