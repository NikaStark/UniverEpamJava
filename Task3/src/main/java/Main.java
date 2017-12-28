import controller.FigureController;
import model.Figure;
import util.factories.AbstractFigureFactory;
import util.factories.ColorFigureFactory;
import util.factories.NotColorFigureFactory;
import view.ConsoleView;

import java.util.Scanner;

/**
 * @author Alex Volochai
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input count : ");
        int count = scanner.nextInt();

        AbstractFigureFactory notColorFigureFactory = NotColorFigureFactory.getInstance();
        AbstractFigureFactory colorFigureFactory = ColorFigureFactory.getInstance();

        Figure[] notColorFigures = notColorFigureFactory.getFigures(count / 2);
        Figure[] colorFigures = colorFigureFactory.getFigures(count / 2);

        ConsoleView.printFigures(notColorFigures);
        ConsoleView.printCountFigures(FigureController.countFigures(notColorFigures));
        System.out.println();
        System.out.println();
        ConsoleView.printFigures(colorFigures);
        ConsoleView.printCountFigures(FigureController.countFigures(colorFigures));
        System.out.println();
        System.out.println();

        ConsoleView.printString("Not color figures");
        ConsoleView.printFigures(FigureController.splitFigures(notColorFigures));
        ConsoleView.printString("Color figures");
        ConsoleView.printFigures(FigureController.splitFigures(colorFigures));
    }

}