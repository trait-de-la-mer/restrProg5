package Main.Commands;

import Main.Collection.Address;
import Main.Collection.Coordinates;
import Main.Collection.Organization;
import Main.Collection.OrganizationType;
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
        Organization organization = new Organization();
        Address address = new Address();
        Coordinates coordinates = new Coordinates();
        organization.setCreationDate(LocalDate.now());
        organization.setId(getCollectionManager().getOrgCollection().get(key).getId());
        while(!Insert.input(Arrays.toString(OrganizationType.values()), organization::setType, OrganizationType::fromString));
        while(!Insert.input("имя", organization::setName, String::valueOf));
        while(!Insert.input("полное имя", organization::setFullName, String::valueOf));
        while(!Insert.input("годовой оборот", organization::setAnnualTurnover, Double::valueOf));
        while(!Insert.input("координата по Х", coordinates::setX, Integer::valueOf));;
        while(!Insert.input("координата по Y", coordinates::setY, Double::valueOf));;
        organization.setCoordinates(coordinates);
        while(!Insert.input("Индекс", address::setZipCode, String::valueOf));;
        organization.setPostalAddress(address);
        if (organization.compareTo(getCollectionManager().getOrgCollection().get(key)) > 0){
            getCollectionManager().addElement(
                    key, organization, getCollectionManager().getOrgCollection().get(key).getId());
            Consoll.printSmt("Успешно обновлено");
        }
        else {Consoll.printSmt("Значение меньше");}
    }
}
