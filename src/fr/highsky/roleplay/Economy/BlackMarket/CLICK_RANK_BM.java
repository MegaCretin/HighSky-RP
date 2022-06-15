package fr.highsky.roleplay.Economy.BlackMarket;

import fr.herllox.hmoney.API.MoneyAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CLICK_RANK_BM implements Listener {

    @EventHandler
    public void buyRank(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§5Marché noir §8§l» §3§lGrades")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;

            }
            switch (e.getCurrentItem().getType()) {
                case CHAINMAIL_HELMET:
                    if (!p.hasPermission("perm.onerank")) {
                        if (MoneyAPI.getMoney(p) >= 100000.00) {
                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add GradeOne");
                            MoneyAPI.removeMoney(p, 100000.00);
                            p.sendMessage("§a§lGRADES §8§l» §aVous avez acheté le §eGrade 1§a pour §e100000$.");
                        } else {
                            p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                        }
                    } else {
                        p.sendMessage("§f§k§lMichel §8§l» §cTu l'as déjà.");
                    }
                    break;
                case LEATHER_HELMET:
                    if (!p.hasPermission("perm.tworank")) {
                        if (p.hasPermission("perm.onerank")) {
                            if (MoneyAPI.getMoney(p) >= 250000.00) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add GradeTwo");
                                MoneyAPI.removeMoney(p, 250000.00);
                                p.sendMessage("§a§lGRADES §8§l» §aVous avez acheté le §eGrade 2§a pour §e250000$.");
                            } else {
                                p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                            }
                        } else {
                            p.sendMessage("§a§lGRADES §8§l» §cVous devez avoir le §eGrade§c.");
                        }
                    } else {
                        p.sendMessage("§f§k§lMichel §8§l» §cTu l'as déjà.");
                    }
                    break;
                case IRON_HELMET:
                    if (!p.hasPermission("perm.threerank")) {
                        if (p.hasPermission("perm.tworank")) {
                            if (MoneyAPI.getMoney(p) >= 650000.00) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add GradeThree");
                                MoneyAPI.removeMoney(p, 650000.00);
                                p.sendMessage("§a§lGRADES §8§l» §aVous avez acheté le §eGrade 3§a pour §e650000$.");
                            } else {
                                p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                            }
                        } else {
                            p.sendMessage("§a§lGRADES §8§l» §cVous devez avoir le §eGrade§c.");
                        }
                    } else {
                        p.sendMessage("§f§k§lMichel §8§l» §cTu l'as déjà.");
                    }
                    break;
                case GOLDEN_HELMET:
                    if (!p.hasPermission("perm.fourrank")) {
                        if (p.hasPermission("perm.threerank")) {
                            if (MoneyAPI.getMoney(p) >= 1000000.00) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add GradeFour");
                                MoneyAPI.removeMoney(p, 1000000.00);
                                p.sendMessage("§a§lGRADES §8§l» §aVous avez acheté le §eGrade 4§a pour §e1000000$.");
                            } else {
                                p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                            }
                        } else {
                            p.sendMessage("§a§lGRADES §8§l» §cVous devez avoir le §eGrade§c.");
                        }
                    } else {
                        p.sendMessage("§f§k§lMichel §8§l» §cTu l'as déjà.");
                    }
                    break;
                case DIAMOND_HELMET:
                    if (!p.hasPermission("perm.fiverank")) {
                        if (p.hasPermission("perm.fourrank")) {
                            if (MoneyAPI.getMoney(p) >= 2000000.00) {
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add GradeFive");
                                MoneyAPI.removeMoney(p, 2000000.00);
                                p.sendMessage("§a§lGRADES §8§l» §aVous avez acheté le §eGrade 5§a pour §e2000000$.");
                            } else {
                                p.sendMessage("§f§k§lMichel §8§l» §cTu n'as pas assez d'agent bouge de là !");
                            }
                        } else {
                            p.sendMessage("§a§lGRADES §8§l» §cVous devez avoir le §eGrade§c.");
                        }
                    } else {
                        p.sendMessage("§f§k§lMichel §8§l» §cTu l'as déjà.");
                    }
                    break;
                case BARRIER:
                    p.closeInventory();
                    p.openInventory(BM_INVENTORY.BMInventory());
                    break;
                case BLACK_STAINED_GLASS_PANE:
                    break;
                default:
                    break;
            }
        }
    }

}
