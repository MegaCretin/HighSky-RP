package fr.highsky.roleplay.Chat;

import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AUTO_MESSAGE extends BukkitRunnable {

    private String oldmess;

    @Override
    public void run() {

        int i = new Random().nextInt(mess().size());
        if (mess().get(i).equalsIgnoreCase(oldmess))
        while (mess().get(i).equalsIgnoreCase(oldmess)){
            i++;
            if(i > mess().size()+1){
                i = 1;
            }
        }else{
            Bukkit.broadcastMessage(mess().get(i));
            oldmess = mess().get(i);
        }

    }

    public static List<String> mess(){

        List<String> mess = new ArrayList<>();

        for(String s : Main.getInstance().getConfig().getStringList("AutoMessage.")){
            mess.add(s);
            Bukkit.broadcastMessage("done");
        }
        return mess;
    }

}
