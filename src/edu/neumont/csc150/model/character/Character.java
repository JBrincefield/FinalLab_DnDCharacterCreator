package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.item.Equipment;
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
    private String name;
    private int maxHealth;
    private int currentHealth;
    private Race race;
    private int armourClass;
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;
    private int maxMP;
    private int currentMP;
    private int exp = 0;
    private int lvl = 1;
    private List<Item> backPack = new ArrayList<>();
    private List<Magical> spells = new ArrayList<>();
    private Equipment[] activeEquipment = new Equipment[5];

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

    protected void setStats(){
        setIntelligence(Die.roll(3,6));
        setStrength(Die.roll(3,6));
        setCharisma(Die.roll(3,6));
        setWisdom(Die.roll(3,6));
        setConstitution(Die.roll(3,6));
        setDexterity(Die.roll(3,6));
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

    protected void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    protected void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
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

    protected void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrengthMod(){
        int tempStrength = getStrength() - 10;
        int mod = tempStrength / 2;
        return mod;
    }

    public int getDexterity() {
        return dexterity;
    }

    protected void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getDexMod(){
        int tempDex = getDexterity() - 10;
        int mod = tempDex / 2;
        return mod;
    }

    public int getConstitution() {
        return constitution;
    }

    protected void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getConMod(){
        int tempCon = getConstitution() - 10;
        int mod = tempCon / 2;
        return mod;
    }

    public int getIntelligence() {
        return intelligence;
    }

    protected void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
    public int getIntelligenceMod(){
        int tempIntelligence = getIntelligence() - 10;
        int mod = tempIntelligence / 2;
        return mod;
    }

    public int getWisdom() {
        return wisdom;
    }

    protected void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    public int getWisMod(){
        int tempWis = getWisdom() - 10;
        int mod = tempWis / 2;
        return mod;
    }

    public int getCharisma() {
        return charisma;
    }

    protected void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public int getCharismaMod(){
        int tempCharisma = getCharisma() - 10;
        int mod = tempCharisma / 2;
        return mod;
    }

    public int getArmourClass() {
        return armourClass;
    }

    protected int calculateAC(){
        int AC = 10 + getDexMod();

        if (activeEquipment != null){
            for (Equipment equipment1 : activeEquipment) {
                if (equipment1 != null)
                 if (equipment1.getDef() > 0){
                    AC += equipment1.getDef();
                 }
            }
        }

        return AC;
    }

    protected void setArmourClass(int armourClass) {
        this.armourClass = armourClass;
    }

    public int getMaxMP() {
        return maxMP;
    }

    protected void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getCurrentMP() {
        return currentMP;
    }

    protected void setCurrentMP(int currentMP) {
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

    protected void setExp(int exp) {
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

    protected void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public List<Magical> getSpells() {
        return spells;
    }

    protected void setSpells(List<Magical> spells) {
        this.spells = spells;
    }
    //endregion
    protected void addEquipment(Equipment equipment){
        if (activeEquipment.length >= 5){
            throw new IllegalArgumentException("You Stupid Bitch. already have 5 equipment");
        }else{
            int i = 0;
            for (Equipment currentEquipment : activeEquipment) {
                if (currentEquipment == null){
                    activeEquipment[i] = equipment;
                    backPack.remove(equipment);
                }
                i++;
            }
        }
    }

    public Equipment[] getActiveEquipment() {
        return activeEquipment;
    }

    public void removeEquipment(Equipment equipment){

        int i = 0;
        for (Equipment currentequipment : activeEquipment) {
            if (currentequipment == equipment){
                activeEquipment[i] = null;

                setArmourClass(getArmourClass() - currentequipment.getDef());
                setMaxHealth(getMaxHealth() - currentequipment.getHp());
                setMaxMP(getMaxMP() - currentequipment.getMp());

                backPack.add(currentequipment);
            }

            i++;
        }
    }

    @Override
    public String toString() {
        return "This Character's name is " + getName() +
                " they are a " + getRace().getFriendlyName() + " their max HP is " + getMaxHealth();
    }
}
