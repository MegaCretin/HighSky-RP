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

public class BUY implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(!(sender instanceof Player)) {

            if (args.length == 2) {
                for (Player p : Bukkit.getOnlinePlayers()) {
                    p.sendTitle("§eMerci à §a§l" + args[0],"§ed'avoir acheté §c§l" + args[1].replace("_", " ") + " §esur la boutique !",50,50,50);
                    p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 100, 100);
                }
            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("party") && args[1].equalsIgnoreCase("add")) {
                    if (args[2].matches("-?\\d+")) {

                        Main.getInstance().getInstance().getConfig().set("ShopParty", Main.getInstance().getInstance().getConfig().getInt("ShopParty") + Integer.parseInt(args[2]));
                        Main.getInstance().getInstance().saveConfig();
                        if (Main.getInstance().getInstance().getConfig().getInt("ShopParty") >= 75) {
                            Main.getInstance().getInstance().getConfig().set("ShopParty", Main.getInstance().getInstance().getConfig().getInt("ShopParty") - 75);
                            Main.getInstance().getInstance().saveConfig();
                            Bukkit.broadcastMessage("§a§lVote §8§l» §eFélicitation vous avez complété le ShopParty, vous recevez tous une clé §6Légendaire§e !");
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "box give " + p.getName() + " Leg 1");
                            }
                        }
                    }

                }
            }
        }

        return false;
    }
}
