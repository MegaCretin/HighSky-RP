package fr.highsky.roleplay.Economy.BlackMarket;

import fr.highsky.roleplay.Utils.GET_RANDOM_BM_ITEM;
import net.citizensnpcs.api.CitizensAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalTime;

public class BM_RUNNABLE extends BukkitRunnable {


    @Override
    public void run() {

        int hour = LocalTime.now().getHour();
        int min = LocalTime.now().getMinute();

        if(hour == 20 && min == 00){

            GET_RANDOM_BM_ITEM.setItem();

            Bukkit.broadcastMessage("§a[§6§lBlackMarket§a] §eUn nouvel objet limité est disponible au BlackMarket. !");


        }else if(hour == 21 && min == 00) {
            Location loc1 = new Location(Bukkit.getWorld("Void"), 26.5 ,144 ,-16.5, -90, 0);
            CitizensAPI.getNPCRegistry().getById(25).teleport(loc1, PlayerTeleportEvent.TeleportCause.COMMAND);
        }



    }


}
