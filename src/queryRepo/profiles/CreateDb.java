package queryRepo.profiles;

import Models.DataBase;
import Repository.DataRepo;
import org.json.JSONException;
import org.json.JSONObject;
import queryRepo.QueryType;

public class CreateDb extends QueryType {

    String dbName = null;

    @Override
    public String getType() {
        return "CREATE_DB";
    }

    @Override
    public boolean isMatch(JSONObject cmd) {

        try {
            String element = cmd.getString("create");

            if(element.equalsIgnoreCase("DB")) {
                dbName = cmd.getString("name");
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
        if(repo.getDb(dbName) != null) {
            System.out.println("dB Already Exists... Operation Failed !!!");
            return false;
        }
        DataBase db = new DataBase(dbName);
        return repo.addDb(db);
    }
}
