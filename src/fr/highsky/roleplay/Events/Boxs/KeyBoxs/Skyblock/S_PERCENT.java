package fr.highsky.roleplay.Events.Boxs.KeyBoxs.Skyblock;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils.KEY;
import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils.MESSAGES;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;
import java.util.Random;

public class S_PERCENT extends BukkitRunnable {

    private Boolean Commun;
    private Boolean Rare;
    private Boolean Leg;
    private Player p;
    private Inventory inv;
    private int time;

    public S_PERCENT(Boolean Commun, Boolean Rare, Boolean Leg, Player p, Inventory inv) {
        this.time = 0;
        this.Commun = Commun;
        this.Rare = Rare;
        this.Leg = Leg;
        this.p = p;
        this.inv = inv;
    }

    @Override
    public void run() {
        time++;
        if (Commun) {
            if (time <= 15) getWinCommunItem(inv);
            if (time == 1) {
                inv.setItem(10, redWin());
                inv.setItem(11, redWin());
                inv.setItem(12, redWin());
                inv.setItem(14, redWin());
                inv.setItem(15, redWin());
                inv.setItem(16, redWin());
                p.updateInventory();
            }
            if (time == 5) {
                inv.setItem(10, limeWin());
                inv.setItem(16, limeWin());
                p.updateInventory();
            }
            if (time == 9) {
                inv.setItem(11, limeWin());
                inv.setItem(15, limeWin());
                p.updateInventory();
            }
            if (time == 13) {
                inv.setItem(12, limeWin());
                inv.setItem(14, limeWin());
                p.updateInventory();
            }
            if (time == 17) {
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("§7$") && inv.getItem(13).getType() == Material.PAPER) {
                    String name = inv.getItem(13).getItemMeta().getDisplayName().replace("§e", "").replace("§7$", "").replace(" ", "");
                    MoneyAPI.giveMoney(p, Double.valueOf(name));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("COMMUNE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.CommunKey(4));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("RARE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.RareKey(2));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("LEGENDAIRE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.LegKey(1));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("VIP") && inv.getItem(13).getType() == Material.TURTLE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " +p.getName() +" parent addtemp vip 14d");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("MVP") && inv.getItem(13).getType() == Material.NETHERITE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " +p.getName() +" parent addtemp mvp 7d");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE"));
                    return;
                }

                p.getInventory().addItem(new ItemStack(inv.getItem(13)));
                p.updateInventory();
                for(Player op : Bukkit.getOnlinePlayers()) {
                    if(!op.getName().equalsIgnoreCase(p.getName())) {
                        op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, "§7"+inv.getItem(13).getType().toString(), "§b§lCOMMUNE")));
                    }
                }
                p.sendMessage(MESSAGES.winMess(p, "§7"+inv.getItem(13).getType().toString(), "§b§lCOMMUNE"));


            }
            if (time == 20) {
                cancel();
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_WANDERING_TRADER_YES, 100, 100);
            }

        }
        if (Rare) {
            if (time <= 15) getWinRareItem(inv);
            if (time == 1) {
                inv.setItem(10, redWin());
                inv.setItem(11, redWin());
                inv.setItem(12, redWin());
                inv.setItem(14, redWin());
                inv.setItem(15, redWin());
                inv.setItem(16, redWin());
                p.updateInventory();
            }
            if (time == 5) {
                inv.setItem(10, limeWin());
                inv.setItem(16, limeWin());
                p.updateInventory();
            }
            if (time == 9) {
                inv.setItem(11, limeWin());
                inv.setItem(15, limeWin());
                p.updateInventory();
            }
            if (time == 13) {
                inv.setItem(12, limeWin());
                inv.setItem(14, limeWin());
                p.updateInventory();
            }
            if (time == 17) {
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("§7$") && inv.getItem(13).getType() == Material.PAPER) {
                    String name = inv.getItem(13).getItemMeta().getDisplayName().replace("§e", "").replace("§7$", "").replace(" ", "");
                    MoneyAPI.giveMoney(p, Double.valueOf(name));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§c§lRARE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§c§lRARE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("COMMUNE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.CommunKey(5));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§c§lRARE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§c§lRARE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("RARE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.RareKey(3));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§c§lRARE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§c§lRARE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("LEGENDAIRE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.LegKey(2));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§c§lRARE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§c§lRARE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("VIP") && inv.getItem(13).getType() == Material.TURTLE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " +p.getName() +" parent add vip");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("MVP") && inv.getItem(13).getType() == Material.NETHERITE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " +p.getName() +" parent addtemp mvp 14d");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE"));
                    return;
                }

                p.getInventory().addItem(new ItemStack(inv.getItem(13)));
                p.updateInventory();
                for(Player op : Bukkit.getOnlinePlayers()) {
                    if(!op.getName().equalsIgnoreCase(p.getName())) {
                        op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, "§7"+inv.getItem(13).getType().toString(), "§c§lRARE")));
                    }
                }
                p.sendMessage(MESSAGES.winMess(p, "§7"+inv.getItem(13).getType().toString(), "§c§lRARE"));


            }
            if (time == 20) {
                cancel();
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_WANDERING_TRADER_YES, 100, 100);
            }

        }
        if (Leg) {
            if (time <= 15) getWinLegItem(inv);
            if (time == 1) {
                inv.setItem(10, redWin());
                inv.setItem(11, redWin());
                inv.setItem(12, redWin());
                inv.setItem(14, redWin());
                inv.setItem(15, redWin());
                inv.setItem(16, redWin());
                p.updateInventory();
            }
            if (time == 5) {
                inv.setItem(10, limeWin());
                inv.setItem(16, limeWin());
                p.updateInventory();
            }
            if (time == 9) {
                inv.setItem(11, limeWin());
                inv.setItem(15, limeWin());
                p.updateInventory();
            }
            if (time == 13) {
                inv.setItem(12, limeWin());
                inv.setItem(14, limeWin());
                p.updateInventory();
            }
            if (time == 17) {
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("§7$") && inv.getItem(13).getType() == Material.PAPER) {
                    String name = inv.getItem(13).getItemMeta().getDisplayName().replace("§e", "").replace("§7$", "").replace(" ", "");
                    MoneyAPI.giveMoney(p, Double.valueOf(name));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("COMMUNE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.CommunKey(10));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("RARE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.RareKey(4));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("LEGENDAIRE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.LegKey(3));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("VIP") && inv.getItem(13).getType() == Material.TURTLE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add VIP");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("MVP") && inv.getItem(13).getType() == Material.NETHERITE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add MVP");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE")));
                        }
                    }
                    p.sendMessage(MESSAGES.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§6§lLEGENDAIRE"));
                    return;
                }


                p.getInventory().addItem(new ItemStack(inv.getItem(13)));
                p.updateInventory();
                for(Player op : Bukkit.getOnlinePlayers()) {
                    if(!op.getName().equalsIgnoreCase(p.getName())) {
                        op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(MESSAGES.winMess(p, "§7"+inv.getItem(13).getType().toString(), "§6§lLEGENDAIRE")));
                    }
                }
                p.sendMessage(MESSAGES.winMess(p, "§7"+inv.getItem(13).getType().toString(), "§6§lLEGENDAIRE"));

            }
            if (time == 20) {
                cancel();
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_WANDERING_TRADER_YES, 100, 100);
            }

        }
    }

    public void getWinCommunItem(Inventory inv) {
        Random rdm = new Random();
        int i = 0 + rdm.nextInt(10000 - 0);
        Double d = Double.valueOf(i);


        if (d <= 1694) {
            ItemStack it = new ItemStack(Material.STONE, 32);
            inv.setItem(13, it);
        } else if (d > 1694 && d < 3394) {
            ItemStack it = new ItemStack(Material.GRASS_BLOCK, 32);
            inv.setItem(13, it);
        } else if (d > 3394 && d < 5044) {
            ItemStack it = new ItemStack(Material.OAK_LOG, 32);
            inv.setItem(13, it);
        } else if (d > 5044 && d < 5844) {
            ItemStack it = new ItemStack(Material.BOOKSHELF, 8);
            inv.setItem(13, it);
        } else if (d > 5844 && d < 6444) {
            ItemStack it = new ItemStack(Material.IRON_BLOCK, 4);
            inv.setItem(13, it);
        } else if (d > 6444 && d < 6844) {
            ItemStack it = new ItemStack(Material.GOLD_BLOCK, 3);
            inv.setItem(13, it);
        } else if (d > 6844 && d < 7044) {
            ItemStack it = new ItemStack(Material.DIAMOND_BLOCK, 2);
            inv.setItem(13, it);
        } else if (d > 7044 && d < 7144) {
            ItemStack it = new ItemStack(Material.EMERALD_BLOCK, 1);
            inv.setItem(13, it);
        } else if (d > 7144 && d < 7244) {
            ItemStack it = new ItemStack(Material.COW_SPAWN_EGG, 1);
            inv.setItem(13, it);
        } else if (d > 7244 && d < 7944) {
            inv.setItem(13, addMoney(500));
        } else if (d > 7944 && d < 8444) {
            inv.setItem(13, addMoney(1000));
        } else if (d > 8444 && d < 8744) {
            inv.setItem(13, addMoney(2500));
        } else if (d > 8744 && d < 9244) {
            inv.setItem(13, addSellStick(150, 1.0));
        } else if (d > 9244 && d < 9744) {
            inv.setItem(13, KEY.CommunKey(4));
        } else if (d > 9744 && d < 9944) {
            inv.setItem(13, KEY.RareKey(2));
        } else if (d > 9944 && d <= 9994) {
            inv.setItem(13, KEY.LegKey(1));
        } else if (d > 9994 && d <= 9999) {
            inv.setItem(13, addVIP());
        } else if (d > 9999 && d <= 10000) {
            inv.setItem(13, addMVP());
        }

    }


    public void getWinRareItem(Inventory inv) {
        Random rdm = new Random();
        int i = 0 + rdm.nextInt(10000 - 0);
        Double d = Double.valueOf(i);


        if (d <= 1638) {
            ItemStack it = new ItemStack(Material.STONE, 64);
            inv.setItem(13, it);
        } else if (d > 1638 && d < 3238) {
            ItemStack it = new ItemStack(Material.GRASS_BLOCK, 64);
            inv.setItem(13, it);
        } else if (d > 3238 && d < 4938) {
            ItemStack it = new ItemStack(Material.OAK_LOG, 64);
            inv.setItem(13, it);
        } else if (d > 4938 && d < 5738) {
            ItemStack it = new ItemStack(Material.IRON_BLOCK, 8);
            inv.setItem(13, it);
        } else if (d > 5738 && d < 6338) {
            ItemStack it = new ItemStack(Material.GOLD_BLOCK, 6);
            inv.setItem(13, it);
        } else if (d > 6338 && d < 6838) {
            ItemStack it = new ItemStack(Material.DIAMOND_BLOCK, 4);
            inv.setItem(13, it);
        } else if (d > 6838 && d < 7038) {
            ItemStack it = new ItemStack(Material.EMERALD_BLOCK, 2);
            inv.setItem(13, it);
        } else if (d > 7038 && d < 7088) {
            ItemStack it = new ItemStack(Material.NETHERITE_SCRAP, 1);
            inv.setItem(13, it);
        } else if (d > 7088 && d < 7288) {
            ItemStack it = new ItemStack(Material.VILLAGER_SPAWN_EGG, 1);
            inv.setItem(13, it);
        } else if (d > 7288 && d < 7838) {
            inv.setItem(13, addMoney(5000));
        } else if (d > 7838 && d < 8338) {
            inv.setItem(13, addMoney(7500));
        } else if (d > 8338 && d < 8638) {
            inv.setItem(13, addMoney(10000));
        } else if (d > 8638 && d < 9238) {
            inv.setItem(13, addSellStick(250, 1.25));
        } else if (d > 9238 && d < 9738) {
            inv.setItem(13, KEY.CommunKey(5));
        } else if (d > 9738 && d < 9938) {
            inv.setItem(13, KEY.RareKey(3));
        } else if (d > 9938 && d <= 9988) {
            inv.setItem(13, KEY.LegKey(2));
        } else if (d > 9988 && d <= 9996) {
            inv.setItem(13, addVIP());
        } else if (d > 9996 && d <= 10000) {
            inv.setItem(13, addMVP());
        }

    }

    public void getWinLegItem(Inventory inv) {
        Random rdm = new Random();
        int i = 0 + rdm.nextInt(10000 - 0);
        Double d = Double.valueOf(i);


        if (d <= 1500) {
            ItemStack it = new ItemStack(Material.GRASS_BLOCK, 64);
            inv.setItem(13, it);
        } else if (d > 1500 && d < 3000) {
            ItemStack it = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
            inv.setItem(13, it);
        } else if (d > 3000 && d < 3300) {
            ItemStack it = new ItemStack(Material.BEACON, 1);
            inv.setItem(13, it);
        } else if (d > 3300 && d < 4300) {
            ItemStack it = new ItemStack(Material.IRON_BLOCK, 16);
            inv.setItem(13, it);
        } else if (d > 4300 && d < 5100) {
            ItemStack it = new ItemStack(Material.GOLD_BLOCK, 12);
            inv.setItem(13, it);
        } else if (d > 5100 && d < 5700) {
            ItemStack it = new ItemStack(Material.DIAMOND_BLOCK, 8);
            inv.setItem(13, it);
        } else if (d > 5700 && d < 6100) {
            ItemStack it = new ItemStack(Material.EMERALD_BLOCK, 4);
            inv.setItem(13, it);
        } else if (d > 6100 && d < 6150) {
            ItemStack it = new ItemStack(Material.NETHERITE_INGOT, 1);
            inv.setItem(13, it);
        } else if (d > 6150 && d < 7000) {
            ItemStack it = new ItemStack(Material.VILLAGER_SPAWN_EGG, 2);
            inv.setItem(13, it);
        } else if (d > 7000 && d < 7600) {
            inv.setItem(13, addMoney(10000));
        } else if (d > 7600 && d < 8100) {
            inv.setItem(13, addMoney(15000));
        } else if (d > 8100 && d < 8400) {
            inv.setItem(13, addMoney(20000));
        } else if (d > 8400 && d < 9000) {
            inv.setItem(13, addSellStick(750, 1.5));
        } else if (d > 9000 && d < 9713) {
            inv.setItem(13, KEY.CommunKey(10));
        } else if (d > 9713 && d < 9933) {
            inv.setItem(13, KEY.RareKey(4));
        } else if (d > 9933 && d <= 9983) {
            inv.setItem(13, KEY.LegKey(2));
        } else if (d > 9983 && d <= 9993) {
            inv.setItem(13, addVIP());
        } else if (d > 9993 && d <= 10000) {
            inv.setItem(13, addMVP());
        }

    }

    public ItemStack addMoney(int Amount) {

        ItemStack it = new ItemStack(Material.PAPER);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§e" + Amount + "§7$");
        it.setItemMeta(itx);
        return it;

    }

    public ItemStack addSellStick(int Use, Double Mult){
        ItemStack it = new ItemStack(Material.BLAZE_ROD);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§6§lSellStick");
        itx.setLore(Arrays.asList("", "§f§lInformations:", "  §f➡ §eUtilisations: §a" + Use, "  §f➡ §eMultiplicateur: §a"+Mult, "", "§7Vous pouvez vous procurer ce ", "§6§lSellStick §7sur la boutique en ligne", "§7ou dans les boxs au spawn."));
        itx.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        it.setItemMeta(itx);

        return it;
    }

    public ItemStack addFramgent(int Amount){
        ItemStack it = new ItemStack(Material.IRON_NUGGET, Amount);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§e§lFragment");
        itx.setLore(Arrays.asList("","§f§lInformation:","  §7Ce §e§lFragment §7est utilisable","  §7pour acheter certaines choses","  §7plus ou moins rares, alors ne les","  §7gâcher pas."));
        itx.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        itx.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        it.setItemMeta(itx);

        return it;
    }

    public ItemStack redWin() {

        ItemStack it = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("");
        it.setItemMeta(itx);
        return it;

    }

    public ItemStack limeWin() {

        ItemStack it = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("");
        it.setItemMeta(itx);
        return it;

    }

    public ItemStack addVIP() {

        ItemStack it = new ItemStack(Material.TURTLE_HELMET);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§7Grade §eVIP");
        it.setItemMeta(itx);
        return it;

    }

    public ItemStack addMVP() {

        ItemStack it = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§7Grade §5MVP");
        it.setItemMeta(itx);
        return it;

    }
}