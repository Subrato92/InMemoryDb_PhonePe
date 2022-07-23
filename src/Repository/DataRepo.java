package Repository;

import Models.DataBase;

import java.util.HashMap;
import java.util.Set;

public enum DataRepo {
    INSTANCE;

    private HashMap<String, DataBase> dataBaseList = new HashMap<>();

    public boolean addDb(DataBase db){
        try {
            if(dataBaseList==null)
                dataBaseList = new HashMap<>();

            dataBaseList.put(db.getName(), db);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public DataBase getDb(String name){
        if(dataBaseList.containsKey(name))
            return dataBaseList.get(name);

        return null;
    }

    public Set<String> getDbList(){
        return dataBaseList.keySet();
    }

}
