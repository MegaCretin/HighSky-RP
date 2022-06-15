package fr.highsky.roleplay.Chat.Tag.TagsMenu;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Chat.Tag.TagsUtils.Database;
import fr.highsky.roleplay.Chat.Tag.TagsUtils.UtilsTags;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.*;

import static org.bukkit.Material.PLAYER_HEAD;

public class TagsEvent implements Listener {
    public TagsEvent() {
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) throws SQLException {
        Player p = (Player)e.getWhoClicked();
        if (e.getClickedInventory() == null) {
            e.setCancelled(true);
        }

        if (e.getView().getTitle().contains("§aTags §7§l»")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;
            }

            if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && e.getCurrentItem().getItemMeta().getDisplayName().equals("§aTags §7§l» §b§lCommun")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory(null, 27, "§aTags §7§l» §b§lCommun");

                for(int i=0;i<27;i++){
                    ItemStack it = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                    ItemMeta itx = it.getItemMeta();
                    itx.setLore(Arrays.asList("§e"));
                    itx.setDisplayName("§e");
                    it.setItemMeta(itx);
                    inv.setItem(i, it);
                }



                List<Integer> in = new ArrayList<>();
                in.add(0);
                in.add(8);
                in.add(18);
                in.add(26);

                for(int i=0; i<in.size();i++){

                    ItemStack it = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                    ItemMeta itx = it.getItemMeta();
                    itx.setLore(Arrays.asList("§e"));
                    itx.setDisplayName("§e");
                    it.setItemMeta(itx);
                    inv.setItem(in.get(i), it);

                }

                ItemStack retour = new ItemStack(Material.ARROW);
                ItemMeta retourx = retour.getItemMeta();
                retourx.setDisplayName("§cRetour");
                retour.setItemMeta(retourx);
                inv.setItem(10, retour);

                UtilsTags.TagsMenu("§7#Jacky§cR§aG§9B", inv, 3);
                UtilsTags.TagsMenu("§7#§9Fr§fan§cce", inv, 4);
                UtilsTags.TagsMenu("§7#§8Bel§egi§cque", inv, 5);
                UtilsTags.TagsMenu("§7#§bDiamant", inv, 6);
                UtilsTags.TagsMenu("§7#§9J'mPaDodo", inv, 12);
                UtilsTags.TagsMenu("§7#§aMinecraft", inv, 13);
                UtilsTags.TagsMenu("§7#§fCommun", inv, 14);
                UtilsTags.TagsMenu("§7#§f§oIdiot", inv, 15);
                UtilsTags.TagsMenu("§7#§d♀", inv, 21);
                UtilsTags.TagsMenu("§7#§b♂", inv, 22);
                UtilsTags.TagsMenu("§7#§9Pro", inv, 23);
                UtilsTags.TagsMenu("§7#§c♥", inv, 24);


                p.openInventory(inv);
                /*ItemStack Insomniaque = new ItemStack(Material.NAME_TAG);
                ItemMeta Insomniaquex = Insomniaque.getItemMeta();
                Insomniaquex.setDisplayName(("&1#&9Insomniaque").replace("&", "§"));
                Insomniaquex.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable après 2h du matin"));
                Insomniaque.setItemMeta(Insomniaquex);
                inv.setItem(10, Insomniaque);

                ItemStack Millionnaire = new ItemStack(Material.NAME_TAG);
                ItemMeta Millionnairex = Millionnaire.getItemMeta();
                Millionnairex.setDisplayName(("&6#&eMillionnaire").replace("&", "§"));
                Millionnairex.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable après avoir 1M$"));
                Millionnaire.setItemMeta(Millionnairex);
                inv.setItem(11, Millionnaire);

                ItemStack Vote = new ItemStack(Material.NAME_TAG);
                ItemMeta Votex = Vote.getItemMeta();
                Votex.setDisplayName(("&a#Voteur").replace("&", "§"));
                Votex.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable après 250 Votes sur le serveur"));
                Vote.setItemMeta(Votex);
                inv.setItem(12, Vote);

                ItemStack it1 = new ItemStack(PLAYER_HEAD, 1);
                SkullMeta itemMeta1 = (SkullMeta) it1.getItemMeta();
                itemMeta1.setDisplayName("§f§lQuêtes");
                GameProfile profile1 = new GameProfile(UUID.randomUUID(), null);
                byte[] encodedData1 = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", "http://textures.minecraft.net/texture/56330a4a22ff55871fc8c618e421a37733ac1dcab9c8e1a4bb73ae645a4a4e").getBytes());
                profile1.getProperties().put("textures", new Property("textures", new String(encodedData1)));
                Field profileField1 = null;
                try
                {
                    profileField1 = itemMeta1.getClass().getDeclaredField("profile");
                    profileField1.setAccessible(true);
                    profileField1.set(itemMeta1, profile1);
                }
                catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException er)
                {
                    er.printStackTrace();
                }
                it1.setItemMeta(itemMeta1);
                inv.setItem(14, it1);

                ItemStack it2 = new ItemStack(PLAYER_HEAD, 1);
                SkullMeta itemMeta2 = (SkullMeta) it2.getItemMeta();
                itemMeta2.setDisplayName("§f§lDH");
                GameProfile profile2 = new GameProfile(UUID.randomUUID(), null);
                byte[] encodedData2 = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"%s\"}}}", "http://textures.minecraft.net/texture/56330a4a22ff55871fc8c618e421a37733ac1dcab9c8e1a4bb73ae645a4a4e").getBytes());
                profile2.getProperties().put("textures", new Property("textures", new String(encodedData2)));
                Field profileField2 = null;
                try
                {
                    profileField2 = itemMeta2.getClass().getDeclaredField("profile");
                    profileField2.setAccessible(true);
                    profileField2.set(itemMeta2, profile2);
                }
                catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException er)
                {
                    er.printStackTrace();
                }
                it2.setItemMeta(itemMeta2);
                inv.setItem(16, it2);
                */
            }

            if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && e.getCurrentItem().getItemMeta().getDisplayName().equals("§aTags §7§l» §c§lRare")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory(null, 27, "§aTags §7§l» §c§lRare");

                for(int i=0;i<27;i++){
                    ItemStack it = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                    ItemMeta itx = it.getItemMeta();
                    itx.setLore(Arrays.asList("§e"));
                    itx.setDisplayName("§e");
                    it.setItemMeta(itx);
                    inv.setItem(i, it);
                }



                List<Integer> in = new ArrayList<>();
                in.add(0);
                in.add(8);
                in.add(18);
                in.add(26);

                for(int i=0; i<in.size();i++){

                    ItemStack it = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                    ItemMeta itx = it.getItemMeta();
                    itx.setLore(Arrays.asList("§e"));
                    itx.setDisplayName("§e");
                    it.setItemMeta(itx);
                    inv.setItem(in.get(i), it);

                }

                ItemStack retour = new ItemStack(Material.ARROW);
                ItemMeta retourx = retour.getItemMeta();
                retourx.setDisplayName("§cRetour");
                retour.setItemMeta(retourx);
                inv.setItem(10, retour);

                UtilsTags.TagsMenu("§c#§f§lSupreme", inv, 3);
                UtilsTags.TagsMenu("&7#§cC§6o§el§ao§br", inv, 4);
                UtilsTags.TagsMenu("§f#§2Stonks", inv, 5);
                UtilsTags.TagsMenu("§f#§4G§ce§6r§em§2a§ai§3n", inv, 6);
                UtilsTags.TagsMenu("§f#§9G§co§6o§9g§2l§ce", inv, 12);
                UtilsTags.TagsMenu("§f#§bRare", inv, 13);
                UtilsTags.TagsMenu("§f#§8§mHashTag", inv, 14);
                UtilsTags.TagsMenu("§f#§e«§6Top 1§e»", inv, 15);
                UtilsTags.TagsMenu("§f#§e❋§6Soleil§e❋", inv, 21);
                UtilsTags.TagsMenu("§f#§e§kM§r§aGameur§e§kM", inv, 22);
                UtilsTags.TagsMenu("§f#§6§lHigh§b§lSky", inv, 23);
                UtilsTags.TagsMenu("§f#§cÉ.MERCÉ", inv, 24);

                p.openInventory(inv);
            }

            if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && e.getCurrentItem().getItemMeta().getDisplayName().equals("§aTags §7§l» §6§lLégendaire")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory(null, 27, "§aTags §7§l» §6§lLégendaire");

                for(int i=0;i<27;i++){
                    ItemStack it = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                    ItemMeta itx = it.getItemMeta();
                    itx.setLore(Arrays.asList("§e"));
                    itx.setDisplayName("§e");
                    it.setItemMeta(itx);
                    inv.setItem(i, it);
                }



                List<Integer> in = new ArrayList<>();
                in.add(0);
                in.add(8);
                in.add(18);
                in.add(26);

                for(int i=0; i<in.size();i++){

                    ItemStack it = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                    ItemMeta itx = it.getItemMeta();
                    itx.setLore(Arrays.asList("§e"));
                    itx.setDisplayName("§e");
                    it.setItemMeta(itx);
                    inv.setItem(in.get(i), it);

                }

                ItemStack retour = new ItemStack(Material.ARROW);
                ItemMeta retourx = retour.getItemMeta();
                retourx.setDisplayName("§cRetour");
                retour.setItemMeta(retourx);
                inv.setItem(10, retour);

                UtilsTags.TagsMenu("§e#", inv, 12);
                UtilsTags.TagsMenu("§6$§ePay§b2§aWin§6$", inv, 13);
                UtilsTags.TagsMenu("§2T§ao§2x§ai§2c §a☣", inv, 14);
                UtilsTags.TagsMenu("§e#§cNO§eL§bI§3F§dE", inv, 15);


                p.openInventory(inv);
            }

            /*if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && e.getCurrentItem().getItemMeta().getDisplayName().equals("§c§lLegendaire")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "§6§l>> §bTags§f/§cLegendaire §6§l<<");

                ItemStack retour = new ItemStack(Material.ARROW);
                ItemMeta retourx = retour.getItemMeta();
                retourx.setDisplayName("§cRetour");
                retour.setItemMeta(retourx);
                inv.setItem(0, retour);

                UtilsTags.TagsMenu("&4&k&l$&b&lPay&e&l&n2&a&lWin&4&l&k$&r", inv, 11);
                UtilsTags.TagsMenu("&e&k&n.&e&nHigh&b&nSky&k&n.", inv, 12);
                UtilsTags.TagsMenu("#&kyyyyy", inv, 13);
                UtilsTags.TagsMenu("&c#NO&eL&bI&3F&dE", inv, 14);
                UtilsTags.TagsMenu("&2T&ao&2x&ai&2c &a☣", inv, 15);

                ItemStack bar = new ItemStack(Material.BARRIER);
                ItemMeta barx = bar.getItemMeta();
                barx.setDisplayName("§cReset du TAG");
                bar.setItemMeta(barx);
                inv.setItem(26, bar);

                p.openInventory(inv);
            }

            if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && e.getCurrentItem().getItemMeta().getDisplayName().equals("§d§lExclusif")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory((InventoryHolder)null, 9, "§6§l>> §bTags§f/§dExclusif §6§l<<");

                ItemStack retour = new ItemStack(Material.ARROW);
                ItemMeta retourx = retour.getItemMeta();
                retourx.setDisplayName("§cRetour");
                retour.setItemMeta(retourx);
                inv.setItem(0, retour);

                ItemStack HighSky = new ItemStack(Material.NAME_TAG);
                ItemMeta HighSkyx = HighSky.getItemMeta();
                HighSkyx.setDisplayName(("&6&lHigh&e&lSky").replace("&", "§"));
                HighSkyx.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable que lors de la première semaine d'ouverture"));
                HighSky.setItemMeta(HighSkyx);
                inv.setItem(3, HighSky);

                ItemStack Donnateur = new ItemStack(Material.NAME_TAG);
                ItemMeta Donnateurx = Donnateur.getItemMeta();
                Donnateurx.setDisplayName(("&f#&cD&6o&en&2a&at&3e&9u&dr &e$$$").replace("&", "§"));
                Donnateurx.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable après avec payé 50 euros sur le serveur"));
                Donnateur.setItemMeta(Donnateurx);
                inv.setItem(4, Donnateur);

                ItemStack Pass = new ItemStack(Material.NAME_TAG);
                ItemMeta Passx = Pass.getItemMeta();
                Passx.setDisplayName(("&6&lPass&a&l✓").replace("&", "§"));
                Passx.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable dans le pass"));
                Pass.setItemMeta(Passx);
                inv.setItem(5, Pass);

                ItemStack bar = new ItemStack(Material.BARRIER);
                ItemMeta barx = bar.getItemMeta();
                barx.setDisplayName("§cReset du TAG");
                bar.setItemMeta(barx);
                inv.setItem(8, bar);

                p.openInventory(inv);

            }

            if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && e.getCurrentItem().getItemMeta().getDisplayName().equals("§f§lQuêtes")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory((InventoryHolder)null, 18, "§6§l>> §bTags§f/§aEn Jeux§f/§8Quêtes §6§l<<");

                ItemStack retour = new ItemStack(Material.ARROW);
                ItemMeta retourx = retour.getItemMeta();
                retourx.setDisplayName("§cRetour");
                retour.setItemMeta(retourx);
                inv.setItem(0, retour);

                ItemStack Neophyte = new ItemStack(Material.NAME_TAG);
                ItemMeta Neophytex = Neophyte.getItemMeta();
                Neophytex.setDisplayName(("&5&l#Facile").replace("&", "§"));
                Neophytex.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable dès les quêtes Facile terminées "));
                Neophyte.setItemMeta(Neophytex);
                inv.setItem(2, Neophyte);

                ItemStack Initie = new ItemStack(Material.NAME_TAG);
                ItemMeta Initiex = Initie.getItemMeta();
                Initiex.setDisplayName(("&d&l#Normal").replace("&", "§"));
                Initiex.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable dès les quêtes Normal terminées "));
                Initie.setItemMeta(Initiex);
                inv.setItem(3, Initie);

                ItemStack Intermediaire = new ItemStack(Material.NAME_TAG);
                ItemMeta Intermediairex = Intermediaire.getItemMeta();
                Intermediairex.setDisplayName(("&c&l#Intermédiaire").replace("&", "§"));
                Intermediairex.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable dès les quêtes Intermédiaires terminées "));
                Intermediaire.setItemMeta(Intermediairex);
                inv.setItem(4, Intermediaire);

                ItemStack Avance = new ItemStack(Material.NAME_TAG);
                ItemMeta Avancex = Avance.getItemMeta();
                Avancex.setDisplayName(("&6&l#Courageux").replace("&", "§"));
                Avancex.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable dès les quêtes Courageux terminées "));
                Avance.setItemMeta(Avancex);
                inv.setItem(5, Avance);

                ItemStack Confirme = new ItemStack(Material.NAME_TAG);
                ItemMeta Confirmex = Confirme.getItemMeta();
                Confirmex.setDisplayName(("&e&l#Epique").replace("&", "§"));
                Confirmex.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable dès les quêtes Epique terminées "));
                Confirme.setItemMeta(Confirmex);
                inv.setItem(11, Confirme);

                ItemStack Maitre = new ItemStack(Material.NAME_TAG);
                ItemMeta Maitrex = Maitre.getItemMeta();
                Maitrex.setDisplayName(("&a&l#Héroïque").replace("&", "§"));
                Maitrex.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable dès les quêtes Héroïque terminées "));
                Maitre.setItemMeta(Maitrex);
                inv.setItem(12, Maitre);

                ItemStack Expert = new ItemStack(Material.NAME_TAG);
                ItemMeta Expertx = Expert.getItemMeta();
                Expertx.setDisplayName(("&3&l#Déterminé").replace("&", "§"));
                Expertx.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable dès les quêtes Déterminé terminées "));
                Expert.setItemMeta(Expertx);
                inv.setItem(13, Expert);

                ItemStack Master = new ItemStack(Material.NAME_TAG);
                ItemMeta Masterx = Master.getItemMeta();
                Masterx.setDisplayName(("&9&l#Légendaire").replace("&", "§"));
                Masterx.setLore(Arrays.asList("", "§aLes tags sont des éléments", "§ade décorations ils sont visibles", "§auniquement quand tu parle.", "", "§3Tu peux les activer et", "§3désactiver quand tu veux.", "", "Obtenable dès les quêtes Légendaire terminées "));
                Master.setItemMeta(Masterx);
                inv.setItem(14, Master);

                ItemStack bar = new ItemStack(Material.BARRIER);
                ItemMeta barx = bar.getItemMeta();
                barx.setDisplayName("§cReset du TAG");
                bar.setItemMeta(barx);
                inv.setItem(17, bar);

                p.openInventory(inv);
            }

            if(e.getCurrentItem().hasItemMeta() && e.getCurrentItem().getItemMeta().hasDisplayName() && e.getCurrentItem().getItemMeta().getDisplayName().equals("§f§lDH")){
                p.closeInventory();

                Inventory inv = Bukkit.createInventory((InventoryHolder)null, 27, "§6§l>> §bTags§f/§aEn Jeux§f/§8DH §6§l<<");

                ItemStack retour = new ItemStack(Material.ARROW);
                ItemMeta retourx = retour.getItemMeta();
                retourx.setDisplayName("§cRetour");
                retour.setItemMeta(retourx);
                inv.setItem(0, retour);

                UtilsTags.TagsMenu("#&eRoi&2Cactus", inv, 2);
                UtilsTags.TagsMenu("#&eRoi&6Carotte", inv, 3);
                UtilsTags.TagsMenu("#&eRoi&6Pattate", inv, 4);
                UtilsTags.TagsMenu("#&eRoi&6Ci&etr&6ou&eil&6le", inv, 5);
                UtilsTags.TagsMenu("#&eRoi&aSucre", inv, 6);
                UtilsTags.TagsMenu("#&eRoi&7Caillou", inv, 11);
                UtilsTags.TagsMenu("#&eRoi&7Pierre", inv, 12);
                UtilsTags.TagsMenu("#&eRoi&cVerrue", inv, 14);
                UtilsTags.TagsMenu("#&eRoi&dChorus", inv, 15);
                UtilsTags.TagsMenu("#&eRoi&8Bois", inv, 20);
                UtilsTags.TagsMenu("#&eRoi&aFeuillage", inv, 21);
                UtilsTags.TagsMenu("#&eRoi&8Cochon", inv, 22);
                UtilsTags.TagsMenu("#&eRoi&5Betterave", inv, 23);
                UtilsTags.TagsMenu("#&eRoi&8Encre", inv, 24);

                ItemStack bar = new ItemStack(Material.BARRIER);
                ItemMeta barx = bar.getItemMeta();
                barx.setDisplayName("§cReset du TAG");
                bar.setItemMeta(barx);
                inv.setItem(26, bar);

                p.openInventory(inv);
            }*/

            switch(e.getCurrentItem().getType()) {
                case NAME_TAG:

                    String tag = (e.getCurrentItem().getItemMeta().getDisplayName()).replace("§", "&");

                    int idTag = Database.RecupId(tag);


                    if (idTag != 0){

                        boolean possede = Database.VerifTag(p, idTag);

                        if (possede == true){

                            p.sendMessage("§6§lHigh§b§lSky §7§l>> §aVotre Tag a bien été mis");

                            if (!Main.mapTAG.containsKey(p.getUniqueId())) {
                                Main.mapTAG.put(p.getUniqueId(), tag.replace("&", "§"));
                            } else {
                                Main.mapTAG.replace(p.getUniqueId(), tag.replace("&", "§"));

                            }

                            p.closeInventory();
                        }
                        else{
                            p.sendMessage("§6§lHigh§b§lSky §7§l>> §cVous ne possédez pas ce Tag");
                            return;
                        }
                    }

                    break;
                case WRITABLE_BOOK:
                    Main.mapTAG.remove(p.getUniqueId());
                    p.sendMessage("§6§lHigh§b§lSky §7§l>> §cTu as retiré ton TAG.");
                    p.closeInventory();

                case ARROW:
                    p.closeInventory();
                    p.performCommand("tags");
            }
        }

    }
}
