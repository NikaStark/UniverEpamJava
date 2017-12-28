package model.enums;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SizeTest {

    @Test
    public void testOrderInstances() throws Exception {
        assertTrue(Size.RANDOM.ordinal() == Size.values().length - 1);
        assertTrue(Size.SMALL.ordinal() < Size.MIDDLE.ordinal());
        assertTrue(Size.MIDDLE.ordinal() < Size.BIG.ordinal());
    }

}