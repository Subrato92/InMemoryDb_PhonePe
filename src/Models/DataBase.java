package Models;

import java.util.HashMap;
import java.util.Set;

public class DataBase {
    private String name = null;
    private HashMap<String, Collections> collectionList = null;

    public DataBase(String name){
        this.name = name;
        collectionList = new HashMap<>();
    }

    public synchronized boolean addCollection(Collections collections){
        try{
            collectionList.put(collections.getName(), collections);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getName(){
        return name;
    }

    public Set<String> getCollectionList(){
        return collectionList.keySet();
    }

    public boolean containsCollection(String name){
        if(collectionList.containsKey(name))
            return true;
        return false;
    }

    public Collections getCollection(String name){
        if(containsCollection(name))
            return collectionList.get(name);

        return null;
    }

}
