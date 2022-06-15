package fr.highsky.roleplay.Events.Boxs.KeyBoxs.Skyblock;

import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils.GET_LOCATION;
import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils.INVENTORY;
import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils.KEY;
import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public class S_EVENTS implements Listener {

    private final Main main;

    public S_EVENTS(Main main) {
        this.main = main;
    }

    @EventHandler
    public void breakBlock(BlockBreakEvent e){

        Block b = e.getBlock();
        if(GET_LOCATION.getLoc(b)){
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void interactBlock(PlayerInteractEvent e){

        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR)return;
        if(GET_LOCATION.getLoc(b)){
            e.setCancelled(true);
            if (b.getType() == Material.CYAN_SHULKER_BOX) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("COMMUNE")) {
                    if (p.getInventory().containsAtLeast(KEY.CommunKeyCheck(), 1)) {
                        p.getInventory().removeItem(KEY.CommunKeyCheck());
                        p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_THROW, 100, 100);
                        Inventory inv = Bukkit.createInventory(null, 27, "§bBOX §lCOMMUNE");
                        p.openInventory(inv);
                        S_PERCENT key = new S_PERCENT(true, false, false, p, inv);
                        key.runTaskTimer(main, 3L, 3L);
                    }
                } else if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    INVENTORY.S_invCommun(p);
                } else p.sendMessage("§d§lBOX §8§l» §cVous n'avez pas la bonne Clé dans la main.");
            } else if (b.getType() == Material.RED_SHULKER_BOX) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("RARE")) {
                    if (p.getInventory().containsAtLeast(KEY.RareKeyCheck(), 1)) {
                        p.getInventory().removeItem(KEY.RareKeyCheck());
                        p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_THROW, 100, 100);
                        Inventory inv = Bukkit.createInventory(null, 27, "§cBOX §lRARE");
                        p.openInventory(inv);
                        S_PERCENT key = new S_PERCENT(false, true, false, p, inv);
                        key.runTaskTimer(main, 3L, 3L);
                    }
                } else if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    INVENTORY.S_invRare(p);
                } else p.sendMessage("§d§lBOX §8§l» §cVous n'avez pas la bonne Clé dans la main.");
            } else if (b.getType() == Material.ORANGE_SHULKER_BOX) {
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("LEGENDAIRE")) {
                    if (p.getInventory().containsAtLeast(KEY.LegKeyCheck(), 1)) {
                        p.getInventory().removeItem(KEY.LegKeyCheck());
                        p.playSound(p.getLocation(), Sound.ITEM_TRIDENT_THROW, 100, 100);
                        Inventory inv = Bukkit.createInventory(null, 27, "§6BOX §lLEGENDAIRE");
                        p.openInventory(inv);
                        S_PERCENT key = new S_PERCENT(false, false, true, p, inv);
                        key.runTaskTimer(main, 3L, 3L);
                    }
                } else if (e.getAction() == Action.LEFT_CLICK_BLOCK) {
                    INVENTORY.S_invLeg(p);
                } else p.sendMessage("§d§lBOX §8§l» §cVous n'avez pas la bonne Clé dans la main.");
            }

        }

    }

    @EventHandler
    public void invClick(InventoryClickEvent e){

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equals("§6BOX §lLEGENDAIRE") || e.getView().getTitle().equals("§cBOX §lRARE") || e.getView().getTitle().equals("§bBOX §lCOMMUNE")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;
            }
        }
    }


    public void Placekey(BlockPlaceEvent e){

        Block b = e.getBlockPlaced();
        Player p = e.getPlayer();
        if(b.getType() == Material.TRIPWIRE_HOOK && p.getInventory().getItemInMainHand().hasItemMeta() && p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("Clé")){
            if(e.getBlock().getType() != Material.ORANGE_SHULKER_BOX || e.getBlock().getType() != Material.CYAN_SHULKER_BOX || e.getBlock().getType() != Material.RED_SHULKER_BOX){
                e.setCancelled(true);
            }
        }

    }


}

