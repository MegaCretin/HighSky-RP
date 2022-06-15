package fr.highsky.roleplay.Commands.World_Gestion;

import fr.highsky.roleplay.Commands.Quests.REGION_JOIN_LEAVE;
import fr.highsky.roleplay.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class LOG_GESTION implements Listener {

    @EventHandler
    public void onBreakWoodonRegion(BlockBreakEvent e) {

        Material mat = e.getBlock().getType();
        if (!e.getPlayer().isOp()) {
            if (e.getBlock().getWorld().getName().equalsIgnoreCase(Main.getInstance().getConfig().getString("Settings.Quest-World"))) {
                if (mat == Material.OAK_LOG || mat == Material.SPRUCE_LOG || mat == Material.DARK_OAK_LOG || mat == Material.BIRCH_LOG) {
                    if (REGION_JOIN_LEAVE.woodRegion.contains(e.getPlayer())) {
                        int delay = 0;
                        if (mat == Material.OAK_LOG) delay = 2400;
                        if (mat == Material.SPRUCE_LOG) delay = 4800;
                        if (mat == Material.BIRCH_LOG) delay = 4800;
                        if (mat == Material.DARK_OAK_LOG) delay = 7200;
                        if (REGION_JOIN_LEAVE.woodRegion.contains(e.getPlayer())) {
                            (new BukkitRunnable() {
                                @Override
                                public void run() {
                                    e.getBlock().setType(mat);
                                }
                            }).runTaskLater(Main.getInstance(), delay);
                        }
                    }
                }
            } else e.setCancelled(true);

        }
    }
}
