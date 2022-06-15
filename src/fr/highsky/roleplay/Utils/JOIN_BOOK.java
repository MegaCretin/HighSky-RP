package fr.highsky.roleplay.Utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;

import java.util.ArrayList;
import java.util.List;

public class JOIN_BOOK {

    public static ItemStack joinBook(){

        ItemStack it = new ItemStack(Material.WRITTEN_BOOK, 1);
        BookMeta bm = (BookMeta) it.getItemMeta();
        bm.setTitle("§8§l» §a§lBIENVENUE §8§l«");
        bm.setAuthor("§6§lHigh§b§lSky");

        List<String> pages = new ArrayList<>();
        pages.add("§7§lCommandes :\n\n§7-§b/AuctionHouse §7(§bah§7)§b: §7Permet d'ouvrir le menu de l'hôtel de vente.\n§7-§b/Bvn §7(§bb§7)§b: §7Souhaite la bienvenue à un nouveau.\n" +
                "§7-§b/Duel <Joueur>: §7Provoque un joueur en duel."); // Page 1
        pages.add("§7-§b/DefiHebdo (dh)§b: §7Ouvre le menu des défis hebdomadaires.\n§7-§bFurnace all/hand§b: Permet de cuite les minerais de votre inventaire.\n" +
                "§7-§b/is help§b: §7Affiche les commandes du plugin Skyblock.\n§7-§b/Kit <kit>§b: §7Permet de recevoir votre quitte.");
        pages.add("§7-§b/Liens§b: §7§7Vous envoie les liens utiles du serveur.\n§7-§b/Money help§b: §7§7Affiche les commandes du plugin de Money.\n§7-§b/Msg <Joueur>§b: §7Permet d'envoyer un message privé à un joueur.\n" +
                "§7-§b/Pt§b: §7Ouvre le menu des récompenses PlayTime.\n§7-§b/Warp <warp>§b: §7Ouvre la liste des warps.");

        bm.setPages(pages);

        it.setItemMeta(bm);

        return it;

    }

}
