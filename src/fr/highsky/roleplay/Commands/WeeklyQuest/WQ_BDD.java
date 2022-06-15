package fr.highsky.roleplay.Commands.WeeklyQuest;

import fr.highsky.roleplay.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WQ_BDD {

    public static Connection connection = null;

    public static Connection connect(){

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

    public static void addPlayer(Player p){

        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
            Connection cn = connect();
            String query = "INSERT INTO WeeklyQuest (Pseudo, Nbr, User) VALUES (?, ?, ?)";
            PreparedStatement ps = null;
            try {
                ps = cn.prepareStatement(query);
                ps.setString(1, p.getName());
                ps.setInt(2, 0);
                ps.setBoolean(3, true);
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
        String query = "SELECT * FROM WeeklyQuest WHERE Pseudo = ?";
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

    public static void addItem(Player p, int nbr) {

        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
            Connection cn = connect();
            String query = "SELECT * FROM WeeklyQuest WHERE Pseudo = ?";
            PreparedStatement ps = null;
            try {
                ps = cn.prepareStatement(query);
                ps.setString(1, p.getName());
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    String bddPseudo = rs.getString("Pseudo");
                    String currentPseudo = p.getName();
                    if (bddPseudo.equals(currentPseudo)){
                        ps = cn.prepareStatement("UPDATE WeeklyQuest SET Nbr = ? WHERE Pseudo = ?");
                        ps.setInt(1, nbr);
                        ps.setString(2, p.getName());
                        ps.executeUpdate();

                    }
                }
                ps.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

    }

    public static Integer checkNbr(String p) throws SQLException {

        Connection cn = connect();
        String query = "SELECT * FROM WeeklyQuest WHERE Pseudo = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, p);
        ResultSet rs = ps.executeQuery();

        if(rs.next()){
            String bddPseudo = rs.getString("Pseudo");
            String currentPseudo = p;
            if (bddPseudo.equals(currentPseudo)) {

                Integer i = rs.getInt("Nbr");
                if (i == null) i = 0;
                return i;
            }


        }


        ps.close();
        cn.close();
        return 0;
    }

    public static List getTop10() {

        List list = new ArrayList();


        Connection cn = connect();
        String query = "SELECT Pseudo,Nbr FROM WeeklyQuest ORDER BY Nbr DESC LIMIT 10";
        Statement st = null;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            int i = 0;
            while (rs.next()){
                list.add(rs.getString("Pseudo"));
                i++;
            }
            if(i < 10){
                while (i != 10){
                    list.add("§f...");
                    i++;
                }
            }


            st.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public static List getTop5(){
        List list = new ArrayList();

        Connection cn = connect();
        String query = "SELECT Pseudo FROM WeeklyQuest ORDER BY Nbr DESC LIMIT 5";
        Statement st = null;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                list.add(rs.getString("Pseudo"));
            }

            st.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    public static List getTop3(){
        List list = new ArrayList();

        Connection cn = connect();
        String query = "SELECT Pseudo FROM WeeklyQuest ORDER BY Nbr DESC LIMIT 3";
        Statement st = null;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);

            int i = 0;
            while (rs.next()){
                list.add(rs.getString("Pseudo"));
                i++;
            }
            if(i < 3){
                while (i != 3){
                    list.add("§f...");
                    i++;
                }
            }
            st.close();
            cn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            }

        return list;
    }




    public static void deleteBDD() throws SQLException {
        Bukkit.getScheduler().runTaskAsynchronously(Main.getInstance(), () -> {
            Connection cn = connect();
            String query = "DELETE FROM WeeklyQuest WHERE User = 1";
            Statement st = null;
            try {
                st = cn.createStatement();
                st.executeUpdate(query);
                st.close();
                cn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });

    }

}
