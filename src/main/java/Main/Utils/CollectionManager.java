package Main.Utils;

import Main.Collection.LabWork;

import java.time.ZonedDateTime;
import java.util.HashMap;

public class CollectionManager {
    private long lastId = 0;
    private HashMap<Integer, LabWork> orgCollection = new HashMap<>();
    private final ZonedDateTime creationDate = ZonedDateTime.now();

    public void setLastId(long lastId) {
        this.lastId = lastId;
    }

    public long getLastId() {
        return lastId;
    }

    public ZonedDateTime getCreationDate() {
        return creationDate;
    }

    public void setLabCollection(HashMap<Integer, LabWork> orgCollection) {
        this.orgCollection = orgCollection;
    }

    public void removeElement(Integer key){
        orgCollection.remove(key);
    }

    public void addElement(Integer key, LabWork org){
        orgCollection.put(key, org);
    }

    public void addElement(Integer key, LabWork org, Long id){
        orgCollection.put(key, org);
        orgCollection.get(key).setId(id);
    }

    public void clearCollection(){
        orgCollection.clear();
    }

    public String getCollectionType() {
        return orgCollection.getClass().getName();
    }

    public int getCollectionSyze(){return orgCollection.size();}

    public HashMap<Integer, LabWork> getOrgCollection() {
        return orgCollection;
    }

    public Long generateId(){
        return ++lastId;
    }

    public void printCol(){
        System.out.println(orgCollection);
    }
}
