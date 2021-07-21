package de.snap20lp.citybuildultra.listeners;
/*

  This project was developed by Furkan  
                                                             
      Private Discord: Furkan#3511           
                                                                                                                      
           created at 20.01.2020
                                                              
        Project: CityBuildULTRA        
                                        
© 2019-2020 SnapDevStudios All Rights Reserved.

            
*/

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();


        try {
            if (!Main.getInstance().getMySQL().playerExist(Main.getInstance().getUuidFetcher().getUUID(player.getName()).toString(), "moneytable")) {
                Main.getInstance().getMySQL().update("INSERT INTO moneytable(UUID,Money) VALUES ('" + Main.getInstance().getUuidFetcher().getUUID(player.getName()) + "','" + Main.getInstance().getFileManager().getJoinYML().getString("join.money.start") + "')");
            }
        } catch (Exception e) {
            player.kickPlayer("\n\n§a§lCityBuild System\n\n§cAn error has occurred while writing in the databse!\n§cPlease contact an administrator or owner to fix this problem!\n\n§cThis error may happen when you are using an Offline Version off the game\n§cDue this issue the plugin cant write your UUID into the database.");
        }

        event.setJoinMessage(null);

        if (Main.getInstance().getFileManager().getJoinYML().getBoolean("join.title.enabled")) {
            String title1 = Main.getInstance().getFileManager().getJoinYML().getString("join.title.title.1");
            title1 = title1.replaceAll("%PLAYER%", player.getName());
            String title2 = Main.getInstance().getFileManager().getJoinYML().getString("join.title.title.2");
            title2 = title2.replaceAll("%PLAYER%", player.getName());
            player.sendTitle(title1, title2);
        }

        if (Main.getInstance().getFileManager().getJoinYML().getBoolean("join.broadcast.enabled")) {
            String message = Main.getInstance().getFileManager().getJoinYML().getString("join.broadcast.message");
            message = message.replaceAll("%PLAYER%", player.getName());
            message = message.replaceAll("%PREFIX%", Main.getInstance().getPrefix());
            Bukkit.broadcastMessage(message);
        }

        if (Main.getInstance().getFileManager().getJoinYML().getBoolean("join.messages.enabled")) {
            String messages = Main.getInstance().getFileManager().getJoinYML().getString("join.messages.message");
            messages = messages.replaceAll("%PLAYER%", player.getName());
            player.sendMessage(messages);
        }
        if (Main.getInstance().getFileManager().getJoinYML().getBoolean("join.sound.enabled")) {
            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getJoinYML().getString("join.sound.sound")), 100, Main.getInstance().getFileManager().getJoinYML().getInt("join.sound.pitch"));
        }

        if (Main.getInstance().getFileManager().getJoinYML().getBoolean("join.spawn.joinonspawn.enabled")) {
            try {
                Location location = (Location) Main.getInstance().getFileManager().getSpawnsYML().get("main.spawn.location");
                player.teleport(location);
            } catch (Exception e) {
                player.sendMessage(Main.getInstance().getPrefix() + "§cSpawnfile is corrupt please report this message to an administrator or owner!");
            }
        } else if (Main.getInstance().getFileManager().getJoinYML().getBoolean("join.spawn.joinonworld.enabled")) {
            try {
                player.teleport(new Location(Bukkit.getWorld(Main.getInstance().getFileManager().getJoinYML().getString("join.spawn.joinonworld.world")), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getYaw(), player.getLocation().getPitch()));
            } catch (Exception e) {
                player.sendMessage(Main.getInstance().getPrefix() + "§cSpawnfile is corrupt please report this message to an administrator or owner!");
            }
        }
    }

}
