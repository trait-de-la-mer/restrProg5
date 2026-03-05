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
    public void execute(String file) {
        JParser jParser = new JParser(getCollectionManager());
        jParser.convertToJson(getCollectionManager().getOrgCollection(), file);
    }
}
