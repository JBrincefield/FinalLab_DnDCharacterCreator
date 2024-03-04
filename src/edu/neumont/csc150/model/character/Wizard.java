package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:39 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Wizard extends Character {

    public Wizard(String name, Race race, List<Item> backPack){
        super(name, race, backPack, 100);
        setStats();
        setMaxHealth(6 + getConMod());
        setArmourClass(calculateAC());
    }

}
