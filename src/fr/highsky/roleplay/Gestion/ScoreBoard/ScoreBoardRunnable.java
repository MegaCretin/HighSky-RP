package fr.highsky.roleplay.Gestion.ScoreBoard;

import com.songoda.skyblock.api.SkyBlockAPI;
import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;


public class ScoreBoardRunnable extends BukkitRunnable {

    public String getGroup(Player player) {
        if(player.hasPermission("group." + "Crea")){
            return "§4Créateur";
        }else if(player.hasPermission("group." + "Admin")){
            return "§cAdmin";
        }else if(player.hasPermission("group." + "Dev")){
            return "§dDev";
        }else if(player.hasPermission("group." + "Modo")){
            return "§6Modo";
        }else if(player.hasPermission("group." + "Guide")){
            return "§bGuide";
        }else if(player.hasPermission("group." + "Partenaire")){
            return "§ePartenaire";
        }else if(player.hasPermission("group." + "MVP")){
            return "§3MVP";
        }else if(player.hasPermission("group." + "VIP")){
            return "§eVIP";
        }else if(player.hasPermission("group." + "default")){
            return "§7Joueur";
        }
        return "Null";
    }

    @Override
    public void run() {

        for(Player p : Bukkit.getOnlinePlayers()) {

            if(DISABLE_SCOREBOARD.scoreboard.contains(p))return;

            ScoreboardManager sb = Bukkit.getScoreboardManager();
            Scoreboard sc = sb.getNewScoreboard();

            int co = Bukkit.getOnlinePlayers().size();
            int voteparty = Main.getInstance().getConfig().getInt("VoteParty");
            int shopparty = Main.getInstance().getConfig().getInt("ShopParty");
            int time = p.getStatistic(Statistic.PLAY_ONE_MINUTE) / 60;

            long level;
            if(!SkyBlockAPI.getIslandManager().getIsland(p).isLoaded()){
                level = 0;
            }else{
                level = SkyBlockAPI.getIslandManager().getIsland(p).getLevel().getLevel();
            }

            Objective ob = sc.registerNewObjective("title","dummy","demmy");
            ob.setDisplaySlot(DisplaySlot.SIDEBAR);
            ob.setDisplayName("§6§lHigh§b§lSky");

            Score s = ob.getScore("§7┏━━━ §f§nInformations§r§7 ━━━");
            Score s1 = ob.getScore("§7┃§a");
            Score s2 = ob.getScore("§7┃  §e▪ §aGrade§f: "+getGroup(p));
            Score s3 = ob.getScore("§7┃  §e▪ §aConnectés§f: §e"+ co);
            Score s4 = ob.getScore("§7┃  §e▪ §aPlayTime§f: §e"+ playerTime(p));
            Score s5 = ob.getScore("§7┃§b");
            Score s6 = ob.getScore("§7┣━━━━━━━━ §b§nIle§r§7 ━━━━━━━━");
            Score s7 = ob.getScore("§7┃§e");
            Score s8 = ob.getScore("§7┃  §e▪ §aRôle§f: §e" + getRole(p));
            Score s9 = ob.getScore("§7┃  §e▪ §aNiveau§f: §e"+ level);
            Score s10 = ob.getScore("§7┃  §e▪ §aArgent§f: §e"+ MoneyAPI.getMoney(p));
            Score s11 = ob.getScore("§7┃§0");
            Score s12 = ob.getScore("§7┗━ §6VoteParty§f(§e"+voteparty+"§f/§750§f) §7━");



            s.setScore(15);
            s1.setScore(14);
            s2.setScore(13);
            s3.setScore(12);
            s4.setScore(11);
            s5.setScore(10);
            s6.setScore(9);
            s7.setScore(8);
            s8.setScore(7);
            s9.setScore(6);
            s10.setScore(5);
            s11.setScore(4);
            s12.setScore(3);

            /*Score s = ob.getScore("§fInformations :");
            Score s1 = ob.getScore(" §f- §aGrade : " +getGroup(p));
            Score s2 = ob.getScore(" §f- §aConnectés : §e" + co);
            Score s3 = ob.getScore(" §f- §aVote Party : §e" + voteparty +"§7/§f50");
            Score s4 = ob.getScore(" §f- §aShop Party : §e" + shopparty +"§7/§f75");
            Score s5 = ob.getScore(" §f- §aTemps de Jeu :§e " + playerTime(p) +"");
            Score s6 = ob.getScore(" ");
            Score s7 = ob.getScore("§6Statistiques :");
            Score s8 = ob.getScore(" §f- §aMoney : §e" + MoneyAPI.getMoney(p) + "§6$");
            Score s9 = ob.getScore(" §f- §aMorts : §e" + p.getStatistic(Statistic.DEATHS));
            Score s10 = ob.getScore("§e");
            Score s11 = ob.getScore("§bIle :");
            Score s12 = ob.getScore(" §f- §aRôle :§e " + getRole(p));
            Score s13 = ob.getScore(" §f- §aNiveau : §e" + level);
            Score s14 = ob.getScore("§e ");
            Score s15 = ob.getScore("       §fPlay.§6High§bSky§f.fr");*/
            //s13.setScore(2);
            //s14.setScore(1);
            //s15.setScore(0);



            p.setScoreboard(sc);
        }
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
            time = second+"§as";
        }else if(minutes != 0 && hours == 0){
            time = minutes+"§am§e"+second+"§as";
        }else if(hours != 0 && day == 0){
            time = hours+"§ah§e"+minutes+"§am";
        }else {
            time = day + "§aj§e" + hours + "§ah§e";
        }
        return time;
    }

    public String getRole(Player p){
        String role = "";
        if(SkyBlockAPI.getIslandManager().getIsland(p).isLoaded() == false){
            role = "Pas d'île";
        } else if(SkyBlockAPI.getIslandManager().getIsland(p).getRole(p).toString().equalsIgnoreCase("OWNER")){
            role = "Chef";
        }else if(SkyBlockAPI.getIslandManager().getIsland(p).getRole(p).toString().equalsIgnoreCase("OPERATOR")){
            role = "Opérateur";
        }else if(SkyBlockAPI.getIslandManager().getIsland(p).getRole(p).toString().equalsIgnoreCase("MEMBER")){
            role = "Membre";
        }
        return role;
    }

}
