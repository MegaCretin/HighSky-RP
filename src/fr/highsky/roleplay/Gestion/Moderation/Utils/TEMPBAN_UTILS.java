package fr.highsky.roleplay.Gestion.Moderation.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class TEMPBAN_UTILS {

    public static void tempBan(Player operator, Player banned, String reason, int time, String unit){

        int max = 0;
        if(operator.hasPermission("tempban.helper")){ max = 2; }

        long endBan = System.currentTimeMillis() + TICK_UTILS.getTick(unit, time);
        long now = System.currentTimeMillis();
        long diff = endBan - now;

        if(diff > 0L){
            setBanned(banned.getName(), endBan);
            Bukkit.broadcastMessage(MODERATION_MESSAGES_UTILS.tempBan(operator, banned, reason, endBan));
            banned.kickPlayer(MODERATION_MESSAGES_UTILS.kicktempBan(operator, reason, endBan));
        }

    }

    private static  HashMap<String, Long> getBanned(){
        return MODERATION_UTILS.Ban;
    }

    private static void setBanned(String name, long end){
        getBanned().put(name, end);
    }



}
