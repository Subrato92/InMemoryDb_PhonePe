package operations.compositional;

import org.json.JSONObject;

public interface Operator {

    public boolean operate(JSONObject doc);
    public String getOperationType();

}
