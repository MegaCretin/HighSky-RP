package fr.highsky.roleplay.Commands.WeeklyQuest;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.sql.SQLException;

public class WQ_GOLDCLICK implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent e) throws SQLException {

        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§3Quêtes Hebdomadaire §8§l» §7[§8I§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                return;

            }
            switch (e.getCurrentItem().getType()){
                case GOLD_BLOCK:

                    if(e.getCurrentItem().getItemMeta().getLore().toString().contains("la §61 ère")){
                        if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Winner.One.recup") == true){
                            MoneyAPI.giveMoney(Bukkit.getPlayer(Main.getInstance().getConfig().getString("Winner.One.player")), Double.valueOf(Main.getInstance().getConfig().getString("WeeklyQuest.Reward.One.Money")));
                            p.sendMessage(Main.getInstance().getConfig().getString("WeeklyQuest.Messages.Prefix").replace("&","§") + Main.getInstance().getConfig().getString("WeeklyQuest.Reward.One.Message"));
                            if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Reward.One.Commands") == true){
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.One.Command1").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.One.player")));
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.One.Command2").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.One.player")));
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.One.Command3").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.One.player")));
                            }
                            Main.getInstance().getConfig().set("WeeklyQuest.Winner.One.recup", false);
                        }else{
                            return;
                        }
                    }else if(e.getCurrentItem().getItemMeta().getLore().toString().contains("la §62 èmes")){
                        if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Winner.Two.recup") == true){
                            MoneyAPI.giveMoney(Bukkit.getPlayer(Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Two.player")), Double.valueOf(Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Two.Money")));
                            p.sendMessage(Main.getInstance().getConfig().getString("WeeklyQuest.Messages.Prefix").replace("&","§") + Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Two.Message"));
                            if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Reward.Two.Commands") == true){
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Two.Command1").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Two.player")));
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Two.Command2").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Two.player")));
                            }
                            Main.getInstance().getConfig().set("WeeklyQuest.Winner.Two.recup", false);
                        }else{
                            return;
                        }
                    } else if(e.getCurrentItem().getItemMeta().getLore().toString().contains("la §63 èmes")){
                        if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Winner.Three.recup") == true){
                            MoneyAPI.giveMoney(Bukkit.getPlayer(Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Three.player")), Double.valueOf(Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Three.Money")));
                            p.sendMessage(Main.getInstance().getConfig().getString("WeeklyQuest.Messages.Prefix").replace("&","§") + Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Two.Message"));
                            if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.WeeklyQuest.Reward.Three.Commands") == true){
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Three.Command1").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Three.player")));
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Three.Command2").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Three.player")));
                            }
                            Main.getInstance().getConfig().set("WeeklyQuest.Winner.Three.recup", false);
                        }else{
                            return;
                        }
                    }else if(e.getCurrentItem().getItemMeta().getLore().toString().contains("la §64 èmes")){
                        if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Winner.Four.recup") == true){
                            MoneyAPI.giveMoney(Bukkit.getPlayer(Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Four.player")), Double.valueOf(Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Four.Money")));
                            p.sendMessage(Main.getInstance().getConfig().getString("Messages.Prefix").replace("&","§") + Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Four.Message"));
                            if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Reward.Four.Commands") == true){
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Four.Command1").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Four.player")));
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Four.Command2").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Four.player")));
                            }
                            Main.getInstance().getConfig().set("WeeklyQuest.Winner.Four.recup", false);
                        }else{
                            return;
                        }
                    }else if(e.getCurrentItem().getItemMeta().getLore().toString().contains("la §65 èmes")){
                        if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Winner.Five.recup") == true){
                            MoneyAPI.giveMoney(Bukkit.getPlayer(Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Five.player")), Double.valueOf(Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Five.Money")));
                            p.sendMessage(Main.getInstance().getConfig().getString("Messages.Prefix").replace("&","§") + Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Five.Message"));
                            if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Reward.Five.Commands") == true){
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Five.Command1").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Five.player")));
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.getInstance().getConfig().getString("WeeklyQuest.Reward.Five.Command2").replace("%player%", Main.getInstance().getConfig().getString("WeeklyQuest.Winner.Five.player")));
                            }
                            Main.getInstance().getConfig().set("WeeklyQuest.Winner.Five.recup", false);
                        }else{
                            return;
                        }
                    }
                    Main.getInstance().saveConfig();
                    p.closeInventory();
                    break;
                default:
                    break;
            }

        }
    }

}