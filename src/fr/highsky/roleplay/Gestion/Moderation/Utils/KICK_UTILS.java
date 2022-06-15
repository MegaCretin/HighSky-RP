package fr.highsky.roleplay.Gestion.Moderation.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class KICK_UTILS {

    public static void kick(Player operator, Player Banned, String reason){

        Banned.kickPlayer(MODERATION_MESSAGES_UTILS.kickPlayer(operator, reason));
        Bukkit.broadcastMessage(MODERATION_MESSAGES_UTILS.Kick(operator, Banned, reason));

    }

}
