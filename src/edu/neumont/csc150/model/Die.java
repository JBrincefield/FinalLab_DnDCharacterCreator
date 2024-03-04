package edu.neumont.csc150.model;

import java.util.Random;

/**
 * @author jbrincefield
 * @createdOn 2/29/2024 at 11:03 AM
 * @projectName FinalLab_DnDCharacterCreator
 * @packageName edu.neumont.csc150.model;
 */
public class Die {
    private static Random random = new Random();
    private static final int MIN_NUM_SIDES = 2, MIN_NUM_DICE = 1;

    public static int roll(int numSides){
        if (numSides < MIN_NUM_SIDES)
            throw new IllegalArgumentException("The number of sides on a die MUST be at least " + MIN_NUM_SIDES);

        int returnRoll = random.nextInt(1, numSides + 1);

        return returnRoll;
    }

    public static int roll(int numDice, int numSides){
        if (numDice < MIN_NUM_DICE)
            throw new IllegalArgumentException("The number of dice MUST be at least " + MIN_NUM_DICE);
        if (numSides < MIN_NUM_SIDES)
            throw new IllegalArgumentException("The number of sides on a die MUST be at least " + MIN_NUM_SIDES);

        int rollSum = 0;

        for (int i = 0; i < numDice; i++) {
            rollSum += random.nextInt(1, numSides + 1);
        }

        return rollSum;
    }

}
