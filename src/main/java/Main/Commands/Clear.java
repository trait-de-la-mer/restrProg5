package Main.Commands;

import Main.Utils.CollectionManager;

public class Clear extends Command{
    {setName("clear");
        setInfo("Очищает коллекцию");}

    public Clear(CollectionManager colm) {
        super(colm);
    }

    @Override
    public void execute(String args) {
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        getCollectionManager().clearCollection();
    }
}
