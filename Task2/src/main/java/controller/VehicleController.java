package controller;

import entities.CVehicle;
import entities.impl.CPlane;
import entities.interfaces.Flyable;
import entities.interfaces.Moveable;
import entities.interfaces.Swimable;

/**
 * Class for selecting the right vehicles
 *
 * @author Alex
 */
public class VehicleController {

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
            if ("CPlane".equals(currentVehicle.getClass().getSimpleName())) {
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
            if (!"CPlane".equals(currentVehicle.getClass().getSimpleName())) {
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
            } else if (currentVehicle instanceof Swimable) {
                splitVehicle[1][j++] = currentVehicle;
            } else if (currentVehicle instanceof Flyable) {
                splitVehicle[2][k++] = currentVehicle;
            }
        }
        return splitVehicle;
    }

}
