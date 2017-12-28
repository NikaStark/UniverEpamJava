package model.enums;

/**
 * @author Alex Volochai
 */
public enum AgeGroup {

    MORE_THEN_THREE_MONTH,
    MORE_THEN_ONE_YEAR,
    MORE_THEN_THREE_YEAR,
    MORE_THEN_SEVEN_YEAR,
    MORE_THEN_THIRTEEN_YEAR,
    RANDOM;

    public static AgeGroup parseAgeGroup(String ageGroup) throws IllegalArgumentException {
        switch (ageGroup) {
            case "+3m":
                return MORE_THEN_THREE_MONTH;
            case "+1y":
                return MORE_THEN_ONE_YEAR;
            case "+3y":
                return MORE_THEN_THREE_YEAR;
            case "+7y":
                return MORE_THEN_SEVEN_YEAR;
            case "+13y":
                return MORE_THEN_THIRTEEN_YEAR;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        switch (this) {
            case MORE_THEN_THREE_MONTH:
                return "+3 month";
            case MORE_THEN_ONE_YEAR:
                return "+1 year";
            case MORE_THEN_THREE_YEAR:
                return "+3 years";
            case MORE_THEN_SEVEN_YEAR:
                return "+7 years";
            case MORE_THEN_THIRTEEN_YEAR:
                return "+13 years";
            default:
                throw new RuntimeException();
        }
    }
}
