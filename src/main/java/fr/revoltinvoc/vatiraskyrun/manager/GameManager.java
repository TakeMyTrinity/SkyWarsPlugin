package fr.revoltinvoc.vatiraskyrun.manager;

import fr.revoltinvoc.vatiraskyrun.GameStatus;
import fr.revoltinvoc.vatiraskyrun.Plugin;
import fr.revoltinvoc.vatiraskyrun.chest.ChestRefill;
import fr.revoltinvoc.vatiraskyrun.chest.RandomItems;
import fr.revoltinvoc.vatiraskyrun.kits.CraftKits;
import fr.revoltinvoc.vatiraskyrun.kits.KitsManager;
import fr.revoltinvoc.vatiraskyrun.runnables.StartRunnable;
import fr.revoltinvoc.vatiraskyrun.scoreboards.ScoreboardManager;
import fr.revoltinvoc.vatiraskyrun.utils.CagesUtils;
import fr.revoltinvoc.vatiraskyrun.utils.TitleManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class GameManager {

    public GameManager(){

    }
    public void loadGame(Player player){
        //Set le gamemode survival

        player.setGameMode(GameMode.SURVIVAL);
        // Clear inventory

        player.getInventory().clear();
        //Activation du pvp

        Bukkit.getWorld("world").setPVP(true);
        // Téléportation cage

        CagesUtils.teleportPlayerToCage(player);
        //Ajout de tous les items
        new RandomItems();

        //Ajout des items au coffre
        new ChestRefill().refillChest();

        //Start de la game
        new StartRunnable().runTaskTimer(Plugin.INSTANCE, 0L, 20L);

        //On donne le kit choisi
        if (CraftKits.playerKits.get(player) == KitsManager.RUSHEUR) {
            new CraftKits(player).giveRusheurKit();
        } else if (CraftKits.playerKits.get(player) == KitsManager.HEALER) {
            new CraftKits(player).giveHealerKit();
        } else {
            new CraftKits(player).giveDefaultKit();
        }
        }
}