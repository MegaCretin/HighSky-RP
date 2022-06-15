package fr.highsky.roleplay.Gestion.Moderation.Utils;

public enum TICK_UTILS {
    SECOND("Secondes", 0),
    MINUTE("Minutes", 1),
    HOUR("Heures", 60),
    DAY("Jours", 1440);


    public int multi;
    public String name;

    TICK_UTILS(String name, int multi){
        this.name = name;
        this.multi = multi;
    }

    public static long getTick(String unit, int time){
        long sec;
        try {
            sec = time * 60;
        }catch (NumberFormatException ex){
            return 0L;
        }
        byte b;
        int i;
        TICK_UTILS[] arrayOfTICK_UTILS;
        for(i = (arrayOfTICK_UTILS = values()).length, b = 0;b<i;){
            TICK_UTILS un = arrayOfTICK_UTILS[b];
            if(unit.startsWith(un.name))
                return (sec *= un.multi) * 1000L;
            b++;
        }
        return 0L;
    }

}
