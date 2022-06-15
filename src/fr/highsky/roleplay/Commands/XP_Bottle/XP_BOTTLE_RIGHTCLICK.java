package fr.highsky.roleplay.Commands.XP_Bottle;

import fr.highsky.roleplay.Main;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.List;

public class XP_BOTTLE_RIGHTCLICK implements Listener {

    private final Main main = Main.getInstance();

    @EventHandler
    public void onrighclickLevel(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK || e.getPlayer().getInventory().getItemInMainHand() == null || e.getPlayer().getInventory().getItemInMainHand().getType() != Material.EXPERIENCE_BOTTLE || !e.getPlayer().getInventory().getItemInMainHand().hasItemMeta())return;


        if(e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK){
            if(e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(main.getConfig().getString("Bottle.Title").replace("&","§"))){
                e.setCancelled(true);


                List<String> lore = main.getConfig().getStringList("Bottle.Description");

                for(int i=0;i<lore.size();i++){
                    if(lore.get(i).contains("%exp%")){
                        String[] lores = p.getInventory().getItemInMainHand().getItemMeta().getLore().get(i).split(" ");
                        for(String s:lores){
                            String[] end = s.split("&");
                            for(String s1:end){
                                if(ChatColor.stripColor(s1).matches("-?\\d+")){

                                    p.getInventory().setItemInMainHand(null);
                                    p.giveExp(Integer.parseInt(ChatColor.stripColor(s1)));
                                    p.sendMessage(main.getConfig().getString("Bottle.Messages.Prefix").replace("&","§") + main.getConfig().getString("Bottle.Messages.Use_Bottle").replace("&","§").replace("%exp%",ChatColor.stripColor(s1)));

                                    break;
                                }
                            }
                        }
                    }
                }
            }


        }



    }


}
