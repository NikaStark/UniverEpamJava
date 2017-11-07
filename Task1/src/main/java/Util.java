/**
 * Utility class for other tasks
 *
 * @author Alex Volochai
 */
public class Util {

    /**
     * Print array in console
     *
     * @param vector Array of integers
     */
    public static void printVector(int[] vector) {
        for (int number : vector) {
            System.out.printf("%3d ", number);
        }
    }

    /**
     * Generated array of integers in [-length, length)
     *
     * @param length Count elements in array
     * @return Array of integers
     */
    public static int[] generatedVector(int length) {
        int[] vector = new int[length];
        for (int i = 0; i < length; i++) {
            vector[i] = (int) (Math.random() * length * 2 - length);
        }
        return vector;
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

    /**
     * Print rectangle array in console
     *
     * @param matrix Array of integers
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] vector : matrix) {
            printVector(vector);
            System.out.println();
        }
    }

    /**
     * Generated array of integers
     *
     * @param length Count elements in array
     * @return Array of integers
     */
    public static int[][] generatedSquareMatrix(int length) {
        return generatedMatrix(length, length);
    }

    /**
     * Generated array of integers
     *
     * @param height Count elements in height
     * @param width  Count elements in width
     * @return Array of integers
     */
    public static int[][] generatedMatrix(int height, int width) {
        int[][] matrix = new int[height][width];
        for (int i = 0; i < height; i++) {
            matrix[i] = generatedVector(width);
        }
        return matrix;
    }

}
