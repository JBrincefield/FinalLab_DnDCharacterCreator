package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.enemy.Enemy;
import edu.neumont.csc150.model.item.Item;
import edu.neumont.csc150.model.skills.Magical;
import edu.neumont.csc150.model.skills.Physical;

import java.util.List;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:40 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Ranger extends Character {
    private final static int MIN_MP_MAX = 100;

    public Ranger(String name, Race race, List<Item> backPack){
        super(name, race, backPack, MIN_MP_MAX);
        setStats();
        setMaxHealth(10 + getConMod());
        setArmourClass(calculateAC());
    }

    public int getAttackRollMod(){
        if (getDexMod() > getWisMod()){
            return getDexMod() + getLvl();
        }else {
            return getWisMod() + getLvl();
        }
    }

    public int magicAttack(Enemy enemy, int attackRoll, Magical attack){
        int damage = 0;

        if (attackRoll + getWisMod() + getAttackRollMod() > enemy.getAC()){
            damage += Die.roll(attack.getRollCount(), attack.getDice());
        }

        return damage;
    }

    public int physicalAttack(Enemy enemy, int attackRoll, Physical attack){
        int damage = 0;

        if (attackRoll + getDexMod() + getAttackRollMod() > enemy.getAC()){
            damage += Die.roll(attack.getRollCount(), attack.getDice());
        }

        return damage;
    }

}
