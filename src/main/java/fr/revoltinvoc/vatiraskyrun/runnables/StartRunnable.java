package fr.revoltinvoc.vatiraskyrun.runnables;

import fr.revoltinvoc.vatiraskyrun.GameStatus;
import fr.revoltinvoc.vatiraskyrun.Plugin;
import fr.revoltinvoc.vatiraskyrun.scoreboards.ScoreboardManager;
import fr.revoltinvoc.vatiraskyrun.utils.CagesUtils;
import fr.revoltinvoc.vatiraskyrun.utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StartRunnable extends BukkitRunnable {

    public int timer = 11;

    @Override
    public void run() {
        timer--;

        if (timer == 10 || timer == 5 || timer == 4 || timer == 3 || timer == 2 || timer == 1) {
            Bukkit.broadcastMessage(Plugin.INSTANCE.getPrefix() + "§6La partie commence dans §e" + timer + " " + getSecond(timer));
            for (Player players : Bukkit.getOnlinePlayers()){
                players.playSound(players.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
            }
            return;
        }

        if (timer == 0) {
            GameStatus.setStatus(GameStatus.GAME);
            this.cancel();
            CagesUtils.destroyCages();
            for (Player player : Bukkit.getOnlinePlayers()) {
                TitleManager.sendTitle(player, "", "§bLa partie a commencé", 40);
                player.playSound(player.getLocation(), Sound.EXPLODE, 1f, 1f);
                //Load du ScoreBoard de Game
                if (ScoreboardManager.scoreboardGame.containsKey(player)) {
                    new ScoreboardManager(player).loadGameScorboard();
                }
            }
            new GameRunnable().runTaskTimer(Plugin.INSTANCE, 0L, 20L);
            return;
        }
    }

    private String getSecond(int time) {
        if (time == 1) return "seconde";
        return "secondes";
    }
}
