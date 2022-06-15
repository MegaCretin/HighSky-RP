package fr.highsky.roleplay.Events.PlayTime;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Economy.Shop.SellStick.Utils.STICK_ITEM;
import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils.KEY;
import fr.highsky.roleplay.Events.Boxs.XPBoxs.XP_BOXS_KEY;
import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;

public class PT_RECUP implements Listener {

    @EventHandler
    public void onRecup(InventoryClickEvent e) throws SQLException {

        Player p = (Player) e.getWhoClicked();


        if (e.getClickedInventory() == null) {
            e.setCancelled(true);
        }
        if (e.getView().getTitle().equalsIgnoreCase("§b§lPLAYTIME §8§l» §7Menu")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;

            }
            switch (e.getCurrentItem().getType()) {
                case LIME_STAINED_GLASS_PANE:
                    int Empty = 0;
                    for (int i = 0; i < 36; i++) {
                        if (p.getInventory().getItem(i) == null) {

                            Empty = Empty + 1;

                        }
                    }

                    int time = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / (60 * 60 * 20);
                    if (Empty <= 3) {
                        p.sendMessage(Main.getInstance().getConfig().getString("Messages.Prefix").replace("&", "§") + Main.getInstance().getConfig().getString("PlayTime.Messages.Inv-Full").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }

                    if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 1h") && time >= 1) {

                        p.getInventory().addItem(KEY.CommunKey(1));
                        p.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 16));
                        PT_BDD.addTime(p, "1h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 2h") && time >= 2) {

                        p.getInventory().addItem(KEY.CommunKey(1));
                        p.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, 8));
                        PT_BDD.addTime(p, "2h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 5h") && time >= 5) {

                        p.getInventory().addItem(KEY.CommunKey(2));
                        MoneyAPI.giveMoney(p, 5000.00);
                        PT_BDD.addTime(p, "3h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 10h") && time >= 10) {

                        p.getInventory().addItem(KEY.RareKey(1));
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND, 16));
                        PT_BDD.addTime(p, "4h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 25h") && time >= 25) {

                        p.getInventory().addItem(KEY.RareKey(1));
                        p.getInventory().addItem(KEY.CommunKey(1));
                        p.getInventory().addItem(new ItemStack(Material.EMERALD, 4));
                        PT_BDD.addTime(p, "5h");


                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 50h") && time >= 50) {

                        STICK_ITEM.SellStick( 1.0, 50);
                        PT_BDD.addTime(p, "6h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 75h") && time >= 75) {

                        p.getInventory().addItem(KEY.CommunKey(3));
                        XP_BOXS_KEY.XP150Key( 1);
                        PT_BDD.addTime(p, "7h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 100h") && time >= 100) {

                        p.getInventory().addItem(KEY.RareKey(2));
                        p.getInventory().addItem(new ItemStack(Material.NETHERITE_SCRAP, 4));
                        p.getInventory().addItem(new ItemStack(Material.VILLAGER_SPAWN_EGG, 2));
                        PT_BDD.addTime(p, "8h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 150h") && time >= 150) {

                        p.getInventory().addItem(KEY.LegKey(1));
                        MoneyAPI.giveMoney(p, 15000.00);
                        PT_BDD.addTime(p, "9h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 200h") && time >= 200) {

                        p.getInventory().addItem(KEY.LegKey(1));
                        p.getInventory().addItem(KEY.RareKey(2));
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tag give " + p.getName() + " 104");
                        PT_BDD.addTime(p, "10h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 250h") && time >= 250) {

                        p.getInventory().addItem(KEY.LegKey(2));
                        XP_BOXS_KEY.XP300Key(1);
                        PT_BDD.addTime(p, "11h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 350h") && time >= 350) {

                        p.getInventory().addItem(KEY.LegKey(2));
                        p.getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK, 16));
                        PT_BDD.addTime(p, "12h");

                    } else if (e.getCurrentItem().getItemMeta().getDisplayName().contains("§f§lJouer 500h") && time >= 500) {

                        p.getInventory().addItem(KEY.LegKey(5));
                        p.getInventory().addItem(KEY.RareKey(3));
                        PT_BDD.addTime(p, "13h");

                    } else {
                        p.sendMessage(Main.getInstance().getConfig().getString("Messages.Prefix").replace("&", "§") + Main.getInstance().getConfig().getString("PlayTime.Messages.Need-Time").replace("&", "§"));
                        p.closeInventory();
                        return;
                    }
                    p.closeInventory();
                    p.sendMessage(Main.getInstance().getConfig().getString("Messages.Prefix").replace("&", "§") + Main.getInstance().getConfig().getString("PlayTime.Messages.Congrat").replace("&", "§"));

                    break;
                case RED_STAINED_GLASS_PANE:
                    e.setCancelled(true);
                    p.sendMessage(Main.getInstance().getConfig().getString("Messages.Prefix").replace("&", "§") + Main.getInstance().getConfig().getString("PlayTime.Messages.Already-Take").replace("&", "§"));
                    break;
                default:
                    break;
            }
        }
    }
}    