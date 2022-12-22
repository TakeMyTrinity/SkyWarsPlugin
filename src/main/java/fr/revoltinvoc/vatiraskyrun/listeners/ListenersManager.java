package fr.revoltinvoc.vatiraskyrun.listeners;

import fr.revoltinvoc.vatiraskyrun.listeners.player.*;
import fr.revoltinvoc.vatiraskyrun.menus.KitsMenu;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {

    public Plugin plugin;
    public PluginManager pluginManager;

    public ListenersManager(Plugin plugin) {
        this.plugin = plugin;
        this.pluginManager = Bukkit.getPluginManager();
    }

    public void registerListeners() {
        this.pluginManager.registerEvents(new PlayerJoinListener(), this.plugin);
        this.pluginManager.registerEvents(new PlayerDeathListener(), this.plugin);
        this.pluginManager.registerEvents(new PlayerQuitListener(), this.plugin);
        this.pluginManager.registerEvents(new ParametersListener(), this.plugin);
        this.pluginManager.registerEvents(new AutoLeafDecayListener(), this.plugin);
        this.pluginManager.registerEvents(new PlayerInteractListener(), this.plugin);
        this.pluginManager.registerEvents(new CustumBlockDropListener(), this.plugin);

        this.pluginManager.registerEvents(new KitsMenu(), this.plugin);
    }

}