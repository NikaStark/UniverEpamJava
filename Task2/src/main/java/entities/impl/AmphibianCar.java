package entities.impl;

import entities.interfaces.Swimable;

/**
 * Class is realized ship and car vehicle
 *
 * @author Alex Volochai
 * @see entities.CVehicle
 */
public class AmphibianCar extends CCar implements Swimable{

    public AmphibianCar() {
    }

    public AmphibianCar(int price, int speed, int issueYear) {
        super(price, speed, issueYear);
    }

    @Override
    public int swim() {
        return speed / 2;
    }

    @Override
    public String toString() {
        return "AmphibianCar{" + this.toStringShort();
    }
}
