package de.snap20lp.citybuildultra.commands;
/*

  This project was developed by Furkan

      Private Discord: Furkan.#4554

           created at 03.01.2020

        Project: CityBuildULTRA

© 2019-2020 SnapDevStudios All Rights Reserved.


*/

import de.snap20lp.citybuildultra.api.CityBuildUltra;
import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Pay implements CommandExecutor {



    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player player = (Player) commandSender;
        if (strings.length == 2) {

            try {
                if (!(Integer.parseInt(strings[1]) > 0)) {
                    player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.notnumber.message"));
                    player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 1);
                    return false;
                } else {
                    if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.self.preparing.message.enabled")) {
                        player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.self.preparing.message.message"));
                        player.playSound(player.getLocation(), Sound.ORB_PICKUP, 100, 1);
                    }
                }
            } catch (Exception e) {
                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.notnumber.message"));
                player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 1);
                return false;
            }

            UUID uuid;
            try {
                uuid = Main.getInstance().getUuidFetcher().getUUID(strings[0]);
                if (!Main.getInstance().getMySQL().playerExist(uuid.toString(), "moneytable")) {
                    String notonline = Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.notonline.message");
                    notonline = notonline.replaceAll("%TARGET%", strings[0]);
                    notonline = notonline.replaceAll("%PLAER%", player.getName());
                    player.sendMessage(Main.getInstance().getPrefix() + notonline);
                    if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.notonline.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getPayYML().getInt("messages.commands.pay.notonline.sound.pitch"));
                    }
                    return false;
                }
            } catch (Exception e) {
                String notonline = Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.notonline.message");
                notonline = notonline.replaceAll("%TARGET%", strings[0]);
                notonline = notonline.replaceAll("%PLAER%", player.getName());
                player.sendMessage(Main.getInstance().getPrefix() + notonline);
                if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.notonline.sound.enabled")) {
                    player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getPayYML().getInt("messages.commands.pay.notonline.sound.pitch"));
                }
                return false;
            }
            if (!Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.permission.enabled") || player.hasPermission(Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.permission.perm"))) {
                try {
                    if (!(Main.getInstance().getMySQL().getMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName())) >= Integer.parseInt(strings[1]))) {
                        if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.self.nomoney.message.enabled")) {
                            String fireed = Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.self.nomoney.message.message");
                            int needed = Math.abs(Main.getInstance().getMySQL().getMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName())) - Integer.parseInt(strings[1]));
                            fireed = fireed.replaceAll("%REST_MONEY%", String.valueOf(needed));
                            player.sendMessage(Main.getInstance().getPrefix() + fireed);
                        }
                        if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.self.nomoney.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.self.nomoney.sound.sound")), 100, Main.getInstance().getFileManager().getPayYML().getInt("messages.commands.pay.self.nomoney.sound.pitch"));
                        }
                        return false;
                    }
                } catch (NumberFormatException e) {
                    player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.notnumber.message"));
                    player.playSound(player.getLocation(), Sound.ANVIL_LAND, 100, 1);
                    return false;
                }
                Player target = null;
                for (Player player1 : Bukkit.getOnlinePlayers()) {
                    if (player1.getName().equals(strings[0])) {
                        target = player1;
                        break;
                    }
                }
                if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.payment.target.needtobeonline")) {
                    if (target == null) {
                        if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.payment.target.message.enabled")) {
                            String fireed = Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.payment.target.message.message");
                            fireed = fireed.replaceAll("%PLAYER%", strings[0]);
                        }
                        if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.payment.target.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.payment.target.sound.sound")), 100, Main.getInstance().getFileManager().getPayYML().getInt("messages.commands.pay.payment.target.sound.pitch"));
                        }
                        return false;
                    }
                }
                if (!Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.cannotpayself.enabled") || !strings[0].equals(player.getName())) {
                    Main.getInstance().getMySQL().removeMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName()), Integer.parseInt(strings[1]));
                    Main.getInstance().getMySQL().giveMoney(uuid, Integer.parseInt(strings[1]));

                    if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.target.message.enabled")) {
                        String fireed = Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.target.message.message");
                        fireed = fireed.replaceAll("%PAY_MONEY%", strings[1]);
                        fireed = fireed.replaceAll("%PLAYER%", player.getName());
                        if (target != null) {
                            target.sendMessage(Main.getInstance().getPrefix() + fireed);
                        }
                    }
                    if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.target.sound.enabled") && target != null) {
                        target.playSound(target.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.target.sound.sound")), 100, Main.getInstance().getFileManager().getPayYML().getInt("messages.commands.pay.target.sound.pitch"));
                    }
                    if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.self.message.enabled")) {
                        String fireed = Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.self.message.message");
                        fireed = fireed.replaceAll("%PAY_MONEY%", strings[1]);
                        fireed = fireed.replaceAll("%TARGET%", strings[0]);
                        player.sendMessage(Main.getInstance().getPrefix() + fireed);
                    }
                    if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.self.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.self.sound.sound")), 100, Main.getInstance().getFileManager().getPayYML().getInt("messages.commands.pay.self.sound.pitch"));
                    }
                } else {
                    player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.cannotpayself.message"));

                    if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.cannotpayself.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.cannotpayself.sound.sound")), 100, Main.getInstance().getFileManager().getPayYML().getInt("messages.commands.pay.cannotpayself.sound.pitch"));
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
            if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.syntax.sound.enabled")) {
                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getPayYML().getInt("messages.commands.pay.syntax.sound.pitch"));
            }
            if (Main.getInstance().getFileManager().getPayYML().getBoolean("messages.commands.pay.syntax.message.enabled")) {
                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getPayYML().getString("messages.commands.pay.syntax.message.message"));
            }
        }
        return false;
    }

}


