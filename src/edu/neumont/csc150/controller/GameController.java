package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.*;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.enemy.*;
import edu.neumont.csc150.model.item.*;
import edu.neumont.csc150.model.item.ItemName;
import edu.neumont.csc150.model.skills.*;
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
    private enemyList[] enemies = enemyList.values();
    private ItemName[] items = ItemName.values();
    private Enemy currentEnemy;
    private Item roomItem;
    private ItemName itemNameCheck;
    private boolean isEnemy;
    private boolean isItem;
    public void run(){
        do {
            switch (UI.displayMainMenu()) {
                case 1:
                    playGame();
                    break;
                case 2:
                    newCharacter();
                    break;
                default:
                    return;
            }
        }while (true);

    }

    public void playGame(){
        if (!characters.isEmpty()) {
            Character character = UI.chooseCharacter(characters);
            enterRoom(false, false);
            do {
                switch (UI.displayInGameMenu()) {
                    case 1:
                        if (Die.roll(2) == 1) {
                            setChecker(true,false);
                            enterRoom(isEnemy,isItem);
                        } else if (Die.roll(10) <= 2){
                            setChecker(false,true);
                            enterRoom(isEnemy,isItem);
                        }else {
                            setChecker(false,false);
                            enterRoom(isEnemy,isItem);
                        }
                        break;
                    case 2:
                        switch (UI.displayAttack(isEnemy)) {
                            case 1:


                                break;
                            case 2:
                                break;
                            default:
                                continue;
                        }
                        break;
                    case 3:
                        openChest(isItem,character);
                        break;
                    case 4:
                        switch (UI.characterOptionsMenu()){
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            default:
                        }
                        break;
                    default:
                        return;
                }
            } while (true);
        }else {
            newCharacter();
            playGame();
        }
    }

    private void openChest(boolean isItem, Character character) {
        if (UI.chestOpen(isItem, roomItem) == 1){
            character.addItem(roomItem);
        }
    }

    public void attackEnemy(Character character){
        character.basicAttack(currentEnemy);
        if (currentEnemy.getCurrentHP() <= 0) {
            currentEnemy = null;
        }
        
    }
    public void attackEnemy(Character character, Magical attack){

    }
    public void attackEnemy(Character character, Physical attack){

    }

    public void enterRoom(boolean isEnemy, boolean isItem){

        if (isEnemy) {
            currentEnemy = new Enemy(enemies[Die.roll(enemies.length - 2)]);
            UI.displayRoom(currentEnemy, roomItem);
        }else if(isItem){
            int rollValue = Die.roll((items.length - 2));

            switch (items[rollValue]){
                case CYANIDE_PILL:
                    roomItem = new Consumable(items[rollValue]);
                    break;
                case HP_POTION:
                    roomItem = new Consumable(items[rollValue]);
                    break;
                case MP_POTION:
                    roomItem = new Consumable(items[rollValue]);
                    break;
                case DEW_OF_LIFE:
                    roomItem = new Consumable(items[rollValue]);
                    break;
                case RATION:
                    roomItem = new Consumable(items[rollValue]);
                    break;
                case WATER_SKIN:
                    roomItem = new Consumable(items[rollValue]);
                    break;
                case ROPE:
                    roomItem = new Consumable(items[rollValue]);
                    break;
                default:
                    roomItem = new Equipment(items[rollValue]);
                    break;
            }
            UI.displayRoom(currentEnemy,roomItem);
        }else{
            UI.displayRoom();
        }
    }
    private void setChecker(boolean enemy, boolean item){
        this.isEnemy = enemy;
        this.isItem = item;
    }
    public void newCharacter() {
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
