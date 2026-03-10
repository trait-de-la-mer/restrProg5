package Main.Commands;

import Main.Collection.LabWork;
import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

import java.util.Iterator;

public class Remove extends Command{
    {setName("remove");
    setInfo("удаляет элемент по id");}
    public Remove(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        int key;
        try{
            key = Integer.parseInt(args);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Аргумент должен быть int");
        }
        CollectionManager cm = getCollectionManager();
        Iterator<LabWork> iterator = cm.getLabCollection().iterator();
        int counter = 0;
        while (iterator.hasNext()){
            LabWork labWork = iterator.next();
            if (labWork.getId() == key){
                cm.removeElement(counter);
                Consoll.printSmt("Эл-т удален");
                return;
            }
            counter++;
        }  throw new IllegalArgumentException("такого id нет");
    }
}
