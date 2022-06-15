package fr.highsky.roleplay.Gestion.Moderation.Utils;

import java.io.*;
import java.util.HashMap;

public class MODERATION_UTILS {

    public static HashMap<String, Long> Ban = new HashMap<>();
    public static HashMap<String, Long> Mute = new HashMap<>();

    private static String BanList = "plugins/HighSky-RP/BanList.dat";
    private static String MuteList = "plugins/HighSky-RP/MuteList.dat";

    public static void newFile() throws IOException, ClassNotFoundException {

        File file = new File(BanList);
        if (file.exists())
            Ban = loadBan();
        if (Ban == null)
            Ban = new HashMap<String, Long>();

        File file1 = new File(MuteList);
        if (file1.exists())
            Mute = loadMute();
        if (Mute == null)
            Mute = new HashMap<String, Long>();

    }


    public static void save() throws IOException {
        File file = new File(BanList);
        (new File("plugins/HighSky-RP")).mkdir();
        if (!file.exists()) {
            file.createNewFile();
        }
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(MuteList));
        oos.writeObject(Ban);
        oos.flush();
        oos.close();

        File file1 = new File(MuteList);
        if (!file1.exists()) {
            file1.createNewFile();
        }
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream(MuteList));
        oos1.writeObject(MuteList);
        oos1.flush();
        oos1.close();
    }


    public static HashMap<String, Long> loadBan() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(BanList));
            Object result = ois.readObject();
            ois.close();
            return (HashMap<String, Long>) result;
        } catch (Exception e) {
            return null;
        }
    }

    public static HashMap<String, Long> loadMute() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(MuteList));
            Object result = ois.readObject();
            ois.close();
            return (HashMap<String, Long>) result;
        } catch (Exception e) {
            return null;
        }
    }
}