package fr.highsky.roleplay.Economy.Shop.Utils;

import fr.highsky.roleplay.Economy.Shop.Villager.VILLAGER;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.entity.WanderingTrader;

public class VILLAGER_UTILS {

    public static Entity Villager(String name, Location loc){

        Villager v = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
        v.setCustomNameVisible(true);
        v.setCustomName(name);
        v.setAdult();
        v.setAI(false);

        return v;

    }

    public static Entity Trader(String name, Location loc){

        WanderingTrader v = (WanderingTrader) loc.getWorld().spawnEntity(loc, EntityType.WANDERING_TRADER);
        v.setCustomNameVisible(true);
        v.setCustomName(name);
        v.setAI(false);

        return v;

    }

}
