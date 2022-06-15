package fr.highsky.roleplay.Economy.Shop.Villager;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum VILLAGER {

    ORE("§6§l» §aMinerais §6§l«", new Location(Bukkit.getWorld("map"),221.5,79,217.5,90,0)),
    WORLD("§6§l» §aMonde §6§l«", new Location(Bukkit.getWorld("map"),205.5,79,196.5,0,0)),
    OTHER("§6§l» §aDivers §6§l«", new Location(Bukkit.getWorld("map"),212.5,79,191.5,-90,0)),
    EAT("§6§l» §aNourriture §6§l«", new Location(Bukkit.getWorld("map"),228.5,79,211.5,180,0)),
    BLOCKS("§6§l» §aBlocs §6§l«", new Location(Bukkit.getWorld("map"),220.5,79,226.5,90,0)),
    WILD("§6§l» §aNature §6§l«", new Location(Bukkit.getWorld("map"),210.5,79,221.5,-90,0)),
    LOOTS("§6§l» §aLoots §6§l«", new Location(Bukkit.getWorld("map"),207.5,79,219.5,-180,0)),
    DECO("§6§l» §aDeco §6§l«", new Location(Bukkit.getWorld("map"),201.5,79,210.5,-90,0)),
    PROMO("§6§l» §aPromotions §6§l«", new Location(Bukkit.getWorld("map"),223.5,76,262.5,0,0));

    private String string;
    private Location loc;

    VILLAGER(String string, Location loc){
        this.string = string;
        this.loc = loc;
    }

    public Location getLoc(){
        return loc;
    }

    public String getString(){
        return string;
    }

}
