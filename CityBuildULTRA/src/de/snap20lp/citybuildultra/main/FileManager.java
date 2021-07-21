package de.snap20lp.citybuildultra.main;
/*

  This project was developed by Furkan

      Private Discord: Furkan.#4554

           created at 03.01.2020

        Project: CityBuildULTRA

© 2019-2020 SnapDevStudios All Rights Reserved.


*/

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public static File getHealFile() {
        return new File("plugins/CityBuildULTRA/Commands/heal.yml");
    }

    public static File getDayFile() {
        return new File("plugins/CityBuildULTRA/Commands/day.yml");
    }

    public static File getNightFile() {
        return new File("plugins/CityBuildULTRA/Commands/night.yml");
    }

    public static File getFireFile() {
        return new File("plugins/CityBuildULTRA/Commands/fire.yml");
    }

    public static File getGamemodeFile() {
        return new File("plugins/CityBuildULTRA/Commands/gamemode.yml");
    }

    public static File getJoinFile() {
        return new File("plugins/CityBuildULTRA/Events/join.yml");
    }

    public static File getSpawnsFile() {
        return new File("plugins/CityBuildULTRA/Data/Spawns.yml");
    }

    public static File getMoneyFile() {
        return new File("plugins/CityBuildULTRA/Commands/money.yml");
    }

    public static File getPayFile() {
        return new File("plugins/CityBuildULTRA/Commands/pay.yml");
    }

    public static File getFlyFile() {
        return new File("plugins/CityBuildULTRA/Commands/fly.yml");
    }

    public static File getSpawnFile() {
        return new File("plugins/CityBuildULTRA/Commands/spawn.yml");
    }

    public static File getLeaveFile() {
        return new File("plugins/CityBuildULTRA/Events/leave.yml");
    }

    public static File getDeathFile() {
        return new File("plugins/CityBuildULTRA/Events/death.yml");
    }

    public File getDirectory() {
        return new File("plugins/CityBuildULTRA");
    }

    public YamlConfiguration getHealYML() {
        return YamlConfiguration.loadConfiguration(getHealFile());
    }

    public YamlConfiguration getDayYML() {
        return YamlConfiguration.loadConfiguration(getDayFile());
    }

    public YamlConfiguration getNightYML() {
        return YamlConfiguration.loadConfiguration(getNightFile());
    }

    public YamlConfiguration getFireYML() {
        return YamlConfiguration.loadConfiguration(getFireFile());
    }

    public YamlConfiguration getGamemodeYML() {
        return YamlConfiguration.loadConfiguration(getGamemodeFile());
    }

    public YamlConfiguration getJoinYML() {
        return YamlConfiguration.loadConfiguration(getJoinFile());
    }

    public YamlConfiguration getSpawnsYML() {
        return YamlConfiguration.loadConfiguration(getSpawnsFile());
    }

    public YamlConfiguration getMoneyYML() {
        return YamlConfiguration.loadConfiguration(getMoneyFile());
    }

    public YamlConfiguration getPayYML() {
        return YamlConfiguration.loadConfiguration(getPayFile());
    }

    public YamlConfiguration getFlyYML() {
        return YamlConfiguration.loadConfiguration(getFlyFile());
    }

    public YamlConfiguration getSpawnYML() {
        return YamlConfiguration.loadConfiguration(getSpawnFile());
    }

    public YamlConfiguration getLeaveYML() {
        return YamlConfiguration.loadConfiguration(getLeaveFile());
    }

    public YamlConfiguration getDeathYML() {
        return YamlConfiguration.loadConfiguration(getDeathFile());
    }


    public void initConfigDeath() {
        FileConfiguration cfg = getDeathYML();
        cfg.addDefault("death.money.lose.enabled", false);
        cfg.addDefault("death.money.lose.money", 500);
        cfg.addDefault("death.self.message.enabled", true);
        cfg.addDefault("death.self.message.message", "%PREFIX%§cDu bist gestorben! §7Und hast §c%LOST_MONEY% §8$ §7verloren!");
        cfg.addDefault("death.broadcast.enabled", true);
        cfg.addDefault("death.broadcast.message", "%PREFIX%§a%PLAYER%§7 ist gestorben!");
        cfg.addDefault("death.sound.enabled", true);
        cfg.addDefault("death.sound.sound", "ANVIL_LAND");
        cfg.addDefault("death.sound.pitch", 1);
        cfg.addDefault("death.autorespawn.enabled", true);
        cfg.addDefault("death.autorespawn.delayseconds", 1);
        cfg.addDefault("death.respawnatspawn.enabled", true);
        cfg.addDefault("death.respawnother.world", "world");
        cfg.addDefault("death.respawnother.x", "0");
        cfg.addDefault("death.respawnother.y", "0");
        cfg.addDefault("death.respawnother.z", "0");
        cfg.addDefault("death.keepinventory", false);
        cfg.addDefault("death.keeplevel", false);
        cfg.addDefault("death.dropitems.enabled", true);
        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getDeathFile());
        } catch (IOException e1) {
        }
    }

    public void initConfigSpawn() {
        FileConfiguration cfg = getSpawnYML();
        cfg.addDefault("messages.commands.spawn.syntax.message.enabled", true);
        cfg.addDefault("messages.commands.spawn.syntax.message.message", "§7Bitte verwende §8/§aSpawn");
        cfg.addDefault("messages.commands.spawn.syntax.sound.pitch", 1);
        cfg.addDefault("messages.commands.spawn.syntax.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.spawn.syntax.sound.enabled", true);
        cfg.addDefault("messages.commands.spawn.message.message", "§7Du hast dich erfolgreich zum spawn teleportiert!");
        cfg.addDefault("messages.commands.spawn.message.enabled", true);
        cfg.addDefault("messages.commands.spawn.permission.perm", "REPLACETHIS.spawn.use");
        cfg.addDefault("messages.commands.spawn.permission.enabled", false);
        cfg.addDefault("messages.commands.spawn.sound.pitch", 1);
        cfg.addDefault("messages.commands.spawn.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.spawn.sound.enabled", true);
        cfg.addDefault("messages.commands.spawn.teleport.delay.enabled", true);
        cfg.addDefault("messages.commands.spawn.teleport.delay.sec", 3);
        cfg.addDefault("messages.commands.spawn.teleport.delay.nomove", true);
        cfg.addDefault("messages.commands.spawn.teleport.delay.message.enabled", true);
        cfg.addDefault("messages.commands.spawn.teleport.delay.message.message", "§7Teleportiere in §a%SECONDS%");
        cfg.addDefault("messages.commands.spawn.teleport.delay.sound.pitch", 1);
        cfg.addDefault("messages.commands.spawn.teleport.delay.sound.sound", "ORB_PICKUP");
        cfg.addDefault("messages.commands.spawn.teleport.delay.abort.sound.enabled", true);
        cfg.addDefault("messages.commands.spawn.teleport.delay.sound.pitch", 1);
        cfg.addDefault("messages.commands.spawn.teleport.delay.sound.sound", "ORB_PICKUP");
        cfg.addDefault("messages.commands.spawn.teleport.delay.sound.enabled", true);
        cfg.addDefault("messages.commands.spawn.teleport.delay.abort.sound.pitch", 1);
        cfg.addDefault("messages.commands.spawn.teleport.delay.abort.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.spawn.teleport.delay.abort.sound.enabled", true);
        cfg.addDefault("messages.commands.spawn.teleport.delay.abort.message.message", "§cDu hast dich bewegt. Teleportation abgebrochen!");
        cfg.addDefault("messages.commands.spawn.teleport.delay.abort.message.enabled", true);
        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getSpawnFile());
        } catch (IOException e1) {
        }
    }

    public void initConfigLeave() {
        FileConfiguration cfg = getLeaveYML();
        cfg.addDefault("leave.broadcast.enabled", true);
        cfg.addDefault("leave.broadcast.message", "%PREFIX%§a%PLAYER%§7 hat den Server verlassen");
        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getLeaveFile());
        } catch (IOException e1) {
        }
    }

    public void initConfigJoin() {
        FileConfiguration cfg = getJoinYML();
        cfg.addDefault("join.money.start", "500");
        cfg.addDefault("join.title.enabled", true);
        cfg.addDefault("join.title.title.1", "§8» §aWillkommen ;)");
        cfg.addDefault("join.title.title.2", "§7Vielen Dank dass du dieses heruntergeladne hast!");
        cfg.addDefault("join.sound.pitch", 1);
        cfg.addDefault("join.sound.sound", "LEVEL_UP");
        cfg.addDefault("join.sound.enabled", true);
        cfg.addDefault("join.broadcast.enabled", true);
        cfg.addDefault("join.broadcast.message", "%PREFIX%§a%PLAYER%§7 ist dem Server beigetreten");
        cfg.addDefault("join.messages.message", "§8§m---------------------------------------------------\n\n§a§lWillkommen §7in §aCityBuild§a§lULTRA §9§l%PLAYER%\n§7Diese Nachricht kannst du in der join.yml ändern ;)\n\n§8§m---------------------------------------------------");
        cfg.addDefault("join.messages.enabled", true);
        cfg.addDefault("join.spawn.joinonspawn.enabled", true);
        cfg.addDefault("join.spawn.joinonworld.enabled", false);
        cfg.addDefault("join.spawn.joinonworld.world", "world");
        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getJoinFile());
        } catch (IOException e1) {
        }
    }

    public void initConfigMoney() {
        FileConfiguration cfg = getMoneyYML();

        cfg.addDefault("messages.commands.money.syntax.message.enabled", true);
        cfg.addDefault("messages.commands.money.syntax.message.message", "§7Bitte verwende §8/§aMoney §8<§aSPIELER§8>");
        cfg.addDefault("messages.commands.money.syntax.sound.pitch", 1);
        cfg.addDefault("messages.commands.money.syntax.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.money.syntax.sound.enabled", true);
        cfg.addDefault("messages.commands.money.message.message", "§7Du hast §a§l%MONEY% §8$");
        cfg.addDefault("messages.commands.money.message.enabled", true);
        cfg.addDefault("messages.commands.money.permission.perm", "REPLACETHIS.money.use");
        cfg.addDefault("messages.commands.money.permission.enabled", false);
        cfg.addDefault("messages.commands.money.sound.pitch", 1);
        cfg.addDefault("messages.commands.money.sound.sound", "ORB_PICKUP");
        cfg.addDefault("messages.commands.money.sound.enabled", true);

        cfg.addDefault("messages.commands.moneyother.notonline.message", "§7Der Spieler §a%TARGET% §7ist nicht in der Datenbank registriert");
        cfg.addDefault("messages.commands.moneyother.notonline.sound.pitch", 1);
        cfg.addDefault("messages.commands.moneyother.notonline.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.moneyother.notonline.sound.enabled", true);
        cfg.addDefault("messages.commands.moneyother.self.message.message", "§a%TARGET% §7hat §a§l%TARGET_MONEY% §8$");
        cfg.addDefault("messages.commands.moneyother.self.message.enabled", true);
        cfg.addDefault("messages.commands.moneyother.self.sound.pitch", 1);
        cfg.addDefault("messages.commands.moneyother.self.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.moneyother.self.sound.enabled", true);
        cfg.addDefault("messages.commands.moneyother.self.permission.perm", "REPLACETHIS.money.other.use");
        cfg.addDefault("messages.commands.moneyother.self.permission.enabled", false);

        cfg.addDefault("messages.commands.moneyadmin.syntax.give.message.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.syntax.give.message.message", "§7Bitte verwende §8/§aMoney §8<§aADD/REMOVE/RESET§8> §8<§aSPIELER§8> §8<§aMONEY§8>");
        cfg.addDefault("messages.commands.moneyadmin.syntax.give.sound.pitch", 1);
        cfg.addDefault("messages.commands.moneyadmin.syntax.give.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.moneyadmin.syntax.give.sound.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.give.permission.perm", "REPLACETHIS.money.give.use");
        cfg.addDefault("messages.commands.moneyadmin.give.permission.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.give.message.message", "§7Du hast §a§l%GAVE_MONEY%§8 $§7 an §a%TARGET%§7 überwiesen.");
        cfg.addDefault("messages.commands.moneyadmin.give.message.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.give.sound.pitch", 1);
        cfg.addDefault("messages.commands.moneyadmin.give.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.moneyadmin.give.sound.enabled", true);

        cfg.addDefault("messages.commands.moneyadmin.syntax.remove.message.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.syntax.remove.message.message", "§7Bitte verwende §8/§aMoney §8<§aADD/REMOVE/RESET§8> §8<§aSPIELER§8> §8<§aMONEY§8>");
        cfg.addDefault("messages.commands.moneyadmin.syntax.remove.sound.pitch", 1);
        cfg.addDefault("messages.commands.moneyadmin.syntax.remove.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.moneyadmin.syntax.remove.sound.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.remove.permission.perm", "REPLACETHIS.money.remove.use");
        cfg.addDefault("messages.commands.moneyadmin.remove.permission.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.remove.message.message", "§7Du hast §a§l%REMOVE_MONEY% §8$§7 von §a%TARGET% §7entzogen");
        cfg.addDefault("messages.commands.moneyadmin.remove.message.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.remove.sound.pitch", 1);
        cfg.addDefault("messages.commands.moneyadmin.remove.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.moneyadmin.remove.sound.enabled", true);

        cfg.addDefault("messages.commands.moneyadmin.syntax.reset.message.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.syntax.reset.message.message", "§7Bitte verwende §8/§aMoney §8<§aADD/REMOVE/RESET§8> §8<§aSPIELER§8> §8<§aMONEY§8>");
        cfg.addDefault("messages.commands.moneyadmin.syntax.reset.sound.pitch", 1);
        cfg.addDefault("messages.commands.moneyadmin.syntax.reset.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.moneyadmin.syntax.reset.sound.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.reset.permission.perm", "REPLACETHIS.money.reset.use");
        cfg.addDefault("messages.commands.moneyadmin.reset.permission.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.reset.message.message", "§7Du hast das Konto von §a%TARGET% §7geleert");
        cfg.addDefault("messages.commands.moneyadmin.reset.message.enabled", true);
        cfg.addDefault("messages.commands.moneyadmin.reset.sound.pitch", 1);
        cfg.addDefault("messages.commands.moneyadmin.reset.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.moneyadmin.reset.sound.enabled", true);


        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getMoneyFile());
        } catch (IOException e1) {
        }
    }


    public void initConfigGamemode() {
        FileConfiguration cfg = getGamemodeYML();

        cfg.addDefault("messages.commands.gamemode.gamemode.creative", "KREATIV");
        cfg.addDefault("messages.commands.gamemode.gamemode.survival", "ÜBERLEBEN");
        cfg.addDefault("messages.commands.gamemode.gamemode.adventure", "ARBENTEUER");
        cfg.addDefault("messages.commands.gamemode.gamemode.spectator", "ZUSCHAUER");

        cfg.addDefault("messages.commands.gamemode.syntax.message.enabled", true);
        cfg.addDefault("messages.commands.gamemode.syntax.message.message", "§7Bitte verwende §8/§aGm §8<§aGAMEMODE§8> §8<§aSPIELER§8>");
        cfg.addDefault("messages.commands.gamemode.syntax.sound.pitch", 1);
        cfg.addDefault("messages.commands.gamemode.syntax.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.gamemode.syntax.sound.enabled", true);
        cfg.addDefault("messages.commands.gamemode.message.message", "§7Du hast dein Spielmodus zu §a%GAMEMODE%§7 geändert!");
        cfg.addDefault("messages.commands.gamemode.message.enabled", true);
        cfg.addDefault("messages.commands.gamemode.permission.perm", "REPLACETHIS.gamemode.use");
        cfg.addDefault("messages.commands.gamemode.permission.enabled", true);
        cfg.addDefault("messages.commands.gamemode.sound.pitch", 1);
        cfg.addDefault("messages.commands.gamemode.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.gamemode.sound.enabled", true);

        cfg.addDefault("messages.commands.gamemodeother.notonline.message", "§7Der Spieler §a%TARGET% §7ist nicht online");
        cfg.addDefault("messages.commands.gamemodeother.notonline.sound.pitch", 1);
        cfg.addDefault("messages.commands.gamemodeother.notonline.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.gamemodeother.notonline.sound.enabled", true);
        cfg.addDefault("messages.commands.gamemodeother.target.message.message", "§a%PLAYER% §7hat deinen Spielmodus zu §a§l%GAMEMODE%§7 geändert");
        cfg.addDefault("messages.commands.gamemodeother.target.message.enabled", true);
        cfg.addDefault("messages.commands.gamemodeother.target.sound.pitch", 1);
        cfg.addDefault("messages.commands.gamemodeother.target.sound.sound", "ORB_PICKUP");
        cfg.addDefault("messages.commands.gamemodeother.target.sound.enabled", true);
        cfg.addDefault("messages.commands.gamemodeother.self.message.message", "§7Du hast den Spielmodus von §a%TARGET% §7geändert!");
        cfg.addDefault("messages.commands.gamemodeother.self.message.enabled", true);
        cfg.addDefault("messages.commands.gamemodeother.self.sound.pitch", 1);
        cfg.addDefault("messages.commands.gamemodeother.self.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.gamemodeother.self.sound.enabled", true);
        cfg.addDefault("messages.commands.gamemodeother.self.permission.perm", "REPLACETHIS.gamemode.other.use");
        cfg.addDefault("messages.commands.gamemodeother.self.permission.enabled", true);

        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getGamemodeFile());
        } catch (IOException e1) {
        }
    }

    public void initConfigHeal() {
        FileConfiguration cfg = getHealYML();

        cfg.addDefault("messages.commands.heal.healvalue", 20);
        cfg.addDefault("messages.commands.heal.syntax.message.enabled", true);
        cfg.addDefault("messages.commands.heal.syntax.message.message", "§7Bitte verwende §8/§aHeal §8<§aSPIELER§8>");
        cfg.addDefault("messages.commands.heal.syntax.sound.pitch", 1);
        cfg.addDefault("messages.commands.heal.syntax.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.heal.syntax.sound.enabled", true);
        cfg.addDefault("messages.commands.heal.message.message", "§7Du hast dich erfolgreich §ageheilt!");
        cfg.addDefault("messages.commands.heal.message.enabled", true);
        cfg.addDefault("messages.commands.heal.permission.perm", "REPLACETHIS.heal.use");
        cfg.addDefault("messages.commands.heal.permission.enabled", true);
        cfg.addDefault("messages.commands.heal.sound.pitch", 1);
        cfg.addDefault("messages.commands.heal.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.heal.sound.enabled", true);

        cfg.addDefault("messages.commands.healother.healvalue", 20);
        cfg.addDefault("messages.commands.healother.notonline.message", "§7Der Spieler §a%TARGET% §7ist nicht online");
        cfg.addDefault("messages.commands.healother.notonline.sound.pitch", 1);
        cfg.addDefault("messages.commands.healother.notonline.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.healother.notonline.sound.enabled", true);
        cfg.addDefault("messages.commands.healother.target.message.message", "§7Du wurdest von §a%PLAYER% §7geheilt");
        cfg.addDefault("messages.commands.healother.target.message.enabled", true);
        cfg.addDefault("messages.commands.healother.target.sound.pitch", 1);
        cfg.addDefault("messages.commands.healother.target.sound.sound", "ORB_PICKUP");
        cfg.addDefault("messages.commands.healother.target.sound.enabled", true);
        cfg.addDefault("messages.commands.healother.self.message.message", "§7Du hast §a%TARGET% §7geheilt!");
        cfg.addDefault("messages.commands.healother.self.message.enabled", true);
        cfg.addDefault("messages.commands.healother.self.sound.pitch", 1);
        cfg.addDefault("messages.commands.healother.self.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.healother.self.sound.enabled", true);
        cfg.addDefault("messages.commands.healother.self.permission.perm", "REPLACETHIS.heal.other.use");
        cfg.addDefault("messages.commands.healother.self.permission.enabled", true);

        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getHealFile());
        } catch (IOException e1) {
        }
    }

    public void initConfigFly() {
        FileConfiguration cfg = getFlyYML();
        cfg.addDefault("messages.commands.fly.syntax.message.enabled", true);
        cfg.addDefault("messages.commands.fly.syntax.message.message", "§7Bitte verwende §8/§aFly §8<§aSPIELER§8>");
        cfg.addDefault("messages.commands.fly.syntax.sound.pitch", 1);
        cfg.addDefault("messages.commands.fly.syntax.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.fly.syntax.sound.enabled", true);
        cfg.addDefault("messages.commands.fly.message.flyon.message", "§7Du bist nun im §aFlugmodus");
        cfg.addDefault("messages.commands.fly.message.flyon.enabled", true);
        cfg.addDefault("messages.commands.fly.message.flyoff.message", "§7Du bist nun §anichtmehr§7 im Flugmodus");
        cfg.addDefault("messages.commands.fly.message.flyoff.enabled", true);
        cfg.addDefault("messages.commands.fly.sound.flyon.pitch", 1);
        cfg.addDefault("messages.commands.fly.sound.flyon.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.fly.sound.flyon.enabled", true);
        cfg.addDefault("messages.commands.fly.sound.flyoff.pitch", 1);
        cfg.addDefault("messages.commands.fly.sound.flyoff.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.fly.sound.flyoff.enabled", true);
        cfg.addDefault("messages.commands.fly.permission.perm", "REPLACETHIS.fly.use");
        cfg.addDefault("messages.commands.fly.permission.enabled", true);

        cfg.addDefault("messages.commands.flyother.self.message.flyon.message", "§a%TARGET%§7 ist nun im §aFlugmodus");
        cfg.addDefault("messages.commands.flyother.self.message.flyon.enabled", true);

        cfg.addDefault("messages.commands.flyother.self.message.flyon.message", "§a%TARGET%§7 ist nun im §aFlugmodus");
        cfg.addDefault("messages.commands.flyother.self.message.flyon.enabled", true);

        cfg.addDefault("messages.commands.flyother.self.message.flyoff.message", "§a%TARGET%§7 ist nun §anichtmehr §7im §aFlugmodus");
        cfg.addDefault("messages.commands.flyother.self.message.flyoff.enabled", true);

        cfg.addDefault("messages.commands.flyother.target.message.flyon.message", "§7Du bist nun im §aFlugmodus");
        cfg.addDefault("messages.commands.flyother.target.message.flyon.enabled", true);

        cfg.addDefault("messages.commands.flyother.target.message.flyoff.message", "§7Du bist nun §anichtmehr§7 im Flugmodus");
        cfg.addDefault("messages.commands.flyother.target.message.flyoff.enabled", true);

        cfg.addDefault("messages.commands.flyother.target.flyon.sound.pitch", 1);
        cfg.addDefault("messages.commands.flyother.target.flyon.sound.sound", "ORB_PICKUP");
        cfg.addDefault("messages.commands.flyother.target.flyon.sound.enabled", true);

        cfg.addDefault("messages.commands.flyother.target.flyoff.sound.pitch", 1);
        cfg.addDefault("messages.commands.flyother.target.flyoff.sound.sound", "ORB_PICKUP");
        cfg.addDefault("messages.commands.flyother.target.flyoff.sound.enabled", true);

        cfg.addDefault("messages.commands.flyother.self.flyon.sound.pitch", 1);
        cfg.addDefault("messages.commands.flyother.self.flyon.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.flyother.self.flyon.sound.enabled", true);

        cfg.addDefault("messages.commands.flyother.self.flyoff.sound.pitch", 1);
        cfg.addDefault("messages.commands.flyother.self.flyoff.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.flyother.self.flyoff.sound.enabled", true);

        cfg.addDefault("messages.commands.flyother.self.permission.perm", "REPLACETHIS.flyother.use");
        cfg.addDefault("messages.commands.flyother.self.permission.enabled", true);

        cfg.addDefault("messages.commands.flyother.notonline.message", "§7Der Spieler §a%TARGET% §7ist nicht online");
        cfg.addDefault("messages.commands.flyother.notonline.sound.pitch", 1);
        cfg.addDefault("messages.commands.flyother.notonline.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.flyother.notonline.sound.enabled", true);
        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getFlyFile());
        } catch (IOException e1) {
        }

    }


    public void initConfigDay() {
        FileConfiguration cfg = getDayYML();
        cfg.addDefault("messages.commands.day.syntax.message.enabled", true);
        cfg.addDefault("messages.commands.day.syntax.message.message", "§7Bitte verwende §8/§aDay");
        cfg.addDefault("messages.commands.day.syntax.sound.pitch", 1);
        cfg.addDefault("messages.commands.day.syntax.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.day.syntax.sound.enabled", true);
        cfg.addDefault("messages.commands.day.message.message", "§7Du hast die Zeit erfolgreich auf §aDAY §7gestellt!");
        cfg.addDefault("messages.commands.day.message.enabled", true);
        cfg.addDefault("messages.commands.day.permission.perm", "REPLACETHIS.day.use");
        cfg.addDefault("messages.commands.day.permission.enabled", true);
        cfg.addDefault("messages.commands.day.sound.pitch", 1);
        cfg.addDefault("messages.commands.day.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.day.sound.enabled", true);
        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getDayFile());
        } catch (IOException e1) {
        }

    }

    public void initConfigNight() {
        FileConfiguration cfg = getNightYML();
        cfg.addDefault("messages.commands.night.syntax.message.enabled", true);
        cfg.addDefault("messages.commands.night.syntax.message.message", "§7Bitte verwende §8/§aNight");
        cfg.addDefault("messages.commands.night.syntax.sound.pitch", 1);
        cfg.addDefault("messages.commands.night.syntax.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.night.syntax.sound.enabled", true);
        cfg.addDefault("messages.commands.night.message.message", "§7Du hast die Zeit erfolgreich auf §aNIGHT §7gestellt!");
        cfg.addDefault("messages.commands.night.message.enabled", true);
        cfg.addDefault("messages.commands.night.permission.perm", "REPLACETHIS.night.use");
        cfg.addDefault("messages.commands.night.permission.enabled", true);
        cfg.addDefault("messages.commands.night.sound.pitch", 1);
        cfg.addDefault("messages.commands.night.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.night.sound.enabled", true);
        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getNightFile());
        } catch (IOException e1) {
        }

    }

    public void initConfigPay() {
        FileConfiguration cfg = getPayYML();
        cfg.addDefault("messages.commands.pay.syntax.message.enabled", true);
        cfg.addDefault("messages.commands.pay.syntax.message.message", "§7Bitte verwende §8/§aPay §8<§aSPIELER§8> §8<§aGELD§8>");
        cfg.addDefault("messages.commands.pay.syntax.sound.pitch", 1);
        cfg.addDefault("messages.commands.pay.syntax.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.pay.syntax.sound.enabled", true);
        cfg.addDefault("messages.commands.pay.cannotpayself.enabled", true);
        cfg.addDefault("messages.commands.pay.cannotpayself.message", "§7Du kannst dich §cnicht §7selbst bezahlen!");
        cfg.addDefault("messages.commands.pay.cannotpayself.sound.pitch", 1);
        cfg.addDefault("messages.commands.pay.cannotpayself.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.pay.cannotpayself.sound.enabled", true);
        cfg.addDefault("messages.commands.pay.notnumber.message", "§7Bitte gebe eine §agültige §7Zahl ein!");

        cfg.addDefault("messages.commands.pay.permission.perm", "REPLACETHIS.pay.use");
        cfg.addDefault("messages.commands.pay.permission.enabled", true);

        cfg.addDefault("messages.commands.pay.notonline.message", "§7Der Spieler §a%TARGET% §7existiert nicht!");
        cfg.addDefault("messages.commands.pay.notonline.sound.pitch", 1);
        cfg.addDefault("messages.commands.pay.notonline.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.pay.notonline.sound.enabled", true);
        cfg.addDefault("messages.commands.pay.target.message.message", "§7Du hast eine Überweisung erhalten. §a§l%PAY_MONEY% §8$ §7von §a%PLAYER%§7.");
        cfg.addDefault("messages.commands.pay.target.message.enabled", true);
        cfg.addDefault("messages.commands.pay.target.sound.pitch", 1);
        cfg.addDefault("messages.commands.pay.target.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.pay.target.sound.enabled", true);

        cfg.addDefault("messages.commands.pay.self.nomoney.message.message", "§7Du hast §cnicht genug §7geld. Dir fehlen §c%REST_MONEY%§8 $");
        cfg.addDefault("messages.commands.pay.self.nomoney.message.enabled", true);
        cfg.addDefault("messages.commands.pay.self.nomoney.sound.pitch", 1);
        cfg.addDefault("messages.commands.pay.self.nomoney.sound.sound", "ANVIL_BREAK");
        cfg.addDefault("messages.commands.pay.self.nomoney.sound.enabled", true);

        cfg.addDefault("messages.commands.pay.self.message.message", "§7Du hast §a%PAY_MONEY%§8 $ §7an §a%TARGET% §7überwiesen!");
        cfg.addDefault("messages.commands.pay.self.message.enabled", true);
        cfg.addDefault("messages.commands.pay.self.sound.pitch", 1);
        cfg.addDefault("messages.commands.pay.self.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.pay.self.sound.enabled", true);

        cfg.addDefault("messages.commands.pay.payment.target.needtobeonline", false);
        cfg.addDefault("messages.commands.pay.payment.target.message.message", "§7Der Spieler §c%PLAYER% §7ist nicht online!");
        cfg.addDefault("messages.commands.pay.payment.target.message.enabled", true);
        cfg.addDefault("messages.commands.pay.payment.target.sound.pitch", 1);
        cfg.addDefault("messages.commands.pay.payment.target.sound.sound", "ANVIL_BREAK");
        cfg.addDefault("messages.commands.pay.payment.target.sound.enabled", true);
        cfg.addDefault("messages.commands.pay.self.preparing.message.enabled", true);
        cfg.addDefault("messages.commands.pay.self.preparing.message.message", "§7Überweisungsvorgang...");

        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getPayFile());
        } catch (IOException e1) {
        }
    }

    public void initConfigFire() {
        FileConfiguration cfg = getFireYML();
        cfg.addDefault("messages.commands.fire.syntax.message.enabled", true);
        cfg.addDefault("messages.commands.fire.syntax.message.message", "§7Bitte verwende §8/§aFire §8<§aSPIELER§8> §8<§aSEKUNDEN§8>");
        cfg.addDefault("messages.commands.fire.syntax.sound.pitch", 1);
        cfg.addDefault("messages.commands.fire.syntax.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.fire.syntax.sound.enabled", true);
        cfg.addDefault("messages.commands.fire.cannotburnself.enabled", true);
        cfg.addDefault("messages.commands.fire.cannotburnself.message", "§7Du kannst dich §cnicht §7selbst anzünden!");
        cfg.addDefault("messages.commands.fire.cannotburnself.sound.pitch", 1);
        cfg.addDefault("messages.commands.fire.cannotburnself.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.fire.cannotburnself.sound.enabled", true);
        cfg.addDefault("messages.commands.fire.notnumber.message", "§7Bitte gebe eine §agültige §7Zahl ein!");
        cfg.addDefault("messages.commands.fireother.notonline.message", "§7Der Spieler §a%TARGET% §7ist nicht online");
        cfg.addDefault("messages.commands.fireother.notonline.sound.pitch", 1);
        cfg.addDefault("messages.commands.fireother.notonline.sound.sound", "ANVIL_LAND");
        cfg.addDefault("messages.commands.fireother.notonline.sound.enabled", true);
        cfg.addDefault("messages.commands.fireother.target.message.message", "§7Du wurdest von §c%PLAYER% §7für §c%SEC%§7 Sekunde§8(§7n§8)§7 angezündet!");
        cfg.addDefault("messages.commands.fireother.target.message.enabled", true);
        cfg.addDefault("messages.commands.fireother.target.sound.pitch", 1);
        cfg.addDefault("messages.commands.fireother.target.sound.sound", "ANVIL_BREAK");
        cfg.addDefault("messages.commands.fireother.target.sound.enabled", true);
        cfg.addDefault("messages.commands.fireother.self.message.message", "§7Du hast §a%TARGET%§7 für §a%SEC%§7 Sekunde§8(§7n§8)§7 angezündet!");
        cfg.addDefault("messages.commands.fireother.self.message.enabled", true);
        cfg.addDefault("messages.commands.fireother.self.sound.pitch", 1);
        cfg.addDefault("messages.commands.fireother.self.sound.sound", "LEVEL_UP");
        cfg.addDefault("messages.commands.fireother.self.sound.enabled", true);
        cfg.addDefault("messages.commands.fireother.self.permission.perm", "REPLACETHIS.fire.other.use");
        cfg.addDefault("messages.commands.fireother.self.permission.enabled", true);

        cfg.options().copyDefaults(true);
        try {
            cfg.save(FileManager.getFireFile());
        } catch (IOException e1) {
        }
    }

    public void createFiles() {
        getDirectory().mkdir();
        try {
            getHealFile().createNewFile();
        } catch (IOException e) {
        }

        try {
            getDayFile().createNewFile();
        } catch (IOException e) {
        }

        try {
            getNightFile().createNewFile();
        } catch (IOException e) {
        }

        try {
            getFireFile().createNewFile();
        } catch (IOException e) {
        }

        try {
            getGamemodeFile().createNewFile();
        } catch (IOException e) {
        }

        try {
            getJoinFile().createNewFile();
        } catch (IOException e) {
        }

        try {
            getSpawnsFile().createNewFile();
        } catch (IOException e) {
        }

        try {
            getMoneyFile().createNewFile();
        } catch (IOException e) {
        }

        try {
            getPayFile().createNewFile();
        } catch (IOException e) {
        }

        try {
            getLeaveFile().createNewFile();
        } catch (IOException e) {
        }
        try {
            getDeathFile().createNewFile();
        } catch (IOException e) {
        }
        try {
            getSpawnFile().createNewFile();
        } catch (IOException ignore) {
        }
        try {
            getFlyFile().createNewFile();
        } catch (IOException ignore) {
        }
    }


}


