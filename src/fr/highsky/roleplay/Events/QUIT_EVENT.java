package fr.highsky.roleplay.Events;

import fr.highsky.roleplay.Commands.TempFly.Utils.TFLY_UTILS;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QUIT_EVENT implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();

        if(TFLY_UTILS.useFly.contains(p)){
            TFLY_UTILS.useFly.remove(p);
            p.setAllowFlight(false);
            Long time = null;
            if(TFLY_UTILS.getRank(p).equals("Crea") || TFLY_UTILS.getRank(p).equals("Admin") || TFLY_UTILS.getRank(p).equals("Dev"))return;
            else if(TFLY_UTILS.getRank(p).equals("MVP")){
                time = TFLY_UTILS.tflyMVP.get(p.getUniqueId()) - System.currentTimeMillis();
            }else if(TFLY_UTILS.getRank(p).equals("VIP")){
                time =  TFLY_UTILS.tflyVIP.get(p.getUniqueId()) - System.currentTimeMillis();
            }

            TFLY_UTILS.tTimer.put(p.getUniqueId(), time);

        }
    }

}
