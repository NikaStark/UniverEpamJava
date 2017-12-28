package util.factories;

import model.Figure;
import org.junit.Test;

/**
 * @author Alex Volochai
 */
public class AbstractFigureFactoryTest {

    private AbstractFigureFactory figureFactory = new AbstractFigureFactory() {
        @Override
        public Figure getFigure() {
            return null;
        }
    };

    @Test(expected = IllegalArgumentException.class)
    public void testGetFigure() throws Exception {
        figureFactory.getFigure(8);
    }

}