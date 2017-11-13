package entities.impl;

import entities.interfaces.Flyable;

/**
 * Class is realized plane and car vehicle
 *
 * @author Alex Volochai
 * @see entities.CVehicle
 */
public class BatCar extends CCar implements Flyable {

    public BatCar() {
    }

    public BatCar(int price, int speed, int issueYear) {
        super(price, speed, issueYear);
    }

    @Override
    public int fly() {
        return speed * 10;
    }

    @Override
    public String toString() {
        return "BatCar{" + this.toStringParameters() + "}";
    }

}
