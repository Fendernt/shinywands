package shinywands.shinywands.spells;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import shinywands.shinywands.spells.spellglobals.ElementType;
import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.Arrays;
import java.util.List;

public class SelfExplosionSpell extends ISpell {
    @Override
    public String Name() {
        return "Self explosion";
    }

    @Override
    public int getCooldown() {
        return 10;
    }

    @Override
    public ElementType getElement() {
        return ElementType.EARTH;
    }

    @Override
    public List<Action> getAction() {
        return Arrays.asList(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
    }

    @Override
    public boolean executeSpellBehavior(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        player.getWorld().createExplosion(player.getLocation(), 2.0f, true);
        return true;
    }
}
