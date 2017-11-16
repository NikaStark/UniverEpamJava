package exercise6;

import java.util.Scanner;

/**
 * Составить программу, отыскивающую проход по лабиринту.
 * Лабиринт представляется в виде матрици, состоящей из квадратов.
 * Каждый квадрат либо открит, либо закрыт.
 * Вход в закрытый квадрат запрещен.
 * Если квадрат открыт, то вход в него возможен со стороны, но не с угла.
 * Каждый квадрат определяктся его координатами в матрице.
 * Программа находит проход через лабиринт, двигаясь от заданого входа.
 * После отыскания прохода программа выводит найденый путь в виде координат квадратов.
 * Для хранения пути использовать стек.
 *
 * @author Alex Volchai
 */
public class Exercise6 {

    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter only odd numbers!");
        System.out.print("Input height : ");
        int height = scanner.nextInt();

        System.out.print("Input width : ");
        int width = scanner.nextInt();

        Maze maze = new Maze(height, width);
        maze.printMaze();
        System.out.println();

        PathSearcher pathSearcher = new PathSearcher(maze);
        Object[] path = pathSearcher.getPath().toArray();
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i] + "   ");
            if ((i + 1) % 10 == 0) System.out.println();
        }
        System.out.println();
        maze.printMaze();
    }

}
