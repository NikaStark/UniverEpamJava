package util.factories;

import model.Figure;

import java.util.Random;

/**
 * @author Alex Volochai
 */
public class ColorFigureFactory extends AbstractFigureFactory {

    private static ColorFigureFactory instance;

    private ColorFigureFactory() {}

    public static ColorFigureFactory getInstance() {
        if (instance == null) {
            instance = new ColorFigureFactory();
        }
        return instance;
    }

    @Override
    public Figure getFigure() {
        Random random = new Random();
        return getFigure(random.nextInt(4) + 4);
    }

}
