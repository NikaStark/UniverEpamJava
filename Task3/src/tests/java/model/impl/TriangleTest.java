package model.impl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Volochai
 */
public class TriangleTest {

    private Triangle triangle;

    @Before
    public void setUp() throws Exception {
        Point a = new Point(0, 0);
        Point b = new Point(8, 2);
        Point c = new Point(-2, 6);
        this.triangle = new Triangle(a, b, c);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetANotCorrect() throws Exception {
        Point newA = new Point(3, 4);

        triangle.setA(newA);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBNotCorrect() throws Exception {
        Point newB = new Point(-1, 3);

        triangle.setB(newB);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetCNotCorrect() throws Exception {
        Point newC = new Point(4, 1);

        triangle.setC(newC);
    }

    @Test
    public void testSetACorrect() throws Exception {
        Point newA = new Point(4, -1);

        triangle.setA(newA);
    }

    @Test
    public void testSetBCorrect() throws Exception {
        Point newB = new Point(1, 2);

        triangle.setB(newB);
    }

    @Test
    public void testSetCCorrect() throws Exception {
        Point newC = new Point(1, 5);

        triangle.setC(newC);
    }

    @Test
    public void testPerimeter() throws Exception {
        double expectedResult = 25.341;
        double delta = 0.001;

        double actualResult = triangle.perimeter();

        assertEquals(expectedResult, actualResult, delta);
    }

    @Test
    public void testSquare() throws Exception {
        double expectedResult = 26;
        double delta = 0.001;

        double actualResult = triangle.square();

        assertEquals(expectedResult, actualResult, delta);
    }
}