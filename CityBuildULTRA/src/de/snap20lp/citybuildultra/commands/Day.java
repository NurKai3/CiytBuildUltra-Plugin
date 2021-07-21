package de.snap20lp.citybuildultra.commands;
/*

  This project was developed by Furkan  
                                                             
      Private Discord: Furkan.#4554                
                                                                                                                      
           created at 03.01.2020           
                                                              
        Project: CityBuildULTRA        
                                        
© 2019-2020 SnapDevStudios All Rights Reserved.

                                         
*/

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Day implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length == 0) {
            if (!Main.getInstance().getFileManager().getDayYML().getBoolean("messages.commands.day.permission.enabled") || player.hasPermission(Main.getInstance().getFileManager().getDayYML().getString("messages.commands.day.permission.perm"))) {
                if (Main.getInstance().getFileManager().getDayYML().getBoolean("messages.commands.day.message.enabled")) {
                    player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getDayYML().getString("messages.commands.day.message.message"));
                }
                player.getWorld().setTime(1000);
                if (Main.getInstance().getFileManager().getDayYML().getBoolean("messages.commands.day.sound.enabled")) {
                    try {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getDayYML().getString("messages.commands.day.sound.sound")), 100, Main.getInstance().getFileManager().getDayYML().getInt("messages.commands.day.sound.pitch"));
                    } catch (Exception e) {
                        player.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                    }
                }
            } else {
                if (Main.getInstance().getConfig().getBoolean("noperms.message.enabled")) {
                    player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getConfig().getString("noperms.message.message"));
                }
                if (Main.getInstance().getConfig().getBoolean("noperms.sound.enabled")) {
                    player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("noperms.sound.sound")), 100, Main.getInstance().getConfig().getInt("noperms.sound.pitch"));
                }
            }
        } else {
            if (Main.getInstance().getFileManager().getDayYML().getBoolean("messages.commands.day.syntax.sound.enabled")) {
                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getDayYML().getString("messages.commands.day.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getDayYML().getInt("messages.commands.day.syntax.sound.pitch"));
            }
            if (Main.getInstance().getFileManager().getDayYML().getBoolean("messages.commands.day.syntax.message.enabled")) {
                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getDayYML().getString("messages.commands.day.syntax.message.message"));
            }
        }
        return false;
    }
}


