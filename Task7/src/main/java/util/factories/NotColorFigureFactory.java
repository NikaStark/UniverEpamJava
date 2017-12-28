package util.factories;

import model.Figure;

import java.util.Random;

/**
 * @author Alex Volochi
 */
public class NotColorFigureFactory extends AbstractFigureFactory {

    private static NotColorFigureFactory instance;

    private NotColorFigureFactory() {
    }

    public static NotColorFigureFactory getInstance() {
        if (instance == null) {
            instance = new NotColorFigureFactory();
        }
        return instance;
    }

    @Override
    public Figure getFigure() {
        Random random = new Random();
        return getFigure(random.nextInt(4));
    }

}
