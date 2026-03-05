package Main.Commands;

import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

public class RemoveAllByAnnualTurnover extends Command{
    {setName("remove_by_turnover");
    setInfo("удаляет все орги с годовым оборотом эквивалетными заданному");}
    public RemoveAllByAnnualTurnover(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        double annualTurnover;
        try{
            annualTurnover = Double.parseDouble(args);
        } catch (NumberFormatException e) {
            throw new RuntimeException("аргумент должен быть Long");
        }
        for (Integer key : getCollectionManager().getOrgCollection().keySet()){
            if (getCollectionManager().getOrgCollection().get(key).getAnnualTurnover() == annualTurnover){
                Remove remove = new Remove(getCollectionManager());
                remove.execute(String.valueOf(key));
                Consoll.printSmt("Удалена орга с ключом: " + key);
            }
        }

    }
}
