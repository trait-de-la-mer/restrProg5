package Main.Commands;

import Main.Collection.LabWork;
import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

public class CountLessMin extends Command{
    {
        setName("countLessMin");
        setInfo("выводит все эл-ты, значение поля author которых меньше заданного");
    }
    public CountLessMin(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String minimalPoint) {
        double minimalPoints;
        if (minimalPoint == null || minimalPoint.isEmpty()) {
            throw new IllegalArgumentException("Для этой команды нужен аргумент!");
        }
        try {
            minimalPoints = Double.parseDouble(minimalPoint);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("что-то не так с форматом данных");
        }
        for (LabWork i : getCollectionManager().getLabCollection()){
            if (i.getMinimalPoint() < minimalPoints) {
                Consoll.printSmt(i.toString());
            }
        }
    }
}
