package edu.neumont.csc150.controller;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.*;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.enemy.*;
import edu.neumont.csc150.model.item.*;
import edu.neumont.csc150.model.item.ItemName;
import edu.neumont.csc150.model.skills.*;
import edu.neumont.csc150.view.Console;
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
    private boolean isEnemy;
    private boolean isItem;
    private ItemName itemsName;

    public void run() {
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
        } while (true);

    }

    public void playGame() {
        if (!characters.isEmpty()) {
            Character character = UI.chooseCharacter(characters);
            enterRoom(false, false, character);
            do {
                switch (UI.displayInGameMenu()) {
                    case 1:
                        setChecker(false,false);
                        if (Die.roll(4) <= 1) {
                            setChecker(true, false);
                            enterRoom(isEnemy, isItem, character);
                        } else if (Die.roll(9) >= 3) {
                            setChecker(false, true);
                            enterRoom(isEnemy, isItem,character);
                        } else {
                            setChecker(false, false);
                            enterRoom(isEnemy, isItem, character);
                        }
                        break;
                    case 2:
                        switch (UI.displayAttack(isEnemy)) {
                            case 1:
                                attackEnemy(character);
                                break;
                            case 2:
                                int skillSelect = UI.pickSkill(character);
                                if (character.getActiveSkills().get(skillSelect).getClass() == Magical.class){
                                    attackEnemy(character, (Magical) character.getActiveSkills().get(skillSelect));
                                }else {
                                    attackEnemy(character, (Physical) character.getActiveSkills().get(skillSelect));
                                }
                                break;
                            default:
                                continue;
                        }
                        break;
                    case 3:
                        openChest(isItem, character,getItemDrop(character));
                        setChecker(false,false);
                        break;
                    case 4:
                        characterMenu(character);
                        break;
                    default:
                        return;
                }
            } while (true);
        } else {
            newCharacter();
            playGame();
        }
    }

    private void characterMenu(Character character) {
        do {


            switch (UI.characterOptionsMenu()) {
                case 1:
                    skillMenu(character);
                    break;
                case 2:
                    bagMenu(character);
                    break;
                case 3:
                    UI.printCharacter(character);
                    break;
                case 4:
                    //S.saveGame(); // Doesn't work yet still working on other stuff
                    break;
                default:
                    return;
            }
        }while (true);
    }

    private void bagMenu(Character character) {
        switch (UI.bagMenu()){
            case 1:
                equipmentMenu(character);
                break;
            case 2:
                inventoryMenu(character);
                break;
            default:
                break;
        }
    }

    private void inventoryMenu(Character character) {
        switch (UI.invetoryMenu()){
            case 1:
                inventoryConsumableMenu(character);
                break;
            case 2:
                inventoryEquipmentMenu(character);
            default:
                break;
        }
    }

    private void inventoryConsumableMenu(Character character) {
        switch (UI.inventoryConsumableMenu()){
            case 1:
                UI.printAllConsumables(character);
                break;
            case 2:
                UI.discardConsumable(character);
            default:
                break;
        }
    }

    private void inventoryEquipmentMenu(Character character) {
        switch (UI.inventoryEquipmentMenu()){
            case 1:
                UI.printAllEquipment(character);
                break;
            case 2:
                UI.discardEquipment(character);
            default:
                break;
        }
    }

    private void equipmentMenu(Character character) {
        switch (UI.equipmentMenu()){
            case 1:
                UI.listEquipment(character);
                break;
            case 2:
                UI.equipItem(character);
                break;
            case 3:
                UI.unequipEquipment(character);
                break;
            default:
                break;
        }
    }

    private void skillMenu(Character character) {
        switch (UI.skillMenu()){
            case 1:
                UI.displaySkill(character, UI.pickSkill(character));
                break;
            case 2:
                UI.displayClassSkills(character);
                break;
            default:
                break;
        }
    }
    //region Item Handler/Creator
    private void openChest(boolean isItem, Character character, Item roomItem) {
        if (UI.chestOpen(isItem, roomItem) == 1) {
            character.addItem(roomItem);
        }
    }
    private Item getItemDrop(Character character) {
        int rollValue = Die.roll((items.length - 2));
        boolean check = true;
        do {
            switch (items[rollValue].getRarity()) {
                case "Mythical":
                    if (Die.roll(99) >= 97) {
                        return createItem(items[rollValue],character);
                    } else {
                        rollValue = Die.roll((items.length - 2));
                        break;
                    }
                case "Legendary":
                    if (Die.roll(99) >= 80) {
                        return createItem(items[rollValue],character);
                    } else {
                        rollValue = Die.roll((items.length - 2));
                        break;
                    }
                case "Rare":
                    if (Die.roll(99) >= 50) {
                        return createItem(items[rollValue],character);
                    } else {
                        rollValue = Die.roll((items.length - 2));
                        break;
                    }
                default:
                    return createItem(items[rollValue],character);
            }
        }while (true) ;
    }
    private Item createItem(ItemName item, Character character){
        if (item.getHpGain() > 0 || item.getMpGain() > 0) {
            itemsName = item;
            return new Consumable(item);
        }else{
            itemsName = item;
            return  new Equipment(item);
        }

    }
    //endregion
    //region  Attack Handlers

    public void attackEnemy(Character character) {
        int damage = character.basicAttack(currentEnemy);
        UI.displayAttackInfo(currentEnemy, damage);
        if (currentEnemy.getCurrentHP() <= 0) {
            getEnemyDrop(character);
            character.setExp(currentEnemy.getExp());
            isEnemy = false;
            currentEnemy = null;
        }else{
            int damageTook = currentEnemy.attack(character);
            character.dealDamage(damage);
            UI.displayAttacked(damage, character);
        }


    }

    public void attackEnemy(Character character, Magical attack) {
        int damage = character.magicAttack(currentEnemy, attack);
        UI.displayMagicalSkillAction(attack);
        UI.displayAttackInfo(currentEnemy, damage);
        if (currentEnemy.getCurrentHP() <= 0) {
            getEnemyDrop(character);
            character.setExp(currentEnemy.getExp());
            isEnemy = false;
            currentEnemy = null;
        }else{
            int damageTook = currentEnemy.attack(character);
            character.dealDamage(damage);
            UI.displayAttacked(damage, character);
        }
    }

    private void getEnemyDrop(Character character) {
        if (Die.roll(99) <= 30){
        takeItem(itemsName, character);
        }
    }

    private void takeItem(ItemName item ,Character character) {
        if (item.getHpGain() > 0 || item.getMpGain() > 0) {
            UI.chestOpen(true, new Consumable((item)));
            character.addItem(new Consumable(item));
        }else{
            UI.chestOpen(true, new Equipment((item)));
            character.addItem(new Equipment(item));
        }
    }

    public void attackEnemy(Character character, Physical attack) {
        int damage = character.physicalAttack(currentEnemy, attack);
        UI.displayPhysicalSkillAction(attack);
        UI.displayAttackInfo(currentEnemy, damage);
        if (currentEnemy.getCurrentHP() <= 0) {
            getEnemyDrop(character);
            character.setExp(currentEnemy.getExp());
            isEnemy = false;
            currentEnemy = null;
        }else{
            int damageTook = currentEnemy.attack(character);
            character.dealDamage(damage);
            UI.displayAttacked(damage, character);
        }
    }
    //endregion
    public void enterRoom(boolean isEnemy, boolean isItem, Character character) {

        if (isEnemy) {
            currentEnemy = new Enemy(enemies[Die.roll(enemies.length - 2)]);
            UI.displayRoom(currentEnemy, null);
        } else if (isItem) {
            currentEnemy = null;
            UI.displayRoom(currentEnemy, getItemDrop(character));
        } else {
            UI.displayRoom(currentEnemy, getItemDrop(character));
        }
    }


    private void setChecker ( boolean enemy, boolean item){
            this.isEnemy = enemy;
            this.isItem = item;
    }
    public void newCharacter () {
            int selection = UI.displayCharacterOption();
            Race race = UI.displayGetRace();
            String name = UI.displayGetName();

            switch (selection) {
                case 1:
                    Wizard w = new Wizard(name, race);
                    characters.add(w);
                    UI.printCharacter(w);
                    break;
                case 2:
                    Fighter f = new Fighter(name, race);
                    characters.add(f);
                    UI.printCharacter(f);
                    break;
                case 3:
                    Ranger ranger = new Ranger(name, race);
                    characters.add(ranger);
                    UI.printCharacter(ranger);
                    break;
                case 4:
                    Character r = new Rogue(name, race);
                    characters.add(r);
                    UI.printCharacter(r);
                    break;
                default:
                    throw new IllegalStateException("how and why are we here?");
            }
        }
    }