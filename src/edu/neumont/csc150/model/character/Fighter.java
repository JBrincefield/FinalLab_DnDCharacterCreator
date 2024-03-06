package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.enemy.Enemy;
import edu.neumont.csc150.model.item.Item;
import edu.neumont.csc150.model.skills.Magical;
import edu.neumont.csc150.model.skills.Physical;
import edu.neumont.csc150.model.skills.SkillList;

import java.util.List;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:40 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Fighter extends Character {

    private final static int MIN_MP_MAX = 100;
    public Fighter(String name, Race race){
        super(name, race, MIN_MP_MAX);
        setStats();
        setMaxHP(10 + getConMod());
        setArmorClass(calculateAC());
        setSkills();
        addActiveSpells(getSkills().getFirst());
    }

    private void setSkills(){
        addSkills(new Physical(SkillList.CLEAVE));
        addSkills(new Physical(SkillList.OVER_HEAD_SLASH));
        addSkills(new Physical(SkillList.POUND));
        addSkills(new Physical(SkillList.STAB));
        addSkills(new Physical(SkillList.BOOMERANG_THROW));
        addSkills(new Physical(SkillList.LIGHTNING_SLASH));
        addSkills(new Physical(SkillList.FLAME_SLASH));
        addSkills(new Physical(SkillList.MAGIC_SLASH));

    }

    public int getDmgMod(){
        return getStrengthMod() + getLvl();
    }

    @Override
    public int basicAttack(Enemy enemy){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);


        if (attackRoll + getDexMod() >= enemy.getAC()){
            damage += Die.roll(1, 6) + getStrengthMod();

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


        return damage;
    }

    @Override
    public int magicAttack(Enemy enemy, Magical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll >= enemy.getAC()){
            damage += attack.useSkill();

            damage += getDmgMod();
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

        return damage;
    }

    @Override
    public int physicalAttack(Enemy enemy, Physical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll + getStrengthMod() > enemy.getAC()){
            damage += attack.useSkill();

            damage += getDmgMod();
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

        return damage;
    }

}
