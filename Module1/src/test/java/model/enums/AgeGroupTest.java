package model.enums;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class AgeGroupTest {

    @Test
    public void testOrderInstances() throws Exception {
        assertTrue(AgeGroup.RANDOM.ordinal() == AgeGroup.values().length - 1);
        assertTrue(AgeGroup.MORE_THEN_THREE_MONTH.ordinal() < AgeGroup.MORE_THEN_ONE_YEAR.ordinal());
        assertTrue(AgeGroup.MORE_THEN_ONE_YEAR.ordinal() < AgeGroup.MORE_THEN_THREE_YEAR.ordinal());
        assertTrue(AgeGroup.MORE_THEN_THREE_YEAR.ordinal() < AgeGroup.MORE_THEN_SEVEN_YEAR.ordinal());
        assertTrue(AgeGroup.MORE_THEN_SEVEN_YEAR.ordinal() < AgeGroup.MORE_THEN_THIRTEEN_YEAR.ordinal());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testParseAgeGroupWhenWrongInput() throws Exception {
        AgeGroup.parseAgeGroup("unreal command");
    }
}