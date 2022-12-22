package fr.revoltinvoc.vatiraskyrun.chest;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ChestRefill {

    public void refillChest() {
        for (Chunk chunk : Bukkit.getWorld("world").getLoadedChunks()) {
            for (BlockState bs : chunk.getTileEntities()) {
                if (bs instanceof Chest) {
                    // Recuperer les coffres sous forme de variable
                    Chest chest = (Chest) bs.getBlock().getState();
                    Inventory chestInv = chest.getInventory();
                    chestInv.clear();
                    // Remplissez le coffre avec l'objet aléatoire dans des emplacements différents
                    for (int i = 0; i < chestInv.getSize(); i += 8) {
                        chestInv.setItem(i, RandomItems.getRandomItem());
                    }

                    ItemStack itemRandom = RandomItems.getRandomItem();
                    Random random = new Random();
                    int invMax = chestInv.getSize() -1;
                    int randomSlot = random.nextInt(invMax);
                    chestInv.setItem(randomSlot, itemRandom);
                }
            }
        }
    }

}
