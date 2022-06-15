package fr.highsky.roleplay.Economy.Shop.Events;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Economy.Shop.Utils.SHOPTYPE;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CLICK_SHOP implements Listener {

    @EventHandler
    public void clickShop(InventoryClickEvent e){
        Player p = (Player)e.getWhoClicked();
        if (e.getClickedInventory() == null)
            e.setCancelled(true);
        if (e.getView().getTitle().equalsIgnoreCase("§bShop §8» §3Blocks") ||
                e.getView().getTitle().equalsIgnoreCase("§bShop §8» §5Loots") ||
                e.getView().getTitle().equalsIgnoreCase("§bShop §8» §eMinerais") ||
                e.getView().getTitle().equalsIgnoreCase("§bShop §8» §aNature") ||
                e.getView().getTitle().equalsIgnoreCase("§bShop §8» Nourriture") ||
                e.getView().getTitle().equalsIgnoreCase("§bShop §8» §2Divers") ||
                e.getView().getTitle().equalsIgnoreCase("§bShop §8» §dCorails")||
                e.getView().getTitle().equalsIgnoreCase("§bShop §8» §6Promotions")||
                e.getView().getTitle().equalsIgnoreCase("§bShop §8» §9World")||
                e.getView().getTitle().equalsIgnoreCase("§bShop §8» §eFleurs")||
                e.getView().getTitle().equalsIgnoreCase("§bShop §8» §7Caverne")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;
            }
            if (e.getClick() == ClickType.LEFT && !e.getView().getTitle().equals("§6§lH§7-§b§lShop") && !e.getView().getTitle().equalsIgnoreCase("§b[§6H§b]  §aAchat") && e.getCurrentItem().getType() != Material.BARRIER) {

                String[] lore = e.getCurrentItem().getItemMeta().getLore().toString().split(",");
                String lores = lore[1].replace("§f┃ §a§l","").replace("§f§l:","").replace(" ","");
                if (!lores.contains("Achat") && e.getCurrentItem().getType() != Material.ARROW && e.getCurrentItem().getType() != Material.LIME_TERRACOTTA && e.getCurrentItem().getType() != Material.GOLD_NUGGET) {
                    p.sendMessage("§6§lHigh§b§lSky §7» §cCet item n'est pas achetable.");
                    e.setCancelled(true);
                    return;
                }


                String s = e.getCurrentItem().getItemMeta().getLore().toString().replace("§f┃  ▶ §b§l", "").replace(" ", "");
                String[] s1 = s.split(",");
                Double price = Double.valueOf(s1[2]);

                Inventory invAchat = Bukkit.createInventory(null, 54, "§b[§6H§b]  §aAchat");

                SHOPTYPE.addStyle(invAchat);

                int item = 1;

                ItemStack it1 = new ItemStack(e.getCurrentItem().getType());
                ItemMeta itx1 = it1.getItemMeta();
                itx1.setDisplayName(e.getCurrentItem().getItemMeta().getDisplayName());
                itx1.setLore(Arrays.asList("§f┏          ━━━━━━", "§f┃ §a§lAchat§f§l:", "§f┃  ▶ §6Prix: §b§l"+price+" §7(§e"+price+"/u§7)", "§f┣          ━━━━━━","§f┃ §a§lQuantité: ", "§f┃  ▶ §b§l"+item+" §6items.","§f┗          ━━━━━━"));
                it1.setItemMeta(itx1);
                invAchat.setItem(13, it1);


                //Catégorie retrait
                ItemStack is0 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
                ItemMeta im0 = is0.getItemMeta();
                im0.setDisplayName("§7---[§cRETIRE 1§7]---");
                im0.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §cretirer 1 item.","§f             ----------"));
                is0.setItemMeta(im0);
                invAchat.setItem(21, is0);

                ItemStack is1 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 10);
                ItemMeta im1 = is1.getItemMeta();
                im1.setDisplayName("§7---[§cRETIRE 10§7]---");
                im1.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §cretirer 10 items.","§f             ----------"));
                is1.setItemMeta(im1);
                invAchat.setItem(20, is1);

                ItemStack is2 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 63);
                ItemMeta im2 = is2.getItemMeta();
                im2.setDisplayName("§7---[§cRETIRE 63§7]---");
                im2.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §cretirer 63 items.","§f             ----------"));
                is2.setItemMeta(im2);
                invAchat.setItem(19, is2);



                //Catégorie ajout
                ItemStack is3 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
                ItemMeta im3 = is3.getItemMeta();
                im3.setDisplayName("§7---[§aAJOUTE 1§7]---");
                im3.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §aajouter 1 item.","§f             ----------"));
                is3.setItemMeta(im3);
                invAchat.setItem(23, is3);


                ItemStack is4 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 10);
                ItemMeta im4 = is4.getItemMeta();
                im4.setDisplayName("§7---[§aAJOUTE 10§7]---");
                im4.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §aajouter 10 items.","§f             ----------"));
                is4.setItemMeta(im4);
                invAchat.setItem(24, is4);


                ItemStack is5 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 63);
                ItemMeta im5 = is5.getItemMeta();
                im5.setDisplayName("§7---[§aAJOUTE 63§7]---");
                im5.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §aajouter 63 items.","§f             ----------"));
                is5.setItemMeta(im5);
                invAchat.setItem(25, is5);



                //Remplir l'inventaire
                int slot = 0;
                for(int i=0;i<36;i++){
                    if(p.getInventory().getItem(i) == null){
                        slot ++;
                    }
                }

                slot = slot*64;

                ItemStack is6 = new ItemStack(Material.CHEST);
                ItemMeta im6 = is6.getItemMeta();
                im6.setDisplayName("§7---[ §3Remplir l'inventaire §7]---");
                im6.setLore(Arrays.asList("§f┏          ━━━━━━","§f┃ §a§lAchat§f§l:", "§f┃  ▶ §6Prix: §b§l"+(price*slot)+" §7(§e"+price+"/u§7)","§f┣          ━━━━━━","§f┃ §a§lQuantité: ", "§f┃  ▶ §b§l"+slot+" §6items.","§f┗          ━━━━━━"));
                is6.setItemMeta(im6);
                invAchat.setItem(38, is6);


                //Achat par stack

                ItemStack is7 = new ItemStack(Material.BARREL);
                ItemMeta im7 = is7.getItemMeta();
                im7.setDisplayName("§7---[ §dAchat par Stack §7]---");
                im7.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §6acheter par stack.","§f             ----------"));
                is7.setItemMeta(im7);
                invAchat.setItem(42, is7);



                //Validé

                ItemStack is10 = new ItemStack(Material.LIME_TERRACOTTA);
                ItemMeta im10 = is10.getItemMeta();
                im10.setDisplayName("§aValidé");
                im10.setLore(Arrays.asList());
                is10.setItemMeta(im10);
                invAchat.setItem(49, is10);



                //Retour
                ItemStack is8 = new ItemStack(Material.ARROW);
                ItemMeta im8 = is8.getItemMeta();
                im8.setDisplayName("§7---[ §cRetour §7]---");
                im8.setLore(Arrays.asList("§f                   ----------","§9▶ §eClique pour §cretourné au menu précédent.","§f                   ----------"));
                is8.setItemMeta(im8);
                invAchat.setItem(45, is8);



                //Argent
                ItemStack is9 = new ItemStack(Material.GOLD_NUGGET);
                ItemMeta im9 = is9.getItemMeta();
                im9.setDisplayName("§7---[ §6Argent §7]---");
                im9.setLore(Arrays.asList("§f┏          ━━━━━━","§f┃ §a§lArgent de §6§l"+p.getName()+"§f§l:", "§f┃  ▶ §b§l"+ MoneyAPI.getMoney(p),"§f┗          ━━━━━━"));
                is9.setItemMeta(im9);
                invAchat.setItem(53, is9);



                p.closeInventory();
                p.openInventory(invAchat);
            }
            if (e.getClick() == ClickType.RIGHT && !e.getView().getTitle().equals("§6§lH§7-§b§lShop") && !e.getView().getTitle().equalsIgnoreCase("§b[§6H§b]  §aAchat") && e.getCurrentItem().getType() != Material.BARRIER) {

                if (!e.getCurrentItem().getItemMeta().getLore().toString().contains("§f┃ §c§lVente§f§l:") && e.getCurrentItem().getType() != Material.ARROW && e.getCurrentItem().getType() != Material.LIME_TERRACOTTA && e.getCurrentItem().getType() != Material.GOLD_NUGGET) {
                    p.sendMessage("§6§lHigh§b§lSky §7» §cCet item n'est pas vendable.");
                    e.setCancelled(true);
                    return;
                }

                Double price = 0.0;

                String s = e.getCurrentItem().getItemMeta().getLore().toString();
                String[] s1 = s.split(",");
                for(int i = 0;i<s1.length;i++){
                    if(s1[i].contains("§f┃ §c§lVente§f§l:")){
                        price = Double.valueOf(s1[i+1].replace("§f┃  ▶ §b§l","").replace(" ",""));
                    }
                }

                Inventory invAchat = Bukkit.createInventory(null, 54, "§b[§6H§b] §cVente");

                SHOPTYPE.addStyle(invAchat);

                int item = 1;

                ItemStack it1 = new ItemStack(e.getCurrentItem().getType());
                ItemMeta itx1 = it1.getItemMeta();
                itx1.setDisplayName(e.getCurrentItem().getItemMeta().getDisplayName());
                itx1.setLore(Arrays.asList("§f┏          ━━━━━━", "§f┃ §c§lVente§f§l:", "§f┃  ▶ §6Prix: §b§l"+price+" §7(§e"+price+"/u§7)", "§f┣          ━━━━━━","§f┃ §a§lQuantité: ", "§f┃  ▶ §b§l"+item+" §6items.","§f┗          ━━━━━━"));
                it1.setItemMeta(itx1);
                invAchat.setItem(13, it1);


                //Catégorie retrait
                ItemStack is0 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
                ItemMeta im0 = is0.getItemMeta();
                im0.setDisplayName("§7---[§cRETIRE 1§7]---");
                im0.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §cretirer 1 item.","§f             ----------"));
                is0.setItemMeta(im0);
                invAchat.setItem(30, is0);

                ItemStack is1 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 10);
                ItemMeta im1 = is1.getItemMeta();
                im1.setDisplayName("§7---[§cRETIRE 10§7]---");
                im1.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §cretirer 10 items.","§f             ----------"));
                is1.setItemMeta(im1);
                invAchat.setItem(29, is1);

                ItemStack is2 = new ItemStack(Material.RED_STAINED_GLASS_PANE, 63);
                ItemMeta im2 = is2.getItemMeta();
                im2.setDisplayName("§7---[§cRETIRE 63§7]---");
                im2.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §cretirer 63 items.","§f             ----------"));
                is2.setItemMeta(im2);
                invAchat.setItem(28, is2);



                //Catégorie ajout
                ItemStack is3 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
                ItemMeta im3 = is3.getItemMeta();
                im3.setDisplayName("§7---[§aAJOUTE 1§7]---");
                im3.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §ajouter 1 item.","§f             ----------"));
                is3.setItemMeta(im3);
                invAchat.setItem(32, is3);


                ItemStack is4 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 10);
                ItemMeta im4 = is4.getItemMeta();
                im4.setDisplayName("§7---[§aAJOUTE 10§7]---");
                im4.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §ajouter 10 items.","§f             ----------"));
                is4.setItemMeta(im4);
                invAchat.setItem(33, is4);


                ItemStack is5 = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 63);
                ItemMeta im5 = is5.getItemMeta();
                im5.setDisplayName("§7---[§aAJOUTE 63§7]---");
                im5.setLore(Arrays.asList("§f             ----------","§9▶ §eClique pour §ajouter 63 items.","§f             ----------"));
                is5.setItemMeta(im5);
                invAchat.setItem(34, is5);



                //Validé

                ItemStack is10 = new ItemStack(Material.LIME_TERRACOTTA);
                ItemMeta im10 = is10.getItemMeta();
                im10.setDisplayName("§aValidé");
                im10.setLore(Arrays.asList());
                is10.setItemMeta(im10);
                invAchat.setItem(49, is10);



                //Retour
                ItemStack is8 = new ItemStack(Material.ARROW);
                ItemMeta im8 = is8.getItemMeta();
                im8.setDisplayName("§7---[ §cRetour §7]---");
                im8.setLore(Arrays.asList("§f                   ----------","§9▶ §eClique pour §cretourné au menu précédent.","§f                   ----------"));
                is8.setItemMeta(im8);
                invAchat.setItem(45, is8);



                //Argent
                ItemStack is9 = new ItemStack(Material.GOLD_NUGGET);
                ItemMeta im9 = is9.getItemMeta();
                im9.setDisplayName("§7---[ §6Argent §7]---");
                im9.setLore(Arrays.asList("§f┏          ━━━━━━","§f┃ §a§lArgent de §6§l"+p.getName()+"§f§l:", "§f┃  ▶ §b§l"+ MoneyAPI.getMoney(p) +" §7(§e"+price+"/u§7)","§f┗          ━━━━━━"));
                is9.setItemMeta(im9);
                invAchat.setItem(53, is9);



                p.closeInventory();
                p.openInventory(invAchat);
            }

            else if (e.getClick() == ClickType.MIDDLE && !e.getView().getTitle().equals("§6§lH§7-§b§lShop") && !e.getView().getTitle().equalsIgnoreCase("§b[§6§b]  §cVente") && e.getCurrentItem().getType() != Material.BARRIER) {
                Double price = 0.00;
                if (!e.getCurrentItem().getItemMeta().getLore().toString().contains("§f┃ §c§lVente§f§l:")) {
                    p.sendMessage("§6§lHigh§b§lSky §7§l» §cCette item n'est pas vendable.");
                    return;
                }

                String s = e.getCurrentItem().getItemMeta().getLore().toString();
                String[] s1 = s.split(",");
                for (int i = 0; i < s1.length; i++) {
                    if (s1[i].contains("§f┃ §c§lVente§f§l:")) {
                        price = Double.valueOf(s1[i + 1].replace("§f┃  ▶ §b§l", "").replace(" ", ""));
                    }
                }

                int fullsell = 0;
                if (p.getInventory().contains(e.getCurrentItem().getType())) {
                    for (int i = 0; i < 36; i++) {
                        if (p.getInventory().getItem(i) != null && p.getInventory().getItem(i).getType() == e.getCurrentItem().getType()) {
                            fullsell += p.getInventory().getItem(i).getAmount();
                        }
                    }
                    if (!(fullsell == 0)) {
                        if (Main.getInstance().getConfig().getBoolean("Double.Enable") == false) {
                            MoneyAPI.giveMoney(p, (price * fullsell));
                            p.getInventory().removeItem(new ItemStack[]{new ItemStack(e.getCurrentItem().getType(), fullsell)});
                            p.sendMessage("§6§lHigh§b§lSky §7§l» §e" + (price * fullsell) + "$§a viens d'être ajouté à ton compte.");


                        }
                        p.updateInventory();
                    }
                }else p.sendMessage("§6§lHigh§b§lSky §7§l» §cTu n'as pas cet item dans ton inventaire.");
            }
        }
    }

}
