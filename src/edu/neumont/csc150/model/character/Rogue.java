package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.enemy.Enemy;
import edu.neumont.csc150.model.skills.Magical;
import edu.neumont.csc150.model.skills.Physical;
import edu.neumont.csc150.model.skills.SkillList;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:41 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Rogue extends Character {

    private final static int MIN_MP_MAX = 125;
    private boolean sneak;
    public Rogue(String name, Race race){
        super(name, race, MIN_MP_MAX);
        setStats();
        setMaxHP(8 + getConMod());
        setArmorClass(calculateAC());
        setSkills();
        addActiveSpells(getSkills().getFirst());
    }

    private void setSkills(){
        addSkills(new Physical(SkillList.POISON_STAB));
        addSkills(new Physical(SkillList.BACK_STAB));
        addSkills(new Physical(SkillList.TRICK_STAB));
        addSkills(new Physical(SkillList.SNEAK_ATTACK));
        addSkills(new Physical(SkillList.DOUBLE_STAB));
        addSkills(new Physical(SkillList.LUCKY_STRIKE));
        addSkills(new Magical(SkillList.MAGE_HAND));
    }

    public void setSneak(boolean sneak){
        this.sneak = sneak;
    }

    @Override
    public int basicAttack(Enemy enemy){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll + getDexMod() >= enemy.getAC()){
            damage += Die.roll(1, 6) + getDexMod();

            damage += getWeaponAttackMod();
        }
        if (attackRoll == 20){
            damage *= 2;
        }
        if (sneak){
            damage *= 2;
            setSneak(false);
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

        if (attackRoll >= enemy.getAC()){
            damage += attack.useSkill();

            damage += getWeaponAttackMod();
        }
        if (attackRoll == 20){
            damage *= 2;
        }
        if (sneak){
            damage *= 2;
            setSneak(false);
        }


        useMana(attack.getMpCost());


        if (damage < enemy.getDefence()){
            damage = 0;
        }else {
            damage = damage - enemy.getDefence();
        }

        enemy.dealDamage(damage);
        return damage;
    }

    @Override
    public int physicalAttack(Enemy enemy, Physical attack){
        int damage = 0;
        int attackRoll = Die.roll(1, 20);

        if (attackRoll + getDexMod() > enemy.getAC()){
            damage += attack.useSkill();

            damage += getWeaponAttackMod();
        }
        if (attackRoll == 20){
            damage *= 2;
        }
        if (sneak){
            damage *= 2;
            setSneak(false);
        }


        useMana(attack.getMpCost());


        if (damage < enemy.getDefence()){
            damage = 0;
        }else {
            damage = damage - enemy.getDefence();
        }

        enemy.dealDamage(damage);
        return damage;
    }

}
