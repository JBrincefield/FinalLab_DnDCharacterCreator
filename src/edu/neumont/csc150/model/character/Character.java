package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.item.Item;
import edu.neumont.csc150.model.skills.Magical;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:39 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public abstract class Character {
    protected static Die die = new Die();
    private String name;
    private int maxHealth;
    private Race race;
    private int armourClass;
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;
    private int maxMP;
    private int currentMP;
    private int exp = 0;
    private int lvl = 1;
    private List<Item> backPack = new ArrayList<>();
    private List<Magical> spells = new ArrayList<>();

    // I think that stats should be set in the individual classes, which means health will need to be as well. and AC
    public Character(String name, Race race,List<Item> backPack){
        setName(name);
        setRace(race);
        setBackPack(backPack);
    }

    public Character(String name, Race race,List<Item> backPack, int maxMP){
        setName(name);
        setRace(race);
        setBackPack(backPack);
        setMaxMP(maxMP);
        setCurrentMP(maxMP);
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

    public int getMaxMP() {
        return maxMP;
    }

    private void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    private void setCurrentMP(int currentMP) {
        this.currentMP = currentMP;
    }

    public List<Item> getBackPack() {
        return backPack;
    }

    private void setBackPack(List<Item> backPack) {
        backPack = backPack;
    }

    public int getExp() {
        return exp;
    }

    private void setExp(int exp) {
        int tempExp = this.exp + exp;
        if (tempExp >= 100){
            setLvl(getLvl() + 1);
            this.exp = tempExp - 100;
        }else {
            this.exp = tempExp;
        }
    }

    public int getLvl() {
        return lvl;
    }

    private void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public List<Magical> getSpells() {
        return spells;
    }

    private void setSpells(List<Magical> spells) {
        this.spells = spells;
    }

    //endregion

    @Override
    public String toString() {
        return "This Character's name is " + getName() +
                " they are a " + getRace().getFriendlyName() + " their max HP is " + getMaxHealth();
    }
}
