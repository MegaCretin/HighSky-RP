package fr.highsky.roleplay.Gestion.Mine.commands;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ResetMineCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender p, Command command, String s, String[] strings) {

        for(Chunk c : Bukkit.getWorld("Mine").getLoadedChunks())
        {
            int X = c.getX() * 16;
            int Z = c.getZ() * 16;

            for (int x = 0; x < 16; x++)
            {
                for (int z = 0; z < 16; z++)
                {
                    for (int y = 160; y < 255; y++)
                    {
                        Block b = c.getWorld().getBlockAt(X+x, y, Z+z);
                        if (b.getType() == Material.COBBLESTONE || b.getType() == Material.BEDROCK || b.getType() == Material.COAL_ORE || b.getType() == Material.IRON_ORE || b.getType() == Material.LAPIS_ORE || b.getType() == Material.REDSTONE_ORE || b.getType() == Material.GOLD_ORE || b.getType() == Material.DIAMOND_ORE || b.getType() == Material.EMERALD_ORE)
                        {
                            b.setType(Material.STONE);
                        }
                    }
                }
            }
        }

        return false;

    }
}
