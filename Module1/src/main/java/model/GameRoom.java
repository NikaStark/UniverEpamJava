package model;

import model.enums.AgeGroup;
import model.enums.Size;
import util.factories.RandomToyFactory;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Alex Volochai
 */
public class GameRoom {

    public static final int DEFAULT_COUNT_MONEY = 500;

    private Toy[] toys;

    public Toy[] getToys() {
        return toys;
    }

    public void createToys(int countMoney) {
        this.toys = RandomToyFactory.getInstance().getToys(countMoney, AgeGroup.RANDOM, Size.RANDOM);
    }

    public void sortToys() {
        Arrays.sort(this.toys);
    }

    public void sortToys(Comparator<Toy> comparator) {
        Arrays.sort(this.toys, comparator);
    }

    public Toy[] findByPrice(int min, int max) {
        ArrayList<Toy> filteredParams = new ArrayList<>(toys.length);
        for (Toy toy : toys) {
            if (toy.getPrice() >= min && toy.getPrice() < max) {
                filteredParams.add(toy);
            }
        }
        filteredParams.trimToSize();
        return filteredParams.toArray(new Toy[filteredParams.size()]);
    }

    public Toy[] findByAgeGroup(AgeGroup ageGroup, boolean equal) {
        ArrayList<Toy> filteredParams = new ArrayList<>(toys.length);
        for (Toy toy : toys) {
            if (equal) {
                if (toy.getAgeGroup().equals(ageGroup)) {
                    filteredParams.add(toy);
                }
            } else {
                if (!toy.getAgeGroup().equals(ageGroup)) {
                    filteredParams.add(toy);
                }
            }
        }
        filteredParams.trimToSize();
        return filteredParams.toArray(new Toy[filteredParams.size()]);
    }

    public Toy[] findBySize(Size size, boolean equal) {
        ArrayList<Toy> filteredParams = new ArrayList<>(toys.length);
        for (Toy toy : toys) {
            if (equal) {
                if (toy.getSize().equals(size)) {
                    filteredParams.add(toy);
                }
            } else {
                if (!toy.getSize().equals(size)) {
                    filteredParams.add(toy);
                }
            }
        }
        filteredParams.trimToSize();
        return filteredParams.toArray(new Toy[filteredParams.size()]);
    }

    public void printToys() {
        ConsoleView.printToys(toys);
    }

}
