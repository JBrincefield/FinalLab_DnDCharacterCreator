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
    private boolean buff;
    public Status(SkillList name, String description, int coolDown, int mpCost,int rollCount,int dice,boolean buff) {
        super(name, description, coolDown, mpCost);
        setRollCount(rollCount);
        setDice(dice);
        setBuff(buff);
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

    public boolean isBuff() {
        return buff;
    }

    private void setBuff(boolean buff) {
        this.buff = buff;
    }

    //endregion

    @Override
    public String toString() {
        return getName() + ": " + """
                Mp cost:""" + getMpCost() + """
                Cooldown:""" + getCoolDown()  + """
                Skill Description:""" + getDescription();
    }
}
