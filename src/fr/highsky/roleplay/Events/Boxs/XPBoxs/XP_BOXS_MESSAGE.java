package fr.highsky.roleplay.Events.Boxs.XPBoxs;

import org.bukkit.entity.Player;

public class XP_BOXS_MESSAGE {

    public static String winMess(Player p, String Name, String Box) {

        String name = Name;

        switch (Box) {
            case "XP75":
                switch (Name) {
                    case "§7COBBLESTONE":
                        name = "§732 Pierres";
                        break;
                    case "§7DIRT":
                        name = "§716 Blocs de terre";
                        break;
                    case "§7GRASS_BLOCK":
                        name = "§78 Blocs d'herbe";
                        break;
                    case "§7OAK_LOG":
                        name = "§732 Buches de chêne";
                        break;
                    case "§7STONE":
                        name = "§716 Blocs de roche";
                        break;
                    case "§7IRON_INGOT":
                        name = "§716 Lingots de fer";
                        break;
                    case "§7GOLD_INGOT":
                        name = "§78 Lingots d'or";
                        break;
                    case "§7DIAMOND":
                        name = "§74 Diamants";
                        break;
                    case "§7ENDER_CHEST":
                        name = "§7Coffre de l'end";
                        break;
                    case "§7EXPERIENCE_BOTTLE":
                        name = "§716 Bouteilles d'expérience";
                        break;
                    case "§7SHEEP_SPAWN_EGG":
                        name = "§7Oeuf de mouton";
                        break;
                    case "§7TURTLE_EGG":
                        name = "§7Oeuf de tortue";
                        break;
                    default:
                        break;
                }
                break;
            case "XP150":
                switch (Name) {
                    case "§7COBBLESTONE":
                        name = "§764 Pierre";
                        break;
                    case "§7DIRT":
                        name = "§732 Blocs de terre";
                        break;
                    case "§7GRASS_BLOCK":
                        name = "§716 Blocs d'herbe";
                        break;
                    case "§7OAK_LOG":
                        name = "§732 Buches de chêne";
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
                    case "§7IRON_INGOT":
                        name = "§732 Lingots de fer";
                        break;
                    case "§7GOLD_INGOT":
                        name = "§716 Lingots d'or";
                        break;
                    case "§7DIAMOND":
                        name = "§78 Diamants";
                        break;
                    case "§7BLAZE_ROD":
                        name = "§6§lSellStick §r§e(75 util)";
                        break;
                    case "§7EXPERIENCE_BOTTLE":
                        name = "§732 Bouteilles d'expérience";
                        break;
                    case "§7NETHERITE_SCRAP":
                        name = "§7Fragment de netherite";
                        break;
                    case "§7COW_SPAWN_EGG":
                        name = "§7Oeuf de vache";
                        break;
                    default:
                        break;
                }
                break;
            case "XP300":
                switch (Name) {
                    case "§7DIRT":
                        name = "§764 Blocs de terre";
                        break;
                    case "§7GRASS_BLOCK":
                        name = "§732 Blocs d'herbe";
                        break;
                    case "§7OAK_LOG":
                        name = "§764 Buches de chêne";
                        break;
                    case "§7STONE":
                        name = "§764 Blocs de roche";
                        break;
                    case "§7BEACON":
                        name = "§71 Balise";
                        break;
                    case "§7VILLAGER_SPAWN_EGG":
                        name = "§71 Oeuf de villageoi";
                        break;
                    case "§7IRON_INGOT":
                        name = "§764 Lingots de fer";
                        break;
                    case "§7GOLD_INGOT":
                        name = "§732 Lingots d'or";
                        break;
                    case "§7DIAMOND":
                        name = "§716 Diamants";
                        break;
                    case "§7BLAZE_ROD":
                        name = "§6§lSellStick §r§e(500 util)";
                        break;
                    case "§7EXPERIENCE_BOTTLE":
                        name = "§f64 Bouteilles d'expérience";
                        break;
                    case "§7NETHERITE_SCRAP":
                        name = "§7Fragment de netherite";
                        break;
                    default:
                        break;
                }
                break;
        }
        return "§d§lBOX §8§l» §E" + p.getName() + " §aa gagné " + name + "§a dans la box§e " + Box + "§a.";

    }

}
