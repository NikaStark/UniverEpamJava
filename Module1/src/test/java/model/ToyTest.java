package model;

import model.enums.AgeGroup;
import model.enums.Size;
import model.impl.*;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ToyTest {

    @Test
    public void testCompareToWhenToyEqual() throws Exception {
        Toy toy1 = new Ball(AgeGroup.MORE_THEN_THREE_MONTH, Size.MIDDLE, 10);
        Toy toy2 = new Ball(AgeGroup.MORE_THEN_THREE_MONTH, Size.MIDDLE, 10);

        assertTrue(toy1.compareTo(toy2) == 0);
    }

    @Test
    public void testCompareToWhenToyNotEqual() throws Exception {
        Toy toy1 = new Ball(AgeGroup.MORE_THEN_ONE_YEAR, Size.MIDDLE, 10);
        Toy toy2 = new Car(AgeGroup.MORE_THEN_SEVEN_YEAR, Size.SMALL, 10);
        Toy toy3 = new Constructor(AgeGroup.MORE_THEN_ONE_YEAR, Size.BIG, 10);
        Toy toy4 = new Cubes(AgeGroup.MORE_THEN_ONE_YEAR, Size.BIG, 11);
        Toy toy5 = new Doll(AgeGroup.MORE_THEN_ONE_YEAR, Size.SMALL, 11);

        assertTrue(toy1.compareTo(toy2) < 0);
        assertTrue(toy1.compareTo(toy3) < 0);
        assertTrue(toy1.compareTo(toy4) < 0);
        assertTrue(toy1.compareTo(toy5) > 0);
    }
}