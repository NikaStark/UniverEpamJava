import java.util.Scanner;

/**
 * A class for drawing a isosceles triangle input values in console
 *
 * @author Alex Volochai
 */
public class RightTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input length : ");
        int length = scanner.nextInt();

        rightTriangle(length);
    }

    /**
     * Simple method which draw a isosceles triangle with in console
     * @param height Value side of isosceles triangle
     */
    public static void rightTriangle(int height) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
                System.out.print(" ");
            }
            System.out.print("\n");
        }
    }

}
