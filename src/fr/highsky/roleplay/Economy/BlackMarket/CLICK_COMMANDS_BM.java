package fr.highsky.roleplay.Economy.BlackMarket;

import fr.herllox.hmoney.API.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CLICK_COMMANDS_BM implements Listener {


    @EventHandler
    public void clickCommands(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();


        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§5Marché noir §8§l» §c§lCommandes")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }

            switch (e.getCurrentItem().getType()) {
                case NAME_TAG:
                    if(!p.hasPermission("cmi.command.nick.different")){
                        if(MoneyAPI.getMoney(p) >= 1000000.00){
                            MoneyAPI.removeMoney(p, 1000000.00);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user "+p.getName()+" permission set cmi.command.nick.different true");
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user "+p.getName()+" permission set cmi.command.nick true");
                            p.sendMessage("§c§lCOMMANDES §8§l» §aVous avez acheté la commande §e/nick <text>§a.");
                        }else{
                            p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                        }
                    }else{
                        p.sendMessage("§f§k§lMichel §8§l» §cTu l'as déjà !");
                    }
                    break;
                case WRITABLE_BOOK:
                    if(!p.hasPermission("cmi.command.itemname")){
                        if(MoneyAPI.getMoney(p) >= 1000000.00){
                            MoneyAPI.removeMoney(p, 1000000.00);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user "+p.getName()+" permission set cmi.command.itemname true");
                            p.sendMessage("§c§lCOMMANDES §8§l» §aVous avez acheté la commande §e/itemname <text>§a.");
                        }else{
                            p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                        }
                    }else{
                        p.sendMessage("§f§k§lMichel §8§l» §cTu l'as déjà !");
                    }
                    break;
                case SPECTRAL_ARROW:
                    if(!p.hasPermission("cmi.command.glow")){
                        if(MoneyAPI.getMoney(p) >= 1000000.00){
                            MoneyAPI.removeMoney(p, 1000000.00);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"lp user "+p.getName()+" permission set cmi.command.glow true");
                            p.sendMessage("§c§lCOMMANDES §8§l» §aVous avez acheté la commande §e/glow§a.");
                        }else{
                            p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                        }
                    }else{
                        p.sendMessage("§f§k§lMichel §8§l» §cTu l'as déjà !");
                    }
                    break;
                case BARRIER:
                    p.closeInventory();
                    p.openInventory(BM_INVENTORY.BMInventory());
                    break;
                default:
                    break;
            }
        }
    }


}
