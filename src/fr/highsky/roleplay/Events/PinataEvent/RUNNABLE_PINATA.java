package fr.highsky.roleplay.Events.PinataEvent;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalTime;

public class RUNNABLE_PINATA extends BukkitRunnable {
    @Override
    public void run() {

        int hour = LocalTime.now().getHour();
        int min = LocalTime.now().getMinute();

        if(hour == 16 && min == 00){
            if(Bukkit.getOnlinePlayers().size()>5) {
                if (Bukkit.getOnlinePlayers().size() < 10) {
                    Player p = Bukkit.getOnlinePlayers().stream().skip((int) (Bukkit.getOnlinePlayers().size() * Math.random())).findFirst().orElse(null);
                    MOB_PINATA.pinataEntity(p.getLocation(), p);
                } else if (Bukkit.getOnlinePlayers().size() > 10 && Bukkit.getOnlinePlayers().size() < 20) {
                    for (int i = 0; i > 3; i++) {
                        Player p = Bukkit.getOnlinePlayers().stream().skip((int) (Bukkit.getOnlinePlayers().size() * Math.random())).findFirst().orElse(null);
                        MOB_PINATA.pinataEntity(p.getLocation(), p);
                    }
                } else if (Bukkit.getOnlinePlayers().size() > 20) {
                    for (int i = 0; i > 4; i++) {
                        Player p = Bukkit.getOnlinePlayers().stream().skip((int) (Bukkit.getOnlinePlayers().size() * Math.random())).findFirst().orElse(null);
                        MOB_PINATA.pinataEntity(p.getLocation(), p);
                    }
                }
            }

        }
    }
}
