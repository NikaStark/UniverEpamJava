package task3;

import task3.entities.Monk;
import task3.entities.Tournament;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alex Volochai
 */
public class Main {

    public static final int COUNT_MONKS = 16;

    public static Queue<Monk> monks = new LinkedList<>();

    public static Queue<Monk> winners = new LinkedList<>();

    public static void main(String args[]) {
        for (int i = 0; i < COUNT_MONKS; i++) {
            monks.add(Monk.create());
        }
        while (winners.size() != 1) {
            winners = Tournament.startTour(monks);
            monks = winners;
            System.out.println();
        }
        System.out.println("Winner of the Tournament is " + winners.peek().toString());
    }

}
