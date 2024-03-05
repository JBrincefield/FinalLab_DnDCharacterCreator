package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.*;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.enemy.Enemy;
import edu.neumont.csc150.model.enemy.enemyList;
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
    enemyList[] enemies = enemyList.values();

    public void run(){
        do {
            switch (UI.displayMainMenu()) {
                case 1:
                    PlayGame();
                    break;
                case 2:
                    newCharacter();
                    break;
                default:
                    return;
            }
        }while (true);

    }

    public void PlayGame(){
        Character character = UI.chooseCharacter(characters);
        enterRoom();



    }

    public void enterRoom(){
        Enemy enemy = new Enemy(enemies[Die.roll(enemies.length)]);
        UI.displayRoom(enemy);
    }

    public void newCharacter(){
        int selection = UI.displayCharacterOption();
        Race race = UI.displayGetRace();
        String name = UI.displayGetName();

        switch (selection){
            case 1:
                Wizard w = new Wizard(name, race);
                characters.add(w);
                UI.printCharacter(w);
                break;
            case 2:
                Fighter f = new Fighter(name,race);
                characters.add(f);
                UI.printCharacter(f);
                break;
            case 3:
                Ranger ranger = new Ranger(name,race);
                characters.add(ranger);
                UI.printCharacter(ranger);
                break;
            case 4:
                Character r = new Rogue(name,race);
                characters.add(r);
                UI.printCharacter(r);
                break;
            default:
                throw new IllegalStateException("how and why are we here?");
        }
    }
}
