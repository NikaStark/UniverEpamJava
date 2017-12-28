package model;

import model.enums.AgeGroup;
import model.enums.Size;

/**
 * @author Alex Volochai
 */
public abstract class Toy implements Comparable<Toy> {

    private final AgeGroup ageGroup;

    private final Size size;

    private final int price;

    public Toy(AgeGroup ageGroup, Size size, int price) {
        this.ageGroup = ageGroup;
        this.size = size;
        this.price = price;
    }

    public AgeGroup getAgeGroup() {
        return ageGroup;
    }

    public Size getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Toy toy) {
        int result = ageGroup.compareTo(toy.ageGroup);
        if (result == 0) result = size.compareTo(toy.size);
        if (result == 0) result = Integer.compare(price, toy.price);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Toy toy = (Toy) o;

        if (price != toy.price) return false;
        if (ageGroup != toy.ageGroup) return false;
        return size == toy.size;

    }

    @Override
    public int hashCode() {
        int result = ageGroup.hashCode();
        result = 31 * result + size.hashCode();
        result = 31 * result + price;
        return result;
    }

    @Override
    public String toString() {
        return "Toy{" + toStringParameters() + "}";
    }

    /**
     * Outputs this toy in short form(without name class) as a {@code String}.
     *
     * @return a string representation of this year, not null
     */
    protected String toStringParameters() {
        return "ageGroup = " + ageGroup +
                ", size=" + size +
                ", price=" + price;
    }

}
