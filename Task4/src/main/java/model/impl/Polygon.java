package model.impl;

import model.Figure;

import java.util.Arrays;

/**
 * @author Alex Volochai
 */
public class Polygon extends Figure {

    private Point[] points;

    public Polygon(Point[] points) {
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Polygon polygon = (Polygon) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(points, polygon.points);

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    public String toString() {
        return "Polygon{" + toStringParameters() + "}";
    }

    @Override
    protected String toStringParameters() {
        StringBuilder result = new StringBuilder();
        for (Point point : points) {
            result.append(point.toString());
        }
        return result.toString();
    }

}
