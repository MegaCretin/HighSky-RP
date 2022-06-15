package fr.highsky.roleplay.Other.TopIslands;


import com.songoda.skyblock.SkyBlock;
import com.songoda.skyblock.leaderboard.Leaderboard;
import net.citizensnpcs.api.CitizensAPI;
import org.bukkit.Bukkit;

import java.sql.*;
import java.util.List;
import java.util.UUID;


public class GetIslandTop{

    @Deprecated
    public static void getTopIS() throws SQLException {

        if (Bukkit.getPluginManager().isPluginEnabled("FabledSkyBlock")) {


            List<Leaderboard> leader = SkyBlock.getInstance().getLeaderboardManager().getLeaderboard(Leaderboard.Type.Level);


            for(int i = 0; i < 3;i++){
                if(CitizensAPI.getNPCRegistry().getById(i+9) == null && leader.get(i) != null){
                    return;
                }else{

                    CitizensAPI.getNPCRegistry().getById(i+9).setName(RecupPseudo(leader.get(i).getVisit().getOwnerUUID()));
                    //Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hd setline "+ (i+4) +" 2 "+"§3"+RecupPseudo(leader.get(i).getVisit().getOwnerUUID()));
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "hd setline "+ (i+4) +" 2 "+"§3Niveau d'ile: §b"+leader.get(i).getVisit().getLevel().getLevel());

                }
            }
        }

    }


    public static String RecupPseudo(UUID uuid) throws SQLException {
        String resultat = "";

        Connection cn = connectBDD();
        String query = "SELECT * FROM Player WHERE UUID = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, uuid.toString());
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            resultat = rs.getString("Pseudo");
        }

        rs.close();
        ps.close();
        cn.close();

        return resultat;
    }
    public static Connection connection = null;

    public static Connection connectBDD(){

        String url = "jdbc:mysql://localhost:3306/HighSky?autoReconnect=true";
        String login = "HighSky";
        String pass = "7rZ5s2NbA";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, login, pass);
        }catch (SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        return connection;



    }

}
