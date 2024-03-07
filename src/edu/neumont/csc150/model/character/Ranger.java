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
public class Ranger extends Character {
    private final static int MIN_MP_MAX = 150;

    public Ranger(String name, Race race){
        super(name, race, MIN_MP_MAX);
        setStats();
        setMaxHP(10 + getConMod());
        setArmorClass(calculateAC());
        setSkills();
        addActiveSpells(getSkills().getFirst());
    }

    private void setSkills(){
        addSkills(new Physical(SkillList.SHOOT));
        addSkills(new Physical(SkillList.TRIPLE_SHOT));
        addSkills(new Physical(SkillList.FIRE_ARROW));
        addSkills(new Physical(SkillList.POISON_ARROW));
        addSkills(new Physical(SkillList.EXPLOSIVE_ARROW));

    }

    public int getAttackRollMod(){
        if (getDexMod() > getWisMod()){
            return getDexMod() + getLvl();
        }else {
            return getWisMod() + getLvl();
        }
    }

    @Override
    public int basicAttack(Enemy enemy){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll + getDexMod() + getAttackRollMod() >= enemy.getAC()){
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

        enemy.dealDamage(damage);
        return damage;
    }

    @Override
    public int magicAttack(Enemy enemy, Magical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll  + getWisMod() + getAttackRollMod() >= enemy.getAC()){
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

    @Override
    public int physicalAttack(Enemy enemy, Physical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll + getDexMod() + getAttackRollMod() >= enemy.getAC()){
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
