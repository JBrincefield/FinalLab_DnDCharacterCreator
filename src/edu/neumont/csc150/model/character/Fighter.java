package edu.neumont.csc150.model.character;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.item.Item;

import java.util.List;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:40 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Fighter extends Character {

    int dmgRollMod = 2 + getLvl();
    public Fighter(String name, Race race, List<Item> backPack){
        super(name, race, backPack, 100);
        setStats();
        setMaxHealth(10 + getConMod());
        setArmourClass(calculateAC());
    }

}
