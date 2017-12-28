package model.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Volochai
 */
public class LineTest {

    private Line line;

    @Before
    public void setUp() throws Exception {
        Point startPoint = new Point(1, 1);
        Point endPoint = new Point(1, -2);
        this.line = new Line(startPoint, endPoint);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetStartPointNotCorrect() throws Exception {
        Point newStartPoint = new Point(1, -2);

        line.setStartPoint(newStartPoint);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetEndPointNotCorrect() throws Exception {
        Point newEndPoint = new Point(1, 1);

        line.setEndPoint(newEndPoint);
    }

    @Test
    public void testSetStartPointCorrect() throws Exception {
        Point newStartPoint = new Point(3, 3);

        line.setStartPoint(newStartPoint);
    }

    @Test
    public void testSetEndPointCorrect() throws Exception {
        Point newEndPoint = new Point(-1, 1);

        line.setEndPoint(newEndPoint);
    }

    @Test
    public void testLength() throws Exception {
        double expectedResult = 3;
        double delta = 0.001;

        double actualResult = line.length();

        assertEquals(expectedResult, actualResult, delta);
    }
}