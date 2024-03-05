package edu.neumont.csc150.model.skills;

public enum SkillList {
    //Rouge Skills
    Sneak("Sword", "", 1, 1, 1, 1, false, 1),
    POISONSTAB("Poison Stab", "", 1, 1, 1, 1, false, 1),
    BACKSTAB("Rope", "", 1, 1, 1, 1, false, 1),
    TRICKSTAB("Bedroll", "", 1, 1, 1, 1, false, 1),
    SNEAKATTACK("Mess Kit", "", 1, 1, 1, 1, false, 1),
    DOUBLESTAB("Double Stab", "", 1, 1, 1, 1, false, 1),
    LUCKYSTRIKE("Lucky Strike", "", 1, 1, 1, 1, false, 1),
    MAGEHAND("Mage Hand", "", 1, 1, 1, 1, false, 1),


    //Wizard Skills

    //Warrior Skills

    //Ranger
    ;

    String skillName = "";
    String description = "";
    int coolDown;
    int mpCost, rollCount, dice, value;
    boolean buff;
    SkillList(String skillName, String description, int coolDown, int mpCost, int rollCount , int dice,boolean buff, int value){
        setSkillName(skillName);
        setBuff(buff);
        setValue(int val);

    }

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

    public int getCoolDown() {
        return coolDown;
    }

    private void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
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

    public int getValue() {
        return value;
    }

    private void setValue(int value) {
        this.value = value;
    }

    public boolean isBuff() {
        return buff;
    }

    private void setBuff(boolean buff) {
        this.buff = buff;
    }
}
