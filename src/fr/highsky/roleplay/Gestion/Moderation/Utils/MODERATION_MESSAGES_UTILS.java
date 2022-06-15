package fr.highsky.roleplay.Gestion.Moderation.Utils;

import org.bukkit.entity.Player;

public class MODERATION_MESSAGES_UTILS {

    public static String tempBan(Player operator, Player banned, String reason, Long delay){
        return "§6§lH§b§lS §8§l» §e"+ banned.getName() +" §ca été bannis§e"+getTime(delay)+" §cpar §e"+operator.getName()+"§c. §7("+reason+")";
    }

    public static String unBan(Player operator, String banned){
        return "§6§lH§b§lS §8§l» §e"+ banned +" §ca été débannis par §e"+operator.getName()+"§c.";
    }

    public static String kicktempBan(Player op, String reason, Long delay){
        return "§6§lH§b§lS\n\n§7Vous êtes temporairement bannis\n\n§cOpérateur: §e"+op.getName()+"\n§cRaison: §e"+reason+"\n§cPendant:§e"+getTime(delay)+"\n\n§7Discord: https://discord.gg/WwgaqUa";
    }

    public static String joinkicktempBan(Long delay){
        return "§6§lH§b§lS\n\n§7Vous êtes temporairement bannis\n\n§cTemps restant:§e"+getTime(delay)+"\n\n§7Discord: https://discord.gg/WwgaqUa";
    }

    public static String Ban(Player operator, Player banned, String reason){
        return "§6§lH§b§lS §8§l» §e"+ banned.getName() +" §ca été bannis par §e"+operator.getName()+"§c. §7("+reason+")";
    }

    public static String kickBan(Player op, String reason){
        return "§6§lH§b§lS\n\n§7Vous êtes bannis\n\n§cOpérateur: §e"+op.getName()+"\n§cRaison: §e"+reason+"\n\n§7Discord: https://discord.gg/WwgaqUa";
    }

    public static String joinkickBan(){
        return "§6§lH§b§lS\n\n§7Vous êtes bannis\n\n§7Discord: https://discord.gg/WwgaqUa";
    }

    public static String Kick(Player operator, Player kicked, String reason){
        return "§6§lH§b§lS §8§l» §e"+ kicked.getName() +" §ca été explusé par §e"+operator.getName()+"§c. §7("+reason+")";
    }

    public static String kickPlayer(Player op,String reason){
        return "§6§lH§b§lS\n\n§7Vous avez été kick\n\n§cOpérateur: §e"+op.getName()+"\n§cRaison: §e"+reason+"\n\n§7Discord: https://discord.gg/WwgaqUa";
    }


    public static String tempMute(Player operator, Player banned, String reason, Long delay){
        return "§6§lH§b§lS §8§l» §e"+ banned.getName() +" §ca été mute§e"+getTime(delay)+" §cpar §e"+operator.getName()+"§c. §7("+reason+")";
    }

    public static String unMute(Player operator, String banned){
        return "§6§lH§b§lS §8§l» §e"+ banned +" §ca été unmute par §e"+operator.getName()+"§c.";
    }
    
    public static String speaktempMute(Long delay){
        return "§6§lH§b§lS §8§l» §cVous êtes actuellement mute. (Temps restant: §e"+getTime(delay)+"§c)";
    }

    public static String getTime(long endBan){
        String msg = "";
        long now = System.currentTimeMillis();
        long diff = endBan - now;
        int second = (int) (diff/1000L);
        if(second >= 86400){
            int days = second / 86400;
            second %= 86400;
            msg = msg+ days+" Jour(s)";
        }
        if(second >= 3600){
            int hours = second /3600;
            second %= 3600;
            msg = msg+ hours+" Heure(s)";
        }
        if(second >= 60){
            int min = second/60;
            second %= 60;
            msg = msg+ min+" Minute(s)";
        }
        if(second >= 0){
            msg = msg+ second+" Seconde(s)";
        }
        return " "+msg;
    }

}
