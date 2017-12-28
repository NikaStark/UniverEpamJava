package util.factories;

import model.Toy;
import model.enums.AgeGroup;
import model.enums.Size;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Alex Volochai
 */
public class RandomToyFactory extends AbstractToyFactory {

    private static AgeGroup[] ageGroups = Arrays.copyOf(AgeGroup.values(), AgeGroup.values().length - 1);

    private static Size[] sizes = Arrays.copyOf(Size.values(), Size.values().length - 1);

    private static RandomToyFactory instance;

    private RandomToyFactory() {}

    public static RandomToyFactory getInstance() {
        if (instance == null) {
            instance = new RandomToyFactory();
        }
        return instance;
    }

    @Override
    public Toy getToy(AgeGroup ageGroup, Size size, int price) {
        Random random = new Random();
        return getToy(random.nextInt(COUNT_TOY_IMPLEMENTATIONS),
                ageGroup == AgeGroup.RANDOM ? ageGroups[random.nextInt(ageGroups.length)] : ageGroup,
                size == Size.RANDOM ? sizes[random.nextInt(sizes.length)] : size,
                price == 0 ? MIN_TOY_PRICE + random.nextInt(MAX_TOY_PRICE - MIN_TOY_PRICE) : price
        );
    }

}
