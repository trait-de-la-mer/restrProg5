package Main.Commands;

import Main.Utils.CollectionManager;
import Main.Utils.CommandMannager;
import Main.Utils.Consoll;

public class Help extends Command{
    {setName("help");
    setInfo("Выводит все команды и их выполнение");}
    public Help(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        for (String nameCommand : CommandMannager.getCommands().keySet()){
            Consoll.printSmt(nameCommand + " - " + CommandMannager.getCommands().get(nameCommand).getInfo());
        }
    }
}
