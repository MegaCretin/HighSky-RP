package fr.highsky.roleplay.Events.Boxs.XPBoxs;

import fr.highsky.roleplay.Utils.INV_CREATOR;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Collections;

public class XP_BOXS_COMMANDS implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player){
            Player p = (Player)sender;

            if(args.length == 0){


                Inventory inv = INV_CREATOR.newInv(27, "§7[§6§lH§b§lS§7] §3Boxs d'expérience");
                for(int i = 0; i<27; i++){
                    ItemStack it = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                    ItemMeta itx = it.getItemMeta();
                    itx.setDisplayName("§e");
                    itx.setLore(Collections.singletonList("§e"));
                    it.setItemMeta(itx);
                    inv.setItem(i, it);
                }
                INV_CREATOR.newItem(inv, 11, Material.SUNFLOWER, 1, "§7§l» §aClé: §fXP75 §7§l«", Arrays.asList(""," §f§l→ §7Prix:§e 75 §7Niveaux d'expérience","", "§7Cliquez pour acheté cette clé."));
                INV_CREATOR.newItem(inv, 13, Material.SUNFLOWER, 1, "§7§l» §eClé: §fXP150 §7§l«", Arrays.asList(""," §f§l→ §7Prix:§e 150 §7Niveaux d'expérience","", "§7Cliquez pour acheté cette clé."));
                INV_CREATOR.newItem(inv, 15, Material.SUNFLOWER, 1, "§7§l» §6Clé: §fXP300 §7§l«", Arrays.asList(""," §f§l→ §7Prix:§e 300 §7Niveaux d'expérience","", "§7Cliquez pour acheté cette clé."));

                p.openInventory(inv);
            } else if(args.length == 4 && p.isOp()){
                if(args[0].equalsIgnoreCase("give")){
                    Player t = Bukkit.getPlayer(args[1]);
                    if(!args[1].isEmpty() && t.isOnline()){
                        if(args[3].matches("-?\\d+")) {
                            if (args[2].equalsIgnoreCase("XP75")) {
                                t.getInventory().addItem(XP_BOXS_KEY.XP75Key(Integer.parseInt(args[3])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[3]+" clé(s) §a§lXP75§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[3]+" clé(s) §a§lXP75 §aà §e"+t.getName()+"§a.");
                            } else if (args[2].equalsIgnoreCase("XP150")) {
                                t.getInventory().addItem(XP_BOXS_KEY.XP150Key(Integer.parseInt(args[3])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[3]+" clé(s) §e§lXP150§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[3]+" clé(s) §e§lXP150§a à §e"+t.getName()+"§a.");
                            } else if (args[2].equalsIgnoreCase("XP300")) {
                                t.getInventory().addItem(XP_BOXS_KEY.XP300Key(Integer.parseInt(args[3])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[3]+" clé(s) §6§lXP300§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[3]+" clé(s) §6§lXP300§a à §e"+t.getName()+"§a.");
                            }
                        }
                    }
                }
            }else if(args.length == 3 && p.isOp()){
                if(args[0].equalsIgnoreCase("giveall")){
                    for(Player t : Bukkit.getOnlinePlayers()){
                        if(args[2].matches("-?\\d+")) {
                            if (args[1].equalsIgnoreCase("XP75")) {
                                t.getInventory().addItem(XP_BOXS_KEY.XP75Key(Integer.parseInt(args[2])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[2]+" clé(s) §a§lXP75§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[2]+" clé(s) §a§lXP75 §aà §e"+t.getName()+"§a.");
                            } else if (args[1].equalsIgnoreCase("XP150")) {
                                t.getInventory().addItem(XP_BOXS_KEY.XP150Key(Integer.parseInt(args[2])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[2]+" clé(s) §e§lXP150§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[2]+" clé(s) §e§lXP150§a à §e"+t.getName()+"§a.");
                            } else if (args[1].equalsIgnoreCase("XP300")) {
                                t.getInventory().addItem(XP_BOXS_KEY.XP300Key(Integer.parseInt(args[2])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[2]+" clé(s) §6§lXP300§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[2]+" clé(s) §6§lXP300§a à §e"+t.getName()+"§a.");
                            }
                        }
                    }
                }
            }else{
                p.sendMessage("§d§lBox §8§l» §7Utilisation §e/xpbox give <PSEUDO> <TYPE> <AMOUNT>");
                p.sendMessage("§d§lBox §8§l» §7Utilisation §e/xpbox giveall <TYPE> <AMOUNT>");
            }
        }

        return false;
    }
}
