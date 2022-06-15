package fr.highsky.roleplay.Events.PlayTime;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.sql.SQLException;

public class PT_MENU implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player p = (Player)sender;

        if(args.length == 0){

            Inventory inv = Bukkit.createInventory(null, 45, "§b§lPLAYTIME §8§l» §7Menu");

            try {
                PT_UTILS.addCase(inv, "1h", 11, "§f1 Clé Commune", " §7• §f16 Lingots de fer", null, p, "1h");
                PT_UTILS.addCase(inv, "2h", 12, "§f1 Clé Commune", " §7• §f16 Lingots d'or", null, p, "2h");
                PT_UTILS.addCase(inv, "5h", 13, "§f2 Clés Commune", " §7• §f5000$", null, p, "3h");
                PT_UTILS.addCase(inv, "10h", 14, "§f1 Clé Rare", " §7• §f16 diamants", null, p, "4h");
                PT_UTILS.addCase(inv, "25h", 15, "§f1 Clé Rare", " §7• §f1 Clé Commune", " §7• §f4 Emeraudes", p, "5h");
                PT_UTILS.addCase(inv, "50h", 20, "§f1 SellStick 50 utilisations", null, null, p, "6h");
                PT_UTILS.addCase(inv, "75h", 21, "§f3 Clé Commune", " §7• §f1 clé 150XP", null, p, "7h");
                PT_UTILS.addCase(inv, "100h", 22, "§f2 Clés Rare", " §7• §f4 Netherite Scrap", " §7• §f2 Oeufs de Villageois", p, "8h");
                PT_UTILS.addCase(inv, "150h", 23, "§f1 Clés Légendaire", " §7• §f15000$", null, p, "9h");
                PT_UTILS.addCase(inv, "200h", 24, "§fTag §c#NO§eL§bI§3F§dE", " §7• §f1 Clés Légendaire", " §7• §f2Clés Rare", p, "10h");
                PT_UTILS.addCase(inv, "250h", 30, "§f2 Clés Légendaire", " §7• §f1 clé 300XP", null, p, "11h");
                PT_UTILS.addCase(inv, "350h", 31, "§f2 Clés Légendaire"," §7• §f16 Blocs de diamants", null, p, "12h");
                PT_UTILS.addCase(inv, "500h", 32, "§f5 Clés Légendaire", " §7• §f3 Clés Rare", " §7• §fTag §c#É.MERCÉ", p, "13h");
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            p.openInventory(inv);

        }

        return false;
    }
}