package Main.Commands;

import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

public class Remove extends Command{
    {setName("remove");
    setInfo("удаляет элемент по ключу");}
    public Remove(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        int key;
        try{
            key = Integer.parseInt(args);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Аргумент жолжен быть int");
        }
        CollectionManager cm = getCollectionManager();
        if (cm.getLabCollection().containsKey(key)) {
            getCollectionManager().removeElement(key);
        } else throw new IllegalArgumentException("такого ключа нет");
    }
}
