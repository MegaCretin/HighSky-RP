package fr.highsky.roleplay.Economy.BlackMarket;

import fr.highsky.roleplay.Utils.INV_CREATOR;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class CLICK_BM_INVENTORY implements Listener {

    @EventHandler
    public void clickShopBM(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§5Marché noir §8§l» §7[§8I§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;

            }
            switch (e.getCurrentItem().getType()) {
                case NETHERITE_CHESTPLATE:
                    p.closeInventory();

                    Inventory inv = INV_CREATOR.newInv(45, "§5Marché noir §8§l» §3§lGrades");
                    for(int i=0; i<44;i++){
                        INV_CREATOR.newItem(inv, i, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§e",Arrays.asList("§e"));
                    }

                    ItemStack it = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                    ItemMeta itx = it.getItemMeta();
                    itx.setDisplayName(null);
                    itx.setLore(null);
                    it.setItemMeta(itx);

                    inv.setItem(0, it);
                    inv.setItem(1, it);
                    inv.setItem(7, it);
                    inv.setItem(8, it);
                    inv.setItem(9, it);
                    inv.setItem(17, it);
                    inv.setItem(27, it);
                    inv.setItem(35, it);
                    inv.setItem(36, it);
                    inv.setItem(37, it);
                    inv.setItem(43, it);
                    inv.setItem(44, it);

                    INV_CREATOR.newItem(inv, 20, Material.CHAINMAIL_HELMET, 1, "§8§l» §f§lÉcuyer §8§l«", Arrays.asList("","§f§lAjouts:"," §f§l→ §7Préfix dans le chat §7[§fÉcuyer§7]."," §f§l→ §73 homes."," §f§l→ §7Commande: §a/tphere <Pseudo>§7."," §f§l→ §7Commande: §a/craft§7.",""," §f§l→ §7Prix: §e100000§6$","","§7Clique ici pour acheter."));
                    INV_CREATOR.newItem(inv, 21, Material.LEATHER_HELMET, 1, "§8§l» §f§lChevalier §8§l«", Arrays.asList("","§f§lAjouts:"," §f§l→ §7Préfix dans le chat §7[§fChevalier§7]."," §f§l→ §74 homes."," §f§l→ §7Commande: §a/hat§7."," §f§l→ §7Commande: §a/enderchest§7.",""," §f§l→ §7Prix: §e250000§6$","","§7Clique ici pour acheter.","","§cGrade précédent requis."));
                    INV_CREATOR.newItem(inv, 22, Material.IRON_HELMET, 1, "§8§l» §f§lCompte §8§l«", Arrays.asList("","§f§lAjouts:"," §f§l→ §7Préfix dans le chat §7[§fCompte§7]."," §f§l→ §75 homes."," §f§l→ §7Commande: §a/back§7."," §f§l→ §7Commande: §a/feed§7."," §f§l→ §7Commande: §a/repair Hand§7.",""," §f§l→ §7Prix: §e650000§6$","","§7Clique ici pour acheter.","§cGrade précédent requis."));
                    INV_CREATOR.newItem(inv, 23, Material.GOLDEN_HELMET, 1, "§8§l» §f§lDuc §8§l«", Arrays.asList("","§f§lAjouts:"," §f§l→ §7Préfix dans le chat §7[§fDuc§7]."," §f§l→ §76 homes."," §f§l→ §7Commande: §a/repair all§7."," §f§l→ §7Commande: §a/heal§7.",""," §f§l→ §7Prix: §e1000000§6$","","§7Clique ici pour acheter.","§cGrade précédent requis."));
                    INV_CREATOR.newItem(inv, 24, Material.DIAMOND_HELMET, 1, "§8§l» §f§lPrince §8§l«", Arrays.asList("","§f§lAjouts:"," §f§l→ §7Préfix dans le chat §7[§fPrince§7]."," §f§l→ §77 homes."," §f§l→ §7Commande: §a/fly§7."," §f§l→ §7Commande: §a/kit VIP§7.",""," §f§l→ §7Prix: §e2000000§6$","","§7Clique ici pour acheter.","§cGrade précédent requis."));
                    INV_CREATOR.newItem(inv, 40, Material.BARRIER, 1, "§8§l» §c§lRetour §8§l«", Arrays.asList("","§7Retourné au menu."));

                    p.openInventory(inv);

                    break;
                case ORANGE_SHULKER_BOX:
                    p.closeInventory();

                    Inventory inv1 = INV_CREATOR.newInv(45, "§5Marché noir §8§l» §b§lClés");
                    for(int i=0; i<44;i++){
                        INV_CREATOR.newItem(inv1, i, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§e",Arrays.asList("§e"));
                    }

                    ItemStack it1 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                    ItemMeta it1x = it1.getItemMeta();
                    it1x.setDisplayName(null);
                    it1x.setLore(null);
                    it1.setItemMeta(it1x);

                    inv1.setItem(0, it1);
                    inv1.setItem(1, it1);
                    inv1.setItem(7, it1);
                    inv1.setItem(8, it1);
                    inv1.setItem(9, it1);
                    inv1.setItem(17, it1);
                    inv1.setItem(27, it1);
                    inv1.setItem(35, it1);
                    inv1.setItem(36, it1);
                    inv1.setItem(37, it1);
                    inv1.setItem(43, it1);
                    inv1.setItem(44, it1);
                    INV_CREATOR.newItem(inv1, 20, Material.TRIPWIRE_HOOK, 1, "§bClé §lCOMMUNE", Arrays.asList(""," §f§l→ §7Prix:§e 25000$","","§7Clique ici pour acheter."));
                    INV_CREATOR.newItem(inv1, 22, Material.TRIPWIRE_HOOK, 1, "§cClé §lRARE", Arrays.asList(""," §f§l→ §7Prix:§e 75000$","","§7Clique ici pour acheter."));
                    INV_CREATOR.newItem(inv1, 24, Material.TRIPWIRE_HOOK, 1, "§6Clé §lLEGENDAIRE", Arrays.asList(""," §f§l→ §7Prix:§e 200000$","","§7Clique ici pour acheter."));
                    INV_CREATOR.newItem(inv1, 40, Material.BARRIER, 1, "§8§l» §c§lRetour §8§l«", Arrays.asList("","§7Retourné au menu."));

                    p.openInventory(inv1);
                    break;
                case COMMAND_BLOCK:

                    p.closeInventory();

                    Inventory inv2 = INV_CREATOR.newInv(45, "§5Marché noir §8§l» §c§lCommandes");
                    for(int i=0; i<44;i++){
                        INV_CREATOR.newItem(inv2, i, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§e",Arrays.asList("§e"));
                    }

                    ItemStack it2 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                    ItemMeta it2x = it2.getItemMeta();
                    it2x.setDisplayName(null);
                    it2x.setLore(null);
                    it2.setItemMeta(it2x);

                    inv2.setItem(0, it2);
                    inv2.setItem(1, it2);
                    inv2.setItem(7, it2);
                    inv2.setItem(8, it2);
                    inv2.setItem(9, it2);
                    inv2.setItem(17, it2);
                    inv2.setItem(27, it2);
                    inv2.setItem(35, it2);
                    inv2.setItem(36, it2);
                    inv2.setItem(37, it2);
                    inv2.setItem(43, it2);
                    inv2.setItem(44, it2);
                    INV_CREATOR.newItem(inv2, 20, Material.NAME_TAG, 1, "§eCommande §f/NICK", Arrays.asList(""," §f§l→ §7Prix:§e 1000000$",""," §7[§fi§7]","  §7Cette commande vous permettra","  §7de changé votre pseudo","  §7grace a la commande","  §e/nick <text>§7.","","§7Cliquez ici pour acheter cette commande."));
                    INV_CREATOR.newItem(inv2, 22, Material.WRITABLE_BOOK, 1, "§eCommande §a/ITEMNAME", Arrays.asList(""," §f§l→ §7Prix:§e 1000000$",""," §7[§fi§7]","  §7Cette commande vous permettra","  §7de rennomé vos objet","  §7grace a la commande","  §e/itemname <text>§7.","","§7Cliquez ici pour acheter cette commande."));
                    INV_CREATOR.newItem(inv2, 24, Material.SPECTRAL_ARROW, 1, "§eCommande §6/GLOW", Arrays.asList(""," §f§l→ §7Prix:§e 1000000$",""," §7[§fi§7]","  §7Cette commande vous permettra","  §7de brillez grace a la","  §7commande §e/nick <text>§7.","","§7Cliquez ici pour acheter cette commande."));
                    INV_CREATOR.newItem(inv2, 40, Material.BARRIER, 1, "§8§l» §c§lRetour §8§l«", Arrays.asList("","§7Retourné au menu."));

                    p.openInventory(inv2);
                    
                    break;
                case BLACK_STAINED_GLASS_PANE:
                    break;
                default:
                    break;
            }
        }

    }

}
