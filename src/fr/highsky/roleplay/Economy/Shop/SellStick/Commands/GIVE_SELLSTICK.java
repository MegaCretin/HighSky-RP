package fr.highsky.roleplay.Economy.Shop.SellStick.Commands;


import fr.highsky.roleplay.Economy.Shop.SellStick.Utils.STICK_ITEM;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GIVE_SELLSTICK implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player){
            Player p = (Player)sender;
            if(p.hasPermission("sellstick.give")){

                //sellstick give pseudo use mult

                if(args.length == 4){
                    if(args[0].equalsIgnoreCase("give")){
                        Player op = Bukkit.getPlayer(args[1]);
                        if(!args[1].isEmpty() && op.isOnline()){
                            if(args[2].matches("-?\\d+") && args[3].matches("^\\d+\\.\\d+")) {

                                op.getInventory().addItem(STICK_ITEM.SellStick(Double.parseDouble(args[3]), Integer.parseInt(args[2])));
                                p.sendMessage("§6§lHigh§b§lSky §7§l» §aTu as give à §e"+op.getName()+" §aun §6SellStick §ade §e"+args[2]+"§autilisations et avec un multiplicateur de §e"+args[3]+".");
                                p.sendMessage("§6§lHigh§b§lSky §7§l» §aTu as reçu un §6SellStick §ade §e"+args[2]+"§autilisations et avec un multiplicateur de §e"+args[3]+".");


                            }else p.sendMessage("§6§lHigh§b§lSky §7§l» §cL'argument §e2 §cet §e3 §cdoivent être un chiffre.");
                        }else p.sendMessage("§6§lHigh§b§lSky §7§l» §cLe joueur §e"+op.getName()+" §cn'est pas en ligne.");
                    }else p.sendMessage("§6§lHigh§b§lSky §7§l» §cUtilisation: §e/sellstick give <Pseudo> <Utilisation> <Multiplicateur>§c.");
                }else p.sendMessage("§6§lHigh§b§lSky §7§l» §cUtilisation: §e/sellstick give <Pseudo> <Utilisation> <Multiplicateur>§c.");
            }
        }

        return false;
    }
}
