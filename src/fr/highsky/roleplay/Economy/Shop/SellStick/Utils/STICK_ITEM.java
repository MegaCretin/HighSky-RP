package fr.highsky.roleplay.Economy.Shop.SellStick.Utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class STICK_ITEM {

    public static ItemStack SellStick(Double multiplicateur,int utilisation){

        ItemStack it = new ItemStack(Material.END_ROD);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§7---§e{ §6§lSellStick §e}§7---§e §f(§a§3"+multiplicateur+"§f)");
        itx.setLore(Arrays.asList("§f┏                ━━━━━━", "§f┃ §a§lUtilisation§f§l:", "§f┃  ▶ §b§l" + utilisation, "§f┣                ━━━━━━", "§f┃ §6§lMultiplicateur§f§l:", "§f┃  ▶ §b§l"  + multiplicateur,"§f┣                ━━━━━━", "§f┃ §e§lInformations§f§l: ", "§f┃   §7[§a✔§7]§aClique §ldroit §r§a sur un coffre","§f┃      §apour vendre le contenue","§f┃      §adu coffre.","§f┗                ━━━━━━"));
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        it.setItemMeta(itx);
        return it;

    }

}
