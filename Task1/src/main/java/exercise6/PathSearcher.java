package exercise6;

import java.util.Stack;

/**
 * Class which searching path in a maze
 *
 * @author Alex Volochai
 */
public class PathSearcher {

    private Maze maze;

    private Stack<Point> path;

    public PathSearcher(Maze maze) {
        this.maze = maze;
        path = new Stack<>();
        path.push(maze.getUserPoint());
    }

    public Stack<Point> getPath() {
        search();
        return path;
    }

    /**
     * Searching path in maze
     */
    private void search() {
        while (true) {
            if (maze.getUserPoint().getI() == maze.getMaze().length - 2 &&
                    maze.getUserPoint().getJ() == maze.getMaze()[0].length - 2) {
                break;
            } else if (canGoDown()) {
                goDown();
            } else if (canGoRight()) {
                goRight();
            } else if (canGoUp()) {
                goUp();
            } else if (canGoLeft()) {
                goLeft();
            } else {
                maze.setUserPoint(path.pop());
            }
        }
    }

    /**
     * Check user can move down
     *
     * @return true or false
     */
    private boolean canGoDown() {
        Point newUserPoint = new Point(maze.getUserPoint().getI() + 1, maze.getUserPoint().getJ());
        if (maze.getMaze()[newUserPoint.getI()][newUserPoint.getJ()] != Maze.WALL)
            if (maze.getMaze()[newUserPoint.getI()][newUserPoint.getJ()] != Maze.USER)
                if (!path.contains(newUserPoint)) return true;
        return false;

    }

    /**
     * Check user can move right
     *
     * @return true or false
     */
    private boolean canGoRight() {
        Point newUserPoint = new Point(maze.getUserPoint().getI(), maze.getUserPoint().getJ() + 1);
        if (maze.getMaze()[newUserPoint.getI()][newUserPoint.getJ()] != Maze.WALL)
            if (maze.getMaze()[newUserPoint.getI()][newUserPoint.getJ()] != Maze.USER)
                if (!path.contains(newUserPoint)) return true;
        return false;
    }

    /**
     * Check user can move up
     *
     * @return true or false
     */
    private boolean canGoUp() {
        Point newUserPoint = new Point(maze.getUserPoint().getI() - 1, maze.getUserPoint().getJ());
        if (maze.getMaze()[newUserPoint.getI()][newUserPoint.getJ()] != Maze.WALL)
            if (maze.getMaze()[newUserPoint.getI()][newUserPoint.getJ()] != Maze.USER)
                if (!path.contains(newUserPoint)) return true;
        return false;

    }

    /**
     * Check user can move left
     *
     * @return true or false
     */
    private boolean canGoLeft() {
        Point newUserPoint = new Point(maze.getUserPoint().getI(), maze.getUserPoint().getJ() - 1);
        if (maze.getMaze()[newUserPoint.getI()][newUserPoint.getJ()] != Maze.WALL)
            if (maze.getMaze()[newUserPoint.getI()][newUserPoint.getJ()] != Maze.USER)
                if (!path.contains(newUserPoint)) return true;
        return false;
    }

    /**
     * Saving move to path and mark new cell as userPoint
     *
     * @param newUserPoint Point which add to path
     */
    private void paveMove(Point newUserPoint) {
        path.push(newUserPoint);
        maze.getMaze()[newUserPoint.getI()][newUserPoint.getJ()] = Maze.USER;
        maze.setUserPoint(newUserPoint);
    }

    /**
     * Move down for one step
     */
    private void goDown() {
        Point newUserPoint = new Point(maze.getUserPoint().getI() + 1, maze.getUserPoint().getJ());
        paveMove(newUserPoint);
    }

    /**
     * Move right for one step
     */
    private void goRight() {
        Point newUserPoint = new Point(maze.getUserPoint().getI(), maze.getUserPoint().getJ() + 1);
        paveMove(newUserPoint);
    }

    /**
     * Move up for one step
     */
    private void goUp() {
        Point newUserPoint = new Point(maze.getUserPoint().getI() - 1, maze.getUserPoint().getJ());
        paveMove(newUserPoint);
    }

    /**
     * Move left for one step
     */
    private void goLeft() {
        Point newUserPoint = new Point(maze.getUserPoint().getI(), maze.getUserPoint().getJ() - 1);
        paveMove(newUserPoint);
    }

}
