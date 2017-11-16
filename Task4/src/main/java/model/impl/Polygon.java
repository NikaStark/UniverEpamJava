package model.impl;

import model.Figure;

import java.util.Arrays;

/**
 * @author Alex Volochai
 */
public class Polygon extends Figure {

    private Point[] points;

    public Polygon(Point[] points) {
        if (!validate(points)) throw new IllegalArgumentException();
        this.points = points;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        if (!validate(points)) throw new IllegalArgumentException();
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

    /**
     * Checking the entered points for validity by polygon
     * @param points - entered points
     * @return true if points valid
     */
    private boolean validate(Point[] points) {
        if (points.length < 4) return false;
        for (int  i = 0; i < points.length - 1; i++){
            if(points[i].equals(points[i + 1])) return false;
        }

        for (int i = 0; i < points.length - 2; i++) {
            if (points[i].getX() == points[i + 1].getX() &&
                    points[i + 1].getX() == points[i + 2 == points.length ? 0 : i + 2].getX())
                return false;
            if (points[i].getY() == points[i + 1].getY() &&
                    points[i + 1].getY() == points[i + 2 == points.length ? 0 : i + 2].getY())
                return false;
        }
        return true;
    }

}
