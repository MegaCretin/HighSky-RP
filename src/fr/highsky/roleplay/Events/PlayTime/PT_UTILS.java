package fr.highsky.roleplay.Events.PlayTime;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.SQLException;
import java.util.Arrays;

public class PT_UTILS {

    public static void addCase(Inventory inv, String Name, int slot, String wins1, String wins2, String wins3, Player p, String bdd) throws SQLException {

        ItemStack it = new ItemStack(Material.LIME_STAINED_GLASS_PANE, 1);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§f§lJouer "+Name);
        if(wins2 == null)wins2 ="";
        if(wins3 == null)wins3 ="";
        itx.setLore((Arrays.asList(" ", "§6§lOBJECTIF", " §7• " + "§7Jouer §e"+Name+" §7pour récupérer","   §7cette récompense.",  " ","§e§lRECOMPENSE", " §7• "+wins1,wins2,wins3)));
        if(PT_BDD.getStatus(p, bdd) == true){
            it = new ItemStack(Material.RED_STAINED_GLASS_PANE, 1);
            itx.setDisplayName("§a§lJouer "+Name);
            itx.setLore((Arrays.asList(" ", "§6§lOBJECTIF", " §7• " + "§7Tu as déjà récupéré cette récompense.","")));
        }
        it.setItemMeta(itx);
        inv.setItem(slot, it);

    }
}
