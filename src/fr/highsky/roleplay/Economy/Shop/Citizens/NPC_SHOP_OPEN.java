package fr.highsky.roleplay.Economy.Shop.Citizens;


import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Economy.Shop.Utils.SHOPTYPE;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.io.IOException;

public class NPC_SHOP_OPEN implements Listener {


    @EventHandler
    public void onClickNPC(NPCRightClickEvent e) throws IOException {

        Integer ID = e.getNPC().getId();
        Player p = e.getClicker().getPlayer();
        if(ID == getIDNPC("Blocks")){
            if(p.hasPermission("shop.block")){
                SHOPTYPE.shopBlocks(p);
            }else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
        }else if(ID == getIDNPC("Feed")){
            if(p.hasPermission("shop.feed")){
                SHOPTYPE.shopEat(p);
            }else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
        }else if(ID == getIDNPC("Ore")){
            if(p.hasPermission("shop.ore")){
                SHOPTYPE.shopOre(p);
            }else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
        }else if(ID == getIDNPC("Loots")){
            if(p.hasPermission("shop.loots")){
                SHOPTYPE.shopLoots(p);
            }else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
        }else if(ID == getIDNPC("Deco")){
            if(p.hasPermission("shop.deco")){
                SHOPTYPE.shopCoral(p);
            }else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
        }else if(ID == getIDNPC("World")){
            if(p.hasPermission("shop.world")){
                SHOPTYPE.shopWorld(p);
            }else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
        }else if(ID == getIDNPC("Other")){
            if(p.hasPermission("shop.other")){
                SHOPTYPE.shopOther(p);
            }else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
        }else if(ID == getIDNPC("Wild")){
            if(p.hasPermission("shop.wild")){
                SHOPTYPE.shopWild(p);
            }else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
        }else if(ID == getIDNPC("Promo")){
            if(p.hasPermission("shop.promo")){
                SHOPTYPE.saleShop(p);
            }else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
        }

    }

    public int getIDNPC(String name){

        int i = Main.getInstance().getConfig().getInt("NPC."+name);

        return i;
    }

}
