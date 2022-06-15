package fr.highsky.roleplay.Gestion.Moderation.Utils;

import fr.highsky.roleplay.Utils.INV_CREATOR;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class MODERATION_INV_UTILS {

    public static Inventory timeInv(Player p, String Type){

        Inventory inv = INV_CREATOR.newInv(45, "§7[§6§lH§b§lH§7] §E§l"+Type+" §8§l» §3"+p.getName());

        for (int i = 0; i<45; i++){
            INV_CREATOR.newItem(inv , i, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        }

        INV_CREATOR.newItem(inv , 0, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 1, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 7, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 8, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 9, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 17, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 27, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 35, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 36, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 37, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 43, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 44, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));

        INV_CREATOR.newItem(inv, 20, Material.CLOCK, 1,"§8§l» §a§lTEMPS §8§l«", Arrays.asList("§7[§fi§7]","§715 Minutes","§730 Minutes","§71 Heure","§72 Heures","§712 Heures","§71 Jours","§77 Jours"));
        INV_CREATOR.newItem(inv, 24, Material.BOOK, 1,"§8§l» §3§lRAISON §8§l«", Arrays.asList("§7[§fi§7]","§7Insultes","§7Utilisation de bug","§7Triche","§7AFK Farm/Mine","§7Flood/Spam","§7Autres"));

        INV_CREATOR.newItem(inv, 39, Material.LIME_STAINED_GLASS_PANE, 1, "§8§l» §aVALIDÉ §8§l«", Arrays.asList("§7[§fi§7]","§7Clique ici pour confirmé","§7la sanction."));
        INV_CREATOR.newItem(inv, 41, Material.RED_STAINED_GLASS_PANE, 1, "§8§l» §cANNULÉ §8§l«", Arrays.asList("§7[§fi§7]","§7Clique ici pour annulé","§7la sanction."));

        return inv;
    }


    public static Inventory reasonInv(Player p, String Type){

        Inventory inv = INV_CREATOR.newInv(45, "§7[§6§lH§b§lH§7] §E§l"+Type+" §8§l» §3"+p.getName());

        for (int i = 0; i<45; i++){
            INV_CREATOR.newItem(inv , i, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        }

        INV_CREATOR.newItem(inv , 0, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 1, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 7, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 8, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 9, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 17, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 27, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 35, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 36, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 37, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 43, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
        INV_CREATOR.newItem(inv , 44, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));

        INV_CREATOR.newItem(inv, 22, Material.BOOK, 1,"§8§l» §3§lRAISON §8§l«", Arrays.asList("§7[§fi§7]","§7Insultes","§7Utilisation de bug","§7Triche","§7AFK Farm/Mine","§7Flood/Spam","§7Autres"));

        INV_CREATOR.newItem(inv, 39, Material.LIME_STAINED_GLASS_PANE, 1, "§8§l» §aVALIDÉ §8§l«", Arrays.asList("§7[§fi§7]","§7Clique ici pour confirmé","§7la sanction."));
        INV_CREATOR.newItem(inv, 41, Material.RED_STAINED_GLASS_PANE, 1, "§8§l» §cANNULÉ §8§l«", Arrays.asList("§7[§fi§7]","§7Clique ici pour annulé","§7la sanction."));

        return inv;
    }

}
