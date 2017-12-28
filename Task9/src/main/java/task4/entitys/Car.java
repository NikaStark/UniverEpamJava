package task4.entitys;

/**
 * Class realized Car that came to the Car Station
 *
 * @author Alex Volochai
 */
public class Car implements Runnable{
    /**
     * Who create the Car (make)
     */
    public String make;
    /**
     * Place that car can stay
     */
    Place p;

    public Car(String make, Place p) {
        this.make = make;
        this.p = p;
        new Thread(this).start();
    }

    /**
     * Stay on the place for some time
     */
    @Override
    public void run() {
        if(!p.use) {
            p.use = true;
            System.out.println("Car " + make + " stay on place " + p.id);
            try {
                Thread.sleep(2000 + (int)(Math.random() * 3000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            p.use = false;
        } else {
            System.out.println("Car " + make + " alive place " + p.id);
        }
    }
}
