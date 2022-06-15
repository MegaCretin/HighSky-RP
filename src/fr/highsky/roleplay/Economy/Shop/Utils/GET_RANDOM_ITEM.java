package fr.highsky.roleplay.Economy.Shop.Utils;


import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GET_RANDOM_ITEM {

    public static String getItemRDM(String categorie){

        File file = new File("plugins/HighSky-RP/ConfigShop.yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

        List<String> list = new ArrayList<>();

        for(String st:config.getConfigurationSection(categorie+".").getKeys(true)){
            list.add(st);
        }

        int r = new Random().nextInt(list.size());
        String s1 = config.getString(categorie+"."+list.get(r));
        String[] items = s1.split("/");


        return items[0];

    }



}
