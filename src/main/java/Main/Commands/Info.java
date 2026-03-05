package Main.Commands;

import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

public class Info extends Command{
    {setName("info");
        setInfo("выводит информацию о коллекцииз (тип, дата инициализации, кол-во элементов)");};

    public Info(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        Consoll.printSmt("тип: " + getCollectionManager().getCollectionType());
        Consoll.printSmt("дата инициализации: " + getCollectionManager().getCollectionSyze());
        Consoll.printSmt("кол-во элементов: " + getCollectionManager().getCreationDate());
    }
}
