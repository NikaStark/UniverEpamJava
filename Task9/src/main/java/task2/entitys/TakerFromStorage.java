package task2.entitys;

import java.util.concurrent.Exchanger;

/**
 * Person will take the box from warehouse
 *
 * @author Alex Volochai
 */
public class TakerFromStorage implements Runnable {

    private Exchanger<Integer> storageGround;

    public TakerFromStorage(Exchanger<Integer> storageGround) {
        this.storageGround = storageGround;
        Thread thread = new Thread(this, "Taker From Storage");
        thread.setDaemon(true);
        thread.start();
    }

    /**
     * Take the box from warehouse
     * And putting box on the ground
     */
    @Override
    public void run() {
        int i = 10;
        while (true) {
            try {
                Thread.sleep((int) (Math.random() * 100));
                storageGround.exchange(i + (int) (Math.random() * 10));
                System.out.println("Put on a ground");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
