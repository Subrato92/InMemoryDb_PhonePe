package queryRepo.profiles;

import Models.Collections;
import Models.DataBase;
import Repository.DataRepo;
import org.json.JSONException;
import org.json.JSONObject;
import queryRepo.QueryType;

import java.util.List;

public class GetAllDocs extends QueryType {
    JSONObject query = null;
    String dbName = null;
    String collectionName = null;

    @Override
    public String getType() {
        return "SEARCH_ALL_DOCS";
    }

    @Override
    public boolean isMatch(JSONObject cmd) {
        try {
            query = cmd.getJSONObject("query");

            if(query.getString("*").equalsIgnoreCase("*")) {
                dbName = cmd.getString("dB");
                collectionName = cmd.getString("collection");
                return true;
            }
        } catch (JSONException e) {
            //e.printStackTrace();
            return false;
        }

        return false;
    }

    @Override
    public boolean execute(DataRepo repo) {
        try{
            DataBase db = repo.getDb(dbName);
            if(db == null){
                System.out.println("[ERROR] DB Doesn't Exists ...");
                return false;
            }
            Collections collections = db.getCollection(collectionName);
            if(collections == null){
                System.out.println("[ERROR] Collections Doesn't Exists ...");
                return false;
            }

            List<JSONObject> docList = collections.getAllDocs();
            for(JSONObject doc : docList){
                System.out.println(doc.toString());
            }

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
