package edu.neumont.csc150.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//CTRL SHIFT -  = Collapse all code
//CTRL SHIFT +  = Expand all code
@SuppressWarnings("unused")
public class Console {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //region TextColors (expand)
    public enum TextColor {BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE, DEFAULT}
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";
    //endregion

    //region BackgroundColors  (expand)
    public enum BackgroundColor {BLACK,RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE, DEFAULT}
    private static final String BLACK_BACKGROUND = "\u001B[40m";
    private static final String RED_BACKGROUND = "\u001B[41m";
    private static final String GREEN_BACKGROUND = "\u001B[42m";
    private static final String YELLOW_BACKGROUND = "\u001B[43m";
    private static final String BLUE_BACKGROUND = "\u001B[44m";
    private static final String PURPLE_BACKGROUND = "\u001B[45m";
    private static final String CYAN_BACKGROUND = "\u001B[46m";
    private static final String WHITE_BACKGROUND = "\u001B[47m";
    //endregion

    /**
     * Resets the text color and background color to console default values
     */
    private static final String RESET = "\u001B[0m";

    public static void writeLnYellow(String text){
        System.out.println(Console.YELLOW + text + RESET);
    }
    public static void writeLnBlue(String text){
        System.out.println(Console.BLUE + text + RESET);
    }
    public static void writeLnRed(String text){
        System.out.println(Console.RED + text + RESET);
    }
    public static void writeLnGreen(String text){
        System.out.println(Console.GREEN + text + RESET);
    }
    public static void writeLnPurple(String text){
        System.out.println(Console.PURPLE + text + RESET);
    }
    public static void writeLnCyan(String text){
        System.out.println(Console.CYAN + text + RESET);
    }
    public static void writeLnWhite(String text){
        System.out.println(Console.WHITE + text + RESET);
    }
    public static void writeLnBlack(String text){
        System.out.println(Console.BLACK + text + RESET);
    }

    public static String getStringWithColor(String text, TextColor color){
        return getTextColorText(color) + text + RESET;
    }

    /**
     * Gets an CHAR input from the console.
     * Console will keep asking until a valid response is provided.
     * Uses the default text color
     * @param message  Message to show to the user as to what you are requesting
     * @return Returns a char value representing the users input
     */
    public static char getCharInput(String message){
        return getCharInput(message, TextColor.DEFAULT);
    }

    /**
     * Gets an CHAR input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns a char value representing the users input
     */
    public static char getCharInput(String message, TextColor textColor){
        return getStringInput(message, false, textColor).charAt(0);
    }

    /**
     * Gets an BOOLEAN input from the console.
     * Console will keep asking until a valid response is provided. Case-insensitive.
     * Uses the default text color
     * @param message  Message to show to the user as to what you are requesting
     * @param positive The positive value to ask the user for (e.g. "Yes")
     * @param negative The negative value to ask the user for (e.g. "No");
     * @return Returns an boolean value representing the users input
     */
    public static boolean getBooleanInput(String message, String positive, String negative){
        return getBooleanInput(message, positive, negative, TextColor.DEFAULT);
    }

    /**
     * Gets an BOOLEAN input from the console.
     * Console will keep asking until a valid response is provided. Case-insensitive.
     * @param message  Message to show to the user as to what you are requesting
     * @param positive The positive value to ask the user for (e.g. "Yes")
     * @param negative The negative value to ask the user for (e.g. "No");
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns an boolean value representing the users input
     */
    public static boolean getBooleanInput(String message, String positive, String negative, TextColor textColor){
        boolean response = false;
        boolean isValidResponse = false;
        do{
            String possibleAnswers = " (" + positive + " or " + negative + ")";
            String responseS = getStringInput(message + possibleAnswers, false, textColor);
            responseS = responseS.toLowerCase().trim();
            if(responseS.equals(positive.toLowerCase())){
                response = isValidResponse = true;
            } else if(responseS.equals(negative.toLowerCase())){
                isValidResponse = true;
                response = false;
            }
            if(!isValidResponse){
                Console.writeLn("Not a valid answer. Please write '" + positive + "' OR '" + negative + "' only.", TextColor.RED);
            }
        }while(!isValidResponse);
        return response;
    }

    /**
     * Gets an BYTE input from the console.
     * Console will keep asking until a valid response is provided.
     * Uses the default text color
     * @param message  Message to show to the user as to what you are requesting
     * @return Returns a byte value representing the users input
     */
    public static byte getByteInput(String message) {
        return getByteInput(message, TextColor.DEFAULT);
    }

    /**
     * Gets an BYTE input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns a byte value representing the users input
     */
    public static byte getByteInput(String message, TextColor textColor) {
        return getByteInput(message, Byte.MIN_VALUE, Byte.MAX_VALUE, textColor);
    }

    /**
     * Gets an BYTE input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param min Minimum allowed byte value
     * @param max Max allowed byte value
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns a byte value representing the users input
     */
    public static byte getByteInput(String message, byte min, byte max, TextColor textColor) {
        Byte response = null;
        do {
            try {
                String responseS = getStringInput(message, false, textColor);
                response = Byte.parseByte(responseS);
                if(response < min || response > max){
                    response = null;
                    Console.writeLn("Number must be between " + min + " and " + max + "!", TextColor.RED);
                }
            } catch (NumberFormatException n) {
                Console.writeLn("You entered an invalid number.", TextColor.RED);
            }
        }while(response == null);
        return response;
    }

    /**
     * Gets an SHORT input from the console.
     * Console will keep asking until a valid response is provided.
     * Uses the default text color
     * @param message  Message to show to the user as to what you are requesting
     * @return Returns a short value representing the users input
     */
    public static short getShortInput(String message) {
        return getShortInput(message, TextColor.DEFAULT);
    }

    /**
     * Gets an SHORT input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns a short value representing the users input
     */
    public static short getShortInput(String message, TextColor textColor) {
        return getShortInput(message, Short.MIN_VALUE, Short.MAX_VALUE, textColor);
    }

    /**
     * Gets an SHORT input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param min Minimum allowed short value
     * @param max Max allowed short value
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns a short value representing the users input
     */
    public static short getShortInput(String message, short min, short max, TextColor textColor) {
        Short response = null;
        do {
            try {
                String responseS = getStringInput(message, false, textColor);
                response = Short.parseShort(responseS);
                if(response < min || response > max){
                    response = null;
                    Console.writeLn("Number must be between " + min + " and " + max + "!", TextColor.RED);
                }
            } catch (NumberFormatException n) {
                Console.writeLn("You entered an invalid number.", TextColor.RED);
            }
        }while(response == null);
        return response;
    }

    /**
     * Gets an DOUBLE input from the console.
     * Console will keep asking until a valid response is provided.
     * Uses the default text color
     * @param message  Message to show to the user as to what you are requesting
     * @return Returns an double value representing the users input
     */
    public static double getDoubleInput(String message) {
        return getDoubleInput(message, TextColor.DEFAULT);
    }

    /**
     * Gets an DOUBLE input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns a double value representing the users input
     */
    public static double getDoubleInput(String message, TextColor textColor) {
        return getDoubleInput(message, Double.MIN_VALUE, Double.MAX_VALUE, textColor);
    }

    /**
     * Gets an DOUBLE input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message   Message to show to the user as to what you are requesting
     * @param min       Minimum double value allowed
     * @param max       Maximum double value allowed
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns a double value representing the users input
     */
    public static double getDoubleInput(String message, double min, double max, TextColor textColor) {
        Double response = null;
        do {
            try {
                String responseS = getStringInput(message, false, textColor);
                response = Double.parseDouble(responseS);
                if (response < min || response > max) {
                    response = null;
                    Console.writeLn("Number must be between " + min + " and " + max + "!", TextColor.RED);
                }
            } catch (NumberFormatException n) {
                Console.writeLn("You entered an invalid number.", TextColor.RED);
            }
        } while (response == null);
        return response;
    }

    /**
     * Gets an FLOAT input from the console.
     * Console will keep asking until a valid response is provided.
     * Uses the default text color
     * @param message  Message to show to the user as to what you are requesting
     * @return Returns an float value representing the users input
     */
    public static float getFloatInput(String message) {
        return getFloatInput(message, TextColor.DEFAULT);
    }

    /**
     * Gets an FLOAT input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns an float value representing the users input
     */
    public static float getFloatInput(String message, TextColor textColor) {
        return getFloatInput(message, Long.MIN_VALUE, Long.MAX_VALUE, textColor);
    }

    /**
     * Gets an FLOAT input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param min Minimum allowed float value
     * @param max Max allowed float value
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns an float value representing the users input
     */
    public static float getFloatInput(String message, float min, float max, TextColor textColor) {
        Float response = null;
        do {
            try {
                String responseS = getStringInput(message, false, textColor);
                response = Float.parseFloat(responseS);
                if(response < min || response > max){
                    response = null;
                    Console.writeLn("Number must be between " + min + " and " + max + "!", TextColor.RED);
                }
            } catch (NumberFormatException n) {
                Console.writeLn("You entered an invalid number.", TextColor.RED);
            }
        }while(response == null);
        return response;
    }

    /**
     * Gets an LONG input from the console.
     * Console will keep asking until a valid response is provided.
     * Uses the default text color
     * @param message  Message to show to the user as to what you are requesting
     * @return Returns an long value representing the users input
     */
    public static long getLongInput(String message) {
        return getLongInput(message, TextColor.DEFAULT);
    }

    /**
     * Gets an LONG input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns a long value representing the users input
     */
    public static long getLongInput(String message, TextColor textColor) {
        return getLongInput(message, Long.MIN_VALUE, Long.MAX_VALUE, textColor);
    }

    /**
     * Gets an LONG input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param min Miniumum allowed long value
     * @param max Maximum allowed long value
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns an long value representing the users input
     */
    public static long getLongInput(String message, long min, long max, TextColor textColor) {
        Long response = null;
        do {
            try {
                String responseS = getStringInput(message, false, textColor);
                response = Long.parseLong(responseS);
                if(response < min || response > max){
                    response = null;
                    Console.writeLn("Number must be between " + min + " and " + max + "!", TextColor.RED);
                }
            } catch (NumberFormatException n) {
                Console.writeLn("You entered an invalid number.", TextColor.RED);
            }
        }while(response == null);
        return response;
    }

    /**
     * Gets an INT input from the console.
     * Console will keep asking until a valid response is provided.
     * Uses the default text color
     * @param message  Message to show to the user as to what you are requesting
     * @return Returns an int value representing the users input
     */
    public static int getIntInput(String message) {
        return getIntInput(message, TextColor.DEFAULT);
    }

    /**
     * Gets an INT input from the console.
     * Console will keep asking until a valid response is provided.
     * Uses the default text color
     * @param message  Message to show to the user as to what you are requesting
     * @param min Minimum number the user can provide
     * @param max Maximum number the user can provide
     * @return Returns an int value representing the users input
     */
    public static int getIntInput(String message, int min, int max){
        return getIntInput(message, min, max, TextColor.DEFAULT);
    }

    /**
     * Gets an INT input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns an int value representing the users input
     */
    public static int getIntInput(String message, TextColor textColor) {
        return getIntInput(message, Integer.MIN_VALUE, Integer.MAX_VALUE, textColor);
    }

    /**
     * Gets an INT input from the console.
     * Console will keep asking until a valid response is provided.
     * @param message  Message to show to the user as to what you are requesting
     * @param min Minimum number the user can provide
     * @param max Maximum number the user can provide
     * @param textColor ConsoleTextColor of the text when written
     * @return Returns an int value representing the users input
     */
    public static int getIntInput(String message, int min, int max, TextColor textColor){
        Integer response = null;
        do {
            try {
                String responseS = getStringInput(message, false, textColor);
                response = Integer.parseInt(responseS);
                if(response < min || response > max){
                    response = null;
                    Console.writeLn("Number must be between " + min + " and " + max + "!", TextColor.RED);
                }
            } catch (NumberFormatException n) {
                Console.writeLn("You entered an invalid number.", TextColor.RED);
            }
        }while(response == null);
        return response;
    }

    /**
     * Gets a String input from the console.
     * Uses the default text color and does not allow empty
     * Console will keep asking until a valid response is provided
     * @param message Message to show to the user as to what you are requesting
     * @return The String the user typed meeting the requirements
     */
    public static String getStringInput(String message){
        return getStringInput(message, false);
    }

    /**
     * Gets a String input from the console.
     * Uses the default text color
     * Console will keep asking until a valid response is provided
     * @param message Message to show to the user as to what you are requesting
     * @param allowEmpty If the method should allow empty (e.g. enter key or space)
     * @return The String the user typed meeting the requirements
     */
    public static String getStringInput(String message, boolean allowEmpty) {
        return getStringInput(message, allowEmpty, TextColor.DEFAULT);
    }

    /**
     * Gets a String input from the console.
     * Console will keep asking until a valid response is provided
     * @param message Message to show to the user as to what you are requesting
     * @param allowEmpty If the method should allow empty (e.g. enter key or space)
     * @param textColor ConsoleTextColor of the text when written
     * @return The String the user typed meeting the requirements
     */
    public static String getStringInput(String message, boolean allowEmpty, TextColor textColor){
        String response = null;
        do{
            try {
                writeLn(message, textColor);
                response = br.readLine();
                if (!allowEmpty && response.trim().isEmpty()) {
                    Console.writeLn("You must enter a non empty answer!", TextColor.RED);
                    response = null;
                }
            }catch(IOException ex){
                writeLn(ex.getMessage(), TextColor.RED);
            }
        }while(response == null);
        return response;
    }

    /**
     * Gets a String input from the console.
     * Console will keep asking until a valid response is provided
     * @param message Message to show to the user as to what you are requesting
     * @param minCharacters The minimum amount of characters allowed in this string.
     * @param maxCharacters The maximum amount of characters allowed in this string.
     * @param textColor ConsoleTextColor of the text when written
     * @return The String the user typed meeting the requirements
     */
    public static String getStringInput(String message, int minCharacters, int maxCharacters, TextColor textColor){
        String response;
        do {
            response = getStringInput(message, minCharacters <= 0, textColor);
            if(response.length() < minCharacters || response.length() > maxCharacters){
                Console.writeLn("Your input must be between " + minCharacters + " and " + maxCharacters + " characters in length!", TextColor.RED);
                response = null;
            }
        }while(response == null);
        return response;
    }

    /**
     * Gets a date from the user by asking for each part (Month, Day, Year)
     * Makes sure that the date typed falls between the two values provided.
     * @param message Message to show to the user as to what you are requesting
     * @param minDate The minimum date allowed
     * @param maxDate The maximum date allowed
     * @param formatPattern pattern to validate the date with. (e.g. "MM-dd-yyyy", "M/dd/yyyy", "dd/MM/yyyy")
     * @param textColor ConsoleTextColor of the text when written
     * @return returns a java.time.LocalDate object populated with the users entered date
     */
    public static LocalDate getDateInput(String message, LocalDate minDate, LocalDate maxDate, String formatPattern, TextColor textColor){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        LocalDate date;
        do {
            date = getDateInput(String.format("%s (between %s and %s):", message, minDate.format(formatter), maxDate.format(formatter)), textColor);
        }while(date.isBefore(minDate) || date.isAfter(maxDate));

        return date;
    }

    /**
     * Gets a date from the user by asking for each part (Month, Day, Year)
     * Makes sure that the date typed falls between the two values provided.
     * @param message Message to show to the user as to what you are requesting
     * @param minDate The minimum date allowed
     * @param maxDate The maximum date allowed
     * @param formatPattern pattern to validate the date with. (e.g. "MM-dd-yyyy", "M/dd/yyyy", "dd/MM/yyyy")
     * @param textColor ConsoleTextColor of the text when written
     * @return returns a java.time.LocalDate object populated with the users entered date
     */
    public static LocalDate getDateInputInline(String message, LocalDate minDate, LocalDate maxDate, String formatPattern, TextColor textColor){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
        LocalDate date;
        do {
            date = getDateInputInline(String.format("%s (between %s and %s)", message, minDate.format(formatter), maxDate.format(formatter)), formatPattern, textColor);
        }while(date.isBefore(minDate) || date.isAfter(maxDate));

        return date;
    }

    /**
     * Gets a date from the user by asking for each part (Month, Day, Year)
     * @param message Message to show to the user as to what you are requesting
     * @param textColor ConsoleTextColor of the text when written
     * @return returns a java.time.LocalDate object populated with the users entered date
     */
    public static LocalDate getDateInput(String message, TextColor textColor) {
        do {
            if(message != null) {
                Console.writeLn(message, textColor);
            }
            int month = getIntInput("Enter month (1-12): ",1, 12, TextColor.DEFAULT);
            int day = getIntInput("Enter day (1-31): ", 1, 31, TextColor.DEFAULT);
            int year = getIntInput("Enter year: ", 1000, 9999, TextColor.DEFAULT);

            try {
                return LocalDate.of(year, month, day);
            } catch (DateTimeException ex) {
                Console.writeLn("Invalid date, try again.", TextColor.RED);
            }
        }while(true);
    }

    public static LocalDate getDateInputInline(String message, String formatPattern, TextColor textColor) {
        do {
            String formatHelper = " [Format: \"" + formatPattern + "\"]:";
            String dateSubmission = getStringInput(message + formatHelper, false, textColor);

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatPattern);
                return LocalDate.parse(dateSubmission, formatter);
            } catch (DateTimeException ex) {
                Console.writeLn("Invalid date, try again.", TextColor.RED);
            }
        }while(true);
    }

    /**
     * Writes to the console using the default text color and background color.
     * Does not append the newline. Text stays on the same line.
     * @param message The message to write to the console
     */
    public static void write(String message){write(message, TextColor.DEFAULT, BackgroundColor.DEFAULT);}

    /**
     * Writes to the console using the provided text color and default background color.
     * Does not append the newline. Text stays on the same line.
     * @param message The message to write to the console
     * @param textColor The ConsoleTextColor to write the text in
     */
    public static void write(String message, TextColor textColor){
        System.out.print(getBackgroundColorText(BackgroundColor.DEFAULT) + getTextColorText(textColor) + message + RESET);
    }

    /**
     * Writes the message to the console using the privided text and background color
     * Does not append the newline. Text stays on the same line.
     * @param message The message to write to the console
     * @param textColor The ConsoleTextColor to write the text in
     * @param backgroundColor The ConsoleBackgroundColor to place behind the text
     */
    public static void write(String message, TextColor textColor, BackgroundColor backgroundColor){
        System.out.print(getBackgroundColorText(backgroundColor) + getTextColorText(textColor) + message + RESET);
    }

    /**
     * Writes to the console using the default text color and background color.
     * Appends the newline to the end.
     * @param message The message to write to the console
     */
    public static void writeLn(String message){ writeLn(message, TextColor.DEFAULT, BackgroundColor.DEFAULT);}

    /**
     * Writes to the console using the provided text color and default background color.
     * Appends the newline to the end.
     * @param message The message to write to the console
     * @param textColor The ConsoleTextColor to write the text in
     */
    public static void writeLn(String message, TextColor textColor) { writeLn(message, textColor, BackgroundColor.DEFAULT);}

    /**
     * Writes the message to the console using the provided text and background color
     * Append the newline to the end.
     * @param message The message to write to the console
     * @param textColor The ConsoleTextColor to write the text in
     * @param backgroundColor The ConsoleBackgroundColor to place behind the text
     */
    public static void writeLn(String message, TextColor textColor, BackgroundColor backgroundColor){
        System.out.println(getBackgroundColorText(backgroundColor) + getTextColorText(textColor) + message + RESET);
    }

    //BLACK, RED, GREEN, YELLOW, BLUE, PURPLE, CYAN, WHITE
    private static String getTextColorText(TextColor textColor){
        switch(textColor){
            case RED:
                return Console.RED;
            case GREEN:
                return Console.GREEN;
            case YELLOW:
                return Console.YELLOW;
            case BLUE:
                return Console.BLUE;
            case PURPLE:
                return Console.PURPLE;
            case CYAN:
                return Console.CYAN;
            case BLACK:
                return Console.BLACK;
            case WHITE:
                return Console.WHITE;
            default:
                return RESET;
        }
    }

    private static String getBackgroundColorText(BackgroundColor backgroundColor){
        switch(backgroundColor){
            case RED:
                return Console.RED_BACKGROUND;
            case GREEN:
                return Console.GREEN_BACKGROUND;
            case YELLOW:
                return Console.YELLOW_BACKGROUND;
            case BLUE:
                return Console.BLUE_BACKGROUND;
            case PURPLE:
                return Console.PURPLE_BACKGROUND;
            case CYAN:
                return Console.CYAN_BACKGROUND;
            case BLACK:
                return Console.BLACK_BACKGROUND;
            case WHITE:
                return Console.WHITE_BACKGROUND;
            default:
                return RESET;
        }
    }
}
