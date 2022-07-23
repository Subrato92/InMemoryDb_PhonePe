package operations.conditional;

import org.json.JSONObject;

public class EqualsTo extends Conditions{

    public EqualsTo(JSONObject clause) {
        super(clause);
        pattern = "$eq";
    }

    @Override
    public boolean validate(JSONObject doc) {
        try {
            Object docValue = doc.get(field);
            if (docValue instanceof String) {
                return ((String)docValue).equals((String)value);
            }else if(docValue instanceof Integer){
                return ((Integer)docValue) == ((Integer)value);
            }else if(docValue instanceof Double){
                return ((Double)docValue) == ((Double)value);
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }

    @Override
    public String getConditionType() {
        return "EQUALS_TO";
    }
}
