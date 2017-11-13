package view;

import entities.CVehicle;
import entities.interfaces.Flyable;
import entities.interfaces.Moveable;
import entities.interfaces.Swimable;

import java.util.Scanner;

/**
 * Class for display in console
 *
 * @author Alex
 */
public class ConsoleView {

    public static int chooseTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose number of task : ");
        return scanner.nextInt();
    }

    public static void printMenu() {
        System.out.println("1. Less five years and min price and max speed");
        System.out.println("2. Plane height > 5000, issue year > 2000");
        System.out.println("3. Not plan 200 < speed < 500");
        System.out.println("4. Split by interface");
    }

    public static void printVehicle(CVehicle[] vehicles) {
        for (CVehicle vehicle : vehicles) {
            if (vehicle != null) {
                String str = vehicle.toString();
                int splitIndex = str.indexOf("{");
                System.out.printf("%12s", str.substring(0, splitIndex));
                System.out.println(str.substring(splitIndex));
            }
        }
    }

    public static void printResult(CVehicle[] vehicles) {
        if (vehicles[0] == null) {
            System.out.println("Vehicles not found");
        } else {
            ConsoleView.printVehicle(vehicles);
        }
    }

    public static void printResult(CVehicle[][] SplitVehicles) {
        for (CVehicle[] vehicles : SplitVehicles) {
            if (vehicles[0] != null) {
                if (vehicles[0] instanceof Moveable) {
                    System.out.println("Moveable");
                } else if (vehicles[0] instanceof Swimable) {
                    System.out.println("Swimable");
                } else if (vehicles[0] instanceof Flyable) {
                    System.out.println("Flyable");
                }
                ConsoleView.printVehicle(vehicles);
                System.out.println();
            }
        }
    }

}
