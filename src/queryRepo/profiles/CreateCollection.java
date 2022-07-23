package queryRepo.profiles;

import Models.Collections;
import Models.DataBase;
import Repository.DataRepo;
import org.json.JSONException;
import org.json.JSONObject;
import queryRepo.QueryType;

public class CreateCollection extends QueryType {

    String collectionName = null;
    String dbName = null;

    @Override
    public String getType() {
        return "CREATE_COLLECTION";
    }

    @Override
    public boolean isMatch(JSONObject cmd) {
        try {
            String element = cmd.getString("create");

            if(element.equalsIgnoreCase("COLLECTION")) {
                collectionName = cmd.getString("name");
                dbName = cmd.getString("dB");
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

        try {
            if (repo.getDb(dbName) == null) {
                System.out.println("dB doesn't Exists... Operation Failed !!!");
                return false;
            }

            DataBase db = repo.getDb(dbName);
            Collections collections = new Collections(collectionName);
            db.addCollection(collections);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
