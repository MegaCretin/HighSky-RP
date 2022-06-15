package fr.highsky.roleplay.Events.Boxs.XPBoxs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class XP_BOXS_INVENTORY {

    public static Inventory XP75_Inventory(){
        Inventory inv = Bukkit.createInventory(null, 27, "§a§lBOX §3§lXP75");
        addItem(inv, 0, Material.GRASS_BLOCK, 8, 12.00, false, false, false, false, "XP75");
        addItem(inv, 1, Material.DIRT, 16, 12.00, false, false, false, false, "XP75");
        addItem(inv, 2, Material.STONE, 16, 12.00, false, false, false, false, "XP75");
        addItem(inv, 3, Material.OAK_LOG, 16, 12.00, false, false, false, false, "XP75");
        addItem(inv, 4, Material.COBBLESTONE, 32, 12.00, false, false, false, false, "XP75");
        addItem(inv, 5, Material.IRON_INGOT, 16, 5.00, false, false, false, false, "XP75");
        addItem(inv, 6, Material.GOLD_INGOT, 8, 4.00, false, false, false, false, "XP75");
        addItem(inv, 7, Material.DIAMOND, 4, 3.00, false, false, false, false, "XP75");
        addItem(inv, 8, Material.ENDER_CHEST, 1, 1.00, false, false, false, false, "XP75");
        addItem(inv, 9, Material.TURTLE_EGG, 1, 1.00, false, false, false, false, "XP75");
        addItem(inv, 10, Material.PAPER, 250, 6.00, true, false, false, false, "XP75");
        addItem(inv, 11, Material.PAPER, 500, 5.00, true, false, false, false, "XP75");
        addItem(inv, 12, Material.PAPER, 100, 4.00, true, false, false, false, "XP75");
        addItem(inv, 13, Material.EXPERIENCE_BOTTLE, 16, 5.00, false, false, false, false, "XP75");
        addItem(inv, 14, Material.SHEEP_SPAWN_EGG, 1, 5.00, false, false, false, false, "XP75");
        addItem(inv, 15, Material.TRIPWIRE_HOOK, 1, 1.00, false, true, false, false, "XP75");
        return inv;
    }

    public static Inventory XP150_Inventory(){
        Inventory inv = Bukkit.createInventory(null, 27, "§a§lBOX §3§lXP150");
        addItem(inv, 0, Material.GRASS_BLOCK, 16, 12.00, false, false, false, false, "XP150");
        addItem(inv, 1, Material.DIRT, 32, 12.00, false, false, false, false, "XP150");
        addItem(inv, 2, Material.STONE, 32, 12.00, false, false, false, false, "XP150");
        addItem(inv, 3, Material.OAK_LOG, 32, 12.00, false, false, false, false, "XP150");
        addItem(inv, 4, Material.COBBLESTONE, 64, 12.00, false, false, false, false, "XP150");
        addItem(inv, 5, Material.IRON_INGOT, 32, 5.00, false, false, false, false, "XP150");
        addItem(inv, 6, Material.GOLD_INGOT, 16, 4.00, false, false, false, false, "XP150");
        addItem(inv, 7, Material.DIAMOND, 8, 3.00, false, false, false, false, "XP150");
        addItem(inv, 8, Material.NETHERITE_SCRAP, 1, 0.50, false, false, false, false, "XP150");
        addItem(inv, 9, Material.ENCHANTING_TABLE, 1, 1.00, false, false, false, false, "XP150");
        addItem(inv, 10, Material.PAPER, 500, 6.00, true, false, false, false, "XP150");
        addItem(inv, 11, Material.PAPER, 1000, 5.00, true, false, false, false, "XP150");
        addItem(inv, 12, Material.PAPER, 2000, 4.00, true, false, false, false, "XP150");
        addItem(inv, 13, Material.EXPERIENCE_BOTTLE, 32, 6.00, false, false, false, false, "XP150");
        addItem(inv, 14, Material.COW_SPAWN_EGG, 1, 5.00, false, false, false, false, "XP150");
        addItem(inv, 15, Material.TRIPWIRE_HOOK, 1, 0.50, false, false, true, false, "XP150");
        return inv;
    }

    public static Inventory XP300_Inventory(){
        Inventory inv = Bukkit.createInventory(null, 27, "§a§lBOX §3§lXP300");
        addItem(inv, 0, Material.GRASS_BLOCK, 32, 13.00, false, false, false, false, "XP300");
        addItem(inv, 1, Material.DIRT, 64,13.00, false, false, false, false, "XP300");
        addItem(inv, 2, Material.STONE, 64, 13.00, false, false, false, false, "XP300");
        addItem(inv, 3, Material.OAK_LOG, 64, 13.00, false, false, false, false, "XP300");
        addItem(inv, 4, Material.IRON_INGOT, 64, 6.00, false, false, false, false, "XP300");
        addItem(inv, 5, Material.GOLD_INGOT, 32, 5.00, false, false, false, false, "XP300");
        addItem(inv, 6, Material.DIAMOND, 16, 4.00, false, false, false, false, "XP300");
        addItem(inv, 7, Material.NETHERITE_SCRAP, 2, 1.00, false, false, false, false, "XP300");
        addItem(inv, 8, Material.BEACON, 1, 1.00, false, false, false, false, "XP300");
        addItem(inv, 9, Material.PAPER, 2500, 7.00, true, false, false, false, "XP300");
        addItem(inv, 10, Material.PAPER, 5000, 6.00, true, false, false, false, "XP300");
        addItem(inv, 11, Material.PAPER, 7500, 5.00, true, false, false, false, "XP300");
        addItem(inv, 12, Material.EXPERIENCE_BOTTLE, 64, 7.00, false, false, false, false, "XP300");
        addItem(inv, 13, Material.VILLAGER_SPAWN_EGG, 1, 5.00, false, false, false, false, "XP300");
        addItem(inv, 14, Material.TRIPWIRE_HOOK, 1, 1.00, false, false, false, true, "XP300");
        return inv;
    }


    public static ItemStack addItem(Inventory inv, int Slot, Material mat, int Amount, Double percent, Boolean Money, Boolean COMMUNE, Boolean RARE, Boolean LEGENDAIRE, String Box){
        ItemStack it = new ItemStack(mat);
        if(Amount > 64){
            it.setAmount(1);
        }else{
            it.setAmount(Amount);
        }
        ItemMeta itx = it.getItemMeta();
        if(!Money || !COMMUNE || !RARE || !LEGENDAIRE){
            String Name = "§7" + mat.toString();
            switch (Box) {
                case "XP75":
                    switch (Name) {
                        case "§7COBBLESTONE":
                            itx.setDisplayName("§732 Pierre");
                            break;
                        case "§7DIRT":
                            itx.setDisplayName("§716 Blocs de terre");
                            break;
                        case "§7GRASS_BLOCK":
                            itx.setDisplayName("§78 Blocs d'herbe");
                            break;
                        case "§7OAK_LOG":
                            itx.setDisplayName("§716 Buches de chêne");
                            break;
                        case "§7STONE":
                            itx.setDisplayName("§716 Blocs de roche");
                            break;
                        case "§7IRON_INGOT":
                            itx.setDisplayName("§716 Lingots de fer");
                            break;
                        case "§7GOLD_INGOT":
                            itx.setDisplayName("§78 Lingots d'or");
                            break;
                        case "§7DIAMOND":
                            itx.setDisplayName("§74 Diamants");
                            break;
                        case "§7ENDER_CHEST":
                            itx.setDisplayName("§7Coffre de l'end");
                            break;
                        case "§7EXPERIENCE_BOTTLE":
                            itx.setDisplayName("§716 Bouteilles d'expérience");
                            break;
                        case "§7SHEEP_SPAWN_EGG":
                            itx.setDisplayName("§7Oeuf de mouton");
                            break;
                        case "§7TURTLE_EGG":
                            itx.setDisplayName("§7Oeuf de tortue");
                            break;
                        default:
                            break;
                    }
                    break;
                case "XP150":
                    switch (Name) {
                        case "§7COBBLESTONE":
                            itx.setDisplayName("§764 Pierre");
                            break;
                        case "§7DIRT":
                            itx.setDisplayName("§732 Blocs de terre");
                            break;
                        case "§7GRASS_BLOCK":
                            itx.setDisplayName("§716 Blocs d'herbe");
                            break;
                        case "§7OAK_LOG":
                            itx.setDisplayName("§732 Buches de chêne");
                            break;
                        case "§7STONE":
                            itx.setDisplayName("§732 Blocs de roche");
                            break;
                        case "§7ENCHANTING_TABLE":
                            itx.setDisplayName("§71 Table d'enchantement");
                            break;
                        case "§7VILLAGER_SPAWN_EGG":
                            itx.setDisplayName("§71 Oeuf de villageois");
                            break;
                        case "§7IRON_INGOT":
                            itx.setDisplayName("§732 Lingots de fer");
                            break;
                        case "§7GOLD_INGOT":
                            itx.setDisplayName("§716 Lingots d'or");
                            break;
                        case "§7DIAMOND":
                            itx.setDisplayName("§78 Diamants");
                            break;
                        case "§7BLAZE_ROD":
                            itx.setDisplayName("§6§lSellStick §r§e(75 util)");
                            break;
                        case "§7EXPERIENCE_BOTTLE":
                            itx.setDisplayName("§732 Bouteilles d'expérience");
                            break;
                        case "§7NETHERITE_SCRAP":
                            itx.setDisplayName("§7Fragment de netherite");
                            break;
                        case "§7COW_SPAWN_EGG":
                            itx.setDisplayName("§7Oeuf de vache");
                            break;
                        default:
                            break;
                    }
                    break;
                case "XP300":
                    switch (Name) {
                        case "§7DIRT":
                            itx.setDisplayName("§764 Blocs de terre");
                            break;
                        case "§7GRASS_BLOCK":
                            itx.setDisplayName("§732 Blocs d'herbe");
                            break;
                        case "§7OAK_LOG":
                            itx.setDisplayName("§764 Buches de chêne");
                            break;
                        case "§7STONE":
                            itx.setDisplayName("§764 Blocs de roche");
                            break;
                        case "§7BEACON":
                            itx.setDisplayName("§71 Balise");
                            break;
                        case "§7VILLAGER_SPAWN_EGG":
                            itx.setDisplayName("§71 Oeuf de villageoi");
                            break;
                        case "§7IRON_INGOT":
                            itx.setDisplayName("§764 Lingots de fer");
                            break;
                        case "§7GOLD_INGOT":
                            itx.setDisplayName("§732 Lingots d'or");
                            break;
                        case "§7DIAMOND":
                            itx.setDisplayName("§716 Diamants");
                            break;
                        case "§7BLAZE_ROD":
                            itx.setDisplayName("§6§lSellStick §r§e(500 util)");
                            break;
                        case "§7EXPERIENCE_BOTTLE":
                            itx.setDisplayName("§f64 Bouteilles d'expérience");
                            break;
                        case "§7NETHERITE_SCRAP":
                            itx.setDisplayName("§72 Fragments de netherite");
                            break;
                        default:
                            break;
                    }
                    break;
            }
        }
        if(Money)itx.setDisplayName("§e"+Amount+"§7$");
        if(COMMUNE)itx.setDisplayName("§bClé §lCOMMUNE");
        if(RARE)itx.setDisplayName("§cClé §lRARE");
        if(LEGENDAIRE)itx.setDisplayName("§6Clé §lLEGENDAIRE");
        itx.setLore(Arrays.asList("§f§m                         ","  §f• §3Chance(s): §e"+percent+"§b%","  §f• §3Quantité(s): §e"+Amount,"§f§m                         "));
        it.setItemMeta(itx);
        inv.setItem(Slot, it);
        return it;
    }


}
