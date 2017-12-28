package task3.entities;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.assertTrue;

public class TournamentTest {

    public Queue<Monk> monks = new LinkedList<>();

    public static Queue<Monk> winners = new LinkedList<>();

    @Test
    public void testTournament() {
        for (int i = 0; i < 15; i++) {
            monks.add(Monk.create());
        }
        Monk monk = new Monk();
        monk.setName("TEST");
        monk.setEnergy(101);
        monk.setVillage("TEST");
        monks.add(monk);
        while (winners.size() != 1) {
            winners = Tournament.startTour(monks);
            monks = winners;
        }

        assertTrue((monks.peek()).equals(monk));
    }
}
