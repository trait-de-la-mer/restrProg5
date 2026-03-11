package Main.Commands;

import Main.Collection.LabWork;
import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

public class Head extends Command{
    {
        setName("head");
        setInfo("Выводит первый эл-т в коллекции");
    }
    public Head(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        LabWork firstElement = getCollectionManager().getElemnt(0);
        Consoll.printSmt(firstElement.toString());
    }
}
