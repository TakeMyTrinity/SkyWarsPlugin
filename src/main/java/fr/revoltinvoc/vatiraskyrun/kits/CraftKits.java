package fr.revoltinvoc.vatiraskyrun.kits;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.HashMap;

public class CraftKits {
    private Player player;

    public static HashMap<Player, KitsManager> playerKits = new HashMap<>();

    public CraftKits(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void giveDefaultKit() {
        player.getInventory().setItem(1, new ItemStack(Material.WOOD_AXE, 1));
    }

    public void giveRusheurKit() {
        player.getInventory().setItem(1, new ItemStack(Material.WOOD_AXE, 1));
        player.getInventory().setItem(1, new ItemStack(Material.COBBLESTONE, 16));
    }
    public void giveHealerKit() {
        Potion potionRegen = new Potion(PotionType.REGEN, 1, false, false);
        potionRegen.setSplash(false);
        ItemStack itemStack = potionRegen.toItemStack(1);
        player.getInventory().setItem(2, itemStack);

        player.getInventory().setItem(1, new ItemStack(Material.GOLDEN_APPLE, 1));
    }

}
