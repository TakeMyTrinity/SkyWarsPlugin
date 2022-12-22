package fr.revoltinvoc.vatiraskyrun.listeners.player;

import fr.revoltinvoc.vatiraskyrun.GameStatus;
import fr.revoltinvoc.vatiraskyrun.utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class ParametersListener implements Listener {
    @EventHandler
    public void onFoodLevel(FoodLevelChangeEvent event){
        if (GameStatus.isStatus(GameStatus.LOBBY)) event.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        if (GameStatus.isStatus(GameStatus.LOBBY)) event.setCancelled(true);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (GameStatus.isStatus(GameStatus.LOBBY)) event.setCancelled(true);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (GameStatus.isStatus(GameStatus.LOBBY)) event.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (GameStatus.isStatus(GameStatus.LOBBY)) event.setCancelled(true);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (GameStatus.isStatus(GameStatus.LOBBY)) event.setCancelled(true);
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        // Quand le player va tomber dans le void
        Player player = event.getPlayer();
        if (GameStatus.isStatus(GameStatus.LOBBY)) {
            if (player.getLocation().getY() <= 0) {
                TitleManager.sendTitle(player, "", "§bNe vous éloignez pas trop du lobby !", 20);
                player.teleport(new Location(Bukkit.getWorld("world"), 0, 119, -1, 0, 0));
            }
        } else {
            if (player.getLocation().getY() <= 10) player.damage(20.0D);
        }
    }
}
