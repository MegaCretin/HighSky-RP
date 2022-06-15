package fr.highsky.roleplay.Economy.Shop.Utils;

import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.time.LocalTime;

public class Runnable extends BukkitRunnable {
    @Override
    public void run() {


        int hour = LocalTime.now().getHour();
        int min = LocalTime.now().getMinute();

        if(hour == 10 && min == 00){

            Main.getInstance().getConfig().set("Blocks", GET_RANDOM_ITEM.getItemRDM("Blocks"));
            Main.getInstance().getConfig().set("Eat", GET_RANDOM_ITEM.getItemRDM("Eat"));
            Main.getInstance().getConfig().set("Ore", GET_RANDOM_ITEM.getItemRDM("Ore"));
            Main.getInstance().getConfig().set("Loots", GET_RANDOM_ITEM.getItemRDM("Loots"));
            Main.getInstance().getConfig().set("Coral", GET_RANDOM_ITEM.getItemRDM("Coral"));
            Main.getInstance().getConfig().set("World", GET_RANDOM_ITEM.getItemRDM("World"));
            Main.getInstance().getConfig().set("Other", GET_RANDOM_ITEM.getItemRDM("Other"));
            Main.getInstance().getConfig().set("Wild", GET_RANDOM_ITEM.getItemRDM("Wild"));
            Main.getInstance().saveConfig();
            Main.getInstance().reloadConfig();

            Bukkit.broadcastMessage("§e§lPROMOTIONS §8» §aDe nouvelles marchandises sont disponibles !");

        }


    }
}
