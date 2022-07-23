package Models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Collections {
    private String name = null;
    private List<JSONObject> docs = null;

    public Collections(String name){
        this.name = name;
        docs = new ArrayList<>();
    }

    public synchronized boolean addDoc(JSONObject doc) throws JSONException {
        try {
            docs.add(doc);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public String getName(){
        return name;
    }

    public List<JSONObject> getAllDocs(){
        return docs;
    }

}
