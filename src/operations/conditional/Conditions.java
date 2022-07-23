package operations.conditional;

import org.json.JSONObject;

public abstract class Conditions {
    protected String field = null;
    protected Object value = null;
    protected String pattern = null;

    public Conditions(JSONObject clause){
        try {
            this.field = clause.getString("field");
            this.value = clause.get("value");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public abstract boolean validate(JSONObject doc);
    public abstract String getConditionType();

    public String getPattern(){
        return pattern;
    }

}
