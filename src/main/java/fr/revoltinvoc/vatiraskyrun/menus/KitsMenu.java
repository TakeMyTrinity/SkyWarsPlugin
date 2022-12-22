package fr.revoltinvoc.vatiraskyrun.menus;

import fr.revoltinvoc.vatiraskyrun.Plugin;
import fr.revoltinvoc.vatiraskyrun.kits.CraftKits;
import fr.revoltinvoc.vatiraskyrun.kits.KitsManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class KitsMenu implements Listener {

    public String invName = "Selection de kits";
    private Inventory inventory = Bukkit.createInventory(null, 9, invName);

    public KitsMenu() {
        ItemStack rusheur = new ItemStack(Material.OBSIDIAN, 1);
        ItemMeta rusheurMeta = rusheur.getItemMeta();
        rusheurMeta.setDisplayName("§eRusheur");
        rusheurMeta.setLore(Arrays.asList("§7Permet de rush plus vite au centre", "§7au lancement de la partie"));
        rusheur.setItemMeta(rusheurMeta);
        inventory.setItem(3, rusheur);

        ItemStack healer = new ItemStack(Material.APPLE, 1);
        ItemMeta healerMeta = healer.getItemMeta();
        healerMeta.setDisplayName("§eHealer");
        healerMeta.setLore(Arrays.asList("§7Permet d'avoir un pack de soin", "§7au lancement de la partie"));
        healer.setItemMeta(healerMeta);
        inventory.setItem(5, healer);
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

    @EventHandler
    public void onClickInventory(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getCurrentItem() == null && event.getAction() != null)
            return;
        if (event.getInventory().getName().equalsIgnoreCase(invName)) {
            switch (event.getCurrentItem().getType()) {
                case OBSIDIAN:
                    if (CraftKits.playerKits.get(player) == KitsManager.RUSHEUR) {
                        player.sendMessage(Plugin.INSTANCE.getPrefix() + "§cVous avez déjà choisi ce kit.");
                        player.closeInventory();
                    } else {
                        CraftKits.playerKits.put(player, KitsManager.RUSHEUR);
                        player.sendMessage(Plugin.INSTANCE.getPrefix() + "§7Vous avez choisi le kit §eRusheur.");
                    }
                    break;

                case APPLE:
                    if (CraftKits.playerKits.get(player) == KitsManager.HEALER) {
                        player.sendMessage(Plugin.INSTANCE.getPrefix() + "§cVous avez déjà choisi ce kit.");
                        player.closeInventory();
                    } else {
                        CraftKits.playerKits.put(player, KitsManager.HEALER);
                        player.sendMessage(Plugin.INSTANCE.getPrefix() + "§7Vous avez choisi le kit §eHealer.");
                    }
                    break;

                default:
                    break;
            }

        }
    }
}
