package task3.entities;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alex Volochai
 */
public class Tournament {

    public static int tourId = 0;

    public static Queue<Monk> startTour(Queue<Monk> monks) {
        Queue<Monk> winners = new LinkedList<>();
        tourId++;
        System.out.println("Fight № " + tourId + " starts");
        while (monks.size() > 0) {
            try {
                Monk monk1 = monks.poll();
                Monk monk2 = monks.poll();
                System.out.println(monk1.getName() + " : " + monk2.getName());
                new Fight(monk1, monk2, winners).join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("count of winners = " + winners.size());
        return winners;
    }

}
