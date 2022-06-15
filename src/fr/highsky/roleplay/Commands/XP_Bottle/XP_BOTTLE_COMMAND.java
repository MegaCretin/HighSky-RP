package fr.highsky.roleplay.Commands.XP_Bottle;

import fr.highsky.roleplay.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.stream.Collectors;

public class XP_BOTTLE_COMMAND implements CommandExecutor {

    private final Main main = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        Player p = (Player)sender;

        if(!p.hasPermission("convertxp.use")){
            p.sendMessage(main.getConfig().getString("Bottle.Messages.Prefix").replace("&","§")+main.getConfig().getString("Bottle.Messages.Permission").replace("&","§"));
            return false;
        }

        if(args.length == 0){
            if(p.getLevel() > main.getConfig().getInt("Bottle.Settings.Min_Lvl")) {
                int exp = (int) XP_BOTTLE_UTILS.convertXP(p.getLevel());
                ItemStack it = new ItemStack(Material.EXPERIENCE_BOTTLE);
                ItemMeta itx = it.getItemMeta();
                itx.setDisplayName(main.getConfig().getString("Bottle.Title").replace("&", "§"));
                List<String> lore = main.getConfig().getStringList("Bottle.Description");
                List<String> replaceLore = lore.stream().map(s -> s.replace("&", "§").replace("%exp%", String.valueOf(exp))).collect(Collectors.toList());
                itx.setLore(replaceLore);
                it.setItemMeta(itx);
                p.getInventory().addItem(it);
                p.setLevel(p.getLevel() - p.getLevel());
            }else{
                p.sendMessage(main.getConfig().getString("Bottle.Messages.Prefix").replace("&","§")+main.getConfig().getString("Bottle.Messages.Need_More").replace("&","§").replace("%min-lvl%", String.valueOf(main.getConfig().getInt("Bottle.Settings.Min_Lvl"))));
            }
        }else{
            p.sendMessage(main.getConfig().getString("Bottle.Messages.Prefix").replace("&","§")+main.getConfig().getString("Bottle.Messages.Permission").replace("&","§"));
        }

        return false;
    }


}
