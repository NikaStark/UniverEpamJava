import java.lang.String;import java.lang.System;import java.util.Scanner;

/**
 * A class for drawing a equilateral triangle with input value
 *
 * @author Alex Volochai
 */
public class Rhombus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input length : ");
        int length = scanner.nextInt();

        drawRhombus(length);
    }

    /**
     * Simple method which draw a rhombus in console
     * @param length Value side of rhombus
     */
    public static void drawRhombus(int length) {
        //Draw upper triangle
        for (int i = 1; i <= length - 1; i++) {
            for (int counterSpace = length - i; counterSpace > 0; counterSpace--) {
                System.out.print(" ");
                System.out.print(" ");
            }

            for (int counterStars = 0; counterStars < i; counterStars++) {
                drawDiamond();
            }

            System.out.print("\n");
        }

        //Draw center
        for (int i = 1; i <= length; i++) {
            drawDiamond();
        }
        System.out.print("\n");

        //Draw lower triangle
        for (int i = 1; i <= length - 1; i++) {
            for (int counterSpace = 0; counterSpace < i; counterSpace++) {
                System.out.print(" ");
                System.out.print(" ");
            }

            for (int counterStars = length-i; counterStars > 0; counterStars--) {
                drawDiamond();
            }

            System.out.print("\n");
        }
    }

    public static void drawDiamond() {
        System.out.print("* ");
        System.out.print(" ");
        System.out.print(" ");
    }

}
