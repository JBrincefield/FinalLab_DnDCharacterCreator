package edu.neumont.csc150.model.item;

/**
 * @author jbrincefield
 * @createdOn 3/3/2024 at 2:06 PM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public enum ItemName {
    SWORD("Sword","",1,1,1,1,1,1),
    ROPE("Rope","",1,1,1,1,1,1),
    BEDROLL("Bedroll","",1,1,1,1,1,1),
    MESS_KIT("Mess Kit","",1,1,1,1,1,1),
    TINDER_BOX("Tinder Box","",1,1,1,1,1,1),
    TORCH("Torch","",1,1,1,1,1,1),
    RATION("Ration","",1,1,1,1,1,1),
    WATER_SKIN("Water Skin","",1,1,1,1,1,1);

    String itemName = "";
    String description = "";
    int hpGain, mpGain, attk, def, hp, mp;
    ItemName(String itemName, String description, int hp, int mp, int attk, int def, int mpGain, int hpGain){
        setItemName(itemName);
        setDescription(description);
        setHp(hp);
        setMp(mp);
        setAttk(attk);
        setDef(def);
        setMpGain(mpGain);
        setHpGain(hpGain);
    }
    //region GETTERS/SETTERS
    public String getItemName() {
        return itemName;
    }
    private void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getDescription() {
        return description;
    }
    private void setDescription(String description) {
        this.description = description;
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
    public int getAttk() {
        return attk;
    }
    private void setAttk(int attk) {
        this.attk = attk;
    }
    public int getDef() {
        return def;
    }
    private void setDef(int def) {
        this.def = def;
    }
    public int getHp() {
        return hp;
    }
    private void setHp(int hp) {
        this.hp = hp;
    }
    public int getMp() {
        return mp;
    }
    private void setMp(int mp) {
        this.mp = mp;
    }
    //endregion
    @Override
    public String toString() {
        return getItemName();
    }
}
