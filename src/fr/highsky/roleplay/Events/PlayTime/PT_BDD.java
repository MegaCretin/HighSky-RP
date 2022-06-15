package fr.highsky.roleplay.Events.PlayTime;

import org.bukkit.entity.Player;

import java.sql.*;

public class PT_BDD {

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

    public static void addPlayer(Player p) throws SQLException {

        Connection cn = connectBDD();
        String query = "INSERT INTO PlayTime (pseudo, 1h, 2h, 3h, 4h, 5h, 6h, 7h, 8h, 9h, 10h, 11h, 12h, 13h, 14h, 15h) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, p.getName());
        ps.setBoolean(2, false);
        ps.setBoolean(3, false);
        ps.setBoolean(4, false);
        ps.setBoolean(5, false);
        ps.setBoolean(6, false);
        ps.setBoolean(7, false);
        ps.setBoolean(8, false);
        ps.setBoolean(9, false);
        ps.setBoolean(10, false);
        ps.setBoolean(11, false);
        ps.setBoolean(12, false);
        ps.setBoolean(13, false);
        ps.setBoolean(14, false);
        ps.setBoolean(15, false);
        ps.setBoolean(16, false);
        ps.executeUpdate();
        ps.close();
        cn.close();

    }

    public static boolean playerExist(Player p) throws SQLException {

        Connection cn = connectBDD();
        String query = "SELECT * FROM PlayTime WHERE pseudo = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, p.getName());
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            String bddUUID = rs.getString("pseudo");
            String currentUUID = p.getName();
            if (bddUUID.equals(currentUUID)) return true;
        }

        ps.close();
        cn.close();
        return false;
    }

    public static void addTime(Player p, String Name) throws SQLException {

        Connection cn = connectBDD();
        String query = "SELECT * FROM PlayTime WHERE Pseudo = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, p.getName());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String bddPseudo = rs.getString("Pseudo");
            String currentPseudo = p.getName();
            if (bddPseudo.equals(currentPseudo)){
                ps = cn.prepareStatement("UPDATE PlayTime SET " +Name+ " = ? WHERE Pseudo = ?");
                ps.setBoolean(1, true);
                ps.setString(2, p.getName());
                ps.executeUpdate();

            }
        }
        ps.close();
        cn.close();

    }

    public static Boolean getStatus(Player p, String Name) throws SQLException {

        Connection cn = connectBDD();
        String query = "SELECT * FROM PlayTime WHERE Pseudo = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, p.getName());
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String bddPseudo = rs.getString("Pseudo");
            String currentPseudo = p.getName();

            if (bddPseudo.equals(currentPseudo)) {

                Boolean b = rs.getBoolean(Name);
                if (b != false) return true;
            }

        }
        rs.close();
        ps.close();
        cn.close();
        return false;
    }

}
