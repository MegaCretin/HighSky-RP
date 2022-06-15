package fr.highsky.roleplay.Events.LootsBoxs;

import fr.highsky.roleplay.Events.LootsBoxs.Utils.LootsBoxs;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GiveCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(args.length == 4) {
            if ((sender instanceof Player && sender.isOp()) || !(sender instanceof Player)) {
                if(args[0].equals("give")){
                    if(args[1].equalsIgnoreCase("commune")){
                        if(!args[2].isEmpty()){
                            if(args[3].matches("-?\\d+")){
                                Bukkit.getPlayer(args[2]).getInventory().addItem(LootsBoxs.CommunBox(Integer.parseInt(args[3])));
                            }
                        }
                    }else if(args[1].equalsIgnoreCase("rare")){
                        if(!args[2].isEmpty()){
                            if(args[3].matches("-?\\d+")){
                                Bukkit.getPlayer(args[2]).getInventory().addItem(LootsBoxs.RareBox(Integer.parseInt(args[3])));
                            }
                        }
                    }else{
                        if(args[1].equalsIgnoreCase("legendaire")){
                            if(!args[2].isEmpty()){
                                if(args[3].matches("-?\\d+")){
                                    Bukkit.getPlayer(args[2]).getInventory().addItem(LootsBoxs.LegBox(Integer.parseInt(args[3])));
                                }
                            }
                        }
                    }
                }
            }
        }else if(args.length == 3){
            if (args[0].equalsIgnoreCase("giveall")) {
                if(args[1].equalsIgnoreCase("commune")){

                    if(args[2].matches("-?\\d+")){
                        for(Player p : Bukkit.getOnlinePlayers()){
                            p.getInventory().addItem(LootsBoxs.CommunBox(Integer.parseInt(args[2])));
                        }
                    }
                }else if(args[1].equalsIgnoreCase("rare")){
                    if(args[2].matches("-?\\d+")){
                        for(Player p : Bukkit.getOnlinePlayers()){
                            p.getInventory().addItem(LootsBoxs.RareBox(Integer.parseInt(args[2])));
                        }
                    }
                }else{
                    if(args[1].equalsIgnoreCase("legendaire")){
                        if(args[2].matches("-?\\d+")){
                            for(Player p : Bukkit.getOnlinePlayers()){
                                p.getInventory().addItem(LootsBoxs.LegBox(Integer.parseInt(args[2])));
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
