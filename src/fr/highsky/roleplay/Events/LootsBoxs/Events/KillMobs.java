package fr.highsky.roleplay.Events.LootsBoxs.Events;

import fr.highsky.roleplay.Events.LootsBoxs.Utils.LootsBoxs;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class KillMobs implements Listener {

    @EventHandler
    public void onkillMobs(EntityDeathEvent e){

        Entity en = e.getEntity();
        if(!(en instanceof Player)) {
            if(e.getEntity().getKiller() instanceof Player){

                Random rdm = new Random();

                int i = 0 + rdm.nextInt(10000-0);
                Double d = Double.valueOf(i);
                
                if (d <= 5) {
                    en.getLocation().getWorld().dropItemNaturally(en.getLocation(), LootsBoxs.LegBox(1));
                }else if(d > 5 && d < 25){
                    en.getLocation().getWorld().dropItemNaturally(en.getLocation(), LootsBoxs.RareBox(1));
                }else if(d > 25 && d < 75){
                    en.getLocation().getWorld().dropItemNaturally(en.getLocation(), LootsBoxs.CommunBox(1));
                }else{
                    return;
                }

            }
        }
    }

}
