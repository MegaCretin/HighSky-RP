package fr.highsky.roleplay.Economy.BlackMarket;

import fr.herllox.hmoney.API.MoneyAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class FRAGMENTS_RIGHT_CLICK implements Listener {

    @EventHandler
    public void tradeFrag(PlayerInteractEvent e){

        Player p = e.getPlayer();

        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(p.getInventory().getItemInMainHand().getType() != null && p.getInventory().getItemInMainHand().getType() == Material.IRON_NUGGET){
                if(p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§e§lFragment")){
                    if(p.getInventory().getItemInMainHand().getItemMeta().hasLore() && p.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§f§lInformation:")){
                        int Amount = p.getInventory().getItemInMainHand().getAmount();
                        MoneyAPI.giveMoney(p, 1000.00 * Amount);
                        p.getInventory().setItemInMainHand(null);

                        p.sendMessage("§e§lFragment §8§l» §aVous avez échanger §e"+Amount+"§a fragments contre §e"+1000*Amount+"§a$.");
                    }
                }
            }
        }



    }

}
