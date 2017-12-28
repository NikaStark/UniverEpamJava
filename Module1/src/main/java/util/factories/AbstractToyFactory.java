package util.factories;

import model.Toy;
import model.enums.AgeGroup;
import model.enums.Size;
import model.impl.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alex Volochai
 */
public abstract class AbstractToyFactory {

    public static final int MIN_TOY_PRICE = 5;

    public static final int MAX_TOY_PRICE = 50;

    public static final int COUNT_TOY_IMPLEMENTATIONS = 5;

    public Toy[] getToys(int countMoney, AgeGroup ageGroup, Size size) {
        if (countMoney <= MIN_TOY_PRICE) {
            throw new IllegalArgumentException();
        }

        List<Toy> toys = new ArrayList<>();
        Toy currentToy;
        while (countMoney >= MIN_TOY_PRICE + MAX_TOY_PRICE) {
            currentToy = getToy(ageGroup, size, 0);
            countMoney -= currentToy.getPrice();
            toys.add(currentToy);
        }
        toys.add(getToy(ageGroup, size, countMoney));
        return toys.toArray(new Toy[toys.size()]);
    }

    protected abstract Toy getToy(AgeGroup ageGroup, Size size, int price);

    protected Toy getToy(int key, AgeGroup ageGroup, Size size, int price) {
        switch (key) {
            case 0: return new Ball(ageGroup, size, price);
            case 1: return new Car(ageGroup, size, price);
            case 2: return new Constructor(ageGroup, size, price);
            case 3: return new Cubes(ageGroup, size, price);
            case 4: return new Doll(ageGroup, size, price);
            default: throw new IllegalArgumentException();
        }
    }

}
