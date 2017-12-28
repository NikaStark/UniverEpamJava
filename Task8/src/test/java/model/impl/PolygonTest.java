package model.impl;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Alex Volochai
 */
public class PolygonTest {

    private Polygon polygon;

    private Point a;

    private Point b;

    private Point c;

    @Before
    public void setUp() throws Exception {
        this.a = new Point(0, 0);
        this.b = new Point(8, 2);
        this.c = new Point(-2, 6);
        Point d = new Point(-1, 0);
        this.polygon = new Polygon(new Point[]{a, b, c, d});

    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetPointsNotCorrect() throws Exception {
        Point newD = new Point(-1, 3);

        polygon.setPoints(new Point[]{a, b, c, newD});
    }

    @Test
    public void testSetPointsCorrect() throws Exception {
        Point newD = new Point(1, 2);

        polygon.setPoints(new Point[]{a, b, c, newD});
    }

}