package entities;

/**
 * Abstract class for objects that is vehicle
 *
 * @author Alex Volochai
 */
public abstract class CVehicle {

    /**
     * Price of the vehicle
     */
    protected int price;
    /**
     * Speed vehicle can move
     */
    protected int speed;
    /**
     * Year of issue vehicle
     */
    protected int issueYear;

    /**
     * Default constructor
     */
    public CVehicle() {
    }

    /**
     * Constructor with parameters
     * @param price price of vehicle
     * @param speed speed of vehicle
     * @param issueYear year of issue vehicle
     */
    public CVehicle(int price, int speed, int issueYear) {
        this.price = price;
        this.speed = speed;
        this.issueYear = issueYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getIssueYear() {
        return issueYear;
    }

    public void setIssueYear(int issueYear) {
        this.issueYear = issueYear;
    }

    /**
     * Checks if this vehicle is equal to another vehicle

     * @param o the object to check, null returns false
     * @return true if this is equal to the other year
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CVehicle cVehicle = (CVehicle) o;

        if (price != cVehicle.price) return false;
        if (speed != cVehicle.speed) return false;
        return issueYear == cVehicle.issueYear;

    }

    /**
     * A hash code for this vehicle
     *
     * @return a suitable hash code
     */
    @Override
    public int hashCode() {
        int result = price;
        result = 31 * result + speed;
        result = 31 * result + issueYear;
        return result;
    }

    /**
     * Outputs this vehicle as a {@code String}.
     *
     * @return a string representation of this year, not null
     */
    @Override
    public String toString() {
        return "CVehicle{" + toStringShort();
    }

    /**
     * Outputs this vehicle in short form(without name class) as a {@code String}.
     *
     * @return a string representation of this year, not null
     */
    protected String toStringShort() {
        return  "price=" + price +
                ", speed=" + speed +
                ", issueYear=" + issueYear +
                '}';
    }

}
