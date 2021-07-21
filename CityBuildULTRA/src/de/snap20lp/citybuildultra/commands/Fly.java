package de.snap20lp.citybuildultra.commands;

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.UUID;

public class Fly implements CommandExecutor {

    public ArrayList<UUID> canFly = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length == 0) {
            if (!Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.fly.permission.enabled") || player.hasPermission(Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.fly.permission.perm"))) {
                if (!canFly.contains(player.getUniqueId())) {
                    canFly.add(player.getUniqueId());
                    player.setAllowFlight(true);
                    player.setFlying(true);
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.fly.message.flyon.enabled")) {
                        player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.fly.message.flyon.message"));
                    }
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.fly.sound.flyon.enabled")) {
                        try {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.fly.sound.flyon.sound")), 100, Main.getInstance().getFileManager().getFlyYML().getInt("messages.commands.fly.sound.flyon.pitch"));
                        } catch (Exception e) {
                            player.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                        }
                    }
                } else {
                    canFly.remove(player.getUniqueId());
                    player.setAllowFlight(false);
                    player.setFlying(false);
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.fly.message.flyoff.enabled")) {
                        player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.fly.message.flyoff.message"));
                    }
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.fly.sound.flyoff.enabled")) {
                        try {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.fly.sound.flyoff.sound")), 100, Main.getInstance().getFileManager().getFlyYML().getInt("messages.commands.fly.sound.flyoff.pitch"));
                        } catch (Exception e) {
                            player.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                        }
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
            if (!Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.flyother.self.permission.enabled") || player.hasPermission(Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.self.permission.perm"))) {
                Player target = Bukkit.getPlayer(strings[0]);
                if (target == null) {
                    String healed = Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.notonline.message");
                    healed = healed.replaceAll("%TARGET%", strings[0]);
                    player.sendMessage(Main.getInstance().getPrefix() + healed);
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.flyother.notonline.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getFlyYML().getInt("messages.commands.flyother.notonline.sound.pitch"));
                    }
                    return false;
                }
                if (!canFly.contains(target.getUniqueId())) {
                    canFly.add(target.getUniqueId());
                    target.setAllowFlight(true);
                    target.setFlying(true);
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.flyother.target.message.flyon.enabled")) {
                        target.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.target.message.flyon.message"));
                    }
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.flyother.target.flyon.sound.enabled")) {
                        try {
                            target.playSound(target.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.target.flyon.sound.sound")), 100, Main.getInstance().getFileManager().getFlyYML().getInt("messages.commands.flyother.target.flyon.sound.pitch"));
                        } catch (Exception e) {
                            target.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                        }
                    }

                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.flyother.self.message.flyon.enabled")) {
                        String healed = Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.self.message.flyon.message");
                        healed = healed.replaceAll("%TARGET%", strings[0]);
                        player.sendMessage(Main.getInstance().getPrefix() + healed);
                    }
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.flyother.self.flyon.sound.enabled")) {
                        try {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.self.flyon.sound.sound")), 100, Main.getInstance().getFileManager().getFlyYML().getInt("messages.commands.flyother.self.flyon.sound.pitch"));
                        } catch (Exception e) {
                            player.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                        }
                    }
                } else {
                    canFly.remove(target.getUniqueId());
                    target.setAllowFlight(false);
                    target.setFlying(false);
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.flyother.target.message.flyoff.enabled")) {
                        target.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.target.message.flyoff.message"));
                    }
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.flyother.target.flyoff.sound.enabled")) {
                        try {
                            target.playSound(target.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.target.flyoff.sound.sound")), 100, Main.getInstance().getFileManager().getFlyYML().getInt("messages.commands.flyother.target.flyoff.sound.pitch"));
                        } catch (Exception e) {
                            target.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                        }
                    }

                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.flyother.self.message.flyoff.enabled")) {
                        String healed = Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.self.message.flyoff.message");
                        healed = healed.replaceAll("%TARGET%", strings[0]);
                        player.sendMessage(Main.getInstance().getPrefix() + healed);
                    }
                    if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.flyother.self.flyoff.sound.enabled")) {
                        try {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.flyother.self.flyoff.sound.sound")), 100, Main.getInstance().getFileManager().getFlyYML().getInt("messages.commands.flyother.self.flyoff.sound.pitch"));
                        } catch (Exception e) {
                            player.sendMessage(Main.getInstance().getPrefix() + "§cDer Ton für diesen Command ist ungültig. Bitte informiere ein Teammitglied!");
                        }
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
            if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.fly.syntax.sound.enabled")) {
                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.fly.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getFlyYML().getInt("messages.commands.fly.syntax.sound.pitch"));
            }
            if (Main.getInstance().getFileManager().getFlyYML().getBoolean("messages.commands.fly.syntax.message.enabled")) {
                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getFlyYML().getString("messages.commands.fly.syntax.message.message"));
            }
        }
        return false;
    }
}
