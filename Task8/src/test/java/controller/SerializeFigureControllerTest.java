package controller;

import model.Figure;
import org.junit.Test;
import util.factories.ColorFigureFactory;

import java.io.File;

import static org.junit.Assert.assertArrayEquals;

public class SerializeFigureControllerTest {

    @Test
    public void testSerializeAndDeserialize() throws Exception {
        Figure[] expectedFigure = ColorFigureFactory.getInstance().getFigures(9);
        Figure[] actualFigure;
        File file = new File("temp.txt");

        SerializeFigureController.serialize(file, expectedFigure);
        actualFigure = SerializeFigureController.deserialize(file, expectedFigure.length);

        assertArrayEquals(expectedFigure, actualFigure);
        file.delete();
    }

}