package fr.highsky.roleplay.Economy.Shop.Commands;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Economy.Shop.Utils.ShopTools;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class SellCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        Player p = (Player)sender;
        if(args.length == 1){
            if(args[0].equalsIgnoreCase("hand")){
                if(p.hasPermission("sellhand.use")){
                    int Amount = 0;
                    Double Price = 0.00;
                    if(p.getInventory().getItemInMainHand().getType() != null){
                        Price = Price + ShopTools.checkSellPrice(p.getInventory().getItemInMainHand());
                        if(ShopTools.checkSellPrice(p.getInventory().getItemInMainHand()) != 0.00){
                            Amount += p.getInventory().getItemInMainHand().getAmount();
                            p.getInventory().setItemInMainHand(null);
                            if(Amount != 0){
                                MoneyAPI.giveMoney(p, Price);
                                p.sendMessage("§6§lHigh§b§lSky §7§l» §aVous avez vendu §e"+Amount+"§a items pour §e"+Price+"$§a.");
                            }else p.sendMessage("§6§lHigh§b§lSky §7§l» §cVous n'avez aucun item à vendre.");
                        }else p.sendMessage("§6§lHigh§b§lSky §7§l» §cCet item ne se vend pas.");
                    }else p.sendMessage("§6§lHigh§b§lSky §7§l» §cVous n'avez rien à vendre.");
                }else{
                    p.sendMessage("§6§lHigh§b§lSky §7§l» §cVous n'avez pas la permission.");
                }
            }else if(args[0].equalsIgnoreCase("all")){
                if(p.hasPermission("sellall.use")){
                    int Amount = 0;
                    Double Price = 0.00;
                    for(int i=0;i<36;i++){
                        if(p.getInventory().getItem(i) != null) {
                            ItemStack it = p.getInventory().getItem(i);
                            Price = Price + ShopTools.checkSellPrice(it);
                            if (ShopTools.checkSellPrice(it) != 0.00) {
                                Amount += p.getInventory().getItem(i).getAmount();
                                p.getInventory().setItem(i, null);
                            }
                        }
                    }
                    if(Price != 0.00){
                         MoneyAPI.giveMoney(p, Price);
                         p.sendMessage("§6§lHigh§b§lSky §7§l» §aVous avez vendu §e"+Amount+"§a items pour §e"+Price+"$§a.");
                    }else p.sendMessage("§6§lHigh§b§lSky §7§l» §cVous n'avez rien à vendre.");
                }else{
                    p.sendMessage("§6§lHigh§b§lSky §7§l» §cVous n'avez pas la permission.");
                }
            }
        }else p.sendMessage("§6§lHigh§b§lSky §7§l» §cUtilisation: §e/sell <all/hand>");
        return false;
    }
}
