package fr.highsky.roleplay.Other.TopMoney;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Main;
import net.citizensnpcs.api.CitizensAPI;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;


import java.util.*;


public class GetTop extends BukkitRunnable {
    
    private Main main;
    public GetTop(Main main){
        this.main = main;
    }

    @Deprecated
    public List<Map.Entry<String, Double>> getTop3(){
        Map<String, Double> playerBalances = new HashMap<String, Double>();
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (MoneyAPI.econ.hasAccount(onlinePlayer)) playerBalances.put(onlinePlayer.getName(), MoneyAPI.econ.getBalance(onlinePlayer.getName()));
        }
        for (OfflinePlayer offlinePlayer : Bukkit.getOfflinePlayers()) {
            if (offlinePlayer != null && offlinePlayer.getName() != null) { // I have a habit of checking for nulls, you don't need this I think.
                if (MoneyAPI.econ.hasAccount(offlinePlayer)) playerBalances.put(offlinePlayer.getName(), MoneyAPI.econ.getBalance(offlinePlayer));
            }
        }

        List<Map.Entry<String, Double>> playersBal = MapSorting.sortedValues(playerBalances);
        return playersBal;
    }

    @Deprecated
    public void getTop() {

        List<Map.Entry<String, Double>> playersBal = getTop3();

        for(int i = 0; i < 3;i++){
            if(CitizensAPI.getNPCRegistry().getById(i+12) == null){
                return;
            }else{
                CitizensAPI.getNPCRegistry().getById(i+12).setName(playersBal.get(playersBal.size() - i -1).getKey());
                //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hd setline "+ (i+1) +" 2 "+"§6"+ playersBal.get(playersBal.size() -i-1).getKey());
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hd setline "+ (i+1) +" 2 "+"§eMoney: §6"+ playersBal.get(playersBal.size() -i-1).getValue());
            }
        }
    }

    @Override
    @Deprecated
    public void run() {

        this.getTop();

    }

}
