package fr.highsky.roleplay;

import fr.highsky.roleplay.Economy.BlackMarket.*;
import fr.highsky.roleplay.Economy.Shop.Events.CLICK_BUY;
import fr.highsky.roleplay.Economy.Shop.Events.CLICK_INVENTORY;
import fr.highsky.roleplay.Economy.Shop.Events.CLICK_SELL;
import fr.highsky.roleplay.Economy.Shop.SellStick.Commands.GIVE_SELLSTICK;
import fr.highsky.roleplay.Economy.Shop.SellStick.Events.CLICK_CHEST;
import fr.highsky.roleplay.Economy.Shop.Villager.ENTITY_SPAWN;
import fr.highsky.roleplay.Economy.Shop.Villager.FIGHT_VILLAGER;
import fr.highsky.roleplay.Economy.Shop.Villager.VILLAGER_CLICK;
import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Skyblock.S_COMMANDS;
import fr.highsky.roleplay.Events.Boxs.KeyBoxs.Skyblock.S_EVENTS;
import fr.highsky.roleplay.Events.Boxs.XPBoxs.XP_BOXS_CLICK;
import fr.highsky.roleplay.Events.Boxs.XPBoxs.XP_BOXS_CLICK_INVENTORY;
import fr.highsky.roleplay.Events.Boxs.XPBoxs.XP_BOXS_COMMANDS;
import fr.highsky.roleplay.Chat.SEND_CHAT;
import fr.highsky.roleplay.Chat.TOGGLE_CHAT;
import fr.highsky.roleplay.Commands.DayliGift.DG_INVENTORY;
import fr.highsky.roleplay.Commands.DayliQuest.DQ_CLICK_INVENTORY;
import fr.highsky.roleplay.Commands.DayliQuest.DQ_INVENTORY;
import fr.highsky.roleplay.Commands.DayliQuest.DQ_RUNNABLE;
import fr.highsky.roleplay.Events.LootsBoxs.Events.KillMobs;
import fr.highsky.roleplay.Events.LootsBoxs.Events.PlaceLootsBox;
import fr.highsky.roleplay.Events.LootsBoxs.GiveCommand;
import fr.highsky.roleplay.Events.QUIT_EVENT;
import fr.highsky.roleplay.Gestion.Maintenance.MAINTENANCE_COMMAND;
import fr.highsky.roleplay.Commands.Menu.MENU_CLICK_INVENTORY;
import fr.highsky.roleplay.Commands.Menu.MENU_INVENTORY;
import fr.highsky.roleplay.Gestion.Mine.commands.MineCommand;
import fr.highsky.roleplay.Gestion.Mine.commands.ResetMineCommand;
import fr.highsky.roleplay.Gestion.Moderation.Events.BANNED_JOIN;
import fr.highsky.roleplay.Gestion.Moderation.Events.MUTE_SPEAK;
import fr.highsky.roleplay.Gestion.Moderation.Inventory.MODERATION_INVENTORY;
import fr.highsky.roleplay.Gestion.Moderation.Inventory.MODERATION_INVENTORY_CLICK;
import fr.highsky.roleplay.Gestion.Moderation.Inventory.MODERATION_REASON_CLICK;
import fr.highsky.roleplay.Gestion.Moderation.Inventory.MODERATION_TEMP_CLICK;
import fr.highsky.roleplay.Gestion.Moderation.Utils.MODERATION_UTILS;
import fr.highsky.roleplay.Other.Furnace.FURNACE;
import fr.highsky.roleplay.Equipement.NO_REPAIR;
import fr.highsky.roleplay.Equipement.Utils.SPEED_GESTION;
import fr.highsky.roleplay.Events.JOIN_EVENT;
import fr.highsky.roleplay.Commands.Quests.CLICK_NPC;
import fr.highsky.roleplay.Commands.Quests.REGION_JOIN_LEAVE;
import fr.highsky.roleplay.Other.ANTI_VOID;
import fr.highsky.roleplay.Other.Furnace.INVENTORY_FURNACE;
import fr.highsky.roleplay.Other.Site.BUY;
import fr.highsky.roleplay.Other.Site.VOTE;
import fr.highsky.roleplay.Other.TopIslands.TopIslandRunnable;
import fr.highsky.roleplay.Other.TopMoney.GetTop;
import fr.highsky.roleplay.Other.WELCOME_COMMAND;
import fr.highsky.roleplay.Events.PinataEvent.RUNNABLE_PINATA;
import fr.highsky.roleplay.Events.PlayTime.PT_MENU;
import fr.highsky.roleplay.Events.PlayTime.PT_RECUP;
import fr.highsky.roleplay.Commands.Quests.QUESTS_CLICK_INVENTORY;
import fr.highsky.roleplay.Commands.Quests.QUESTS_INVENTORY;
import fr.highsky.roleplay.Gestion.ScoreBoard.DISABLE_SCOREBOARD;
import fr.highsky.roleplay.Gestion.ScoreBoard.Event.SBJoin;
import fr.highsky.roleplay.Gestion.ScoreBoard.ScoreBoardRunnable;
import fr.highsky.roleplay.Economy.Shop.Citizens.NPC_SHOP_OPEN;
import fr.highsky.roleplay.Economy.Shop.Commands.SellCommands;
import fr.highsky.roleplay.Economy.Shop.Commands.Shop;
import fr.highsky.roleplay.Economy.Shop.Events.CLICK_SHOP;
import fr.highsky.roleplay.Economy.Shop.Utils.Runnable;
import fr.highsky.roleplay.Chat.Tag.Commands.TagCommand;
import fr.highsky.roleplay.Chat.Tag.Listeners.TagListener;
import fr.highsky.roleplay.Chat.Tag.TagsMenu.TagsEvent;
import fr.highsky.roleplay.Chat.Tag.TagsMenu.TagsMenu;
import fr.highsky.roleplay.Chat.Tag.TagsUtils.Database;
import fr.highsky.roleplay.Chat.Tag.TagsUtils.TagRunnable;
import fr.highsky.roleplay.Commands.TempFly.TFLY_COMMAND;
import fr.highsky.roleplay.Commands.TempFly.TFLY_EVENT;
import fr.highsky.roleplay.Utils.FILE_UTILS;
import fr.highsky.roleplay.Commands.WeeklyQuest.*;
import fr.highsky.roleplay.Commands.XP_Bottle.XP_BOTTLE_COMMAND;
import fr.highsky.roleplay.Commands.XP_Bottle.XP_BOTTLE_RIGHTCLICK;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Main extends JavaPlugin {

    public static HashMap<UUID, String> mapTAG = new HashMap();

    private static Main instance;

    @Override
    public void onEnable() {

        saveDefaultConfig();
        instance = this;

        /*AUTOMESSAGE
        AUTO_MESSAGE.mess();
        AUTO_MESSAGE automess = new AUTO_MESSAGE();
        automess.runTaskTimerAsynchronously(this, 0, 600);*/

        //FARMER
        try {
            FILE_UTILS.addfile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //TAG

        try {
            this.reloadTag();
        } catch (SQLException var2) {
        }
        Bukkit.getPluginManager().registerEvents(new TagListener(), this);
        this.getCommand("tag").setExecutor(new TagCommand());

        TagRunnable inso = new TagRunnable(this);
        inso.runTaskTimerAsynchronously(this, 0, 20*60);

        this.getCommand("tags").setExecutor(new TagsMenu());
        Bukkit.getPluginManager().registerEvents(new TagsEvent(), this);

        //EVENTS
          //NPC
        getCommand("quests").setExecutor(new QUESTS_INVENTORY());
        Bukkit.getPluginManager().registerEvents(new QUESTS_CLICK_INVENTORY(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_NPC(), this);
        Bukkit.getPluginManager().registerEvents(new JOIN_EVENT(), this);
          //SEEDS
        //Bukkit.getPluginManager().registerEvents(new SEEDS_GESTION(), this);
          //LOG
        //Bukkit.getPluginManager().registerEvents(new LOG_GESTION(), this);
          //REGION EVENT
        Bukkit.getPluginManager().registerEvents(new REGION_JOIN_LEAVE(), this);
          //NO REPAIR
        Bukkit.getPluginManager().registerEvents(new NO_REPAIR(), this);

        //BLACKMARKET
        Bukkit.getPluginManager().registerEvents(new FRAGMENTS_RIGHT_CLICK(), this);
        Bukkit.getPluginManager().registerEvents(new BM_INVENTORY(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_BM_INVENTORY(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_RANK_BM(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_KEY_BM(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_BUY_BM(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_COMMANDS_BM(), this);
        BM_RUNNABLE task3 = new BM_RUNNABLE();
        task3.runTaskTimer(this, 0, 20*60);

        //EQUIPEMENT
        Bukkit.getPluginManager().registerEvents(new SPEED_GESTION(), this);



        //CHAT
        Bukkit.getPluginManager().registerEvents(new SEND_CHAT(), this);
        getCommand("togglechat").setExecutor(new TOGGLE_CHAT());

        //LAG
        //Bukkit.getPluginManager().registerEvents(new NO_AI_ENTITY(), this);


        //BOX
          //KEY BOX
        getCommand("box").setExecutor(new S_COMMANDS());
        Bukkit.getPluginManager().registerEvents(new S_EVENTS(this), this);
        //GeneratorParticleTask task = new GeneratorParticleTask();
        //ask.runTaskTimerAsynchronously(this, 10, 1);
          //XP BOX
        getCommand("xpbox").setExecutor(new XP_BOXS_COMMANDS());
        Bukkit.getPluginManager().registerEvents(new XP_BOXS_CLICK(), this);
        Bukkit.getPluginManager().registerEvents(new XP_BOXS_CLICK_INVENTORY(), this);



        //SHOP
        Runnable task2 = new Runnable();
        task2.runTaskTimer(this, 0, 20*60);
        WQ_RUNNABLE task10 = new WQ_RUNNABLE();
        task10.runTaskTimerAsynchronously(this, 0, 20*60);
          //VILLAGER
        ENTITY_SPAWN.spawnonEnable();
        Bukkit.getPluginManager().registerEvents(new VILLAGER_CLICK(), this);
        Bukkit.getPluginManager().registerEvents(new FIGHT_VILLAGER(), this);

        getCommand("shop").setExecutor(new Shop());
        getCommand("sell").setExecutor(new SellCommands());
        getCommand("sellstick").setExecutor(new GIVE_SELLSTICK());
        Bukkit.getPluginManager().registerEvents(new NPC_SHOP_OPEN(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_SHOP(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_BUY(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_SELL(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_CHEST(), this);
        Bukkit.getPluginManager().registerEvents(new CLICK_INVENTORY(), this);

        //Scoreboard
        Bukkit.getPluginManager().registerEvents(new SBJoin(this), this);
        ScoreBoardRunnable task4 = new ScoreBoardRunnable();
        task4.runTaskTimer(this, 0, 300);
        getCommand("scoreboard").setExecutor(new DISABLE_SCOREBOARD());

        /*Particules
        PARTICULE_INVENTORY menu = new PARTICULE_INVENTORY();
        menu.register();
        Bukkit.getPluginManager().registerEvents(new PARTICULE_CLICK_INVENTORY(), this);
        Bukkit.getPluginManager().registerEvents(new PARTICULE_QUITTE(), this);
        Bukkit.getPluginManager().registerEvents(new PARTICULE_MOUVEMENT(), this);
        this.getCommand("particules").setExecutor(new PARTICULE_COMMAND());

        //Pet
        Bukkit.getPluginManager().registerEvents(new PET_EVENT(), this);
        Bukkit.getPluginManager().registerEvents(new PET_CLICK_INVENTORY(), this);
        this.getCommand("pets").setExecutor(new PET_COMMAND());
           */
        //OTHER
        Bukkit.getPluginManager().registerEvents(new ANTI_VOID(), this);
          //Top-Money
        GetTop task5 = new GetTop(this);
        task5.runTaskTimer(this, 0, 12000);
          //Top Ilsand
        TopIslandRunnable task6 = new TopIslandRunnable();
        task6.runTaskTimer(this, 0, 12000);
          //BUY
        getCommand("achat").setExecutor(new BUY());
          //VOTE
        getCommand("avote").setExecutor(new VOTE());
          //BVN
        Bukkit.getPluginManager().registerEvents(new WELCOME_COMMAND(), this);
        getCommand("bvn").setExecutor(new WELCOME_COMMAND());


        //FURNACE
        getCommand("furnace").setExecutor(new FURNACE());
        Bukkit.getPluginManager().registerEvents(new INVENTORY_FURNACE(), this);

        //DAYLIQUEST
        getCommand("dq").setExecutor(new DQ_INVENTORY());
        Bukkit.getPluginManager().registerEvents(new DQ_CLICK_INVENTORY(), this);
        DQ_RUNNABLE task7 = new DQ_RUNNABLE();
        task7.runTaskTimer(this, 0, 20*60);

        //WEEKLYQUEST
        getCommand("wq").setExecutor(new WQ_INVENTORY());
        Bukkit.getPluginManager().registerEvents(new WQ_CLICKBEACON(), this);
        Bukkit.getPluginManager().registerEvents(new WQ_CLICKITEM(), this);
        Bukkit.getPluginManager().registerEvents(new WQ_CLICKWINDOW(), this);
        Bukkit.getPluginManager().registerEvents(new WQ_CONFIRMCLICK(), this);
        Bukkit.getPluginManager().registerEvents(new WQ_GOLDCLICK(), this);
        Bukkit.getPluginManager().registerEvents(new WQ_RETURNCLICK(), this);
        Bukkit.getPluginManager().registerEvents(new WQ_CLICLDIAMOND(), this);
        WQ_RUNNABLE task8 = new WQ_RUNNABLE();
        task8.runTaskTimerAsynchronously(this, 0, 20*60);

        //MENU
        getCommand("menu").setExecutor(new MENU_INVENTORY());
        Bukkit.getPluginManager().registerEvents(new MENU_CLICK_INVENTORY(), this);

        //MINE
        getCommand("minepaste").setExecutor(new MineCommand());
        getCommand("minereset").setExecutor(new ResetMineCommand());


        //PINATA
        RUNNABLE_PINATA task9 = new RUNNABLE_PINATA();
        task9.runTaskTimer(this, 0, 20*60);


        //MODERATION
        getCommand("staff").setExecutor(new MODERATION_INVENTORY());
        Bukkit.getPluginManager().registerEvents(new BANNED_JOIN(), this);
        Bukkit.getPluginManager().registerEvents(new MUTE_SPEAK(), this);

        Bukkit.getPluginManager().registerEvents(new MODERATION_INVENTORY_CLICK(), this);
        Bukkit.getPluginManager().registerEvents(new MODERATION_TEMP_CLICK(), this);
        Bukkit.getPluginManager().registerEvents(new MODERATION_REASON_CLICK(), this);


        //FLY
        getCommand("fly").setExecutor(new TFLY_COMMAND());
        Bukkit.getPluginManager().registerEvents(new TFLY_EVENT(), this);
        Bukkit.getPluginManager().registerEvents(new QUIT_EVENT(), this);

        //BOTTLE XP
        getCommand("convertxp").setExecutor(new XP_BOTTLE_COMMAND());
        Bukkit.getPluginManager().registerEvents(new XP_BOTTLE_RIGHTCLICK(), this);

        try {
            MODERATION_UTILS.newFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //PLAYTIME
        getCommand("pt").setExecutor(new PT_MENU());
        Bukkit.getPluginManager().registerEvents(new PT_RECUP(), this);

        //MAINTENANCE
        getCommand("maintenance").setExecutor(new MAINTENANCE_COMMAND());

        //DAY-GIFT
        getCommand("daygift").setExecutor(new DG_INVENTORY());

        //LOOTSBOXS
        getCommand("LootsBoxs").setExecutor(new GiveCommand());
        Bukkit.getPluginManager().registerEvents(new KillMobs(), this);
        Bukkit.getPluginManager().registerEvents(new PlaceLootsBox(this), this);

    }

    @Override
    public void onDisable() {

        //MODERARTION
        try {
            MODERATION_UTILS.save();
        } catch (IOException e) {
            e.printStackTrace();
        }

        REGION_JOIN_LEAVE.woodRegion.clear();

        //TAG
        try {
            this.saveActiveTag();
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

        mapTAG.clear();

    }

    private void reloadTag() throws SQLException {
        Connection cn = Database.connect();
        String query = "SELECT idTags FROM tag_used WHERE UUID = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        Iterator var4 = Bukkit.getOnlinePlayers().iterator();

        while(var4.hasNext()) {

            Player online = (Player)var4.next();
            ps.setString(1, online.getUniqueId().toString());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int tag = rs.getInt("idTags");
                if (tag != 0) {
                    mapTAG.put(online.getUniqueId(), Database.RecupTag(tag));
                }
            }
        }

    }

    private void saveActiveTag() throws SQLException {
        Connection cn = Database.connect();
        String query = "SELECT idTags FROM tag_used WHERE UUID = ?";
        PreparedStatement ps = cn.prepareStatement(query);
        Iterator var4 = Bukkit.getOnlinePlayers().iterator();

        while(var4.hasNext()) {
            Player p = (Player)var4.next();
            if (mapTAG.containsKey(p.getUniqueId())) {
                String tag = (String)mapTAG.get(p.getUniqueId());
                if (tag != null && tag != "") {
                    ps.setString(1, p.getUniqueId().toString());
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        if (!tag.equalsIgnoreCase(Database.RecupTag(rs.getInt("idTags")))) {
                            int tags = Database.RecupId(tag.replace("§","&"));
                            System.out.println("Update dans la BDD >> " + tag + " >> " + rs.getInt("idTags"));
                            query = "UPDATE tag_used SET idTags = ? WHERE UUID = ?";
                            ps = cn.prepareStatement(query);
                            ps.setInt(1, tags);
                            ps.setString(2, p.getUniqueId().toString());
                            ps.executeUpdate();
                        }
                    } else {
                        int tags = Database.RecupId(tag.replace("§","&"));
                        System.out.println("Inscription dans la BDD");
                        query = "INSERT INTO tag_used (UUID, idTags) VALUES (?, ?)";
                        ps = cn.prepareStatement(query);
                        ps.setString(1, p.getUniqueId().toString());
                        ps.setInt(2, tags);
                        ps.executeUpdate();
                    }

                    mapTAG.remove(p.getUniqueId());
                }
            }
        }

        ps.close();
        cn.close();
    }

    public static Main getInstance() { return instance; }
}
