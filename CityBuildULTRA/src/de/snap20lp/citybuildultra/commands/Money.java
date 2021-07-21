package de.snap20lp.citybuildultra.commands;

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Money implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        if (strings.length == 0) {
            if (!Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.money.permission.enabled") || player.hasPermission("messages.commands.money.permission.perm")) {
                if (!Main.getInstance().getMySQL().playerExist(Main.getInstance().getUuidFetcher().getUUID(player.getName()).toString(), "moneytable")) {
                    player.sendMessage(Main.getInstance().getPrefix() + "§cNo database registry where found please rejoin!");
                } else {
                    String money = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.money.message.message");
                    money = money.replaceAll("%MONEY%", String.valueOf(Main.getInstance().getMySQL().getMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName()))));
                    if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.money.message.enabled")) {
                        player.sendMessage(Main.getInstance().getPrefix() + money);
                    }
                    if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.money.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.money.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.money.sound.pitch"));
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
            if (!Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyother.self.permission.enabled") || player.hasPermission("messages.commands.moneyother.self.permission.perm")) {
                UUID uuid;
                try {
                    uuid = Main.getInstance().getUuidFetcher().getUUID(strings[0]);
                    if (!Main.getInstance().getMySQL().playerExist(uuid.toString(), "moneytable")) {
                        String notonline = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.message");
                        notonline = notonline.replaceAll("%TARGET%", strings[0]);
                        notonline = notonline.replaceAll("%PLAER%", player.getName());
                        player.sendMessage(Main.getInstance().getPrefix() + notonline);
                        if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyother.notonline.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyother.notonline.sound.pitch"));
                        }
                        return false;
                    }
                } catch (Exception e) {
                    String notonline = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.message");
                    notonline = notonline.replaceAll("%TARGET%", strings[0]);
                    notonline = notonline.replaceAll("%PLAER%", player.getName());
                    player.sendMessage(Main.getInstance().getPrefix() + notonline);
                    if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyother.notonline.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyother.notonline.sound.pitch"));
                    }
                    return false;
                }

                String money = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.self.message.message");
                money = money.replaceAll("%MONEY%", String.valueOf(Main.getInstance().getMySQL().getMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName()))));
                money = money.replaceAll("%TARGET%", strings[0]);
                money = money.replaceAll("%TARGET_MONEY%", String.valueOf(Main.getInstance().getMySQL().getMoney(uuid)));
                player.sendMessage(Main.getInstance().getPrefix() + money);
                if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyother.self.sound.enabled")) {
                    player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.self.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyother.self.sound.pitch"));
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
            if (strings[0].equalsIgnoreCase("reset")) {
                if (!Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyadmin.reset.permission.enabled") || player.hasPermission("messages.commands.moneyadmin.reset.permission.perm")) {

                    UUID uuid;
                    try {
                        uuid = Main.getInstance().getUuidFetcher().getUUID(strings[1]);
                        if (!Main.getInstance().getMySQL().playerExist(uuid.toString(), "moneytable")) {
                            String notonline = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.message");
                            notonline = notonline.replaceAll("%TARGET%", strings[1]);
                            notonline = notonline.replaceAll("%PLAER%", player.getName());
                            player.sendMessage(Main.getInstance().getPrefix() + notonline);
                            if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyother.notonline.sound.enabled")) {
                                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyother.notonline.sound.pitch"));
                            }
                            return false;
                        }
                    } catch (Exception e) {
                        String notonline = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.message");
                        notonline = notonline.replaceAll("%TARGET%", strings[1]);
                        notonline = notonline.replaceAll("%PLAER%", player.getName());
                        player.sendMessage(Main.getInstance().getPrefix() + notonline);
                        if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyother.notonline.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyother.notonline.sound.pitch"));
                        }
                        return false;
                    }

                    Main.getInstance().getMySQL().resetMoney(uuid);
                    String money = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyadmin.reset.message.message");
                    money = money.replaceAll("%RESET_MONEY%", String.valueOf(Main.getInstance().getMySQL().getMoney(uuid)));
                    money = money.replaceAll("%TARGET%", strings[1]);
                    player.sendMessage(Main.getInstance().getPrefix() + money);
                    if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyadmin.reset.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyadmin.reset.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyadmin.reset.sound.pitch"));
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
                if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.money.syntax.sound.enabled")) {
                    player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.money.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.money.syntax.sound.pitch"));
                }
                if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.money.syntax.message.enabled")) {
                    player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.money.syntax.message.message"));
                }
            }
        } else if (strings.length == 3) {
            if (strings[0].equalsIgnoreCase("give")) {
                if (!Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyadmin.give.permission.enabled") || player.hasPermission("messages.commands.moneyadmin.give.permission.perm")) {
                    try {
                        int test = Integer.parseInt(strings[2]);
                    } catch (Exception e) {
                        if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyadmin.syntax.give.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyadmin.syntax.give.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyadmin.syntax.give.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyadmin.syntax.give.message.enabled")) {
                            player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyadmin.syntax.give.message.message"));
                        }
                        return false;
                    }
                    UUID uuid;
                    try {
                        uuid = Main.getInstance().getUuidFetcher().getUUID(strings[1]);
                        if (!Main.getInstance().getMySQL().playerExist(uuid.toString(), "moneytable")) {
                            String notonline = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.message");
                            notonline = notonline.replaceAll("%TARGET%", strings[1]);
                            notonline = notonline.replaceAll("%PLAER%", player.getName());
                            player.sendMessage(Main.getInstance().getPrefix() + notonline);
                            if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyother.notonline.sound.enabled")) {
                                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyother.notonline.sound.pitch"));
                            }
                            return false;
                        }
                    } catch (Exception e) {
                        String notonline = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.message");
                        notonline = notonline.replaceAll("%TARGET%", strings[1]);
                        notonline = notonline.replaceAll("%PLAER%", player.getName());
                        player.sendMessage(Main.getInstance().getPrefix() + notonline);
                        if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyother.notonline.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyother.notonline.sound.pitch"));
                        }
                        return false;
                    }

                    Main.getInstance().getMySQL().giveMoney(uuid, Integer.parseInt(strings[2]));
                    String money = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyadmin.give.message.message");
                    money = money.replaceAll("%GAVE_MONEY%", strings[2]);
                    money = money.replaceAll("%TARGET%", strings[1]);
                    player.sendMessage(Main.getInstance().getPrefix() + money);
                    if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyadmin.give.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyadmin.give.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyadmin.give.sound.pitch"));
                    }
                } else {
                    if (Main.getInstance().getConfig().getBoolean("noperms.message.enabled")) {
                        player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getConfig().getString("noperms.message.message"));
                    }
                    if (Main.getInstance().getConfig().getBoolean("noperms.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("noperms.sound.sound")), 100, Main.getInstance().getConfig().getInt("noperms.sound.pitch"));
                    }
                }
            } else if (strings[0].equalsIgnoreCase("remove")) {
                if (!Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyadmin.remove.permission.enabled") || player.hasPermission("messages.commands.moneyadmin.remove.permission.perm")) {
                    try {
                        int test = Integer.parseInt(strings[2]);
                    } catch (Exception e) {
                        if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyadmin.syntax.remove.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyadmin.syntax.remove.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyadmin.syntax.remove.sound.pitch"));
                        }
                        if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyadmin.syntax.remove.message.enabled")) {
                            player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyadmin.syntax.remove.message.message"));
                        }
                        return false;
                    }
                    UUID uuid;
                    try {
                        uuid = Main.getInstance().getUuidFetcher().getUUID(strings[1]);
                        if (!Main.getInstance().getMySQL().playerExist(uuid.toString(), "moneytable")) {
                            String notonline = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.message");
                            notonline = notonline.replaceAll("%TARGET%", strings[1]);
                            notonline = notonline.replaceAll("%PLAER%", player.getName());
                            player.sendMessage(Main.getInstance().getPrefix() + notonline);
                            if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyother.notonline.sound.enabled")) {
                                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyother.notonline.sound.pitch"));
                            }
                            return false;
                        }
                    } catch (Exception e) {
                        String notonline = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.message");
                        notonline = notonline.replaceAll("%TARGET%", strings[1]);
                        notonline = notonline.replaceAll("%PLAER%", player.getName());
                        player.sendMessage(Main.getInstance().getPrefix() + notonline);
                        if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyother.notonline.sound.enabled")) {
                            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyother.notonline.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyother.notonline.sound.pitch"));
                        }
                        return false;
                    }

                    Main.getInstance().getMySQL().removeMoney(uuid, Integer.parseInt(strings[2]));
                    String money = Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyadmin.remove.message.message");
                    money = money.replaceAll("%REMOVE_MONEY%", strings[2]);
                    money = money.replaceAll("%TARGET%", strings[1]);
                    player.sendMessage(Main.getInstance().getPrefix() + money);
                    if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.moneyadmin.remove.sound.enabled")) {
                        player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.moneyadmin.remove.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.moneyadmin.remove.sound.pitch"));
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
                if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.money.syntax.sound.enabled")) {
                    player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.money.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.money.syntax.sound.pitch"));
                }
                if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.money.syntax.message.enabled")) {
                    player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.money.syntax.message.message"));
                }
            }
        } else {
            if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.money.syntax.sound.enabled")) {
                player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.money.syntax.sound.sound")), 100, Main.getInstance().getFileManager().getMoneyYML().getInt("messages.commands.money.syntax.sound.pitch"));
            }
            if (Main.getInstance().getFileManager().getMoneyYML().getBoolean("messages.commands.money.syntax.message.enabled")) {
                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getFileManager().getMoneyYML().getString("messages.commands.money.syntax.message.message"));
            }
        }
        return false;
    }
}
