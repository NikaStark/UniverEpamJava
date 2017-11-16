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
        this.a = a;
    }

    public Point getB() {
        return b;
    }

    public void setB(Point b) {
        this.b = b;
    }

    public Point getC() {
        return c;
    }

    public void setC(Point c) {
        this.c = c;
    }

    public Line getSideAB() {
        return sideAB;
    }

    public void setSideAB(Line sideAB) {
        this.sideAB = sideAB;
    }

    public Line getSideAC() {
        return sideAC;
    }

    public void setSideAC(Line sideAC) {
        this.sideAC = sideAC;
    }

    public Line getSideBC() {
        return sideBC;
    }

    public void setSideBC(Line sideBC) {
        this.sideBC = sideBC;
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