package edu.neumont.csc150.view;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.character.Race;
import edu.neumont.csc150.model.character.Rogue;
import edu.neumont.csc150.model.enemy.Enemy;
import edu.neumont.csc150.model.item.Item;
import edu.neumont.csc150.view.Console;

import java.util.List;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:38 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.view;
 */
public class UI {
    public static int displayMainMenu(){
        return Console.getIntInput("""
                1. Play Game
                2. New Character
                3. Exit
                """, 1, 3, Console.TextColor.CYAN);
    }

    public static int displayCharacterOption(){
        Console.writeLn("Pick a Class:", Console.TextColor.BLUE);
        return Console.getIntInput("""
                1. Wizard
                2. Fighter
                3. Ranger
                4. Rogue
                """,1 ,5, Console.TextColor.CYAN);
    }

    public static Race displayGetRace(){
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

    public static String displayGetName(){
        return Console.getStringInput("What is the name of your Character?", false, Console.TextColor.BLUE);
    }

    public static void printCharacter(Character r) {
        Console.writeLn(r.toString(), Console.TextColor.GREEN);
    }

    public static Character chooseCharacter(List<Character> characters){
        if (characters != null) {
            String charactersList = "";

            int i = 1;
            for (Character character : characters) {
                if (character != null)
                    charactersList += i + ". " + character.getName() + "\n";
                i++;
            }

            Console.writeLn("What character do you want to use?");


            return characters.get(Console.getIntInput(charactersList) - 1);
        }else {
            Console.writeLn("No characters");
            return null;
        }
    }

    public static void displayRoom(Enemy enemy , Item item){

        switch (Die.roll(4)){
            case 1:
                if (enemy != null) {
                    Console.writeLn("You are in a dark room with a single source of light from the roof. in front of you you see a " , Console.TextColor.CYAN);
                    Console.writeLn(enemy.getName() + "!", Console.TextColor.RED);
                }else if(item != null){

                }
                break;
            case 2:
                if (enemy != null) {
                    Console.writeLn("You are in very bright open room. in front of you you see a ", Console.TextColor.CYAN);
                    Console.writeLn(enemy.getName() + "!", Console.TextColor.RED);
                }else if(item != null){

                }
                break;
            case 3:
                if (enemy != null) {
                    Console.writeLn("you are in a long dark hallway. in front of you you see a ", Console.TextColor.CYAN);
                    Console.writeLn(enemy.getName() + "!", Console.TextColor.RED);
                }else if(item != null){
                    Console.writeLn("you are in a long dark hallway. in front of you you see a ", Console.TextColor.CYAN);
                    Console.writeLn(enemy.getName() + "!", Console.TextColor.RED);
                }
                break;
            case 4:
                if (enemy != null) {
                    Console.writeLn("You are in a boring room. in front of you you see a ", Console.TextColor.CYAN);
                    Console.writeLn("Treasure Chest", Console.TextColor.YELLOW);
                }else if(item != null){
                    Console.writeLn("you are in a long dark hallway. in front of you you see a ");
                }
                break;
            default:
                throw new IllegalStateException("How did we get here?");
        }
    }
    public static void displayRoom(){
        switch (Die.roll(4)){
            case 1:
                Console.writeLn("You are in a dark room with a single source of light from the roof. in front of you you see a Door");
                break;
            case 2:
                Console.writeLn("You are in very bright open room. in front of you you see a Door" );
                break;
            case 3:
                Console.writeLn("you are in a long dark hallway. in front of you you see a Door");
                break;
            case 4:
                Console.writeLn("You are in a boring room. in front of you you see a Door");
                break;
            default:
                throw new IllegalStateException("How did we get here?");
        }
    }

    public static int displayInGameMenu(){
        return Console.getIntInput("""
                1. Move into next room
                2. Attack
                3. Check for Item
                4. Open Character Menu
                5. exit
                """, 1, 5, Console.TextColor.CYAN);
    }



    public static int displayAttack(boolean isEnemy){
        if (isEnemy) {
            Console.writeLn("Select an action:", Console.TextColor.BLUE);
            return Console.getIntInput("""
                    1. Basic attack
                    2. Skill
                    3. back
                    """, 1, 3, Console.TextColor.CYAN);
        }else
            Console.writeLn("You swing straight into the ground, there is no enemy... what did you expect?", Console.TextColor.CYAN);

        return -1;
    }

    public static void displayAttackInfo(int attackDmg, Enemy enemy){
        if (attackDmg > 0){
            Console.write("You dealt ");
            Console.write(attackDmg + "!", Console.TextColor.RED);
            Console.writeLn("The Enemy has " + enemy.getCurrentHP() + " left", Console.TextColor.CYAN);
        }else{
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

    public  static int  chestOpen(boolean isItem,Item item) {
        if(isItem != false){
            Console.writeLn("You found...", Console.TextColor.CYAN);
            switch (item.getRarity()){
                case "Mythical":
                    Console.writeLn(item.toString(), Console.TextColor.RED);
                    break;
                case "Legendary":
                    Console.writeLn(item.toString(), Console.TextColor.YELLOW);
                    break;
                case "Rare":
                    Console.writeLn(item.toString(), Console.TextColor.BLUE);
                    break;
                case "Uncommon":
                    Console.writeLn(item.toString(), Console.TextColor.CYAN);
                    break;
                default:
                    Console.writeLn(item.toString(), Console.TextColor.WHITE);
                    break;
            }
            return 1;
        }
        Console.writeLn("There is nothing there.");
        return 0;
    }
}
