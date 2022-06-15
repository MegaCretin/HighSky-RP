package fr.highsky.roleplay.Gestion.Moderation.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BAN_UTILS {

    public static void ban(Player operator, Player Banned, String Reason){

        Banned.kickPlayer(MODERATION_MESSAGES_UTILS.kickBan(operator, Reason));
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "ban "+Banned.getName());
        Bukkit.broadcastMessage(MODERATION_MESSAGES_UTILS.Ban(operator, Banned, Reason));

    }

}
