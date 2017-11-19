package util.factories;

import model.Figure;
import model.interfaces.Colorable;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Alex Volochai
 */
public class ColorFigureFactoryTest extends AbstractFigureFactoryTest {

    @Test
    public void testGetFigure() throws Exception {
        Figure[] colorFigures = ColorFigureFactory.getInstance().getFigures(10);

        for (Figure figure : colorFigures) {
            assertTrue(figure instanceof Colorable);
        }
    }

}