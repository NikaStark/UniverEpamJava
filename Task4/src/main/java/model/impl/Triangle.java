package model.impl;

import model.Figure;

/**
 * @author Alex Volochai
 */
public class Triangle extends Figure {

    private Point a, b, c;

    private Line sideAB, sideAC, sideBC;

    public Triangle(Point a, Point b, Point c) {
        if (!validate(a, b, c)) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;
        this.sideAB = new Line(a, b);
        this.sideAC = new Line(a, c);
        this.sideBC = new Line(b, c);
    }

    public Point getA() {
        return a;
    }

    public void setA(Point a) {
        if (!validate(a, this.b, this.c)) throw new IllegalArgumentException();
        this.sideAB.setStartPoint(a);
        this.sideAC.setStartPoint(a);
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        if (!validate(this.a, b, this.c)) throw new IllegalArgumentException();
        this.sideAB.setEndPoint(b);
        this.sideBC.setStartPoint(b);
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        if (!validate(this.a, this.b, c)) throw new IllegalArgumentException();
        this.sideAC.setEndPoint(c);
        this.sideBC.setEndPoint(c);
        this.c = c;
    }

    public Line getSideAB() {
        return sideAB;
    }

    public Line getSideAC() {
        return sideAC;
    }

    public Line getSideBC() {
        return sideBC;
    }

    /**
     * Calculate perimeter of the triangle
     *
     * @return perimeter
     */
    public double perimeter() {
        return sideAB.length() + sideAC.length() + sideBC.length();
    }

    /**
     * Calculate square of the triangle
     *
     * @return square
     */
    public double square() {
        double halfPerimeter = perimeter() / 2;
        return Math.sqrt(
                halfPerimeter *
                (halfPerimeter - sideAB.length()) *
                (halfPerimeter - sideAC.length()) *
                (halfPerimeter - sideBC.length())
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;

        if (!a.equals(triangle.a)) return false;
        if (!b.equals(triangle.b)) return false;
        if (!c.equals(triangle.c)) return false;
        if (!sideAB.equals(triangle.sideAB)) return false;
        if (!sideAC.equals(triangle.sideAC)) return false;
        return sideBC.equals(triangle.sideBC);

    }

    @Override
    public int hashCode() {
        int result = a.hashCode();
        result = 31 * result + b.hashCode();
        result = 31 * result + c.hashCode();
        result = 31 * result + sideAB.hashCode();
        result = 31 * result + sideAC.hashCode();
        result = 31 * result + sideBC.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" + toStringParameters() + "}";
    }

    @Override
    protected String toStringParameters() {
        return a.toString() + b.toString() + c.toString();
    }

    /**
     * Checking mutual arrangement of three point
     *
     * @param a first point
     * @param b second point
     * @param c third point
     * @return True if two points not equal
     */
    private boolean validate(Point a, Point b, Point c) {
        if (!a.equals(b) && !a.equals(c) && !b.equals(c)) {
            if (a.getX() != b.getX() || a.getX() != c.getX()) {
                if (a.getY() != b.getY() || a.getY() != c.getY()) {
                    return true;
                }
            }
        }
        return false;
    }

}