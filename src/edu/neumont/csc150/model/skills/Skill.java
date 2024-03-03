package edu.neumont.csc150.model.skills;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:38 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public abstract class Skill {
    private String name;
    private int coolDown, mpCost;

    public Skill(String name, int coolDown) {
        this.name = name;
        this.coolDown = coolDown;
    }

    @Override
    public abstract String toString();
}

