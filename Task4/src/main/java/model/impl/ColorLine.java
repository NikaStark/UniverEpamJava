package model.impl;

import model.interfaces.Colorable;

/**
 * @author Alex Volochai
 */
public class ColorLine extends Line implements Colorable {

    private int color;

    public ColorLine(Point startPoint, Point endPoint, int color) {
        super(startPoint, endPoint);
        if (!validateColor(color)) throw new IllegalArgumentException();
        this.color = color;
    }

    public ColorLine(Line line, int color) {
        this(line.getStartPoint(), line.getEndPoint(), color);
    }

    @Override
    public int getColor() {
        return color;
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

        ColorLine colorLine = (ColorLine) o;

        return color == colorLine.color;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + color;
        return result;
    }

    @Override
    public String toString() {
        return "ColorLine{" + toStringParameters() + "}";
    }

    @Override
    protected String toStringParameters() {
        return super.toStringParameters() +
                ", color=" + color;
    }

}
