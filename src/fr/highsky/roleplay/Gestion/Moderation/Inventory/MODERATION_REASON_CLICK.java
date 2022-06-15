package fr.highsky.roleplay.Gestion.Moderation.Inventory;

import fr.highsky.roleplay.Gestion.Moderation.Utils.BAN_UTILS;
import fr.highsky.roleplay.Gestion.Moderation.Utils.KICK_UTILS;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MODERATION_REASON_CLICK implements Listener {

    @EventHandler
    public void clickTime(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();


        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().startsWith("§7[§6§lH§b§lH§7] §E§lKICK §8§l»")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }

            switch (e.getCurrentItem().getType()) {
                case BOOK:

                    List<String> lore1 = e.getCurrentItem().getItemMeta().getLore();
                    ItemMeta itx1 = e.getCurrentItem().getItemMeta();

                    if(lore1.get(6).startsWith("§7")&& lore1.get(5).startsWith("§f")){
                        lore1.set(5, lore1.get(5).replace("§f","§7"));
                        lore1.set(6, lore1.get(6).replace("§7","§f"));
                    }else if(lore1.get(5).startsWith("§7")&& lore1.get(4).startsWith("§f")){
                        lore1.set(4, lore1.get(4).replace("§f","§7"));
                        lore1.set(5, lore1.get(5).replace("§7","§f"));
                    }else if(lore1.get(4).startsWith("§7")&& lore1.get(3).startsWith("§f")){
                        lore1.set(3, lore1.get(3).replace("§f","§7"));
                        lore1.set(4, lore1.get(4).replace("§7","§f"));
                    }else if(lore1.get(3).startsWith("§7")&& lore1.get(2).startsWith("§f")){
                        lore1.set(2, lore1.get(2).replace("§f","§7"));
                        lore1.set(3, lore1.get(3).replace("§7","§f"));
                    }else if(lore1.get(2).startsWith("§7") && lore1.get(1).startsWith("§f")){
                        lore1.set(1, lore1.get(1).replace("§f","§7"));
                        lore1.set(2, lore1.get(2).replace("§7","§f"));
                    }else if(lore1.get(1).startsWith("§7")){
                        lore1.set(1, lore1.get(1).replace("§7","§f"));
                        lore1.set(6, lore1.get(6).replace("§f","§7"));
                    }


                    itx1.setLore(lore1);
                    e.getCurrentItem().setItemMeta(itx1);
                    p.updateInventory();

                    break;
                case LIME_STAINED_GLASS_PANE:

                    List<String> lore3 = e.getInventory().getItem(22).getItemMeta().getLore();
                    String reason = null;
                    for(String s:lore3){
                        if(s.startsWith("§f")){
                            reason = s.replace("§f","");
                            break;
                        }
                    }

                    KICK_UTILS.kick(p, Bukkit.getPlayer(e.getView().getTitle().replace("§7[§6§lH§b§lH§7] §E§lKICK §8§l» §3","").replace(" ","")), reason);
                    p.closeInventory();

                    break;
                case RED_STAINED_GLASS_PANE:
                    p.closeInventory();
                    break;
                default:
                    break;
            }
        }else if(e.getView().getTitle().startsWith("§7[§6§lH§b§lH§7] §E§lBAN §8§l»")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }

            switch (e.getCurrentItem().getType()) {
                case BOOK:

                    List<String> lore1 = e.getCurrentItem().getItemMeta().getLore();
                    ItemMeta itx1 = e.getCurrentItem().getItemMeta();

                    if (lore1.get(6).startsWith("§7") && lore1.get(5).startsWith("§f")) {
                        lore1.set(5, lore1.get(5).replace("§f", "§7"));
                        lore1.set(6, lore1.get(6).replace("§7", "§f"));
                    } else if (lore1.get(5).startsWith("§7") && lore1.get(4).startsWith("§f")) {
                        lore1.set(4, lore1.get(4).replace("§f", "§7"));
                        lore1.set(5, lore1.get(5).replace("§7", "§f"));
                    } else if (lore1.get(4).startsWith("§7") && lore1.get(3).startsWith("§f")) {
                        lore1.set(3, lore1.get(3).replace("§f", "§7"));
                        lore1.set(4, lore1.get(4).replace("§7", "§f"));
                    } else if (lore1.get(3).startsWith("§7") && lore1.get(2).startsWith("§f")) {
                        lore1.set(2, lore1.get(2).replace("§f", "§7"));
                        lore1.set(3, lore1.get(3).replace("§7", "§f"));
                    } else if (lore1.get(2).startsWith("§7") && lore1.get(1).startsWith("§f")) {
                        lore1.set(1, lore1.get(1).replace("§f", "§7"));
                        lore1.set(2, lore1.get(2).replace("§7", "§f"));
                    } else if (lore1.get(1).startsWith("§7")) {
                        lore1.set(1, lore1.get(1).replace("§7", "§f"));
                        lore1.set(6, lore1.get(6).replace("§f", "§7"));
                    }


                    itx1.setLore(lore1);
                    e.getCurrentItem().setItemMeta(itx1);
                    p.updateInventory();

                    break;
                case LIME_STAINED_GLASS_PANE:

                    List<String> lore3 = e.getInventory().getItem(22).getItemMeta().getLore();
                    String reason = null;
                    for (String s : lore3) {
                        if (s.startsWith("§f")) {
                            reason = s.replace("§f", "");
                            break;
                        }
                    }

                    BAN_UTILS.ban(p, Bukkit.getPlayer(e.getView().getTitle().replace("§7[§6§lH§b§lH§7] §E§lBAN §8§l» §3", "").replace(" ", "")), reason);
                    p.closeInventory();

                    break;
                case RED_STAINED_GLASS_PANE:
                    p.closeInventory();
                    break;
                default:
                    break;

            }
        }
    }

}