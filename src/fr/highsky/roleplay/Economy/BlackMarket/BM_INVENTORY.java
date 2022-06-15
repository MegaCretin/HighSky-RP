package fr.highsky.roleplay.Economy.BlackMarket;

import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Utils.GET_RANDOM_BM_ITEM;
import fr.highsky.roleplay.Utils.INV_CREATOR;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class BM_INVENTORY implements Listener {


    @EventHandler
    public void openBMInventory(NPCRightClickEvent e){
        if(e.getNPC().getId() == Main.getInstance().getConfig().getInt("NPC.BlackMarket.ID")){
            Player p = e.getClicker().getPlayer();

            p.openInventory(BMInventory());
        }
    }

    public static Inventory BMInventory(){
        Inventory inv = INV_CREATOR.newInv(45,"§5Marché noir §8§l» §7[§8I§7]");
        for(int i=0; i<44;i++){
            INV_CREATOR.newItem(inv, i, Material.LIGHT_BLUE_STAINED_GLASS_PANE, 1, "§e",Arrays.asList("§e"));
        }

        ItemStack it = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName(null);
        itx.setLore(null);
        it.setItemMeta(itx);

        inv.setItem(0, it);
        inv.setItem(1, it);
        inv.setItem(7, it);
        inv.setItem(8, it);
        inv.setItem(9, it);
        inv.setItem(17, it);
        inv.setItem(27, it);
        inv.setItem(35, it);
        inv.setItem(36, it);
        inv.setItem(37, it);
        inv.setItem(43, it);
        inv.setItem(44, it);

        INV_CREATOR.newItem(inv, 13, Material.COMMAND_BLOCK, 1,"§8§l» §c§lCOMMANDES §8§l«", Arrays.asList("","§7[§fi§7]","  §7Ici vous pouvez acheter","  §7des commandes spéciales","  §7avec de l'argent en jeu."));

        INV_CREATOR.newItem(inv, 19, Material.NETHERITE_CHESTPLATE, 1,"§8§l» §5§lGRADES §8§l«", Arrays.asList("","§7[§fi§7]","  §7Ici vous pouvez acheter","  §7des grades définitif","  §7avec de l'argent en jeu."));

        INV_CREATOR.newItem(inv, 25, Material.ORANGE_SHULKER_BOX, 1,"§8§l» §b§lCLÉS DE BOX §8§l«", Arrays.asList("","§7[§fi§7]","  §7Ici vous pouvez acheter","  §7des clés pour les box","  §7avec de l'argent en jeu."));

        inv.setItem(31, GET_RANDOM_BM_ITEM.getItem(Main.getInstance().getConfig().getInt("BlackMarket.Number")));


        return inv;
    }

}
