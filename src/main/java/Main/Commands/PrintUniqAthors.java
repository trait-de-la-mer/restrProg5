package Main.Commands;

import Main.Collection.LabWork;
import Main.Collection.Person;
import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PrintUniqAthors extends Command{
    {setName("uniqAuthor");
    setInfo("Выводи уникальных авторов");}


    public PrintUniqAthors(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        ArrayList<Person> persons = new ArrayList<>();
        for (LabWork i : getCollectionManager().getLabCollection()){
            boolean isAuthorExist = false;
            Person author = i.getAuthor();
            for (Person j : persons){
                if (j.equals(author)) {
                    isAuthorExist = true;
                    break;
                }
            }
            if (!isAuthorExist){
                persons.add(author);
            }
        }
        for (Person i : persons){
            System.out.println(i);
        }
    }
}
