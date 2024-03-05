package edu.neumont.csc150.model.enemy;

/**
 * @author jbrincefield
 * @createdOn 3/4/2024 at 10:37 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model.enemy;
 */
public class Enemy {
    private String name;
    private int maxHP;
    private int currentHP;
    private int AC;
    private int attackDiceAmount;
    private int attackDiceSides;
    private int dmgDiceAmount;
    private int dmgDiceSides;

    public Enemy(String name, int maxHP, int AC, int attackDiceAmount, int attackDiceSides, int dmgDiceAmount, int dmgDiceSides){
        setName(name);
        setMaxHP(maxHP);
        setCurrentHP(maxHP);
        setAC(AC);
        setAttackDiceAmount(attackDiceAmount);
        setAttackDiceSides(attackDiceSides);
        setDmgDiceAmount(dmgDiceAmount);
        setAttackDiceSides(dmgDiceSides);
    }


    //region getters/setters

    public String getName() {
        return name;
    }

    protected void setName(String name) {
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
        if (currentHP < 0)
            this.currentHP = 0;
        else
            this.currentHP = currentHP;
    }

    //boolean is to tell whatever calls this method whether the player has died
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

    public int getAC() {
        return AC;
    }

    protected void setAC(int AC) {
        this.AC = AC;
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
