package edu.neumont.csc150.model.item;

/**
 * @author jbrincefield
 * @createdOn 3/3/2024 at 2:06 PM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public enum ItemName {
    //region Consumables
    ROPE("Common","Rope","Does nothing",0,0,0,0,0,0,0),
    WATER_SKIN("Common","Water Skin","Water tasted like iron, but is still refreshing.",0,0,0,0,0,5,5),
    RATION("Common","Ration","Not much but still quenches your Hunger.",0,0,0,0,0,0,10),
    MP_POTION("Uncommon","Mana Potion","smells like a dying horse, but tastes sweet.",0,0,0,0,0,50,0),
    HP_POTION("Uncommon","Health Potion","A red liquid in a flask",0,0,0,0,0,0,50),
    DEW_OF_LIFE("Rare","Dew of Life","Fills you with the essence of life. (TASTES HORRIBLE)",0,0,0,0,0,0,1000),
    CYANIDE_PILL("Uncommon","Ration","The cowards way out.",0,0,0,0,0,0,-1000000),
    //endregion
    //region Equipment
    SHOES("Common","Shoes","They appear to be the wrong size but beggars can't be choosers.",1,0,0,0,2,0,0),
    GARB("Common","Garb","A worn out garb smells horrid.",0,0,0,0,5,0,0),
    CHEST_PLATE("Uncommon","Chest-plate","an old chest plate smells of sweat and blood.",10,0,0,0,10,0,0),
    Knights_Helmet("Uncommon","Knights Helmet","Still reeks of the previous owner.",15,5,0,0,15,0,0),
    ROYAL_KNIGHT_ARMOUR("Rare","Royal Knights Armour","Royal knights armour you can still feel the honourable presence of the previous owner.",15,5,0,0,15,0,0),
    ROYAL_KNIGHT_HELM("Rare","Royal Knights Helm","Royal Knights Helm it bears the Crest of a Fallen Kingdom.",25,10,0,0,25,1,1),
    DRAGONS_ARMOR("Legendary","Dragonic Armour","Armour Made from the remains of a dragon.",50,50,0,0,50,0,0),
    DRAGONS_HELM("Legendary","Dragon's Helm","Helmet made from the horns of a dragon.",50,50,0,0,50,0,0),
    WIZARDS_ROBE("Uncommon","Wizard's Robe","A worn out wizards robe you can feel a faint magical presence from it.",0,15,0,0,1,1,1),
    WIZARDS_HAT("Uncommon","Wizard's Hat","A worn out wizards hat remnants of an insignia can be found on it.",5,10,0,0,5,1,1),
    SAGES_HAT("Rare","Sage's Hat","A Sages Hat you can see the Insignia from before it is appears to be a Griffin",10,25,1,1,1,1,1),
    SAGES_ROBE("Rare","Sage's Robe","an Old Sages Robe you feel a magic Aura from it.",10,25,0,25,10,0,0),
    PHOENIX_HAT("Legendary","Phoenix hat","Made from the dawn of a Phoenix.",25,70,0,70,30,1,1),
    PHOENIX_ROBE("Legendary","Phoenix Robe","Great Warmth Emanates from the Robe filling you with a desire to push on.",30,100,20,70,30,0,0),
    POT_OF_GREED("Mythical","Pot of Greed","AND FOR MY NEXT MOVE I SUMMON POT OF GREED!!!",1000,1000,0,0,0,0,0),
    GODS_JESTER("Mythical","GOD'S Jesters hat","Worn by the greatest fool of them all. You feel a sinister presence emanate from this hat.",2000,2000,2000,2000,100,0,0),
    HAT("Common","Mess Kit","a worn out Hat",2,2,0,0,4,0,0),
    HOOD("Uncommon","Hood","a Hood riddled with holes.",5,0,10,1,10,1,1),
    CLOAK("Uncommon","Cloak","a Cloak with a rusty medal on it.",5,5,10,0,10,1,1),
    DARK_CLOAK("Rare","Dark Cloak","Black Cloak worn by elite Assassins",10,5,10,0,10,1,1),
    DARK_HOOD("Rare","Dark Hood","Black hood worn by elite Assassins",10,10,20,1,15,1,1),
    CLOAK_OF_SHADOWS("Legendary","Cloak of Shadows","The Cloak seems to feel as though it is sucking you in slowly.",35,35,70,40,25,1,1),
    HOOD_OF_SHADOWS("Legendary","Hood of Shadows","Your face becomes enshrouded by darkness when you dawn this hood.",25,25,70,30,25,0,0),
    STAFF("Common","Staff","",0,5,1,5,1,0,0),
    WIZARDS_GRIMOIRE("Uncommon","Wizard's Grimoire","A old book that appears to be age",0,10,0,15,1,0,0),
    SAGES_ORB("Rare","Sage's Orb","A mysterious orb it appears to show a image when pondered",1,30,1,30,0,0,0),
    TORCH("Common","Torch","The torch fills you with hope to see the flame in the darkness",1,1,1,1,1,0,0),
    WAR_TORCH("Uncommon","Ration","",0,0,10,5,0,0,0),
    DAGGER("Common","DAGGER","",1,1,5,0,0,0,0),
    BLOODY_DAGGER("Uncommon","Bloody DAGGER","A Dagger Stained by Blood(has a ",5,5,15,0,0,0,0),
    RAVENS_KNIFE("Common","Ravens Knife","A thin black blade it reeks of blood.",10,10,30,0,0,1,1),
    TIAMAT("Legendary","Tiamat","A Legendary weapon forged from Tiamat feels as though it is still alive within the blade.",15,15,80,0,10,0,0),
    BOW("Common","Bow","A simple wooden bow appears to be wornout.",2,4,6,1,1,0,0),
    War_Bow("Uncommon","War_Bow","A Large Bow used during war time it is incredibly hard to use.",1,1,10,0,2,0,0),
    ELVES_BOW("Rare","Elvish Bow","Bow used by Elf nobles it has strange runes on it.",0,10,20,15,1,1,1),
    ARTEMIS_BOW("Legendary","Artemis Bow","A Bow blessed by the gods it feels as though they watch over you as you use it.",25,15,60,40,25,0,0),
    LEGENDARY_STAFF("Legendary","Legendary Staff","Though it looks like a weird stick you can feel a strong magical presence from it.",15,30,0,60,0,0,0),
    GLOCK("Legendary","Glock with a Switch","You can hear a bald eagle in the distance you start to feel Patriotic.",0,0,100,0,0,0,0),
    DURANDAL("Legendary","Durandal","A legendary sword once held by Sir Roland of Charlemagne.",20,25,54,50,15,0,0),
    CLAYMORE("Uncommon","Claymore","A long blade sure to strike fear into the heart of the enemy.",0,0,15, 0,10,0,0),
    ROYAL_KNIGHTS_SWORD("Rare","Royal Knights Sword","Once used for by a Noble Knight now it rests in your hands.",0,5,25,10,15,0,0),
    DEATHS_SCYTHE("Mythical","Deaths Scythe","The Scythes Blade shows the reflection of the souls its claimed. This Weapon has claimed the lives of the innocent and Guilty.",2000,2000,2000, 2000,10,0,0),
    GODS_HAND("Mythical","Gods Hand","You feel a sense of enlightenment. A feeling beyond Living. You feel as if you were gods messenger sent to punish those who sinned.",2000,2000,2000, 2000,10,0,0),
    JESTERS_WATER_BOTTLE("Mythical","Simple Bottle","My Main Goal is to blow up and act like i dont know nobody argh! argh! ar! argh!",2000,2000,2000,2000,10,0,0),
    CHEDDAR_CHEESE_RING("Mythical", "Cheese", " Never trust a rat with cheese they will always betray you - Food for thought - Quote by a Nicaraguan",2000,2000,0,2000,2000,0,0),
    GRASS_BLOCK("Mythical", "Grass", "That's a yikes buddy, this shit is useless! touch grass",0,0,0,0,0,0,0),
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
