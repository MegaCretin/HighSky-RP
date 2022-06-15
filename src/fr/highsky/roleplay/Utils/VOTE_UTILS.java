package fr.highsky.roleplay.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class VOTE_UTILS {
    
    public static Integer getLevel(Player p){
        File file = new File("plugins/HighSky-RP/Origine/PlayerData/"+p.getName()+".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config.getInt("Vote.Level");
    }

    public static Integer getMounthAmount(Player p){
        File file = new File("plugins/HighSky-RP/Origine/PlayerData/"+p.getName()+".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config.getInt("Vote.Mounth-Amount");
    }

    public static Integer getTotalAmount(Player p){
        File file = new File("plugins/HighSky-RP/Origine/PlayerData/"+p.getName()+".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config.getInt("Vote.Total-Amount");
    }

    public static Integer getPoint(Player p){
        File file = new File("plugins/HighSky-RP/Origine/PlayerData/"+p.getName()+".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        return config.getInt("Vote.Point");
    }

    public static String getAmount(Player p){
        if(getLevel(p) == 0)return "§7(§f"+getPoint(p)+"§7/§f20§7)";
        if(getLevel(p) == 1)return "§7(§f"+getPoint(p)+"§7/§f40§7)";
        if(getLevel(p) == 2)return "§7(§f"+getPoint(p)+"§7/§f60§7)";
        if(getLevel(p) == 3)return "§7(§f"+getPoint(p)+"§7/§f80§7)";
        if(getLevel(p) == 4)return "§7(§f"+getPoint(p)+"§7/§f100§7)";
        if(getLevel(p) == 5)return "§7(§f"+getPoint(p)+"§7/§f120§7)";
        if(getLevel(p) == 6)return "§7(§f"+getPoint(p)+"§7/§f140§7)";
        if(getLevel(p) == 7)return "§7(§f"+getPoint(p)+"§7/§f160§7)";
        if(getLevel(p) == 8)return "§7(§f"+getPoint(p)+"§7/§f180§7)";
        if(getLevel(p) == 9)return "§7(§f"+getPoint(p)+"§7/§f200§7)";
        if(getLevel(p) == 10)return "§7(§f"+getPoint(p)+"§7/§f220§7)";
        return "";
    }

    public static String getProgress(Player p){
        if(getLevel(p) == 0){ //POINT REQUIS = 20
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) == 1)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) == 2)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) == 3)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) == 4)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) == 5)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) == 6)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) == 7)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) == 8)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) == 9)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) == 10)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) == 11)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) == 12)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) == 13)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) == 14)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) == 15)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) == 16)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) == 17)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) == 18)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) == 19)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) == 20)return "§7Progression: §a||||||||||||||||||||";
        }else if(getLevel(p) == 1){ //POINT REQUIS = 40
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) <= 2)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) <= 4)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) <= 6)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) <= 8)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) <= 10)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) <= 12)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) <= 14)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) <= 16)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) <= 18)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) <= 20)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) <= 22)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) <= 24)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) <= 26)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) <= 28)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) <= 30)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) <= 32)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) <= 34)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) <= 36)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) <= 38)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) <= 40)return "§7Progression: §a||||||||||||||||||||";
        }else if(getLevel(p) == 2){ //POINT REQUIS = 60
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) <= 3)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) <= 6)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) <= 9)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) <= 12)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) <= 15)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) <= 18)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) <= 21)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) <= 24)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) <= 27)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) <= 30)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) <= 33)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) <= 36)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) <= 39)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) <= 42)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) <= 45)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) <= 48)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) <= 51)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) <= 54)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) <= 57)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) <= 60)return "§7Progression: §a||||||||||||||||||||";
        }else if(getLevel(p) == 3){ //POINT REQUIS = 80
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) <= 4)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) <= 8)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) <= 12)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) <= 16)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) <= 20)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) <= 24)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) <= 28)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) <= 32)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) <= 36)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) <= 40)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) <= 44)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) <= 48)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) <= 52)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) <= 56)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) <= 60)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) <= 64)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) <= 68)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) <= 72)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) <= 76)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) <= 80)return "§7Progression: §a||||||||||||||||||||";
        }else if(getLevel(p) == 4){ //POINT REQUIS = 100
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) <= 5)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) <= 10)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) <= 15)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) <= 20)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) <= 25)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) <= 30)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) <= 35)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) <= 40)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) <= 45)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) <= 50)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) <= 55)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) <= 60)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) <= 65)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) <= 70)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) <= 75)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) <= 80)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) <= 85)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) <= 90)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) <= 95)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) <= 100)return "§7Progression: §a||||||||||||||||||||";
        }else if(getLevel(p) == 5){ //POINT REQUIS = 120
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) <= 6)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) <= 12)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) <= 18)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) <= 24)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) <= 30)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) <= 36)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) <= 42)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) <= 48)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) <= 54)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) <= 60)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) <= 66)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) <= 72)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) <= 78)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) <= 84)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) <= 90)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) <= 96)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) <= 102)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) <= 108)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) <= 114)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) <= 120)return "§7Progression: §a||||||||||||||||||||";
        }
        else if(getLevel(p) == 6){ //POINT REQUIS = 140
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) <= 7)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) <= 14)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) <= 21)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) <= 28)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) <= 35)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) <= 42)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) <= 49)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) <= 56)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) <= 63)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) <= 70)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) <= 77)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) <= 84)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) <= 91)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) <= 98)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) <= 105)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) <= 112)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) <= 119)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) <= 126)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) <= 133)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) <= 140)return "§7Progression: §a||||||||||||||||||||";
        }else if(getLevel(p) == 7){ //POINT REQUIS = 160
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) <= 8)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) <= 16)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) <= 24)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) <= 32)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) <= 40)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) <= 48)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) <= 56)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) <= 64)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) <= 72)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) <= 80)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) <= 88)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) <= 96)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) <= 104)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) <= 112)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) <= 120)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) <= 128)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) <= 136)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) <= 144)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) <= 152)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) <= 160)return "§7Progression: §a||||||||||||||||||||";
        }else if(getLevel(p) == 8){ //POINT REQUIS = 180
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) <= 9)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) <= 18)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) <= 27)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) <= 36)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) <= 45)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) <= 54)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) <= 63)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) <= 72)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) <= 81)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) <= 90)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) <= 99)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) <= 108)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) <= 117)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) <= 126)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) <= 135)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) <= 144)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) <= 153)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) <= 162)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) <= 171)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) <= 180)return "§7Progression: §a||||||||||||||||||||";
        }else if(getLevel(p) == 9){ //POINT REQUIS = 200
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) <= 10)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) <= 20)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) <= 30)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) <= 40)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) <= 50)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) <= 60)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) <= 70)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) <= 80)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) <= 90)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) <= 100)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) <= 110)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) <= 120)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) <= 130)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) <= 140)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) <= 150)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) <= 160)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) <= 170)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) <= 180)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) <= 190)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) <= 200)return "§7Progression: §a||||||||||||||||||||";
        }else if(getLevel(p) == 10){ //POINT REQUIS = 220
            if(getPoint(p) == 0)return "§7Progression: §e||||||||||||||||||||";
            else if(getPoint(p) <= 11)return "§7Progression: §a|§e|||||||||||||||||||";
            else if(getPoint(p) <= 22)return "§7Progression: §a||§e||||||||||||||||||";
            else if(getPoint(p) <= 33)return "§7Progression: §a|||§e|||||||||||||||||";
            else if(getPoint(p) <= 44)return "§7Progression: §a||||§e||||||||||||||||";
            else if(getPoint(p) <= 55)return "§7Progression: §a|||||§e|||||||||||||||";
            else if(getPoint(p) <= 66)return "§7Progression: §a||||||§e||||||||||||||";
            else if(getPoint(p) <= 77)return "§7Progression: §a|||||||§e|||||||||||||";
            else if(getPoint(p) <= 88)return "§7Progression: §a||||||||§e||||||||||||";
            else if(getPoint(p) <= 99)return "§7Progression: §a|||||||||§e|||||||||||";
            else if(getPoint(p) <= 110)return "§7Progression: §a||||||||||§e||||||||||";
            else if(getPoint(p) <= 121)return "§7Progression: §a|||||||||||§e|||||||||";
            else if(getPoint(p) <= 132)return "§7Progression: §a||||||||||||§e||||||||";
            else if(getPoint(p) <= 143)return "§7Progression: §a|||||||||||||§e|||||||";
            else if(getPoint(p) <= 154)return "§7Progression: §a||||||||||||||§e||||||";
            else if(getPoint(p) <= 165)return "§7Progression: §a|||||||||||||||§e|||||";
            else if(getPoint(p) <= 176)return "§7Progression: §a||||||||||||||||§e||||";
            else if(getPoint(p) <= 187)return "§7Progression: §a|||||||||||||||||§e|||";
            else if(getPoint(p) <= 198)return "§7Progression: §a||||||||||||||||||§e||";
            else if(getPoint(p) <= 209)return "§7Progression: §a|||||||||||||||||||§e|";
            else if(getPoint(p) <= 220)return "§7Progression: §a||||||||||||||||||||";
        }
        
        return "";
    }
    
    
    
}
