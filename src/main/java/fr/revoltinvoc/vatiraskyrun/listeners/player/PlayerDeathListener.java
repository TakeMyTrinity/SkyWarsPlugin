package fr.revoltinvoc.vatiraskyrun.listeners.player;

import fr.revoltinvoc.vatiraskyrun.Plugin;
import fr.revoltinvoc.vatiraskyrun.utils.WinDetector;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerDeathListener implements Listener {
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player killer = event.getEntity().getKiller();
        Player player = event.getEntity();

        //Respawn instant du joueur
        instantDeath(player);
        player.setGameMode(GameMode.SPECTATOR);
        new WinDetector().check();

        if (killer != null) {
            event.setDeathMessage(Plugin.INSTANCE.getPrefix() + "§f" + player.getName() + "§7a été tué par §c" +
                    killer.getName());
            player.getInventory().clear();
            player.getInventory().setHelmet(new ItemStack(Material.AIR));
            player.getInventory().setChestplate(new ItemStack(Material.AIR));
            player.getInventory().setLeggings(new ItemStack(Material.AIR));
            player.getInventory().setBoots(new ItemStack(Material.AIR));

            new WinDetector().check();

        } else {
            //killer != joueur
            event.setDeathMessage(event.getEntity().getName() + " est mort d'une manière mystérieuse...");
        }
    }

    private void instantDeath(Player player) {
        Bukkit.getScheduler().runTaskLater(Plugin.INSTANCE, () -> {
            PacketPlayInClientCommand packet = new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN);
            ((CraftPlayer) player).getHandle().playerConnection.a(packet);
        }, 1L);
    }
}
