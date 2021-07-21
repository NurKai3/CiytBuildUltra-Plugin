package de.snap20lp.citybuildultra.listeners;

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class OnDeath implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        event.setKeepInventory(Main.getInstance().getFileManager().getDeathYML().getBoolean("death.keepinventory"));

        if (!Main.getInstance().getFileManager().getDeathYML().getBoolean("death.dropitems.enabled")) {
            event.getDrops().clear();
        }
        event.setKeepLevel(Main.getInstance().getFileManager().getDeathYML().getBoolean("death.keeplevel"));
        event.setKeepInventory(Main.getInstance().getFileManager().getDeathYML().getBoolean("death.keepinventory"));

        if (Main.getInstance().getFileManager().getDeathYML().getBoolean("death.autorespawn.enabled")) {

            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
                @Override
                public void run() {
                    player.spigot().respawn();
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), () -> {
                        Location location;
                        if (Main.getInstance().getFileManager().getDeathYML().getBoolean("death.respawnatspawn.enabled")) {
                            location = (Location) Main.getInstance().getFileManager().getSpawnsYML().get("main.spawn.location");
                        } else {
                            location = new Location(Bukkit.getWorld(Main.getInstance().getFileManager().getDeathYML().getString("death.respawnother.world")), Main.getInstance().getFileManager().getDeathYML().getInt("death.respawnother.x"), Main.getInstance().getFileManager().getDeathYML().getInt("death.respawnother.y"), Main.getInstance().getFileManager().getDeathYML().getInt("death.respawnother.z"));
                        }
                        if (location != null) {
                            player.teleport(location);
                        } else {
                            player.sendMessage(Main.getInstance().getPrefix() + "§cSpawnfile is corrupt please report this message to an administrator or owner!");
                        }
                    }, 10);
                }
            }, 20L * Main.getInstance().getFileManager().getDeathYML().getInt("death.autorespawn.delayseconds"));
        }

        if (Main.getInstance().getFileManager().getDeathYML().getBoolean("death.broadcast.enabled")) {
            String message = Main.getInstance().getFileManager().getDeathYML().getString("death.broadcast.message");
            message = message.replaceAll("%PLAYER%", player.getName());
            message = message.replaceAll("%PREFIX%", Main.getInstance().getPrefix());
            event.setDeathMessage(message);
        } else {
            event.setDeathMessage(null);
        }

        if (Main.getInstance().getFileManager().getDeathYML().getBoolean("death.sound.enabled")) {
            player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getFileManager().getDeathYML().getString("death.sound.sound")), 100, Main.getInstance().getFileManager().getDeathYML().getInt("death.sound.pitch"));
        }

        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                if (Main.getInstance().getFileManager().getDeathYML().getBoolean("death.self.message.enabled")) {
                    String message = Main.getInstance().getFileManager().getDeathYML().getString("death.self.message.message");
                    if (Main.getInstance().getMySQL().getMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName())) < Main.getInstance().getFileManager().getDeathYML().getInt("death.money.lose.money")) {
                        message = message.replaceAll("%LOST_MONEY%", "0");
                    } else {
                        message = message.replaceAll("%LOST_MONEY%", Main.getInstance().getFileManager().getDeathYML().getBoolean("death.money.lose.enabled") ? String.valueOf(Main.getInstance().getFileManager().getDeathYML().getInt("death.money.lose.money")) : "0");
                    }
                    message = message.replaceAll("%PREFIX%", Main.getInstance().getPrefix());
                    player.sendMessage(message);
                }
                if (Main.getInstance().getFileManager().getDeathYML().getBoolean("death.money.lose.enabled")) {
                    if (Main.getInstance().getMySQL().getMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName())) < Main.getInstance().getFileManager().getDeathYML().getInt("death.money.lose.money")) {
                        Main.getInstance().getMySQL().resetMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName()));
                    } else {
                        Main.getInstance().getMySQL().removeMoney(Main.getInstance().getUuidFetcher().getUUID(player.getName()), Main.getInstance().getFileManager().getDeathYML().getInt("death.money.lose.money"));
                    }
                }
            }
        }, 10);


    }
}
