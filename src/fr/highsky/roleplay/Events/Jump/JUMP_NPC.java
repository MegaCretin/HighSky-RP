package fr.highsky.roleplay.Events.Jump;

import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class JUMP_NPC implements Listener {

    @EventHandler
    public void clickNpc(NPCRightClickEvent e){

        if(e.getNPC().getId() == 59){

        }else if(e.getNPC().getId() == 60){

        }

    }

}
