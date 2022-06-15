package fr.highsky.roleplay.Events.LootsBoxs.Events;

import fr.highsky.roleplay.Events.LootsBoxs.Particles.ParticleDensity;
import fr.highsky.roleplay.Events.LootsBoxs.Particles.ParticleEffect;
import fr.highsky.roleplay.Events.LootsBoxs.Particles.ParticleType;
import fr.highsky.roleplay.Events.LootsBoxs.Particles.ParticleUtils;
import fr.highsky.roleplay.Events.LootsBoxs.Utils.ItemUtils;
import fr.highsky.roleplay.Main;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlaceLootsBox implements Listener {

    private final Main main;

    public PlaceLootsBox(Main main) {
        this.main = main;
    }

    @EventHandler
    public void placeLootBox(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(p.getInventory().getItemInMainHand().hasItemMeta()){
            if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §b§lLootBox Commune §8§l«")){
                if(p.getWorld().getName().equalsIgnoreCase("map")){
                    p.sendMessage("§cImpossible de poser ça ici.");
                    e.setCancelled(true);
                    return;
                }
                ParticleUtils.addParticle(e.getBlock(), ParticleDensity.LIGHT, ParticleType.CLOUD, ParticleEffect.TARGET);
                e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 1,0), ItemUtils.CommunLoot());
                p.getInventory().setItemInMainHand(null);
                (new BukkitRunnable() {
                    public void run() {
                        e.getBlock().setType(Material.AIR);
                    }
                }).runTaskLater(main, 1L);
            }else if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§8§l» §c§lLootBox Rare §8§l«")){
                if(p.getWorld().getName().equalsIgnoreCase("map")){
                    p.sendMessage("§cImpossible de poser ça ici.");
                    e.setCancelled(true);
                    return;
                }
                ParticleUtils.addParticle(e.getBlock(), ParticleDensity.MAD, ParticleType.PORTAL, ParticleEffect.TARGET);
                e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 1,0), ItemUtils.RareLoot());
                p.getInventory().setItemInMainHand(null);
                (new BukkitRunnable() {
                    public void run() {
                        e.getBlock().setType(Material.AIR);
                    }
                }).runTaskLater(main, 1L);
            }else if(p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§8§l» §6§lLootBox Légendaire §8§l«")){
                if(p.getWorld().getName().equalsIgnoreCase("map")){
                    p.sendMessage("§cImpossible de poser ça ici.");
                    e.setCancelled(true);
                    return;
                }
                ParticleUtils.addParticle(e.getBlock(), ParticleDensity.LIGHT, ParticleType.CRIT_MAGIC, ParticleEffect.TARGET);
                e.getBlock().getLocation().getWorld().dropItemNaturally(e.getBlock().getLocation().add(0, 1,0), ItemUtils.LegLoot());
                p.getInventory().setItemInMainHand(null);
                (new BukkitRunnable() {
                    public void run() {
                        e.getBlock().setType(Material.AIR);
                    }
                }).runTaskLater(main, 1L);
            }
        }

    }
}
