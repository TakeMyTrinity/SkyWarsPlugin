package fr.revoltinvoc.vatiraskyrun.listeners.player;

import fr.revoltinvoc.vatiraskyrun.utils.WinDetector;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        event.setQuitMessage(null);
        new WinDetector().check();

    }

}
