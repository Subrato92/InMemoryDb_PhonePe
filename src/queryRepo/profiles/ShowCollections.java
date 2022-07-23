package queryRepo.profiles;

import Models.DataBase;
import Repository.DataRepo;
import org.json.JSONException;
import org.json.JSONObject;
import queryRepo.QueryType;

import java.util.Set;

public class ShowCollections extends QueryType {
    private String dbName = null;

    @Override
    public String getType() {
        return "SHOW_COLLECTIONS";
    }

    @Override
    public boolean isMatch(JSONObject cmd) {
        try {
            String element = cmd.getString("getAll");

            if(element.equalsIgnoreCase("COLLECTIONS")) {
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
            DataBase db = repo.getDb(dbName);

            if(db == null){
                System.out.println("[ERROR] DB Doesn't Exists ...");
                return false;
            }

            Set<String> collectionNames = db.getCollectionList();

            for (String collections : collectionNames) {
                System.out.println(collections);
            }
        }catch(Exception e){
            //e.printStackTrace();
            return false;
        }

        return true;
    }
}
