package fr.highsky.roleplay.Utils;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PLAYER_FILE {


    public static void addPlayerFile(String name) throws IOException {
        File file = new File("plugins/HighSky-RP/Origine/PlayerData/"+name+".yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        if(!file.exists()){
            File fileQO = new File("plugins/HighSky-RP/Origine/Quests/NPC/NPC.yml");
            FileConfiguration configQO = YamlConfiguration.loadConfiguration(fileQO);

            file.createNewFile();

            config.set("Vote.Level", 0);
            config.set("Vote.Point", 0);
            config.set("Vote.Month-Amount", 0);
            config.set("Vote.Total-Amount", 0);

            config.set("QuestPrincipal.Started.Debut", false);
            config.set("QuestPrincipal.Started.Name", "Start");
            config.set("QuestPrincipal.Started.CheckPoint", 0);
            config.set("QuestPrincipal.Started.Id", 0);
            config.set("QuestPrincipal.Started.IdNext", 9);

            config.set("Quest.Current", false);
            config.set("Quest.Started", "");
            /** test**/

            for(String s : configQO.getStringList("NPC")){
                int i = 0;
                File fileQONPC = new File("plugins/HighSky-RP/Origine/Quests/NPC/"+s+".yml");
                FileConfiguration configQONPC = YamlConfiguration.loadConfiguration(fileQONPC);

                config.set("Quest.Quests.Origine."+s+"-Last", 0);

                for(String ss : configQONPC.getConfigurationSection("Quest").getKeys(false)){
                    i++;
                    config.set("Quest.Quests.Origine."+s+"."+i+"Q", false);
                }
            }
            savePlayerFile(name, config);
        }
        else{
            File fileQO = new File("plugins/HighSky-RP/Origine/Quests/NPC/NPC.yml");
            FileConfiguration configQO = YamlConfiguration.loadConfiguration(fileQO);

            for(String s : configQO.getStringList("NPC")){
                int i = 0;
                File fileQONPC = new File("plugins/HighSky-RP/Origine/Quests/NPC/"+s+".yml");
                FileConfiguration configQONPC = YamlConfiguration.loadConfiguration(fileQONPC);

                if(!config.contains("Quest.Quests.Origine."+s+"-Last")){
                    config.set("Quest.Quests.Origine."+s+"-Last", 0);
                }

                for(String ss : configQONPC.getConfigurationSection("Quest").getKeys(false)){
                    i++;
                    if (!config.contains("Quest.Quests.Origine."+s+"."+i+"Q")){
                        config.set("Quest.Quests.Origine."+s+"."+i+"Q", false);
                    }
                }
            }
            savePlayerFile(name, config);
        }
    }


    public static void savePlayerFile(String name, FileConfiguration configuration) throws IOException {
        File file = new File("plugins/HighSky-RP/Origine/PlayerData/"+name+".yml");
        configuration.save(file);
    }


}
