package util.command;

import model.GameRoom;
import view.ConsoleView;

/**
 * Realize behavior program for command "create"
 *
 * @author Alex Volochai
 */
public class CreateCommand implements Command {

    private static CreateCommand instance;

    private CreateCommand() {
    }

    public static CreateCommand getInstance() {
        if (instance == null) {
            instance = new CreateCommand();
        }
        return instance;
    }

    @Override
    public void execute(GameRoom gameRoom, String[] params) {
        if (params.length == 0) {
            gameRoom.createToys(GameRoom.DEFAULT_COUNT_MONEY);
        } else {
            try {
                gameRoom.createToys(Integer.parseInt(params[0]));
            } catch (NumberFormatException e) {
                ConsoleView.printlnMessage(ConsoleView.WRONG_PARAM_MSG);
                return;
            }
        }
        ConsoleView.printlnMessage(ConsoleView.SUCCESS_CREATE_MSG);
    }

}
