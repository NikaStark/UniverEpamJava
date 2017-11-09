import entities.CVehicle;
import entities.impl.*;

import java.util.Random;

/**
 * Utility class for generate entity
 *
 * @author Alex Volochai
 */
public class Util {

    public static final int MIN_CAR_PRICE = 10;

    public static final int MAX_CAR_PRICE = 1_000;

    public static final int MIN_SHIP_PRICE = 100;

    public static final int MAX_SHIP_PRICE = 10_000;

    public static final int MIN_PLANE_PRICE = 1_000;

    public static final int MAX_PLANE_PRICE = 100_000;

    public static final int MAX_PLANE_HEIGHT = 10_000;

    public static final int MAX_SPEED = 500;

    public static final int MIN_ISSUE_YEAR = 1950;

    public static final int MAX_ISSUE_YEAR = 2017;

    public static final int MAX_PASSENGERS = 100_000;

    public static void printVehicle(CVehicle[] vehicles) {
        for (CVehicle vehicle : vehicles) {
            if (vehicle != null){
                System.out.println(vehicle.toString());
            }
        }
    }

    public static CVehicle[] generatedVehicle(int count) {
        Random random = new Random();
        CVehicle[] vehicles = new CVehicle[count];
        for (int i = 0; i < count; i++) {
            vehicles[i] = randomVehicle(random.nextInt(5));
        }
        return vehicles;
    }

    public static CVehicle randomVehicle(int key) {
        Random random = new Random();
        switch (key + 1) {
            case 1:
                return new CCar(
                        random.nextInt(MAX_CAR_PRICE - MIN_CAR_PRICE) + MIN_CAR_PRICE,
                        random.nextInt(MAX_SPEED),
                        random.nextInt(MAX_ISSUE_YEAR - MIN_ISSUE_YEAR) + MIN_ISSUE_YEAR
                );
            case 2:
                return new CShip(
                        random.nextInt(MAX_SHIP_PRICE - MIN_SHIP_PRICE) + MIN_SHIP_PRICE,
                        random.nextInt(MAX_SPEED),
                        random.nextInt(MAX_ISSUE_YEAR - MIN_ISSUE_YEAR) + MIN_ISSUE_YEAR,
                        random.nextInt(MAX_PASSENGERS),
                        "port" + random.nextInt(MIN_ISSUE_YEAR)
                );
            case 3:
                return new CPlane(
                        random.nextInt(MAX_PLANE_PRICE - MIN_PLANE_PRICE) + MIN_PLANE_PRICE,
                        random.nextInt(MAX_SPEED),
                        random.nextInt(MAX_ISSUE_YEAR - MIN_ISSUE_YEAR) + MIN_ISSUE_YEAR,
                        random.nextInt(MAX_PASSENGERS),
                        random.nextInt(MAX_PLANE_HEIGHT)
                );
            case 4:
                CVehicle batCar = randomVehicle(1);
                return new BatCar(batCar.getPrice(), batCar.getSpeed(), batCar.getIssueYear());
            case 5:
                CVehicle ampCar = randomVehicle(1);
                return new AmphibianCar(ampCar.getPrice(), ampCar.getSpeed(), ampCar.getIssueYear());
            default: return null;
        }
    }

}
