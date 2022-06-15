package fr.highsky.roleplay.Gestion.Mine.commands;


import fr.highsky.roleplay.Gestion.Mine.utils.MINE_ORE_AMOUNT;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Random;

public class MineCommand implements CommandExecutor {

    private ArrayList<Location> Blocks = new ArrayList<>();
    private int minX = 117;
    private int maxX = 228;
    private int minY = 160;
    private int maxY = 255;
    private int minZ = -200;
    private int maxZ = -81;
    boolean boucle;

    @Override
    public boolean onCommand(CommandSender p, Command command, String s, String[] strings) {

        boucle = true;
        ArrayList<Location> StoneLoc = new ArrayList<>();
        int bb =0;
        for(int x = minX; x < maxX; x++){
            for (int y = minY; y < maxY; y++) {
                for (int z = minZ; z < maxZ; z++) {

                    Location loc = new Location(Bukkit.getWorld("Mine"), x,y,z);
                    Block b = loc.getBlock();
                    if (b.getType() != null && (b.getType() == Material.STONE || b.getType() == Material.BEDROCK)) {
                        StoneLoc.add(b.getLocation());
                        bb++;
                    }
                }
            }
        }

        Bukkit.broadcastMessage(bb+"");
        if(StoneLoc.size() >0) {
            for (int ia=0; ia< StoneLoc.size(); ia++) {
                Block b = StoneLoc.get(ia).getBlock();
                if (StoneLoc.get(ia).getY() > 210) {
                    Random rdm = new Random();
                    int i = rdm.nextInt(100);

                    if (i <= 15 && MINE_ORE_AMOUNT.COAL < 1000) {
                        b.setType(Material.COAL_ORE);
                        MINE_ORE_AMOUNT.COAL++;
                    } else if (i > 15 && i <= 20 && MINE_ORE_AMOUNT.IRON < 300) {
                        b.setType(Material.IRON_ORE);
                        MINE_ORE_AMOUNT.IRON++;
                    }
                } else if (StoneLoc.get(ia).getY() < 210 && StoneLoc.get(ia).getY() > 198) {
                    Random rdm = new Random();
                    int i = rdm.nextInt(100);

                    if (i <= 20 && MINE_ORE_AMOUNT.COAL < 1250) {
                        b.setType(Material.COAL_ORE);
                        MINE_ORE_AMOUNT.COAL++;
                    } else if (i > 20 && i <= 30 && MINE_ORE_AMOUNT.IRON < 400) {
                        b.setType(Material.IRON_ORE);
                        MINE_ORE_AMOUNT.IRON++;
                    } else if (i > 30 && i <= 35 && MINE_ORE_AMOUNT.GOLD < 200) {
                        b.setType(Material.GOLD_ORE);
                        MINE_ORE_AMOUNT.GOLD++;
                    }
                } else if (StoneLoc.get(ia).getY() < 198 && StoneLoc.get(ia).getY() > 180) {
                    if ((StoneLoc.get(ia).getX() < 176 && StoneLoc.get(ia).getX() > 120) && (StoneLoc.get(ia).getZ() < -165 && StoneLoc.get(ia).getZ() > -115)) {
                        Random rdm = new Random();
                        int i = rdm.nextInt(100);

                        if (i <= 20 && MINE_ORE_AMOUNT.COAL < 1300) {
                            b.setType(Material.COAL_ORE);
                            MINE_ORE_AMOUNT.COAL++;
                        } else if (i > 20 && i <= 30 && MINE_ORE_AMOUNT.IRON < 500) {
                            b.setType(Material.IRON_ORE);
                            MINE_ORE_AMOUNT.IRON++;
                        } else if (i > 30 && i <= 35 && MINE_ORE_AMOUNT.REDSTONE < 125) {
                            b.setType(Material.REDSTONE_ORE);
                            MINE_ORE_AMOUNT.REDSTONE++;
                        } else if (i > 35 && i <= 50 && MINE_ORE_AMOUNT.GOLD < 250) {
                            b.setType(Material.GOLD_ORE);
                            MINE_ORE_AMOUNT.GOLD++;
                        }
                    } else if ((StoneLoc.get(ia).getX() < 230 && StoneLoc.get(ia).getX() > 176) && (StoneLoc.get(ia).getZ() < -164 && StoneLoc.get(ia).getZ() > -90)) {
                        Random rdm = new Random();
                        int i = rdm.nextInt(100);

                        if (i <= 30 && MINE_ORE_AMOUNT.COAL < 1300) {
                            b.setType(Material.COAL_ORE);
                            MINE_ORE_AMOUNT.COAL++;
                        } else if (i > 30 && i <= 45 && MINE_ORE_AMOUNT.IRON < 500) {
                            b.setType(Material.IRON_ORE);
                            MINE_ORE_AMOUNT.IRON++;
                        } else if (i > 45 && i <= 50 && MINE_ORE_AMOUNT.LAPIS < 125) {
                            b.setType(Material.LAPIS_ORE);
                            MINE_ORE_AMOUNT.LAPIS++;
                        } else if (i > 50 && i <= 55 && MINE_ORE_AMOUNT.REDSTONE < 125) {
                            b.setType(Material.REDSTONE_ORE);
                            MINE_ORE_AMOUNT.REDSTONE++;
                        } else if (i > 55 && i <= 70 && MINE_ORE_AMOUNT.GOLD < 250) {
                            b.setType(Material.GOLD_ORE);
                            MINE_ORE_AMOUNT.GOLD++;
                        }
                    }
                } else if (StoneLoc.get(ia).getY() < 180 && StoneLoc.get(ia).getY() > 160) {
                    Random rdm = new Random();
                    int i = rdm.nextInt(100);

                    if (i <= 30 && MINE_ORE_AMOUNT.COAL < 500) {
                        b.setType(Material.COAL_ORE);
                        MINE_ORE_AMOUNT.COAL++;
                    } else if (i > 30 && i <= 50 && MINE_ORE_AMOUNT.IRON < 250) {
                        b.setType(Material.IRON_ORE);
                        MINE_ORE_AMOUNT.IRON++;
                    } else if (i > 50 && i <= 60 && MINE_ORE_AMOUNT.LAPIS < 50) {
                        b.setType(Material.LAPIS_ORE);
                        MINE_ORE_AMOUNT.LAPIS++;
                    } else if (i > 60 && i <= 70 && MINE_ORE_AMOUNT.REDSTONE < 50) {
                        b.setType(Material.REDSTONE_ORE);
                        MINE_ORE_AMOUNT.REDSTONE++;
                    } else if (i > 70 && i <= 80 && MINE_ORE_AMOUNT.GOLD < 125) {
                        b.setType(Material.GOLD_ORE);
                        MINE_ORE_AMOUNT.GOLD++;
                    } else if (i > 80 && i <= 90 && MINE_ORE_AMOUNT.DIAMANT < 30) {
                        b.setType(Material.DIAMOND_ORE);
                        MINE_ORE_AMOUNT.DIAMANT++;
                    } else if (i > 90 && i <= 100 && MINE_ORE_AMOUNT.EMERAUDE < 10) {
                        b.setType(Material.EMERALD_ORE);
                        MINE_ORE_AMOUNT.EMERAUDE++;
                    }
                }
                StoneLoc.remove(b.getLocation());
            }
        }
        Bukkit.broadcastMessage("COAL:"+MINE_ORE_AMOUNT.COAL+"\nIRON:"+MINE_ORE_AMOUNT.IRON+"\nGOLD:"+MINE_ORE_AMOUNT.GOLD+"\nLAPIS"+MINE_ORE_AMOUNT.LAPIS+"\nREDSTONE:"+MINE_ORE_AMOUNT.REDSTONE+"\nDIAMANT:"+MINE_ORE_AMOUNT.DIAMANT+"\nEMERAUDE:"+MINE_ORE_AMOUNT.EMERAUDE);


        ArrayList<Location> test = new ArrayList<>();
        for(int x = 323; x < 337; x++){
            for (int y = 6; y < 16; y++) {
                for (int z = -161 ; z < -147; z++) {

                    Location loc = new Location(Bukkit.getWorld("Mine"), x,y,z);
                    Block b = loc.getBlock();
                    if(b.getType() == Material.STONE) {
                        test.add(b.getLocation());
                    }

                }
            }
        }

        for(int o = 0; o<test.size();o++){
            Block b = test.get(o).getBlock();

            Random rdm = new Random();
            int i = rdm.nextInt(100);

            if (i <= 15) {
                b.setType(Material.COAL_ORE);
            }
        }

        return false;
    }
}
