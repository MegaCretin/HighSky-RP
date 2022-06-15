package fr.highsky.roleplay.Gestion.Moderation.Events;

import fr.highsky.roleplay.Gestion.Moderation.Utils.MODERATION_MESSAGES_UTILS;
import fr.highsky.roleplay.Gestion.Moderation.Utils.MODERATION_UTILS;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import java.util.HashMap;

public class MUTE_SPEAK implements Listener {



    public static Boolean canSpeak(Player p){
        if(getMute().containsKey(p.getName().toLowerCase()) && getMute().get(p.getName().toLowerCase()) != null) {

            long endBan = getMute().get(p.getName().toLowerCase()).longValue();
            long now = System.currentTimeMillis();
            long diff = endBan - now;
            if (diff <= 0L) {
                getMute().remove(p.getName().toLowerCase());
                return true;
            }else{
                p.sendMessage(MODERATION_MESSAGES_UTILS.speaktempMute(endBan));
                return false;
            }
        }
        return true;
    }

    private static HashMap<String, Long> getMute(){
        return MODERATION_UTILS.Mute;
    }


}
