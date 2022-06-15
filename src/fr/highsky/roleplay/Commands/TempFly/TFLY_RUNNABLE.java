package fr.highsky.roleplay.Commands.TempFly;

import fr.highsky.roleplay.Commands.TempFly.Utils.TFLY_UTILS;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.UUID;

public class TFLY_RUNNABLE extends BukkitRunnable {
    @Override
    public void run() {

        int hour = LocalTime.now().getHour();
        int min = LocalTime.now().getMinute();

        if(hour == 00 && min == 00){
            TFLY_UTILS.useFly.clear();
        }

        for(Player p : Bukkit.getOnlinePlayers()) {
            if(TFLY_UTILS.tflyMVP.containsKey(p) || TFLY_UTILS.tflyVIP.containsKey(p) || TFLY_UTILS.tflyPlayer.containsKey(p)) {
                if(returnTime(p) == 1800){
                    p.sendTitle("§aIl vous reste","§e30 minutes§a de fly.",20,20,20);
                }else if(returnTime(p) == 900){
                    p.sendTitle("§aIl vous reste","§e15 minutes§a de fly.",20,20,20);
                }else if(returnTime(p) == 300){
                    p.sendTitle("§aIl vous reste","§e5 minutes§a de fly.",20,20,20);
                }else if(returnTime(p) == 60){
                    p.sendTitle("§aIl vous reste","§e60 secondes§a de fly.", 20, 20,20);
                }else if(returnTime(p) == 30){
                    p.sendTitle("§aIl vous reste","§e30 secondes§a de fly.", 20, 20,20);
                }else if(returnTime(p) == 15){
                    p.sendTitle("§aIl vous reste","§e15 secondes§a de fly.", 20, 20,20);
                }else if(returnTime(p) == 10){
                    p.sendTitle("§aIl vous reste","§e10 secondes§a de fly.", 20, 20,20);
                }else if(returnTime(p) == 5){
                    p.sendTitle("§aIl vous reste","§e5 secondes§a de fly.", 20, 20,20);
                }else if(returnTime(p) == 4){
                    p.sendTitle("§aIl vous reste","§e4 secondes§a de fly.", 20, 20,20);
                }else if(returnTime(p) == 3){
                    p.sendTitle("§aIl vous reste","§e3 secondes§a de fly.", 20, 20,20);
                }else if(returnTime(p) == 2){
                    p.sendTitle("§aIl vous reste","§e2 secondes§a de fly.", 20, 20,20);
                }else if(returnTime(p) == 1){
                    p.sendTitle("§aIl vous reste","§e1 seconde§a de fly.",20,20,20);
                }

            }
        }


    }

    public int returnTime(Player p){
        long endFly = getFlyer(p).get(p).longValue();
        long now = System.currentTimeMillis();
        long diff = endFly - now;
        int second = (int) (diff / 1000L);
        if(second >= 60) {
            return second/60;
        }else{
            return second;
        }
    }

    public HashMap<UUID, Long> getFlyer (Player p){
        if (TFLY_UTILS.getRank(p).equals("MVP") && TFLY_UTILS.tflyMVP.containsKey(p.getUniqueId())) {
            return TFLY_UTILS.tflyMVP;
        } else if (TFLY_UTILS.getRank(p).equals("VIP") && TFLY_UTILS.tflyVIP.containsKey(p.getUniqueId())) {
            return TFLY_UTILS.tflyVIP;
        } else if (TFLY_UTILS.getRank(p).equals("Player") && TFLY_UTILS.tflyPlayer.containsKey(p.getUniqueId())) {
            return TFLY_UTILS.tflyPlayer;
        }
        p.sendMessage("§B§LFLY §8§l» §cVous n'avez pas de §eFLY §cactivé.");
        return null;
    }

}
