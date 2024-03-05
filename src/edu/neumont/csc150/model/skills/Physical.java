package edu.neumont.csc150.model.skills;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.skills.Skill;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:38 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Physical extends Skill {
    private int rollCount, dice;

    public Physical(SkillList name) {
        super(name);
        setValue();
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

    //endregion
    public int useSkill(){
        int rollValue = Die.roll(getRollCount(),getDice());
        return rollValue;
    }
    @Override
    public String toString() {
        return getName() + ": " + """
                Mp cost:""" + getMpCost() + """
                Cooldown:""" + getCoolDown()  + """
                Skill Description:""" + getDescription();
    }
}
