package fr.revoltinvoc.vatiraskyrun.scoreboards;

import fr.revoltinvoc.vatiraskyrun.runnables.GameRunnable;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static fr.revoltinvoc.vatiraskyrun.runnables.LobbyRunnable.timer;

public class ScoreboardManager {

    public Player player;
    public ScoreboardSign sign;
    public static Map<Player, ScoreboardSign> scoreboardGame = new HashMap<>();

    public ScoreboardManager(Player player) {
        this.player = player;
        this.sign = new ScoreboardSign(player, player.getName());
        scoreboardGame.put(player, this.sign);
    }

    public void loadScoreboard() {
        this.sign.setObjectiveName("§6§lSkyRun");
        this.sign.create();

        ((ScoreboardSign) scoreboardGame.get(player)).setLine(7, "§7");
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(6, "§7Début dans: §b" +
                new SimpleDateFormat("mm:ss").format(new Date(timer * 1000)));
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(5, "§8");
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(4, "§7Joueurs: §e" +
                Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(3, "§5");
        if (Bukkit.getOnlinePlayers().size() != Bukkit.getMaxPlayers()) {
            ((ScoreboardSign) scoreboardGame.get(player)).setLine(2, "§cEn l'attente de");
            ((ScoreboardSign) scoreboardGame.get(player)).setLine(1, "§cjoueurs...");
        } else {
            ((ScoreboardSign) scoreboardGame.get(player)).setLine(2, "§2La partie va");
            ((ScoreboardSign) scoreboardGame.get(player)).setLine(1, "§2débuter...");
        }
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(0, "§2");
    }

    public void loadGameScorboard() {
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(6, "§7");
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(5, "§7Temps §e" +
                new SimpleDateFormat("mm:ss").format(new Date(GameRunnable.timer * 1000)));
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(4, "§7Kills: §a" +
                player.getStatistic(Statistic.PLAYER_KILLS));
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(3, "§8");
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(2, "§7Joueurs: §e" +
                Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers());
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(1, "§5");
        ((ScoreboardSign) scoreboardGame.get(player)).setLine(0, "§2");
    }

}
