package fr.highsky.roleplay.Gestion.Mine.utils;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

public class BlockCheckTimer extends BukkitRunnable {

    private final World world;
    private final int locXMax;
    private final int locXMin;
    private final int locYMax;
    private final int locYMin;
    private final int locZMax;
    private final int locZMin;

    public BlockCheckTimer(int locXMax, int locXMin, int locYMax, int locYMin, int locZMax, int locZMin) {

        this.world = Bukkit.getWorld("Mines");
        this.locXMax = locXMax;
        this.locXMin = locXMin;
        this.locYMax = locYMax;
        this.locYMin = locYMin;
        this.locZMax = locZMax;
        this.locZMin = locZMin;
    }

    public void run() {
        for (int x = locXMin; x <= locXMax; x++) {
            for (int y = locYMin; y <= locYMax; y++) {
                for (int z = locZMin; z <= locZMax; z++) {
                    Block block = world.getBlockAt(x, y, z);
                    if(block.getType().equals("DIAMOND_ORE")){
                        Bukkit.broadcastMessage(block.toString());
                    }
                }
            }
        }

    }

}