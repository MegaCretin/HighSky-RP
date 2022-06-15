package fr.highsky.roleplay.Events;


import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Gestion.Moderation.Utils.TICK_UTILS;
import fr.highsky.roleplay.Other.PLAYER_DATABASE;
import fr.highsky.roleplay.Events.PlayTime.PT_BDD;
import fr.highsky.roleplay.Commands.TempFly.Utils.TFLY_UTILS;
import fr.highsky.roleplay.Commands.Quests.REGION_JOIN_LEAVE;
import fr.highsky.roleplay.Utils.PLAYER_FILE;
import fr.highsky.roleplay.Commands.WeeklyQuest.WQ_BDD;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

public class JOIN_EVENT implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws IOException, SQLException {

        Player p = e.getPlayer();

        /*if(Main.getInstance().getConfig().getBoolean("Maintenance.Statut")){
            String[] li = Main.getInstance().getConfig().getString("Maintenance.List").replace(" ","").split(",");
            List list = Arrays.asList(li);
            if (!list.contains(p.getName())) {

                p.kickPlayer("§6§lHigh§b§lSky\n\n§c     Le serveur est en maintenance\n§5Discord: §7https://discord.gg/xHEYY3R.");
            }

        }*/

        if(!PLAYER_DATABASE.playerExist(p)){
            PLAYER_DATABASE.addPlayer(p);
        }

        if(!PT_BDD.playerExist(p)){
            PT_BDD.addPlayer(p);
        }

        if(WQ_BDD.playerExist(p) == false){
            WQ_BDD.addPlayer(p);
        }

        PLAYER_FILE.addPlayerFile(p.getName());

        PLAYER_FILE.addPlayerFile(p.getName());

        File filePlayer = new File("plugins/HighSky-RP/Origine/PlayerData/"+p.getName()+".yml");
        FileConfiguration configPlayer = YamlConfiguration.loadConfiguration(filePlayer);
        e.setJoinMessage(null);
        for(Player op : Bukkit.getOnlinePlayers()) {
            if(!p.hasPlayedBefore()){
                BossBar bb = Bukkit.createBossBar("§8§l» §7Bienvenue à §e"+p.getName()+" §7sur §6§lHigh§b§lSky §7(§f/b§7) §8§l«",BarColor.WHITE,BarStyle.SOLID);
                bb.addPlayer(op);
                new BukkitRunnable() { 
                    @Override
                    public void run() {

                        bb.removePlayer(op);
                    }
                }.runTaskLaterAsynchronously(Main.getInstance(), 200);

            }
            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§7[§a+§7] §7" + p.getName()));
        }

        /*
        String StartedName = configPlayer.getString("QuestPrincipal.Started.Name");
        String StartedCheckPoint = configPlayer.getString("QuestPrincipal.Started.CheckPoint");
        
        /*if(!StartedName.isEmpty()){
            File file = new File("plugins/HighSky-RP/Origine/Quests/"+StartedName+".yml");
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            String MsgBossBar = config.getString(StartedName+"."+StartedCheckPoint+".BossBar-Message");
            BOSSBAR_UTILS.addBossBar(p, MsgBossBar);
        }*/


        //VERFICATION FOR THE FLYING PLAYER
        if(TFLY_UTILS.tTimer.containsKey(p.getUniqueId())){
            Long time = null;
            if(TFLY_UTILS.getRank(p).equals("MVP")){
                time = TICK_UTILS.getTick("Heures", 2) - (TICK_UTILS.getTick("Heures", 2) - TFLY_UTILS.tTimer.get(p.getUniqueId()));
            }else if(TFLY_UTILS.getRank(p).equals("VIP")){
                time = TICK_UTILS.getTick("Heures", 1) - (TICK_UTILS.getTick("Heures", 1) - TFLY_UTILS.tTimer.get(p.getUniqueId()));
            }
            long endFly = System.currentTimeMillis() + time;
            TFLY_UTILS.setFlyer(p, endFly);
            p.sendMessage("§B§LFLY §8§l» §aFly activé il vous reste: §e" + TFLY_UTILS.getTime(endFly) + "§a.");
            p.setAllowFlight(true);
            p.setFlying(true);
            TFLY_UTILS.tTimer.remove(p.getUniqueId());
            TFLY_UTILS.useFly.add(p);
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        REGION_JOIN_LEAVE.woodRegion.remove(p);
        for(Player op : Bukkit.getOnlinePlayers()) {
            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§7[§c-§7] §7" + p.getName()));
        }

    }


}
