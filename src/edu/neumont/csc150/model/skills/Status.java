package edu.neumont.csc150.model.skills;

import edu.neumont.csc150.model.skills.Skill;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:39 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Status extends Skill {
    private int rollCount, dice;
    private boolean heal, buff;
    public Status(SkillList name, String description, int coolDown, int mpCost,int rollCount,int dice,boolean buff,boolean heal) {
        super(name, description, coolDown, mpCost);
        setRollCount(rollCount);
        setDice(dice);
        setBuff(buff);
        setHeal(heal);
    }
    //region Getter/Setters

    public int getRollCount() {
        return rollCount;
    }

    private void setRollCount(int rollCount) {
        this.rollCount = rollCount;
    }

    public int getDice() {
        return dice;
    }

    private void setDice(int dice) {
        this.dice = dice;
    }

    public boolean isHeal() {
        return heal;
    }

    private void setHeal(boolean heal) {
        this.heal = heal;
    }

    public boolean isBuff() {
        return buff;
    }

    private void setBuff(boolean buff) {
        this.buff = buff;
    }

    //endregion

    @Override
    public String toString() {
        return null;
    }
}
