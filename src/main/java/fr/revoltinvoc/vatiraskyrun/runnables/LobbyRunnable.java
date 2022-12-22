package fr.revoltinvoc.vatiraskyrun.runnables;

import fr.revoltinvoc.vatiraskyrun.GameStatus;
import fr.revoltinvoc.vatiraskyrun.Plugin;
import fr.revoltinvoc.vatiraskyrun.manager.GameManager;
import fr.revoltinvoc.vatiraskyrun.scoreboards.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LobbyRunnable extends BukkitRunnable {

    public static int timer = 30;
    public static boolean start = false;

    @Override
    public void run() {
        timer--;

        if ((Bukkit.getOnlinePlayers().size() < 1) || (!GameStatus.isStatus(GameStatus.LOBBY))){
            Bukkit.broadcastMessage(Plugin.INSTANCE.getPrefix() + "§cIl n'y a pas assez de joueur pour démarrer la partie !");
            timer = 121;
            this.cancel();
            return;
        }

        if ((timer == 120) || (timer == 90) || (timer == 60) || (timer == 30) || (timer == 15) || (timer == 10) ||
                (timer == 5) || (timer == 4) || (timer == 3) || (timer == 2) || (timer == 1)){
            Bukkit.broadcastMessage(Plugin.INSTANCE.getPrefix() + "§6La partie commence dans §e" + timer + " " + getSecond(timer));
            for (Player players : Bukkit.getOnlinePlayers()){
                players.playSound(players.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
            }
            return;
        }

        if (timer == 0){
            timer = 30;
            this.cancel();
            for (Player players : Bukkit.getOnlinePlayers()){ new GameManager().loadGame(players); }
            new GameRunnable().runTaskTimer(Plugin.INSTANCE, 0L, 20L);
            return;
        }
        setLevel();
    }

    public void setLevel(){
        for (Player players : Bukkit.getOnlinePlayers()){
            players.setLevel(timer);

            if (GameStatus.isStatus(GameStatus.LOBBY)){
                if (ScoreboardManager.scoreboardGame.containsKey(players)){
                    ScoreboardManager.scoreboardGame.get(players).setLine(6, "§7Début dans: §b" +
                            new SimpleDateFormat("mm:ss").format(new Date(timer * 1000)));
                }
            }
        }
    }

    private String getSecond(int time) {
        if (time == 1) return "seconde";
        return "secondes";
    }
}
