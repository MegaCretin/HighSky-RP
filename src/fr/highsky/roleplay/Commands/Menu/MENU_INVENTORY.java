package fr.highsky.roleplay.Commands.Menu;

import fr.highsky.roleplay.Utils.INV_CREATOR;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class MENU_INVENTORY implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player p = (Player) sender;

        if(p.hasPermission("menu.use")){

         if(args.length == 0){

             Inventory inv = INV_CREATOR.newInv(45, "§d§lMENU §8§l» §7[§8I§7]");

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

             INV_CREATOR.newItem(inv , 11, Material.GRASS_BLOCK, 1, "§8§l» §a§lILE §8§l«", Arrays.asList("","§7[§8I§7]","  §aVous permet d'éxécuté la","  §acommande §e/is§a.","","§7Cliquez pour éxecuter cette","§7commande."));
             INV_CREATOR.newItem(inv , 13, Material.BELL, 1, "§8§l» §b§lHOTEL DE VENTE §8§l«", Arrays.asList("","§7[§8I§7]","  §aVous permet d'éxécuté la","  §acommande §e/ah§a.","","§7Cliquez pour éxecuter cette","§7commande."));
             INV_CREATOR.newItem(inv , 15, Material.WHEAT, 1, "§8§l» §3§lQUETES JOURNALIERE §8§l«", Arrays.asList("","§7[§8I§7]","  §aVous permet d'éxécuté la","  §acommande §e/dq§a.","","§7Cliquez pour éxecuter cette","§7commande."));
             INV_CREATOR.newItem(inv , 21, Material.BEDROCK, 1, "§8§l» §d§lSPAWN §8§l«", Arrays.asList("","§7[§8I§7]","  §aVous permet d'éxécuté la","  §acommande §e/spawn§a.","","§7Cliquez pour éxecuter cette","§7commande."));
             INV_CREATOR.newItem(inv , 23, Material.EXPERIENCE_BOTTLE, 1, "§8§l» §e§lXP BOXS §8§l«", Arrays.asList("","§7[§8I§7]","  §aVous permet d'éxécuté la","  §acommande §e/xpbox§a.","","§7Cliquez pour éxecuter cette","§7commande."));
             INV_CREATOR.newItem(inv , 29, Material.CLOCK, 1, "§8§l» §6§lPLAYTIME §8§l«", Arrays.asList("","§7[§8I§7]","  §aVous permet d'éxécuté la","  §acommande §e/pt§a.","","§7Cliquez pour éxecuter cette","§7commande."));
             INV_CREATOR.newItem(inv , 31, Material.ENDER_PEARL, 1, "§8§l» §5§lWARPS §8§l«", Arrays.asList("","§7[§8I§7]","  §aVous permet d'éxécuté la","  §acommande §e/warp§a.","","§7Cliquez pour éxecuter cette","§7commande."));
             INV_CREATOR.newItem(inv , 33, Material.CACTUS, 1, "§8§l» §f§lQUETES HEBDOMADAIRE §8§l«", Arrays.asList("","§7[§8I§7]","  §aVous permet d'éxécuté la","  §acommande §e/wq§a.","","§7Cliquez pour éxecuter cette","§7commande."));

             p.openInventory(inv);

         }else p.sendMessage("§d§lMENU §8§l» §cUtilisation: §7/menu§c.");

        }else p.sendMessage("§6§lH§b§lS §8§l» §cVous n'avez pas cette permission.");
        return false;
    }
}
