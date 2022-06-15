package fr.highsky.roleplay.Commands.Quests;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class GET_LVL_QUEST {

    public static String getQuestLVL(Player p, String QuestName){

        File file = new File("plugins/HighSky-RP/PlayerData/"+p.getName()+".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        String[] list = config.getString("Quest."+QuestName).split("/");
        for(int i =0;i<list.length;i++){
            if(!list[i].equalsIgnoreCase("2") && !list[i].equalsIgnoreCase("1") && list[i].equalsIgnoreCase("0")){
                if(!list[(i-1)].equalsIgnoreCase("0")){
                    int level = Integer.parseInt(list[i]);
                    if(level == 0)return "One";
                    else if(level == 1)return "Two";
                    else if(level == 2)return "Three";
                    else if(level == 3)return "Four";
                    else if(level == 4)return "Five";
                }
            }
        }


        return "";
    }

}
