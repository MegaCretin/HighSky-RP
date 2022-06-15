package fr.highsky.roleplay.Commands.WeeklyQuest;

import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Economy.Shop.Utils.ShopTools;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Calendar;

public class WQ_CLICKITEM implements Listener {

    private float amount = 0;

    @EventHandler
    public void onClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        Calendar cal = Calendar.getInstance();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§3Quêtes Hebdomadaire §8§l» §7[§8I§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }
            if(e.getSlot() == 38){

                ItemStack is= new ItemStack(Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")));
                if(p.getInventory().contains(Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")))) {
                    for (int n1 = 0; n1 <= 36; n1++) {
                        if (p.getInventory().getItem(n1) != null) {
                            if (p.getInventory().getItem(n1).getType() == Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems"))) {
                                amount = amount + p.getInventory().getItem(n1).getAmount();

                            }
                        }

                    }
                    double price = ShopTools.checkSellPrice(is);
                    double endprice = price * amount;

                    Inventory inv = Bukkit.createInventory(null, 27, Main.getInstance().getConfig().getString("WeeklyQuest.Menu.Confirmation").replace("&", "§"));

                    ItemStack conf = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
                    ItemMeta confx = conf.getItemMeta();
                    confx.setDisplayName("§aConfirmation");
                    confx.setLore(Arrays.asList("",  " §7• Gains: §f" + (endprice/2) + " §f$"," §7• Nombre: §f" + amount + "§f Items"," ", "§7En cliquant ici, tu confirmes vouloir", "§7transférer tes items pour cette quêtes."));
                    conf.setItemMeta(confx);
                    inv.setItem(11, conf);


                    ItemStack canc = new ItemStack(Material.RED_STAINED_GLASS_PANE,1);
                    ItemMeta cancx = conf.getItemMeta();
                    cancx.setDisplayName("§cRetour");
                    cancx.setLore(Arrays.asList("","§7En cliquant ici, tu annules le transfert","§7des items pour la quêtes."));
                    canc.setItemMeta(cancx);
                    inv.setItem(15, canc);

                    p.closeInventory();
                    p.openInventory(inv);
                    amount = 0;

                }else{
                    p.closeInventory();
                    p.sendMessage(Main.getInstance().getConfig().getString("WeeklyQuest.Messages.Prefix").replace("&", "§") + Main.getInstance().getConfig().getString("WeeklyQuest.Messages.NeedItem").replace("&", "§"));

                    return;
                }


            }

        }
    }
    
    
}
