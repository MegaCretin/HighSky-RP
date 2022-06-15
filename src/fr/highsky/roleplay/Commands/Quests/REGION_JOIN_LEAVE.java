package fr.highsky.roleplay.Commands.Quests;

import net.raidstone.wgevents.events.RegionEnteredEvent;
import net.raidstone.wgevents.events.RegionLeftEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;

public class REGION_JOIN_LEAVE implements Listener {

    public static ArrayList woodRegion = new ArrayList<Player>();

    @EventHandler
    public void onRegionEnter(RegionEnteredEvent e){

        if(e.getRegionName().equalsIgnoreCase("lumberjack")){
            woodRegion.add(e.getPlayer());
        }

    }

    @EventHandler
    public void onRegionEnter(RegionLeftEvent e){

        if(e.getRegionName().equalsIgnoreCase("lumberjack")){
            woodRegion.remove(e.getPlayer());
        }

    }

}
