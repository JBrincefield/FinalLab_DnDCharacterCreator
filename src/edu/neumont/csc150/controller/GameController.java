package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.character.*;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.view.UI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:31 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.controller;
 */
public class GameController {

    List<Character> characters = new ArrayList<>();

    public void run(){
        do {
            switch (UI.displayMainMenu()) {
                case 1:
                    newGame();
                    break;
                case 2:
                    newCharacter();
                    break;
                default:
                    return;
            }
        }while (true);

    }

    public void newGame(){

    }

    public void newCharacter(){
        int selection = UI.displayCharacterOption();
        Race race = UI.displayGetRace();
        String name = UI.displayGetName();

        switch (selection){
            case 1:
                new Wizard(name, race);
                break;
            case 2:
                new Fighter(name, race);
                break;
            case 3:
                new Ranger(name, race);
                break;
            case 4:
                new Rouge(name, race);
                break;
            default:
                return;
        }
    }
}
