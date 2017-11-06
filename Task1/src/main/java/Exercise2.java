import java.util.Scanner;

/**
 * В одномерном массиве сначала положительные потом отрицательные за О(n)
 *
 * @author Alex Volochai
 */
public class Exercise2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input length : ");
        int length = scanner.nextInt();

        int[] vector = Util.generatedVector(length);
        Util.printString("Initial vector");
        Util.printVector(vector);
        System.out.println();

        splitVector(vector);

        Util.printString("Split vector");
        Util.printVector(vector);
    }

    /**
     * Method split array of integer to two parts by "O(n)" difficult
     * @param vector Array of integer which need to to split
     */
    public static void splitVector(int[] vector) {
        int i = 0;
        int j = vector.length - 1;

        while (i != j) {
            if (vector[i] < 0) {
                while (vector[j] < 0) {
                    j--;
                    if (j == i) return;
                }
                int temp = vector[i];
                vector[i] = vector[j];
                vector[j] = temp;
            }
            i++;
        }
    }

}
