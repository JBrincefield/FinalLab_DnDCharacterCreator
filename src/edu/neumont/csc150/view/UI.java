package edu.neumont.csc150.view;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.character.Race;
import edu.neumont.csc150.model.character.Rogue;
import edu.neumont.csc150.model.enemy.Enemy;
import edu.neumont.csc150.model.item.Equipment;
import edu.neumont.csc150.model.item.Item;
import edu.neumont.csc150.view.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:38 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.view;
 */
public class UI {
    public static int displayMainMenu() {
        return Console.getIntInput("""
                1. Play Game
                2. New Character
                3. Exit
                """, 1, 3, Console.TextColor.CYAN);
    }

    public static int displayCharacterOption() {
        Console.writeLn("Pick a Class:", Console.TextColor.BLUE);
        return Console.getIntInput("""
                1. Wizard
                2. Fighter
                3. Ranger
                4. Rogue
                """, 1, 5, Console.TextColor.CYAN);
    }

    public static Race displayGetRace() {
        Race[] races = Race.values();
        StringBuilder typeBuilder = new StringBuilder();
        Console.writeLn("What Race is your character?\n", Console.TextColor.BLUE);
        int menuCount = 1;
        for (Race race : races) {
            if (race == Race.DEFAULT) continue;
            typeBuilder.append(menuCount + ". " + race);
            menuCount++;
            typeBuilder.append("\n");
        }
        int selection = Console.getIntInput(typeBuilder.toString(), 1, races.length - 1, Console.TextColor.CYAN);
        return races[selection];
    }

    public static String displayGetName() {
        return Console.getStringInput("What is the name of your Character?", false, Console.TextColor.BLUE);
    }

    public static void printCharacter(Character r) {
        Console.writeLn(r.toString(), Console.TextColor.GREEN);
    }

    public static Character chooseCharacter(List<Character> characters) {
        if (characters != null) {
            String charactersList = "";

            int i = 1;
            for (Character character : characters) {
                if (character != null)
                    charactersList += i + ". " + character.getName() + "\n";
                i++;
            }

            Console.writeLn("What character do you want to use?", Console.TextColor.BLUE);


            return characters.get(Console.getIntInput(charactersList,1,charactersList.length(), Console.TextColor.BLUE) - 1);
        } else {
            Console.writeLn("No characters");
            return null;
        }
    }

    public static void displayRoom(Enemy enemy, Item item) {

        switch (Die.roll(4)) {
            case 1:
                if (enemy != null) {
                    Console.writeLn("You are in a dark room with a single source of light from the roof. in front of you you see a ", Console.TextColor.BLUE);
                    Console.writeLn(enemy.getName() + "!", Console.TextColor.RED);
                } else if (item != null) {
                    Console.writeLn("You are in a dark room with a single source of light from the roof. in front of you you see a ", Console.TextColor.BLUE);
                    Console.writeLn("Treasure Chest", Console.TextColor.YELLOW);
                }
                break;
            case 2:
                if (enemy != null) {
                    Console.writeLn("You are in very bright open room. in front of you you see a ", Console.TextColor.BLUE);
                    Console.writeLn(enemy.getName() + "!", Console.TextColor.RED);
                } else if (item != null) {
                    Console.writeLn("You are in very bright open room. in front of you you see a ", Console.TextColor.BLUE);
                    Console.writeLn("Treasure Chest", Console.TextColor.YELLOW);
                }
                break;
            case 3:
                if (enemy != null) {
                    Console.writeLn("you are in a long dark hallway. in front of you you see a ", Console.TextColor.BLUE);
                    Console.writeLn(enemy.getName() + "!", Console.TextColor.RED);
                } else if (item != null) {
                    Console.writeLn("you are in a long dark hallway. in front of you you see a ", Console.TextColor.BLUE);
                    Console.writeLn("Treasure Chest", Console.TextColor.YELLOW);
                }
                break;
            case 4:
                if (enemy != null) {
                    Console.writeLn("You are in a boring room. in front of you you see a ", Console.TextColor.BLUE);
                    Console.writeLn(enemy.getName(), Console.TextColor.RED);
                } else if (item != null) {
                    Console.writeLn("you are in a long dark hallway. in front of you you see a ", Console.TextColor.BLUE);
                    Console.writeLn("Treasure Chest", Console.TextColor.YELLOW);
                }
                break;
            default:
                throw new IllegalStateException("How did we get here?");
        }
    }

    public static void displayRoom() {
        switch (Die.roll(4)) {
            case 1:
                Console.writeLn("You are in a dark room with a single source of light from the roof. in front of you you see a Door", Console.TextColor.BLUE);
                break;
            case 2:
                Console.writeLn("You are in very bright open room. in front of you you see a Door", Console.TextColor.BLUE);
                break;
            case 3:
                Console.writeLn("you are in a long dark hallway. in front of you you see a Door", Console.TextColor.BLUE);
                break;
            case 4:
                Console.writeLn("You are in a boring room. in front of you you see a Door", Console.TextColor.BLUE);
                break;
            default:
                throw new IllegalStateException("How did we get here?");
        }
    }

    public static int displayInGameMenu() {
        return Console.getIntInput("""
                1. Move into next room
                2. Attack
                3. Check for Item
                4. Open Character Menu
                5. exit
                """, 1, 5, Console.TextColor.CYAN);
    }


    public static int displayAttack(boolean isEnemy) {
        if (isEnemy) {
            Console.writeLn("Select an action:", Console.TextColor.BLUE);
            return Console.getIntInput("""
                    1. Basic attack
                    2. Skill
                    3. back
                    """, 1, 3, Console.TextColor.CYAN);
        } else
            Console.writeLn("You swing straight into the ground, there is no enemy... what did you expect?", Console.TextColor.BLUE);

        return -1;
    }

    public static void displayAttackInfo(int attackDmg, Enemy enemy) {
        if (attackDmg > 0) {
            Console.write("You dealt ");
            Console.write(attackDmg + "!", Console.TextColor.RED);
            Console.writeLn("The Enemy has " + enemy.getCurrentHP() + " left", Console.TextColor.CYAN);
        } else {
            Console.writeLn("You Missed", Console.TextColor.YELLOW);
        }
    }

    public static int characterOptionsMenu() {
        Console.writeLn("Character Menu:", Console.TextColor.BLUE);
        return Console.getIntInput("""
                1. Display Skills
                2. Open Backpack
                3. Show Character Stats
                4. save (Non-Functional)
                5.exit
                """, 1, 5, Console.TextColor.CYAN);
    }

    public static int chestOpen(boolean isItem, Item item) {
        if (isItem != false) {
            Console.writeLn("You found...", Console.TextColor.BLUE);
            printItem(item);
            return 1;
        }
        Console.writeLn("There is nothing there.", Console.TextColor.BLUE);
        return 0;
    }

    //region SkillsStuff includes Skill selector
    public static int skillMenu() {
        Console.writeLn("Skills Menu:", Console.TextColor.BLUE);
        return Console.getIntInput("""
                1. Check Skill Descriptions
                2. See All Class Skills
                3. exit
                """, 1, 3, Console.TextColor.CYAN);
    }

    public static int pickSkill(Character character) {
        Console.writeLn("Select a Skill:", Console.TextColor.BLUE);
        for (int i = 0; i < character.getActiveSkills().size(); i++) {
            Console.writeLn((i + 1) + ":" + character.getActiveSkills().get(i).getName(), Console.TextColor.CYAN);
        }
        return Console.getIntInput("", 1, character.getActiveSkills().size()) - 1;
    }

    public static void displayClassSkills(Character character) {
        Console.writeLn("All Class Skills:", Console.TextColor.BLUE);
        for (int i = 0; i < character.getSkills().size(); i++) {
            Console.writeLn("Lvl req:" + (i + 1) + " " + character.getSkills().get(i), Console.TextColor.CYAN);
        }
    }

    public static void displaySkill(Character character, int i) {
        Console.writeLn("You Selected:", Console.TextColor.BLUE);
        Console.writeLn(character.getActiveSkills().get(i).toString(), Console.TextColor.CYAN);
    }

    //endregion
    //region backPack Stuff
    public static int bagMenu() {
        Console.writeLn("Bag Menu:", Console.TextColor.BLUE);
        return Console.getIntInput("""
                1. Equipment
                2. Inventory
                3. exit
                """, 1, 3, Console.TextColor.CYAN);
    }

    public static void unequipEquipment(Character character) {
        Console.writeLn("Select  an Equipment to Dequip:", Console.TextColor.BLUE);
        listEquipment(character);
        int choice = Console.getIntInput("",0,6) - 1;
        if (character.getActiveEquipment()[choice] != null) {
            character.removeEquipment(character.getActiveEquipment()[choice]);
            Console.writeLn("Successfully Unequiped the Item...", Console.TextColor.BLUE);
        }else{
            Console.writeLn("Failed to remove Equipement. Cannont Remove from an empty spot!!", Console.TextColor.RED);
        }
    }

    public static int equipmentMenu() {
        Console.writeLn("Equipment Menu:", Console.TextColor.BLUE);
        return Console.getIntInput("""
                1. List Active Equipment
                2. Equip Item
                3. Remove Equipment
                4. exit
                """, 1, 4, Console.TextColor.CYAN);
    }

    public static void listEquipment(Character character) {
        int count = 0;
        for (int i = 0; i < character.getActiveEquipment().length; i++) {
            if (character.getActiveEquipment()[i] != null){
                count++;
            }
        }
        Console.writeLn(count + "/ 6 Equipment Active", Console.TextColor.BLUE);
        Console.writeLn("Active Equipment:", Console.TextColor.BLUE);
        for (int i = 0; i < character.getActiveEquipment().length; i++) {
            Console.writeLn((i + 1) + ":", Console.TextColor.CYAN);
            if (character.getActiveEquipment()[i] != null) {
                printItem(character.getActiveEquipment()[i]);
            }else{
                Console.writeLn("Empty", Console.TextColor.BLUE);
            }
        }
    }

    public static void printItem(Item item) {
        switch (item.getRarity()) {
            case "Mythical":
                Console.writeLn(item.toString(), Console.TextColor.RED);
                break;
            case "Legendary":
                Console.writeLn(item.toString(), Console.TextColor.YELLOW);
                break;
            case "Rare":
                Console.writeLn(item.toString(), Console.TextColor.PURPLE);
                break;
            case "Uncommon":
                Console.writeLn(item.toString(), Console.TextColor.GREEN);
                break;
            default:
                Console.writeLn(item.toString(), Console.TextColor.WHITE);
                break;
        }
    }

    public static void equipItem(Character character) {
        int choice = 0;
        if (!character.getBackPack().isEmpty()) {
            ArrayList<Item> equipmentList = returnEquipment(character);
            if(!equipmentList.isEmpty()) {
                for (int i = 0; i < equipmentList.size(); i++) {
                    Console.writeLn((i + 1) + ":", Console.TextColor.BLUE);
                    printItem(equipmentList.get(i));
                }
                choice = Console.getIntInput("Select an Equipment:", 1, equipmentList.size(), Console.TextColor.BLUE) - 1;
                character.addEquipment((Equipment) equipmentList.get(choice));
                listEquipment(character);
                Console.writeLn("Successfully Equiped Item....", Console.TextColor.BLUE);
            }else {
                Console.writeLn("You do not have any Equipment Dive Deeper or kill monsters to obtain equipment.", Console.TextColor.RED);
            }
        }else{
            Console.writeLn("You Currently don't have any Items Dive Deeper or kill monsters to obtain equipment.", Console.TextColor.RED);
        }
    }
        private static ArrayList<Item> returnEquipment(Character character) {
            ArrayList<Item> equipmentList = new ArrayList<>();
            for (int i = 0; i < character.getBackPack().size() - 1; i++) {
                if (character.getBackPack().get(i) instanceof Equipment) {
                    equipmentList.add(character.getBackPack().get(i));
                }
            }
            return equipmentList;
        }

    public static int inventoryEquipmentMenu() {
        Console.writeLn("Inventory Menu Equipment:", Console.TextColor.BLUE);
        return Console.getIntInput("""
                1. List all Equipment
                2. Discard Equipment
                3. exit
                """, 1, 3, Console.TextColor.CYAN);
    }

    public static int inventoryConsumableMenu() {
        Console.writeLn("Inventory Menu Consumables:", Console.TextColor.BLUE);
        return Console.getIntInput("""
                1. List all Consumables
                2. Discard Consumable
                3. exit
                """, 1, 4, Console.TextColor.CYAN);
    }

    public static void printAllConsumables(Character character) {
    }

    public static void discardConsumable(Character character) {
    }

    public static void printAllEquipment(Character character) {
        ArrayList<Item> equipmentList = new ArrayList<>();
        if (!character.getBackPack().isEmpty()) {
            equipmentList = returnEquipment(character);
            if (!equipmentList.isEmpty()) {
                for (int i = 0; i < equipmentList.size(); i++) {
                    Console.writeLn((i + 1) + ":", Console.TextColor.BLUE);
                    printItem(equipmentList.get(i));
                }
            } else {
                Console.writeLn("You do not have any Equipment Dive Deeper or kill monsters to obtain equipment.", Console.TextColor.RED);
            }
        }else{
            Console.writeLn("You Currently don't have any Items Dive Deeper or kill monsters to obtain equipment.", Console.TextColor.RED);
        }
    }

    public static void discardCEquipment(Character character) {
        printAllEquipment(character);
        character.discardItem(returnEquipment(character).get(Console.getIntInput("Select an Item to remove:",1, returnEquipment(character).size(), Console.TextColor.BLUE)-1));
        Console.writeLn("Removal Successful....", Console.TextColor.BLUE);
    }

    public static int invetoryMenu() {
        Console.writeLn("Inventory Menu:", Console.TextColor.BLUE);
        return Console.getIntInput("""
                1. Consumables
                2. Equipment
                3. exit
                """, 1, 3, Console.TextColor.CYAN);
    }
    //endregion
}
