package fr.highsky.roleplay.Events.Boxs.XPBoxs;

import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class XP_BOXS_CLICK implements Listener {

    @EventHandler
    public void clickXPBox(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR)return;
        if(XP_BOXS_LOCATION.getLoc(b)) {
            e.setCancelled(true);
            if (b.getType() == Material.IRON_BLOCK) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("XP75")) {
                    if (p.getInventory().containsAtLeast(XP_BOXS_KEY.XP75KeyCheck(), 1)) {
                        p.getInventory().removeItem(XP_BOXS_KEY.XP75KeyCheck());
                        p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_THROW, 100, 100);
                        Inventory inv = Bukkit.createInventory(null, 27, "§a§lBOX §3§lXP75");
                        p.openInventory(inv);
                        XP_BOXS_PERCENT key = new XP_BOXS_PERCENT(true, false, false, p, inv);
                        key.runTaskTimer(Main.getInstance(), 3L, 3L);
                    }
                } else if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    p.openInventory(XP_BOXS_INVENTORY.XP75_Inventory());
                } else p.sendMessage("§d§lBOX §8§l» §cVous n'avez pas la bonne Clé dans la main.");
            }
            else if (b.getType() == Material.GOLD_BLOCK) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("XP150")) {
                    if (p.getInventory().containsAtLeast(XP_BOXS_KEY.XP150KeyCheck(), 1)) {
                        p.getInventory().removeItem(XP_BOXS_KEY.XP150KeyCheck());
                        p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_THROW, 100, 100);
                        Inventory inv = Bukkit.createInventory(null, 27, "§a§lBOX §3§lXP150");
                        p.openInventory(inv);
                        XP_BOXS_PERCENT key = new XP_BOXS_PERCENT(true, false, false, p, inv);
                        key.runTaskTimer(Main.getInstance(), 3L, 3L);
                    }
                } else if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    p.openInventory(XP_BOXS_INVENTORY.XP150_Inventory());
                } else p.sendMessage("§d§lBOX §8§l» §cVous n'avez pas la bonne Clé dans la main.");
            }
            else if (b.getType() == Material.DIAMOND_BLOCK) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("XP300")) {
                    if (p.getInventory().containsAtLeast(XP_BOXS_KEY.XP300KeyCheck(), 1)) {
                        p.getInventory().removeItem(XP_BOXS_KEY.XP300KeyCheck());
                        p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_THROW, 100, 100);
                        Inventory inv = Bukkit.createInventory(null, 27, "§a§lBOX §3§lXP300");
                        p.openInventory(inv);
                        XP_BOXS_PERCENT key = new XP_BOXS_PERCENT(true, false, false, p, inv);
                        key.runTaskTimer(Main.getInstance(), 3L, 3L);
                    }
                } else if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    p.openInventory(XP_BOXS_INVENTORY.XP300_Inventory());
                } else p.sendMessage("§d§lBOX §8§l» §cVous n'avez pas la bonne Clé dans la main.");
            }
        }
    }

}
