package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.enemy.Enemy;
import edu.neumont.csc150.model.skills.Magical;
import edu.neumont.csc150.model.skills.Physical;
import edu.neumont.csc150.model.skills.SkillList;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:39 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Wizard extends Character {
    private final static int MIN_MP_MAX = 250;

    public Wizard(String name, Race race){
        super(name, race, MIN_MP_MAX);
        setStats();
        setMaxHP(6 + getConMod());
        setArmorClass(calculateAC());
        setSkills();
        addActiveSpells(getSkills().getFirst());
    }

    private void setSkills(){
        addSkills(new Magical(SkillList.MAGIC_BULLET));
        addSkills(new Magical(SkillList.FIREBALL));
        addSkills(new Magical(SkillList.LIGHTNING_BOLT));
        addSkills(new Magical(SkillList.IMPLODE));
        addSkills(new Magical(SkillList.FIRE_BOLT));
        addSkills(new Magical(SkillList.LIGHTNING_STRIKE));
        addSkills(new Magical(SkillList.FROST_BOLT));
        addSkills(new Magical(SkillList.DARK_SUN));

    }

    public int getSpellAttackMod(){
        return getIntelligenceMod() + getLvl();
    }


    @Override
    public int basicAttack(Enemy enemy){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

         if (attackRoll + getDexMod() >= enemy.getAC()){
            damage += Die.roll(1, 4) + getStrengthMod();

             damage += getWeaponAttackMod();
        }
         if (attackRoll == 20){
             damage *= 2;
         }

         if (damage < enemy.getDefence()){
             damage = 0;
         }else {
             damage = damage - enemy.getDefence();
         }

         //TODO: DO NOT FORGET TO CHANGE DAMAGE VALUE, THIS IS FOR TESTING
        enemy.dealDamage(9999);
        return 9999;
    }

    @Override
    public int magicAttack(Enemy enemy, Magical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll + getIntelligenceMod() >= enemy.getAC()){
            damage += attack.useSkill();

            damage += getWeaponAttackMod();
            damage += getSpellAttackMod();
        }
        if (attackRoll == 20){
            damage *= 2;
        }

        if (damage < enemy.getDefence()){
            damage = 0;
        }else {
            damage = damage - enemy.getDefence();
        }

        useMana(attack.getMpCost());

        enemy.dealDamage(damage);
        return damage;
    }

    @Override
    public int physicalAttack(Enemy enemy, Physical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll >= enemy.getAC()){
            damage += attack.useSkill();

            damage += getWeaponAttackMod();
        }
        if (attackRoll == 20){
            damage *= 2;
        }

        if (damage < enemy.getDefence()){
            damage = 0;
        }else {
            damage = damage - enemy.getDefence();
        }

        useMana(attack.getMpCost());
        enemy.dealDamage(damage);
        return damage;
    }

}
