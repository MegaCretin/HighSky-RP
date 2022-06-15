package fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class INVENTORY {

    public static void S_invCommun(Player p){

        Inventory inv = Bukkit.createInventory(null, 18,"§bBOX §lCOMMUNE");

        addItem(inv, inv.firstEmpty(), Material.STONE, 32,16.94,false, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.GRASS_BLOCK, 32,17.0, false, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.OAK_LOG, 32,16.5, false, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.BOOKSHELF, 8,8.0, false, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.IRON_BLOCK, 4,6.0, false, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.GOLD_BLOCK, 3,4.0, false, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.DIAMOND_BLOCK, 2,2.0, false, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.EMERALD_BLOCK, 1,1.0, false, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.COW_SPAWN_EGG, 1,1.0, false, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.PAPER, 500,7.0, true, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.PAPER, 1000,5.0, true, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.PAPER, 2500,3.0, true, false, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.BLAZE_ROD, 1,5.0, false, false, false, false, false, false, true, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.TRIPWIRE_HOOK, 4,5.0, false, true, false, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.TRIPWIRE_HOOK, 2,2.0, false, false, true, false, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.TRIPWIRE_HOOK, 1,0.5, false, false, false, true, false, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.TURTLE_HELMET, 1,0.05, false, false, false, false, true, false, false, false, "COMMUNE");
        addItem(inv, inv.firstEmpty(), Material.NETHERITE_HELMET, 1,0.01, false, false, false, false, false, true, false, false, "COMMUNE");


        p.openInventory(inv);

    }


    public static void S_invRare(Player p){

        Inventory inv = Bukkit.createInventory(null, 18,"§cBOX §lRARE");

        addItem(inv, inv.firstEmpty(), Material.STONE, 64,16.38,false, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.GRASS_BLOCK, 64,16.0, false, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.OAK_LOG, 64,17.0, false, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.IRON_BLOCK, 8,8.0, false, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.GOLD_BLOCK, 6,6.0, false, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.DIAMOND_BLOCK, 4,5.0, false, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.EMERALD_BLOCK, 2,2.0, false, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.NETHERITE_SCRAP, 1,0.5, false, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.VILLAGER_SPAWN_EGG, 1,1.5, false, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.PAPER, 5000,6.0, true, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.PAPER, 7500,5.0, true, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.PAPER, 10000,3.0, true, false, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.BLAZE_ROD, 1,6.0, false, false, false, false, false, false, true, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.TRIPWIRE_HOOK, 5,5.0, false, true, false, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.TRIPWIRE_HOOK, 3,2.0, false, false, true, false, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.TRIPWIRE_HOOK, 2,0.5, false, false, false, true, false, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.TURTLE_HELMET, 1,0.08, false, false, false, false, true, false, false, false, "RARE");
        addItem(inv, inv.firstEmpty(), Material.NETHERITE_HELMET, 1,0.04, false, false, false, false, false, true, false, false, "RARE");


        p.openInventory(inv);

    }

    public static void S_invLeg(Player p){

        Inventory inv = Bukkit.createInventory(null, 18,"§6BOX §lLEGENDAIRE");

        addItem(inv, inv.firstEmpty(), Material.GRASS_BLOCK, 64,15.0, false, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.EXPERIENCE_BOTTLE, 64,15.0, false, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.BEACON, 1,5.0, false, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.IRON_BLOCK, 16,10.0, false, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.GOLD_BLOCK, 12,8.0, false, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.DIAMOND_BLOCK, 8,6.0, false, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.EMERALD_BLOCK, 4,4.0, false, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.NETHERITE_INGOT, 1,0.5, false, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.VILLAGER_SPAWN_EGG, 2,8.5, false, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.PAPER, 10000,6.0, true, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.PAPER, 15000,5.0, true, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.PAPER, 20000,3.0, true, false, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.BLAZE_ROD, 1,6.0, false, false, false, false, false, false, true, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.TRIPWIRE_HOOK, 10,7.13, false, true, false, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.TRIPWIRE_HOOK, 4,2.2, false, false, true, false, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.TRIPWIRE_HOOK, 2,0.5, false, false, false, true, false, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.TURTLE_HELMET, 1,0.1, false, false, false, false, true, false, false, false, "LEGENDAIRE");
        addItem(inv, inv.firstEmpty(), Material.NETHERITE_HELMET, 1,0.07, false, false, false, false, false, true, false, false, "LEGENDAIRE");


        p.openInventory(inv);

    }


    public static ItemStack addItem(Inventory inv, int Slot, Material mat, int Amount, Double percent, Boolean Money, Boolean COMMUNE, Boolean RARE, Boolean LEGENDAIRE, Boolean VIP, Boolean MVP, Boolean SellStick, Boolean Fragment, String Box){
        ItemStack it = new ItemStack(mat);
        if(Amount > 64){
            it.setAmount(1);
        }else{
            it.setAmount(Amount);
        }
        ItemMeta itx = it.getItemMeta();
        if(!Money || !COMMUNE || !RARE || !LEGENDAIRE || !MVP || !VIP || !Fragment){
            String Name = "§7" + mat.toString();
            switch (Box) {
                case "COMMUNE":
                    switch (Name) {
                        case "§7DIRT":
                            itx.setDisplayName("§732 Blocs de terre");
                            break;
                        case "§7GRASS_BLOCK":
                            itx.setDisplayName("§732 Blocs d'herbe");
                            break;
                        case "§7OAK_LOG":
                            itx.setDisplayName("§732 Buches de chêne");
                            break;
                        case "§7STONE":
                            itx.setDisplayName("§732 Blocs de roche");
                            break;
                        case "§7BOOKSHELF":
                            itx.setDisplayName("§78 Bibliothèques");
                            break;
                        case "§7IRON_BLOCK":
                            itx.setDisplayName("§74 Blocs de fer");
                            break;
                        case "§7GOLD_BLOCK":
                            itx.setDisplayName("§73 Blocs d'or");
                            break;
                        case "§7DIAMOND_BLOCK":
                            itx.setDisplayName("§72 Blocs de diamant");
                            break;
                        case "§7EMERALD_BLOCK":
                            itx.setDisplayName("§71 Bloc d'emeraude");
                            break;
                        case "§7BLAZE_ROD":
                            itx.setDisplayName("§6§lSellStick §r§e(150 util)");
                            break;
                        case "§7COW_SPAWN_EGG":
                            itx.setDisplayName("§71 Oeuf de vache");
                            break;
                        default:
                            break;
                    }
                    break;
                case "RARE":
                    switch (Name) {
                        case "§7GRASS_BLOCK":
                            itx.setDisplayName("§764 Blocs d'herbe");
                            break;
                        case "§7STONE":
                            itx.setDisplayName("§764 Blocs de roche");
                            break;
                        case "§7OAK_LOG":
                            itx.setDisplayName("§764 Buches de chêne");
                            break;
                        case "§7VILLAGER_SPAWN_EGG":
                            itx.setDisplayName("§71 Oeuf de villageois");
                            break;
                        case "§7IRON_BLOCK":
                            itx.setDisplayName("§78 Blocs de fer");
                            break;
                        case "§7GOLD_BLOCK":
                            itx.setDisplayName("§76 Blocs d'or");
                            break;
                        case "§7DIAMOND_BLOCK":
                            itx.setDisplayName("§74 Blocs de diamant");
                            break;
                        case "§7EMERALD_BLOCK":
                            itx.setDisplayName("§72 Blocs d'émeraude");
                            break;
                        case "§7BLAZE_ROD":
                            itx.setDisplayName("§6§lSellStick §r§e(250 util)");
                            break;
                        case "§7NETHERITE_SCRAP":
                            itx.setDisplayName("§71 fragment de netherite");
                            break;
                        default:
                            break;
                    }
                    break;
                case "LEGENDAIRE":
                    switch (Name) {
                        case "§7GRASS_BLOCK":
                            itx.setDisplayName("§764 Blocs d'herbe");
                            break;
                        case "§7BEACON":
                            itx.setDisplayName("§71 Balise");
                            break;
                        case "§7VILLAGER_SPAWN_EGG":
                            itx.setDisplayName("§72 Oeufs de villageois");
                            break;
                        case "§7IRON_BLOCK":
                            itx.setDisplayName("§716 Blocs de fer");
                            break;
                        case "§7GOLD_BLOCK":
                            itx.setDisplayName("§712 Blocs d'or");
                            break;
                        case "§7DIAMOND_BLOCK":
                            itx.setDisplayName("§78 Blocs de diamant");
                            break;
                        case "§7EMERALD_BLOCK":
                            itx.setDisplayName("§74 Blocs d'émeraude");
                            break;
                        case "§7BLAZE_ROD":
                            itx.setDisplayName("§6§lSellStick §r§e(750 util)");
                            break;
                        case "§7NETHERITE_INGOT":
                            itx.setDisplayName("§71 lingot de netherite");
                            break;
                        case "§7EXPERIENCE_BOTTLE":
                            itx.setDisplayName("§764 bouteilles d'expérience");
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
        if(Money){
            itx.setDisplayName("§e"+Amount+"§7$");
            Amount =1;
        }
        if(COMMUNE)itx.setDisplayName("§bClé §lCOMMUNE");
        if(RARE)itx.setDisplayName("§cClé §lRARE");
        if(LEGENDAIRE)itx.setDisplayName("§6Clé §lLEGENDAIRE");
        if(VIP)itx.setDisplayName("§7Grade §eVIP");
        if(MVP)itx.setDisplayName("§7Grade §5MVP");
        if(Fragment)itx.setDisplayName("§e§lFragment");
        itx.setLore(Arrays.asList("§f§m                         ","  §f• §3Chance(s): §e"+percent+"§b%","  §f• §3Quantité(s): §e"+Amount,"§f§m                         "));
        it.setItemMeta(itx);
        inv.setItem(Slot, it);
        return it;
    }

}
