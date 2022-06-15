package fr.highsky.roleplay.Commands.Quests;

import net.citizensnpcs.api.event.NPCRightClickEvent;

public class GET_NPC_CLICKED {

    public static String getNPCID(NPCRightClickEvent e){
        Integer id = e.getNPC().getId();
        if(id == 0) return "Fermier";
        else if (id == 1) return "Boucher";
        else if (id == 2) return "Tavernier";
        else if (id == 3) return "Pecheur";
        else if (id == 4) return "Boulanger";
        else if (id == 5) return "Seigneur";
        else if (id == 6) return "Pichon";
        else return "";
    }

}
