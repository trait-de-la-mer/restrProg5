package Main.Commands;


import Main.Collection.Coordinates;
import Main.Collection.LabWork;
import Main.Collection.Difficulty;
import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

import java.time.LocalDate;
import java.util.Arrays;

public class ReplaceIfGreater extends Command{
    {setName("replace_if_greater");
    setInfo("изменяет значение по ключу, если новое значение > старого");}
    public ReplaceIfGreater(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        Integer key;
        try{
            key = Integer.valueOf(args);
        } catch (NumberFormatException e) {
            throw new RuntimeException("аргумент должен быть int");
        }
//        LabWork labWork = new LabWork();
//        Address address = new Address();
//        Coordinates coordinates = new Coordinates();
//        labWork.setCreationDate(LocalDate.now());
//        labWork.setId(getCollectionManager().getOrgCollection().get(key).getId());
//        while(!Insert.input(Arrays.toString(Difficulty.values()), labWork::setType, Difficulty::fromString));
//        while(!Insert.input("имя", labWork::setName, String::valueOf));
//        while(!Insert.input("полное имя", labWork::setFullName, String::valueOf));
//        while(!Insert.input("годовой оборот", labWork::setAnnualTurnover, Double::valueOf));
//        while(!Insert.input("координата по Х", coordinates::setX, Integer::valueOf));;
//        while(!Insert.input("координата по Y", coordinates::setY, Double::valueOf));;
//        labWork.setCoordinates(coordinates);
//        while(!Insert.input("Индекс", address::setZipCode, String::valueOf));;
//        labWork.setPostalAddress(address);
//        if (labWork.compareTo(getCollectionManager().getOrgCollection().get(key)) > 0){
//            getCollectionManager().addElement(
//                    key, labWork, getCollectionManager().getOrgCollection().get(key).getId());
//            Consoll.printSmt("Успешно обновлено");
//        }
//        else {Consoll.printSmt("Значение меньше");}
    }
}
