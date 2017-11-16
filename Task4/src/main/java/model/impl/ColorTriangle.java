package model.impl;

import model.interfaces.Colorable;

/**
 * @author Alex Volochai
 */
public class ColorTriangle extends Triangle implements Colorable {

    private int color;

    public ColorTriangle(Point a, Point b, Point c, int color) {
        super(a, b, c);
        this.color = color;
    }

    public ColorTriangle (Triangle triangle, int color) {
        this(triangle.getA(), triangle.getB(), triangle.getC(), color);
    }

    @Override
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColorTriangle that = (ColorTriangle) o;

        return color == that.color;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + color;
        return result;
    }

    @Override
    public String toString() {
        return "ColorTriangle{" + toStringParameters() + "}";
    }

    @Override
    protected String toStringParameters() {
        return super.toStringParameters() +
                ", color=" + color;
    }
}
