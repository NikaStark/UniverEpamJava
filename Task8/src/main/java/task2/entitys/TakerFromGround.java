package task2.entitys;

import java.util.concurrent.Exchanger;

/**
 * Person will take the box from ground and put it to the car
 *
 * @author Alex Volochai
 */
public class TakerFromGround implements Runnable {

    private Exchanger<Integer> storageGround;

    private Exchanger<Integer> groundCounter;

    public TakerFromGround(Exchanger<Integer> storageGround, Exchanger<Integer> groundCounter) {
        this.storageGround = storageGround;
        this.groundCounter = groundCounter;
        Thread thread = new Thread(this, "Taker From A Ground And Put into Car");
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Putting the box to the car
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 100));
                groundCounter.exchange(storageGround.exchange(null));
                System.out.println("Took from a ground");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
