import java.util.Scanner;

/**
 * @author Alex Volochai
 */
public class Exercise4 {

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

        sortRowAscendingBySameElements(matrix);

        Util.printString("Sorted matrix");
        Util.printMatrix(matrix);
    }

    /**
     * Sorts an array in ascending order count same elements in rows
     *
     * @param matrix Matrix of integer
     */
    public static void sortRowAscendingBySameElements(int[][] matrix) {
        int[] vectorCounterSameElem = createVectorCounterSameElem(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                if (vectorCounterSameElem[i] > vectorCounterSameElem[j]) {
                    int temp = vectorCounterSameElem[j];
                    int[] tempVector = matrix[j];
                    vectorCounterSameElem[j] = vectorCounterSameElem[i];
                    matrix[j] = matrix[i];
                    vectorCounterSameElem[i] = temp;
                    matrix[i] = tempVector;
                }
            }
        }
    }

    /**
     * Calculate count same element in matrix row
     *
     * @param matrix Matrix of integer
     * @return Vector of count same element in matrix row
     */
    public static int[] createVectorCounterSameElem(int[][] matrix) {
        int[] vectorCounterSameElem = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            int counter = 0;
            int sameElement = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (sameElement == matrix[i][j]) {
                    counter++;
                } else {
                    if (counter > vectorCounterSameElem[i]) {
                        vectorCounterSameElem[i] = counter;
                    }
                    sameElement = matrix[i][j];
                    counter = 1;
                }
            }
        }
        return vectorCounterSameElem;
    }

}
