package fr.highsky.roleplay.Events.LootsBoxs;


import fr.highsky.roleplay.Events.LootsBoxs.Utils.LootsBoxs;
import fr.highsky.roleplay.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

public class CraftBox implements Listener {

    @EventHandler
    public static void getRareRecipe(PrepareItemCraftEvent e){


        NamespacedKey key = new NamespacedKey(Main.getInstance(), "commune");

        ItemStack it = LootsBoxs.RareBox(1);

        ShapedRecipe recipe = new ShapedRecipe(key, it);

        recipe.shape("***","***","***");

        recipe.setIngredient('*', new RecipeChoice.ExactChoice(LootsBoxs.CommunBox(1)));


    }

}
