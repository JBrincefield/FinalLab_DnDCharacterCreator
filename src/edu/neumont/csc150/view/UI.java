package edu.neumont.csc150.view;

import edu.neumont.csc150.model.character.Character;
import edu.neumont.csc150.model.character.Race;
import edu.neumont.csc150.model.character.Rogue;
import edu.neumont.csc150.view.Console;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 10:38 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.view;
 */
public class UI {
    public static int displayMainMenu(){
        return Console.getIntInput("""
                1. New Game
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
}
