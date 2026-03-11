package Main.Commands;

import Main.Utils.CollectionManager;

public class RemoveFirst extends Command{
    {setName("remove_first");
        setInfo("удаляет первый элемент в коллекции");}
    public RemoveFirst(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        getCollectionManager().removeElement(0);
    }
}
