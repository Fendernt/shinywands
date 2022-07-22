package shinywands.shinywands.spells;

import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import shinywands.shinywands.globalFunctions.PlayerMethods;
import shinywands.shinywands.spells.spellglobals.ElementType;
import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.Collections;
import java.util.List;

public class SmallFireballSpell extends ISpell {
    @Override
    public String Name() {
        return "Fireball Spell";
    }

    @Override
    public int getCooldown() {
        return 3;
    }

    @Override
    public ElementType getElement() {
        return ElementType.FIRE;
    }

    @Override
    public List<Action> getAction() {
        return Collections.singletonList(Action.RIGHT_CLICK_AIR);
    }

    @Override
    public boolean executeSpellBehavior(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Fireball f = player.launchProjectile(Fireball.class);
        f.setIsIncendiary(false);
        f.setVelocity(PlayerMethods.getPlayerLookVector(player.getLocation(), player.rayTraceBlocks(200).getHitBlock().getLocation()));
        f.setVisualFire(true);
        return true;
    }
}
