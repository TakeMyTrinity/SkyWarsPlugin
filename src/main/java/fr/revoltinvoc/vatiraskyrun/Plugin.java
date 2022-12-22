package fr.revoltinvoc.vatiraskyrun;

import fr.revoltinvoc.vatiraskyrun.utils.WorldManager;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import fr.revoltinvoc.vatiraskyrun.listeners.ListenersManager;

/*
 * vatiraSkyrun SkyRun plugin
 * BY REVOLTINVOC
 */
public class Plugin extends JavaPlugin {
  public static Plugin INSTANCE;

  public void onEnable() {
    INSTANCE = this;

    // API luckperms INITIALISATION
    RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
    if (provider != null) {
      LuckPerms api = provider.getProvider();
    }

    new ListenersManager(this).registerListeners();
    GameStatus.setStatus(GameStatus.LOBBY);

  }

  public void onDisable() {
    WorldManager.replaceWorld(true);
  }

  public String getPrefix() {
    return "§7[§eSkyRun§7]";
  }

}
