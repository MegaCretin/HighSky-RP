package fr.highsky.roleplay.Commands.Quests;


import fr.highsky.roleplay.Utils.TYPE_TRAD;

import java.util.List;

public class MESSAGE_QUEST {

    public static String formationMessage(List<String> item){
        String resultat = "";
        String liaison = ", ";
        for (int i = 0; i < item.size(); i++) {
            if(i == item.size() - 2){
                liaison = " et ";
            }
            else if(i == item.size() - 1){
                liaison = "";
            }

            String[] req_split = item.get(i).split(":");
            if(Integer.parseInt(req_split[1]) > 1){
                resultat += req_split[1]+" "+ TYPE_TRAD.typeToStrindFr(req_split[0], true) + liaison;
            }
            else{
                resultat += req_split[1]+" "+ TYPE_TRAD.typeToStrindFr(req_split[0], false) + liaison;
            }

        }

        return resultat;
    }
}
