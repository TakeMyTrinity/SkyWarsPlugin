package fr.revoltinvoc.vatiraskyrun.utils;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CagesUtils {

    public static List<Location> cagesLocation = new ArrayList<Location>();

    public static void teleportPlayerToCage(Player player){
        cagesLocation.add(new Location(Bukkit.getWorld("world"), 48, 75, -23));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), 70, 75, 0));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), 48, 75, 22));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), 22, 75, 48));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), 0, 75, 70));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), -23, 75, 48));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), -49, 75, 22));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), -71, 75, 0));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), -49, 75, -23));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), -23, 75, -49));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), 0, 75, -71));
        cagesLocation.add(new Location(Bukkit.getWorld("world"), 22, 75, -49));

        for (int x = 0; x < Bukkit.getOnlinePlayers().size(); x++) {
            player.teleport(cagesLocation.get(new Random().nextInt(cagesLocation.size())));
        }
    }

    public static void destroyCages(){
        for (Location cagesLoc : cagesLocation) {
            Location glass = cagesLoc.add(0, -1, 0);
            glass.getBlock().setType(Material.AIR);
        }
    }
}
