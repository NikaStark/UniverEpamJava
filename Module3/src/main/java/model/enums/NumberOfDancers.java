package model.enums;

/**
 * @author Alex Volochai
 */
public enum NumberOfDancers {

    MASS,
    SOLO,
    PAIRED;

    public static NumberOfDancers parseNumberOfDancers(String numberOfDancers) throws IllegalArgumentException {
        switch (numberOfDancers) {
            case "mass":
                return MASS;
            case "solo":
                return SOLO;
            case "paired":
                return PAIRED;
            default:
                throw new IllegalArgumentException();
        }
    }

}
