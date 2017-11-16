import model.Figure;
import model.impl.Line;
import model.impl.Point;
import model.impl.Polygon;
import model.impl.Triangle;

import java.util.Random;

public class Util {

    public static final int MIN_X = -100;

    public static final int MAX_X = 100;

    public static final int MIN_Y = -100;

    public static final int MAX_Y = 100;

    public static final int MAX_COUNT_POINT_IN_POLYGON = 100;

    public static Figure[] generatedVehicle(int count) {
        Random random = new Random();
        Figure[] figures = new Figure[count];
        for (int i = 0; i < count; i++) {
            figures[i] = randomFigure(random.nextInt(4));
        }
        return figures;
    }

    public static Figure randomFigure(int key) {
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
            default:
                throw new IllegalArgumentException();
        }
    }

}
