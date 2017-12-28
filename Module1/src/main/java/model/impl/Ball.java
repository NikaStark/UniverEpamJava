package model.impl;

import model.Toy;
import model.enums.AgeGroup;
import model.enums.Size;

/**
 * @author Alex Volochai
 */
public class Ball extends Toy {

    public Ball(AgeGroup ageGroup, Size size, int price) {
        super(ageGroup, size, price);
    }

    @Override
    public String toString() {
        return "Ball{" + toStringParameters() + "}";
    }

}
