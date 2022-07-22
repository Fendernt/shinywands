package shinywands.shinywands;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import shinywands.UpdateChecker;
import shinywands.shinywands.items.ItemManager;
import shinywands.shinywands.managers.CommandsManager;
import shinywands.shinywands.managers.HandlersManager;
import shinywands.shinywands.managers.ServerCommunicator;

public final class Shinywands extends JavaPlugin {

    public static Shinywands PLUGIN = null;

    @Override
    public void onEnable() {
        PLUGIN = this;

        HandlersManager.initializeHandlers();
        CommandsManager.initializeCommands();

        ItemManager.initializeItems();

        checkForUpdates();
        ServerCommunicator.sendConsoleMessage("Shiny Wands enabled.");
    }

    @Override
    public void onDisable() {

        ServerCommunicator.sendConsoleMessage("Shiny Wands disabled.");
    }


    private void checkForUpdates(){
        new UpdateChecker(this, 103142).getVersion(version -> {
            if (this.getDescription().getVersion().equals(version)) {
                ServerCommunicator.sendConsoleMessage("Shiny Wands is up to date.");
            } else {
                ServerCommunicator.sendConsoleMessage(ChatColor.RED + "There is a new version of Shiny Wands available. Please consider updating.");
                ServerCommunicator.sendConsoleMessage(ChatColor.RED +"You are on version: "+this.getDescription().getVersion()+", please update to version: "+version);
            }
        });
    }
}
