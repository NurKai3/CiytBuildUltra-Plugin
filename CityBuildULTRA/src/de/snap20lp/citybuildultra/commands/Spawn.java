package de.snap20lp.citybuildultra.commands;

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Spawn implements CommandExecutor, Listener {

    private int sec = Main.getInstance().getFileManager().getSpawnYML().getInt("messages.commands.spawn.teleport.delay.sec");
    private Location location;
    private int scheduler;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length == 0) {
            if (!Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.permission.enabled") || player.hasPermission(Main.getInstance().getFileManager().getSpawnYML().getString("messages.commands.spawn.permission.perm"))) {
                if (Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.teleport.delay.enabled")) {
                    location = player.getLocation();
                    sec++;
                    scheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getInstance(), new Runnable() {
                        @Override
                        public void run() {
                            if (sec != 0) {
                                sec--;
                            }


                            if (Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.teleport.delay.nomove")) {
                                if (location != null) {
                                    if (location.getBlockX() != player.getLocation().getBlockX() || location.getBlockY() != player.getLocation().getBlockY() || location.getBlockZ() != player.getLocation().getBlockZ()) {
                                        Bukkit.getScheduler().cancelTask(scheduler);
                                        sec = Main.getInstance().getFileManager().getSpawnYML().getInt("messages.commands.spawn.teleport.delay.sec");
                                        location = null;
                                        if (Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.teleport.delay.abort.message.enabled")) {
                                            String message = Main.getInstance().getFileManager().getSpawnYML().getString("messages.commands.spawn.teleport.delay.abort.message.message");
                                            message = message.replaceAll("%SECONDS%", String.valueOf(sec));
                                            player.sendMessage(Main.getInstance().getPrefix() + message);
                                        }
                                        if (Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.teleport.delay.abort.sound.enabled")) {
                                            try {
                                                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getSpawnYML().getString("messages.commands.spawn.teleport.delay.abort.sound.sound")), 100, Main.getInstance().getFileManager().getSpawnYML().getInt("messages.commands.spawn.teleport.delay.abort.sound.pitch"));
                                            } catch (Exception ignore) {
                                                player.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                                            }
                                        }
                                        return;
                                    }
                                }
                            }
                            if (sec != 0) {
                                if (Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.teleport.delay.message.enabled")) {
                                    String message = Main.getInstance().getFileManager().getSpawnYML().getString("messages.commands.spawn.teleport.delay.message.message");
                                    message = message.replaceAll("%SECONDS%", String.valueOf(sec));
                                    player.sendMessage(Main.getInstance().getPrefix() + message);
                                }
                                if (Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.teleport.delay.sound.enabled")) {
                                    try {
                                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getSpawnYML().getString("messages.commands.spawn.teleport.delay.sound.sound")), 100, Main.getInstance().getFileManager().getSpawnYML().getInt("messages.commands.spawn.teleport.delay.sound.pitch"));
                                    } catch (Exception ignore) {
                                        player.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                                    }
                                }
                            }


                            if (sec <= 0) {
                                sec = Main.getInstance().getFileManager().getSpawnYML().getInt("messages.commands.spawn.teleport.delay.sec");
                                location = null;
                                Location location = (Location) Main.getInstance().getFileManager().getSpawnsYML().get("main.spawn.location");
                                player.teleport(location);
                                if (Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.message.enabled")) {
                                    String message = Main.getInstance().getFileManager().getSpawnYML().getString("messages.commands.spawn.message.message");
                                    message = message.replaceAll("%SECONDS%", String.valueOf(sec));
                                    player.sendMessage(Main.getInstance().getPrefix() + message);
                                }
                                if (Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.sound.enabled")) {
                                    try {
                                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getSpawnYML().getString("messages.commands.spawn.sound.sound")), 100, Main.getInstance().getFileManager().getSpawnYML().getInt("messages.commands.spawn.sound.pitch"));
                                    } catch (Exception ignore) {
                                        player.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                                    }
                                }
                                Bukkit.getScheduler().cancelTask(scheduler);

                            }
                        }
                    }, 0, 20);
                } else {
                    if (Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.message.enabled")) {
                        player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getSpawnYML().getString("messages.commands.spawn.message.message"));
                    }
                    if (Main.getInstance().getFileManager().getSpawnYML().getBoolean("messages.commands.spawn.sound.enabled")) {
                        try {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getSpawnYML().getString("messages.commands.spawn.sound.sound")), 100, Main.getInstance().getFileManager().getSpawnYML().getInt("messages.commands.spawn.sound.pitch"));
                        } catch (Exception e) {
                            player.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                        }
                    }
                    Location location = (Location) Main.getInstance().getFileManager().getSpawnsYML().get("main.spawn.location");
                    player.teleport(location);
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
