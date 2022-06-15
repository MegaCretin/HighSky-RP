package fr.highsky.roleplay.Gestion.ScoreBoard;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class DISABLE_SCOREBOARD implements CommandExecutor {

    public static ArrayList<Player> scoreboard = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 1) {
                if (p.hasPermission("scoreboard.gestion")) {
                    if (args[0].equalsIgnoreCase("on")) {
                        if (!scoreboard.contains(p)) {
                            p.sendMessage("§b§lSCOREBOARD §8§l» §cVous avez déjà activé le scoreboard.");
                        } else if (scoreboard.contains(p)) {
                            scoreboard.remove(p);
                            p.sendMessage("§b§lSCOREBOARD §8§l» §aVous avez activé le scoreboard.");
                        }
                    } else if (args[0].equalsIgnoreCase("off")) {
                        if (scoreboard.contains(p)) {
                            p.sendMessage("§b§lSCOREBOARD §8§l» §cVous avez déjà désactivé le scoreboard.");
                        } else if (!scoreboard.contains(p)) {
                            scoreboard.add(p);
                            p.sendMessage("§b§lSCOREBOARD §8§l» §cVous avez désactivé le scoreboard.");
                            p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
                        }
                    }
                }
            } else if (args.length == 0) {
                if (!scoreboard.contains(p)) {
                    p.sendMessage("§b§lSCOREBOARD §8§l» §cVous avez désactivé le scoreboard.");
                    scoreboard.add(p);
                    p.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
                } else if (scoreboard.contains(p)) {
                    p.sendMessage("§b§lSCOREBOARD §8§l» §aVous avez activé le scoreboard.");
                    scoreboard.remove(p);
                }
            }
        }

        return false;
    }
}
