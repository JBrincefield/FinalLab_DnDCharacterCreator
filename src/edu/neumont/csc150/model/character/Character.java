package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.item.*;
import edu.neumont.csc150.model.skills.*;

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
    private int maxHP;
    private int currentHP;
    private Race race;
    private int armorClass;
    private int defence;
    private int strength, dexterity, constitution, intelligence, wisdom, charisma;
    private int maxMana;
    private int currentMana;
    private int weaponAttackMod = 0;
    private int exp = 0;
    private int lvl = 1;
    private List<Item> backPack;
    private List<Skill> spells = new ArrayList<>();
    private List<Skill> activeSpells = new ArrayList<>();
    private Equipment[] activeEquipment = new Equipment[6];

    public Character(String name, Race race, int maxMana){
        setName(name);
        setRace(race);
        backPack = new ArrayList<>();
        setMaxMana(maxMana);
        setCurrentMana(maxMana);
    }
    //region getters/setter

    protected void setStats(){
        setIntelligence(Die.roll(3,6));
        setStrength(Die.roll(3,6));
        setCharisma(Die.roll(3,6));
        setWisdom(Die.roll(3,6));
        setConstitution(Die.roll(3,6));
        setDexterity(Die.roll(3,6));
    }

    protected void setStats(int amount){
        setIntelligence(getIntelligence() + amount);
        setStrength(getStrength() + amount);
        setCharisma(getCharisma() + amount);
        setWisdom(getWisdom() + amount);
        setConstitution(getCharisma() + amount);
        setDexterity(getDexterity() + amount);
    }
    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    protected void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    protected void setCurrentHP(int currentHP) {
        if (currentHP >=  0)
            this.currentHP = currentHP;
        else if (currentHP > getMaxHP())
            this.currentHP = getMaxHP();
        else
            this.currentHP = 0;
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

    public int getArmorClass() {
        return armorClass;
    }

    protected void setArmorClass(int armorClass) {
        if (getArmorClass() <= 15)
        this.armorClass = armorClass;
    }

    public int getDefence() {
        return defence;
    }

    protected void setDefence(int defence) {
        this.defence = defence;
    }

    protected  void addDefence(int addAmount){
        setDefence(getDefence() + addAmount);
    }

    protected void removeDefence(int removeAmount){
        setDefence(getDefence() - removeAmount);
    }

    public int getMaxMana() {
        return maxMana;
    }

    protected void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getCurrentMana() {
        return currentMana;
    }

    protected void setCurrentMana(int currentMana) {
        if (currentMana > 0)
            this.currentMana = currentMana;
        else
            this.currentMana = 0;
    }

    public List<Item> getBackPack() {
        return backPack;
    }

    public int getExp() {
        return exp;
    }

    protected void setExp(int exp) {
        int tempExp = this.exp + exp;
        if (tempExp >= 100){
            levelUp();
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

    public List<Skill> getSpells() {
        return spells;
    }

    protected void setClassSpells(List<Skill> spells) {
        this.spells = spells;
    }

    public List<Skill> getActiveSpells() {
        return activeSpells;
    }

    protected void addActiveSpells(Skill activeSpells) {
        this.activeSpells.add(activeSpells);
    }

    public int getWeaponAttackMod() {
        return weaponAttackMod;
    }

    protected void setWeaponAttackMod(int weaponAttackMod) {
        this.weaponAttackMod = weaponAttackMod;
    }

    //endregion

    protected void useMana(int manaUsed){
        setCurrentMana(getCurrentMana() - manaUsed);
    }

    protected void levelUp(){
        setLvl(getLvl() + 1);
        if (getLvl() < getSpells().size()){
            addActiveSpells(getSpells().get(getLvl()));
        }
        setStats(1);
        setArmorClass(calculateAC());
        setMaxHP(getMaxHP() + Die.roll(2, 8));
        setCurrentHP(getMaxHP());
        setMaxMana(getMaxMana() + (Die.roll(5) * 10));
        setCurrentMana(getMaxMana());
    }

    protected boolean dealDamage(int damage){
        int newHealth = getCurrentHP() - damage;
        if (newHealth > 0 ){
            setCurrentHP(newHealth);
            return false;
        }else {
            setCurrentHP(0);
            return true;
        }
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
    protected void addEquipment(Equipment equipment){
        if (activeEquipment.length >= 6){
            throw new IllegalArgumentException("You Stupid Bitch. already have 5 equipment");
        }else{
            int i = 0;
            for (Equipment currentEquipment : activeEquipment) {
                if (currentEquipment == null){
                    activeEquipment[i] = equipment;
                    setDefence(getDefence() - currentEquipment.getDef());
                    setMaxHP(getMaxHP() - currentEquipment.getHp());
                    setMaxMana(getMaxMana() - currentEquipment.getMp());
                    setWeaponAttackMod(getWeaponAttackMod() + currentEquipment.getAttk());
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
        for (Equipment currentEquipment : activeEquipment) {
            if (currentEquipment == equipment){
                activeEquipment[i] = null;
                setDefence(getDefence() - currentEquipment.getDef());
                setMaxHP(getMaxHP() - currentEquipment.getHp());
                setMaxMana(getMaxMana() - currentEquipment.getMp());
                setWeaponAttackMod(getWeaponAttackMod() - currentEquipment.getAttk());
                backPack.add(currentEquipment);
            }

            i++;
        }
    }
    public void useItem(Consumable item){
        setCurrentHP(getCurrentHP() + item.getHpGain());
        setCurrentMana(getCurrentMana() + item.getMpGain());
        backPack.remove(item);
    }
    public void discardItem(Item item){
        backPack.remove(item);
    }
    public void addItem(Item item){
        backPack.add(item);
    }
    @Override
    public String toString() {
        return "This Character's name is " + getName() +
                " they are a " + getRace().getFriendlyName() + " their max HP is " + getMaxHP();
    }
}
