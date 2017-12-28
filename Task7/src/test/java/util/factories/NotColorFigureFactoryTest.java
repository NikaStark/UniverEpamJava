package util.factories;

import model.Figure;
import model.interfaces.Colorable;
import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * @author Alex Volochai
 */
public class NotColorFigureFactoryTest extends AbstractFigureFactoryTest {

    @Test
    public void testGetFigure() throws Exception {
        Figure[] notColorFigures = NotColorFigureFactory.getInstance().getFigures(10);

        for (Figure figure : notColorFigures) {
            assertFalse(figure instanceof Colorable);
        }
    }

}