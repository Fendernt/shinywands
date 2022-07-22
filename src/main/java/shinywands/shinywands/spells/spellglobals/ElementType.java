package shinywands.shinywands.spells.spellglobals;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Particle;

public enum ElementType {
    GLOBAL(ChatColor.GOLD, new Particle.DustTransition(Color.ORANGE, Color.YELLOW, 1.6F)),
    FIRE(ChatColor.RED, new Particle.DustTransition(Color.RED, Color.ORANGE, 1.6F)),
    AIR(ChatColor.DARK_GRAY, new Particle.DustTransition(Color.WHITE, Color.GRAY, 1.6F)),
    WATER(ChatColor.DARK_AQUA, new Particle.DustTransition(Color.BLUE, Color.AQUA, 1.6F)),
    EARTH(ChatColor.GREEN, new Particle.DustTransition(Color.GREEN, Color.LIME, 1.6F)),
    DARK(ChatColor.DARK_PURPLE, new Particle.DustTransition(Color.PURPLE, Color.FUCHSIA, 1.6F));

    private final ChatColor color;
    private final Particle.DustTransition dustTransition;
    ElementType(ChatColor color, Particle.DustTransition dustTransition){
        this.color = color;
        this.dustTransition = dustTransition;
    }

    public ChatColor getColor() {
        return color;
    }

    public Particle.DustTransition getDustTransition() {
        return dustTransition;
    }
}
