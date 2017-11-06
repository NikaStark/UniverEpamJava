import java.util.Scanner;

/**
 * A class for drawing a rectangle input values in console
 *
 * @author Alex Volochai
 */
public class Rectangle {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input height : ");
        int height = scanner.nextInt();

        System.out.print("Input width : ");
        int width = scanner.nextInt();

        drawRectangle(height, width);
    }

    /**
     * Simple method which draw a rectangle with in console
     * @param height Value height of rectangle
     * @param width Value width of rectangle
     */
    public static void drawRectangle(int height, int width) {
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
    }

}
