package util.factories;

import model.Figure;
import model.impl.*;

import java.util.Random;

/**
 * @author Alex Volochai
 */
public abstract class AbstractFigureFactory {

    public static final int MIN_X = -100;

    public static final int MAX_X = 100;

    public static final int MIN_Y = -100;

    public static final int MAX_Y = 100;

    public static final int MAX_COUNT_POINT_IN_POLYGON = 10;

    public static final int MAX_COLOR = 10_000;

    public abstract Figure getFigure();

    /**
     * Method which create array of new figures
     *
     * @param count Count of figures you need
     * @return Array of create figures
     */
    public Figure[] getFigures(int count) {
        Figure[] figures = new Figure[count];
        for (int i = 0; i < figures.length; i++) {
            figures[i] = getFigure();
        }
        return figures;
    }

    /**
     * Method which create new figure
     *
     * @param key switch for different figures
     * @return New generate figure
     */
    protected Figure getFigure(int key) {
        Random random = new Random();
        try {
            switch (key) {
                case 0:
                    return new Point(
                            random.nextInt(Math.abs(MAX_X) + Math.abs(MIN_X) - Math.abs(MIN_X)),
                            random.nextInt(Math.abs(MAX_Y) + Math.abs(MIN_Y) - Math.abs(MIN_Y))
                    );
                case 1:
                    return new Line(
                            new Point((Point) getFigure(0)),
                            new Point((Point) getFigure(0))
                    );
                case 2:
                    return new Triangle(
                            new Point((Point) getFigure(0)),
                            new Point((Point) getFigure(0)),
                            new Point((Point) getFigure(0))
                    );
                case 3:
                    int count = random.nextInt(MAX_COUNT_POINT_IN_POLYGON);
                    Point[] points = new Point[count];
                    for (int i = 0; i < count; i++) {
                        points[i] = new Point((Point) getFigure(0));
                    }
                    return new Polygon(points);
                case 4:
                    return new ColorPoint((Point) getFigure(0), random.nextInt(MAX_COLOR));
                case 5:
                    return new ColorLine((Line) getFigure(1), random.nextInt(MAX_COLOR));
                case 6:
                    return new ColorTriangle((Triangle) getFigure(2), random.nextInt(MAX_COLOR));
                case 7:
                    return new ColorPolygon((Polygon) getFigure(3), random.nextInt(MAX_COLOR));
            }
        } catch (IllegalArgumentException e) {
            return getFigure(key);
        }
        throw new IllegalArgumentException();
    }

}
