package controller;

import model.GameRoom;
import util.command.CommandFactory;
import view.ConsoleView;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Alex Volochai
 */
public class GameRoomController {

    private GameRoom gameRoom = new GameRoom();

    private CommandFactory commandFactory = CommandFactory.getInstance();

    public void startProcessing() {
        Scanner scanner = new Scanner(System.in);
        ConsoleView.printlnMessage(ConsoleView.HELLO_MSG);
        String command;
        String[] params;
        do {
            ConsoleView.printMessage(ConsoleView.INPUT_MSG);
            params = scanner.nextLine().trim().split(" ", 2);
            command = params[0].toLowerCase();
            params = params.length > 1 ? filtering(params[1].split(" ")) : new String[]{};
            if (commandFactory.isPresent(command)) {
                commandFactory.getCommand(command).execute(gameRoom, params);
            } else {
                ConsoleView.printlnMessage(ConsoleView.WRONG_COMMAND_MSG);
            }
        } while (!"exit".equals(command));
    }

    private String[] filtering(String[] params) {
        ArrayList<String> filteredParams = new ArrayList<>(params.length);
        for (String param : params) {
            if (!"".equals(param)) {
                filteredParams.add(param);
            }
        }
        filteredParams.trimToSize();
        return filteredParams.toArray(new String[filteredParams.size()]);
    }

}
