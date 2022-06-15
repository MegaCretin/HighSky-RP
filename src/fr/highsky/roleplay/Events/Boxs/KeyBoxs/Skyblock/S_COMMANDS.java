package fr.highsky.roleplay.Events.Boxs.KeyBoxs.Skyblock;


import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils.KEY;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class S_COMMANDS implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;

            if(args.length == 4){
                if(args[0].equalsIgnoreCase("give")){
                    Player t = Bukkit.getPlayer(args[1]);
                    if(!args[1].isEmpty() && t.isOnline()){
                        if(args[3].matches("-?\\d+")) {
                            if (args[2].equalsIgnoreCase("Commune")) {
                                t.getInventory().addItem(KEY.CommunKey(Integer.parseInt(args[3])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[3]+" clé(s) §b§lCOMMUNE(S)§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[3]+" clé(s) §b§lCOMMUNE(S)§a à §e"+t.getName()+"§a.");
                            } else if (args[2].equalsIgnoreCase("Rare")) {
                                t.getInventory().addItem(KEY.RareKey(Integer.parseInt(args[3])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[3]+" clé(s) §c§lRARE(S)§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[3]+" clé(s) §c§lRARE(S)§a à §e"+t.getName()+"§a.");
                            } else if (args[2].equalsIgnoreCase("Leg")) {
                                t.getInventory().addItem(KEY.LegKey(Integer.parseInt(args[3])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[3]+" clé(s) §6§lLEGENDAIRE(S)§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[3]+" clé(s) §6§lLEGENDAIRE(S)§a à §e"+t.getName()+"§a.");
                            }
                        }
                    }
                }
            }else if(args.length == 3){
                if(args[0].equalsIgnoreCase("giveall")){
                    for(Player t : Bukkit.getOnlinePlayers()){
                        if(args[2].matches("-?\\d+")) {
                            if (args[1].equalsIgnoreCase("Commune")) {
                                t.getInventory().addItem(KEY.CommunKey(Integer.parseInt(args[2])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[2]+" clé(s) §b§lCOMMUNE(S)§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[2]+" clé(s) §b§lCOMMUNE(S)§a à §eALL§a.");
                            } else if (args[1].equalsIgnoreCase("Rare")) {
                                t.getInventory().addItem(KEY.RareKey(Integer.parseInt(args[2])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[2]+" clé(s) §c§lRARE(S)§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[2]+" clé(s) §c§lRARE(S)§a à §eALL§a.");
                            } else if (args[1].equalsIgnoreCase("Leg")) {
                                t.getInventory().addItem(KEY.LegKey(Integer.parseInt(args[2])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[2]+" clé(s) §6§lLEGENDAIRE(S)§a.");
                                p.sendMessage("§d§lBox §8§l» §aVous avez envoyé §e"+args[2]+" clé(s) §6§lLEGENDAIRE(S)§a à §eALL§a.");
                            }
                        }
                    }
                }
            }else{
                p.sendMessage("§d§lBox §8§l» §7Utilisation §e/box give <PSEUDO> <TYPE> <AMOUNT>");
                p.sendMessage("§d§lBox §8§l» §7Utilisation §e/box giveall <TYPE> <AMOUNT>");
            }

        }else{
            if(args.length == 4){
                if(args[0].equalsIgnoreCase("give")){
                    Player t = Bukkit.getPlayer(args[1]);
                    if(!args[1].isEmpty() && t.isOnline()){
                        if(args[3].matches("-?\\d+")) {
                            if (args[2].equalsIgnoreCase("Commune")) {
                                t.getInventory().addItem(KEY.CommunKey(Integer.parseInt(args[3])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[3]+" clé(s) §b§lCOMMUNE(S)§a.");
                                System.out.println("§d§lBox §8§l» §aVous avez envoyé §e"+args[3]+" clé(s) §b§lCOMMUNE(S)§a à §e"+t.getName()+"§a.");
                            } else if (args[2].equalsIgnoreCase("Rare")) {
                                t.getInventory().addItem(KEY.RareKey(Integer.parseInt(args[3])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[3]+" clé(s) §c§lRARE(S)§a.");
                                System.out.println("§d§lBox §8§l» §aVous avez envoyé §e"+args[3]+" clé(s) §c§lRARE(S)§a à §e"+t.getName()+"§a.");
                            } else if (args[2].equalsIgnoreCase("Leg")) {
                                t.getInventory().addItem(KEY.LegKey(Integer.parseInt(args[3])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[3]+" clé(s) §6§lLEGENDAIRE(S)§a.");
                                System.out.println("§d§lBox §8§l» §aVous avez envoyé §e"+args[3]+" clé(s) §6§lLEGENDAIRE(S)§a à §e"+t.getName()+"§a.");
                            }
                        }
                    }
                }
            }else if(args.length == 3){
                if(args[0].equalsIgnoreCase("giveall")){
                    for(Player t : Bukkit.getOnlinePlayers()){
                        if(args[2].matches("-?\\d+")) {
                            if (args[1].equalsIgnoreCase("Commune")) {
                                t.getInventory().addItem(KEY.CommunKey(Integer.parseInt(args[2])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[2]+" clé(s) §b§lCOMMUNE(S)§a.");
                                System.out.println("§d§lBox §8§l» §aVous avez envoyé §e"+args[2]+" clé(s) §b§lCOMMUNE(S)§a à §eALL§a.");
                            } else if (args[1].equalsIgnoreCase("Rare")) {
                                t.getInventory().addItem(KEY.RareKey(Integer.parseInt(args[2])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[2]+" clé(s) §c§lRARE(S)§a.");
                                System.out.println("§d§lBox §8§l» §aVous avez envoyé §e"+args[2]+" clé(s) §c§lRARE(S)§a à §eALL§a.");
                            } else if (args[1].equalsIgnoreCase("Leg")) {
                                t.getInventory().addItem(KEY.LegKey(Integer.parseInt(args[2])));
                                t.sendMessage("§d§lBox §8§l» §aVous avez reçu §e"+args[2]+" clé(s) §6§lLEGENDAIRE(S)§a.");
                                System.out.println("§d§lBox §8§l» §aVous avez envoyé §e"+args[2]+" clé(s) §6§lLEGENDAIRE(S)§a à §eALL§a.");
                            }
                        }
                    }
                }
            }else{
                System.out.println("§d§lBox §8§l» §7Utilisation §e/box give <PSEUDO> <TYPE> <AMOUNT>");
                System.out.println("§d§lBox §8§l» §7Utilisation §e/box giveall <TYPE> <AMOUNT>");
            }
        }

        return false;
    }
}