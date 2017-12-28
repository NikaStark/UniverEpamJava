package util.command;

import model.GameRoom;

/**
 * Realize behavior program for command "exit"
 *
 * @author Alex Volochai
 */
public class ExitCommand implements Command {

    private static ExitCommand instance;

    private ExitCommand() {
    }

    public static ExitCommand getInstance() {
        if (instance == null) {
            instance = new ExitCommand();
        }
        return instance;
    }

    @Override
    public void execute(GameRoom gameRoom, String[] params) {
    }

}
