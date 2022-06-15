package fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils;


import org.bukkit.Bukkit;
import org.bukkit.Location;

public enum BOXS {

    F_COMMUNE(new Location(Bukkit.getWorld("world"), 6, 89, 0)),
    F_RARE(new Location(Bukkit.getWorld("world"), 4, 89, 4)),
    F_LEGENDAIRE(new Location(Bukkit.getWorld("world"), 0, 89, 6)),
    S_COMMUNE(new Location(Bukkit.getWorld("map"), 190, 81, 209)),
    S_RARE(new Location(Bukkit.getWorld("map"), 187, 81, 206)),
    S_LEGENDAIRE(new Location(Bukkit.getWorld("map"), 187, 82, 209));

    private Location loc;

    BOXS(Location loc){
        this.loc = loc;
    }

    public Location getLoc(){
        return loc;
    }

}
