package Main.Commands;

import Main.Collection.Color;
import Main.Collection.LabWork;
import Main.Collection.Person;
import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

import java.util.Arrays;

public class LessThanAuthor extends Command{
    {setName("lessThanAuthor");
    setInfo("вывести элементы, значение поля author которых меньше заданного");}

    public LessThanAuthor(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        Person person = new Person();
        while(!Add.input("вес", person::setWeight, Double::valueOf));
        while(!Add.input("имя", person::setName, String::valueOf));
        while(!Add.input("цвет глаз: " + Arrays.toString(Color.values()), person::setEyeColor, Color::fromString));
        for (LabWork lab : getCollectionManager().getLabCollection()){
            if (lab.getAuthor().compareTo(person) < 0){
                Consoll.printSmt(lab.toString());
            }
        }
    }
}
