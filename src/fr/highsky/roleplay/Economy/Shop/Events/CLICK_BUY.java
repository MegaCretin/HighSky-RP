package fr.highsky.roleplay.Economy.Shop.Events;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Economy.Shop.Utils.SHOPTYPE;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CLICK_BUY implements Listener {

    @EventHandler
    public void clickBuy(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();


        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§b[§6H§b]  §aAchat")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }

            ItemStack aa = e.getInventory().getItem(13);
            ItemMeta it = aa.getItemMeta();
            String[] lore1 = it.getLore().toString().split(",");
            int nbr = Integer.parseInt(lore1[5].replace("§f┃  ▶ §b§l","").replace(" §6items.","").replace(" ",""));
            int amount = e.getCurrentItem().getAmount();
            String[] lore2 = lore1[2].split(" ");
            Double initPrice = Double.valueOf(lore2[6].replace("§7(§e","").replace("/u§7)","").replace(" ",""));
            boolean inv = true;
            switch (e.getCurrentItem().getType()){
                case RED_STAINED_GLASS_PANE:


                    if((nbr - amount) >= 1){


                        List<String> lores = it.getLore();

                        lores.set(2, "§f┃  ▶ §6Prix: §b§l"+initPrice*(nbr-amount)+" §7(§e"+initPrice+"/u§7)");
                        lores.set(5,"§f┃  ▶ §b§l"+(nbr-amount)+" §6items.");


                        aa.setAmount((nbr-amount));
                        it.setLore(lores);
                        aa.setItemMeta(it);
                        p.updateInventory();

                    }

                    break;
                case LIME_STAINED_GLASS_PANE:

                    if((nbr + amount) <= 64){

                        List<String> lores = it.getLore();

                        lores.set(2, "§f┃  ▶ §6Prix: §b§l"+initPrice*(nbr+amount)+" §7(§e"+initPrice+"/u§7)");
                        lores.set(5,"§f┃  ▶ §b§l"+(nbr+amount)+" §6items.");


                        aa.setAmount((nbr+amount));
                        it.setLore(lores);
                        aa.setItemMeta(it);
                        p.updateInventory();

                    }

                    break;

                case LIME_TERRACOTTA:

                    double price = (initPrice*nbr);

                    for (int i = 0; i < 36; i++) {
                        if (p.getInventory().firstEmpty() == i)
                            inv = false;
                        if (!inv)
                            break;
                    }
                    if (inv) {
                        e.setCancelled(true);
                        p.sendMessage("§6§lHigh§b§lSky §7§l» §cVotre inventaire est plein.");
                        return;
                    }else {
                        if (MoneyAPI.getMoney(p) < price) {
                            e.setCancelled(true);
                            p.sendMessage("§6§lHigh§b§lSky §7§l» §cTu n'as pas assez d'argent.");
                            return;
                        }else{
                            MoneyAPI.removeMoney(p, price);
                            p.getInventory().addItem(new ItemStack(aa.getType(), nbr));
                            p.sendMessage("§6§lHigh§b§lSky §7§l» §e"+ price + "$ §Fviens d'être retiré de ton compte.");
                            p.closeInventory();
                        }
                    }



                    break;
                case CHEST:

                    String[] desc = e.getCurrentItem().getItemMeta().getLore().toString().split(",");

                    Double prix = Double.valueOf(desc[2].replace("§f┃  ▶ §6Prix: §b§l","").replace(" §7(§e"+initPrice+"/u§7)","").replace(" ", ""));
                    int items = Integer.parseInt(desc[5].replace("§f┃  ▶ §b§l","").replace(" §6items.","").replace(" ", ""));

                    for (int i = 0; i < 36; i++) {
                        if (p.getInventory().firstEmpty() == i)
                            inv = false;
                        if (!inv)
                            break;
                    }
                    if (inv) {
                        e.setCancelled(true);
                        p.sendMessage("§6§lHigh§b§lSky §7§l» §cVotre inventaire est plein.");
                        return;
                    }else {
                        if (MoneyAPI.getMoney(p) < prix) {
                            p.sendMessage("§6§lHigh§b§lSky §7§l» §cTu n'as pas assez d'argent.");
                            e.setCancelled(true);
                            return;
                        }else{
                            MoneyAPI.removeMoney(p, prix);
                            p.getInventory().addItem(new ItemStack(aa.getType(), items));
                            p.sendMessage("§6§lHigh§b§lSky §7§l» §e"+ prix + "$ §Fviens d'être retiré de ton compte.");
                            p.closeInventory();
                        }
                    }

                    break;
                case BARREL:
                    
                    Inventory stackinv = Bukkit.createInventory(null, 54, "§b[§6H§b]  §aAchat §7/ §eStack");

                    SHOPTYPE.addStyle(stackinv);
                    
                    ItemStack item = new ItemStack(e.getInventory().getItem(13).getType(), 2);
                    ItemMeta itemMeta = item.getItemMeta();
                    itemMeta.setDisplayName(e.getInventory().getItem(13).getItemMeta().getDisplayName());
                    itemMeta.setLore(Arrays.asList("§f┏          ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §6Prix: §b§l"+((initPrice*2)*64)+" §7(§e"+initPrice+"/u§7)", "§f┣          ━━━━━━","§f┃ §a§lQuantité: ", "§f┃  ▶ §b§l2 §6Stacks.","§f┗          ━━━━━━"));
                    item.setItemMeta(itemMeta);
                    stackinv.setItem(13, item);
                    
                    ItemStack stack2 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 2);
                    ItemMeta stack2x = stack2.getItemMeta();
                    stack2x.setDisplayName("§7---[§aAJOUTE 2 STACK§7]---");
                    stack2x.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §amettre à 2 stacks.","§f             ----------"));
                    stack2.setItemMeta(stack2x);
                    stackinv.setItem(28, stack2);

                    ItemStack stack4 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 4);
                    ItemMeta stack4x = stack4.getItemMeta();
                    stack4x.setDisplayName("§7---[§aAJOUTE 4 STACK§7]---");
                    stack4x.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §amettre à 4 stacks.","§f             ----------"));
                    stack4.setItemMeta(stack4x);
                    stackinv.setItem(29, stack4);

                    ItemStack stack8 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 8);
                    ItemMeta stack8x = stack8.getItemMeta();
                    stack8x.setDisplayName("§7---[§aAJOUTE 8 STACK§7]---");
                    stack8x.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §amettre à 8 stacks.","§f             ----------"));
                    stack8.setItemMeta(stack8x);
                    stackinv.setItem(30, stack8);
                    
                    ItemStack stack16 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 16);
                    ItemMeta stack16x = stack16.getItemMeta();
                    stack16x.setDisplayName("§7---[§aAJOUTE 16 STACK§7]---");
                    stack16x.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §amettre à 16 stacks.","§f             ----------"));
                    stack16.setItemMeta(stack16x);
                    stackinv.setItem(31, stack16);
                    
                    ItemStack stack24 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 24);
                    ItemMeta stack24x = stack24.getItemMeta();
                    stack24x.setDisplayName("§7---[§aAJOUTE 24 STACK§7]---");
                    stack24x.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §amettre à 24 stacks.","§f             ----------"));
                    stack24.setItemMeta(stack24x);
                    stackinv.setItem(32, stack24);

                    ItemStack stack32 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 32);
                    ItemMeta stack32x = stack32.getItemMeta();
                    stack32x.setDisplayName("§7---[§aAJOUTE 32 STACK§7]---");
                    stack32x.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §amettre à 32 stacks.","§f             ----------"));
                    stack32.setItemMeta(stack32x);
                    stackinv.setItem(33, stack32);

                    ItemStack stack36 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 36);
                    ItemMeta stack36x = stack36.getItemMeta();
                    stack36x.setDisplayName("§7---[§aAJOUTE 36 STACK§7]---");
                    stack36x.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §amettre à 36 stacks.","§f             ----------"));
                    stack36.setItemMeta(stack36x);
                    stackinv.setItem(34, stack36);

                    ItemStack is10 = new ItemStack(Material.LIME_TERRACOTTA);
                    ItemMeta im10 = is10.getItemMeta();
                    im10.setDisplayName("§aValidé");
                    im10.setLore(Arrays.asList());
                    is10.setItemMeta(im10);
                    stackinv.setItem(49, is10);

                    ItemStack is8 = new ItemStack(Material.ARROW);
                    ItemMeta im8 = is8.getItemMeta();
                    im8.setDisplayName("§7---[ §cRetour §7]---");
                    im8.setLore(Arrays.asList("§f                   ----------","§9▶ §eClique pour §cretourné au menu précédent.","§f                   ----------"));
                    is8.setItemMeta(im8);
                    stackinv.setItem(45, is8);

                    ItemStack is9 = new ItemStack(Material.GOLD_NUGGET);
                    ItemMeta im9 = is9.getItemMeta();
                    im9.setDisplayName("§7---[ §6Argent §7]---");
                    im9.setLore(Arrays.asList("§f┏          ━━━━━━","§f┃ §a§lArgent de §6§l"+p.getName()+"§f§l:", "§f┃  ▶ §b§l"+ MoneyAPI.getMoney(p),"§f┗          ━━━━━━"));
                    is9.setItemMeta(im9);
                    stackinv.setItem(53, is9);

                    p.closeInventory();
                    p.openInventory(stackinv);


                    break;
                case ARROW:
                    p.closeInventory();
                    break;
                default:
                    break;
            }

        }
    }

    @EventHandler
    public void clickBuyStack(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (e.getClickedInventory() == null) {
            e.setCancelled(true);
        }
        if (e.getView().getTitle().equalsIgnoreCase("§b[§6H§b]  §aAchat §7/ §eStack")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }
            String[] lore = e.getInventory().getItem(13).getItemMeta().getLore().toString().split(",");
            String[] loreprice = lore[2].split(" ");
            Double price = Double.valueOf(loreprice[5].replace("§b§l","").replace(" ",""));
            Double initPrice = Double.valueOf(loreprice[6].replace("§7(§e","").replace("/u§7)","").replace(" ",""));
            int amount = Integer.parseInt(lore[5].replace("§f┃  ▶ §b§l","").replace(" §6Stacks.","").replace(" ",""));
            ItemStack aa = e.getInventory().getItem(13);
            ItemMeta it = aa.getItemMeta();
            switch (e.getCurrentItem().getType()){
                case LIME_STAINED_GLASS_PANE:

                    List<String> lores = it.getLore();

                    aa.setAmount(e.getCurrentItem().getAmount());

                    lores.set(2, "§f┃  ▶ §6Prix: §b§l"+(initPrice*(e.getCurrentItem().getAmount()*64))+" §7(§e"+initPrice+"/u§7)");
                    lores.set(5,  "§f┃  ▶ §b§l"+e.getCurrentItem().getAmount()+" §6Stacks.");

                    aa.setAmount(e.getCurrentItem().getAmount());
                    it.setLore(lores);
                    aa.setItemMeta(it);
                    p.updateInventory();
                    break;
                case LIME_TERRACOTTA:

                    int slot=0;

                    for(int i=0;i<36;i++){
                        if(p.getInventory().getItem(i) == null){
                            slot++;
                        }
                    }

                    if(slot >= amount){
                        if(MoneyAPI.getMoney(p) >= price){
                            MoneyAPI.removeMoney(p, price);
                            p.getInventory().addItem(new ItemStack(aa.getType(), (amount*64)));
                            p.sendMessage("§6§lHigh§b§lSky §7§l» §e"+ price + "$ §Fviens d'être retiré de ton compte.");
                        }else {
                            e.setCancelled(true);
                            p.sendMessage("§6§lHigh§b§lSky §7§l» §cTu n'as pas assez d'argent.");
                            return;
                        }
                    }else {
                        e.setCancelled(true);
                        p.sendMessage("§6§lHigh§b§lSky §7§l» §cTu n'as pas assez de place dans ton inventaire.");
                        return;
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
