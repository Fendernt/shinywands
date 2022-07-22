package shinywands.shinywands.spells;

import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import shinywands.shinywands.spells.spellglobals.ElementType;
import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.Arrays;
import java.util.List;

public class HealSpell extends ISpell {

    private int healAmount = 8;

    @Override
    public String Name() {
        return "Heal spell";
    }

    @Override
    public int getCooldown() {
        return 6;
    }

    @Override
    public ElementType getElement() {
        return ElementType.WATER;
    }

    @Override
    public List<Action> getAction() {
        return Arrays.asList(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
    }

    @Override
    public boolean executeSpellBehavior(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if(player.getHealth()+healAmount <= player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()){
            player.setHealth(player.getHealth() + 8);
        } else {
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        }
        player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 60, 1, 1, 1, getElement().getDustTransition());
        return true;
    }
}
