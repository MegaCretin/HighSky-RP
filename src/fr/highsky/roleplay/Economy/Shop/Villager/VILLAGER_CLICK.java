package fr.highsky.roleplay.Economy.Shop.Villager;

import fr.highsky.roleplay.Economy.Shop.Utils.SHOPTYPE;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.io.IOException;

public class VILLAGER_CLICK implements Listener {
    @EventHandler
    public void villagerClick(PlayerInteractEntityEvent e) throws IOException {

        if(e.getRightClicked() instanceof Villager || e.getRightClicked() instanceof WanderingTrader) {
            if (e.getRightClicked().getLocation().getWorld().getName().equalsIgnoreCase("map")) {
                Player p = e.getPlayer();
                e.setCancelled(true);
                if (e.getRightClicked().getName().equalsIgnoreCase("§6§l» §aBlocs §6§l«")) {
                    if (p.hasPermission("shop.block")) {
                        SHOPTYPE.shopBlocks(p);
                    } else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
                } else if (e.getRightClicked().getName().equalsIgnoreCase("§6§l» §aNourriture §6§l«")) {
                    if (p.hasPermission("shop.feed")) {
                        SHOPTYPE.shopEat(p);
                    } else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
                } else if (e.getRightClicked().getName().equalsIgnoreCase("§6§l» §aMinerais §6§l«")) {
                    if (p.hasPermission("shop.ore")) {
                        SHOPTYPE.shopOre(p);
                    } else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
                } else if (e.getRightClicked().getName().equalsIgnoreCase("§6§l» §aLoots §6§l«")) {
                    if (p.hasPermission("shop.loots")) {
                        SHOPTYPE.shopLoots(p);
                    } else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
                } else if (e.getRightClicked().getName().equalsIgnoreCase("§6§l» §aDeco §6§l«")) {
                    if (p.hasPermission("shop.deco")) {
                        //ShopType.shopCoral(p);
                        SHOPTYPE.shopDeco(p);
                    } else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
                } else if (e.getRightClicked().getName().equalsIgnoreCase("§6§l» §aMonde §6§l«")) {
                    if (p.hasPermission("shop.world")) {
                        SHOPTYPE.shopWorld(p);
                    } else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
                } else if (e.getRightClicked().getName().equalsIgnoreCase("§6§l» §aDivers §6§l«")) {
                    if (p.hasPermission("shop.other")) {
                        SHOPTYPE.shopOther(p);
                    } else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
                } else if (e.getRightClicked().getName().equalsIgnoreCase("§6§l» §aNature §6§l«")) {
                    if (p.hasPermission("shop.wild")) {
                        SHOPTYPE.shopWild(p);
                    } else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
                } else if (e.getRightClicked().getName().equalsIgnoreCase("§6§l» §aPromotions §6§l«")) {
                    if (p.hasPermission("shop.promo")) {
                        /*Merchant merchant = Bukkit.createMerchant("§6§l» §aPromotions §6§l«");
                        List<MerchantRecipe> merchantRecipes = new ArrayList<MerchantRecipe>();
                        MerchantRecipe recipe = new MerchantRecipe(new ItemStack(Material.STONE), 1000);
                        recipe.setExperienceReward(false);
                        recipe.addIngredient(new ItemStack(Material.GRAVEL, 5));
                        recipe.addIngredient(new ItemStack(Material.STONE));
                        merchantRecipes.add(recipe);

                        merchant.setRecipes(merchantRecipes);
                        p.openMerchant(merchant, true);*/
                        SHOPTYPE.saleShop(p);
                    } else p.sendMessage("§6§lSHOP §8§l» §cVous n'avez pas la permission de parler avec ce vendeur.");
                }

            }
        }

    }


}
