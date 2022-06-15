package fr.highsky.roleplay.Economy.Shop.SellStick.Events;

import com.songoda.skyblock.api.SkyBlockAPI;
import fr.herllox.hmoney.API.MoneyAPI;

import fr.highsky.roleplay.Economy.Shop.SellStick.Utils.STICK_ITEM;
import fr.highsky.roleplay.Economy.Shop.Utils.ShopTools;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CLICK_CHEST implements Listener {

    @EventHandler
    public void onchestClick(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if(e.getClickedBlock() != null && e.getClickedBlock().getType() != Material.AIR && e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (p.getInventory().getItemInMainHand() != null && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getType() == Material.END_ROD) {
                Material click = e.getClickedBlock().getType();
                if (p.getInventory().getItemInMainHand().getItemMeta().getLore().toString().contains("§f┃ §a§lUtilisation§f§l:")) {
                    if (SkyBlockAPI.getIslandManager().isPlayerAtIsland(SkyBlockAPI.getIslandManager().getIsland(p), p)) {
                        if (click == Material.CHEST) {
                            e.setCancelled(true);
                            Chest chest = (Chest) e.getClickedBlock().getState();
                            Double Price = 0.00;
                            int Amount = 0;
                            for (int i = 0; i < chest.getInventory().getSize(); i++) {
                                ItemStack it = chest.getInventory().getItem(i);
                                if (chest.getInventory().getItem(i) != null) {
                                    Price = Price + ShopTools.checkSellPrice(it);
                                    if (ShopTools.checkSellPrice(it) != 0.00) {
                                        Amount += chest.getInventory().getItem(i).getAmount();
                                        chest.getInventory().setItem(i, null);
                                    }
                                }
                            }
                            if (Price == 0.00) {
                                p.sendMessage("§6§lHigh§b§lSky §7§l» §cIl n'y a rien à vendre dans ce coffre.");
                                return;
                            }
                            String[] Lore = p.getInventory().getItemInMainHand().getItemMeta().getLore().toString().split(",");
                            Double Mult = Double.parseDouble(Lore[5].replace("§f┃  ▶ §b§l", "").replace(" ", ""));
                            int Utilisation = Integer.parseInt(Lore[2].replace("§f┃  ▶ §b§l","").replace(" ",""));
                            p.sendMessage("§6§lHigh§b§lSky §7§l» §aVous avez vendu §e" + Amount + "§a items pour §e" + (Price*Mult) + "$§a.");
                            MoneyAPI.giveMoney(p, (Price * Mult));

                            if(Utilisation == 1){
                                p.getInventory().setItemInMainHand(null);
                                e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ITEM_SHIELD_BREAK, 10.0F, 1.0F);
                                return;
                            }else if(Utilisation > 1){
                                p.getInventory().setItemInMainHand(null);
                                p.getInventory().setItemInMainHand(STICK_ITEM.SellStick(Mult, (Utilisation-1)));
                            }
                        }
                    }
                }
            }
        }
    }

}
