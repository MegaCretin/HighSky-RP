package fr.highsky.roleplay.Gestion.Mine.npc;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class NpcMine implements Listener {

    @EventHandler
    public void onMineClick(NPCRightClickEvent e){

        if(e.getClicker() instanceof Player) {
            Player p = e.getClicker();
            if (!p.isOp()) {
                if (e.getNPC().getId() == 7) {

                    Date now = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("EEEE");
                    String day = format.format(now);
                    int hour = LocalTime.now().getHour();
                    int min = LocalTime.now().getMinute();

                    if (day.equalsIgnoreCase("Monday") || day.equalsIgnoreCase("Wednesday") || day.equalsIgnoreCase("Friday") && (hour >= 20 && min >= 00) && (hour < 21 && min < 00)) {

                        if (p.hasPermission("mine.access")){

                            World w = Bukkit.getWorld("Mines");
                            Location loc = new Location(w, 0.50, 75, 0.50);

                            p.teleport(loc);

                            p.sendMessage("§7§lMine §8§l» §aVous avez été téléporté à la mine.");


                        }else {
                            p.sendMessage("§7§lMine §8§l» §cDésolé mais tu n'as pas le §6§LPassMine§c.");
                        }

                    } else if (day.equalsIgnoreCase("Sunday") && (hour >= 13 && min >= 00) && (hour < 13 && min < 59)) {

                        World w = Bukkit.getWorld("Mines");
                        Location loc = new Location(w, 0.50, 75, 0.50);

                        p.teleport(loc);

                        p.sendMessage("§7§lMine §8§l» §aVous avez été téléporté à la mine.");

                    } else {
                        p.sendMessage("§7§lMine §8§l» §cLa mine n'est pas ouverte.");
                        return;
                    }

                }
            }else if(p.isOp()){
                if (e.getNPC().getId() == 7) {
                    World w = Bukkit.getWorld("Mines");
                    Location loc = new Location(w, 0.50, 75, 0.50);

                    p.teleport(loc);

                    p.sendMessage("§7§lMine §8§l» §aVous avez été téléporté à la mine.");
                }
            }
        }


    }

}
