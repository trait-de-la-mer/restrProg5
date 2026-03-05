package Main.Commands;

import Main.Utils.CollectionManager;

public abstract class Command{
    private String name = "";
    private final CollectionManager cm;

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    private String info = "Какая-то команда, возможно ей еще не прописали инфу о действии (или забыли)";

    public Command(CollectionManager cm){
        this.cm = cm;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CollectionManager getCollectionManager() {
        return cm;
    }

    public String getName() {
        return name;
    }

    public abstract void execute(String args);
}
