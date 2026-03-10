package Main.Commands;

import Main.Utils.CollectionManager;
import Main.Utils.JParser;

public class Save extends Command{
    {setName("save");
    setInfo("сохранить коллекцию в файли из которого она была загружен");}
    public Save(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String args) {
        if (args != null && !args.isEmpty()) throw new IllegalArgumentException(
                "В команде " + getName() + " не может быть аргументов!");
        JParser jParser = new JParser(getCollectionManager());
        jParser.convertToJson(getCollectionManager().getLabCollection());
    }
}
