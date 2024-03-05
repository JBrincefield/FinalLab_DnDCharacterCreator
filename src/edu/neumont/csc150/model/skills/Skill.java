package edu.neumont.csc150.model.skills;

import edu.neumont.csc150.model.Die;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:38 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public abstract class Skill {
    private String description;
    private int coolDown, mpCost;
    private SkillList name;

    public Skill(SkillList name) {
        setName(name);
    }
    //region Getter/Setters

    public SkillList getName() {
        return name;
    }

    private void setName(SkillList name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    public int getCoolDown() {
        return coolDown;
    }

    private void setCoolDown(int coolDown) {
        this.coolDown = coolDown;
    }

    public int getMpCost() {
        return mpCost;
    }

    private void setMpCost(int mpCost) {
        this.mpCost = mpCost;
    }

    //endregion
    @Override
    public abstract String toString();
}

