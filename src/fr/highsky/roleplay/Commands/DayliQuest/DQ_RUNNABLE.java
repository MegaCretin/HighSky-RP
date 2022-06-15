package fr.highsky.roleplay.Commands.DayliQuest;

import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Utils.PLAYER_FILE;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

public class DQ_RUNNABLE extends BukkitRunnable {
    @Override
    public void run() {

        int hour = LocalTime.now().getHour();
        int min = LocalTime.now().getMinute();

        if(hour == 13  && min == 2){
            int i = 0;
            while (DQ_UTILS.players.size() != 0){
                File file = new File("plugins/HighSky-RP/Origine/PlayerData/"+DQ_UTILS.players.get(i).getName()+".yml");
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);
                config.set("DayliQuest.One", false);
                config.set("DayliQuest.Two", false);
                config.set("DayliQuest.Three", false);
                Bukkit.broadcastMessage("1");
                try {
                    PLAYER_FILE.savePlayerFile(DQ_UTILS.players.get(0).getName(), config);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                i++;
                DQ_UTILS.players.remove(DQ_UTILS.players.get(i));
            }
            Bukkit.broadcastMessage(DQ_UTILS.DQOne());
            Main.getInstance().getConfig().set("DayliQuest.One", DQ_UTILS.DQOne());
            Main.getInstance().getConfig().set("DayliQuest.Two", DQ_UTILS.DQTwo());
            Main.getInstance().getConfig().set("DayliQuest.Three", DQ_UTILS.DQThree());
            Main.getInstance().saveConfig();
            Bukkit.broadcastMessage("Finish");
        }

    }
}
