package fr.highsky.roleplay.Commands.TempFly;

import fr.highsky.roleplay.Gestion.Moderation.Utils.TICK_UTILS;
import fr.highsky.roleplay.Commands.TempFly.Utils.TFLY_UTILS;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

public class TFLY_COMMAND implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            if(p.isOp()){
                if(TFLY_UTILS.useFly.contains(p)){
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.sendMessage("§B§LFLY §8§l» §aMode fly §edésactivé§a.");
                    TFLY_UTILS.useFly.remove(p);
                }else{
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage("§B§LFLY §8§l» §aMode fly §eactivé§a.");
                    TFLY_UTILS.useFly.add(p);
                }
            }else if(!p.isOp()) {
                if (TFLY_UTILS.useFly.contains(p)) {
                    long endFly = getFlyer(p).get(p.getUniqueId()).longValue();
                    long now = System.currentTimeMillis();
                    long diff = endFly - now;
                    if (diff <= 0L) {
                        getFlyer(p).remove(p);
                        if (TFLY_UTILS.tflyMVP.containsKey(p)) {
                            TFLY_UTILS.tflyMVP.remove(p);
                        } else if (TFLY_UTILS.tflyVIP.containsKey(p)) {
                            TFLY_UTILS.tflyVIP.remove(p);
                        } else if (TFLY_UTILS.tflyPlayer.containsKey(p)) {
                            TFLY_UTILS.tflyPlayer.remove(p);
                        }
                        p.sendMessage("§B§LFLY §8§l» §cVotre de temp de fly est désormais finie.");
                    } else {
                        p.sendMessage("§B§LFLY §8§l» §aTemps restant: §e" + TFLY_UTILS.getTime(endFly) + "§a.");
                    }

                } else {

                    if(!isFlyer(p)){


                        if (TFLY_UTILS.getRank(p).equals("MVP")) {
                            long endFly = System.currentTimeMillis() + TICK_UTILS.getTick("Heures", 2);
                            setFlyer(p, endFly);
                        } else if (TFLY_UTILS.getRank(p).equals("VIP")) {
                            long endFly = System.currentTimeMillis() + TICK_UTILS.getTick("Heures", 1);
                            TFLY_UTILS.tflyVIP.put(p.getUniqueId(), endFly);
                        }
                    }
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    TFLY_UTILS.useFly.add(p);
                    p.sendMessage("§B§LFLY §8§l» §aVotre fly est activé profités en sinon il sera perdu pour ajourd'hui.");

                }
            }
        }
        return false;
    }

    public Boolean isFlyer (Player p){
        if (TFLY_UTILS.getRank(p).equals("MVP") && TFLY_UTILS.tflyMVP.containsKey(p.getUniqueId())) {
            return true;
        } else if (TFLY_UTILS.getRank(p).equals("VIP") && TFLY_UTILS.tflyVIP.containsKey(p.getUniqueId())) {
            return true;
        } else if (TFLY_UTILS.getRank(p).equals("Player") && TFLY_UTILS.tflyPlayer.containsKey(p.getUniqueId())) {
            return true;
        }
        return false;
    }

    public HashMap<UUID, Long> getFlyer (Player p){
        if (TFLY_UTILS.getRank(p).equals("MVP") && TFLY_UTILS.tflyMVP.containsKey(p.getUniqueId())) {
            return TFLY_UTILS.tflyMVP;
        } else if (TFLY_UTILS.getRank(p).equals("VIP") && TFLY_UTILS.tflyVIP.containsKey(p.getUniqueId())) {
            return TFLY_UTILS.tflyVIP;
        } else if (TFLY_UTILS.getRank(p).equals("Player") && TFLY_UTILS.tflyPlayer.containsKey(p.getUniqueId())) {
            return TFLY_UTILS.tflyPlayer;
        }
        p.sendMessage("§B§LFLY §8§l» §cVous n'avez pas de §eFLY §cactivé.");
        return null;
    }

    public void setFlyer (Player p, Long delay){
        if (TFLY_UTILS.getRank(p).equals("MVP")) {
            TFLY_UTILS.tflyMVP.put(p.getUniqueId(), delay);
        } else if (TFLY_UTILS.getRank(p).equals("VIP")) {
            TFLY_UTILS.tflyVIP.put(p.getUniqueId(), delay);
        } else if (TFLY_UTILS.getRank(p).equals("Player")) {
            TFLY_UTILS.tflyPlayer.put(p.getUniqueId(), delay);
        }
    }

    public void removeFlyer (Player p){
        if (TFLY_UTILS.getRank(p).equals("MVP")) {
            TFLY_UTILS.tflyMVP.remove(p);
        } else if (TFLY_UTILS.getRank(p).equals("VIP")) {
            TFLY_UTILS.tflyVIP.remove(p);
        } else if (TFLY_UTILS.getRank(p).equals("Player")) {
            TFLY_UTILS.tflyPlayer.remove(p);
        }
    }

}
