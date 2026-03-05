package Main.Commands;

import Main.Collection.Address;
import Main.Collection.Coordinates;
import Main.Collection.Organization;
import Main.Collection.OrganizationType;
import Main.Utils.CollectionManager;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Update extends Command{
    {setName("update");
    setInfo("Обновляет элемент по заданному id");}
    public Update(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        Long id;
        try{
            id = Long.valueOf(args);
        } catch (NumberFormatException e) {
            throw new RuntimeException("аргумент должен быть Long");
        }
        for (Integer key : getCollectionManager().getOrgCollection().keySet()){
            if (Objects.equals(getCollectionManager().getOrgCollection().get(key).getId(), id)){
                Organization organization = new Organization();
                Address address = new Address();
                Coordinates coordinates = new Coordinates();
                organization.setCreationDate(LocalDate.now());
                while(!Insert.input(Arrays.toString(OrganizationType.values()), organization::setType, OrganizationType::fromString));
                while(!Insert.input("имя", organization::setName, String::valueOf));
                while(!Insert.input("полное имя", organization::setFullName, String::valueOf));
                while(!Insert.input("годовой оборот", organization::setAnnualTurnover, Double::valueOf));
                while(!Insert.input("координата по Х", coordinates::setX, Integer::valueOf));;
                while(!Insert.input("координата по Y", coordinates::setY, Double::valueOf));;
                organization.setCoordinates(coordinates);
                while(!Insert.input("Индекс", address::setZipCode, String::valueOf));;
                organization.setPostalAddress(address);
                getCollectionManager().addElement(key, organization, id);
                break;
            }
        }
    }
}
