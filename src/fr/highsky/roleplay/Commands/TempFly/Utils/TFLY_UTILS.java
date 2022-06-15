package fr.highsky.roleplay.Commands.TempFly.Utils;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class TFLY_UTILS {

    public static HashMap<UUID, Long> tflyMVP = new HashMap<>();
    public static HashMap<UUID, Long> tflyVIP = new HashMap<>();
    public static HashMap<UUID, Long> tflyPlayer = new HashMap<>();
    public static HashMap<UUID, Long> tTimer = new HashMap<>();
    public static ArrayList<Player> useFly = new ArrayList<>();

    public static String getRank(Player p){
        
        if(p.hasPermission("group." + "MVP")){
            return "MVP";
        }else if(p.hasPermission("group." + "VIP")){
            return "VIP";
        }else if(p.hasPermission("group." + "default")){
            return "Player";
        }
        return null;
    }


    public static String getTime(long flyTemp){
        String msg = "";
        long now = System.currentTimeMillis();
        long diff = flyTemp - now;
        int second = (int) (diff/1000L);
        if(second >= 3600){
            int hours = second /3600;
            second %= 3600;
            msg = msg+ hours+" Heure(s)";
        }
        if(second >= 60){
            int min = second/60;
            second %= 60;
            msg = msg+ min+" Minute(s)";
        }
        if(second >= 0){
            msg = msg+ second+" Seconde(s)";
        }
        return " "+msg;
    }


    public static void setFlyer (Player p, Long delay){
        if (TFLY_UTILS.getRank(p).equals("MVP")) {
            TFLY_UTILS.tflyMVP.put(p.getUniqueId(), delay);
        } else if (TFLY_UTILS.getRank(p).equals("VIP")) {
            TFLY_UTILS.tflyVIP.put(p.getUniqueId(), delay);
        } else if (TFLY_UTILS.getRank(p).equals("Player")) {
            TFLY_UTILS.tflyPlayer.put(p.getUniqueId(), delay);
        }
    }

}
