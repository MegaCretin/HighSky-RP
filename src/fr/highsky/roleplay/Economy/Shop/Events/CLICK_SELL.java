package fr.highsky.roleplay.Economy.Shop.Events;

import fr.herllox.hmoney.API.MoneyAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class CLICK_SELL implements Listener {

    @EventHandler
    public void clickBuy(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();


        if (e.getClickedInventory() == null) {
            e.setCancelled(true);
        }
        if (e.getView().getTitle().equalsIgnoreCase("§b[§6H§b] §cVente")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }

            ItemStack aa = e.getInventory().getItem(13);
            ItemMeta it = aa.getItemMeta();
            String[] lore1 = it.getLore().toString().split(",");
            int nbr = Integer.parseInt(lore1[5].replace("§f┃  ▶ §b§l", "").replace(" §6items.", "").replace(" ", ""));
            int amount = e.getCurrentItem().getAmount();
            String[] lore2 = lore1[2].split(" ");
            Double initPrice = Double.valueOf(lore2[6].replace("§7(§e", "").replace("/u§7)", "").replace(" ", ""));
            switch (e.getCurrentItem().getType()) {
                case RED_STAINED_GLASS_PANE:


                    if ((nbr - amount) >= 1) {


                        List<String> lores = it.getLore();

                        lores.set(2, "§f┃  ▶ §6Prix: §b§l" + initPrice * (nbr - amount) + " §7(§e" + initPrice + "/u§7)");
                        lores.set(5, "§f┃  ▶ §b§l" + (nbr - amount) + " §6items.");


                        aa.setAmount((nbr - amount));
                        it.setLore(lores);
                        aa.setItemMeta(it);
                        p.updateInventory();

                    }

                    break;
                case LIME_STAINED_GLASS_PANE:

                    if ((nbr + amount) <= 64) {

                        List<String> lores = it.getLore();

                        lores.set(2, "§f┃  ▶ §6Prix: §b§l" + initPrice * (nbr + amount) + " §7(§e" + initPrice + "/u§7)");
                        lores.set(5, "§f┃  ▶ §b§l" + (nbr + amount) + " §6items.");


                        aa.setAmount((nbr + amount));
                        it.setLore(lores);
                        aa.setItemMeta(it);
                        p.updateInventory();

                    }

                    break;

                case LIME_TERRACOTTA:

                    double price = (initPrice * nbr);

                    if(p.getInventory().containsAtLeast(new ItemStack(e.getInventory().getItem(13).getType()), nbr)){
                        MoneyAPI.giveMoney(p, price);
                        p.getInventory().removeItem(new ItemStack(e.getInventory().getItem(13).getType(), nbr));
                        p.closeInventory();
                        p.sendMessage("§6§lHigh§b§lSky §7§l» §e" + price + "$ §Fviens d'être ajouté à ton compte.");
                    }else{
                        e.setCancelled(true);
                        p.sendMessage("§6§lHigh§b§lSky §7§l» §cTu n'as pas cet item dans ton inventaire.");
                    }

                    break;
                case ARROW:
                    p.closeInventory();
                    break;
                default:
                    break;
            }
        }
    }
}
