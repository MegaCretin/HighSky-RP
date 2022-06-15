package fr.highsky.roleplay.Commands.DayliQuest;

import fr.herllox.hmoney.API.MoneyAPI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DQ_UTILS {

    public static ArrayList<Player> players = new ArrayList<>();

    public static ItemStack getInfo(Material mat){

        ItemStack it = new ItemStack(mat);

        switch (mat){
            case WHEAT:
            case GRANITE:
            case ANDESITE:
            case DIORITE:
            case PUMPKIN:
                it.setAmount(256);
                break;
            case POTATO:
            case CARROT:
                it.setAmount(192);
                break;
            case MELON_SLICE:
            case COOKIE:
            case STONE:
            case ROTTEN_FLESH:
                it.setAmount(512);
                break;
            case SWEET_BERRIES:
            case DIRT:
            case BREAD:
            case OAK_LOG:
            case SPRUCE_LOG:
            case BIRCH_LOG:
            case JUNGLE_LOG:
            case ACACIA_LOG:
            case DARK_OAK_LOG:
            case CHICKEN:
            case RABBIT:
            case MUTTON:
                it.setAmount(128);
                break;
            case BEETROOT:
            case TROPICAL_FISH:
            case SALMON:
            case COD:
            case BEEF:
            case PORKCHOP:
                it.setAmount(64);
                break;
            case COCOA_BEANS:
            case COBBLESTONE:
                it.setAmount(1024);
                break;
        }

        return it;

    }

    public static List<String> setQuest(Material mat){

        switch (mat){
            //NATURAL PART
            case WHEAT:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f256 §eblés","  §3Récompense: §f500 §e$","","§7Difficulté: §a||§7||||||||||||||||||");
            case POTATO:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f192 §epattates","  §3Récompense: §f1000 §e$","","§7Difficulté: §a||§7||||||||||||||||||");
            case CARROT:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f192 §ecarottes","  §3Récompense: §f1000 §e$","","§7Difficulté: §a||§7||||||||||||||||||");
            case MELON_SLICE:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f512 §etranches de melon","  §3Récompense: §f8 §eBlocs de terre","","§7Difficulté: §a||||§7||||||||||||||||");
            case PUMPKIN:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f256 §ecitrouilles","  §3Récompense: §f8 §esables","","§7Difficulté: §a||||§7||||||||||||||||");
            case SWEET_BERRIES:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §ebaies","  §3Récompense: §f1500 §e$","","§7Difficulté: §a||||§7||||||||||||||||");
            case BEETROOT:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f64 §ebetteraves","  §3Récompense: §f1000 §e$","","§7Difficulté: §a||||§7||||||||||||||||");
            case BREAD:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §epains","  §3Récompense: §f1500 §e$","","§7Difficulté: §a||§7||||||||||||||||||");
            case COCOA_BEANS:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f1024 §efèves de cacao","  §3Récompense: §f1 §ebloc de fer","","§7Difficulté: §a||||||§7||||||||||||||");
            case COOKIE:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f512 §ebiscuits","  §3Récompense: §f2500 §e$","","§7Difficulté: §a||||||§7||||||||||||||");

            //BLOCK PART

            case COBBLESTONE:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f1024 §epierres","  §3Récompense: §f1000 §e$","","§7Difficulté: §a||§7||||||||||||||||||");
            case STONE:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f512 §eroches","  §3Récompense: §f2000 §e$","","§7Difficulté: §a||||||§7||||||||||||||");
            case GRANITE:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f256 §egranites","  §3Récompense: §f1500 §e$","","§7Difficulté: §a||||||||§7||||||||||||");
            case DIORITE:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f256 §ediorites","  §3Récompense: §f1500 §e$","","§7Difficulté: §a||||||||§7||||||||||||");
            case ANDESITE:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f256 §eandésites","  §3Récompense: §f1500 §e$","","§7Difficulté: §a||||||||§7||||||||||||");
            case OAK_LOG:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §ebûches de chêne","  §3Récompense: §f16 §ed'herbe","","§7Difficulté: §a||||§7||||||||||||||||");
            case SPRUCE_LOG:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §ebûches de sapin","  §3Récompense: §f8 §eMycélium","","§7Difficulté: §a||||§7||||||||||||||||");
            case BIRCH_LOG:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §ebûches de bouleau","  §3Récompense: §f1000 §e$","","§7Difficulté: §a||||§7||||||||||||||||");
            case JUNGLE_LOG:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §ebûches de d'acajou","  §3Récompense: §f1000 §e$","","§7Difficulté: §a||||§7||||||||||||||||");
            case ACACIA_LOG:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §ebûches d'acacia","  §3Récompense: §f1000 §e$","","§7Difficulté: §a||||§7||||||||||||||||");
            case DARK_OAK_LOG:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §ebûches de chêne noir","  §3Récompense: §f1000 §e$","","§7Difficulté: §a||||§7||||||||||||||||");
            case DIRT:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §eterres","  §3Récompense: §f2500 §e$","","§7Difficulté: §a||§7||||||||||||||||||");

            //MOBS PART

            case PORKCHOP:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f64 §ecôtelletes de porc cru","  §3Récompense: §f1000 §e$","","§7Difficulté: §a||||§7||||||||||||||||");
            case BEEF:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f64 §eboeufs cru","  §3Récompense: §f2000 §e$","","§7Difficulté: §a||||§7||||||||||||||||");
            case MUTTON:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §emouttons cru","  §3Récompense: §f1500 §e$","","§7Difficulté: §a||||||||§7||||||||||||");
            case RABBIT:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §elapins cru","  §3Récompense: §f1500 §e$","","§7Difficulté: §a||||||§7||||||||||||||");
            case CHICKEN:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f128 §epoulets cru","  §3Récompense: §f1500 §e$","","§7Difficulté: §a||||||§7||||||||||||||");
            case COD:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f64 §emorues cru","  §3Récompense: §f16 §ed'herbe","","§7Difficulté: §e||||||||§7||||||||||||");
            case SALMON:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f64 §esaumons cru","  §3Récompense: §f1 §eBloc d'or","","§7Difficulté: §e||||||||§7||||||||||||");
            case TROPICAL_FISH:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f64 §epoissons tropical","  §3Récompense: §f1000 §e$","","§7Difficulté: §e||||||||||§7||||||||||");
            case ROTTEN_FLESH:
                return Arrays.asList("","§7[§8I§7]","","  §3Objet requis: §f512 §echairs putréfiée","  §3Récompense: §f1000 §e$","","§7Difficulté: §a||||§7||||||||||||||||");
        }

        return null;

    }

    public static List<String> getReward(Material mat, Player p){

        switch (mat){
            //NATURAL PART
            case WHEAT:
                MoneyAPI.giveMoney(p, 500.00);
                break;
            case POTATO:
            case ROTTEN_FLESH:
            case TROPICAL_FISH:
            case PORKCHOP:
            case DARK_OAK_LOG:
            case ACACIA_LOG:
            case JUNGLE_LOG:
            case BIRCH_LOG:
            case COBBLESTONE:
            case BEETROOT:
            case CARROT:
                MoneyAPI.giveMoney(p, 1000.00);
                break;
            case MELON_SLICE:
                p.getInventory().addItem(new ItemStack(Material.DIRT, 8));
                break;
            case PUMPKIN:
                p.getInventory().addItem(new ItemStack(Material.SAND, 8));
                break;
            case SWEET_BERRIES:
            case CHICKEN:
            case RABBIT:
            case MUTTON:
            case ANDESITE:
            case DIORITE:
            case GRANITE:
            case BREAD:
                MoneyAPI.giveMoney(p, 1500.00);
                break;
            case COCOA_BEANS:
                p.getInventory().addItem(new ItemStack(Material.IRON_BLOCK, 1));
                break;
            case COOKIE:
            case DIRT:
                MoneyAPI.giveMoney(p, 2500.00);
                break;
            case STONE:
            case BEEF:
                MoneyAPI.giveMoney(p, 2000.00);
                break;
            case OAK_LOG:
            case COD:
                p.getInventory().addItem(new ItemStack(Material.GRASS_BLOCK, 16));
                break;
            case SPRUCE_LOG:
                p.getInventory().addItem(new ItemStack(Material.MYCELIUM, 8));
                break;
            case SALMON:
                p.getInventory().addItem(new ItemStack(Material.GOLD_BLOCK, 1));
                break;
        }

        return null;

    }

    public static String DQOne(){

        Random r = new Random();
        int locate = 12;
        int alea = 1 + r.nextInt(locate);

        if(alea == 1){
            return "COBBLESTONE";
        }else if(alea == 2){
            return "STONE";
        }else if(alea == 3){
            return "GRANITE";
        }else if(alea == 4){
            return "DIORITE";
        }else if(alea == 5){
            return "ANDESITE";
        }else if(alea == 6){
            return "OAK_LOG";
        }else if(alea == 7){
            return "SPRUCE_LOG";
        }else if(alea == 8){
            return "BIRCH_LOG";
        }else if(alea == 9){
            return "JUNGLE_LOG";
        }else if(alea == 10){
            return "ACACIA_LOG";
        }else if(alea == 11){
            return "DARK_OAK_LOG";
        }else if(alea == 12){
            return "DIRT";
        }
        return null;
    }

    public static String DQTwo(){

        Random r = new Random();
        int locate = 9;
        int alea = 1 + r.nextInt(locate);

        if(alea == 1){
            return "PORKCHOP";
        }else if(alea == 2){
            return "BEEF";
        }else if(alea == 3){
            return "MUTTON";
        }else if(alea == 4){
            return "RABBIT";
        }else if(alea == 5){
            return "CHICKEN";
        }else if(alea == 6){
            return "COD";
        }else if(alea == 7){
            return "SALMON";
        }else if(alea == 8){
            return "TROPICAL_FISH";
        }else if(alea == 9){
            return "ROTTEN_FLESH";
        }
        return null;
    }

    public static String DQThree(){

        Random r = new Random();
        int locate = 10;
        int alea = 1 + r.nextInt(locate);

        if(alea == 1){
            return "WHEAT";
        }else if(alea == 2){
            return "CARROT";
        }else if(alea == 3){
            return "POTATO";
        }else if(alea == 4){
            return "MELON_SLICE";
        }else if(alea == 5){
            return "PUMPKIN";
        }else if(alea == 6){
            return "SWEET_BERRIES";
        }else if(alea == 7){
            return "BEETROOT";
        }else if(alea == 8){
            return "BREAD";
        }else if(alea == 9){
            return "COCOA_BEANS";
        }else if(alea == 10){
            return "COOKIE";
        }
        return null;
    }

}
