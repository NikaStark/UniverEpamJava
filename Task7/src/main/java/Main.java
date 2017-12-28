import controller.SerializeFigureController;
import model.Figure;
import util.factories.ColorFigureFactory;
import util.factories.NotColorFigureFactory;
import view.ConsoleView;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @author Alex Volochai
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File("figures.txt");

        System.out.print("Input paired count : ");
        int count = scanner.nextInt();

        Figure[] notColorFigures = NotColorFigureFactory.getInstance().getFigures(count / 2);
        Figure[] colorFigures = ColorFigureFactory.getInstance().getFigures(count / 2);

        Figure[] allFiguresInput;
        Figure[] allFiguresOutput = Stream.concat(Arrays.stream(notColorFigures), Arrays.stream(colorFigures))
                .toArray(Figure[]::new);

        SerializeFigureController.serialize(file, allFiguresOutput);
        allFiguresInput = SerializeFigureController.deserialize(file, count);

        ConsoleView.printString("Output figures");
        ConsoleView.printFigures(allFiguresOutput);
        System.out.println();
        ConsoleView.printString("Input figures");
        ConsoleView.printFigures(allFiguresInput);
        System.out.println(file.delete() ? "Delete file" : "Not delete file");

    }

}