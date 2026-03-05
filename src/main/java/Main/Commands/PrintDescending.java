package Main.Commands;

import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

import java.util.LinkedList;

public class PrintDescending extends Command{
    {setName("print_descending");
    setInfo("Выводи коллекцию в порядке убывания");}

    public PrintDescending(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        LinkedList<Integer> collectionReverse = new LinkedList<>();
        collectionReverse.addAll(getCollectionManager().getOrgCollection().keySet());
        collectionReverse.sort((key1, key2) -> getCollectionManager().getOrgCollection().get(key1).compareTo(
                getCollectionManager().getOrgCollection().get(key2)));
        collectionReverse = collectionReverse.reversed();
        for (Integer key : collectionReverse){
            Consoll.printSmt(getCollectionManager().getOrgCollection().get(key).toString());
        }
    }
}
