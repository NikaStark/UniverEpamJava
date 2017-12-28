package task4.entitys;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {
    Place p;
    @Before
    public void setUp() throws Exception {
        p = new Place(1);
    }

    @After
    public void tearDown() throws Exception {
        p = null;
    }

    @Test
    public void run() throws Exception {
        Car c = new Car("BMW", p);

        c.run();

        assertFalse(c.p.use);
    }

}