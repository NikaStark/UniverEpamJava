package task1;

import task1.entities.Bee;
import task1.entities.Forest;
import task1.entities.TaskQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Volochai
 */
public class Main {

    public static Boolean found = false;
    public static List<Bee> beeQueue = new ArrayList<>();
    public static int row = 0;
    public static int column = 0;
    public static int SIZE = 10;

    public static void main(String... args) {
        final int BEES_NUMBER = 10;

        Forest forest = new Forest(SIZE);
        TaskQueue taskQueue = forest.getTasks();

        for (int i = 0; i < BEES_NUMBER; i++) {
            beeQueue.add(new Bee(i, taskQueue));
            beeQueue.get(i).start();
        }

        for (int i = 0; i < BEES_NUMBER; i++) {
            try {
                beeQueue.get(i).join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());

            }
        }
        Forest.printForest(forest.getForestMatrix());
        System.out.println();
        System.out.println("Winni founded!");
        System.out.println("In cell -> row = " + row + ", and column = " + column);
    }

}