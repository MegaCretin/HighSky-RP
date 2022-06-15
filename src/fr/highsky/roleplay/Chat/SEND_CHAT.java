package fr.highsky.roleplay.Chat;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Gestion.Moderation.Events.MUTE_SPEAK;
import fr.highsky.roleplay.Chat.Tag.TagsUtils.UtilsTags;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SEND_CHAT implements Listener {

    private final Pattern pattern = Pattern.compile("#[a-fA-F0-9]{6}");

    @Deprecated
    @EventHandler (priority = EventPriority.HIGHEST)
    public void sendChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();


        if(!MUTE_SPEAK.canSpeak(p)){
            e.setCancelled(true);
            return;
        }else {


            long level = 0;
        /*if(SkyBlockAPI.getIslandManager().getIsland(p).isLoaded() == false){
            level = 0;
        }else{
            level = SkyBlockAPI.getIslandManager().getIsland(p).getLevel().getLevel();
        }*/

            String msg = "";
            String text = e.getMessage();
            if (p.hasPermission("group." + "Crea") || p.hasPermission("group." + "Admin") || p.hasPermission("group." + "Dev")) {

                if (p.hasPermission("group." + "Crea") && p.getName().equalsIgnoreCase("Herllox")) {
                    msg = UtilsTags.getTag(p) + "§c[§4Créateur§c] §c" + e.getPlayer().getName() + " §7»§f ";
                } else if (p.hasPermission("group." + "Admin") && (p.getName().equalsIgnoreCase("MegaCretin") || p.getName().equalsIgnoreCase("Mewl_"))) {
                    msg = UtilsTags.getTag(p) + "§4[Admin] §c" + e.getPlayer().getName() + " §7»§f ";
                } else if (p.hasPermission("group." + "Dev")) {
                    msg = UtilsTags.getTag(p) + "§d[§5Développeur§d] §d" + e.getPlayer().getName() + " §7»§f ";
                }

                e.setFormat(msg + format(text));

            }else{
                if (p.hasPermission("chat.color")) {
                    text = text.replace("&","§");
                }
                if (p.hasPermission("group." + "Modo")) {
                    msg = UtilsTags.getTag(p) + getRank(p) + " §6" + e.getPlayer().getName() + " §7»§f ";
                } else if (p.hasPermission("group." + "Guide")) {
                    msg = UtilsTags.getTag(p) + getRank(p) + " §b" + e.getPlayer().getName() + " §7»§f ";
                } else if (p.hasPermission("group." + "Partenaire")) {
                    msg = UtilsTags.getTag(p) + getRank(p) + " §e" + e.getPlayer().getName() + " §7»§f ";
                } else if (p.hasPermission("group." + "Builder")) {
                    msg = UtilsTags.getTag(p) + getRank(p) + " §a" + e.getPlayer().getName() + " §7»§f ";
                } else if (p.hasPermission("group." + "MVP")) {
                    msg = UtilsTags.getTag(p) + getRank(p) + " §3" + e.getPlayer().getName() + " §7»§f ";
                } else if (p.hasPermission("group." + "VIP")) {
                    msg = UtilsTags.getTag(p) + getRank(p) + " §e" + e.getPlayer().getName() + " §7»§f ";
                } else if (p.hasPermission("group." + "default")) {
                    msg = UtilsTags.getTag(p) + getRank(p) + " §7" + e.getPlayer().getName() + " §7»§f ";
                }

                TextComponent tc = new TextComponent(msg + text);
                tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§f§nInformations :\n§e\n§7Grade: " + getGroup(p) + "\n§7Argent: §f" + MoneyAPI.getMoney(p) + "\n§7Niveau d'île: §f" + level + "\n§7Temps de jeu: §f" + playerTime(p)).create()));
                e.setCancelled(true);
                System.out.println(p.getName() + " » " + text);

                for(Player op: Bukkit.getOnlinePlayers()){
                    if(!TOGGLE_CHAT.chatToggle.contains(op)){
                        op.spigot().sendMessage(tc);
                    }
                }
            }
            String[] msg1 = e.getMessage().split(" ");
            for(int i =0;i < msg1.length;i++){
                for(Player op: Bukkit.getOnlinePlayers()){
                    if(msg1[i].equals(op.getName()) && !msg1[i].equals(e.getPlayer().getName())){
                        op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§8§l» §6"+e.getPlayer().getName()+" §3vous a mentionné dans le chat §8§l«"));
                        op.playSound(op.getLocation(), Sound.ITEM_BOOK_PAGE_TURN, 100, 75);
                    }
                }
            }
        }
    }

    public String getGroup(Player player) {
        if(player.hasPermission("group." + "Crea") && player.getUniqueId().toString().equals("1ae5c22f-60cc-49ca-82ab-781f76777a78")){
            return "§c[§4Créateur§c]";
        }else if(player.hasPermission("group." + "Admin") && player.getUniqueId().toString().equals("0175ffd2-4dde-331f-ba34-ed38742f71a1")){
            return "§4[§cAdmin§4]";
        }else if(player.hasPermission("group." + "Dev") && player.getUniqueId().toString().equals("78f61460-e6af-41bd-8814-28d0ae833e19") || player.getUniqueId().toString().equals("77eaa601-45ba-3088-abb2-ee6c38bf3b17")){
            return "§d[§5Développeur§d]";
        }else if(player.hasPermission("group." + "Modo")){
            return "§8[§6§lModérateur§8]";
        }else if(player.hasPermission("group." + "Guide")){
            return "§8[§b§lGuide§8]";
        }else if(player.hasPermission("group." + "Partenaire")){
            return "§7[§ePartenaire§7]";
        }else if(player.hasPermission("group." + "Builder")){
            return "§2[§aBuilder§2]";
        }else if(player.hasPermission("group." + "MVP")){
            return "§8[§3§lMVP§8]";
        }else if(player.hasPermission("group." + "VIP")){
            return "§8[§e§lVIP§8]";
        }else if(player.hasPermission("group." + "default")){
            return "§8[§7Joueur§8]";
        }
        return "Null";
    }

    public String getRank(Player player) {
        if(player.hasPermission("perm.onerank")){
            return "§7[§fCitoyen§7]";
        }else if(player.hasPermission("perm.tworank")){
            return "§7[§fÉcuyer§7]";
        }else if(player.hasPermission("perm.threerank")){
            return "§7[§fChevalier§7]";
        }else if(player.hasPermission("perm.fourrank")){
            return "§7[§fCompte§7]";
        }else if(player.hasPermission("perm.fiverank")){
            return "§7[§fDuc§7]";
        }else if(player.hasPermission("perm.sixrank")){
            return "§7[§fPrince§7]";
        }
        return "§7[§fVoyageur§7]";
    }

    public String playerTime(Player p){
        int tick = p.getStatistic(Statistic.PLAY_ONE_MINUTE);
        int second = tick / 20;
        int minutes = 0;//tick  / (60*20);
        int hours = 0;//tick / (60*60*20);
        int day = 0;//tick / (24*60*60*20);
        while (second >= 60){
            second = second - 60;
            minutes++;
        }
        while (minutes > 60) {
            minutes = minutes - 60;
            hours++;
        }
        while (hours > 24) {
            hours = hours - 24;
            day++;
        }
        String time;
        if(minutes == 0){
            time = second+"§7s";
        }else if(minutes != 0 && hours == 0){
            time = minutes+"§7m§f"+second+"§7s";
        }else if(hours != 0 && day == 0){
            time = hours+"§7h§f"+minutes+"§7m";
        }else {
            time = day + "§7j§f" + hours + "§7h§f";
        }
        return time;
    }


    private String format(String msg){
        if(Bukkit.getVersion().contains("1.16")){
            Matcher match = pattern.matcher(msg);
            while (match.find()){
                String color = msg.substring(match.start(), match.end());
                msg = msg.replace(color, ChatColor.of(color) + "");
                match = pattern.matcher(msg);
            }
        }
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
