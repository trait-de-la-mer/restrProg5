package Main;

import Main.Commands.*;
import Main.Utils.CollectionManager;
import Main.Utils.CommandMannager;
import Main.Utils.Consoll;
import Main.Utils.JParser;


public class Main
{

    public static void main(String[] args){
       CollectionManager collectionManager = new CollectionManager();
        JParser jParser = new JParser(collectionManager);
        collectionManager.setLabCollection(jParser.parse("ewq.json"));

        CommandMannager cm = new CommandMannager(
                new CountLessMin(collectionManager),
                new RemoveFirst(collectionManager),
                new ExecuteScript(collectionManager),
                new Clear(collectionManager),
                new Add(collectionManager),
                new Exit(collectionManager),
                new Help(collectionManager),
                new Info(collectionManager),
                new Show(collectionManager),
                new Update(collectionManager),
                new Remove(collectionManager),
                new Save(collectionManager)
        );
        Consoll console = new Consoll(cm);
        console.startConsole();
    }
}