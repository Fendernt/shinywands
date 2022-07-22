package shinywands.shinywands.spells;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;
import shinywands.shinywands.spells.spellglobals.ElementType;
import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.Collections;
import java.util.List;

import static shinywands.shinywands.Shinywands.PLUGIN;

public class LeapSpell extends ISpell {

    private int totalParticles = 0;

    @Override
    public String Name() {
        return "Leap Spell";
    }

    @Override
    public int getCooldown() {
        return 5;
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
        Vector lookingAtVector = event.getPlayer().getEyeLocation().getDirection();
        event.getPlayer().setVelocity(lookingAtVector.multiply(3));
        totalParticles = 18;
        spawnParticles(getElement().getDustTransition(), event.getPlayer());
        return true;
    }

    private void spawnParticles(Particle.DustTransition dustTransition, Player player){
        player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 30, 0.2, 0.2, 0.2, dustTransition);
        if(totalParticles > 0){
            totalParticles-=1;
            Bukkit.getScheduler().scheduleSyncDelayedTask(PLUGIN, () -> spawnParticles(dustTransition,player), 2L);
        }
    }
}
