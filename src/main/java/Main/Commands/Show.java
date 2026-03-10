package Main.Commands;

import Main.Collection.LabWork;
import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

public class Show extends Command{
    {setName("show");
    setInfo("выводит все элементы в коллекции");}

    public Show(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        for (LabWork lab : getCollectionManager().getLabCollection()){
            Consoll.printSmt(lab.toString());
        }
    }
}
