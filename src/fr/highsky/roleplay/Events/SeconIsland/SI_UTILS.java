package fr.highsky.roleplay.Events.SeconIsland;

import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class SI_UTILS {

    public static ItemStack PassIsland(){

        ItemStack it = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta itx = it .getItemMeta();
        itx.setDisplayName("§8§l» §3Deuxième île §8§l«");
        itx.setLore(Arrays.asList("","§7[§8I§7]","  §f➡ §eUtilisations: §aIllimité","","§7En faisant clique droit vous ","§7accederez à votre deuxième île."));
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        it.setItemMeta(itx);
        return it;
    }

}
