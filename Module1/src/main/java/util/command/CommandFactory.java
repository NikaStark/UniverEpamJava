package util.command;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex Volochai
 */
public class CommandFactory {

    private static CommandFactory instance;

    private static Map<String, Command> commands;

    private CommandFactory() {
        commands = new HashMap<String, Command>() {{
            put("create", CreateCommand.getInstance());
            put("exit", ExitCommand.getInstance());
            put("find", FindCommand.getInstance());
            put("print", PrintCommand.getInstance());
            put("sort", SortCommand.getInstance());
        }};
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }

    public Command getCommand(String command) {
        return commands.get(command);
    }

    public boolean isPresent(String command) {
        return commands.keySet().contains(command);
    }

}
