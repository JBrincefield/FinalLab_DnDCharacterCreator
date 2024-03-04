package edu.neumont.csc150.model.character;

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


    public Wizard(){
        this("test", Race.ELF, new ArrayList<Item>());
    }
    public Wizard(String name, Race race, List<Item> backPack){
        super(name, race, backPack, 100);
        setStats();
        setMaxHealth(die.roll(6));
    }

    private void setStats(){
        setIntelligence(die.roll(3,6));
        setStrength(die.roll(3,6));
        setCharisma(die.roll(3,6));
        setWisdom(die.roll(3,6));
        setConstitution(die.roll(3,6));
        setDexterity(die.roll(3,6));
    }

}
