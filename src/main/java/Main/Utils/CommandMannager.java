package Main.Utils;

import Main.Commands.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;

public class CommandMannager {
    private static final HashMap<String, Command> commands = new HashMap<>();

    public CommandMannager(Command... needComands) {
        for (Command com : needComands){
            commands.put(com.getName().toLowerCase(Locale.ENGLISH), com);
        }

    }

    public static HashMap<String, Command> getCommands() {
        return commands;
    }

    public boolean isCommandExits(String nameCommand){
        return commands.containsKey(nameCommand);
    }

    public void executeC(String... nameCommand){
        if (nameCommand != null && nameCommand.length != 0 && !Objects.equals(nameCommand[0], "")
                && commands.containsKey(nameCommand[0])){
            String[] copyNameCommand = Arrays.copyOf(nameCommand, nameCommand.length + 1);
                if (nameCommand.length == 1){
                    copyNameCommand[1] = null;
                }
                try {
                    commands.get(copyNameCommand[0]).execute(copyNameCommand[1]);
                } catch (Exception ex) {Consoll.printSmt(ex.getMessage());}
            }
        else{
            Consoll.printSmt("Ты уверен, что ввел правильно?");
        }
    }
}
