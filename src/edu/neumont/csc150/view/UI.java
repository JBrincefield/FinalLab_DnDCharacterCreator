package edu.neumont.csc150.view;

import edu.neumont.csc150.model.Die;
import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.character.Race;
import edu.neumont.csc150.model.character.Rogue;
import edu.neumont.csc150.model.enemy.Enemy;
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
        typeBuilder.append("What Race is your character?\n");
        int menuCount = 1;
        for (Race race : races) {
            if (race == Race.DEFAULT) continue;
            typeBuilder.append(menuCount + ". " + race);
            menuCount++;
            typeBuilder.append("\n");
        }
        int selection = Console.getIntInput(typeBuilder.toString(), 1, races.length - 1);
        return races[selection];
    }

    public static String displayGetName(){
        return Console.getStringInput("What is the name of your Character?", false, Console.TextColor.CYAN);
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

    public static void displayRoom(Enemy enemy){

        switch (Die.roll(4)){
            case 1:
                Console.writeLn("You are in a dark room with a single source of light from the roof. in front of you you see a " + enemy.getName());
                break;
            case 2:
                Console.writeLn("You are in very bright open room. in front of you you see a " + enemy.getName());
                break;
            case 3:
                Console.writeLn("you are in a long dark hallway. in front of you you see a " + enemy.getName());
                break;
            case 4:
                Console.writeLn("You are in a boring room. in front of you you see a " + enemy.getName());
                break;
            default:
                throw new IllegalStateException("How did we get here?");
        }
    }
    public static void displayRoom(){

        switch (Die.roll(4)){
            case 1:
                Console.writeLn("You are in a dark room with a single source of light from the roof. in front of you you see a ");
                break;
            case 2:
                Console.writeLn("You are in very bright open room. in front of you you see a " );
                break;
            case 3:
                Console.writeLn("you are in a long dark hallway. in front of you you see a ");
                break;
            case 4:
                Console.writeLn("You are in a boring room. in front of you you see a ");
                break;
            default:
                throw new IllegalStateException("How did we get here?");
        }
    }

    public static int displayInGameMenu(){
        return Console.getIntInput("""
                1. Move into next room
                2. Attack
                3. Check Skills
                4. Check Back Pack
                5. save (Non-Functional)
                6.exit
                """, 1, 6, Console.TextColor.CYAN);
    }



    public static int displayAttack(boolean isEnemy){
        if (isEnemy)
        return Console.getIntInput("""
                1. Basic attack
                2. Skill
                3. back
                """, 1 ,3);
        else
            Console.writeLn("You swing straight into the ground, there is no enemy... what did you expect?");

        return -1;
    }

    public static void displayAttackInfo(int attackDmg, Enemy enemy){
        if (attackDmg > 0){
            Console.writeLn("You dealt " + attackDmg);
            Console.writeLn("The Enemy has " + enemy.getCurrentHP() + " left");
        }else{
            Console.writeLn("You Missed");
        }
    }
}
