package fr.highsky.roleplay.Commands.World_Gestion;

import fr.highsky.roleplay.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class SEEDS_GESTION implements Listener {


    @EventHandler
    public void breakSeeds(BlockBreakEvent e){


        Material mat = e.getBlock().getType();
        if(mat == Material.WHEAT || mat == Material.POTATOES || mat == Material.CARROTS || mat == Material.BEETROOTS || mat == Material.NETHER_WART) {
            if (e.getBlock().getBlockData() instanceof Ageable) {
                Block b = e.getBlock();
                if (b.getWorld().getName().equalsIgnoreCase(Main.getInstance().getConfig().getString("Settings.Quest-World"))) {
                    int delay = 0;
                    if(mat == Material.WHEAT)delay = 1200;
                    if(mat == Material.POTATOES)delay = 3600;
                    if(mat == Material.CARROTS)delay = 3600;
                    if(mat == Material.BEETROOTS)delay = 6000;
                    Ageable crop = (Ageable) b.getBlockData();
                    if (crop.getMaximumAge() == crop.getAge()) {
                        (new BukkitRunnable() {
                            @Override
                            public void run() {
                                b.setType(mat);
                            }
                        }).runTaskLater(Main.getInstance(), delay);
                    } else {
                        e.setCancelled(true);
                        return;
                    }
                }else e.setCancelled(true);
            }
        }

    }


}
