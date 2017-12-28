package task1;

import org.junit.Test;
import task1.entities.Bee;
import task1.entities.Forest;
import task1.entities.TaskQueue;

import static org.junit.Assert.assertEquals;

public class TaskBagTest {

    @Test
    public void testTaskBag(){
        final int SIZE = 10;
        final int BEES_COUNT = 10;
        int EXPECTED_ROW = 0;
        int EXPECTED_COLUMN = 0;
        Forest forest = new Forest(SIZE);
        TaskQueue taskQueue = forest.getTasks();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (forest.getForestMatrix()[i][j] == 1) {
                    EXPECTED_ROW = i;
                    EXPECTED_COLUMN = j;
                }
            }
        }
        assertEquals(SIZE, taskQueue.size());
        for(int i = 0; i < BEES_COUNT; i++){
            Main.beeQueue.add(new Bee(i, taskQueue));
            Main.beeQueue.get(i).start();
        }
        for (int i = 0; i < BEES_COUNT; i++) {
            try {
                Main.beeQueue.get(i).join();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        assertEquals(EXPECTED_ROW, Main.row);
        assertEquals(EXPECTED_COLUMN, Main.column);
    }
}
