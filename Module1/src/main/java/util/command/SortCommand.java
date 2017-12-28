package util.command;

import model.GameRoom;
import model.Toy;
import util.comparators.ToyAgeGroupComparator;
import util.comparators.ToyPriceComparator;
import util.comparators.ToySizeComparator;
import view.ConsoleView;

import java.util.Comparator;

/**
 * Realize behavior program for command "sort"
 *
 * @author Alex Volochai
 */
public class SortCommand implements Command {

    private static SortCommand instance;

    private SortCommand() {
    }

    public static SortCommand getInstance() {
        if (instance == null) {
            instance = new SortCommand();
        }
        return instance;
    }

    @Override
    public void execute(GameRoom gameRoom, String[] params) {
        if (gameRoom.getToys() == null) {
            ConsoleView.printlnMessage(ConsoleView.TOYS_NOT_INIT_MSG);
            return;
        } else {
            if (params.length == 0) {
                gameRoom.sortToys();
            } else {
                try {
                    gameRoom.sortToys(parseInputSortParams(params));
                } catch (IllegalArgumentException e) {
                    ConsoleView.printlnMessage(ConsoleView.WRONG_PARAM_MSG);
                    return;
                }
            }
        }
        ConsoleView.printlnMessage(ConsoleView.SUCCESS_SORT_MSG);
    }

    private Comparator<Toy> parseInputSortParams(String[] params) throws IllegalArgumentException {
        if (!"by".equals(params[0])) throw new IllegalArgumentException();
        switch (params[1]) {
            case "ageGroup": return new ToyAgeGroupComparator();
            case "size": return new ToySizeComparator();
            case "price": return new ToyPriceComparator();
            default: throw new IllegalArgumentException();
        }
    }

}
