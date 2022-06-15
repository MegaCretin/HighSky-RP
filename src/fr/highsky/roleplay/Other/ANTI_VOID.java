package fr.highsky.roleplay.Other;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class ANTI_VOID implements Listener {


    @EventHandler
    public void onFallVoid(PlayerMoveEvent e){
        Player p = e.getPlayer();
        if(p.getWorld().getName().equalsIgnoreCase("map") && p.getLocation().getY() <= 64 && !p.isOp()){
            p.teleport(new Location(Bukkit.getWorld("map"), 193.5, 81, 202.5));
        }

    }

}
