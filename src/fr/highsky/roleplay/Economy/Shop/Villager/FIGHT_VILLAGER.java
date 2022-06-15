package fr.highsky.roleplay.Economy.Shop.Villager;

import org.bukkit.entity.Villager;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FIGHT_VILLAGER implements Listener {

    @EventHandler
    public void villagerDamage(EntityDamageEvent e){

        if(e.getEntity() instanceof Villager || e.getEntity() instanceof WanderingTrader){

            if(e.getEntity().getLocation().getWorld().getName().equalsIgnoreCase("map")){
                e.setCancelled(true);
            }

        }

    }

}
