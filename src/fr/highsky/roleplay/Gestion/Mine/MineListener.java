package fr.highsky.roleplay.Gestion.Mine;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Random;

public class MineListener implements Listener {

    public static HashMap<Block, LocalTime> blocksBreak = new HashMap<>();

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event){

        Block block = event.getBlock();
        Player player = event.getPlayer();
        Random r;
        int rdm;

        if(player.getGameMode() != GameMode.CREATIVE && player.getWorld().getName().equalsIgnoreCase("Mines")){
            event.setCancelled(true);

            switch (block.getType()) {

                case COBBLESTONE:


                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE, 1));

                    blocksBreak.put(block, LocalTime.now());

                    block.setType(Material.BEDROCK);

                    break;

                case STONE:

                    if(player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.SILK_TOUCH)){
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.STONE, 1));
                    }else{
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COBBLESTONE, 1));
                    }

                    blocksBreak.put(block, LocalTime.now());

                    block.setType(Material.COBBLESTONE);

                    break;

                case COAL_ORE:

                    if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3){

                        r = new Random();
                        rdm = 6;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL, 1 +r.nextInt(rdm)));
                    }else if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2){

                        r = new Random();
                        rdm = 5;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL, 1 +r.nextInt(rdm)));
                    }else if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1){

                        r = new Random();
                        rdm = 4;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL, 1 +r.nextInt(rdm)));
                    }else{

                        r = new Random();
                        rdm = 3;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.COAL, 1 +r.nextInt(rdm)));
                    }

                    block.setType(Material.STONE);

                    break;

                case IRON_ORE:

                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.IRON_ORE,1));

                    block.setType(Material.STONE);

                    break;

                case LAPIS_ORE:

                    if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3){

                        r = new Random();
                        rdm = 6;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.LAPIS_LAZULI, 1 +r.nextInt(rdm)));
                    }else if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2){

                        r = new Random();
                        rdm = 5;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.LAPIS_LAZULI, 1 +r.nextInt(rdm)));
                    }else if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1){

                        r = new Random();
                        rdm = 4;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.LAPIS_LAZULI, 1 +r.nextInt(rdm)));
                    }else{

                        r = new Random();
                        rdm = 3;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.LAPIS_LAZULI, 1 +r.nextInt(rdm)));
                    }

                    block.setType(Material.STONE);

                    break;

                case REDSTONE_ORE:

                    if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3){

                        r = new Random();
                        rdm = 8;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.REDSTONE, 1 +r.nextInt(rdm)));
                    }else if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2){

                        r = new Random();
                        rdm = 7;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.REDSTONE, 1 +r.nextInt(rdm)));
                    }else if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1){

                        r = new Random();
                        rdm = 6;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.REDSTONE, 1 +r.nextInt(rdm)));
                    }else{

                        r = new Random();
                        rdm = 5;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.REDSTONE, 1 +r.nextInt(rdm)));

                    }

                    block.setType(Material.STONE);

                    break;

                case GOLD_ORE:

                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLD_ORE, 1));

                    block.setType(Material.STONE);

                    break;

                case DIAMOND_ORE:

                    if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3){

                        r = new Random();
                        rdm = 5;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND, 1 +r.nextInt(rdm)));
                    }else if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2){

                        r = new Random();
                        rdm = 4;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND, 1 +r.nextInt(rdm)));
                    }else if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1){

                        r = new Random();
                        rdm = 3;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND, 1 +r.nextInt(rdm)));
                    }else{

                        r = new Random();
                        rdm = 2;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.DIAMOND, 1 +r.nextInt(rdm)));
                    }

                    block.setType(Material.STONE);

                    break;

                case EMERALD_ORE:

                    if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 3){

                        r = new Random();
                        rdm = 5;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD, 1 +r.nextInt(rdm)));
                    }else if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 2){

                        r = new Random();
                        rdm = 4;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD, 1 +r.nextInt(rdm)));
                    }else if (player.getInventory().getItemInMainHand().getEnchantments().containsKey(Enchantment.LOOT_BONUS_BLOCKS) && player.getInventory().getItemInMainHand().getEnchantmentLevel(Enchantment.LOOT_BONUS_BLOCKS) == 1){

                        r = new Random();
                        rdm = 3;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD, 1 +r.nextInt(rdm)));
                    }else{

                        r = new Random();
                        rdm = 2;
                        block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.EMERALD, 1 +r.nextInt(rdm)));
                    }

                    block.setType(Material.STONE);

                    break;

            }
        }

    }
}
