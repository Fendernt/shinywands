package shinywands.shinywands.spells;

import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import shinywands.shinywands.globalFunctions.PlayerMethods;
import shinywands.shinywands.spells.spellglobals.ElementType;
import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.Collections;
import java.util.List;

public class DragonBallSpell extends ISpell {
    @Override
    public String Name() {
        return "Dragon Ball";
    }

    @Override
    public int getCooldown() {
        return 8;
    }

    @Override
    public ElementType getElement() {
        return ElementType.DARK;
    }

    @Override
    public List<Action> getAction() {
        return Collections.singletonList(Action.RIGHT_CLICK_AIR);
    }

    @Override
    public boolean executeSpellBehavior(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        DragonFireball f = player.launchProjectile(DragonFireball.class);
        f.setVelocity(PlayerMethods.getPlayerLookVector(player.getLocation(), player.rayTraceBlocks(200).getHitBlock().getLocation()));
        f.setVisualFire(true);
        return true;
    }
}
