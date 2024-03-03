package edu.neumont.csc150.model.item;

import edu.neumont.csc150.model.item.Item;

public class Consumable extends Item {

    private int hpGain, mpGain;

        public Consumable(ItemName name, String description,int hpGain, int mpGain) {
            super(name, description);

        }

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

    @Override
    public String toString() {
        return getName() + ":" + getDescription();
    }
}
