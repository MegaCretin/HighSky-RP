package fr.highsky.roleplay.Utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FILE_UTILS {

    public static void addfile() throws IOException {
        File file = new File("plugins/HighSky-RP/Origine/Quests/Quest.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);
        if(!file.exists()){
            file.createNewFile();
            addChallenge(config, "1", "La première", 0, "&6Fermier: &aRécolte moi 64 blés.", Arrays.asList("&dBonjour","&eComment allez-vous ?","&aJ'ai besoin de 64 blé aller vite m'en chercher s'il vous plait."),Arrays.asList("&aJ'attend toujours mes 64 blés","&ec'est urgent."),Arrays.asList("&dMerci à toi jeune aventurier !","&eTiens 64 stone pour te remercier !"), Arrays.asList("WHEAT:64"),Arrays.asList("GRASS:64"),500.0, null);
            saveFile(config);
        }
    }


    public static void saveFile(FileConfiguration configuration) throws IOException {
        File file = new File("plugins/HighSky-RP/Origine/Quests/Quest.yml");
        configuration.save(file);
    }


    public static void addChallenge(FileConfiguration config, String Number, String name, int NpcID,String BossBarMessage, List<String> StartMessage, List<String> StartedMessage, List<String> EndMessage, List<String> RequiredItems, List<String> RewardItems, Double RewardMoney, String RewardCommand){
        config.set("Quest.Quest-"+Number+".Name", name);
        config.set("Quest.Quest-"+Number+".NPC", NpcID);
        config.set("Quest.Quest-"+Number+".BossBar-Message", BossBarMessage);
        config.set("Quest.Quest-"+Number+".Start-Message", StartMessage);
        config.set("Quest.Quest-"+Number+".Started-Message", StartedMessage);
        config.set("Quest.Quest-"+Number+".End-Message", EndMessage);
        config.set("Quest.Quest-"+Number+".Required-Items", RequiredItems);
        config.set("Quest.Quest-"+Number+".Reward-Items", RewardItems);
        config.set("Quest.Quest-"+Number+".Reward-Money", RewardMoney);
        if(RewardCommand != null) config.set("Quest.Quest-"+Number+".Reward-Command", RewardCommand);
    }
}
