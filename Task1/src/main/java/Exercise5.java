import java.util.Scanner;

/**
 * @author Alex Volochai
 */
public class Exercise5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input length : ");
        int length = scanner.nextInt();

        int[][] matrix = Util.generatedSquareMatrix(length);
        Util.printString("Initial matrix");
        Util.printMatrix(matrix);
        System.out.println();

        Util.printString("Vector");
        Util.printVector(printMatrixInVector(matrix));
    }

    /**
     * Rewrites the matrix in a vector clockwise
     *
     * @param matrix Matrix of integer
     * @return Array of integer
     */
    public static int[] printMatrixInVector(int[][] matrix) {
        int vectorCount = 0;
        int[] resultVector = new int[matrix.length * matrix.length];
        int maxCountCircles = (int) Math.ceil((matrix.length * 2 - 1) / 2); //Count of same circles

        for (int counterCircles = 0; counterCircles < maxCountCircles; counterCircles++) {
            //Cycle by up side
            for (int i = counterCircles; i < matrix.length - counterCircles; i++) {
                resultVector[vectorCount++] = matrix[counterCircles][i];
            }
            //Cycle by right side
            for (int i = counterCircles + 1; i < matrix.length - counterCircles; i++) {
                resultVector[vectorCount++] = matrix[i][matrix.length - counterCircles - 1];
            }
            //Cycle by down side
            for (int i = matrix.length - counterCircles - 1 - 1; i >= counterCircles; i--) {
                resultVector[vectorCount++] = matrix[matrix.length - counterCircles - 1][i];
            }
            //Cycle by left side
            for (int i = matrix.length - counterCircles - 1 - 1; i > counterCircles; i--) {
                resultVector[vectorCount++] = matrix[i][counterCircles];
            }
        }
        return resultVector;
    }

}
