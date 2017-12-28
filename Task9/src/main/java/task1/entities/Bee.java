package task1.entities;

import task1.Main;

import java.util.concurrent.TimeUnit;

/**
 * @author Alex Volochai
 */
public class Bee extends Thread {

    private String name;
    private TaskQueue tasks;

    public Bee(int id, TaskQueue tasks) {
        this.name = "Bee #" + id;
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        while (!tasks.isEmpty() && !Main.found) {
            Task currentTask = tasks.poll();
            if (currentTask != null) {
                int taskData[] = currentTask.getTaskData();
                for (int i = 0; i < currentTask.getTaskData().length; i++) {
                    if (taskData[i] == 1) {
                        Main.row = currentTask.getTaskIndex();
                        Main.column = i;
                        Main.found = true;
                        return;
                    }
                }

            }
        }
    }
}
