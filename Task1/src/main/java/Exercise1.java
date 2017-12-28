import java.util.Scanner;

/**
 * @author Alex Volochai
 */
public class Exercise1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input length : ");
        int length = scanner.nextInt();

        int[] vector = Util.generatedVector(length);
        Util.printString("Initial vector");
        Util.printVector(vector);
        System.out.println();

        sortAscendingOnSegment(vector, 0, vector.length);
        int i = 0;
        while (vector[i] < 0) i++;
        sortDecreasingOnSegment(vector, i, vector.length);

        Util.printString("Sort vector");
        Util.printVector(vector);
    }

    /**
     * Sorts an array in ascending order on a segment
     *
     * @param vector       Array of integer which been sorted
     * @param firstElement Element from which starts sorting
     * @param lastElement  Element to which sorting
     */
    public static void sortAscendingOnSegment(int[] vector, int firstElement, int lastElement) {
        for (int i = firstElement; i < lastElement; i++) {
            for (int j = i; j < lastElement; j++) {
                if (vector[i] > vector[j]) {
                    int temp = vector[j];
                    vector[j] = vector[i];
                    vector[i] = temp;
                }
            }
        }
    }

    /**
     * Sorts an array in descending order on a segment
     *
     * @param vector       Array of integer which been sorted
     * @param firstElement Element from which starts sorting
     * @param lastElement  Element to which sorting
     */
    public static void sortDecreasingOnSegment(int[] vector, int firstElement, int lastElement) {
        for (int i = firstElement; i < lastElement; i++) {
            for (int j = i; j < lastElement; j++) {
                if (vector[i] < vector[j]) {
                    int temp = vector[j];
                    vector[j] = vector[i];
                    vector[i] = temp;
                }
            }
        }
    }

}
