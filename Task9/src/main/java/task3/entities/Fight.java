package task3.entities;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @author Alex Volochai
 */
public class Fight extends Thread {

    private Monk monk1;

    private Monk monk2;

    private Queue<Monk> winners = new LinkedList<>();

    public Fight(Monk monk1, Monk monk2, Queue<Monk> winners) {
        this.monk1 = monk1;
        this.monk2 = monk2;
        this.winners = winners;
        try {
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        start();
    }

    @Override
    public void run() {
        synchronized (winners) {
            winners.add(monk1.getEnergy() > monk2.getEnergy() ? monk1 : monk2);
        }
    }
}
