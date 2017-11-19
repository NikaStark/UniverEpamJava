package model.impl;

import model.interfaces.Colorable;

/**
 * @author Alex Volochai
 */
public class ColorPoint extends Point implements Colorable {

    private int color;

    public ColorPoint(int x, int y, int color) {
        super(x, y);
        if (!validateColor(color)) throw new IllegalArgumentException();
        this.color = color;
    }

    public ColorPoint(Point point, int color) {
        this(point.getX(), point.getY(), color);
    }

    @Override
    public int getColor() {
        return 0;
    }

    public void setColor(int color) {
        if (!validateColor(color)) throw new IllegalArgumentException();
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColorPoint that = (ColorPoint) o;

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
        return "ColorPoint{" + toStringParameters() + "}";
    }

    @Override
    protected String toStringParameters() {
        return super.toStringParameters() +
                ", color=" + color;
    }

}
