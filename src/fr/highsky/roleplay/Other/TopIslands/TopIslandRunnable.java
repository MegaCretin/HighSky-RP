package fr.highsky.roleplay.Other.TopIslands;

import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;

public class TopIslandRunnable extends BukkitRunnable {
    @Deprecated
    @Override
    public void run() {

        try {
            GetIslandTop.getTopIS();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
