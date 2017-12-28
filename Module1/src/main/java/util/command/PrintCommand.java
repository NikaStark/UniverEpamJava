package util.command;

import model.GameRoom;
import view.ConsoleView;

/**
 * Realize behavior program for command "print"
 *
 * @author Alex Volochai
 */
public class PrintCommand implements Command {

    private static PrintCommand instance;

    private PrintCommand() {
    }

    public static PrintCommand getInstance() {
        if (instance == null) {
            instance = new PrintCommand();
        }
        return instance;
    }

    @Override
    public void execute(GameRoom gameRoom, String[] params) {
        if (gameRoom.getToys() == null) {
            ConsoleView.printlnMessage(ConsoleView.TOYS_NOT_INIT_MSG);
        } else {
            gameRoom.printToys();
        }
    }

}
