package fr.highsky.roleplay.Utils;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

public class BOSSBAR_UTILS {

    public static BossBar b;

    public static BossBar addBossBar(Player p, String msg){

        b = Bukkit.createBossBar(msg.replace("&", "§"), BarColor.PINK, BarStyle.SOLID);

        b.addPlayer(p);

        return b;
    }

    public static BossBar removeBossBar(Player p){

        b.removePlayer(p);

        return b;
    }

}
