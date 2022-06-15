package fr.highsky.roleplay.Chat.Tag.Listeners;

import fr.highsky.roleplay.Main;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.highsky.roleplay.Chat.Tag.TagsUtils.Database;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

public class TagListener implements Listener {
    public TagListener() {
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws SQLException {

        Player p = e.getPlayer();
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                try {
                    Connection cn = Database.connect();
                    String query = "SELECT idTags FROM tag_used WHERE UUID = ?";
                    PreparedStatement ps = null;
                    ps = cn.prepareStatement(query);
                    ps.setString(1, p.getUniqueId().toString());
                    ResultSet rs = ps.executeQuery();

                    while(rs.next()) {
                        String Tags = Database.RecupTag(rs.getInt("idTags"));

                        if (Tags != "") {
                            Main.mapTAG.put(p.getUniqueId(), Tags.replace("&","§"));
                        }

                    }
                    rs.close();
                    ps.close();
                    cn.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) throws SQLException {

        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
            try{
                Player p = e.getPlayer();
                if (Main.mapTAG.containsKey(p.getUniqueId())) {
                    String tag = (String) Main.mapTAG.get(p.getUniqueId());
                    int idTags = Database.RecupId(tag.replace("§","&"));
                    if (tag != null) {

                        Connection cn = Database.connect();
                        String query = "SELECT idTags FROM tag_used WHERE UUID = ?";
                        PreparedStatement ps = cn.prepareStatement(query);
                        ps.setString(1, p.getUniqueId().toString());
                        ResultSet rs = ps.executeQuery();


                        if (rs.next()) {
                            if (!((idTags) == (rs.getInt("idTags")))) {
                                query = "UPDATE tag_used SET idTags = ? WHERE UUID = ?";
                                ps = cn.prepareStatement(query);
                                ps.setInt(1, idTags);
                                ps.setString(2, p.getUniqueId().toString());
                                ps.executeUpdate();
                                rs.close();
                                ps.close();
                                cn.close();
                            }
                        } else {
                            query = "INSERT INTO tag_used (UUID, idTags) VALUES (?, ?)";
                            ps = cn.prepareStatement(query);
                            ps.setString(1, p.getUniqueId().toString());
                            ps.setInt(2, idTags);
                            ps.executeUpdate();
                            rs.close();
                            ps.close();
                            cn.close();
                        }

                        Main.mapTAG.remove(p.getUniqueId());
                    }
                }
            }catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        });

    }

    @Deprecated
    @EventHandler
    public void interactPrefix(PlayerInteractEvent event) throws SQLException {

        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), new Runnable() {
            @Override
            public void run() {

                try{
                    Player p = event.getPlayer();
                    ItemStack item = event.getItem();
                    Action action = event.getAction();

                    if((p.getInventory().getItemInMainHand().getType() == Material.NAME_TAG) && (p.getInventory().getItemInMainHand().hasItemMeta()) && (p.getInventory().getItemInMainHand().getItemMeta().getLore().size() == 3)){
                        if(action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK){
                            String nameTag = p.getInventory().getItemInMainHand().getItemMeta().getDisplayName().replace("§","&");
                            int idTag = Database.RecupId(nameTag);
                            if (!Database.VerifTag(p, idTag)){
                                event.setCancelled(true);
                                Connection cn = Database.connect();
                                String query = "INSERT INTO User (UUID, idTags) VALUES (?, ?)";
                                PreparedStatement ps = cn.prepareStatement(query);
                                ps.setString(1, p.getUniqueId().toString());
                                ps.setInt(2, idTag);
                                int rs = ps.executeUpdate();

                                ps.close();
                                cn.close();
                                if (!Main.mapTAG.containsKey(p.getUniqueId())) {
                                    Main.mapTAG.put(p.getUniqueId(), nameTag.replace("&", "§"));
                                } else {
                                    Main.mapTAG.replace(p.getUniqueId(), nameTag.replace("&", "§"));
                                }
                                p.sendMessage("§6§lHigh§b§lSky §bVotre Préfix a été ajouté");
                                ItemStack i = p.getInventory().getItemInMainHand();
                                p.getInventory().remove(i);
                            }
                            else{
                                event.setCancelled(true);
                                p.sendMessage("§6§lHigh§b§lSky §bVous possédez déjà ce Préfix");
                                ItemStack i = p.getInventory().getItemInMainHand();
                                p.getInventory().remove(i);
                            }
                        }

                    }
                }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }

            }
        });
    }


}
