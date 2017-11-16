import model.Figure;
import model.impl.*;

import java.util.Random;

/**
 * Utility class for generate entity
 *
 * @author Alex Volochai
 */
public class Util {

    public static final int MIN_X = -100;

    public static final int MAX_X = 100;

    public static final int MIN_Y = -100;

    public static final int MAX_Y = 100;

    public static final int MAX_COUNT_POINT_IN_POLYGON = 100;

    public static final int MAX_COLOR = 10_000;

    /**
     * Factory method which create array of figures
     *
     * @param count    Count of figures you need
     * @param colorful Flag which switching by color and single-color figures
     * @return Array of generate figures
     */
    public static Figure[] generatedFigure(int count, boolean colorful) {
        Random random = new Random();
        Figure[] figures = new Figure[count];
        for (int i = 0; i < count; i++) {
            figures[i] = randomFigure(random.nextInt(4) + (colorful ? 4 : 0));
        }
        return figures;
    }

    /**
     * Method which generate new figure
     *
     * @param key switch for different figures
     * @return New generate figure
     */
    private static Figure randomFigure(int key) {
        Random random = new Random();
        switch (key) {
            case 0:
                return new Point(
                        random.nextInt(Math.abs(MAX_X) + Math.abs(MIN_X) - Math.abs(MIN_X)),
                        random.nextInt(Math.abs(MAX_Y) + Math.abs(MIN_Y) - Math.abs(MIN_Y))
                );
            case 1:
                return new Line(
                        new Point((Point) randomFigure(0)),
                        new Point((Point) randomFigure(0))
                );
            case 2:
                return new Triangle(
                        new Point((Point) randomFigure(0)),
                        new Point((Point) randomFigure(0)),
                        new Point((Point) randomFigure(0))
                );
            case 3:
                int count = random.nextInt(MAX_COUNT_POINT_IN_POLYGON);
                Point[] points = new Point[count];
                for (int i = 0; i < count; i++) {
                    points[i] = new Point((Point) randomFigure(0));
                }
                return new Polygon(points);
            case 4:
                return new ColorPoint((Point) randomFigure(0), random.nextInt(MAX_COLOR));
            case 5:
                return new ColorLine((Line) randomFigure(1), random.nextInt(MAX_COLOR));
            case 6:
                return new ColorTriangle((Triangle) randomFigure(2), random.nextInt(MAX_COLOR));
            case 7:
                return new ColorPolygon((Polygon) randomFigure(3), random.nextInt(MAX_COLOR));
            default:
                throw new IllegalArgumentException();
        }
    }

}
