package fr.highsky.roleplay.Events.LootsBoxs.Utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Random;

public class ItemUtils {

    public static ItemStack CommunLoot(){

        Random rdm = new Random();

        int i = 0 + rdm.nextInt(1000-0);
        Double d = Double.valueOf(i);

        //SKYBLOCK


        if (d <= 70) { //7%

            return new ItemStack(Material.DIRT, 16);

        } else if (d > 70 && d < 130) { //6%

            return new ItemStack(Material.GRASS_BLOCK, 8);

        } else if (d > 130 && d < 200) { //7%

            return new ItemStack(Material.OAK_LOG, 16);

        } else if (d > 200 && d <= 260) { //6%

            return new ItemStack(Material.STONE, 16);

        } else if (d > 260 && d <= 330) { //7%

            return new ItemStack(Material.SAND, 16);

        } else if (d > 330 && d <= 400) { //7%

            return new ItemStack(Material.COBBLESTONE, 32);

        } else if (d > 400 && d <= 450) { //5%

            return new ItemStack(Material.REDSTONE, 16);

        } else if (d > 450 && d <= 490) { //4%

            return new ItemStack(Material.COAL, 16);

        } else if (d > 490 && d <= 520) { //3%

            return new ItemStack(Material.IRON_INGOT, 8);

        } else if (d > 520 && d <= 540) { //2%

            return new ItemStack(Material.GOLD_INGOT, 4);

        } else if (d > 540 && d <= 550) { //1%

            return new ItemStack(Material.DIAMOND, 2);

        } else if (d > 550 && d <= 600) { //5%

            return new ItemStack(Material.BREAD, 16);

        } else if (d > 600 && d <= 640) { //4%

            return new ItemStack(Material.COOKED_CHICKEN, 8);

        } else if (d > 640 && d <=680) { //4%

            return new ItemStack(Material.COOKED_BEEF, 8);

        } else if (d > 680 && d <= 750) { //7%

            return new ItemStack(Material.WHEAT_SEEDS, 16);

        } else if (d > 750 && d <= 820) { //7%

            return new ItemStack(Material.MELON_SEEDS, 8);

        } else if (d > 820 && d <= 890) { //7%

            return new ItemStack(Material.PUMPKIN_SEEDS, 8);

        } else if (d > 890 && d <= 960) { //7%

            return new ItemStack(Material.NETHER_WART, 8);

        } else if (d > 960 && d <= 990) { //3%

            return new ItemStack(Material.PIG_SPAWN_EGG, 1);

        } else if (d > 990 && d <= 1000) { //1%

            return CommunKey(1);

        }


        return CommunLoot();

    }


    public static ItemStack RareLoot(){

        Random rdm = new Random();

        int i = 0 + rdm.nextInt(1000-0);
        Double d = Double.valueOf(i);



        //SKYBLOCK


        if (d <= 60) { //6%

            return new ItemStack(Material.STONE, 32);

        } else if (d > 60 && d < 130) { //7%

            return new ItemStack(Material.OAK_LOG, 32);

        } else if (d > 130 && d < 200) { //7%

            return new ItemStack(Material.DIRT, 32);

        } else if (d > 200 && d <= 260) { //6%

            return new ItemStack(Material.GRASS_BLOCK, 16);

        } else if (d > 260 && d <= 330) { //7%

            return new ItemStack(Material.COBBLESTONE, 64);

        } else if (d > 330 && d <= 400) { //7%

            return new ItemStack(Material.SAND, 32);

        } else if (d > 400 && d <= 450) { //5%

            return new ItemStack(Material.COAL, 32);

        } else if (d > 450 && d <= 490) { //4%

            return new ItemStack(Material.REDSTONE, 32);

        } else if (d > 490 && d <= 520) { //3%

            return new ItemStack(Material.IRON_INGOT, 24);

        } else if (d > 520 && d <= 540) { //2%

            return new ItemStack(Material.GOLD_INGOT, 16);

        } else if (d > 540 && d <= 550) { //1%

            return new ItemStack(Material.DIAMOND, 8);

        } else if (d > 550 && d <= 555) { //0.5%

            return new ItemStack(Material.NETHERITE_SCRAP, 1);

        } else if (d > 555 && d <= 595) { //4%

            return new ItemStack(Material.COOKED_BEEF, 24);

        } else if (d > 595 && d <= 635) { //4%

            return new ItemStack(Material.COOKED_CHICKEN, 24);

        } else if (d > 635 && d <= 695) { //6%

            return new ItemStack(Material.BREAD, 32);

        } else if (d > 695 && d <= 755) { //6%

            return new ItemStack(Material.WHEAT_SEEDS, 32);

        } else if (d > 755 && d <= 805) { //5%

            return new ItemStack(Material.MELON_SEEDS, 16);

        } else if (d > 805 && d <= 855) { //5%

            return new ItemStack(Material.PUMPKIN_SEEDS, 16);

        } else if (d > 855 && d <= 895) { //4%

            return new ItemStack(Material.NETHER_WART, 16);

        } else if (d > 895 && d <= 935) { //4%

            return new ItemStack(Material.COW_SPAWN_EGG, 1);

        } else if (d > 935 && d <= 975) { //4%

            return new ItemStack(Material.DRAGON_HEAD, 1);

        } else if (d > 975 && d <= 990) { //1.5%

            return CommunKey(2);

        } else if (d > 990 && d <= 1000) { //0.5%

            return RareKey(1);

        }




        return RareLoot();
    }

    public static ItemStack LegLoot(){

        Random rdm = new Random();

        int i = 0 + rdm.nextInt(1000-0);
        Double d = Double.valueOf(i);


        //SKYBLOCK


        if (d <= 90) { //9%

            return new ItemStack(Material.STONE, 64);

        } else if (d > 90 && d < 200) { //11%

            return new ItemStack(Material.OAK_LOG, 64);

        } else if (d > 200 && d < 290) { //9%

            return new ItemStack(Material.GRASS_BLOCK, 64);

        } else if (d > 290 && d <= 360) { //7%

            return new ItemStack(Material.COAL, 64);

        } else if (d > 360 && d <= 430) { //7%

            return new ItemStack(Material.REDSTONE, 64);

        } else if (d > 430 && d <= 480) { //5%

            return new ItemStack(Material.IRON_INGOT, 48);

        } else if (d > 480 && d <= 520) { //4%

            return new ItemStack(Material.GOLD_INGOT, 32);

        } else if (d > 520 && d <= 550) { //3%

            return new ItemStack(Material.DIAMOND, 8);

        } else if (d > 550 && d <= 560) { //1%

            return new ItemStack(Material.NETHERITE_INGOT, 1);

        } else if (d > 560 && d <= 630) { //7%

            return new ItemStack(Material.COOKED_BEEF, 32);

        } else if (d > 630 && d <= 700) { //7%

            return new ItemStack(Material.COOKED_CHICKEN, 32);

        } else if (d > 700 && d < 790) { //9%

            return new ItemStack(Material.BREAD, 48);

        } else if (d > 790 && d <= 820) { //3%

            return new ItemStack(Material.VILLAGER_SPAWN_EGG, 1);

        } else if (d > 820 && d <= 870) { //5%

            return new ItemStack(Material.TURTLE_EGG, 1);

        } else if (d > 870 && d <= 910) { //4%

            return new ItemStack(Material.EXPERIENCE_BOTTLE, 32);

        } else if (d > 910 && d <= 930) { //2%

            return new ItemStack(Material.NETHER_STAR, 1);

        } else if (d > 930 && d <= 940) { //1%

            return new ItemStack(Material.BEACON, 1);

        } else if (d > 940 && d <= 970) { //3%

            return CommunKey(3);

        } else if (d > 970 && d <= 990) { //2%

            return RareKey(2);

        } else if (d > 990 && d <= 1000) { //1%

            return LegKey(1);

        }
        return LegLoot();
    }

    public static ItemStack CommunKey(int Amount){
        ItemStack it = new ItemStack(Material.TRIPWIRE_HOOK, Amount);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§bClé §lCOMMUNE");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("","§7Clé utilisable avec la box §b§lCOMMUNE§7 du","§7spawn en faisant §f/Spawn§7."));
        it.setItemMeta(itx);
        return it;
    }

    public static ItemStack RareKey(int Amount){
        ItemStack it = new ItemStack(Material.TRIPWIRE_HOOK, Amount);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§cClé §lRARE");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("","§7Clé utilisable avec la box §c§lRare§7 du","§7spawn en faisant §f/Spawn§7."));
        it.setItemMeta(itx);
        return it;
    }

    public static ItemStack LegKey(int Amount){
        ItemStack it = new ItemStack(Material.TRIPWIRE_HOOK, Amount);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§6Clé §lLEGENDAIRE");
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.setLore(Arrays.asList("","§7Clé utilisable avec la box §6§lLégendaire§7 du","§7spawn en faisant §f/Spawn§7."));
        it.setItemMeta(itx);
        return it;
    }

}
