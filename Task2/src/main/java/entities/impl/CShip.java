package entities.impl;

import entities.CVehicle;
import entities.interfaces.Swimable;

/**
 * Class is realized ship vehicle
 *
 * @author Alex Volochai
 * @see entities.CVehicle
 */
public class CShip extends CVehicle implements Swimable {

    /**
     * Count of passengers
     */
    private int passengers;

    /**
     * Port of registration
     */
    private String port;

    public CShip() {
    }

    public CShip(int price, int speed, int issueYear, int passengers, String port) {
        super(price, speed, issueYear);
        this.passengers = passengers;
        this.port = port;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public int swim() {
        return speed / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        CShip cShip = (CShip) o;

        if (passengers != cShip.passengers) return false;
        return port.equals(cShip.port);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + passengers;
        result = 31 * result + port.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CShip{" + toStringShort();
    }

    @Override
    protected String toStringShort() {
        return "passengers=" + passengers +
                ", port='" + port + '\'' +
                super.toStringShort();
    }

}
