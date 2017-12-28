package task2.entitys;


import java.util.concurrent.Exchanger;

/**
 * Person will count sum of price all boxes
 *
 * @author Alex Volochai
 */
public class Counter implements Runnable {

    public static int allPrice = 0;

    private Exchanger<Integer> groundCounter;

    public Counter(Exchanger<Integer> groundCounter) {
        this.groundCounter = groundCounter;
        new Thread(this, "Counter ").start();
    }

    /**
     * Adding price of the box to all sum
     */
    @Override
    public void run() {
        while (allPrice < 1000) {
            try {
                Thread.sleep((int) (Math.random() * 100));
                allPrice += groundCounter.exchange(null);
                System.out.println("Put into car");
                System.out.println("Add to all cost = " + allPrice);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
