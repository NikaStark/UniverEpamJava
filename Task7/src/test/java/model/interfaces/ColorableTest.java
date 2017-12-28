package model.interfaces;

import org.junit.Test;

public class ColorableTest {

    public Colorable colorFigure = new Colorable() {
        @Override
        public int getColor() {
            return 0;
        }
    };

    @Test
    public void testValidateCorrectColor() throws Exception {
        colorFigure.validateColor(911);
    }


    @Test
    public void testValidateNotCorrectColor() throws Exception {
        colorFigure.validateColor(-911);
    }

}