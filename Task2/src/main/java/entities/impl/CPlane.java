package entities.impl;

import entities.CVehicle;
import entities.interfaces.Flyable;

/**
 * Class is realized plane vehicle
 *
 * @author Alex Volochai
 * @see entities.CVehicle
 */
public class CPlane extends CVehicle implements Flyable {

    /**
     * Count of passengers
     */
    private int passengers;

    /**
     * Height of rise
     */
    private int height;

    public CPlane() {
    }

    public CPlane(int price, int speed, int issueYear, int passengers, int height) {
        super(price, speed, issueYear);
        this.passengers = passengers;
        this.height = height;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int fly() {
        return speed * 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CPlane cPlane = (CPlane) o;

        if (passengers != cPlane.passengers) return false;
        return height == cPlane.height;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengers;
        result = 31 * result + height;
        return result;
    }

    @Override
    public String toString() {
        return "CPlane{" + toStringShort();
    }

    @Override
    protected String toStringShort() {
        return "passengers=" + passengers +
                ", height=" + height +
                super.toStringShort();
    }
}
