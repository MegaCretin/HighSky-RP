package fr.highsky.roleplay.Commands.DayliGift;

import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Gestion.Moderation.Utils.MODERATION_MESSAGES_UTILS;
import fr.highsky.roleplay.Gestion.Moderation.Utils.TICK_UTILS;
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

import java.util.Collections;
import java.util.HashMap;

public class DG_INVENTORY implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender instanceof Player){
            Player p = (Player)sender;

            if(args.length == 0){

                if(getDayGift().containsKey(p.getName())){

                    long endGift = (long) getDayGift().get(p.getName());
                    long now = System.currentTimeMillis();
                    long diff = endGift - now;
                    if(diff <= 0L){
                        getDayGift().remove(p.getName());
                    }else {
                        p.sendMessage("§b§lDAY§7-§6§lGIFT §8§l» §cTemps d'attente restant: §e"+ MODERATION_MESSAGES_UTILS.getTime(endGift));
                        return false;
                    }


                }

                Inventory inv = INV_CREATOR.newInv(27, "§b§lDAY§7-§6§lGIFT §8§l» §7[§8I§7]");

                for(int i=0;i<27;i++){
                    ItemStack it = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                    ItemMeta itx = it.getItemMeta();
                    itx.setDisplayName("§e");
                    itx.setLore(Collections.singletonList("§e"));
                    it.setItemMeta(itx);
                    inv.setItem(i, it);
                }

                ItemStack it = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                ItemMeta itx = it.getItemMeta();
                itx.setDisplayName("§e");
                itx.setLore(Collections.singletonList("§e"));
                it.setItemMeta(itx);
                inv.setItem(0, it);
                inv.setItem(1, it);
                inv.setItem(7, it);
                inv.setItem(8, it);
                inv.setItem(9, it);
                inv.setItem(17, it);
                inv.setItem(18, it);
                inv.setItem(19, it);
                inv.setItem(25, it);
                inv.setItem(26, it);

                ItemStack it1 = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                ItemMeta it1x = it1.getItemMeta();
                it1x.setDisplayName("§e");
                it1x.setLore(Collections.singletonList("§e"));
                it1.setItemMeta(it1x);

                p.openInventory(inv);

                DG_UTILS box = new DG_UTILS(p, inv);
                box.runTaskTimer(Main.getInstance(), 3L, 3L);



                long endGift = System.currentTimeMillis() + TICK_UTILS.getTick("Heures", 24);
                long now = System.currentTimeMillis();
                long diff = endGift - now;

                if(diff > 0L){
                    setDayGift(p.getName(), endGift);
                }

            }
        }

        return false;
    }

    private static HashMap getDayGift(){
        return DG_UTILS.DayGift;
    }

    public static void setDayGift(String name, long delay){
        getDayGift().put(name, delay);
    }

}
