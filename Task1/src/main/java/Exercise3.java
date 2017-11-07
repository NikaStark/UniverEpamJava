import java.util.Scanner;

/**
 * Дана целочисленная прямоугольная матрица.
 * Упорядочить столбцы по убыванию среднего значения.
 *
 * @author Alex Volochai
 */
public class Exercise3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input height : ");
        int height = scanner.nextInt();

        System.out.print("Input width : ");
        int width = scanner.nextInt();

        int[][] matrix = Util.generatedMatrix(height, width);
        Util.printString("Initial matrix");
        Util.printMatrix(matrix);
        System.out.println();

        sortDecreasingByAverage(matrix, height, width);

        Util.printString("Sorted matrix");
        Util.printMatrix(matrix);
    }

    /**
     * Sorts an array in descending order average value in columns
     *
     * @param matrix Matrix of integer
     * @param height Count elements in height
     * @param width  Count elements in width
     */
    public static void sortDecreasingByAverage(int[][] matrix, int height, int width) {
        long[] vectorAverage = createVectorAverage(matrix, height, width);

        for (int i = 0; i < width; i++) {
            for (int j = i; j < width; j++) {
                if (vectorAverage[i] < vectorAverage[j]) {
                    long temp = vectorAverage[j];
                    vectorAverage[j] = vectorAverage[i];
                    vectorAverage[i] = temp;
                    switchColumn(matrix, i, j);
                }
            }
        }
    }

    /**
     * Switching two column in matrix
     *
     * @param matrix       Matrix of integer
     * @param firstColumn  Number of first column
     * @param secondColumn Number of second column
     */
    public static void switchColumn(int[][] matrix, int firstColumn, int secondColumn) {
        for (int i = 0; i < matrix.length; i++) {
            int temp = matrix[i][firstColumn];
            matrix[i][firstColumn] = matrix[i][secondColumn];
            matrix[i][secondColumn] = temp;
        }
    }

    /**
     * Calculate average value in matrix column
     *
     * @param matrix Matrix of integer
     * @param height Count elements in height
     * @param width  Count elements in width
     * @return Vector of average value in matrix column
     */
    public static long[] createVectorAverage(int[][] matrix, int height, int width) {
        long[] vectorAverage = new long[width];
        for (int i = 0; i < width; i++) {
            int[] vector = new int[matrix.length];
            for (int j = 0; j < height; j++) {
                vector[j] = matrix[j][i];
            }
            vectorAverage[i] = averageInVector(vector);
        }

        return vectorAverage;
    }

    /**
     * Calculating average value in array
     *
     * @param vector Array of integer
     * @return Average value
     */
    public static long averageInVector(int[] vector) {
        int sum = 0;
        for (int number : vector) {
            sum += number;
        }
        return sum / vector.length;
    }

}