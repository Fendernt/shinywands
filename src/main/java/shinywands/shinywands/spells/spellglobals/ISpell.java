package shinywands.shinywands.spells.spellglobals;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import shinywands.shinywands.managers.ServerCommunicator;

import java.util.List;

import static shinywands.shinywands.Shinywands.PLUGIN;

public abstract class ISpell {

    private int cooldownTimer = 0;

    public abstract String Name();

    public String getName(){
        return getElement().getColor() + Name();
    }

    public abstract int getCooldown();

    public abstract ElementType getElement();

    public abstract List<Action> getAction();

    public Void onPlayerDeath(PlayerDeathEvent event){
        return null;
    }

    public Void onGamemodeChange(PlayerGameModeChangeEvent event){
        return null;
    }

    public Void onPlayerJoin(PlayerJoinEvent event){
        return null;
    }

    public void executeSpell(PlayerInteractEvent event){
        if(cooldownTimer <= 0 || event.getPlayer().getGameMode() == GameMode.CREATIVE){
            if(executeSpellBehavior(event)) {
                enableCooldown(event.getPlayer());
            }
        } else {
            ServerCommunicator.sendChatMessageToPlayer(event.getPlayer(), getName()+ ChatColor.GRAY+" is on cooldown. Try again in: "+getElement().getColor()+cooldownTimer+ChatColor.GRAY+" seconds.");
        }
    }

    protected abstract boolean executeSpellBehavior(PlayerInteractEvent event);

    private void enableCooldown(Player player){
        if(player.getGameMode() != GameMode.CREATIVE) {
            cooldownTimer = getCooldown();
            Bukkit.getScheduler().scheduleSyncDelayedTask(PLUGIN, this::lowerCooldown, 20L);
        } else {
            cooldownTimer = 0;
        }
    }

    private void lowerCooldown(){
        if(cooldownTimer > 0){
            Bukkit.getScheduler().scheduleSyncDelayedTask(PLUGIN, this::lowerCooldown, 20L);
            cooldownTimer-=1;
        }
    }
}
