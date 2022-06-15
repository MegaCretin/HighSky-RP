package fr.highsky.roleplay.Events.Boxs.KeyBoxs.Utils;

import org.bukkit.Material;
import org.bukkit.block.Block;

public class GET_LOCATION {

    public static Boolean getLoc(Block b){

        if ((b.getType() == Material.CYAN_SHULKER_BOX && b.getLocation().getX() == BOXS.S_COMMUNE.getLoc().getX() && b.getLocation().getZ() == BOXS.S_COMMUNE.getLoc().getZ() && b.getLocation().getY() == BOXS.S_COMMUNE.getLoc().getY())
                || (b.getType() == Material.RED_SHULKER_BOX && b.getLocation().getX() == BOXS.S_RARE.getLoc().getX() && b.getLocation().getZ() == BOXS.S_RARE.getLoc().getZ() && b.getLocation().getY() == BOXS.S_RARE.getLoc().getY()) ||
                (b.getType() == Material.ORANGE_SHULKER_BOX && b.getLocation().getX() == BOXS.S_LEGENDAIRE.getLoc().getX() && b.getLocation().getZ() == BOXS.S_LEGENDAIRE.getLoc().getZ() && b.getLocation().getY() == BOXS.S_LEGENDAIRE.getLoc().getY())) {
            return true;
        }
        return false;
    }

}
