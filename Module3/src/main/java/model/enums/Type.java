package model.enums;

/**
 * @author Alex Volochai
 */
public enum Type {

    BALLROOM,
    POPULAR,
    POP,
    ORIENTAL;

    public static Type parseType(String type) throws IllegalArgumentException {
        switch (type) {
            case "ballroom":
                return BALLROOM;
            case "popular":
                return POPULAR;
            case "pop":
                return POP;
            case "oriental":
                return ORIENTAL;
            default:
                throw new IllegalArgumentException();
        }
    }

}
