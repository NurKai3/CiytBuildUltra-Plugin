package de.snap20lp.citybuildultra.commands;
/*

  This project was developed by Furkan  
                                                             
      Private Discord: Furkan#3511           
                                                                                                                      
           created at 03.02.2020
                                                              
        Project: CityBuildULTRA        
                                        
© 2019-2020 SnapDevStudios All Rights Reserved.

            
*/

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length == 1) {
            if (!Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.permission.enabled") || player.hasPermission("messages.commands.gamemode.permission.perm")) {
                if (strings[0].equalsIgnoreCase("0")) {
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemode.sound.pitch"));
                    }
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.message.enabled")) {
                        String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.message.message");
                        gamemode = gamemode.replaceAll("%PLAYER%", player.getName());
                        gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.survival"));
                        player.sendMessage(Main.getInstance().getPrefix() + gamemode);
                    }
                    player.setGameMode(GameMode.SURVIVAL);
                } else if (strings[0].equalsIgnoreCase("1")) {
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemode.sound.pitch"));
                    }
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.message.enabled")) {
                        String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.message.message");
                        gamemode = gamemode.replaceAll("%PLAYER%", player.getName());
                        gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.creative"));
                        player.sendMessage(Main.getInstance().getPrefix() + gamemode);
                    }
                    player.setGameMode(GameMode.CREATIVE);
                } else if (strings[0].equalsIgnoreCase("2")) {
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemode.sound.pitch"));
                    }
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.message.enabled")) {
                        String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.message.message");
                        gamemode = gamemode.replaceAll("%PLAYER%", player.getName());
                        gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.adventure"));
                        player.sendMessage(Main.getInstance().getPrefix() + gamemode);
                    }
                    player.setGameMode(GameMode.ADVENTURE);
                } else if (strings[0].equalsIgnoreCase("3")) {
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemode.sound.pitch"));
                    }
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.message.enabled")) {
                        String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.message.message");
                        gamemode = gamemode.replaceAll("%PLAYER%", player.getName());
                        gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.spectator"));
                        player.sendMessage(Main.getInstance().getPrefix() + gamemode);
                    }
                    player.setGameMode(GameMode.SPECTATOR);
                } else {
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.syntax.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemode.syntax.sound.pitch"));
                    }
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.syntax.message.enabled")) {
                        player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.syntax.message.message"));
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
        } else if (strings.length == 2) {
            if (!Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.self.permission.enabled") || player.hasPermission("messages.commands.gamemodeother.self.permission.perm")) {
                Player target = Bukkit.getPlayer(strings[1]);
                if (target != null) {
                    if (target.getUniqueId() == player.getUniqueId()) {
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.permission.enabled") && !player.hasPermission("messages.commands.gamemode.permission.perm")) {
                            if (Main.getInstance().getConfig().getBoolean("noperms.message.enabled")) {
                                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getConfig().getString("noperms.message.message"));
                            }
                            if (Main.getInstance().getConfig().getBoolean("noperms.sound.enabled")) {
                                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("noperms.sound.sound")), 100, Main.getInstance().getConfig().getInt("noperms.sound.pitch"));
                            }
                            return false;
                        }
                    }
                    if (strings[0].equalsIgnoreCase("0")) {
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.self.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.self.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemodeother.self.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.self.message.enabled")) {
                            String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.self.message.message");
                            gamemode = gamemode.replaceAll("%TARGET%", target.getName());
                            gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.survival"));
                            player.sendMessage(Main.getInstance().getPrefix() + gamemode);
                        }


                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.target.sound.enabled")) {
                            target.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.target.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemodeother.target.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.target.message.enabled")) {
                            String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.target.message.message");
                            gamemode = gamemode.replaceAll("%PLAYER%", player.getName());
                            gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.survival"));
                            target.sendMessage(Main.getInstance().getPrefix() + gamemode);
                        }

                        target.setGameMode(GameMode.SURVIVAL);
                    } else if (strings[0].equalsIgnoreCase("1")) {
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.self.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.self.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemodeother.self.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.self.message.enabled")) {
                            String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.self.message.message");
                            gamemode = gamemode.replaceAll("%TARGET%", target.getName());
                            gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.creative"));
                            player.sendMessage(Main.getInstance().getPrefix() + gamemode);
                        }


                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.target.sound.enabled")) {
                            target.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.target.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemodeother.target.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.target.message.enabled")) {
                            String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.target.message.message");
                            gamemode = gamemode.replaceAll("%PLAYER%", player.getName());
                            gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.creative"));
                            target.sendMessage(Main.getInstance().getPrefix() + gamemode);
                        }

                        target.setGameMode(GameMode.CREATIVE);
                    } else if (strings[0].equalsIgnoreCase("2")) {
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.self.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.self.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemodeother.self.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.self.message.enabled")) {
                            String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.self.message.message");
                            gamemode = gamemode.replaceAll("%TARGET%", target.getName());
                            gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.adventure"));
                            player.sendMessage(Main.getInstance().getPrefix() + gamemode);
                        }


                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.target.sound.enabled")) {
                            target.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.target.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemodeother.target.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.target.message.enabled")) {
                            String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.target.message.message");
                            gamemode = gamemode.replaceAll("%PLAYER%", player.getName());
                            gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.adventure"));
                            target.sendMessage(Main.getInstance().getPrefix() + gamemode);
                        }

                        target.setGameMode(GameMode.ADVENTURE);
                    } else if (strings[0].equalsIgnoreCase("3")) {
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.self.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.self.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemodeother.self.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.self.message.enabled")) {
                            String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.self.message.message");
                            gamemode = gamemode.replaceAll("%TARGET%", target.getName());
                            gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.spectator"));
                            player.sendMessage(Main.getInstance().getPrefix() + gamemode);
                        }

                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.target.sound.enabled")) {
                            target.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.target.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemodeother.target.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.target.message.enabled")) {
                            String gamemode = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.target.message.message");
                            gamemode = gamemode.replaceAll("%PLAYER%", player.getName());
                            gamemode = gamemode.replaceAll("%GAMEMODE%", Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.gamemode.spectator"));
                            target.sendMessage(Main.getInstance().getPrefix() + gamemode);
                        }


                        target.setGameMode(GameMode.SPECTATOR);
                    } else {
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.syntax.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemode.syntax.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.syntax.message.enabled")) {
                            player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.syntax.message.message"));
                        }
                    }
                } else {
                    String notonline = Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.notonline.message");
                    notonline = notonline.replaceAll("%TARGET%", strings[1]);
                    notonline = notonline.replaceAll("%PLAER%", player.getName());
                    player.sendMessage(Main.getInstance().getPrefix() + notonline);
                    if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemodeother.notonline.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemodeother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemodeother.notonline.sound.pitch"));
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
            if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.syntax.sound.enabled")) {
                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getGamemodeYML().getInt("messages.commands.gamemode.syntax.sound.pitch"));
            }
            if (Main.getInstance().getFileManager().getGamemodeYML().getBoolean("messages.commands.gamemode.syntax.message.enabled")) {
                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getGamemodeYML().getString("messages.commands.gamemode.syntax.message.message"));
            }
        }
        return false;
    }
}
