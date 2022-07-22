package shinywands.shinywands.spells;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.GameMode;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import shinywands.shinywands.managers.ServerCommunicator;
import shinywands.shinywands.spells.spellglobals.ElementType;
import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.Arrays;
import java.util.List;

import static shinywands.shinywands.Shinywands.PLUGIN;

public class FlySpell extends ISpell {
    private boolean flyingEnabled;

    @Override
    public String Name() {
        return "Fly Spell";
    }

    @Override
    public int getCooldown() {
        return 0;
    }

    @Override
    public ElementType getElement() {
        return ElementType.AIR;
    }

    @Override
    public List<Action> getAction() {
        return Arrays.asList(Action.RIGHT_CLICK_AIR, Action.RIGHT_CLICK_BLOCK);
    }

    @Override
    public boolean executeSpellBehavior(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        player.setAllowFlight(!player.getAllowFlight());
        this.flyingEnabled = player.getAllowFlight();
        ServerCommunicator.sendChatMessageToPlayer(player, "Toggled flight.");
        cloudParticles(event.getPlayer());
        return false;
    }

    private void cloudParticles(Player player){
        if(player.getGameMode() != GameMode.CREATIVE && player.isFlying()) player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation(), 20, 0.4, 0.2, 0.4, getElement().getDustTransition());
        if(flyingEnabled) Bukkit.getScheduler().scheduleSyncDelayedTask(PLUGIN, () -> cloudParticles(player), 2L);
    }

    @Override
    public Void onPlayerDeath(PlayerDeathEvent event){
        this.flyingEnabled = false;
        return null;
    }

    @Override
    public Void onGamemodeChange(PlayerGameModeChangeEvent event){
        this.flyingEnabled = false;
        return null;
    }

    @Override
    public Void onPlayerJoin(PlayerJoinEvent event){
        this.flyingEnabled = event.getPlayer().getAllowFlight();
        cloudParticles(event.getPlayer());
        return null;
    }

}
