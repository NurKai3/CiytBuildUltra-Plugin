package de.snap20lp.citybuildultra.listeners;
/*

  This project was developed by Furkan  
                                                             
      Private Discord: Furkan#3511           
                                                                                                                      
           created at 19.01.2020
                                                              
        Project: CityBuildULTRA        
                                        
© 2019-2020 SnapDevStudios All Rights Reserved.

            
*/

import de.snap20lp.citybuildultra.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.help.HelpTopic;

public class OnCommand implements Listener {

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        if (!event.isCancelled() && Main.getInstance().getConfig().getBoolean("commandnotfound.enabled")) {
            String command = event.getMessage().split(" ")[0];
            HelpTopic helpTopic = Bukkit.getServer().getHelpMap().getHelpTopic(command);
            if (helpTopic == null) {
                if (Main.getInstance().getConfig().getBoolean("commandnotfound.sound.enabled")) {
                    player.playSound(player.getLocation(), Sound.valueOf(Main.getInstance().getConfig().getString("commandnotfound.sound.sound")), 100, Main.getInstance().getConfig().getInt("commandnotfound.sound.pitch"));
                }
                player.sendMessage(Main.getInstance().getPrefix() + Main.getInstance().getConfig().getString("commandnotfound.message").replaceAll("%COMMAND%", event.getMessage()));
                event.setCancelled(true);
            }
        }

    }


}
