package fr.revoltinvoc.vatiraskyrun.listeners.player;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class CustumBlockDropListener implements Listener {

    @EventHandler
    public void onPlayerBreak(BlockBreakEvent event) {
        Location breakLoc = event.getBlock().getLocation();

        switch (event.getBlock().getType()) {
            case IRON_ORE:
                event.setCancelled(true);
                event.getBlock().setType(Material.AIR);

                breakLoc.getWorld().dropItemNaturally(breakLoc,new ItemStack(Material.IRON_INGOT, 1));
                break;

            case COAL_ORE:
                event.setCancelled(true);
                event.getBlock().setType(Material.AIR);

                breakLoc.getWorld().dropItemNaturally(breakLoc,new ItemStack(Material.COAL, 4));
                break;

            case GOLD_ORE:
                event.setCancelled(true);
                event.getBlock().setType(Material.AIR);

                breakLoc.getWorld().dropItemNaturally(breakLoc,new ItemStack(Material.GOLD_INGOT, 2));
                break;

            case DIAMOND_ORE:
                event.setCancelled(true);
                event.getBlock().setType(Material.AIR);

                breakLoc.getWorld().dropItemNaturally(breakLoc,new ItemStack(Material.DIAMOND, 1));
                break;
        }
    }
}
