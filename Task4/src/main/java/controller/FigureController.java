package controller;

import model.Figure;
import model.impl.Line;
import model.impl.Point;
import model.impl.Polygon;
import model.impl.Triangle;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for working with figures
 *
 * @author Alex Volochai
 */
public class FigureController {

    public static Figure[][] splitFigures(Figure[] figures) {
        int a = 0, b = 0, c = 0, d = 0;
        Figure[] points = new Point[figures.length];
        Figure[] lines = new Line[figures.length];
        Figure[] triangles = new Triangle[figures.length];
        Figure[] polygons = new Polygon[figures.length];

        for (Figure figure : figures) {
            if (figure instanceof Point) {
                points[a++] = figure;
            } else if (figure instanceof Line) {
                lines[b++] = figure;
            } else if (figure instanceof Triangle) {
                triangles[c++] = figure;
            } else if (figure instanceof Polygon) {
                polygons[d++] = figure;
            }
        }
        return new Figure[][]{points, lines, triangles, polygons};
    }

    public static Map<String, Integer> countFigures(Figure[] figures) {
        Map<String, Integer> map = new HashMap<>(4);
        int a = 0, b = 0, c = 0, d = 0;

        for (Figure figure : figures) {
            if (figure instanceof Point) {
                a++;
            } else if (figure instanceof Line) {
                b++;
            } else if (figure instanceof Triangle) {
                c++;
            } else if (figure instanceof Polygon) {
                d++;
            }
        }
        map.put("Points", a);
        map.put("Lines", b);
        map.put("Triangles", c);
        map.put("Polygons", d);
        return map;
    }

}
