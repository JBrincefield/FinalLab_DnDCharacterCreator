package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
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
public class Fighter extends Character {


    public Fighter(String name, Race race, List<Item> backPack){
        super(name, race, backPack);
        setStats();
        setMaxHealth(10 + getConMod());
        setArmourClass(calculateAC());
    }

    public int getDmgMod(){
        return getStrengthMod() + getLvl();
    }

    public int magicAttack(Enemy enemy, int attackRoll, Magical attack){
        int damage = 0;

        if (attackRoll > enemy.getAC()){
            damage += Die.roll(attack.getRollCount(), attack.getDice());
        }

        return damage;
    }

    public int physicalAttack(Enemy enemy, int attackRoll, Physical attack){
        int damage = 0;

        if (attackRoll + getStrengthMod() > enemy.getAC()){
            damage += Die.roll(attack.getRollCount(), attack.getDice());

            damage += getDmgMod();
        }

        return damage;
    }

}
