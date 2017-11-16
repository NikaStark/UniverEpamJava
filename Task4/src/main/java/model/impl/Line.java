package model.impl;

import model.Figure;

/**
 * @author Alex Volochai
 */
public class Line extends Figure {

    private Point startPoint;

    private Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        if (!validate(startPoint, endPoint)) throw new IllegalArgumentException();
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        if (!validate(startPoint, this.endPoint)) throw new IllegalArgumentException();
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        if (!validate(this.startPoint, endPoint)) throw new IllegalArgumentException();
        this.endPoint = endPoint;
    }

    /**
     * Length of line
     *
     * @return length in double format
     */
    public double length() {
        return Math.sqrt(
                Math.pow(endPoint.getX() - startPoint.getX(), 2) +
                Math.pow(endPoint.getY() - startPoint.getY(), 2)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (!startPoint.equals(line.startPoint)) return false;
        return endPoint.equals(line.endPoint);

    }

    @Override
    public int hashCode() {
        int result = startPoint.hashCode();
        result = 31 * result + endPoint.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Line{" + toStringParameters() + "}";
    }

    @Override
    protected String toStringParameters() {
        return startPoint.toString() + endPoint.toString();
    }

    /**
     * Checking mutual arrangement of two point
     *
     * @param a first point
     * @param b second point
     * @return True if two points not equal
     */
    private boolean validate(Point a, Point b) {
        return !a.equals(b);
    }

}
