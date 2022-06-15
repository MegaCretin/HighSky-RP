package fr.highsky.roleplay.Other.Furnace;

import fr.highsky.roleplay.Utils.INV_CREATOR;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.*;

public class FURNACE implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 1){
                if(p.hasPermission("furnace.use")) {

                    Map<Material, Material> mat = new HashMap<>();
                    mat.put(Material.COAL_ORE, Material.COAL);
                    mat.put(Material.IRON_ORE, Material.IRON_INGOT);
                    mat.put(Material.GOLD_ORE, Material.GOLD_INGOT);
                    mat.put(Material.REDSTONE_ORE, Material.REDSTONE);
                    mat.put(Material.LAPIS_ORE, Material.LAPIS_LAZULI);
                    mat.put(Material.DIAMOND_ORE, Material.DIAMOND);
                    mat.put(Material.EMERALD_ORE, Material.EMERALD);
                    mat.put(Material.ANCIENT_DEBRIS, Material.NETHERITE_SCRAP);
                    mat.put(Material.NETHER_QUARTZ_ORE, Material.QUARTZ);
                    mat.put(Material.NETHER_GOLD_ORE, Material.GOLD_INGOT);

                    if (args[0].equalsIgnoreCase("hand")) {
                        if(p.hasPermission("furnace.hand")) {
                            if (p.getInventory().getItemInMainHand() != null && mat.containsKey(p.getInventory().getItemInMainHand().getType())) {

                                Inventory inv = INV_CREATOR.newInv(27, "§a§lFour §7[§3Main§7]");

                                for(int i=0; i<27;i++){
                                    INV_CREATOR.newItem(inv, i, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§e",Arrays.asList("§e"));
                                }

                                int coal = 0;
                                int iron = 0;
                                int gold = 0;
                                int redstone = 0;
                                int lapis = 0;
                                int diamond = 0;
                                int emerald = 0;
                                int netherite = 0;
                                int quartz = 0;
                                int nether_gold = 0;

                                if(p.getInventory().getItemInMainHand().getType() == Material.COAL_ORE)coal = p.getInventory().getItemInMainHand().getAmount();
                                if(p.getInventory().getItemInMainHand().getType() == Material.IRON_ORE)iron = p.getInventory().getItemInMainHand().getAmount();
                                if(p.getInventory().getItemInMainHand().getType() == Material.GOLD_ORE)gold = p.getInventory().getItemInMainHand().getAmount();
                                if(p.getInventory().getItemInMainHand().getType() == Material.REDSTONE_ORE)redstone = p.getInventory().getItemInMainHand().getAmount();
                                if(p.getInventory().getItemInMainHand().getType() == Material.LAPIS_ORE)lapis = p.getInventory().getItemInMainHand().getAmount();
                                if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND_ORE)diamond = p.getInventory().getItemInMainHand().getAmount();
                                if(p.getInventory().getItemInMainHand().getType() == Material.EMERALD_ORE)emerald = p.getInventory().getItemInMainHand().getAmount();
                                if(p.getInventory().getItemInMainHand().getType() == Material.ANCIENT_DEBRIS)netherite = p.getInventory().getItemInMainHand().getAmount();
                                if(p.getInventory().getItemInMainHand().getType() == Material.NETHER_QUARTZ_ORE)quartz = p.getInventory().getItemInMainHand().getAmount();
                                if(p.getInventory().getItemInMainHand().getType() == Material.NETHER_GOLD_ORE)nether_gold = p.getInventory().getItemInMainHand().getAmount();

                                INV_CREATOR.newItem(inv, 11, Material.LIME_STAINED_GLASS_PANE, 1,"§aCONFIRMÉ", Arrays.asList("",
                                        "§7Minerais de charbon: §e"+coal,
                                        "§7Minerais de fer: §e"+iron,
                                        "§7Minerais d'or: §e"+gold,
                                        "§7Minerais de redstone: §e"+redstone,
                                        "§7Minerais de Lapis: §e"+lapis,
                                        "§7Minerais de diamant: §e"+diamond,
                                        "§7Minerais d'emeraude: §e"+emerald,
                                        "§7Ancient debris: §e"+netherite,
                                        "§7Minerais de quartz: §e"+quartz,
                                        "§7Minerais d'or du nether: §e"+nether_gold,
                                        "","§fPrix: §35 Niveaux d'éxpériences","",
                                        "§7Cliquez pour acheté."));

                                INV_CREATOR.newItem(inv, 15, Material.RED_STAINED_GLASS_PANE, 1,"§cANNULÉ", Arrays.asList("","§7Cliquez pour annulé."));

                                p.openInventory(inv);

                            }
                        }else p.sendMessage("§6§lH§b§lS §8§l» §cVous n'avez pas cette permission.");
                    } else if (args[0].equalsIgnoreCase("all")) {
                        if(p.hasPermission("furnace.all")) {

                            Inventory inv = INV_CREATOR.newInv(27, "§a§lFour §7[§3Tous§7]");

                            for(int i=0; i<27;i++){
                                INV_CREATOR.newItem(inv, i, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§e",Arrays.asList("§e"));
                            }

                            int coal = 0;
                            int iron = 0;
                            int gold = 0;
                            int redstone = 0;
                            int lapis = 0;
                            int diamond = 0;
                            int emerald = 0;
                            int netherite = 0;
                            int quartz = 0;
                            int nether_gold = 0;

                            for (int i = 0; i < 36; i++) {
                                if (p.getInventory().getItem(i) != null && mat.containsKey(p.getInventory().getItem(i).getType())) {
                                    if(p.getInventory().getItem(i).getType() == Material.COAL_ORE)coal = coal + p.getInventory().getItem(i).getAmount();
                                    if(p.getInventory().getItem(i).getType() == Material.IRON_ORE)iron = iron + p.getInventory().getItem(i).getAmount();
                                    if(p.getInventory().getItem(i).getType() == Material.GOLD_ORE)gold = gold + p.getInventory().getItem(i).getAmount();
                                    if(p.getInventory().getItem(i).getType() == Material.REDSTONE_ORE)redstone = redstone + p.getInventory().getItem(i).getAmount();
                                    if(p.getInventory().getItem(i).getType() == Material.LAPIS_ORE)lapis = lapis + p.getInventory().getItem(i).getAmount();
                                    if(p.getInventory().getItem(i).getType() == Material.DIAMOND_ORE)diamond = diamond + p.getInventory().getItem(i).getAmount();
                                    if(p.getInventory().getItem(i).getType() == Material.EMERALD_ORE)emerald = emerald + p.getInventory().getItem(i).getAmount();
                                    if(p.getInventory().getItem(i).getType() == Material.ANCIENT_DEBRIS)netherite = netherite + p.getInventory().getItem(i).getAmount();
                                    if(p.getInventory().getItem(i).getType() == Material.NETHER_QUARTZ_ORE)quartz = quartz + p.getInventory().getItem(i).getAmount();
                                    if(p.getInventory().getItem(i).getType() == Material.NETHER_GOLD_ORE)nether_gold = nether_gold + p.getInventory().getItem(i).getAmount();
                                }
                            }

                            INV_CREATOR.newItem(inv, 11, Material.LIME_STAINED_GLASS_PANE, 1,"§aCONFIRMÉ", Arrays.asList("",
                                    "§7Minerais de charbon: §e"+coal,
                                    "§7Minerais de fer: §e"+iron,
                                    "§7Minerais d'or: §e"+gold,
                                    "§7Minerais de redstone: §e"+redstone,
                                    "§7Minerais de Lapis: §e"+lapis,
                                    "§7Minerais de diamant: §e"+diamond,
                                    "§7Minerais d'emeraude: §e"+emerald,
                                    "§7Ancient debris: §e"+netherite,
                                    "§7Minerais de quartz: §e"+quartz,
                                    "§7Minerais d'or du nether: §e"+nether_gold,
                                    "","§fPrix: §310e Niveaux d'éxpériences","",
                                    "§7Cliquez pour acheté."));

                            INV_CREATOR.newItem(inv, 15, Material.RED_STAINED_GLASS_PANE, 1,"§cANNULÉ", Arrays.asList("","§7Cliquez pour annulé."));

                            p.openInventory(inv);

                        }else p.sendMessage("§6§lH§b§lS §8§l» §cVous n'avez pas cette permission.");
                    }
                }else p.sendMessage("§6§lH§b§lS §8§l» §cVous n'avez pas cette permission.");
            }
        }

        return false;
    }
}
