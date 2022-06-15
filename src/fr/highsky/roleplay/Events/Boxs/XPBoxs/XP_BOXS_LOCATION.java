package fr.highsky.roleplay.Events.Boxs.XPBoxs;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class XP_BOXS_LOCATION{

    public static Boolean getLoc(Block b){

        if ((b.getType() == Material.IRON_BLOCK && b.getLocation().getX() == XP_BOXS_ENUM.XP75.getLoc().getX() && b.getLocation().getZ() == XP_BOXS_ENUM.XP75.getLoc().getZ() && b.getLocation().getY() == XP_BOXS_ENUM.XP75.getLoc().getY())
                || (b.getType() == Material.GOLD_BLOCK && b.getLocation().getX() == XP_BOXS_ENUM.XP150.getLoc().getX() && b.getLocation().getZ() == XP_BOXS_ENUM.XP150.getLoc().getZ() && b.getLocation().getY() == XP_BOXS_ENUM.XP150.getLoc().getY()) ||
                (b.getType() == Material.DIAMOND_BLOCK && b.getLocation().getX() == XP_BOXS_ENUM.XP300.getLoc().getX() && b.getLocation().getZ() == XP_BOXS_ENUM.XP300.getLoc().getZ() && b.getLocation().getY() == XP_BOXS_ENUM.XP300.getLoc().getY())) {
            return true;
        }
        return false;
    }
    
}
