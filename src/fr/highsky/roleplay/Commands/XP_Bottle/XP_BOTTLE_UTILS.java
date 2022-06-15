package fr.highsky.roleplay.Commands.XP_Bottle;

public class XP_BOTTLE_UTILS {

    public static double convertXP(int Lvl) {
        double exp;
        if (Lvl <= 16) {
            exp = Lvl * Lvl + 6 * Lvl;
        } else if (Lvl <= 31) {
            exp = 2.5 * Lvl * Lvl - 40.5 * Lvl + 360;
        } else {
            exp = 4.5 * Lvl * Lvl - 162.5 * Lvl + 2220;
        }
        return exp;
    }
}