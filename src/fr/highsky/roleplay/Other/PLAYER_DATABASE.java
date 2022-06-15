package fr.highsky.roleplay.Other;

import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;

public class PLAYER_DATABASE {

    public static Connection connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/HighSky?autoReconnect=true";
            String user = "HighSky";
            String passwd = "7rZ5s2NbA";
            Connection conn = DriverManager.getConnection(url, user, passwd);
            return conn;
        } catch (Exception var4) {
            var4.printStackTrace();
            return null;
        }
    }


    public static void addPlayer(Player p){

        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
            Connection cn = connect();
            String query = "INSERT INTO Player (UUID, Pseudo) VALUES (?, ?)";
            PreparedStatement ps = null;
            try {
                ps = cn.prepareStatement(query);
                ps.setString(1, String.valueOf(p.getUniqueId()));
                ps.setString(2, p.getName());
                ps.executeUpdate();
                ps.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    public static boolean playerExist(Player p) throws SQLException {

        Connection cn = connect();
        String query = "SELECT * FROM Player WHERE Pseudo = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, p.getName());
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            String bddUUID = rs.getString("Pseudo");
            String currentUUID = p.getName();
            if (bddUUID.equals(currentUUID)) return true;
        }

        ps.close();
        cn.close();
        return false;
    }

}
