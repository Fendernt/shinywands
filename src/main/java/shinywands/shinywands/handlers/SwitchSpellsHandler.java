package shinywands.shinywands.handlers;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import shinywands.shinywands.items.ItemManager;
import shinywands.shinywands.managers.SpellManager;

public class SwitchSpellsHandler implements Listener {

    @EventHandler
    public static void onShiftRightClickEvent(PlayerInteractEvent event){
        Player player = event.getPlayer();
        if(event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK){
            if(event.getItem() != null){
                if(event.getItem().getItemMeta().equals(ItemManager.ShinyWand.getItemMeta())){
                    SpellManager sm = new SpellManager();
                    if(player.isSneaking()){
                        sm.previousSpell(player);
                    } else {
                        sm.nextSpell(player);
                    }
                    event.setCancelled(true);
                }
            }
        }
    }
}
