package fr.highsky.roleplay.Chat.Tag.TagsUtils;


import org.bukkit.entity.Player;

import java.sql.*;

public class Database {
    public Database() {
    }

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

    public static int RecupId(String tag) throws SQLException {
        int resultat = 0;

        Connection cn = Database.connect();
        String query = "SELECT * FROM tag where libelle = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, tag);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            resultat = rs.getInt("id");
        }
        rs.close();
        ps.close();
        cn.close();

        return resultat;
    }



    public static Boolean VerifTag(Player p, int tag) throws SQLException {

         boolean resultat = false;
        Connection cn = Database.connect();
        String query = "SELECT * FROM tag_user WHERE UUID = ? AND idTags = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setString(1, p.getUniqueId().toString());
        ps.setInt(2, tag);
        ResultSet rs = ps.executeQuery();
        if(rs.next()){
            String bddPseudo = rs.getString("UUID");
            int bddTag = rs.getInt("idTags");
            String currentPseudo = p.getUniqueId().toString();
            int currentTag = tag;
            if ((bddPseudo.equals(currentPseudo)) && (currentTag == bddTag)) {
                resultat = true;
            }
        }
        rs.close();
        ps.close();
        cn.close();

        return resultat;
    }

    public static String RecupTag(int tag) throws SQLException {

         String resultat = "";

        Connection cn = Database.connect();
        String query = "SELECT * FROM tag WHERE id = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        ps.setInt(1, tag);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            resultat = rs.getString("libelle");
        }

        rs.close();
        ps.close();
        cn.close();

        return resultat;
    }
}
