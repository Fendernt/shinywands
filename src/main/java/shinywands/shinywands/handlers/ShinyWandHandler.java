package shinywands.shinywands.handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import shinywands.shinywands.items.ItemManager;
import shinywands.shinywands.managers.SpellManager;
import shinywands.shinywands.spells.spellglobals.ISpell;

public class ShinyWandHandler implements Listener {

    @EventHandler
    public static void onRightClick(PlayerInteractEvent event){
        if(event.getItem() != null){
            if(event.getItem().getItemMeta().equals(ItemManager.ShinyWand.getItemMeta())){
                SpellManager sm = new SpellManager();
                ISpell spell = sm.getActiveSpell(event.getPlayer());
                if(spell.getAction().contains(event.getAction())){
                    spell.executeSpell(event);
                }
            }
        }
    }
}
