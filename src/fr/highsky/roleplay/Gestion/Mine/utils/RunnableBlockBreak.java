package fr.highsky.roleplay.Gestion.Mine.utils;


import fr.highsky.roleplay.Gestion.Mine.MineListener;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalTime;

public class RunnableBlockBreak extends BukkitRunnable {
    @Override
    public void run() {

        String[] localTime = LocalTime.now().toString().split(":");
        String[] args = MineListener.blocksBreak.keySet().toString().split(",");
        String[] time = MineListener.blocksBreak.get(args[0]).toString().split(";");
        float sec = Float.parseFloat(localTime[2]);
        float verifTime = Float.parseFloat(time[2]);

        if(sec <= verifTime + 30){
            Block[] blocks = MineListener.blocksBreak.keySet().toArray(new Block[MineListener.blocksBreak.size()]);

        }
    }
}

