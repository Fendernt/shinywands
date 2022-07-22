package shinywands.shinywands.spells;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Entity;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;
import shinywands.shinywands.spells.spellglobals.ElementType;
import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LaunchSpell extends ISpell {
    @Override
    public String Name() {
        return "Launch Spell";
    }

    @Override
    public int getCooldown() {
        return 3;
    }

    @Override
    public ElementType getElement() {
        return ElementType.AIR;
    }

    @Override
    public List<Action> getAction() {
        return Collections.singletonList(Action.RIGHT_CLICK_AIR);
    }

    @Override
    public boolean executeSpellBehavior(PlayerInteractEvent event) {
        RayTraceResult rs = event.getPlayer().rayTraceBlocks(200);
        Collection<Entity> entities = rs.getHitBlock().getLocation().getWorld().getNearbyEntities(rs.getHitBlock().getLocation(), 3,3,3);
        for(Entity entity : entities){
            entity.getWorld().spawnParticle(Particle.REDSTONE, entity.getLocation(), 100, 1, 1, 1, getElement().getDustTransition());
            entity.setVelocity(new Vector(0,1,0).multiply(2.3));
            return true;
        }
        return false;
    }
}
