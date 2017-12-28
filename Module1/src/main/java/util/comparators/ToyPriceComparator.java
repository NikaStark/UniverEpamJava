package util.comparators;

import model.Toy;

import java.util.Comparator;

/**
 * @author Alex Volochai
 */
public class ToyPriceComparator implements Comparator<Toy> {

    @Override
    public int compare(Toy toy1, Toy toy2) {
        return Integer.compare(toy1.getPrice(), toy2.getPrice());
    }

}
