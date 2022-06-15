package fr.highsky.roleplay.Other.Site;

import fr.highsky.roleplay.Main;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VOTE implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(!(sender instanceof Player)){
            if(args.length == 1){
                for(Player p : Bukkit.getOnlinePlayers()){
                    String m = "§eMerci à §a§l" + args[0] + " §ed'avoir voté ! §f/§lvote";
                    p.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(m));
                    p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_CELEBRATE, 100, 100);
                }
            }else if(args.length == 3){

                if(args[0].equalsIgnoreCase("party") && args[1].equalsIgnoreCase("add")){
                    if(args[2].matches("-?\\d+")) {

                        Main.getInstance().getConfig().set("VoteParty", Main.getInstance().getConfig().getInt("VoteParty") + Integer.parseInt(args[2]));
                        Main.getInstance().saveConfig();
                        if (Main.getInstance().getConfig().getInt("VoteParty") >= 50) {
                            Main.getInstance().getConfig().set("VoteParty", Main.getInstance().getConfig().getInt("VoteParty") - 50);
                            Main.getInstance().saveConfig();
                            Bukkit.broadcastMessage("§a§lVote §8§l» §eFélicitation vous avez complété le VoteParty, vous recevez tous une clé §4Rare§e !");
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "box give " + p.getName() + " Rare 1");
                            }
                        }
                    }

                }

            }
        }
        return false;
    }

}
