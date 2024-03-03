package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Race;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:39 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public abstract class Character {
    private String name;
    private int maxHealth;
    private Race race;
    int armourClass;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int charisma;



    // I think that stats should be set in the individual classes, which means health will need to be as well. and AC
    public void Character(String name, Race race){
        setName(name);
        setRace(race);
    }

    //region getters/setter

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    private void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Race getRace() {
        return race;
    }

    private void setRace(Race race) {
        this.race = race;
    }

    private int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    private void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getConstitution() {
        return constitution;
    }

    private void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getIntelligence() {
        return intelligence;
    }

    private void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getWisdom() {
        return wisdom;
    }

    private void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getCharisma() {
        return charisma;
    }

    private void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getArmourClass() {
        return armourClass;
    }

    private void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    //endregion

    @Override
    public String toString() {
        return "This Character's name is " + getName() +
                " they are a " + getRace().getFriendlyName() + " their max HP is " + getMaxHealth();
    }
}
