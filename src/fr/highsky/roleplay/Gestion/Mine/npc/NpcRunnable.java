package fr.highsky.roleplay.Gestion.Mine.npc;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class NpcRunnable extends BukkitRunnable {

    @Override
    public void run() {

        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        String day = format.format(now);
        int hour = LocalTime.now().getHour();
        int min = LocalTime.now().getMinute();

        if(day.equalsIgnoreCase("Monday") || day.equalsIgnoreCase("Wednesday") || day.equalsIgnoreCase("Thursday")){
            if(hour == 19 && min == 55){
                Bukkit.broadcastMessage("§7§lMine §8§l» §aLa mine ouvre ses portes dans 5 minutes !");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mine reset Mine");
            }else if(hour == 20 && min == 00){
                Bukkit.broadcastMessage("§7§lMine §8§l» §aLa mine ouvre ses portes maintenant !");
            }else if(hour == 21 && min == 00){
                for(Player p : Bukkit.getOnlinePlayers()){

                    if(p.getLocation().getWorld().getName().equalsIgnoreCase("Mine")){
                        Bukkit.dispatchCommand(p, "spawn");
                        p.sendMessage("§7§lMine §8§l» §aLa mine est désormais fermée.");
                    }

                }
            }
        }
        else if(day.equalsIgnoreCase("Sunday")){
            if(hour == 12 && min == 55){
                Bukkit.broadcastMessage("§7§lMine §8§l» §aLa mine ouvre ses portes dans 5 minutes !");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mine reset Mine");
            }else if(hour == 13 && min == 00){
                Bukkit.broadcastMessage("§7§lMine §8§l» §aLa mine ouvre ses portes maintenant !");
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mine reset Mine");
            }else if(hour == 14 && min == 00){
                for(Player p : Bukkit.getOnlinePlayers()){

                    if(p.getLocation().getWorld().getName().equalsIgnoreCase("Mine")){
                        Bukkit.dispatchCommand(p, "spawn");
                        p.sendMessage("§7§lMine §8§l» §aLa mine est désormais fermée.");
                    }
                }
            }
        }

    }
}
