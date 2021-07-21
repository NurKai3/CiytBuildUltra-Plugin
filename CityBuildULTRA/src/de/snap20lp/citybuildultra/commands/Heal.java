package de.snap20lp.citybuildultra.commands;
/*

  This project was developed by Furkan  
                                                             
      Private Discord: Furkan.#4554                
                                                                                                                      
           created at 01.02.2020
                                                              
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

public class Heal implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length == 0) {
            if (!Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.heal.permission.enabled") || player.hasPermission(Main.getInstance().getFileManager().getHealYML().getString("messages.commands.heal.permission.perm"))) {
                if (Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.heal.message.enabled")) {
                    player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getHealYML().getString("messages.commands.heal.message.message"));
                }
                player.setHealth(Main.getInstance().getFileManager().getHealYML().getInt("messages.commands.heal.healvalue"));
                if (Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.heal.sound.enabled")) {
                    try {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getHealYML().getString("messages.commands.heal.sound.sound")), 100, Main.getInstance().getFileManager().getHealYML().getInt("messages.commands.heal.sound.pitch"));
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
        } else if (strings.length == 1) {
            Player target = Bukkit.getPlayer(strings[0]);
            if (!Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.healother.self.permission.enabled") || player.hasPermission(Main.getInstance().getFileManager().getHealYML().getString("messages.commands.healother.self.permission.perm"))) {
                if (target != null) {
                    if (target.getUniqueId() == player.getUniqueId()) {
                        if (Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.heal.permission.enabled") && !player.hasPermission(Main.getInstance().getFileManager().getHealYML().getString("messages.commands.heal.permission.perm"))) {
                            if (Main.getInstance().getConfig().getBoolean("noperms.message.enabled")) {
                                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getConfig().getString("noperms.message.message"));
                            }
                            if (Main.getInstance().getConfig().getBoolean("noperms.sound.enabled")) {
                                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("noperms.sound.sound")), 100, Main.getInstance().getConfig().getInt("noperms.sound.pitch"));
                            }
                            return false;
                        }
                    }
                    target.setHealth(Main.getInstance().getFileManager().getHealYML().getInt("messages.commands.healother.healvalue"));
                    if (Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.healother.target.message.enabled")) {
                        String healed = Main.getInstance().getFileManager().getHealYML().getString("messages.commands.healother.target.message.message");
                        healed = healed.replaceAll("%PLAYER%", player.getName());
                        target.sendMessage(Main.getInstance().getPrefix() + healed);
                    }
                    if (Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.healother.target.sound.enabled")) {
                        target.playSound(target.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getHealYML().getString("messages.commands.healother.target.sound.sound")), 100, Main.getInstance().getFileManager().getHealYML().getInt("messages.commands.healother.target.sound.pitch"));
                    }
                    if (Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.healother.self.message.enabled")) {
                        String healed = Main.getInstance().getFileManager().getHealYML().getString("messages.commands.healother.self.message.message");
                        healed = healed.replaceAll("%TARGET%", target.getName());
                        player.sendMessage(Main.getInstance().getPrefix() + healed);
                    }
                    if (Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.healother.self.sound.enabled")) {
                        player.playSound(target.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getHealYML().getString("messages.commands.healother.self.sound.sound")), 100, Main.getInstance().getFileManager().getHealYML().getInt("messages.commands.healother.self.sound.pitch"));
                    }
                } else {
                    String healed = Main.getInstance().getFileManager().getHealYML().getString("messages.commands.healother.notonline.message");
                    healed = healed.replaceAll("%TARGET%", strings[0]);
                    player.sendMessage(Main.getInstance().getPrefix() + healed);
                    if (Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.healother.notonline.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getHealYML().getString("messages.commands.healother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getHealYML().getInt("messages.commands.healother.notonline.sound.pitch"));
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
            if (Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.heal.syntax.sound.enabled")) {
                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getHealYML().getString("messages.commands.heal.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getHealYML().getInt("messages.commands.heal.syntax.sound.pitch"));
            }
            if (Main.getInstance().getFileManager().getHealYML().getBoolean("messages.commands.heal.syntax.message.enabled")) {
                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getHealYML().getString("messages.commands.heal.syntax.message.message"));
            }
        }
        return false;
    }
}
