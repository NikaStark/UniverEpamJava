package model.impl;

import model.interfaces.Colorable;

/**
 * @author Alex Volochai
 */
public class ColorPolygon extends Polygon implements Colorable {

    private int color;

    public ColorPolygon(Point[] points, int color) {
        super(points);
        this.color = color;
    }

    public ColorPolygon(Polygon polygon, int color) {
        this(polygon.getPoints(), color);
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

        ColorPolygon that = (ColorPolygon) o;

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
        return "ColorPolygon{" + toStringParameters() + "}";
    }

    @Override
    protected String toStringParameters() {
        return super.toStringParameters() +
                ", color=" + color;
    }

}
