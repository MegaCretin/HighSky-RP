package fr.highsky.roleplay.Other.TopMoney;

import fr.herllox.hmoney.API.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Comparator;

public class ValueComparator implements Comparator<Player> {


    @Override
    public int compare(Player o1, Player o2) {
        return (int) (MoneyAPI.getMoney(o1) - MoneyAPI.getMoney(o2));
    }
}
