package fr.highsky.roleplay.Other;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.ArrayList;
import java.util.Random;

public class WELCOME_COMMAND implements Listener, CommandExecutor {

    private static ArrayList<Player> welcome = new ArrayList<>();
    private static String New= "";


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player p = (Player)sender;


        if(welcome.contains(p)){
            Random r = new Random();
            int choix = 4;
            int alea = 1 + r.nextInt(choix - 1);
            if(alea == 1){
                p.chat("§7Bienvenue §e" + New + " §7sur §6§lHigh§b§lSky !");
            }
            else if(alea == 2){
                p.chat("§7Bienvenue §e" + New + " §7et bon jeu sur §6§lHigh§b§lSky §7!");
            }
            else if(alea == 3){
                p.chat("§7Je te souhaite la bienvenue sur §6§lHigh§b§lSky §e" + New + " §7!");
            }
            else if(alea == 4){
                p.chat("§7Nous te souhaitons un bon jeu sur §6§lHigh§b§lSky§e" + New + " §7!");
            }
            welcome.remove(p);
        }

        return false;
    }

    @EventHandler
    public void newPlayer(PlayerJoinEvent e){

        if(!e.getPlayer().hasPlayedBefore()){
            New = e.getPlayer().getName();
            for(Player p : Bukkit.getOnlinePlayers()){
                if(p != e.getPlayer()){
                    if(!welcome.contains(p)) {
                        welcome.add(p);
                    }
                }
            }
        }

    }
}
