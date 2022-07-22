package shinywands.shinywands.managers;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import shinywands.shinywands.handlers.ShinyWandHandler;
import shinywands.shinywands.handlers.SpellFunctionHandlers;
import shinywands.shinywands.handlers.SwitchSpellsHandler;

import java.util.Arrays;
import java.util.List;

import static shinywands.shinywands.Shinywands.PLUGIN;

public class HandlersManager {

    public static void initializeHandlers(){
        List<Listener> handlers = Arrays.asList(
                new ShinyWandHandler(),
                new SwitchSpellsHandler(),
                new SpellFunctionHandlers()
        );
        register(handlers);
    }

    private static void register(List<Listener> handlers){
        for(Listener event : handlers) {
            Bukkit.getPluginManager().registerEvents(event, PLUGIN);
        }
    }

}
