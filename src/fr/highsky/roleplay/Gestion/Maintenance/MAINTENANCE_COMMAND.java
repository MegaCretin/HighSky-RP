package fr.highsky.roleplay.Gestion.Maintenance;

import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MAINTENANCE_COMMAND implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender.isOp()) {
            if (args.length == 1) {
                if (args[0].equals("on")) {
                    Main.getInstance().getConfig().set("Maintenance.Statut", true);
                    Bukkit.broadcastMessage("§e§m          [§r§6§lHigh§b§lSky§e§m]          ");
                    Bukkit.broadcastMessage("§cMaintenance activé");
                    Bukkit.broadcastMessage("§e§m          [§r§6§lHigh§b§lSky§e§m]          ");
                    for(Player p : Bukkit.getOnlinePlayers()){
                        if(!p.isOp()){
                            p.kickPlayer("§6§lHigh§b§lSky\n\n§c     Le serveur est en maintenance\n§5Discord: §7https://discord.gg/xHEYY3R.");
                        }
                    }
                } else if (args[0].equals("off")) {
                    Main.getInstance().getConfig().set("Maintenance.Statut", false);
                    Bukkit.broadcastMessage("§e§m          [§r§6§lHigh§b§lSky§e§m]          ");
                    Bukkit.broadcastMessage("§cMaintenance §adésactivé");
                    Bukkit.broadcastMessage("§e§m          [§r§6§lHigh§b§lSky§e§m]          ");
                }
                Main.getInstance().saveConfig();
            }
        }

        return false;
    }
}
