package fr.highsky.roleplay.Events.Jump;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class JUMP_COMMAND implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if (sender instanceof Player && args.length == 0){
            Player p = (Player)sender;
            if(p.hasPermission("jump.access")){
                p.teleport(new Location(Bukkit.getWorld("jump"), 1.5, 64,1.5, 90,0));
                p.sendMessage("&a&lJUMP §8§l» &eVous avez été téléporté au jump.");
            }
        }
        return false;
    }
}
