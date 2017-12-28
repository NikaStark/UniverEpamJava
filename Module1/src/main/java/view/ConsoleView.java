package view;

import model.Toy;

/**
 * Class for display in console
 *
 * @author Alex Volochai
 */
public class ConsoleView {

    public static final String HELLO_MSG = "You are in management game room by console system.\n" +
            "Input command:";

    public static final String INPUT_MSG = ">";

    public static final String SUCCESS_CREATE_MSG = "Toys created";

    public static final String SUCCESS_SORT_MSG = "Toys sorted";

    public static final String TOYS_NOT_INIT_MSG = "Toys not initialize";

    public static final String WRONG_COMMAND_MSG = "Command not found";

    public static final String WRONG_PARAM_MSG = "Wrong parameters";

    /**
     * Print toys in console
     *
     * @param toys will be printed
     */
    public static void printToys(Toy[] toys) {
        for (Toy toy : toys) {
            if (toy != null) {
                String str = toy.toString();
                int splitIndex = str.indexOf("{");
                System.out.printf("%11s", str.substring(0, splitIndex));
                System.out.println(str.substring(splitIndex));
            }
        }
    }

    /**
     * Printing simple message
     *
     * @param message {@link String}
     */
    public static void printMessage(String message) {
        System.out.print(message);
    }


    /**
     * Printing simple message
     *
     * @param message {@link String}
     */
    public static void printlnMessage(String message) {
        printMessage(message);
        System.out.println();
    }

}
