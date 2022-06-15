package fr.highsky.roleplay.Economy.Shop.Commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Shop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        Player p = (Player)sender;

            /*
            File file = new File("plugins/HighSky-RP/ConfigShop.yml");
            YamlConfiguration config = YamlConfiguration.loadConfiguration(file);

            File file1 = new File("plugins/HighSky-RP/DataShop.yml");
            YamlConfiguration conf = YamlConfiguration.loadConfiguration(file1);

            for (String start : config.getConfigurationSection("").getKeys(false)) {
                Bukkit.broadcastMessage("§6"+start);
                for (String s : config.getConfigurationSection(start+".").getKeys(true)) {
                    String s1 = config.getString(start + "." + s);
                    String[] items = s1.split("/");
                    conf.set(items[0] + ".Achat.Value", 1.000);
                    conf.set(items[0] + ".Achat.Nbr", 0);
                    conf.set(items[0] + ".Vente.Value", 1.000);
                    conf.set(items[0] + ".Vente.Nbr", 0);
                }
                try {
                    conf.save(file1);
                    Bukkit.broadcastMessage("§aSave");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }*/


        return false;
    }
}
