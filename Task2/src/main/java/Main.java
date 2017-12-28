import controller.VehicleController;
import entities.CVehicle;
import view.ConsoleView;

/**
 * @author Alex Volochai
 */
public class Main {

    public static void main(String[] args) {
        ConsoleView.printMenu();
        System.out.println();
        int number = ConsoleView.chooseTask();

        CVehicle[] vehicles = Util.generatedVehicle(10);
        ConsoleView.printVehicle(vehicles);
        System.out.println();

        switch (number) {
            case 1:
                System.out.println(VehicleController.task1(vehicles));
                break;
            case 2:
                ConsoleView.printResult(VehicleController.task2(vehicles));
                break;
            case 3:
                ConsoleView.printResult(VehicleController.task3(vehicles));
                break;
            case 4:
                ConsoleView.printResult(VehicleController.task4(vehicles));
                break;
            default:
                System.out.println("Wrong argument!");
        }
    }

}
