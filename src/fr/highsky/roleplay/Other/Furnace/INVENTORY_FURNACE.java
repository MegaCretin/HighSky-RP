package fr.highsky.roleplay.Other.Furnace;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class INVENTORY_FURNACE implements Listener {



    @EventHandler
    public void onClickInventory(InventoryClickEvent e){


        Player p = (Player) e.getWhoClicked();

        if(e.getClickedInventory() == null){
            e.setCancelled(true);
        }
        if(e.getView().getTitle().equalsIgnoreCase("§a§lFour §7[§3Main§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;

            }

            Map<Material, Material> mat = new HashMap<>();
            mat.put(Material.COAL_ORE, Material.COAL);
            mat.put(Material.IRON_ORE, Material.IRON_INGOT);
            mat.put(Material.GOLD_ORE, Material.GOLD_INGOT);
            mat.put(Material.REDSTONE_ORE, Material.REDSTONE);
            mat.put(Material.LAPIS_ORE, Material.LAPIS_LAZULI);
            mat.put(Material.DIAMOND_ORE, Material.DIAMOND);
            mat.put(Material.EMERALD_ORE, Material.EMERALD);
            mat.put(Material.ANCIENT_DEBRIS, Material.NETHERITE_SCRAP);
            mat.put(Material.NETHER_QUARTZ_ORE, Material.QUARTZ);
            mat.put(Material.NETHER_GOLD_ORE, Material.GOLD_INGOT);

            switch (e.getCurrentItem().getType()) {
                case LIME_STAINED_GLASS_PANE:
                    if(p.getLevel() >= 5){
                        Material material = mat.get(p.getInventory().getItemInMainHand().getType());
                        Integer integer = p.getInventory().getItemInMainHand().getAmount();
                        p.getInventory().getItemInMainHand().setType(null);

                        p.getInventory().setItemInMainHand(new ItemStack(material, integer));
                        p.setLevel(p.getLevel() - 5);
                        p.closeInventory();
                    }
                    break;
                case RED_STAINED_GLASS_PANE:
                    p.closeInventory();
                    break;
                default:
                    break;
            }
        }else if(e.getView().getTitle().equalsIgnoreCase("§a§lFour §7[§3Tous§7]")) {
            e.setCancelled(true);
            if (e.getInventory() == null || e.getCurrentItem() == null || e.getCurrentItem().getType() == null || !e.getCurrentItem().hasItemMeta()) {
                p.closeInventory();
                return;

            }

            Map<Material, Material> mat = new HashMap<>();
            mat.put(Material.COAL_ORE, Material.COAL);
            mat.put(Material.IRON_ORE, Material.IRON_INGOT);
            mat.put(Material.GOLD_ORE, Material.GOLD_INGOT);
            mat.put(Material.REDSTONE_ORE, Material.REDSTONE);
            mat.put(Material.LAPIS_ORE, Material.LAPIS_LAZULI);
            mat.put(Material.DIAMOND_ORE, Material.DIAMOND);
            mat.put(Material.EMERALD_ORE, Material.EMERALD);
            mat.put(Material.ANCIENT_DEBRIS, Material.NETHERITE_SCRAP);
            mat.put(Material.NETHER_QUARTZ_ORE, Material.QUARTZ);
            mat.put(Material.NETHER_GOLD_ORE, Material.GOLD_INGOT);

            switch (e.getCurrentItem().getType()) {
                case LIME_STAINED_GLASS_PANE:
                    if(p.getLevel() >= 10){
                        for (int i = 0; i < 36; i++) {
                            if (p.getInventory().getItem(i) != null && mat.containsKey(p.getInventory().getItem(i).getType())) {
                                p.getInventory().getItem(i).setType(null);
                                p.setLevel(p.getLevel() - 10);
                                Integer integer = p.getInventory().getItem(i).getAmount();
                                p.getInventory().setItem(i, new ItemStack(mat.get(p.getInventory().getItem(i).getType()), integer));

                                p.closeInventory();
                            }
                        }
                    }
                    break;
                case RED_STAINED_GLASS_PANE:
                    p.closeInventory();
                    break;
                default:
                    break;
            }
        }
    }
}
