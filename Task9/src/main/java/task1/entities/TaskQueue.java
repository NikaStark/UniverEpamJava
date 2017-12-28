package task1.entities;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Alex Volochai
 */
public class TaskQueue {

    private Queue<Task> tasksQ = new LinkedList<>();

    public synchronized Task poll() {
        Task task = tasksQ.poll();
        return task;
    }

    public synchronized void add(Task task) {
        tasksQ.add(task);
    }

    public synchronized Queue<Task> getTasksQ() {
        return tasksQ;
    }

    public synchronized boolean isEmpty() {
        return tasksQ.isEmpty();
    }

    public synchronized int size() {
        return tasksQ.size();
    }

}
