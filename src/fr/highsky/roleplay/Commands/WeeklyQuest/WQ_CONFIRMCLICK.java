package fr.highsky.roleplay.Commands.WeeklyQuest;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Economy.Shop.Utils.ShopTools;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;
import java.util.Calendar;

public class WQ_CONFIRMCLICK implements Listener {

    
    private float amount = 0;

    @EventHandler
    public void onClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        Calendar cal = Calendar.getInstance();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase(Main.getInstance().getConfig().getString("WeeklyQuest.Menu.Confirmation").replace("&","§"))) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }
            switch (e.getCurrentItem().getType()){
                case LIME_STAINED_GLASS_PANE:
                    if(p.getInventory().contains(Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")))){
                        for(int n1 = 0; n1 <= 36; n1++) {
                            if (p.getInventory().getItem(n1) != null ) {
                                if(p.getInventory().getItem(n1).getType() == Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems"))){
                                    amount = amount + p.getInventory().getItem(n1).getAmount();
                                }
                            }
                        }
                        try {
                            if(!WQ_BDD.playerExist(p)) {
                                int a = (int) amount;
                                ItemStack ui = new ItemStack(Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")));
                                ItemStack is= new ItemStack(Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")), a);
                                double price = ShopTools.checkSellPrice(ui);
                                double endprice = price * amount;
                                MoneyAPI.giveMoney(p, (Double.valueOf(endprice)/2));
                                WQ_BDD.addPlayer(p);
                                WQ_BDD.addItem(p, a);
                                p.sendMessage(Main.getInstance().getConfig().getString("WeeklyQuest.Messages.Prefix").replace("&", "§") + Main.getInstance().getConfig().getString("WeeklyQuest.Messages.AddBDD").replace("&", "§").replace("%oldnumber%", ""+a).replace("%newnumber%", ""+a).replace("%money%", ""+(endprice/2)));
                                p.getInventory().removeItem(is);
                                System.out.println("[WeaklyQuest][ADD] "+p.getName()+":"+p.getUniqueId()+":" + amount +":"+ (endprice/2)+":"+ Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")).toString().toLowerCase());
                            }else{
                                ItemStack ui = new ItemStack(Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")));
                                float nbr = WQ_BDD.checkNbr(p.getName());
                                float end = amount + nbr;
                                int end2 = (int) end;
                                ItemStack is= new ItemStack(Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")), end2);
                                double price = ShopTools.checkSellPrice(ui);
                                double endprice = price * amount;
                                MoneyAPI.giveMoney(p, (Double.valueOf(endprice)/2));
                                WQ_BDD.addItem(p, end2);
                                p.sendMessage(Main.getInstance().getConfig().getString("WeeklyQuest.Messages.Prefix").replace("&", "§") + Main.getInstance().getConfig().getString("WeeklyQuest.Messages.AddBDD").replace("&", "§").replace("%oldnumber%", ""+amount).replace("%newnumber%", ""+end2).replace("%money%", ""+(endprice/2)));
                                p.getInventory().removeItem(is);
                                System.out.println("[WeaklyQuest][ADD] "+p.getName()+":"+p.getUniqueId()+":" + amount +":"+ (endprice/2)+":"+ Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")).toString().toLowerCase());
                            }
                            amount = 0;
                        } catch (SQLException ev) {
                            ev.printStackTrace();
                        }
                        p.closeInventory();
                    }else{

                        p.closeInventory();
                        p.sendMessage(Main.getInstance().getConfig().getString("WeeklyQuest.Messages.Prefix").replace("&", "§") + Main.getInstance().getConfig().getString("Messages.WeeklyQuest.NothingInv").replace("&","§"));

                    }
                    break;
                case RED_STAINED_GLASS_PANE:
                    Bukkit.dispatchCommand(p, "dh");
                default:
                    break;
            }

        }
    }
}
