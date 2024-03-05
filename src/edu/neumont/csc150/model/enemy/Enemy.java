package edu.neumont.csc150.model.enemy;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.item.Item;
import edu.neumont.csc150.model.item.ItemName;

import java.util.ArrayList;


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
    private int defence;
    private int attackMod;
    private int dmgMod;

    public Enemy(enemyList enemy){
        setName(enemy.getEnemyName());
        setMaxHP(enemy.getMaxHP());
        setCurrentHP(enemy.getMaxHP());
        setAC(enemy.getAC());
        setAttackMod(enemy.getAttackMod());
        setDmgMod(enemy.getDmgMod());
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

    public int getAttackMod() {
        return attackMod;
    }

    protected void setAttackMod(int attackMod) {
        this.attackMod = attackMod;
    }

    public int getDmgMod() {
        return dmgMod;
    }

    protected void setDmgMod(int dmgMod) {
        this.dmgMod = dmgMod;
    }
    //endregion

    private int getAction(){
        return Die.roll(1, 4);
    }

    private int attack(Character player){
        int damage = 0;
        int action = getAction();
        int attackRoll = Die.roll(1, 20);
        boolean critical = false;

        if (attackRoll == 20){
            critical = true;
        }

        switch (action){
            case 1:
                attackRoll += 3;

                if (attackRoll + getAttackMod() > player.getArmorClass())
                    damage += Die.roll(4, 3) + getDmgMod();

                if (critical)
                damage *= 2;
                break;
            case 2:
                if (attackRoll + attackMod > player.getArmorClass())
                    damage += Die.roll(2, 8) + getDmgMod();


                break;
            case 3:
                attackRoll -= 3;

                if (attackRoll + getAttackMod() > player.getArmorClass())
                    damage += Die.roll(2, 10) + getDmgMod();

                if (critical)
                    damage *= 2;
                break;
            case 4:
                attackRoll -= 12;

                if (attackRoll + getAttackMod() > player.getArmorClass())
                    damage += Die.roll(2, 20) + getDmgMod();

                if (critical)
                    damage *= 2;
                break;
            default:
                throw new IllegalStateException("What the fuck?, how did we get here");
        }

        if (damage < player.getDefence()){
            damage = 0;
        }else {
            damage = damage - player.getDefence();
        }


        return damage;
    }

}
