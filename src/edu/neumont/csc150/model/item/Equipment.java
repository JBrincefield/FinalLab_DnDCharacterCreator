package edu.neumont.csc150.model.item;

public class Equipment extends Item {
    private int def, attk, mp, hp;
    private boolean active;

    public Equipment(ItemName name, String description,int attk, int def,int hp, int mp) {
        super(name, description);
        setAttk(attk);
        setDef(def);
        setHp(hp);
        setMp(mp);
        setActive(false);
    }

    public int getDef() {
        return def;
    }

    private void setDef(int def) {
        this.def = def;
    }

    public int getAttk() {
        return attk;
    }

    private void setAttk(int attk) {
        this.attk = attk;
    }

    public int getMp() {
        return mp;
    }

    private void setMp(int mp) {
        this.mp = mp;
    }

    public int getHp() {
        return hp;
    }

    private void setHp(int hp) {
        this.hp = hp;
    }

    public boolean isActive() {
        return active;
    }

    private void setActive(boolean active) {
        this.active = active;
    }
    @Override
    public String toString() {

        return getName() + ": " + """
                Attack:"""+ getAttk() + """
                Def:""" + getDef() + """
                Hp:""" + getHp() + """
                Mp:""" + getMp() + """
                Item Description:""" + getDescription();
    }
}
