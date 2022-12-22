package fr.revoltinvoc.vatiraskyrun.runnables;

import fr.revoltinvoc.vatiraskyrun.GameStatus;
import fr.revoltinvoc.vatiraskyrun.Plugin;
import fr.revoltinvoc.vatiraskyrun.manager.GameManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameRunnable extends BukkitRunnable {

    public static int timer;

    @Override
    public void run() {
        timer++;
    }
}
