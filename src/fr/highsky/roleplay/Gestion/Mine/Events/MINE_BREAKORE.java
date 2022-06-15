package fr.highsky.roleplay.Gestion.Mine.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class MINE_BREAKORE implements Listener {

    @EventHandler
    public void breakBlock(BlockBreakEvent e){

        Player p = e.getPlayer();
        if(e.getBlock().getWorld().getName().equals("Mine")){

        }

    }

}
