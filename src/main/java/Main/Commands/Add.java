package Main.Commands;

import Main.Collection.*;
import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;

public class Add extends Command {
    {setName("add");
        setInfo("добавляет новый элемент");}

    public Add(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String parametr) {
        if (parametr == null || parametr.isBlank()) throw new IllegalArgumentException("Неправильный ключ!");
        if (getCollectionManager().getOrgCollection().containsKey(parametr))
            throw new IllegalArgumentException("Элемент с таким ключом уже есть!");
        Integer key;
        try {
            key = Integer.valueOf(parametr);
        } catch (NumberFormatException e){throw new IllegalArgumentException("ключ должен быть int!");}
        LabWork labWork = new LabWork();
        Coordinates coordinates = new Coordinates();
        Person person = new Person();
        labWork.setId(getCollectionManager().generateId());
        labWork.setCreationDate(LocalDate.now());
        while(!input("сложность: " + Arrays.toString(Difficulty.values()), labWork::setDifficulty, Difficulty::fromString));
        while(!input("имя лабы", labWork::setName, String::valueOf));
        while(!input("минимальное кол-во баллов", labWork::setMinimalPoint, Double::valueOf));
        while(!input("координата по Х", coordinates::setX, Long::valueOf));
        while(!input("координата по Y", coordinates::setY, Integer::valueOf));
        labWork.setCoordinates(coordinates);
        while(!input("ваш вес", person::setWeight, Double::valueOf));
        while(!input("ваше имя", person::setName, String::valueOf));
        while(!input("цвет глаз: " + Arrays.toString(Color.values()), person::setEyeColor, Color::fromString));
        labWork.setAuthor(person);
        getCollectionManager().addElement(key, labWork);
        Consoll.printSmt("Успешно добавлен!");
    }

    protected static <T> boolean input(String fieldName, Consumer<T> setter, Function<String, T> intoValue) {
        try {
            String line = Consoll.askSmt(fieldName);
            setter.accept(intoValue.apply(line));
            return true;
        } catch (NumberFormatException exep) {
            System.out.println("Проверь пральность ввода!");
            return false;
        }
        catch (IllegalArgumentException exp){
            Consoll.printSmt(exp.getMessage());
            return false;
        } catch (Exception ex) {
            return false;
        }
    }
}
