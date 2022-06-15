package fr.highsky.roleplay.Events.Boxs.XPBoxs;

import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum XP_BOXS_ENUM {

    XP75(new Location(Bukkit.getWorld("map"), 187, 81, 199)),
    XP150(new Location(Bukkit.getWorld("map"), 190, 81, 196)),
    XP300(new Location(Bukkit.getWorld("map"), 187, 82, 196));

    private Location loc;

    XP_BOXS_ENUM(Location loc){
        this.loc = loc;
    }

    public Location getLoc(){
        return loc;
    }

}
