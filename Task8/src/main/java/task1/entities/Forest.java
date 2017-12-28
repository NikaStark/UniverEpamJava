package task1.entities;

import java.util.Arrays;

/**
 * @author Alex Volochai
 */
public class Forest {

    private int[][] forestMatrix;
    private TaskQueue tasks = new TaskQueue();

    public Forest(int size) {
        forestMatrix = fillTheForest(size);
        for (int i = 0; i < size; i++) {
            tasks.add(new Task(i, forestMatrix[i]));
        }
    }

    public int[][] getForestMatrix() {
        return forestMatrix;
    }

    @Override
    public String toString() {
        return "Forest{" +
                "forestMatrix=" + Arrays.deepToString(forestMatrix) +
                '}';
    }

    public TaskQueue getTasks() {
        return tasks;
    }

    public int[][] fillTheForest(int size) {
        int[][] forest = new int[size][size];
        int x = (int) (Math.random() * size);
        int y = (int) (Math.random() * size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i == x && j == y) {
                    forest[i][j] = 1;
                } else {
                    forest[i][j] = 0;
                }
            }
        }
        return forest;
    }

    public static void printForest(int[][] forest) {
        for (int[] row : forest) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

}
