package edu.neumont.csc150.model.enemy;

/**
 * @author jbrincefield
 * @createdOn 3/4/2024 at 10:37 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model.enemy;
 */
public class Enemy {
    private String name;
    private int MaxHP;
    private int currentHP;
    private int attackDiceAmount;
    private int attackDiceSides;
    private int dmgDiceAmount;
    private int dmgDiceSides;


    //region getters/setters

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public int getMaxHP() {
        return MaxHP;
    }

    protected void setMaxHP(int maxHP) {
        MaxHP = maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    protected void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getAttackDiceAmount() {
        return attackDiceAmount;
    }

    protected void setAttackDiceAmount(int attackDiceAmount) {
        this.attackDiceAmount = attackDiceAmount;
    }

    public int getAttackDiceSides() {
        return attackDiceSides;
    }

    protected void setAttackDiceSides(int attackDiceSides) {
        this.attackDiceSides = attackDiceSides;
    }

    public int getDmgDiceAmount() {
        return dmgDiceAmount;
    }

    protected void setDmgDiceAmount(int dmgDiceAmount) {
        this.dmgDiceAmount = dmgDiceAmount;
    }

    public int getDmgDiceSides() {
        return dmgDiceSides;
    }

    protected void setDmgDiceSides(int dmgDiceSides) {
        this.dmgDiceSides = dmgDiceSides;
    }


    //endregion

}
