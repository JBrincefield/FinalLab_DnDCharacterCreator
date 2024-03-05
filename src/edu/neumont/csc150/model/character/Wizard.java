package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.enemy.Enemy;
import edu.neumont.csc150.model.item.Item;
import edu.neumont.csc150.model.skills.Magical;
import edu.neumont.csc150.model.skills.Physical;
import edu.neumont.csc150.model.skills.Skill;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:39 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Wizard extends Character {
    private final static int MIN_MP_MAX = 200;

    public Wizard(String name, Race race, List<Item> backPack){
        super(name, race, backPack, MIN_MP_MAX);
        setStats();
        setMaxHealth(6 + getConMod());
        setArmourClass(calculateAC());
    }

    public int getSpellAttackMod(){
        return getIntelligenceMod() + getLvl();
    }
    // TODO: once there is a consumable variable on skills (to check if it is an item being used or player skill), change mp cost and check if
    // TODO: the skill is a consumable before using
    public int basicAttack(Enemy enemy){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

         if (attackRoll + getDexMod() >= enemy.getAC()){
            damage += Die.roll(1, 4) + getStrengthMod();
        }
         if (attackRoll == 20){
             damage *= 2;
         }

        return damage;
    }

    public int magicAttack(Enemy enemy, Magical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll + getIntelligenceMod() >= enemy.getAC()){
            damage += attack.useSkill();

            damage += getSpellAttackMod();
        }
        if (attackRoll >= 20){
            damage *= 2;
        }

        return damage;
    }

    public int physicalAttack(Enemy enemy, Physical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll >= enemy.getAC()){
            damage += attack.useSkill();
        }
        if (attackRoll == 20){
            damage *= 2;
        }

        attack.useSkill();
        return damage;
    }

}
