package operations.conditional;

import org.json.JSONObject;

public class GreaterThan extends Conditions{
    public GreaterThan(JSONObject clause) {
        super(clause);
        pattern = "$gt";
    }

    @Override
    public boolean validate(JSONObject doc) {
        try {
            Object docValue = doc.get(field);
            if (docValue instanceof String) {
                return ((String)docValue).compareTo((String)value) > 0;
            }else if(docValue instanceof Integer){
                return ((Integer)docValue) > ((Integer)value);
            }else if(docValue instanceof Double){
                return ((Double)docValue) > ((Double)value);
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }

    @Override
    public String getConditionType() {
        return "GREATER_THAN";
    }
}
