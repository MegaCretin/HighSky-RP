package fr.highsky.roleplay.Gestion.Moderation.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MUTE_UTILS {

    public static void Mute(Player operator, Player banned, String reason, int time, String unit){

        long endMute = System.currentTimeMillis() + TICK_UTILS.getTick(unit, time);
        long now = System.currentTimeMillis();
        long diff = endMute - now;

        if(diff > 0L){
            setMute(banned.getName(), endMute);
            Bukkit.broadcastMessage(MODERATION_MESSAGES_UTILS.tempMute(operator, banned, reason, endMute));
        }

    }

    private static HashMap<String, Long> getMuted(){
        return MODERATION_UTILS.Mute;
    }

    private static void setMute(String name, long end){
        getMuted().put(name, end);
    }

}
