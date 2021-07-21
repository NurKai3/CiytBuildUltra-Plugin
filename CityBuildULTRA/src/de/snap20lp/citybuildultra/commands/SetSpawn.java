package de.snap20lp.citybuildultra.commands;
/*

  This project was developed by Furkan  
                                                             
      Private Discord: Furkan#3511           
                                                                                                                      
           created at 21.01.2020
                                                              
        Project: CityBuildULTRA        
                                        
© 2019-2020 SnapDevStudios All Rights Reserved.

            
*/

import de.snap20lp.citybuildultra.main.FileManager;
import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SetSpawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (player.isOp() || player.hasPermission("*")) {
            if (strings.length == 0) {
                FileConfiguration cfg = Main.getInstance().getFileManager().getSpawnsYML();
                cfg.set("main.spawn.location", player.getLocation());
                try {
                    cfg.save(FileManager.getSpawnsFile());
                    player.playSound(player.getLocation(), Sound.LEVEL_UP, 100, 1);
                    player.sendMessage(Main.getInstance().getPrefix() + "§7Der Spawnpunkt wurde §aerfolgreich§7 gesetzt!");
                } catch (IOException e) {
                    player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 1);
                    player.sendMessage(Main.getInstance().getPrefix() + "§7Der Spawnpunkt konnte §cnicht §7gesetzt werden! §cNicht genug Speicherplatz?");
                }
            } else {
                player.sendMessage(Main.getInstance().getPrefix() + "§7Bitte benutze: §8/§aSetSpawn");
            }
        }
        return false;
    }
}
