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
    private int mpCost;
    private SkillList nameSkill;
    private String name;
    public Skill(SkillList name) {
        setNameSkill(name);
        setName(name);
        setDescription(name.getDescription());
        setMpCost(name.getMpCost());
    }
    //region Getter/Setters
    public SkillList getNameSkill() {
        return nameSkill;
    }

    private void setNameSkill(SkillList nameSkill) {
        this.nameSkill = nameSkill;
    }
    public String getName() {
        return name;
    }
    private void setName(SkillList name) {
        this.name = name.getSkillName();
    }

    public String getDescription() {
        return description;
    }

    private void setDescription(String description) {
        this.description = description;
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

