package shinywands.shinywands.managers;

import org.bukkit.entity.Player;
import shinywands.shinywands.spells.*;
import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.*;

public class SpellManager {

    private static final Map<UUID, SpellContainer> _spells = new HashMap<>();

    public ArrayList<ISpell> getSpells(){
        ArrayList<ISpell> spells = new ArrayList<>();

        spells.add(new HealSpell());
        spells.add(new SelfExplosionSpell());
        spells.add(new ExplosionSpell());
        spells.add(new BiggerExplosionSpell());
        spells.add(new FlySpell());
        spells.add(new DragonBallSpell());
        spells.add(new SmallFireballSpell());
        spells.add(new LaunchSpell());
        spells.add(new LeapSpell());

        return spells;
    }

    public List<ISpell> getPlayerSpells(Player player){
        addUserToList(player);
        return _spells.get(player.getUniqueId()).getSpells();
    }

    public void addUserToList(Player player){
        _spells.putIfAbsent(player.getUniqueId(), new SpellContainer(getSpells()));
    }

    public ISpell getActiveSpell(Player player){
        addUserToList(player);
        return _spells.get(player.getUniqueId()).getActiveSpell();
    }

    public void nextSpell(Player player){
        addUserToList(player);
        ISpell spell = _spells.get(player.getUniqueId()).nextSpell();
        ServerCommunicator.sendChatMessageToPlayer(player, "Spell set to: "+spell.getName());
    }

    public void previousSpell(Player player){
        addUserToList(player);
        ISpell spell = _spells.get(player.getUniqueId()).previousSpell();
        ServerCommunicator.sendChatMessageToPlayer(player, "Spell set to: "+spell.getName());
    }
}
