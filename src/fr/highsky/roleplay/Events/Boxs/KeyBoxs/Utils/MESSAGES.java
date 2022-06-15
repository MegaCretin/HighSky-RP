package fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils;

import org.bukkit.entity.Player;

public class MESSAGES {

    public static String winMess(Player p, String Name, String Box) {

        String name = Name;

        switch (Box) {
            case "§b§lCOMMUNE":
                switch (Name) {
                    case "§7DIRT":
                        name = "§732 Blocs de terre";
                        break;
                    case "§7GRASS_BLOCK":
                        name = "§732 Blocs d'herbe";
                        break;
                    case "§7OAK_LOG":
                        name = "§732 Buches de chêne";
                        break;
                    case "§7STONE":
                        name = "§732 Blocs de roche";
                        break;
                    case "§7ANVIL":
                        name = "§71 Enclume";
                        break;
                    case "§7BOOKSHELF":
                        name = "§78 Bibliothèques";
                        break;
                    case "§7IRON_INGOT":
                        name = "§732 Lingots de fer";
                        break;
                    case "§7GOLD_INGOT":
                        name = "§716 Lingots d'or";
                        break;
                    case "§7DIAMOND":
                        name = "§78 Diamants";
                        break;
                    case "§7EMERALD":
                        name = "§78 Emeraudes";
                        break;
                    case "§7BLAZE_ROD":
                        name = "§6§lSellStick §r§e(25 util)";
                        break;

                    default:
                        break;
                }
                break;
            case "§c§lRARE":
                switch (Name) {
                    case "§7GRASS_BLOCK":
                        name = "§764 Blocs d'herbe";
                        break;
                    case "§7STONE":
                        name = "§764 Blocs de roche";
                        break;
                    case "§7ENCHANTING_TABLE":
                        name = "§71 Table d'enchantement";
                        break;
                    case "§7VILLAGER_SPAWN_EGG":
                        name = "§71 Oeuf de villageois";
                        break;
                    case "§7IRON_BLOCK":
                        name = "§716 Blocs de fer";
                        break;
                    case "§7GOLD_BLOCK":
                        name = "§78 Blocs d'or";
                        break;
                    case "§7DIAMOND_BLOCK":
                        name = "§74 Blocs de diamant";
                        break;
                    case "§7EMERALD_BLOCK":
                        name = "§71 Blocs d'émeraude";
                        break;
                    case "§7BLAZE_ROD":
                        name = "§6§lSellStick §r§e(75 util)";
                        break;

                    default:
                        break;
                }
                break;
            case "§6§lLEGENDAIRE":
                switch (Name) {
                    case "§7GRASS_BLOCK":
                        name = "§764 Blocs d'herbe";
                        break;
                    case "§7BEACON":
                        name = "§71 Balise";
                        break;
                    case "§7VILLAGER_SPAWN_EGG":
                        name = "§72 Oeufs de villageois";
                        break;
                    case "§7IRON_BLOCK":
                        name = "§732 Blocs de fer";
                        break;
                    case "§7GOLD_BLOCK":
                        name = "§724 Blocs d'or";
                        break;
                    case "§7DIAMOND_BLOCK":
                        name = "§716 Blocs de diamant";
                        break;
                    case "§7EMERALD_BLOCK":
                        name = "§78 Blocs d'émeraude";
                        break;
                    case "§7BLAZE_ROD":
                        name = "§6§lSellStick §r§e(500 util)";
                        break;
                    case "§7IRON_NUGGET":
                        name = "§6§l2 Fragments";
                        break;
                    default:
                        break;
                }
                break;
        }
        return "§d§lBOX §8§l» §E" + p.getName() + " §aa gagné " + name + "§a dans la box§e " + Box + "§a.";

    }
}