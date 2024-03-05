package edu.neumont.csc150.model.skills;

public enum SkillList {
    //Rogue Skills
    POISON_STAB("Poison Stab", "You stab the opponent with your blade covered in poison.", 20,  3, 6),
    BACK_STAB("Back stab", "You stab the opponent in the back.", 10, 1,  8),
    TRICK_STAB("Trick stab", "You do a 360 and flip at your opponent its the sickest thing they've seen in their life. till you stab them.",  30, 2, 10),
    SNEAK_ATTACK("Sneak Attack", "you sneak up on the opponent to stab them in the back.",  15, 2, 8),
    DOUBLE_STAB("Double Stab", "You quickly stab twice at the opponent.", 10, 2,  6),
    LUCKY_STRIKE("Lucky Strike", "You stab the opponent with a high chance to crit(Deal more dmg).",  35, 3, 1),
    MAGE_HAND("Mage Hand", "you extend across the battlefield to slap the opponent.",40, 3, 10),
    //Wizard Skills
    MAGIC_BULLET("Magic Bullet", "You cast a magic bolt at the opponent", 15,  1, 8),
    FIREBALL("Fire Ball", "You send forth a massive ball of fire at the opponent.",  60, 8, 6),
    LIGHTNING_BOLT("Lightning Bolt", "You fling a bolt of lightning at the opponent.",  30, 3, 6),
    IMPLODE("Implode", "You cause a small explosion within the opponent.", 100,  6, 8),
    FIRE_BOLT("Fire Bolt", "You fling a tiny flame at the opponent.", 30, 4, 6),
    LIGHTNING_STRIKE("Lightning Strike", "You summon lightning down onto the opponent.",  40, 3, 8),
    FROST_BOLT("Frost Bolt", "You cast a icicle at the opponent.",  15, 2, 6),
    DARK_SUN("Dark Star", "You Plunge the area into darkness for a few minutes leaving nothing of your opponent behind.",  500, 10, 10),
    //Warrior Skills

    CLEAVE("Cleave", "You slash aggressively at the opponent", 10, 2, 6),
    OVER_HEAD_SLASH("Over Head Slash", "You slash down upon the opponents heads",  20, 2, 8),
    POUND("Pound", "You thrust your fist at the opponent.",  5, 1, 6),
    STAB("Stab", "You stab your weapon at the opponent",  15, 3, 6),
    BOOMERANG_THROW("Boomerang Throw", "You throw your weapon at the Opponent Retrieving it as it comes back from hitting them.",  30, 3, 8),
    LIGHTNING_SLASH("Lightning Slash", "You swing at the enemy with a blade covered in Lightning",  40, 4, 10),
    FLAME_SLASH("Flame Slash", "You swing at the enemy with a blade covered in fire", 45, 8, 8),
    MAGIC_SLASH("Magic Slash", "You swing at the enemy with a blade covered in mana", 50, 10, 5),
    //Ranger Skills
    SHOOT("Shoot", "You fire a arrow at the enemy.", 5, 1,  8),
    TRIPLE_SHOT("Triple Shot", "You shoot three arrows in succession.", 15, 3,  8),
    FIRE_ARROW("Fire Arrow", "You shoot an arrow lit with fire at the opponent.", 30,  6, 8),
    POISON_ARROW("Poison Arrow", "You shoot an arrow doused in poison at the enemy.", 60,  12, 8),
    EXPLOSIVE_ARROW("Explosive Arrow", "You shoot an arrow tipped with a explosive at the enemy.",  120, 24, 8)
    ;

    String skillName = "";
    String description = "";
    int mpCost, rollCount, dice;
    SkillList(String skillName, String description, int mpCost, int rollCount , int dice){
        setSkillName(skillName);
        setDescription(description);
        setMpCost(mpCost);
        setRollCount(rollCount);
        setDice(dice);

    }
    //region GETTERS/SETTTERS
    public String getSkillName() {
        return skillName;
    }

    private void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public int getMpCost() {
        return mpCost;
    }

    private void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    public int getRollCount() {
        return rollCount;
    }

    private void setRollCount(int rollCount) {
        this.rollCount = rollCount;
    }

    public int getDice() {
        return dice;
    }

    private void setDice(int dice) {
        this.dice = dice;
    }

    @Override
    public String toString(){
        return getSkillName();
    }

    //endregion
}
