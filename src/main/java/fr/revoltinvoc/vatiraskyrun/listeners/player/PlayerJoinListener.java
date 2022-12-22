package fr.revoltinvoc.vatiraskyrun.listeners.player;

import fr.revoltinvoc.vatiraskyrun.GameStatus;
import fr.revoltinvoc.vatiraskyrun.kits.CraftKits;
import fr.revoltinvoc.vatiraskyrun.kits.KitsManager;
import fr.revoltinvoc.vatiraskyrun.runnables.LobbyRunnable;
import fr.revoltinvoc.vatiraskyrun.scoreboards.ScoreboardManager;
import fr.revoltinvoc.vatiraskyrun.utils.TitleManager;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import fr.revoltinvoc.vatiraskyrun.Plugin;
import org.bukkit.inventory.ItemStack;

public class PlayerJoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage(Plugin.INSTANCE.getPrefix() + ChatColor.GRAY + player.getName()
                + " §e a rejoint la partie ! §a(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers()
                + ")");

        player.teleport(new Location(Bukkit.getWorld("world"), 0, 119, -1, 0, 0));
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().clear();
        player.setFoodLevel(20);
        player.setHealth(20);
        player.setLevel(0);


        TitleManager.sendTitle(player, "§6Skyrun", "Bienvenue dans la partie.", (20 * 3));

        // On donne le kit par default au joueur
        CraftKits.playerKits.put(player, KitsManager.DEFAULT);

        player.getInventory().setItem(4, new ItemStack(Material.NETHER_STAR, 1));

        if (!ScoreboardManager.scoreboardGame.containsKey(player)) {
            new ScoreboardManager(player).loadScoreboard();
        }

        if ((!LobbyRunnable.start) && (GameStatus.isStatus(GameStatus.LOBBY))) {
            new LobbyRunnable().runTaskTimer(Plugin.INSTANCE, 0L, 20L);
            LobbyRunnable.start = true;
            return;
        }
    }
}
