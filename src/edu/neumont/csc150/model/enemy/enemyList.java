package edu.neumont.csc150.model.enemy;

import edu.neumont.csc150.model.item.Consumable;
import edu.neumont.csc150.model.item.Item;
import edu.neumont.csc150.model.item.ItemName;
import edu.neumont.csc150.model.skills.SkillList;

import java.util.ArrayList;

public enum enemyList {

    JESTER("Jester",200,15,50,1000,1000, 200),
    SLIME("Slime",10,10,0,2,2, 5),
    DRAGON("Dragon",100,15,15,4,40, 100),
    GOBLIN("Goblin",15,12,2,2,2, 5),
    SKELETON("Skeleton",20,10,0,5,1, 6),
    SKELETON_MAGE("Skeleton Mage",20,12,0,5,5, 10),
    HOBGOBLIN("Hobgoblin",20,13,10,2,5, 15),
    TROLL("Troll",40,13,12,3,12, 15),
    KNOLL("Knoll",25,10,5,2,4, 7),
    DWARF("Dwarf",100,10,12,1,1, 10),
    BANDIT("Bandit",50,10,12,4,3, 15),
    ORPHAN("Orphan",1,1,1,0,0, 1),
    DOG("The orphan's Dog",12,10,1,1,1, 1),
    BAT("Bat",5,10,1,1,0, 3),
    ZOMBIE("Zombie",15,11,0,2,10, 5),
    KINGSLIME("King Slime",150,15,10,1,6, 15),
    TIAMAT("TIAMAT",200,15,10,4,50, 150),
    TARRASQUE("TARRASQUE",679,15,25,1,25, 200),
    VAMPITE("Vampire",50,15,25,2,15, 20),
    WEREWOLF("Werewolf",65,15,30,0,15, 20);

    private String enemyName = "";
    private int maxHP, AC, defence, attackMod, dmgMod, exp;
    enemyList(String enemyName,int maxHP, int AC,int defence,int attackMod,int dmgMod, int exp){
        setEnemyName(enemyName);
        setAC(AC);
        setDefence(defence);
        setAttackMod(attackMod);
        setDmgMod(dmgMod);
        setMaxHP(maxHP);

    }

    //region GETTERS/SETTERS
    public String getEnemyName() {
        return enemyName;
    }

    private void setEnemyName(String enemyName) {
        this.enemyName = enemyName;
    }

    public int getMaxHP() {
        return maxHP;
    }

    private void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getAC() {
        return AC;
    }

    private void setAC(int AC) {
        this.AC = AC;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAttackMod() {
        return attackMod;
    }

    private void setAttackMod(int attackMod) {
        this.attackMod = attackMod;
    }

    public int getDmgMod() {
        return dmgMod;
    }

    private void setDmgMod(int dmgMod) {
        this.dmgMod = dmgMod;
    }

    public int getExp() {
        return exp;
    }

    private void setExp(int exp) {
        this.exp = exp;
    }

    //endregion
}