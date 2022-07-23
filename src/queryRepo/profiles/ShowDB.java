package queryRepo.profiles;

import Repository.DataRepo;
import org.json.JSONException;
import org.json.JSONObject;
import queryRepo.QueryType;

import java.util.Set;

public class ShowDB extends QueryType {
    @Override
    public String getType() {
        return "SHOW_DB";
    }

    @Override
    public boolean isMatch(JSONObject cmd) {

        try {
            String element = cmd.getString("getAll");

            if(element.equalsIgnoreCase("DB")) {
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
            Set<String> dbs = repo.getDbList();

            for (String s : dbs) {
                System.out.println(s);
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
