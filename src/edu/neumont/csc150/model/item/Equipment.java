package edu.neumont.csc150.model.item;

public class Equipment extends Item {
    private int def, attk, mp, hp;
    private boolean active, magicResist;

    public Equipment(ItemName name, String description,int attk, int def,int hp, int mp, boolean magicResist) {
        super(name, description);
        setAttk(attk);
        setDef(def);
        setHp(hp);
        setMp(mp);
        setMagicResist(magicResist);
        setActive(false);
    }
    //region Getter/Setters

    public boolean isMagicResist() {
        return magicResist;
    }

    private void setMagicResist(boolean magicResist) {
        this.magicResist = magicResist;
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
    //endregion
    private String getEffect(){
        if (isMagicResist()){
            return "\nEffect:" + "MagicResistant";
        }
        return "";
    }
    public  equip(Character player){
        setActive(true);
        return
    }
    @Override
    public String toString() {

        return getName() + ": " + """
                Attack:"""+ getAttk() + """
                Def:""" + getDef() + """
                Hp:""" + getHp() + """
                Mp:""" + getMp() +
                getEffect() + """
                Item Description:""" + getDescription();
    }
}
