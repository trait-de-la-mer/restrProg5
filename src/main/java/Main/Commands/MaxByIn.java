package Main.Commands;

import Main.Utils.CollectionManager;
import Main.Utils.Consoll;

public class MaxByIn extends Command{
    {setName("max");
    setInfo("выдает оргу с макс id");}
    public MaxByIn(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args){
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        for (Integer key : getCollectionManager().getOrgCollection().keySet()){
            if (getCollectionManager().getOrgCollection().get(key).getId() == getCollectionManager().getLastId()){
                Consoll.printSmt(key + " - " + getCollectionManager().getOrgCollection().get(key).toString());
            }
        }
    }
}
