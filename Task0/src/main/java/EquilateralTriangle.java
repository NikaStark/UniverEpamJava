import java.util.Scanner;

/**
 * A class for drawing a equilateral triangle with input value
 *
 * @author Alex Volochai
 */
public class EquilateralTriangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input length : ");
        int length = scanner.nextInt();

        drawEquilateralTriangle(length);
    }

    /**
     * Simple method which draw a equilateral triangle in console
     * @param length Value side of equilateral triangle
     */
    public static void drawEquilateralTriangle(int length) {
        for (int i = 1; i <= length; i++) {
            for (int counterSpace = length - i; counterSpace > 0; counterSpace--) {
                System.out.print(" ");
                System.out.print(" ");
            }

            for (int counterStars = 0; counterStars < i; counterStars++) {
                System.out.print("* ");
                System.out.print(" ");
                System.out.print(" ");
            }

            System.out.print("\n");
        }
    }

}
