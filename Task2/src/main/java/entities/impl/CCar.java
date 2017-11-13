package entities.impl;

import entities.CVehicle;
import entities.interfaces.Moveable;

/**
 * Class is realized car vehicle
 *
 * @author Alex Volochai
 */
public class CCar extends CVehicle implements Moveable {

    public CCar() {
    }

    public CCar(int price, int speed, int issueYear) {
        super(price, speed, issueYear);
    }

    @Override
    public int move() {
        return speed;
    }

    @Override
    public String toString() {
        return "CCar{" + toStringParameters() + "}";
    }

}
