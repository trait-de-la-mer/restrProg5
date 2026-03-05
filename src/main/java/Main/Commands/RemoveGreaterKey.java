package Main.Commands;

import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

public class RemoveGreaterKey extends Command{
    {setName("remove_if_greater");
    setInfo("удаляет все ключи, больше заданного");}
    public RemoveGreaterKey(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String arg) {
        Integer key;
        try{
            key = Integer.valueOf(arg);
        } catch (NumberFormatException e) {
            throw new RuntimeException("аргумент должен быть int");
        }
        for (Integer keys : getCollectionManager().getOrgCollection().keySet()){
            if (keys > key){
                Remove remove = new Remove(getCollectionManager());
                remove.execute(String.valueOf(keys));
                Consoll.printSmt("Удален элемент с ключом: " + keys);
            }
        }

    }
}
