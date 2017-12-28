package view;

import model.Figure;

import java.util.Map;

/**
 * Class for display in console
 *
 * @author Alex Volochai
 */
public class ConsoleView {

    /**
     * Print figures in console
     *
     * @param figures will be printed
     */
    public static void printFigures(Figure[] figures) {
        for (Figure figure : figures) {
            if (figure != null) {
                System.out.println(figure.toString());
            }
        }
    }

    /**
     * Print split figures in console
     *
     * @param figures will be printed
     */
    public static void printFigures(Figure[][] figures) {
        for (Figure[] sameFigures : figures) {
            if (sameFigures[0] != null) {
                System.out.println(sameFigures.getClass().getSimpleName());
                printFigures(sameFigures);
                System.out.println();
            }
        }
    }

    /**
     * Print count of each figure
     *
     * @param map result of counting
     */
    public static void printCountFigures(Map<String, Integer> map){
        for (String key : map.keySet()) {
            System.out.print(key + "=" + map.get(key) + " ");
        }
    }

    /**
     * Write string with border in console
     *
     * @param s User's string
     */
    public static void printString(String s) {
        String line = "----------";
        System.out.println(line + s + line);
    }

}
