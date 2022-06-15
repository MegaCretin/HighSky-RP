package fr.highsky.roleplay.Commands.WeeklyQuest;

import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Economy.Shop.Utils.SHOPTYPE;
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
import org.bukkit.inventory.meta.SkullMeta;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class WQ_INVENTORY implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player p = (Player)sender;
        if(p.hasPermission("weeklyquest.open")){

            Inventory inv = INV_CREATOR.newInv(54, "§3Quêtes Hebdomadaire §8§l» §7[§8I§7]");
            SHOPTYPE.addStyle(inv);

            List op = WQ_BDD.getTop3();
            String[] s = op.toString().replace("[","").replace(" ", "").replace("]", "").split(",");
            List<Integer> slot = Arrays.asList(4, 11, 15);


            for(int i = 0; i < s.length; i++){

                if (!s[i].isEmpty()){

                    ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta meta = (SkullMeta) head.getItemMeta();
                    meta.setOwningPlayer(Bukkit.getOfflinePlayer(s[i]));
                    meta.setDisplayName("§8§l» §aSTATS de §e§l"+s[i]+" §8§l«");
                    if(s[i] != null){
                        try {
                            meta.setLore(Arrays.asList(" ", " §7• Nombre: §f"+WQ_BDD.checkNbr(s[i])+" §fitems"," "));
                        } catch (SQLException throwables) {
                            throwables.printStackTrace();
                        }
                    }
                    head.setItemMeta(meta);

                    inv.setItem(slot.get(i), head);

                }
            }

            INV_CREATOR.newItem(inv, 19, Material.GRAY_STAINED_GLASS_PANE, 1,"§e", Arrays.asList("§r"));
            INV_CREATOR.newItem(inv, 20, Material.GRAY_STAINED_GLASS_PANE, 1,"§e", Arrays.asList("§r"));
            INV_CREATOR.newItem(inv, 21, Material.GRAY_STAINED_GLASS_PANE, 1,"§e", Arrays.asList("§r"));
            INV_CREATOR.newItem(inv, 22, Material.GRAY_STAINED_GLASS_PANE, 1,"§e", Arrays.asList("§r"));
            INV_CREATOR.newItem(inv, 23, Material.GRAY_STAINED_GLASS_PANE, 1,"§e", Arrays.asList("§r"));
            INV_CREATOR.newItem(inv, 24, Material.GRAY_STAINED_GLASS_PANE, 1,"§e", Arrays.asList("§r"));
            INV_CREATOR.newItem(inv, 25, Material.GRAY_STAINED_GLASS_PANE, 1,"§e", Arrays.asList("§r"));




            ItemStack player = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta playerx = (SkullMeta) player.getItemMeta();
            playerx.setDisplayName("§8§l» §aVOS STATS §8§l«");
            playerx.setOwningPlayer(p);
            try {
                playerx.setLore(Arrays.asList("","§eNombres d'item posé: §3"+ WQ_BDD.checkNbr(p.getName())));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            player.setItemMeta(playerx);
            inv.setItem(31, player);


            if(p.getName().equalsIgnoreCase(Main.getInstance().getConfig().getString("Winner.One.player"))){
                if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Winner.One.recup") == true) {
                    ItemStack gift = new ItemStack(Material.GOLD_BLOCK);
                    ItemMeta giftx = gift.getItemMeta();
                    giftx.setDisplayName("§e§lRECOMPENSES");
                    giftx.setLore(Arrays.asList(" ", "§fVous avez paerticiper aux ","quêtes hebdomadaires et vous", "§favez finis dans les ","premiers, plus particulièrement", "§fà la §61 ère§f place.","Félicitation !", " ", "§7Cliquez ici pour récupérer","votre récompense"));
                    gift.setItemMeta(giftx);
                    inv.setItem(22, gift);
                }
            }else if(p.getName().equalsIgnoreCase(Main.getInstance().getConfig().getString("Winner.Two.player"))){
                if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Winner.Two.recup") == true) {
                    ItemStack gift = new ItemStack(Material.GOLD_BLOCK);
                    ItemMeta giftx = gift.getItemMeta();
                    giftx.setDisplayName("§e§lRECOMPENSES");
                    giftx.setLore(Arrays.asList(" ", "§fVous avez participer aux quêtes hebdomadaires et vous", "§favez finis dans les premiers, plus particulièrement", "§fà la §62 èmes§f place. Félicitation !", " ", "§7Cliquez ici pour récupérer votre récompense"));
                    gift.setItemMeta(giftx);
                    inv.setItem(22, gift);
                }
            }else if(p.getName().equalsIgnoreCase(Main.getInstance().getConfig().getString("Winner.Three.player"))){
                if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Winner.Three.recup") == true) {
                    ItemStack gift = new ItemStack(Material.GOLD_BLOCK);
                    ItemMeta giftx = gift.getItemMeta();
                    giftx.setDisplayName("§e§lRECOMPENSES");
                    giftx.setLore(Arrays.asList(" ", "§fVous avez participer aux quêtes hebdomadaires et vous", "§favez finis dans les premiers, plus particulièrement", "§fà la §63 èmes§f place. Félicitation !", " ", "§7Cliquez ici pour récupérer votre récompense"));
                    gift.setItemMeta(giftx);
                    inv.setItem(22, gift);
                }
            }else if(p.getName().equalsIgnoreCase(Main.getInstance().getConfig().getString("Winner.Four.player"))){
                if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Winner.Four.recup") == true) {
                    ItemStack gift = new ItemStack(Material.GOLD_BLOCK);
                    ItemMeta giftx = gift.getItemMeta();
                    giftx.setDisplayName("§e§lRECOMPENSES");
                    giftx.setLore(Arrays.asList(" ", "§fVous avez participer aux quêtes hebdomadaires et vous", "§favez finis dans les premiers, plus particulièrement", "§fà la §64 èmes§f place. Félicitation !", " ", "§7Cliquez ici pour récupérer votre récompense"));
                    gift.setItemMeta(giftx);
                    inv.setItem(22, gift);
                }
            }else if(p.getName().equalsIgnoreCase(Main.getInstance().getConfig().getString("Winner.Five.player"))){
                if(Main.getInstance().getConfig().getBoolean("WeeklyQuest.Winner.Five.recup") == true) {
                    ItemStack gift = new ItemStack(Material.GOLD_BLOCK);
                    ItemMeta giftx = gift.getItemMeta();
                    giftx.setDisplayName("§e§lRECOMPENSES");
                    giftx.setLore(Arrays.asList(" ", "§fVous avez participer aux quêtes hebdomadaires et vous", "§favez finis dans les premiers, plus particulièrement", "§fà la §65 èmes§f place. Félicitation !", " ", "§7Cliquez ici pour récupérer votre récompense"));
                    gift.setItemMeta(giftx);
                    inv.setItem(22, gift);
                }
            }
            

            INV_CREATOR.newItem(inv, 38, Material.getMaterial(Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")), 1,"§8§l» §dITEM DE LA SEMAINE §8§l«", Arrays.asList("","§7[§8I§7]","  §fCette semaine vous avez","  §fpour objectif de déposée","  §fun maximum de §a"+Main.getInstance().getConfig().getString("WeeklyQuest.WeekItems")+"§f.","","§7Cliquez pour déposé."));
            INV_CREATOR.newItem(inv, 42, Material.BEACON, 1, "§8§l» §6TOP 10 §8§l«", Arrays.asList("","§7Clqiue pour voir les","§710 premiers joueurs","§7actuelle."));
            INV_CREATOR.newItem(inv, 49, Material.DIAMOND, 1,"§8§l» §bRECOMPENSES §8§l«", Arrays.asList("","§7Cliquez pour voir les récompenses."));

            p.openInventory(inv);
        }else p.sendMessage("§6§lH§b§lS §8§l» §cVous n'avez pas cette permission.");
        return false;
    }
}
