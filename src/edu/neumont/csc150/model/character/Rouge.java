package edu.neumont.csc150.model.character;

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
    public Rouge(String name, Race race, List<Item> backPack, int maxMP) {
        super(name, race, backPack, maxMP);
    }
}
