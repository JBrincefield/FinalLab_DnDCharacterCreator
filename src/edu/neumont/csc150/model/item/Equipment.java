package edu.neumont.csc150.model.item;

public class Equipment extends Item {
    private int def, attk, mp, hp;
    private boolean active;

    public Equipment(ItemName name) {
        super(name);
        setAttk(name.getAttk());
        setDef(name.getDef());
        setHp(name.getHp());
        setMp(name.getMp());
    }
    //region Getter/Setters
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
    //endregion
    public int[] equip(){
        if (isActive()){
            throw new IllegalArgumentException("Cannot Equip the same armour");
        }
        setActive(true);
        int [] stats = new int[] {getAttk(), getDef(), getHp(),getMp()};
        return stats;
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
