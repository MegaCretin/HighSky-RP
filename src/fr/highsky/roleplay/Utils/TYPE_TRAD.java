package fr.highsky.roleplay.Utils;


public class TYPE_TRAD {

    public static String typeToStrindFr(String material, boolean plusieur){

        switch (material){
            case "WHEAT":
                if(plusieur){
                    return "blés";
                }
                return "blé";
            case "POTATO":
                if(plusieur){
                    return "patates";
                }
                return "patate";
            case "CARROT":
                if(plusieur){
                    return "carotes";
                }
                return "carote";
            case "BEETROOT":
                if(plusieur){
                    return "betteraves";
                }
                return "betterave";
            case "MELON":
                if(plusieur){
                    return "pastèques";
                }
                return "pastèque";
            case "PUMPKIN":
                if(plusieur){
                    return "citrouilles";
                }
                return "citrouille";
            case "CACTUS":
                return "cactus";
            case "SUGAR_CANE":
                if(plusieur){
                    return "cannes à sucres";
                }
                return "cannes à sucre";
            case "BAMBOO":
                if(plusieur){
                    return "bambous";
                }
                return "bambou";
        }
        return material;
    }
}
