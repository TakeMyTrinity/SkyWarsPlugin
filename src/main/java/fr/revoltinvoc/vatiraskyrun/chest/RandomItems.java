package fr.revoltinvoc.vatiraskyrun.chest;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomItems {

    public static List<ItemStack> items = new ArrayList<>();

    public RandomItems() {
        // On ajoute tous les items des coffres aléatoirement
        items.add(getItem(null, Material.STONE_SWORD, 1, (byte) 0, null, 0));
        items.add(getItem(null, Material.WOOD, 16, (byte) 0, null, 0));
        items.add(getItem(null, Material.TNT, 3, (byte) 0, null, 0));
        items.add(getItem(null, Material.APPLE, 4, (byte) 0, null, 0));
        items.add(getItem(null, Material.IRON_BOOTS, 1, (byte) 0, null, 0));
        items.add(getItem(null, Material.CHAINMAIL_LEGGINGS, 1, (byte) 0, null, 0));
        items.add(getItem(null, Material.GOLD_LEGGINGS, 1, (byte) 0, null, 0));
        items.add(getItem(null, Material.STONE, 12, (byte) 0, null, 0));
        items.add(getItem(null, Material.DIAMOND_SWORD, 1, (byte) 0, Enchantment.DAMAGE_ALL, 1));
        items.add(getItem(null, Material.EGG, 6, (byte) 0, null, 0));
        items.add(getItem(null, Material.EXP_BOTTLE, 24, (byte) 0, null, 0));
        items.add(getItem(null, Material.WOOD_SWORD, 1, (byte) 0, Enchantment.DAMAGE_ALL, 1));
        items.add(getItem(null, Material.STONE_SWORD, 1, (byte) 0, null, 0));
        items.add(getItem(null, Material.DIAMOND_HELMET, 1, (byte) 0, null, 0));
        items.add(getItem(null, Material.GLASS, 8, (byte) 0, null, 0));
        items.add(getItem(null, Material.GOLD_PICKAXE, 1, (byte) 0, null, 0));
        items.add(getItem(null, Material.STONE_PICKAXE, 1, (byte) 0, null, 0));
        items.add(getItem(null, Material.WOOD_AXE, 1, (byte) 0, Enchantment.DAMAGE_ALL, 1));
        items.add(getItem(null, Material.STONE_AXE, 1, (byte) 0, null, 0));
    }

    public static ItemStack getRandomItem() {
        int listMax = items.size() -1;
        Random random = new Random();
        int choice = random.nextInt(listMax);
        return items.get(choice);
    }

    private ItemStack getItem(String name, Material mat, int amount, byte data, Enchantment enchant, int enchantLevel) {
        ItemStack itemStack = new ItemStack(mat, amount, data);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        if (enchant != null) itemMeta.addEnchant(enchant, enchantLevel, true);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

}
