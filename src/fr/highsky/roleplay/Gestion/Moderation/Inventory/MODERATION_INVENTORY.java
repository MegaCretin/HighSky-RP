package fr.highsky.roleplay.Gestion.Moderation.Inventory;

import fr.highsky.roleplay.Gestion.Moderation.Utils.MODERATION_MESSAGES_UTILS;
import fr.highsky.roleplay.Gestion.Moderation.Utils.MODERATION_UTILS;
import fr.highsky.roleplay.Utils.INV_CREATOR;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Arrays;

public class MODERATION_INVENTORY implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player){
            Player p = (Player) sender;
            if(args.length == 1){
                if(p.hasPermission("moderation.menu")){
                    Player suspect = Bukkit.getPlayer(args[0]);
                    if(suspect.isOnline()){
                        Inventory inv = INV_CREATOR.newInv(45, "§6§lH§b§lL§7-§aModération §8§l» §7[§7i§7]");

                        for (int i = 0; i<45; i++){
                            INV_CREATOR.newItem(inv , i, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        }

                        INV_CREATOR.newItem(inv , 0, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 1, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 7, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 8, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 9, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 17, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 27, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 35, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 36, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 37, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 43, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));
                        INV_CREATOR.newItem(inv , 44, Material.ORANGE_STAINED_GLASS_PANE, 1, "§8", Arrays.asList(""));

                        INV_CREATOR.newItem(inv, 4, Material.PLAYER_HEAD, 1, "§a§LGESTION DE SANCTION §8§l» §e"+suspect.getName(), Arrays.asList("§e"));
                        INV_CREATOR.newItem(inv, 19, Material.BARRIER, 1, "§8§l» §d§lMUTE §8§l«", Arrays.asList("§7[§fi§7]","§7Clique ici pour choisir la","§7raison et le temps."));
                        INV_CREATOR.newItem(inv, 21, Material.GOLDEN_BOOTS, 1, "§8§l» §3§lKICK §8§l«", Arrays.asList("§7[§fi§7]","§7Clique ici pour choisir la raison."));
                        INV_CREATOR.newItem(inv, 23, Material.GOLDEN_SWORD, 1, "§8§l» §e§lTEMPBAN §8§l«", Arrays.asList("§7[§fi§7]","§7Clique ici pour choisir la","§7raison et le temps."));
                        INV_CREATOR.newItem(inv, 25, Material.NETHERITE_SWORD, 1, "§8§l» §c§lBAN §8§l«", Arrays.asList("§7[§fi§7]","§7Clique ici pour choisir la raison."));

                        p.openInventory(inv);
                    }
                }else p.sendMessage("§6§lH§b§lS §8§l» §cVous n'avez pas cette permission.");
            }else if(args.length == 2){
                if(args[1].equalsIgnoreCase("untempban")) {
                    if(p.hasPermission("moderation.untempban")){
                        if (MODERATION_UTILS.Ban.containsKey(args[0])) {
                            MODERATION_UTILS.Ban.remove(args[0]);
                            MODERATION_MESSAGES_UTILS.unBan(p, args[0]);
                        }
                    }else p.sendMessage("§6§lH§b§lS §8§l» §cVous n'avez pas cette permission.");
                }else if(args[1].equalsIgnoreCase("unban")){
                    Bukkit.broadcastMessage("0");
                    if(p.hasPermission("moderation.unban")) {
                        if (Bukkit.getOfflinePlayer(args[0]).isBanned()) {
                            Bukkit.broadcastMessage("1");
                            MODERATION_MESSAGES_UTILS.unBan(p, args[0]);
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pardon "+args[0]);
                        }
                    }else p.sendMessage("§6§lH§b§lS §8§l» §cVous n'avez pas cette permission.");
                }else if(args[1].equalsIgnoreCase("unmute")){
                    if(p.hasPermission("moderation.unmute")) {
                        if (MODERATION_UTILS.Mute.containsKey(args[0])) {
                            MODERATION_UTILS.Mute.remove(args[0]);
                            MODERATION_MESSAGES_UTILS.unMute(p, args[0]);
                        }
                    }else p.sendMessage("§6§lH§b§lS §8§l» §cVous n'avez pas cette permission.");
                }
            }
        }

        return false;
    }
}
