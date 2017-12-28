package util.comparators;

import model.Toy;

import java.util.Comparator;

/**
 * @author Alex Volochai
 */
public class ToySizeComparator implements Comparator<Toy> {

    @Override
    public int compare(Toy toy1, Toy toy2) {
        return toy1.getSize().compareTo(toy2.getSize());
    }

}
