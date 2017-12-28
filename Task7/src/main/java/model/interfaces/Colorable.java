package model.interfaces;

/**
 * Interface for color figure
 *
 * @author Alex Volochai
 */
public interface Colorable {

    int getColor();

    default boolean validateColor(int color) {
        return color > 0;
    }

}
