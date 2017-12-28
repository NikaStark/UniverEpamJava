package controller;

import model.Figure;

import java.io.*;

/**
 * @author Alex Volochai
 */
public class SerializeFigureController {

    public static void serialize(File file, Figure[] figures) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Figure figure : figures) {
                out.writeObject(figure);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Figure[] deserialize(File file, int length) {
        Figure[] figures = new Figure[length];
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            for (int i = 0; i < figures.length; i++) {
                figures[i] = (Figure) in.readObject();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return figures;
    }

}
