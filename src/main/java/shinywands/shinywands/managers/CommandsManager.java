package shinywands.shinywands.managers;

import shinywands.shinywands.commands.ShinyWandCommand;

import static shinywands.shinywands.Shinywands.PLUGIN;

public class CommandsManager {

    public static void initializeCommands(){
        PLUGIN.getCommand("shinywand").setExecutor(new ShinyWandCommand());
    }
}
