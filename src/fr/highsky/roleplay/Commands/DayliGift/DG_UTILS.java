package fr.highsky.roleplay.Commands.DayliGift;

import fr.highsky.roleplay.Events.LootsBoxs.Utils.LootsBoxs;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Random;

public class DG_UTILS extends BukkitRunnable {

    public static HashMap<String, Long> DayGift = new HashMap<>();

    private Player p;
    private Inventory inv;
    private int time;

    public DG_UTILS(Player p, Inventory inv) {
        this.time = 0;
        this.p = p;
        this.inv = inv;


    }

    @Override
    public void run() {
        time++;
        if(time <= 20)getBox(inv, 12);
        if(time <= 20)getBox(inv, 13);
        if(time <= 20)getBox(inv, 14);
        if(time == 22){

            if(inv.getItem(12).getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §b§lLootBox Commune §8§l«") ){
                p.getInventory().addItem(LootsBoxs.CommunBox(1));
            }else if(inv.getItem(12).getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §c§lLootBox Rare §8§l«")){
                p.getInventory().addItem(LootsBoxs.RareBox(1));
            }else if(inv.getItem(12).getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §6§lLootBox Légendaire §8§l«")){
                p.getInventory().addItem(LootsBoxs.LegBox(1));
            }else if(inv.getItem(12).getType() == Material.BARRIER){
                p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 100);
            }


            if(inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §b§lLootBox Commune §8§l«") ){
                p.getInventory().addItem(LootsBoxs.CommunBox(1));
            }else if(inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §c§lLootBox Rare §8§l«")){
                p.getInventory().addItem(LootsBoxs.RareBox(1));
            }else if(inv.getItem(13).getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §6§lLootBox Légendaire §8§l«")){
                p.getInventory().addItem(LootsBoxs.LegBox(1));
            }else if(inv.getItem(13).getType() == Material.BARRIER){
                p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 100);
            }

            if(inv.getItem(14).getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §b§lLootBox Commune §8§l«") ){
                p.getInventory().addItem(LootsBoxs.CommunBox(1));
            }else if(inv.getItem(14).getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §c§lLootBox Rare §8§l«")){
                p.getInventory().addItem(LootsBoxs.RareBox(1));
            }else if(inv.getItem(14).getItemMeta().getDisplayName().equalsIgnoreCase("§8§l» §6§lLootBox Légendaire §8§l«")){
                p.getInventory().addItem(LootsBoxs.LegBox(1));
            }else if(inv.getItem(14).getType() == Material.BARRIER){
                p.playSound(p.getLocation(), Sound.ENTITY_BLAZE_DEATH, 100, 100);
            }
        }
        if (time == 25) {
            cancel();
            p.closeInventory();
            p.playSound(p.getLocation(), Sound.ENTITY_WANDERING_TRADER_YES, 100, 100);
        }
    }


    public void getBox(Inventory inv, Integer slot){

        Random rdm = new Random();
        int i = 0 + rdm.nextInt(100 - 0);
        Double d = Double.valueOf(i);

        if(d<50){
            ItemStack it = new ItemStack(Material.BARRIER);
            inv.setItem(slot, it);
        }else if(d>50&&d<80){
            inv.setItem(slot, LootsBoxs.CommunBox(1));
        }else if(d>80&&d<95){
            inv.setItem(slot, LootsBoxs.RareBox(1));
        }else if(d>95&&d<100){
            inv.setItem(slot, LootsBoxs.LegBox(1));
        }

    }

}