package Main.Commands;

import Main.Utils.CollectionManager;
import Main.Utils.CommandMannager;
import Main.Utils.Consoll;

public class History extends Command{
    {
        setName("history");
        setInfo("выводит последние 5 команд (без их аргументов)");
    }

    public History(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        for (String i : CommandMannager.getHistory()) {
            Consoll.printSmt(i);
        }
    }
}
