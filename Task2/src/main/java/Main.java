import entities.CVehicle;
import entities.impl.CPlane;
import entities.interfaces.Flyable;
import entities.interfaces.Moveable;
import entities.interfaces.Swimable;

import java.util.Scanner;

/**
 * Создать абстрактный класс CVehicle. На его основе реализовать классы CPlane, CCar, CShip.
 * Классы должны иметь возмлжность задавать и получать координаты, параметры средств передвижения (цена, скорость, год выпуска).
 * Для самолетаа должна быть определена высота, для самолета и корабля - количество пасажиров. Для корабля - порт приписки.
 * <p>
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
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Less five years and min price and max speed");
        System.out.println("2. Plane height > 5000, issue year > 2000");
        System.out.println("3.  Not plan 200 < speed < 500");
        System.out.println("4. Split by interface");
        System.out.println();
        System.out.print("Input number task : ");
        int number = scanner.nextInt();

        CVehicle[] vehicles = Util.generatedVehicle(100);
        Util.printVehicle(vehicles);
        System.out.println();
        switch (number) {
            case 1:
                System.out.println(task1(vehicles));
                break;
            case 2:
                Util.printVehicle(task2(vehicles));
                break;
            case 3:
                Util.printVehicle(task3(vehicles));
                break;
            case 4:
                for (int i = 0; i < 3; i++) {
                    Util.printVehicle(task4(vehicles)[i]);
                }
                break;
        }
    }

    public static CVehicle task1(CVehicle[] vehicles) {
        CVehicle vehicle = null;
        for (CVehicle currentVehicle : vehicles) {
            if (2017 - currentVehicle.getIssueYear() < 5) {
                if (vehicle != null) {
                    if ((currentVehicle.getPrice() < vehicle.getPrice()) &&
                            (currentVehicle.getSpeed() > vehicle.getSpeed())) {
                        vehicle = currentVehicle;
                    }
                } else {
                    vehicle = currentVehicle;
                }
            }
        }
        return vehicle;
    }

    public static CVehicle[] task2(CVehicle[] vehicles) {
        int i = 0;
        CVehicle[] rightVehicle = new CVehicle[vehicles.length];
        for (CVehicle currentVehicle : vehicles) {
            if ("Plane".equals(currentVehicle.getClass().getName())) {
                if (((CPlane) currentVehicle).getHeight() > 5000) {
                    if (currentVehicle.getIssueYear() > 2000) {
                        rightVehicle[i++] = currentVehicle;
                    }
                }
            }
        }
        return rightVehicle;
    }

    public static CVehicle[] task3(CVehicle[] vehicles) {
        int i = 0;
        CVehicle[] rightVehicle = new CVehicle[vehicles.length];
        for (CVehicle currentVehicle : vehicles) {
            if (!"Plane".equals(currentVehicle.getClass().getName())) {
                if (currentVehicle.getSpeed() > 200) {
                    if (currentVehicle.getSpeed() < 500) {
                        rightVehicle[i++] = currentVehicle;
                    }
                }
            }
        }
        return rightVehicle;
    }

    public static CVehicle[][] task4(CVehicle[] vehicles) {
        int i = 0, j = 0, k = 0;
        CVehicle[][] splitVehicle = new CVehicle[3][vehicles.length];
        for (CVehicle currentVehicle : vehicles) {
            if (currentVehicle instanceof Moveable) {
                splitVehicle[0][i++] = currentVehicle;
            }
            if (currentVehicle instanceof Swimable) {
                splitVehicle[1][j++] = currentVehicle;
            }
            if (currentVehicle instanceof Flyable) {
                splitVehicle[2][k++] = currentVehicle;
            }
        }
        return splitVehicle;
    }

}
