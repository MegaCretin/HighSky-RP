package fr.highsky.roleplay.Commands.DayliQuest;

import fr.highsky.roleplay.Utils.INV_CREATOR;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.time.LocalTime;
import java.util.Arrays;

public class DQ_INVENTORY implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player p = (Player)sender;
        if(p.hasPermission("dayq.open")){
            int hour = LocalTime.now().getHour();
            int min = LocalTime.now().getMinute();

            if(hour >= 2 && (hour <= 23 && min <= 59)){

                if(!DQ_UTILS.players.contains(p))DQ_UTILS.players.add(p);
                File file = new File("plugins/HighSky-RP/Origine/PlayerData/"+p.getName()+".yml");
                FileConfiguration config = YamlConfiguration.loadConfiguration(file);

                Inventory inv = INV_CREATOR.newInv(27, "§3Quêtes Journalière §8§l» §7[§8I§7]");

                for(int i = 0; i<27;i++){
                    INV_CREATOR.newItem(inv, i, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));
                }


                INV_CREATOR.newItem(inv, 0, Material.ORANGE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));
                INV_CREATOR.newItem(inv, 1, Material.ORANGE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));
                INV_CREATOR.newItem(inv, 7, Material.ORANGE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));
                INV_CREATOR.newItem(inv, 8, Material.ORANGE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));
                INV_CREATOR.newItem(inv, 9, Material.ORANGE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));
                INV_CREATOR.newItem(inv, 17, Material.ORANGE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));
                INV_CREATOR.newItem(inv, 18, Material.ORANGE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));
                INV_CREATOR.newItem(inv, 19, Material.ORANGE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));
                INV_CREATOR.newItem(inv, 25, Material.ORANGE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));
                INV_CREATOR.newItem(inv, 26, Material.ORANGE_STAINED_GLASS_PANE, 1, "§e", Arrays.asList("§e"));

                ItemStack q1 = new ItemStack(Material.WHEAT);
                ItemMeta q1x = q1.getItemMeta();
                q1x.setDisplayName("§aQuête §fn°§e1");
                if(config.getBoolean("DayliQuest.One") == false){
                    q1x.setLore(DQ_UTILS.setQuest(q1.getType()));
                }else{
                    q1x.setLore(Arrays.asList("","§7[§8I§7]","  §aQuête réussi"));
                    q1x.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    q1x.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                }
                q1.setItemMeta(q1x);
                inv.setItem(11, q1);

                ItemStack q2 = new ItemStack(Material.COBBLESTONE);
                ItemMeta q2x = q2.getItemMeta();
                q2x.setDisplayName("§aQuête §fn°§e2");
                if(config.getBoolean("DayliQuest.Two") == false){
                    q2x.setLore(DQ_UTILS.setQuest(q2.getType()));
                }else{
                    q2x.setLore(Arrays.asList("","§7[§8I§7]","  §aQuête réussi"));
                    q2x.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    q2x.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                }
                q2.setItemMeta(q2x);
                inv.setItem(13, q2);

                ItemStack q3 = new ItemStack(Material.ROTTEN_FLESH);
                ItemMeta q3x = q3.getItemMeta();
                q3x.setDisplayName("§aQuête §fn°§e3");
                if(config.getBoolean("DayliQuest.Three") == false){
                    q3x.setLore(DQ_UTILS.setQuest(q3.getType()));
                }else{
                    q3x.setLore(Arrays.asList("","§7[§8I§7]","  §aQuête réussi"));
                    q3x.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
                    q3x.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                }
                q3.setItemMeta(q3x);
                inv.setItem(15, q3);

                p.openInventory(inv);
            }else p.sendMessage("§3Quêtes Journalière §8§l» §cCette commande n'est disponible que de 2h à 23h59.");
        }else p.sendMessage("§6§lH§b§lS §8§l» §cVous n'avez pas cette permission.");
        return false;
    }
}
