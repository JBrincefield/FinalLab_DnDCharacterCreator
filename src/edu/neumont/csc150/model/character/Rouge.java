package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.item.Item;

import java.util.List;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:41 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Rouge extends Character {
    private boolean sneak;
    public Rouge(String name, Race race, List<Item> backPack){
        super(name, race, backPack, 100);
        setStats();
        setMaxHealth(8 + getConMod());
        setArmourClass(calculateAC());
    }


}
