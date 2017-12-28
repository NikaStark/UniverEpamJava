package util.command;

import model.GameRoom;
import model.Toy;
import model.enums.AgeGroup;
import model.enums.Size;
import util.factories.AbstractToyFactory;
import view.ConsoleView;

/**
 * Realize behavior program for command "find"
 *
 * @author Alex Volochai
 */
public class FindCommand implements Command {

    private static FindCommand instance;

    private FindCommand() {
    }

    public static FindCommand getInstance() {
        if (instance == null) {
            instance = new FindCommand();
        }
        return instance;
    }

    @Override
    public void execute(GameRoom gameRoom, String[] params) {
        if (gameRoom.getToys() == null) {
            ConsoleView.printlnMessage(ConsoleView.TOYS_NOT_INIT_MSG);
        } else {
            if (params.length == 0) {
                ConsoleView.printlnMessage(ConsoleView.WRONG_PARAM_MSG);
            } else {
                try {
                    ConsoleView.printToys(searchToys(gameRoom, params));
                } catch (IllegalArgumentException e) {
                    ConsoleView.printlnMessage(ConsoleView.WRONG_PARAM_MSG);
                }
            }
        }
    }

    //TODO If you have a free time, rewrite this bullshit code
    private Toy[] searchToys(GameRoom gameRoom, String[] params) throws IllegalArgumentException {
        if (!"by".equals(params[0])) throw new IllegalArgumentException();
        switch (params[1]) {
            case "ageGroup":
                if ("==".equals(params[2])) {
                    return gameRoom.findByAgeGroup(AgeGroup.parseAgeGroup(params[3]), true);
                } else if ("!=".equals(params[2])) {
                    return gameRoom.findByAgeGroup(AgeGroup.parseAgeGroup(params[3]), false);
                } else {
                    throw new IllegalArgumentException();
                }
            case "size":
                if ("==".equals(params[2])) {
                    return gameRoom.findBySize(Size.valueOf(params[3]), true);
                } else if ("!=".equals(params[2])) {
                    return gameRoom.findBySize(Size.valueOf(params[3]), false);
                } else {
                    throw new IllegalArgumentException();
                }
            case "price":
                return gameRoom.findByPrice(
                        Integer.parseInt(params[2]),
                        params.length > 3 ? Integer.parseInt(params[3]) : AbstractToyFactory.MAX_TOY_PRICE);
            default:
                throw new IllegalArgumentException();
        }
    }

}
