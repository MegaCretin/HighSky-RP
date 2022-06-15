package fr.highsky.roleplay.Commands.WeeklyQuest;

import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WQ_CLICKBEACON implements Listener {

    @EventHandler
    public void onTop(InventoryClickEvent e) throws SQLException {


        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§3Quêtes Hebdomadaire §8§l» §7[§8I§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }
            switch (e.getCurrentItem().getType()){
                case BEACON:

                    Inventory load = Bukkit.createInventory(null, 27, "Chargement");

                    ItemStack it = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
                    ItemMeta itm = it.getItemMeta();
                    itm.setDisplayName("§fChargement ...");
                    itm.setLore(Collections.singletonList(" "));
                    it.setItemMeta(itm);


                    ItemStack it2 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
                    ItemMeta itm2 = it2.getItemMeta();
                    itm2.setDisplayName("§fChargement ...");
                    itm2.setLore(Collections.singletonList(" "));
                    it2.setItemMeta(itm2);


                    load.setItem(11, it);
                    load.setItem(13, it);
                    load.setItem(15, it);

                    p.openInventory(load);


                    Inventory inv = Bukkit.createInventory(null, 54, Main.getInstance().getConfig().getString("WeeklyQuest.Menu.Beacon").replace("&", "§"));



                    List op = WQ_BDD.getTop10();
                    String[] s = op.toString().replace("[","").replace(" ", "").replace("]", "").split(",");
                    List<Integer> slot = Arrays.asList(13, 21, 23, 29, 31, 33, 37, 39, 41, 43);


                    for(int i = 0; i < s.length; i++){

                        if (!s[i].isEmpty()){

                            ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
                            SkullMeta meta = (SkullMeta) head.getItemMeta();
                            meta.setOwningPlayer(Bukkit.getOfflinePlayer(s[i]));
                            meta.setDisplayName("§6§L"+ s[i]);
                            if(s[i] != null){
                                meta.setLore(Arrays.asList(" ", " §7• Nombre: §f"+WQ_BDD.checkNbr(s[i])+" §fitems"," "));
                            }
                            head.setItemMeta(meta);

                            inv.setItem(slot.get(i), head);

                        }
                    }

                    ItemStack ret = new ItemStack(Material.PAPER);
                    ItemMeta retx = ret.getItemMeta();
                    retx.setDisplayName("§8§l» §cRetour §8§l«");
                    ret.setItemMeta(retx);
                    inv.setItem(45, ret);

                    (new BukkitRunnable() {
                        public void run() {
                            load.setItem(11, it2);
                            p.updateInventory();
                            (new BukkitRunnable() {
                                public void run() {
                                    load.setItem(13, it2);
                                    p.updateInventory();
                                    (new BukkitRunnable() {
                                        public void run() {
                                            load.setItem(15, it2);
                                            p.updateInventory();
                                            (new BukkitRunnable() {
                                                public void run() {
                                                    p.openInventory(inv);
                                                }
                                            }).runTaskLater(Main.getInstance(), 5L);
                                        }
                                    }).runTaskLater(Main.getInstance(), 10L);
                                }
                            }).runTaskLater(Main.getInstance(), 10L);
                        }
                    }).runTaskLater(Main.getInstance(), 10L);




                    break;
                default:
                    break;

            }


        }


    }
    
}
