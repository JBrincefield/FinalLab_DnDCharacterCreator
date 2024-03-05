package edu.neumont.csc150.model.item;

/**
 * @author jbrincefield
 * @createdOn 3/3/2024 at 2:06 PM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public enum ItemName {
    //region Consumables
    ROPE("common","Rope","",1,1,1,1,1,0,0),
    WATER_SKIN("common","Water Skin","",1,1,1,1,1,5,5),
    RATION("common","Ration","",1,1,1,1,1,0,5),

    //region Equipment
    CHEST_PLATE("Uncommon","Chest-plate","",10,0,0,0,10,0,0),
    Knights_Helmet("Uncommon","Knights Helmet","Still reeks of the previous owner.",1,1,1,1,1,1,1),
    WIZARDS_ROBE("Uncommon","Ration","",0,15,0,0,1,1,1),
    WIZARDS_HAT("Uncommon","Ration","",5,10,0,0,5,1,1),
    POT_OF_GREED("Mythical","Pot of Greed","AND FOR MY NEXT MOVE I SUMMON POT OF GREED!!!",1000,1000,0,0,0,0,0),
    GODS_JESTER("Mythical","GOD'S Jesters hat","Worn by the greatest fool of them all. You feel a sinister presence emanate from this hat.",2000,2000,2000,2000,100,1,1),
    HAT("Common","Mess Kit","",1,1,1,1,1,1,1),
    STAFF("Common","Staff","",1,1,1,1,1,1,1),
    TORCH("Common","Torch","The torch fills you with hope to see the flame in the darkness",1,1,1,1,1,1,1),
    WAR_TORCH("Uncommon","Ration","",1,1,1,1,1,1,1),
    DAGGER("Common","DAGGER","",1,1,1,1,1,1,1),
    Blood_DAGGER("Uncommon","Blood DAGGER","",1,1,15,1,1,1,1),
    TIAMAT("Legendary","Tiamat","A Legendary weapon forged from Tiamat feels as though it is still alive within the blade.",15,15,80,0,10,1,1),
    BOW("Common","Bow","A simple wooden bow appears to be wornout.",1,1,1,1,1,1,1),
    War_Bow("Uncommon","War_Bow","A Large Bow used during war time it is incredibly hard to use.",1,1,10,0,2,0,1),
    ARTEMIS_BOW("Legendary","Artemis Bow","A Bow blessed by the gods it feels as though they watch over you as you use it.",25,15,60,40,25,0,0),
    LEGENDARY_STAFF("Legendary","Legendary Staff","Though it looks like a weird stick you can feel a strong magical presence from it.",15,30,0,60,0,0,0),
    GLOCK("Legendary","Glock with a Switch","You can hear a bald eagle in the distance you start to feel Patriotic.",0,0,100,0,0,0,0),
    DURANDAL("Legendary","Durandal","A legendary sword once held by Sir Roland of Charlemagne.",20,25,54,50,15,0,0),
    CLAYMORE("Uncommon","Claymore","A long blade sure to strike fear into the heart of the enemy.",0,0,15, 0,10,0,0),
    DEATHS_SCYTHE("Mythical","Deaths Scythe","The Scythes Blade shows the reflection of the souls its claimed. This Weapon has claimed the lives of the innocent and Guilty.",2000,2000,2000, 2000,10,0,0),
    GODS_HAND("Mythical","Gods Hand","You feel a sense of enlightenment. A feeling beyond Living. You feel as if you were gods messenger sent to punish those who sinned.",2000,2000,2000, 2000,10,0,0),
    JESTERS_WATER_BOTTLE("Common","Simple Bottle","My Main Goal is to blow up and act like i dont know nobody argh! argh! ar! argh!",1,1,1,1,1,1,1),
    SWORD("Common","Sword","A old worn out blade feels as though its seen better days.",4,0,6,0,5,0,0);

    //endregion

    String itemName = "";
    String description = "";
    String rarity;
    int hpGain, mpGain, attk, mgAttk, def, hp, mp;
    ItemName(String rarity, String itemName, String description, int hp, int mp, int attk,int mgAttk, int def, int mpGain, int hpGain){
        setRarity(rarity);
        setItemName(itemName);
        setDescription(description);
        setHp(hp);
        setMp(mp);
        setAttk(attk);
        setDef(def);
        setMpGain(mpGain);
        setHpGain(hpGain);
        setMgAttk(mgAttk);
    }
    //region GETTERS/SETTERS

    public String getRarity() {
        return rarity;
    }

    private void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getMagicAttack() {
        return mgAttk;
    }
    public void setMgAttk(int mgAttk) {
        this.mgAttk = mgAttk;
    }

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
