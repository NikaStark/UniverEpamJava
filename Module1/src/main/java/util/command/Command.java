package util.command;

import model.GameRoom;

/**
 * @author Alex Volochai
 */
public interface Command {

    void execute(GameRoom gameRoom, String[] params);

}
