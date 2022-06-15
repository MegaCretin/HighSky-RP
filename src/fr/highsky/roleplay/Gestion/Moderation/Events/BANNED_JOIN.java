package fr.highsky.roleplay.Gestion.Moderation.Events;

import fr.highsky.roleplay.Gestion.Moderation.Utils.MODERATION_MESSAGES_UTILS;
import fr.highsky.roleplay.Gestion.Moderation.Utils.MODERATION_UTILS;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class BANNED_JOIN implements Listener {



    @EventHandler
    public void onBanJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        if(getBanned().containsKey(p.getName().toLowerCase()) && getBanned().get(p.getName().toLowerCase()) != null){

            long endBan = getBanned().get(p.getName().toLowerCase()).longValue();
            long now = System.currentTimeMillis();
            long diff = endBan - now;
            if(diff <= 0L){
                getBanned().remove(p.getName().toLowerCase());
            }else {
                p.kickPlayer(MODERATION_MESSAGES_UTILS.joinkicktempBan(endBan));
            }

        }
        if(p.isBanned()){
            p.kickPlayer(MODERATION_MESSAGES_UTILS.joinkickBan());
        }
    }

    public HashMap<String, Long> getBanned(){
        return MODERATION_UTILS.Ban;
    }

}
