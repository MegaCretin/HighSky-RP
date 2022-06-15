package fr.highsky.roleplay.Commands.Quests;

import fr.herllox.hmoney.API.MoneyAPI;
import fr.highsky.roleplay.Equipement.Stuff.TOOLS;
import fr.highsky.roleplay.Main;
import fr.highsky.roleplay.Utils.*;
import net.citizensnpcs.api.event.NPCRightClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class CLICK_NPC implements Listener {

    @EventHandler
    public void clickNPC(NPCRightClickEvent e) throws IOException, InterruptedException {
        Player p = e.getClicker().getPlayer();
        String NPC = GET_NPC_CLICKED.getNPCID(e);
        File filePlayer = new File("plugins/HighSky-RP/Origine/PlayerData/"+p.getName()+".yml");
        FileConfiguration configPlayer = YamlConfiguration.loadConfiguration(filePlayer);
        File fileMessage = new File("plugins/HighSky-RP/Origine/Quests/NPC/Message.yml");
        FileConfiguration configMessage = YamlConfiguration.loadConfiguration(fileMessage);
        String StartedName = configPlayer.getString("QuestPrincipal.Started.Name");

        if(configPlayer.getBoolean("QuestPrincipal.Started.Debut")){
            File fileStart = new File("plugins/HighSky-RP/Origine/Quests/"+StartedName+".yml");
            FileConfiguration configStart = YamlConfiguration.loadConfiguration(fileStart);
            Integer StartedCheckPoint = configPlayer.getInt("QuestPrincipal.Started.CheckPoint");
            Integer StartedId = configStart.getInt(StartedName+"."+StartedCheckPoint+".NPC.ID");
            Integer StartedNext = configPlayer.getInt("QuestPrincipal.Started.IdNext");
            if(StartedId.equals(e.getNPC().getId())){
                List<String> msg = configStart.getStringList("Start."+StartedCheckPoint+".Started-Message");
                p.sendMessage(msg.get(0).replace("&", "§"));
                if(msg.size() > 1){
                    (new BukkitRunnable() {
                        Integer i = 1;
                        @Override
                        public void run() {
                            if(i < msg.size()) {
                                p.sendMessage(msg.get(i).replace("&", "§"));
                                if(i == msg.size()-1){
                                    this.cancel();
                                }
                            }
                            i++;
                        }
                    }).runTaskTimer(Main.getInstance(), 60, 60);
                }
            }else if(StartedNext.equals(e.getNPC().getId())){
                Integer intNext = configPlayer.getInt("QuestPrincipal.Started.CheckPoint") + 1;
                fileStart = new File("plugins/HighSky-RP/Origine/Quests/"+StartedName+".yml");
                configStart = YamlConfiguration.loadConfiguration(fileStart);


                int ItemQuest = StartedCheckPoint +1;

                if (configStart.contains("Start."+ItemQuest+".Require-Items")) {

                    List<String> Require_Items = configStart.getStringList("Start."+ItemQuest+".Require-Items");
                    int req = 0;
                    for (int i = 0; i < Require_Items.size(); i++) {
                        String[] req_split = Require_Items.get(i).split(":");
                        ItemStack it = new ItemStack(Material.valueOf(req_split[0]), 1);
                        if (p.getInventory().containsAtLeast(it, Integer.parseInt(req_split[1]))) {
                            req++;
                        }
                    }

                    if (req == Require_Items.size()) {
                        configPlayer.set("QuestPrincipal.Started.CheckPoint", intNext);
                        configPlayer.set("QuestPrincipal.Started.Id", configPlayer.getInt("QuestPrincipal.Started.IdNext"));
                        configPlayer.set("QuestPrincipal.Started.IdNext", configStart.getInt(StartedName+"."+intNext+".Next-NPC"));
                        PLAYER_FILE.savePlayerFile(p.getName(), configPlayer);

                        for (int i = 0; i < Require_Items.size(); i++) {
                            String[] req_split = Require_Items.get(i).split(":");
                            ItemStack it = new ItemStack(Material.valueOf(req_split[0]), Integer.parseInt(req_split[1]));
                            p.getInventory().removeItem(it);
                        }

                        List<String> msg = configStart.getStringList(StartedName+"."+intNext+".Start-Message");
                        p.sendMessage(msg.get(0).replace("&", "§").replace("<PLAYER>", p.getDisplayName()));
                        if(msg.size() > 1){
                            (new BukkitRunnable() {
                                Integer i = 1;
                                @Override
                                public void run() {
                                    if(i < msg.size()) {
                                        p.sendMessage(msg.get(i).replace("&", "§").replace("<PLAYER>", p.getDisplayName()));
                                    }
                                    i++;

                                }
                            }).runTaskTimer(Main.getInstance(), 60, 60);
                        }
                    }
                    else {
                        List<String> msg = configStart.getStringList(StartedName+"."+intNext+".notStart-Message");
                        p.sendMessage(msg.get(0).replace("&", "§"));
                        if (msg.size() > 1) {
                            FileConfiguration finalConfig = configStart;
                            (new BukkitRunnable() {
                                Integer i = 1;

                                @Override
                                public void run() {
                                    if (i < msg.size()) {
                                        p.sendMessage(msg.get(i).replace("&", "§"));
                                    }
                                    i++;

                                }
                            }).runTaskTimer(Main.getInstance(), 60, 60);
                        }
                    }

                    BOSSBAR_UTILS.removeBossBar(p);
                    if(configStart.contains("Start."+ItemQuest+".BossBar-Message")){
                        BOSSBAR_UTILS.addBossBar(p, configStart.getString("Start."+ItemQuest+".BossBar-Message"));
                    }
                }
                else {

                    configPlayer.set("QuestPrincipal.Started.CheckPoint", intNext);
                    configPlayer.set("QuestPrincipal.Started.Id", configPlayer.getInt("QuestPrincipal.Started.IdNext"));
                    configPlayer.set("QuestPrincipal.Started.IdNext", configStart.getInt(StartedName+"."+intNext+".Next-NPC"));
                    PLAYER_FILE.savePlayerFile(p.getName(), configPlayer);



                    if (configStart.contains("Start."+ItemQuest+".Give-Items")) {
                        List<String> Reward_Items = configStart.getStringList("Start."+ItemQuest+".Give-Items");
                        for (int i = 0; i < Reward_Items.size(); i++) {
                            String[] req_split = Reward_Items.get(i).split(":");
                            ItemStack it = new ItemStack(Material.valueOf(req_split[0]), Integer.parseInt(req_split[1]));
                            p.getInventory().addItem(it);
                        }
                    }

                    List<String> msg = configStart.getStringList(StartedName+"."+intNext+".Start-Message");
                    p.sendMessage(msg.get(0).replace("&", "§").replace("<PLAYER>", p.getDisplayName()));
                    if(msg.size() > 1){
                        (new BukkitRunnable() {
                            Integer i = 1;
                            @Override
                            public void run() {
                                if(i < msg.size()) {
                                    p.sendMessage(msg.get(i).replace("&", "§").replace("<PLAYER>", p.getDisplayName()));
                                }
                                i++;

                            }
                        }).runTaskTimer(Main.getInstance(), 60, 60);
                    }

                    BOSSBAR_UTILS.removeBossBar(p);
                    if(configStart.contains("Start."+ItemQuest+".BossBar-Message")){
                        BOSSBAR_UTILS.addBossBar(p, configStart.getString("Start."+ItemQuest+".BossBar-Message"));
                    }

                    if (configStart.contains("Start."+ItemQuest+".END")) {
                        if(configStart.getBoolean("Start."+ItemQuest+".END")){
                            configPlayer.set("QuestPrincipal.Started.Debut", false);
                            configPlayer.set("QuestPrincipal.Started.Name", "");
                            configPlayer.set("QuestPrincipal.Started.CheckPoint", 0);
                            configPlayer.set("QuestPrincipal.Started.Id", 0);
                            configPlayer.set("QuestPrincipal.Started.IdNext", 0);
                            PLAYER_FILE.savePlayerFile(p.getName(), configPlayer);
                        }
                    }
                }
            }
        }
        else {
            String nameNpc = e.getNPC().getName().replace("§6", "");
            File fileQO = new File("plugins/HighSky-RP/Origine/Quests/NPC/"+nameNpc+".yml");
            FileConfiguration configQO = YamlConfiguration.loadConfiguration(fileQO);
            String prefix = configQO.getString("Prefix");

            if(fileQO.exists()){
                int level = configPlayer.getInt("Quest.Quests.Origine."+nameNpc+"-Last") + 1;

                for (String s : configQO.getConfigurationSection("Quest").getKeys(false)) {
                    if (Integer.parseInt(s.replace("Quest-", "").replace(" ", "")) == level) {
                        if (configPlayer.getBoolean("Quest.Current")) {
                            if(e.getNPC().getId() == configPlayer.getInt("Quest.NPC")) {
                                if (e.getNPC().getId() == configQO.getInt("Quest." + s + ".NPC")) {

                                    List<String> Requirement_Items = configQO.getStringList("Quest." + s + ".Required-Items");
                                    int req = 0;
                                    for (int i = 0; i < Requirement_Items.size(); i++) {
                                        String[] req_split = Requirement_Items.get(i).split(":");
                                        ItemStack it = new ItemStack(Material.valueOf(req_split[0]), 1);
                                        if (p.getInventory().containsAtLeast(it, Integer.parseInt(req_split[1]))) {
                                            req++;
                                        }
                                    }

                                    if (req == Requirement_Items.size()) {
                                        for (int i = 0; i < Requirement_Items.size(); i++) {
                                            String[] req_split = Requirement_Items.get(i).split(":");
                                            ItemStack it = new ItemStack(Material.valueOf(req_split[0]), Integer.parseInt(req_split[1]));
                                            p.getInventory().removeItem(it);
                                        }

                                        if (configQO.contains("Quest." + s + ".Reward-Money")) {
                                            MoneyAPI.giveMoney(p, configQO.getDouble("Quest." + s + ".Reward-Money"));
                                        }

                                        if (configQO.contains("Quest." + s + ".Command")) {
                                            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), configQO.getString("Quest." + s + ".Reward-Command").replace("%player%", p.getName()));
                                        }


                                        if(configQO.contains("Quest."+ s +".Special-Reward")){
                                            if (configQO.contains("Quest." + s + ".Special-Reward.Tool")) {
                                                List<String> Stuff_Reward = configQO.getStringList("Quest." + s + ".Special-Reward.Tool.Enchante");
                                                List<String> Stuff_Reward_Lore = configQO.getStringList("Quest." + s + ".Special-Reward.Tool.Lore");
                                                p.getInventory().addItem(TOOLS.Tools(Material.getMaterial(Stuff_Reward.get(0)), Stuff_Reward.get(1), Stuff_Reward_Lore, Integer.parseInt(Stuff_Reward.get(2)), Integer.parseInt(Stuff_Reward.get(3)), Integer.parseInt(Stuff_Reward.get(4)), Integer.parseInt(Stuff_Reward.get(5)), Integer.parseInt(Stuff_Reward.get(6)), Integer.parseInt(Stuff_Reward.get(7)), Integer.parseInt(Stuff_Reward.get(8)), Boolean.parseBoolean(Stuff_Reward.get(9)) , Boolean.parseBoolean(Stuff_Reward.get(10)), Boolean.parseBoolean(Stuff_Reward.get(11))));

                                            }

                                            if (configQO.contains("Quest." + s + ".Special-Reward.Command")){
                                                for (String command : configQO.getStringList("Quest." + s + ".Special-Reward.Command")) {
                                                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), command.replace("%player%", p.getDisplayName()));
                                                }
                                            }
                                        }

                                        if (configQO.contains("Quest." + s + ".Reward-Items")) {
                                            List<String> Reward_Items = configQO.getStringList("Quest." + s + ".Reward-Items");
                                            for (int i = 0; i < Reward_Items.size(); i++) {
                                                String[] req_split = Reward_Items.get(i).split(":");
                                                ItemStack it = new ItemStack(Material.valueOf(req_split[0]), Integer.parseInt(req_split[1]));
                                                p.getInventory().addItem(it);
                                            }
                                        }



                                        configPlayer.set("Quest.Quests.Origine." + nameNpc + "." + level + "Q", true);
                                        configPlayer.set("Quest.Quests.Origine." + nameNpc + "-Last", level);
                                        configPlayer.set("Quest.Current", false);
                                        configPlayer.set("Quest.Started", "");
                                        PLAYER_FILE.savePlayerFile(p.getName(), configPlayer);


                                        List<String> msgEnd = configMessage.getStringList("Message.Fin");
                                        Random r = new Random();
                                        int i = r.nextInt((msgEnd.size() - 1) + 1);
                                        p.sendMessage(prefix + msgEnd.get(i).replace("&", "§").replace("%reward%", MESSAGE_QUEST.formationMessage(configQO.getStringList("Quest." + s + ".Reward-Items") )).replace("%player%", p.getDisplayName()));
                                        /*List<String> msg = configQO.getStringList("Quest." + s + ".End-Message");
                                        p.sendMessage(msg.get(0).replace("&", "§"));
                                        if (msg.size() > 1) {
                                            FileConfiguration finalConfig = configQO;
                                            (new BukkitRunnable() {
                                                Integer i = 1;

                                                @Override
                                                public void run() {
                                                    if (i < msg.size()) {
                                                        p.sendMessage(msg.get(i).replace("&", "§"));
                                                    }
                                                    i++;

                                                }
                                            }).runTaskTimer(Main.getInstance(), 60, 60);
                                        }*/
                                    } else {

                                        List<String> msg = configMessage.getStringList("Started-Message");
                                        Random r = new Random();
                                        int i = r.nextInt((msg.size() - 1) + 1);
                                        p.sendMessage(prefix + msg.get(i).replace("&", "§").replace("%item%", MESSAGE_QUEST.formationMessage(configQO.getStringList("Quest." + s + ".Required-Items"))));

                                        /*if (msg.size() > 1) {
                                            FileConfiguration finalConfig = configQO;
                                            (new BukkitRunnable() {
                                                Integer i = 1;

                                                @Override
                                                public void run() {
                                                    if (i < msg.size()) {
                                                        p.sendMessage(msg.get(i).replace("&", "§"));
                                                    }
                                                    i++;

                                                }
                                            }).runTaskTimer(Main.getInstance(), 60, 60);
                                        }*/
                                    }
                                }
                            }
                            else {
                                p.sendMessage("§eTu as déjà une quête en cours");
                            }


                        } else {
                            if (e.getNPC().getId() == configQO.getInt("Quest." + s + ".NPC")) {

                                List<String> msgDebut = configMessage.getStringList("Message.Debut");
                                List<String> msgContext = configMessage.getStringList("Message.Context");

                                Random r = new Random();
                                int i = r.nextInt((msgDebut.size() - 1) + 1);
                                p.sendMessage(prefix + msgDebut.get(i).replace("&", "§").replace("%item%", MESSAGE_QUEST.formationMessage(configQO.getStringList("Quest." + s + ".Required-Items"))).replace("%player%", p.getDisplayName()));

                                r = new Random();
                                i = r.nextInt((msgContext.size() - 1) + 1);
                                p.sendMessage(prefix + msgContext.get(i).replace("&", "§").replace("%item%", MESSAGE_QUEST.formationMessage(configQO.getStringList("Quest." + s + ".Required-Items"))));
                                /*List<String> msg = configQO.getStringList("Quest." + s + ".Start-Message");
                                p.sendMessage(msg.get(0).replace("&", "§"));
                                if (msg.size() > 1) {
                                    FileConfiguration finalConfig = configQO;
                                    (new BukkitRunnable() {
                                        Integer i = 1;

                                        @Override
                                        public void run() {
                                            if (i < msg.size()) {
                                                p.sendMessage(msg.get(i).replace("&", "§"));
                                            }
                                            i++;

                                        }
                                    }).runTaskTimer(Main.getInstance(), 60, 60);
                                }*/
                                configPlayer.set("Quest.Current", true);
                                configPlayer.set("Quest.NPC", e.getNPC().getId());
                                configPlayer.set("Quest.Started-Message", MESSAGE_QUEST.formationMessage(configQO.getStringList("Quest." + s + ".Required-Items")));
                                configPlayer.set("Quest.Started", configQO.getString("Quest." + s + ".Started-Item"));
                                PLAYER_FILE.savePlayerFile(p.getName(), configPlayer);
                            }
                        }
                    }
                }
            }
        }
    }
}
