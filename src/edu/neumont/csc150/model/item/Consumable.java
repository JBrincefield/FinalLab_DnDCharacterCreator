package edu.neumont.csc150.model.item;

import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.item.Item;

public class Consumable extends Item {

    private int hpGain, mpGain;
        public Consumable(ItemName name) {
            super(name);
            setHpGain(name.getHpGain());
            setMpGain(name.getMpGain());
        }
    //region Getter/Setters
    public int getHpGain() {
        return hpGain;
    }

    private void setHpGain(int hpGain) {
        this.hpGain = hpGain;
    }

    public int getMpGain() {
        return mpGain;
    }

    private void setMpGain(int mpGain) {
        this.mpGain = mpGain;
    }
    //endregion
    @Override
    public String toString() {
        return getRarity() +":"+ getName() + ": " + """
                \nHp+:"""+ getHpGain() + """
                \nMp+:""" + getMpGain() + """
                \nItem Description:""" + getDescription();
    }
}
