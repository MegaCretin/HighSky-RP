package fr.highsky.roleplay.Economy.Shop.Villager;

import fr.highsky.roleplay.Economy.Shop.Utils.VILLAGER_UTILS;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.Listener;

public class ENTITY_SPAWN implements Listener {

    public static void spawnonEnable(){

        for(Entity e: VILLAGER.BLOCKS.getLoc().getWorld().getEntities()){
            if(e.getLocation().getWorld().getName().equalsIgnoreCase("map")) {
                if (e.getType() == EntityType.VILLAGER || e.getType() == EntityType.WANDERING_TRADER) {
                    e.remove();
                }
            }
        }


        VILLAGER_UTILS.Villager(VILLAGER.BLOCKS.getString(), VILLAGER.BLOCKS.getLoc());
        VILLAGER_UTILS.Villager(VILLAGER.ORE.getString(), VILLAGER.ORE.getLoc());
        VILLAGER_UTILS.Villager(VILLAGER.WORLD.getString(), VILLAGER.WORLD.getLoc());
        VILLAGER_UTILS.Villager(VILLAGER.OTHER.getString(), VILLAGER.OTHER.getLoc());
        VILLAGER_UTILS.Villager(VILLAGER.EAT.getString(), VILLAGER.EAT.getLoc());
        VILLAGER_UTILS.Villager(VILLAGER.WILD.getString(), VILLAGER.WILD.getLoc());
        VILLAGER_UTILS.Villager(VILLAGER.LOOTS.getString(), VILLAGER.LOOTS.getLoc());
        VILLAGER_UTILS.Villager(VILLAGER.DECO.getString(), VILLAGER.DECO.getLoc());
        VILLAGER_UTILS.Trader(VILLAGER.PROMO.getString(), VILLAGER.PROMO.getLoc());

    }


}
