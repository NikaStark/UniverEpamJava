package exercise6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

/**
 * Class for saving inner state of maze and generate him
 *
 * @author Alex Volochai
 */
public class Maze {

    /**
     * Const for cell
     */
    public static final char CELL = ' ';
    /**
     * Const for wall
     */
    public static final char WALL = 'X';
    /**
     * Const for user
     */
    public static final char USER = 'U';

    /**
     * Const for visited point
     */
    public static final char VISITED = 'V';

    /**
     * Array for saving maze
     */
    private char[][] maze;

    /**
     * Point where user are now
     */
    private Point userPoint;

    public Maze(char[][] maze, Point userPoint) {
        this.maze = maze;
        this.userPoint = userPoint;
    }

    public Maze(int height, int weight) {
        maze = new char[height][weight];
        createMaze();
    }

    /**
     * Printing maze in console
     */
    public void printMaze() {
        for (char[] row : maze) {
            for (char symbol : row) {
                System.out.printf("%2c", symbol);
            }
            System.out.println();
        }
    }

    public Point getUserPoint() {
        return this.userPoint;
    }

    public void setUserPoint(Point userPoint) {
        this.userPoint = userPoint;
    }

    public char[][] getMaze() {
        return maze;
    }

    /**
     * Prepared maze, marking user, entrance and exit
     */
    private void createMaze() {
        generate();
        userPoint = new Point(1, 1);
        maze[1][1] = USER;
        maze[0][1] = CELL;
        maze[maze.length - 1][maze[0].length - 2] = CELL;
    }

    private void generate() {
        generateGrid();
        generateWays();
        clean();
    }

    /**
     * Generate grid in paired cells
     */
    private void generateGrid() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                maze[i][j] = i % 2 != 0 && j % 2 != 0 ? CELL : WALL;
            }
        }
    }

    /**
     * Generate ways after generateGrid(), without loops
     */
    private void generateWays() {
        Stack<Point> way = new Stack<>();
        way.push(new Point(1, 1));
        maze[1][1] = VISITED;
        Point previousPoint;
        Random random = new Random();
        List<Point> neighbours;

        while (!way.empty()) {
            neighbours = getUnvisitedNeighbours(way);
            if (!neighbours.isEmpty()) {
                previousPoint = way.peek();
                way.push(neighbours.get(neighbours.size() > 1 ? random.nextInt(neighbours.size()) : 0));  //TODO Ask what is cheaper and maybe refactor
                maze[way.peek().getI()][way.peek().getJ()] = VISITED;
                removeWall(previousPoint, way.peek());
            } else {
                way.pop();
            }
        }
    }

    /**
     * Searching unvisited neighbours cells around last cell in a way
     *
     * @param way Stack which saving points in way
     * @return List of neighbours, unvisited cells
     */
    private List<Point> getUnvisitedNeighbours(Stack<Point> way) {
        List<Point> neighbours = new ArrayList<>(4);
        Point currentPoint = way.peek();
        Point neighbourPoint;
        //Up neighbour
        neighbourPoint = new Point(currentPoint.getI() - 2, currentPoint.getJ());
        if (neighbourPoint.getI() > 0 && maze[neighbourPoint.getI()][neighbourPoint.getJ()] != VISITED && !way.contains(neighbourPoint)) {
            neighbours.add(neighbourPoint);
        }
        //Right neighbour
        neighbourPoint = new Point(currentPoint.getI(), currentPoint.getJ() + 2);
        if (neighbourPoint.getJ() < maze[0].length && maze[neighbourPoint.getI()][neighbourPoint.getJ()] != VISITED && !way.contains(neighbourPoint)) {
            neighbours.add(neighbourPoint);
        }
        //Down neighbour
        neighbourPoint = new Point(currentPoint.getI() + 2, currentPoint.getJ());
        if (neighbourPoint.getI() < maze.length && maze[neighbourPoint.getI()][neighbourPoint.getJ()] != VISITED && !way.contains(neighbourPoint)) {
            neighbours.add(neighbourPoint);
        }
        //Left neighbour
        neighbourPoint = new Point(currentPoint.getI(), currentPoint.getJ() - 2);
        if (neighbourPoint.getJ() > 0 && maze[neighbourPoint.getI()][neighbourPoint.getJ()] != VISITED && !way.contains(neighbourPoint)) {
            neighbours.add(neighbourPoint);
        }
        return neighbours;
    }

    /**
     * Replace "wall" in cell to empty cell
     *
     * @param previousPoint previous point in way
     * @param presentPoint  current point
     */
    private void removeWall(Point previousPoint, Point presentPoint) {
        if (previousPoint.getI() == presentPoint.getI()) {
            maze[presentPoint.getI()][presentPoint.getJ() + (presentPoint.getJ() > previousPoint.getJ() ? -1 : 1)] = CELL;
        } else { //TODO Ask need to check second if
            maze[presentPoint.getI() + (presentPoint.getI() > previousPoint.getI() ? -1 : 1)][presentPoint.getJ()] = CELL;
        }
    }

    /**
     * Remove visiting marks after generateWays()
     */
    private void clean() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == VISITED) {
                    maze[i][j] = CELL;
                }
            }
        }
    }

}
