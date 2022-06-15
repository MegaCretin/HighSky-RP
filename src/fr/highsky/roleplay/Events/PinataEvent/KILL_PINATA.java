package fr.highsky.roleplay.Events.PinataEvent;

import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils.KEY;
import fr.highsky.roleplay.Events.Boxs.XPBoxs.XP_BOXS_KEY;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Llama;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class KILL_PINATA implements Listener {

    @EventHandler
    public void killPinata(EntityDeathEvent e){

        if(e.getEntity() instanceof Llama){
            if(e.getEntity().getCustomName().equals("§8§l» §d§lPIÑATA §8§l«")){
                e.getDrops().clear();
                e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.GRASS_BLOCK, 64));
                e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.GRASS_BLOCK, 64));
                e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.SAND, 64));
                e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.OAK_LOG, 32));
                e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.DIAMOND, 4));
                e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), new ItemStack(Material.IRON_INGOT, 16));
                e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), KEY.RareKey(1));
                e.getEntity().getLocation().getWorld().dropItemNaturally(e.getEntity().getLocation(), XP_BOXS_KEY.XP150Key(2));

                Bukkit.broadcastMessage("§d§lPIÑATA §8§l» §e"+e.getEntity().getKiller().getName()+" §aà détruit la piñata !");
            }
        }

    }

}
