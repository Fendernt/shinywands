package shinywands.shinywands.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import shinywands.shinywands.managers.SpellManager;
import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.function.Function;

public class SpellFunctionHandlers implements Listener {

    @EventHandler
    public static void onPlayerDeath(PlayerDeathEvent event){
        executeFunction(event.getEntity(), e -> e.onPlayerDeath(event));
    }

    @EventHandler
    public static void onGamemodeChange(PlayerGameModeChangeEvent event){
        executeFunction(event.getPlayer(), e -> e.onGamemodeChange(event));
    }

    private static void executeFunction(Player player, Function<ISpell, Object>function){
        SpellManager sm = new SpellManager();
        for(ISpell spell : sm.getPlayerSpells(player)){
            function.apply(spell);
        }
    }
}
