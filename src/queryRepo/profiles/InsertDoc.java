package queryRepo.profiles;

import Models.Collections;
import Models.DataBase;
import Repository.DataRepo;
import org.json.JSONException;
import org.json.JSONObject;
import queryRepo.QueryType;

public class InsertDoc extends QueryType {

    String dbName = null;
    String collectionName = null;
    JSONObject doc = null;

    @Override
    public String getType() {
        return "INSERT_DOC";
    }

    @Override
    public boolean isMatch(JSONObject cmd) {
        try {
            String element = cmd.getString("create");

            if(element.equalsIgnoreCase("DOC")) {
                dbName = cmd.getString("dB");
                collectionName = cmd.getString("collection");
                doc = cmd.getJSONObject("doc");
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
                System.out.println("[ERROR] Db Doesn't exists");
                return false;
            }
            Collections collections = db.getCollection(collectionName);
            if(collections == null){
                System.out.println("[ERROR] Collection Doesn't exists");
                return false;
            }

            return collections.addDoc(doc);

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
