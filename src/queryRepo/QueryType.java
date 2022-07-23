package queryRepo;

import Repository.DataRepo;
import org.json.JSONObject;

public abstract class QueryType {
    public abstract String getType();
    public abstract boolean isMatch(JSONObject cmd);
    public abstract boolean execute(DataRepo repo);
}
