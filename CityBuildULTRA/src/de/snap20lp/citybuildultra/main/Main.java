package de.snap20lp.citybuildultra.main;
/*

  This project was developed by Furkan  
                                                             
      Private Discord: Furkan.#4554                
                                                                                                                      
           created at 03.01.2020
                                                              
        Project: CityBuildULTRA        
                                        
© 2019-2020 SnapDevStudios All Rights Reserved.

                                         
*/

import de.snap20lp.citybuildultra.commands.*;
import de.snap20lp.citybuildultra.listeners.OnCommand;
import de.snap20lp.citybuildultra.listeners.OnDeath;
import de.snap20lp.citybuildultra.listeners.OnJoin;
import de.snap20lp.citybuildultra.listeners.OnLeave;
import de.snap20lp.citybuildultra.util.MySQL;
import de.snap20lp.citybuildultra.util.UUIDFetcher;
import de.snap20lp.citybuildultra.util.VerifyUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {

    private final String prefix = getConfig().getString("prefix");
    public MySQL mySQL;
    private FileManager fileManager;

    private UUIDFetcher uuidFetcher;
    private VerifyUtil verifyUtil;
    private String serverVersion;

    public String getServerVersion() {
        return serverVersion;
    }

    public static Main getInstance() {
        return getPlugin(Main.class);
    }

    public String getPrefix() {
        return prefix;
    }

    public MySQL getMySQL() {
        return mySQL;
    }

    private void registerCommands() {
        getCommand("setspawn").setExecutor(new SetSpawn());
        if (getConfig().getBoolean("heal.enabled")) {
            getCommand("heal").setExecutor(new Heal());
        }
        if (getConfig().getBoolean("day.enabled")) {
            getCommand("day").setExecutor(new Day());
        }
        if (getConfig().getBoolean("night.enabled")) {
            getCommand("night").setExecutor(new Night());
        }
        if (getConfig().getBoolean("fire.enabled")) {
            getCommand("fire").setExecutor(new Fire());
        }
        if (getConfig().getBoolean("gamemode.enabled")) {
            getCommand("gm").setExecutor(new Gamemode());
        }
        if (getConfig().getBoolean("money.enabled")) {
            getCommand("money").setExecutor(new Money());
        }
        if (getConfig().getBoolean("pay.enabled")) {
            getCommand("pay").setExecutor(new Pay());
        }
        if (getConfig().getBoolean("spawn.enabled")) {
            getCommand("spawn").setExecutor(new Spawn());
        }
        if (getConfig().getBoolean("fly.enabled")) {
            getCommand("fly").setExecutor(new Fly());
        }
    }

    private void registerEvents(PluginManager manager) {
        manager.registerEvents(new OnJoin(), this);
        manager.registerEvents(new OnCommand(), this);
        manager.registerEvents(new OnLeave(), this);
        manager.registerEvents(new OnDeath(), this);

    }

    public FileManager getFileManager() {
        return fileManager;
    }

    public String getLicence() {
        return "0";
    }

    public String getVersion() {
        return "2021.0.2";
    }



    public VerifyUtil getVerifyUtil() {
        return verifyUtil;
    }

    public UUIDFetcher getUuidFetcher() {
        return uuidFetcher;
    }

    @Override
    public void onEnable() {
            serverVersion = Bukkit.getBukkitVersion().split("-")[0];
            Bukkit.getConsoleSender().sendMessage("\n§8[§c§lSystem§8] §7Lade CityBuildULTRA fuer §aSPIGOT-" + serverVersion);
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
            Bukkit.getConsoleSender().sendMessage("\n");
            Bukkit.getConsoleSender().sendMessage("§8[§c§lSystem§8] §7Verbinde zu MySQL Datenbank...");
            mySQL = new MySQL();
            if (!mySQL.isIsconnected()) {
                Bukkit.getConsoleSender().sendMessage("§8[§c§lSystem§8] §cMySQL Datenbank konnte nicht erreicht werden (Falsches Passwort?). Shutdown...");
                onDisable();
                return;
            }
            verifyUtil = new VerifyUtil();
            if (verifyUtil.isInstanceGranted()) {
                Bukkit.getConsoleSender().sendMessage("§8[§c§lModule loader§8] §7Instanziiere Klassen...");
                fileManager = new FileManager();
                fileManager.createFiles();
                fileManager.initConfigHeal();
                fileManager.initConfigDay();
                fileManager.initConfigNight();
                fileManager.initConfigFire();
                fileManager.initConfigGamemode();
                fileManager.initConfigJoin();
                fileManager.initConfigMoney();
                fileManager.initConfigPay();
                fileManager.initConfigLeave();
                fileManager.initConfigDeath();
                fileManager.initConfigSpawn();
                fileManager.initConfigFly();
                registerCommands();
                registerEvents(Bukkit.getPluginManager());
                Bukkit.getConsoleSender().sendMessage("\n");
                Bukkit.getConsoleSender().sendMessage("§aCityBuildULTRA");
                Bukkit.getConsoleSender().sendMessage("§eVersion " + getVersion());
                Bukkit.getConsoleSender().sendMessage("§7AccessToken §a" + getLicence() + "§f\n");
                Bukkit.getConsoleSender().sendMessage("§aCityBuildULTRA " + getVersion() + " §7erfolgreich gestartet! §8| §7Verbunden mit Server: §5§lEUW-" + "none§f" + "\n");
                uuidFetcher = new UUIDFetcher();
            } else {

            }
    }
}


