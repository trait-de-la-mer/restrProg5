package Main.Commands;

import Main.Utils.CollectionManager;

public class Exit extends Command{
    {setName("exit");
        setInfo("выходит из программы");}
    public Exit(CollectionManager cm) {
        super(cm);
    }

    @Override
    public void execute(String parametr) {
        System.exit(0);
    }
}
