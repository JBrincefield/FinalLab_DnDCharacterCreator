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
 * @createdOn 2/29/2024 at 10:41 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Rouge extends Character {

    private final static int MIN_MP_MAX = 75;
    private boolean sneak;
    public Rouge(String name, Race race, List<Item> backPack){
        super(name, race, backPack, MIN_MP_MAX);
        setStats();
        setMaxHealth(8 + getConMod());
        setArmourClass(calculateAC());
    }

    public void setSneak(boolean sneak){
        this.sneak = sneak;
    }

    public int basicAttack(Enemy enemy){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll + getDexMod() >= enemy.getAC()){
            damage += Die.roll(1, 6) + getDexMod();
        }
        if (attackRoll == 20){
            damage *= 2;
        }
        if (sneak){
            damage *= 2;
            setSneak(false);
        }

        return damage;
    }

    public int magicAttack(Enemy enemy, Magical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll >= enemy.getAC()){
            damage += attack.useSkill();
        }
        if (attackRoll == 20){
            damage *= 2;
        }
        if (sneak){
            damage *= 2;
            setSneak(false);
        }

        return damage;
    }

    public int physicalAttack(Enemy enemy, Physical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll + getDexMod() > enemy.getAC()){
            damage += attack.useSkill();

            damage *= 2;
        }
        if (attackRoll == 20){
            damage *= 2;
        }
        if (sneak){
            damage *= 2;
            setSneak(false);
        }

        return damage;
    }

}
