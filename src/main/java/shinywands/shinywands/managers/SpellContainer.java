package shinywands.shinywands.managers;

import shinywands.shinywands.spells.spellglobals.ISpell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpellContainer {

    private final ArrayList<ISpell> spells;
    private int index;

    public SpellContainer(ArrayList<ISpell> spells){
        this.spells = spells;
        this.index = 0;
    }

    public ISpell nextSpell(){
        if(index < spells.size()-1){
            index+=1;
        } else {
            index = 0;
        }
        return getActiveSpell();
    }

    public ISpell previousSpell(){
        if(index > 0){
            index-=1;
        } else {
            index = spells.size()-1;
        }
        return getActiveSpell();
    }

    public List<ISpell> getSpells() {
        return Collections.unmodifiableList(spells);
    }

    public ISpell getActiveSpell(){
        return spells.get(index);
    }

}
