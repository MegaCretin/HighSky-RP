package fr.highsky.roleplay.Events.Boxs.XPBoxs;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils.KEY;
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

public class XP_BOXS_PERCENT extends BukkitRunnable {

    private Boolean XP75;
    private Boolean XP150;
    private Boolean XP300;
    private Player p;
    private Inventory inv;
    private int time;

    public XP_BOXS_PERCENT(Boolean XP75, Boolean XP150, Boolean XP300, Player p, Inventory inv) {
        this.time = 0;
        this.XP75 = XP75;
        this.XP150 = XP150;
        this.XP300 = XP300;
        this.p = p;
        this.inv = inv;
    }

    @Override
    public void run() {
        time++;
        if (XP75) {
            if (time <= 15) getXP75Item(inv);
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
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("COMMUNE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.CommunKey(4));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("RARE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.RareKey(2));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("LEGENDAIRE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.LegKey(1));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("VIP") && inv.getItem(13).getType() == Material.TURTLE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " +p.getName() +" parent addtemp vip 14d");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("MVP") && inv.getItem(13).getType() == Material.NETHERITE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " +p.getName() +" parent addtemp mvp 7d");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP75"));
                    return;
                }

                p.getInventory().addItem(new ItemStack(inv.getItem(13)));
                p.updateInventory();
                for(Player op : Bukkit.getOnlinePlayers()) {
                    if(!op.getName().equalsIgnoreCase(p.getName())) {
                        op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, "§7"+inv.getItem(13).getType().toString(), "XP75")));
                    }
                }
                p.sendMessage(XP_BOXS_MESSAGE.winMess(p, "§7"+inv.getItem(13).getType().toString(), "XP75"));


            }
            if (time == 20) {
                cancel();
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_WANDERING_TRADER_YES, 100, 100);
            }

        }
        if (XP150) {
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
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP150")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP150"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("COMMUNE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.CommunKey(5));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP150")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP150"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("RARE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.RareKey(3));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP150")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP150"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("LEGENDAIRE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.LegKey(2));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP150")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP150"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("VIP") && inv.getItem(13).getType() == Material.TURTLE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " +p.getName() +" parent add vip");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("MVP") && inv.getItem(13).getType() == Material.NETHERITE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " +p.getName() +" parent addtemp mvp 14d");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "§b§lCOMMUNE"));
                    return;
                }

                p.getInventory().addItem(new ItemStack(inv.getItem(13)));
                p.updateInventory();
                for(Player op : Bukkit.getOnlinePlayers()) {
                    if(!op.getName().equalsIgnoreCase(p.getName())) {
                        op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, "§7"+inv.getItem(13).getType().toString(), "XP150")));
                    }
                }
                p.sendMessage(XP_BOXS_MESSAGE.winMess(p, "§7"+inv.getItem(13).getType().toString(), "XP150"));


            }
            if (time == 20) {
                cancel();
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_WANDERING_TRADER_YES, 100, 100);
            }

        }
        if (XP300) {
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
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("COMMUNE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.CommunKey(10));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("RARE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.RareKey(4));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("LEGENDAIRE") && inv.getItem(13).getType() == Material.TRIPWIRE_HOOK) {
                    p.getInventory().addItem(KEY.LegKey(3));
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("VIP") && inv.getItem(13).getType() == Material.TURTLE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add VIP");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300"));
                    return;
                }
                if (inv.getItem(13).hasItemMeta() && inv.getItem(13).getItemMeta().getDisplayName().contains("MVP") && inv.getItem(13).getType() == Material.NETHERITE_HELMET) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " parent add MVP");
                    for(Player op : Bukkit.getOnlinePlayers()) {
                        if(!op.getName().equalsIgnoreCase(p.getName())) {
                            op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300")));
                        }
                    }
                    p.sendMessage(XP_BOXS_MESSAGE.winMess(p, inv.getItem(13).getItemMeta().getDisplayName(), "XP300"));
                    return;
                }


                p.getInventory().addItem(new ItemStack(inv.getItem(13)));
                p.updateInventory();
                for(Player op : Bukkit.getOnlinePlayers()) {
                    if(!op.getName().equalsIgnoreCase(p.getName())) {
                        op.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(XP_BOXS_MESSAGE.winMess(p, "§7"+inv.getItem(13).getType().toString(), "XP300")));
                    }
                }
                p.sendMessage(XP_BOXS_MESSAGE.winMess(p, "§7"+inv.getItem(13).getType().toString(), "XP300"));

            }
            if (time == 20) {
                cancel();
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.ENTITY_WANDERING_TRADER_YES, 100, 100);
            }

        }
    }

    public void getXP75Item(Inventory inv) {
        Random rdm = new Random();
        int i = 0 + rdm.nextInt(1000 - 0);
        Double d = Double.valueOf(i);


        if (d <= 120) {
            ItemStack it = new ItemStack(Material.STONE, 16);
            inv.setItem(13, it);
        } else if (d > 120 && d < 240) {
            ItemStack it = new ItemStack(Material.GRASS_BLOCK, 8);
            inv.setItem(13, it);
        } else if (d > 240 && d < 360) {
            ItemStack it = new ItemStack(Material.OAK_LOG, 16);
            inv.setItem(13, it);
        } else if (d > 360 && d < 480) {
            ItemStack it = new ItemStack(Material.DIRT, 16);
            inv.setItem(13, it);
        } else if (d > 480 && d < 600) {
            ItemStack it = new ItemStack(Material.COBBLESTONE, 32);
            inv.setItem(13, it);
        } else if (d > 600 && d < 650) {
            ItemStack it = new ItemStack(Material.IRON_INGOT, 16);
            inv.setItem(13, it);
        } else if (d > 650 && d < 690) {
            ItemStack it = new ItemStack(Material.GOLD_INGOT, 8);
            inv.setItem(13, it);
        } else if (d > 690 && d < 720) {
            ItemStack it = new ItemStack(Material.DIAMOND, 4);
            inv.setItem(13, it);
        } else if (d > 720 && d < 730) {
            ItemStack it = new ItemStack(Material.ENDER_CHEST, 1);
            inv.setItem(13, it);
        } else if (d > 730 && d < 740) {
            ItemStack it = new ItemStack(Material.TURTLE_EGG, 1);
            inv.setItem(13, it);
        } else if (d > 740 && d < 800) {
            inv.setItem(13, addMoney(250));
        } else if (d > 800 && d < 850) {
            inv.setItem(13, addMoney(500));
        } else if (d > 850 && d < 890) {
            inv.setItem(13, addMoney(1000));
        } else if (d > 890 && d < 940) {
            ItemStack it = new ItemStack(Material.EXPERIENCE_BOTTLE, 16);
            inv.setItem(13, it);
        } else if (d > 940 && d < 990) {
            ItemStack it = new ItemStack(Material.SHEEP_SPAWN_EGG, 1);
            inv.setItem(13, it);
        } else if (d > 990 && d <= 1000) {
            inv.setItem(13, KEY.CommunKey(1));
        }

    }

    public void getWinRareItem(Inventory inv) {
        Random rdm = new Random();
        int i = 0 + rdm.nextInt(1000 - 0);
        Double d = Double.valueOf(i);


        if (d <= 120) {
            ItemStack it = new ItemStack(Material.STONE, 32);
            inv.setItem(13, it);
        } else if (d > 120 && d < 240) {
            ItemStack it = new ItemStack(Material.GRASS_BLOCK, 16);
            inv.setItem(13, it);
        } else if (d > 240 && d < 360) {
            ItemStack it = new ItemStack(Material.OAK_LOG, 32);
            inv.setItem(13, it);
        } else if (d > 360 && d < 480) {
            ItemStack it = new ItemStack(Material.DIRT, 32);
            inv.setItem(13, it);
        } else if (d > 480 && d < 600) {
            ItemStack it = new ItemStack(Material.COBBLESTONE, 64);
            inv.setItem(13, it);
        } else if (d > 600 && d < 650) {
            ItemStack it = new ItemStack(Material.IRON_INGOT, 32);
            inv.setItem(13, it);
        } else if (d > 650 && d < 690) {
            ItemStack it = new ItemStack(Material.GOLD_INGOT, 16);
            inv.setItem(13, it);
        } else if (d > 690 && d < 720) {
            ItemStack it = new ItemStack(Material.DIAMOND, 8);
            inv.setItem(13, it);
        } else if (d > 720 && d < 725) {
            ItemStack it = new ItemStack(Material.NETHERITE_SCRAP, 1);
            inv.setItem(13, it);
        } else if (d > 725 && d < 735) {
            ItemStack it = new ItemStack(Material.ENCHANTING_TABLE, 1);
            inv.setItem(13, it);
        } else if (d > 735 && d < 795) {
            inv.setItem(13, addMoney(500));
        } else if (d > 795 && d < 845) {
            inv.setItem(13, addMoney(1000));
        } else if (d > 845 && d < 885) {
            inv.setItem(13, addMoney(2000));
        } else if (d > 885 && d < 945) {
            ItemStack it = new ItemStack(Material.EXPERIENCE_BOTTLE, 32);
            inv.setItem(13, it);
        } else if (d > 945 && d < 995) {
            ItemStack it = new ItemStack(Material.COW_SPAWN_EGG, 1);
            inv.setItem(13, it);
        } else if (d > 995 && d <= 1000) {
            inv.setItem(13, KEY.RareKey(1));
        }

    }

    public void getWinLegItem(Inventory inv) {
        Random rdm = new Random();
        int i = 0 + rdm.nextInt(10000 - 0);
        Double d = Double.valueOf(i);


        if (d <= 130) {
            ItemStack it = new ItemStack(Material.STONE, 64);
            inv.setItem(13, it);
        } else if (d > 130 && d < 260) {
            ItemStack it = new ItemStack(Material.GRASS_BLOCK, 32);
            inv.setItem(13, it);
        } else if (d > 260 && d < 390) {
            ItemStack it = new ItemStack(Material.OAK_LOG, 64);
            inv.setItem(13, it);
        } else if (d > 390 && d < 520) {
            ItemStack it = new ItemStack(Material.DIRT, 64);
            inv.setItem(13, it);
        } else if (d > 520 && d < 580) {
            ItemStack it = new ItemStack(Material.IRON_INGOT, 64);
            inv.setItem(13, it);
        } else if (d > 580 && d < 630) {
            ItemStack it = new ItemStack(Material.GOLD_INGOT, 32);
            inv.setItem(13, it);
        } else if (d > 630 && d < 670) {
            ItemStack it = new ItemStack(Material.DIAMOND_BLOCK, 16);
            inv.setItem(13, it);
        } else if (d > 670 && d < 680) {
            ItemStack it = new ItemStack(Material.NETHERITE_SCRAP, 2);
            inv.setItem(13, it);
        } else if (d > 680 && d < 690) {
            ItemStack it = new ItemStack(Material.BEACON, 1);
            inv.setItem(13, it);
        } else if (d > 690 && d < 760) {
            inv.setItem(13, addMoney(2500));
        } else if (d > 760 && d < 820) {
            inv.setItem(13, addMoney(5000));
        } else if (d > 820 && d < 870) {
            inv.setItem(13, addMoney(7500));
        } else if (d > 870 && d < 940) {
            ItemStack it = new ItemStack(Material.EXPERIENCE_BOTTLE, 64);
            inv.setItem(13, it);
        } else if (d > 940 && d < 990) {
            ItemStack it = new ItemStack(Material.VILLAGER_SPAWN_EGG, 1);
            inv.setItem(13, it);
        } else if (d > 990 && d < 1000) {
            inv.setItem(13, KEY.LegKey(1));
        }

    }

    public ItemStack addMoney(int Amount) {

        ItemStack it = new ItemStack(Material.PAPER);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§e" + Amount + "§7$");
        it.setItemMeta(itx);
        return it;

    }

    public ItemStack addSellStick(int Use){
        ItemStack it = new ItemStack(Material.BLAZE_ROD);
        ItemMeta itx = it.getItemMeta();
        itx.setDisplayName("§6§lSellStick");
        itx.setLore(Arrays.asList("", "§f§lInformations:", "  §f➡ §eUtilisations: §a"+Use, "", "§7Vous pouvez vous procurez", "§7ce §6§lSellStick §7sur la", "§7boutique en ligne ou dans", "§7les boxs au spawn."));
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
