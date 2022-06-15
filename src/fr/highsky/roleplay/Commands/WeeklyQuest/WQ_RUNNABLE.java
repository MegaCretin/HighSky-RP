package fr.highsky.roleplay.Commands.WeeklyQuest;

import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class WQ_RUNNABLE extends BukkitRunnable {
    

    @Override
    public void run() {

        int hour = LocalTime.now().getHour();
        int min = LocalTime.now().getMinute();
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("EEEE");
        String day = format.format(now);


        if(day.equalsIgnoreCase("sunday") && hour == 17 && min == 00){


            List op = WQ_BDD.getTop5();
            String[] s = op.toString().replace("[","").replace(" ", "").replace("]", "").split(",");
            Bukkit.broadcastMessage("§m§l                                                               ");
            Bukkit.broadcastMessage("§6§lLes vainqueurs des quêtes hebdomadaires sont :");
            Bukkit.broadcastMessage("§7#1: §f" + s[0]);
            Bukkit.broadcastMessage("§7#2: §f" + s[1]);
            Bukkit.broadcastMessage("§7#3: §f" + s[2]);
            Bukkit.broadcastMessage("§7#4: §f" + s[3]);
            Bukkit.broadcastMessage("§7#5: §f" + s[4]);
            Bukkit.broadcastMessage("§m§l                                                               ");

            Main.getInstance().getConfig().set("Winner.One.player", s[0]);
            Main.getInstance().getConfig().set("Winner.One.recup", true);
            Main.getInstance().getConfig().set("Winner.Two.player", ""+s[1]);
            Main.getInstance().getConfig().set("Winner.Two.recup", true);
            Main.getInstance().getConfig().set("Winner.Three.player", ""+s[2]);
            Main.getInstance().getConfig().set("Winner.Three.recup", true);
            Main.getInstance().getConfig().set("Winner.Four.player", ""+s[3]);
            Main.getInstance().getConfig().set("Winner.Four.recup", true);
            Main.getInstance().getConfig().set("Winner.Five.player", ""+s[4]);
            Main.getInstance().getConfig().set("Winner.Five.recup", true);
            Main.getInstance().saveConfig();


            try {
                WQ_BDD.deleteBDD();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }


            ItemStack material = aleaItem();
            String item = material.toString();

            Main.getInstance().getConfig().set("WeeklyQuest.WeekItems", item);
            Main.getInstance().saveConfig();
            return;




        }else return;



    }







    public static ItemStack aleaItem(){
        Random r = new Random();
        int choix = 14;
        int alea = 1 + r.nextInt(choix - 1);
        switch (alea){
            case 1:
                return new ItemStack(Material.POPPY);
            case 2:
                return new ItemStack(Material.WHEAT);
            case 3:
                return new ItemStack(Material.COBBLESTONE);
            case 4:
                return new ItemStack(Material.INK_SAC);
            case 5:
                return new ItemStack(Material.BEETROOT);
            case 6:
                return new ItemStack(Material.STONE);
            case 7:
                return new ItemStack(Material.SPRUCE_LEAVES);
            case 8:
                return new ItemStack(Material.BIRCH_LOG);
            case 9:
                return new ItemStack(Material.NETHER_WART);
            case 10:
                return new ItemStack(Material.CAKE);
            case 11:
                return new ItemStack(Material.PORKCHOP);
            case 12:
                return new ItemStack(Material.CHORUS_FRUIT);
            case 13:
                return new ItemStack(Material.CARROT);
            case 14:
                return new ItemStack(Material.POTATO);
            default:
                break;
        }
        return new ItemStack(Material.CACTUS);
    }


}
