package Main.Commands;

import Main.Utils.CollectionManager;

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
        getCollectionManager().removeElement(key);
    }
}
