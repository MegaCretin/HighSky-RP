package fr.highsky.roleplay.Events.PinataEvent;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.*;

public class MOB_PINATA {

    public static void pinataEntity(Location location, Player p){

        TraderLlama llama = (TraderLlama) location.getWorld().spawnEntity(location, EntityType.TRADER_LLAMA);
        llama.setAdult();
        llama.setAI(false);
        llama.setGlowing(true);
        llama.setCustomName("§8§l» §d§lPIÑATA §8§l«");
        llama.setCustomNameVisible(true);

        p.spawnParticle(Particle.SMOKE_LARGE, p.getLocation().add(0,1,0), 1000);

        Bukkit.broadcastMessage("§d§lPIÑATA §8§l» §e"+p.getName()+" §aà reçu la piñata !");
    }

}
