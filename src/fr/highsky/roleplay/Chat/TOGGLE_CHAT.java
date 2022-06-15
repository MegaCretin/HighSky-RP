package fr.highsky.roleplay.Chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class TOGGLE_CHAT implements CommandExecutor {

    public static ArrayList<Player> chatToggle = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            if(p.hasPermission("toggle.chat")){
                if(chatToggle.contains(p)){
                    chatToggle.remove(p);
                    p.sendMessage("§6§lH§b§lS §8§l» §aVous avez activé votre chat.");
                } else{
                    chatToggle.add(p);
                    p.sendMessage("§6§lH§b§lS §8§l» §cVous avez désactivé votre chat.");
                }
            }else p.sendMessage("§6§lH§b§lS §8§l» Vous n'avez pas cette permission.");
        }
        return false;
    }
}
