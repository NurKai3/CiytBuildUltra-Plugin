package de.snap20lp.citybuildultra.listeners;

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnLeave implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {

        if (!Main.getInstance().getFileManager().getLeaveYML().getBoolean("leave.broadcast.enabled")) {
            event.setQuitMessage(null);
        } else {
            String message = Main.getInstance().getFileManager().getLeaveYML().getString("leave.broadcast.message");
            message = message.replaceAll("%PLAYER%", event.getPlayer().getName());
            message = message.replaceAll("%PREFIX%", Main.getInstance().getPrefix());
            event.setQuitMessage(message);
        }

    }

}
