import controller.VehicleController;
import entities.CVehicle;
import view.ConsoleView;

/**
 * Создать абстрактный класс CVehicle. На его основе реализовать классы CPlane, CCar, CShip.
 * Классы должны иметь возмлжность задавать и получать координаты, параметры средств передвижения (цена, скорость, год выпуска).
 * Для самолетаа должна быть определена высота, для самолета и корабля - количество пасажиров. Для корабля - порт приписки.
 *
 * Написать программу, создающую список объектов этих классов в динамической памяти.
 * Программа должна содержать меню, позволяющее осуществить проверку всех методов класов.
 * Методы:
 * 1. механизм с наименьшей ценой, с наибольшей скоростью и не старше 5 лет
 * 2. найти из механизмов Plane c высотой полета выше 5000 с годом выпуска после 2000
 * 3. найти механизмы с максимальной скоростью в диапазоне 200 - 500, но не Plane
 * 4. добавить к данной иерархии машину-амфибию, и БетМобиль, создать 3 масива сгупированых по Интерфейсам Flyable, MoveAble, SwimAble
 *
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
