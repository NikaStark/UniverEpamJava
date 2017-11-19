package controller;

import model.Figure;
import model.impl.Line;
import model.impl.Point;
import model.impl.Polygon;
import model.impl.Triangle;
import org.junit.Test;
import util.factories.ColorFigureFactory;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class FigureControllerTest {

    @Test
    public void testSplitFigures() throws Exception {
        Figure[] figures = ColorFigureFactory.getInstance().getFigures(100);

        Figure[][] expectedSplitFigures = FigureController.splitFigures(figures);

        for (Figure[] sameFigures : expectedSplitFigures) {
            if (sameFigures[0] != null) {
                for (int i = 1; i < sameFigures.length; i++) {
                    if (sameFigures[i] == null) continue;
                    if (sameFigures[0].getClass() != sameFigures[i].getClass()) fail();
                }
            }
        }
    }

    @Test
    public void testCountPoints() throws Exception {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(1, 2);
        Point point3 = new Point(1, 3);
        Integer expectedResult = 3;

        Map<String, Integer> map = FigureController.countFigures(new Point[]{point1, point2, point3});
        Integer actualResult = map.get("Points");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountLines() throws Exception {
        Line line1 = new Line(new Point(1, 1), new Point(1, 2));
        Line line2 = new Line(new Point(2, 1), new Point(2, 2));
        Integer expectedResult = 2;

        Map<String, Integer> map = FigureController.countFigures(new Line[]{line1, line2});
        Integer actualResult = map.get("Lines");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountTriangles() throws Exception {
        Triangle triangle1 = new Triangle(new Point(1, 1), new Point(1, 2), new Point(0, 3));
        Triangle triangle2 = new Triangle(new Point(2, 1), new Point(2, 2), new Point(0, 3));
        Integer expectedResult = 2;

        Map<String, Integer> map = FigureController.countFigures(new Triangle[]{triangle1, triangle2});
        Integer actualResult = map.get("Triangles");

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCountPolygons() throws Exception {
        Polygon polygon = new Polygon(new Point[]{new Point(1, 1), new Point(-1, 1), new Point(-1, -1), new Point(1, -1)});
        Integer expectedResult = 1;

        Map<String, Integer> map = FigureController.countFigures(new Polygon[]{polygon});
        Integer actualResult = map.get("Polygons");

        assertEquals(expectedResult, actualResult);
    }

}