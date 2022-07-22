package shinywands.shinywands.spells;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.RayTraceResult;
import shinywands.shinywands.globalFunctions.ParticleMethods;
import shinywands.shinywands.spells.spellglobals.ElementType;
import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.Arrays;
import java.util.List;


public class BiggerExplosionSpell extends ISpell {
    @Override
    public String Name() {
        return "BIGGER Explosion Spell";
    }

    @Override
    public int getCooldown() {
        return 20;
    }

    @Override
    public ElementType getElement() {
        return ElementType.FIRE;
    }

    @Override
    public List<Action> getAction() {
        return Arrays.asList(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
    }

    @Override
    public boolean executeSpellBehavior(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        RayTraceResult result = player.rayTraceBlocks(200);
        if(result != null) {
            ParticleMethods.drawLine(player.getEyeLocation(),result.getHitBlock().getLocation(), 2, Particle.FLAME);
            player.getWorld().createExplosion(result.getHitBlock().getLocation(), 15.0f, true);
            return true;
        }
        return false;
    }
}
