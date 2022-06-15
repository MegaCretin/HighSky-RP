package fr.highsky.roleplay.Gestion.Moderation.Inventory;

import fr.highsky.roleplay.Gestion.Moderation.Utils.MUTE_UTILS;
import fr.highsky.roleplay.Gestion.Moderation.Utils.TEMPBAN_UTILS;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class MODERATION_TEMP_CLICK implements Listener {

    @EventHandler
    public void clickTime(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();


        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().startsWith("§7[§6§lH§b§lH§7] §E§lTEMPBAN §8§l»")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }

            switch (e.getCurrentItem().getType()) {
                case CLOCK:

                    List<String> lore = e.getCurrentItem().getItemMeta().getLore();
                    ItemMeta itx = e.getCurrentItem().getItemMeta();

                    if(lore.get(7).startsWith("§7")&& lore.get(6).startsWith("§f")){
                        lore.set(6, lore.get(6).replace("§f","§7"));
                        lore.set(7, lore.get(7).replace("§7","§f"));
                    }else if(lore.get(6).startsWith("§7")&& lore.get(5).startsWith("§f")){
                        lore.set(5, lore.get(5).replace("§f","§7"));
                        lore.set(6, lore.get(6).replace("§7","§f"));
                    }else if(lore.get(5).startsWith("§7")&& lore.get(4).startsWith("§f")){
                        lore.set(4, lore.get(4).replace("§f","§7"));
                        lore.set(5, lore.get(5).replace("§7","§f"));
                    }else if(lore.get(4).startsWith("§7")&& lore.get(3).startsWith("§f")){
                        lore.set(3, lore.get(3).replace("§f","§7"));
                        lore.set(4, lore.get(4).replace("§7","§f"));
                    }else if(lore.get(3).startsWith("§7")&& lore.get(2).startsWith("§f")){
                        lore.set(2, lore.get(2).replace("§f","§7"));
                        lore.set(3, lore.get(3).replace("§7","§f"));
                    }else if(lore.get(2).startsWith("§7") && lore.get(1).startsWith("§f")){
                        lore.set(1, lore.get(1).replace("§f","§7"));
                        lore.set(2, lore.get(2).replace("§7","§f"));
                    }else if(lore.get(1).startsWith("§7")){
                        lore.set(1, lore.get(1).replace("§7","§f"));
                        lore.set(7, lore.get(7).replace("§f","§7"));
                    }


                    itx.setLore(lore);
                    e.getCurrentItem().setItemMeta(itx);
                    p.updateInventory();

                    break;
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

                    List<String> lore2 = e.getInventory().getItem(20).getItemMeta().getLore();
                    String time = null;
                    for(String s:lore2){
                        if(s.startsWith("§f")){
                            time = s.replace("§f","");
                            break;
                        }
                    }

                    String[] args = time.split(" ");


                    List<String> lore3 = e.getInventory().getItem(24).getItemMeta().getLore();
                    String reason = null;
                    for(String s:lore3){
                        if(s.startsWith("§f")){
                            reason = s.replace("§f","");
                            break;
                        }
                    }

                    TEMPBAN_UTILS.tempBan(p, Bukkit.getPlayer(e.getView().getTitle().replace("§7[§6§lH§b§lH§7] §E§lTEMPBAN §8§l» §3","").replace(" ","")), reason, Integer.parseInt(args[0]),args[1].replace(" ",""));
                    p.closeInventory();

                    break;
                case RED_STAINED_GLASS_PANE:
                    p.closeInventory();
                    break;
                default:
                    break;
            }
        }else if(e.getView().getTitle().startsWith("§7[§6§lH§b§lH§7] §E§lMUTE §8§l»")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }

            switch (e.getCurrentItem().getType()) {
                case CLOCK:

                    List<String> lore = e.getCurrentItem().getItemMeta().getLore();
                    ItemMeta itx = e.getCurrentItem().getItemMeta();

                    if (lore.get(7).startsWith("§7") && lore.get(6).startsWith("§f")) {
                        lore.set(6, lore.get(6).replace("§f", "§7"));
                        lore.set(7, lore.get(7).replace("§7", "§f"));
                    } else if (lore.get(6).startsWith("§7") && lore.get(5).startsWith("§f")) {
                        lore.set(5, lore.get(5).replace("§f", "§7"));
                        lore.set(6, lore.get(6).replace("§7", "§f"));
                    } else if (lore.get(5).startsWith("§7") && lore.get(4).startsWith("§f")) {
                        lore.set(4, lore.get(4).replace("§f", "§7"));
                        lore.set(5, lore.get(5).replace("§7", "§f"));
                    } else if (lore.get(4).startsWith("§7") && lore.get(3).startsWith("§f")) {
                        lore.set(3, lore.get(3).replace("§f", "§7"));
                        lore.set(4, lore.get(4).replace("§7", "§f"));
                    } else if (lore.get(3).startsWith("§7") && lore.get(2).startsWith("§f")) {
                        lore.set(2, lore.get(2).replace("§f", "§7"));
                        lore.set(3, lore.get(3).replace("§7", "§f"));
                    } else if (lore.get(2).startsWith("§7") && lore.get(1).startsWith("§f")) {
                        lore.set(1, lore.get(1).replace("§f", "§7"));
                        lore.set(2, lore.get(2).replace("§7", "§f"));
                    } else if (lore.get(1).startsWith("§7")) {
                        lore.set(1, lore.get(1).replace("§7", "§f"));
                        lore.set(7, lore.get(7).replace("§f", "§7"));
                    }


                    itx.setLore(lore);
                    e.getCurrentItem().setItemMeta(itx);
                    p.updateInventory();

                    break;
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

                    List<String> lore2 = e.getInventory().getItem(20).getItemMeta().getLore();
                    String time = null;
                    for (String s : lore2) {
                        if (s.startsWith("§f")) {
                            time = s.replace("§f", "");
                            break;
                        }
                    }

                    String[] args = time.split(" ");


                    List<String> lore3 = e.getInventory().getItem(24).getItemMeta().getLore();
                    String reason = null;
                    for (String s : lore3) {
                        if (s.startsWith("§f")) {
                            reason = s.replace("§f", "");
                            break;
                        }
                    }

                    MUTE_UTILS.Mute(p, Bukkit.getPlayer(e.getView().getTitle().replace("§7[§6§lH§b§lH§7] §E§lMUTE §8§l» §3", "").replace(" ", "")), reason, Integer.parseInt(args[0]), args[1].replace(" ", ""));
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
