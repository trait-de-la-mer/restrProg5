package Main.Commands;

import Main.Collection.*;
import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class Update extends Command{
    {setName("update");
    setInfo("Обновляет элемент по заданному id");}
    public Update(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        boolean isIdExist = false;
        Long needId;
        try{
            needId = Long.valueOf(args);
        } catch (NumberFormatException e) {
            throw new RuntimeException("аргумент должен быть Long");
        }
        for (LabWork lab : getCollectionManager().getLabCollection()){
            Long currentId = lab.getId();
            if (Objects.equals(needId, currentId)){
                isIdExist = true;
                LabWork labWork = new LabWork();
                Coordinates coordinates = new Coordinates();
                Person person = new Person();
                labWork.setId(getCollectionManager().generateId());
                labWork.setCreationDate(LocalDate.now());
                while(!Add.input("сложность: " + Arrays.toString(Difficulty.values()), labWork::setDifficulty, Difficulty::fromString));
                while(!Add.input("имя лабы", labWork::setName, String::valueOf));
                while(!Add.input("минимальное кол-во баллов", labWork::setMinimalPoint, Double::valueOf));
                while(!Add.input("координата по Х", coordinates::setX, Long::valueOf));
                while(!Add.input("координата по Y", coordinates::setY, Integer::valueOf));
                labWork.setCoordinates(coordinates);
                while(!Add.input("ваш вес", person::setWeight, Double::valueOf));
                while(!Add.input("ваше имя", person::setName, String::valueOf));
                while(!Add.input("цвет глаз: " + Arrays.toString(Color.values()), person::setEyeColor, Color::fromString));
                labWork.setAuthor(person);
                labWork.setAuthor(person);
                //getCollectionManager().addElement(labWork, needId);
                CollectionManager cm = getCollectionManager();
                labWork.setId(currentId);
                Iterator<LabWork> iterator = cm.getLabCollection().iterator();
                int counter = 0;
                while (iterator.hasNext()){
                    LabWork someLabWork = iterator.next();
                    if (Objects.equals(someLabWork.getId(), needId)){
                        cm.changeLab(labWork, counter);
                        cm.setLastId(cm.getLastId() - 1);
                        return;
                    }
                    counter++;
                }
                break;
            }
        }
        if (!isIdExist){
            Consoll.printSmt("Такого id нет");
        }
    }
}
