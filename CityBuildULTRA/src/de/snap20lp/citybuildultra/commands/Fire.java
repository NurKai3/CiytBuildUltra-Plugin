package de.snap20lp.citybuildultra.commands;
/*

  This project was developed by Furkan  
                                                             
      Private Discord: Furkan.#4554                
                                                                                                                      
           created at 03.01.2020           
                                                              
        Project: CityBuildULTRA        
                                        
© 2019-2020 SnapDevStudios All Rights Reserved.

                                         
*/

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fire implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length == 2) {
            Player target = Bukkit.getPlayer(strings[0]);
            if (!Main.getInstance().getFileManager().getFireYML().getBoolean("messages.commands.fireother.self.permission.enabled") || player.hasPermission(Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fireother.self.permission.perm"))) {
                if (target != null) {
                    if (!Main.getInstance().getFileManager().getFireYML().getBoolean("messages.commands.fire.cannotburnself.enabled") || target.getUniqueId() != player.getUniqueId()) {

                        try {
                            int a = Integer.parseInt(strings[1]);
                            int sek = a * 20;
                            target.setFireTicks(sek);
                        } catch (Exception e) {
                            player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fire.notnumber.message"));
                            player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 1);
                            return false;
                        }
                        if (Main.getInstance().getFileManager().getFireYML().getBoolean("messages.commands.fireother.target.message.enabled")) {
                            String fireed = Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fireother.target.message.message");
                            fireed = fireed.replaceAll("%PLAYER%", player.getName());
                            fireed = fireed.replaceAll("%SEC%", strings[1]);
                            target.sendMessage(Main.getInstance().getPrefix() + fireed);
                        }
                        if (Main.getInstance().getFileManager().getFireYML().getBoolean("messages.commands.fireother.target.sound.enabled")) {
                            target.playSound(target.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fireother.target.sound.sound")), 100, Main.getInstance().getFileManager().getFireYML().getInt("messages.commands.fireother.target.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getFireYML().getBoolean("messages.commands.fireother.self.message.enabled")) {
                            String fireed = Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fireother.self.message.message");
                            fireed = fireed.replaceAll("%TARGET%", target.getName());
                            fireed = fireed.replaceAll("%SEC%", strings[1]);
                            player.sendMessage(Main.getInstance().getPrefix() + fireed);
                        }
                        if (Main.getInstance().getFileManager().getFireYML().getBoolean("messages.commands.fireother.self.sound.enabled")) {
                            player.playSound(target.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fireother.self.sound.sound")), 100, Main.getInstance().getFileManager().getFireYML().getInt("messages.commands.fireother.self.sound.pitch"));
                        }
                    } else {
                        if (Main.getInstance().getFileManager().getFireYML().getBoolean("messages.commands.fire.cannotburnself.sound.enabled")) {
                            player.playSound(target.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fire.cannotburnself.sound.sound")), 100, Main.getInstance().getFileManager().getFireYML().getInt("messages.commands.fire.cannotburnself.sound.pitch"));
                        }

                        player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fire.cannotburnself.message"));

                    }
                } else {
                    String fireed = Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fireother.notonline.message");
                    fireed = fireed.replaceAll("%TARGET%", strings[0]);
                    fireed = fireed.replaceAll("%SEC%", strings[1]);
                    player.sendMessage(Main.getInstance().getPrefix() + fireed);
                    if (Main.getInstance().getFileManager().getFireYML().getBoolean("messages.commands.fireother.notonline.sound.enabled")) {

                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fireother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getFireYML().getInt("messages.commands.fireother.notonline.sound.pitch"));
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
            if (Main.getInstance().getFileManager().getFireYML().getBoolean("messages.commands.fire.syntax.sound.enabled")) {
                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fire.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getFireYML().getInt("messages.commands.fire.syntax.sound.pitch"));
            }
            if (Main.getInstance().getFileManager().getFireYML().getBoolean("messages.commands.fire.syntax.message.enabled")) {
                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getFireYML().getString("messages.commands.fire.syntax.message.message"));
            }
        }
        return false;
    }

}


