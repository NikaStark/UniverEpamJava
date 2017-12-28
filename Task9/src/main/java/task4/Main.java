package task4;

import task4.entitys.Car;
import task4.entitys.Place;

/**
 * @author Alex Volochai
 */
public class Main {
    /**
     * Create new place (1)
     */
    static Place p1 = new Place(1);
    /**
     * Create new place (2)
     */
    static Place p2 = new Place(2);
    /**
     * Create new place (3)
     */
    static Place p3 = new Place(3);

    public static void main(String[] args) throws InterruptedException {
        /**
         * Create new Car per 0.5s
         * And find the place for one
         * If has no place car wait for 0.5s
         * And if no free place after 0.5s waiting - car alive the car station
         */
        int i = 1;
        while(true) {
            Thread.sleep(500);
            int t = 1;
            boolean hasPlace = false;
            while(t<500) {
                if (!p1.use) {
                    new Car("c" + i, p1);
                    i++;
                    hasPlace = true;
                    break;
                } else if (!p2.use) {
                    new Car("c" + i, p2);
                    i++;
                    hasPlace = true;
                    break;
                } else if (!p3.use) {
                    new Car("c" + i, p3);
                    i++;
                    hasPlace = true;
                    break;
                }
                Thread.sleep(100);
                t += 100;
            }
            if(!hasPlace) {
                System.out.println("Car c" + i + " alive station");
                i++;
            }
        }
    }
}

