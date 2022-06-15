package fr.highsky.roleplay.Events.Jump;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class JUMP_VOID implements Listener {

    @EventHandler
    public void onVoidJump(PlayerMoveEvent e){
        if(e.getPlayer().getLocation().getY() < 50){
            e.getPlayer().teleport(new Location(Bukkit.getWorld("jump"), 1.5, 64,1.5, 90,0));
            e.getPlayer().sendMessage("&a&lJUMP §8§l» &eVous avez été téléporté au jump.");
        }
    }

}
