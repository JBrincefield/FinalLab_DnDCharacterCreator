package edu.neumont.csc150.model.skills;

import edu.neumont.csc150.model.skills.Skill;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:39 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Status extends Skill {
    public Status(String name, int coolDown) {
        super(name, coolDown);
    }
    @Override
    public String toString() {
        return null;
    }
}
