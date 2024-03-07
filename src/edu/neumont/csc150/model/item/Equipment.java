package edu.neumont.csc150.model.item;

public class Equipment extends Item {
    private int def, attk, mgAttk , mp, hp;
    private String rarity;
    private boolean active;

    public Equipment(ItemName name) {
        super(name);
        setRarity(name.getRarity());
        setAttk(name.getAttk());
        setDef(name.getDef());
        setHp(name.getHp());
        setMp(name.getMp());
        setMgAttk(name.getMagicAttack());
    }
    //region Getter/Setters

    public String getRarity() {
        return rarity;
    }

    private void setRarity(String rarity) {
        this.rarity = rarity;
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

    public int getMgAttk() {
        return mgAttk;
    }

    private void setMgAttk(int mgAttk) {
        this.mgAttk = mgAttk;
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
        return getRarity() +":" + getName() + ": " + """
                \nAttack:"""+ getAttk() + """
                \nMagick Attack:""" + getMgAttk() + """
                \nDef:""" + getDef() + """
                \nHp:""" + getHp() + """
                \nMp:""" + getMp() + """
                \nItem Description:""" + getDescription();
    }
}
