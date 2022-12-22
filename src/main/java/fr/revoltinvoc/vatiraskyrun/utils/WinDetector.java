package fr.revoltinvoc.vatiraskyrun.utils;

import fr.revoltinvoc.vatiraskyrun.GameStatus;
import fr.revoltinvoc.vatiraskyrun.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class WinDetector {

    public List<Player> survivals = new ArrayList<>();
    public void check() {

        for (Player player : Bukkit.getOnlinePlayers()){
            if (player.getGameMode() != GameMode.SPECTATOR) {
                survivals.add(player);
            }
            if (survivals.size() == 1) {
                GameStatus.setStatus(GameStatus.END);
                for (int i = 0; i < survivals.size(); i++) {
                    TitleManager.sendTitle(survivals.get(i), "§6§lFelicitation !",
                            "§bVous avez gagné la partie...", 60);
                }
                end();
            }
        }
    }

    private void end() {
        Bukkit.getScheduler().runTaskLater(Plugin.INSTANCE, () -> {
            Bukkit.spigot().restart();
        }, 80);
    }
}
